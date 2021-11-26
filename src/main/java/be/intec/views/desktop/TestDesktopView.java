package be.intec.views.desktop;


import be.intec.models.binders.TestBinder;
import be.intec.models.entities.TestEntity;
import be.intec.repositories.TestRepository;
import be.intec.services.exceptions.TestException;
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

public class TestDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< TestBinder > table = new TableView<>();
	private final ObservableList< TestBinder > data = FXCollections.observableArrayList();
	private final TestRepository repository = new TestRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "Test Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "Test Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< TestBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "code" );
		column1.setCellValueFactory(
				new PropertyValueFactory< TestBinder, String >( "code" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< TestBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setCode( t.getNewValue() );
				}
		);
		TableColumn column2 = new TableColumn( "duration" );
		column2.setCellValueFactory(
				new PropertyValueFactory< TestBinder, Integer >( "duration" ) );
		column2.setEditable( true );
		column2.setOnEditCommit( ( EventHandler< CellEditEvent< TestBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setDuration( t.getNewValue() );
				}
		);
		TableColumn column3 = new TableColumn( "maxScore" );
		column3.setCellValueFactory(
				new PropertyValueFactory< TestBinder, Integer >( "maxScore" ) );
		column3.setEditable( true );
		column3.setOnEditCommit( ( EventHandler< CellEditEvent< TestBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setMaxScore( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1, column2, column3 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "code" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );
		final TextField column2EditField = new TextField();
		column2EditField.setPromptText( "duration" );
		column2EditField.setMaxWidth( column2.getPrefWidth() );
		final TextField column3EditField = new TextField();
		column3EditField.setPromptText( "maxScore" );
		column3EditField.setMaxWidth( column3.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new TestEntity()
								.withParsedCode( column1EditField.getText() )
								.withParsedDuration( column2EditField.getText() )
								.withParsedMaxScore( column3EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< TestEntity > itemList = repository.findAll();

					for ( TestEntity item : itemList ) {
						data.add( new TestBinder(
								item.getId(),
								item.getCode(),
								item.getDuration(),
								item.getMaxScore()
						) );
					}

					table.setItems( data );

					message.setText( "New records from Test are created and to the list." );
					column1EditField.clear();
					column2EditField.clear();
					column3EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "Test created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: Test could NOT be created!" );
				}
			} catch ( TestException testException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( testException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< TestEntity > itemList = repository.findAll();

			for ( TestEntity item : itemList ) {
				data.add( new TestBinder(
						item.getId(),
						item.getCode(),
						item.getDuration(),
						item.getMaxScore()
				) );
			}

			table.setItems( data );

			message.setText( "Test records are refreshed" );

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

