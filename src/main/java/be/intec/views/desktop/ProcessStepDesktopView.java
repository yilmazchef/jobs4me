package be.intec.views.desktop;


import be.intec.models.binders.ProcessStepBinder;
import be.intec.models.entities.ProcessStepEntity;
import be.intec.repositories.ProcessStepRepository;
import be.intec.services.exceptions.ProcessStepException;
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

public class ProcessStepDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< ProcessStepBinder > table = new TableView<>();
	private final ObservableList< ProcessStepBinder > data = FXCollections.observableArrayList();
	private final ProcessStepRepository repository = new ProcessStepRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "ProcessStep Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "ProcessStep Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< ProcessStepBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "stepId" );
		column1.setCellValueFactory(
				new PropertyValueFactory< ProcessStepBinder, Integer >( "stepId" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< ProcessStepBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setStepId( t.getNewValue() );
				}
		);
		TableColumn column2 = new TableColumn( "processId" );
		column2.setCellValueFactory(
				new PropertyValueFactory< ProcessStepBinder, Integer >( "processId" ) );
		column2.setEditable( true );
		column2.setOnEditCommit( ( EventHandler< CellEditEvent< ProcessStepBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setProcessId( t.getNewValue() );
				}
		);
		TableColumn column3 = new TableColumn( "status" );
		column3.setCellValueFactory(
				new PropertyValueFactory< ProcessStepBinder, String >( "status" ) );
		column3.setEditable( true );
		column3.setOnEditCommit( ( EventHandler< CellEditEvent< ProcessStepBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setStatus( t.getNewValue() );
				}
		);
		TableColumn column4 = new TableColumn( "priority" );
		column4.setCellValueFactory(
				new PropertyValueFactory< ProcessStepBinder, Integer >( "priority" ) );
		column4.setEditable( true );
		column4.setOnEditCommit( ( EventHandler< CellEditEvent< ProcessStepBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setPriority( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1, column2, column3, column4 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "stepId" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );
		final TextField column2EditField = new TextField();
		column2EditField.setPromptText( "processId" );
		column2EditField.setMaxWidth( column2.getPrefWidth() );
		final TextField column3EditField = new TextField();
		column3EditField.setPromptText( "status" );
		column3EditField.setMaxWidth( column3.getPrefWidth() );
		final TextField column4EditField = new TextField();
		column4EditField.setPromptText( "priority" );
		column4EditField.setMaxWidth( column4.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new ProcessStepEntity()
								.withParsedStepId( column1EditField.getText() )
								.withParsedProcessId( column2EditField.getText() )
								.withParsedStatus( column3EditField.getText() )
								.withParsedPriority( column4EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< ProcessStepEntity > itemList = repository.findAll();

					for ( ProcessStepEntity item : itemList ) {
						data.add( new ProcessStepBinder(
								item.getId(),
								item.getStepId(),
								item.getProcessId(),
								item.getStatus(),
								item.getPriority()
						) );
					}

					table.setItems( data );

					message.setText( "New records from ProcessStep are created and to the list." );
					column1EditField.clear();
					column2EditField.clear();
					column3EditField.clear();
					column4EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "ProcessStep created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: ProcessStep could NOT be created!" );
				}
			} catch ( ProcessStepException processstepException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( processstepException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< ProcessStepEntity > itemList = repository.findAll();

			for ( ProcessStepEntity item : itemList ) {
				data.add( new ProcessStepBinder(
						item.getId(),
						item.getStepId(),
						item.getProcessId(),
						item.getStatus(),
						item.getPriority()
				) );
			}

			table.setItems( data );

			message.setText( "ProcessStep records are refreshed" );

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

