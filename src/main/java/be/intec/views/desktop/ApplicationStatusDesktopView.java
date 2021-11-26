package be.intec.views.desktop;


import be.intec.models.binders.ApplicationStatusBinder;
import be.intec.models.entities.ApplicationStatusEntity;
import be.intec.repositories.ApplicationStatusRepository;
import be.intec.services.exceptions.ApplicationStatusException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class ApplicationStatusDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< ApplicationStatusBinder > table = new TableView<>();
	private final ObservableList< ApplicationStatusBinder > data = FXCollections.observableArrayList();
	private final ApplicationStatusRepository repository = new ApplicationStatusRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "ApplicationStatus Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "ApplicationStatus Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< ApplicationStatusBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "status" );
		column1.setCellValueFactory(
				new PropertyValueFactory< ApplicationStatusBinder, String >( "status" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationStatusBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setStatus( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "status" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new ApplicationStatusEntity()
								.withParsedStatus( column1EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< ApplicationStatusEntity > itemList = repository.findAll();

					for ( ApplicationStatusEntity item : itemList ) {
						data.add( new ApplicationStatusBinder(
								item.getId(),
								item.getStatus()
						) );
					}

					table.setItems( data );

					message.setText( "New records from ApplicationStatus are created and to the list." );
					column1EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "ApplicationStatus created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: ApplicationStatus could NOT be created!" );
				}
			} catch ( ApplicationStatusException applicationstatusException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( applicationstatusException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< ApplicationStatusEntity > itemList = repository.findAll();

			for ( ApplicationStatusEntity item : itemList ) {
				data.add( new ApplicationStatusBinder(
						item.getId(),
						item.getStatus()
				) );
			}

			table.setItems( data );

			message.setText( "ApplicationStatus records are refreshed" );

		} );

		final Button backButton = new Button( "Back" );
		backButton.setOnAction( onClick -> {
			scene.getWindow().hide();
			new MainMenuDesktopView().start( stage );
		} );

		navBox.getChildren().addAll( backButton );
		navBox.setSpacing( 3 );

		actBox.getChildren().addAll( column1EditField, addButton, viewButton );
		actBox.setSpacing( 3 );

		final VBox vbox = new VBox();
		vbox.setSpacing( 5 );
		vbox.setPadding( new Insets( 10, 0, 0, 10 ) );
		vbox.getChildren().addAll( header, table, actBox, navBox, message );

		( ( Group ) scene.getRoot() ).getChildren().addAll( vbox );

		stage.setScene( scene );

		stage.show();
	}

}

