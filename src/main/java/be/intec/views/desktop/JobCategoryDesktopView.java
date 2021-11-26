package be.intec.views.desktop;


import be.intec.models.binders.JobCategoryBinder;
import be.intec.models.entities.JobCategoryEntity;
import be.intec.repositories.JobCategoryRepository;
import be.intec.services.exceptions.JobCategoryException;
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

public class JobCategoryDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< JobCategoryBinder > table = new TableView<>();
	private final ObservableList< JobCategoryBinder > data = FXCollections.observableArrayList();
	private final JobCategoryRepository repository = new JobCategoryRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "JobCategory Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "JobCategory Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< JobCategoryBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "code" );
		column1.setCellValueFactory(
				new PropertyValueFactory< JobCategoryBinder, String >( "code" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< JobCategoryBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setCode( t.getNewValue() );
				}
		);
		TableColumn column2 = new TableColumn( "name" );
		column2.setCellValueFactory(
				new PropertyValueFactory< JobCategoryBinder, String >( "name" ) );
		column2.setEditable( true );
		column2.setOnEditCommit( ( EventHandler< CellEditEvent< JobCategoryBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setName( t.getNewValue() );
				}
		);
		TableColumn column3 = new TableColumn( "description" );
		column3.setCellValueFactory(
				new PropertyValueFactory< JobCategoryBinder, String >( "description" ) );
		column3.setEditable( true );
		column3.setOnEditCommit( ( EventHandler< CellEditEvent< JobCategoryBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setDescription( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1, column2, column3 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "code" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );
		final TextField column2EditField = new TextField();
		column2EditField.setPromptText( "name" );
		column2EditField.setMaxWidth( column2.getPrefWidth() );
		final TextField column3EditField = new TextField();
		column3EditField.setPromptText( "description" );
		column3EditField.setMaxWidth( column3.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new JobCategoryEntity()
								.withParsedCode( column1EditField.getText() )
								.withParsedName( column2EditField.getText() )
								.withParsedDescription( column3EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< JobCategoryEntity > itemList = repository.findAll();

					for ( JobCategoryEntity item : itemList ) {
						data.add( new JobCategoryBinder(
								item.getId(),
								item.getCode(),
								item.getName(),
								item.getDescription()
						) );
					}

					table.setItems( data );

					message.setText( "New records from JobCategory are created and to the list." );
					column1EditField.clear();
					column2EditField.clear();
					column3EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "JobCategory created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: JobCategory could NOT be created!" );
				}
			} catch ( JobCategoryException jobcategoryException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( jobcategoryException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< JobCategoryEntity > itemList = repository.findAll();

			for ( JobCategoryEntity item : itemList ) {
				data.add( new JobCategoryBinder(
						item.getId(),
						item.getCode(),
						item.getName(),
						item.getDescription()
				) );
			}

			table.setItems( data );

			message.setText( "JobCategory records are refreshed" );

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

