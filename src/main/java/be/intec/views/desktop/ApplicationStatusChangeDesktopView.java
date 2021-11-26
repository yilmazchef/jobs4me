package be.intec.views.desktop;


import be.intec.models.binders.ApplicationStatusChangeBinder;
import be.intec.models.entities.ApplicationStatusChangeEntity;
import be.intec.repositories.ApplicationStatusChangeRepository;
import be.intec.services.exceptions.ApplicationStatusChangeException;
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

public class ApplicationStatusChangeDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< ApplicationStatusChangeBinder > table = new TableView<>();
	private final ObservableList< ApplicationStatusChangeBinder > data = FXCollections.observableArrayList();
	private final ApplicationStatusChangeRepository repository = new ApplicationStatusChangeRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "ApplicationStatusChange Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "ApplicationStatusChange Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< ApplicationStatusChangeBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "dateChanged" );
		column1.setCellValueFactory(
				new PropertyValueFactory< ApplicationStatusChangeBinder, java.sql.Timestamp >( "dateChanged" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationStatusChangeBinder, java.sql.Timestamp > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setDateChanged( t.getNewValue() );
				}
		);
		TableColumn column2 = new TableColumn( "applicationStatusId" );
		column2.setCellValueFactory(
				new PropertyValueFactory< ApplicationStatusChangeBinder, Integer >( "applicationStatusId" ) );
		column2.setEditable( true );
		column2.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationStatusChangeBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setApplicationStatusId( t.getNewValue() );
				}
		);
		TableColumn column3 = new TableColumn( "applicationId" );
		column3.setCellValueFactory(
				new PropertyValueFactory< ApplicationStatusChangeBinder, Integer >( "applicationId" ) );
		column3.setEditable( true );
		column3.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationStatusChangeBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setApplicationId( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1, column2, column3 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "dateChanged" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );
		final TextField column2EditField = new TextField();
		column2EditField.setPromptText( "applicationStatusId" );
		column2EditField.setMaxWidth( column2.getPrefWidth() );
		final TextField column3EditField = new TextField();
		column3EditField.setPromptText( "applicationId" );
		column3EditField.setMaxWidth( column3.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new ApplicationStatusChangeEntity()
								.withParsedDateChanged( column1EditField.getText() )
								.withParsedApplicationStatusId( column2EditField.getText() )
								.withParsedApplicationId( column3EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< ApplicationStatusChangeEntity > itemList = repository.findAll();

					for ( ApplicationStatusChangeEntity item : itemList ) {
						data.add( new ApplicationStatusChangeBinder(
								item.getId(),
								item.getDateChanged(),
								item.getApplicationStatusId(),
								item.getApplicationId()
						) );
					}

					table.setItems( data );

					message.setText( "New records from ApplicationStatusChange are created and to the list." );
					column1EditField.clear();
					column2EditField.clear();
					column3EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "ApplicationStatusChange created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: ApplicationStatusChange could NOT be created!" );
				}
			} catch ( ApplicationStatusChangeException applicationstatuschangeException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( applicationstatuschangeException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< ApplicationStatusChangeEntity > itemList = repository.findAll();

			for ( ApplicationStatusChangeEntity item : itemList ) {
				data.add( new ApplicationStatusChangeBinder(
						item.getId(),
						item.getDateChanged(),
						item.getApplicationStatusId(),
						item.getApplicationId()
				) );
			}

			table.setItems( data );

			message.setText( "ApplicationStatusChange records are refreshed" );

		} );

		final Button backButton = new Button( "Back" );
		backButton.setOnAction( onClick -> {
			scene.getWindow().hide();
			new MainMenuDesktopView().start( stage );
		} );

		navBox.getChildren().addAll( backButton );
		navBox.setSpacing( 3 );

		actBox.getChildren().addAll( column1EditField, column2EditField, column3EditField, addButton, viewButton );
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

