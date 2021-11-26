package be.intec.views.desktop;


import be.intec.models.binders.ApplicationTestBinder;
import be.intec.models.entities.ApplicationTestEntity;
import be.intec.repositories.ApplicationTestRepository;
import be.intec.services.exceptions.ApplicationTestException;
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

public class ApplicationTestDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< ApplicationTestBinder > table = new TableView<>();
	private final ObservableList< ApplicationTestBinder > data = FXCollections.observableArrayList();
	private final ApplicationTestRepository repository = new ApplicationTestRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "ApplicationTest Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "ApplicationTest Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< ApplicationTestBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "testId" );
		column1.setCellValueFactory(
				new PropertyValueFactory< ApplicationTestBinder, Integer >( "testId" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationTestBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setTestId( t.getNewValue() );
				}
		);
		TableColumn column2 = new TableColumn( "applicationId" );
		column2.setCellValueFactory(
				new PropertyValueFactory< ApplicationTestBinder, Integer >( "applicationId" ) );
		column2.setEditable( true );
		column2.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationTestBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setApplicationId( t.getNewValue() );
				}
		);
		TableColumn column3 = new TableColumn( "startTime" );
		column3.setCellValueFactory(
				new PropertyValueFactory< ApplicationTestBinder, java.sql.Timestamp >( "startTime" ) );
		column3.setEditable( true );
		column3.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationTestBinder, java.sql.Timestamp > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setStartTime( t.getNewValue() );
				}
		);
		TableColumn column4 = new TableColumn( "endTime" );
		column4.setCellValueFactory(
				new PropertyValueFactory< ApplicationTestBinder, java.sql.Timestamp >( "endTime" ) );
		column4.setEditable( true );
		column4.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationTestBinder, java.sql.Timestamp > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setEndTime( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1, column2, column3, column4 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "testId" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );
		final TextField column2EditField = new TextField();
		column2EditField.setPromptText( "applicationId" );
		column2EditField.setMaxWidth( column2.getPrefWidth() );
		final TextField column3EditField = new TextField();
		column3EditField.setPromptText( "startTime" );
		column3EditField.setMaxWidth( column3.getPrefWidth() );
		final TextField column4EditField = new TextField();
		column4EditField.setPromptText( "endTime" );
		column4EditField.setMaxWidth( column4.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new ApplicationTestEntity()
								.withParsedTestId( column1EditField.getText() )
								.withParsedApplicationId( column2EditField.getText() )
								.withParsedStartTime( column3EditField.getText() )
								.withParsedEndTime( column4EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< ApplicationTestEntity > itemList = repository.findAll();

					for ( ApplicationTestEntity item : itemList ) {
						data.add( new ApplicationTestBinder(
								item.getId(),
								item.getTestId(),
								item.getApplicationId(),
								item.getStartTime(),
								item.getEndTime()
						) );
					}

					table.setItems( data );

					message.setText( "New records from ApplicationTest are created and to the list." );
					column1EditField.clear();
					column2EditField.clear();
					column3EditField.clear();
					column4EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "ApplicationTest created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: ApplicationTest could NOT be created!" );
				}
			} catch ( ApplicationTestException applicationtestException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( applicationtestException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< ApplicationTestEntity > itemList = repository.findAll();

			for ( ApplicationTestEntity item : itemList ) {
				data.add( new ApplicationTestBinder(
						item.getId(),
						item.getTestId(),
						item.getApplicationId(),
						item.getStartTime(),
						item.getEndTime()
				) );
			}

			table.setItems( data );

			message.setText( "ApplicationTest records are refreshed" );

		} );

		final Button backButton = new Button( "Back" );
		backButton.setOnAction( onClick -> {
			scene.getWindow().hide();
			new MainMenuDesktopView().start( stage );
		} );

		navBox.getChildren().addAll( backButton );
		navBox.setSpacing( 3 );

		actBox.getChildren().addAll( column1EditField, column2EditField, column3EditField, column4EditField, addButton, viewButton );
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

