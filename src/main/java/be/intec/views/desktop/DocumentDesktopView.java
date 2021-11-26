package be.intec.views.desktop;


import be.intec.models.binders.DocumentBinder;
import be.intec.models.entities.DocumentEntity;
import be.intec.repositories.DocumentRepository;
import be.intec.services.exceptions.DocumentException;
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

public class DocumentDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< DocumentBinder > table = new TableView<>();
	private final ObservableList< DocumentBinder > data = FXCollections.observableArrayList();
	private final DocumentRepository repository = new DocumentRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "Document Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "Document Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< DocumentBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "name" );
		column1.setCellValueFactory(
				new PropertyValueFactory< DocumentBinder, String >( "name" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< DocumentBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setName( t.getNewValue() );
				}
		);
		TableColumn column2 = new TableColumn( "rawData" );
		column2.setCellValueFactory(
				new PropertyValueFactory< DocumentBinder, String >( "rawData" ) );
		column2.setEditable( true );
		column2.setOnEditCommit( ( EventHandler< CellEditEvent< DocumentBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setRawData( t.getNewValue() );
				}
		);
		TableColumn column3 = new TableColumn( "url" );
		column3.setCellValueFactory(
				new PropertyValueFactory< DocumentBinder, String >( "url" ) );
		column3.setEditable( true );
		column3.setOnEditCommit( ( EventHandler< CellEditEvent< DocumentBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setUrl( t.getNewValue() );
				}
		);
		TableColumn column4 = new TableColumn( "lastUpdated" );
		column4.setCellValueFactory(
				new PropertyValueFactory< DocumentBinder, java.sql.Timestamp >( "lastUpdated" ) );
		column4.setEditable( true );
		column4.setOnEditCommit( ( EventHandler< CellEditEvent< DocumentBinder, java.sql.Timestamp > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setLastUpdated( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1, column2, column3, column4 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "name" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );
		final TextField column2EditField = new TextField();
		column2EditField.setPromptText( "rawData" );
		column2EditField.setMaxWidth( column2.getPrefWidth() );
		final TextField column3EditField = new TextField();
		column3EditField.setPromptText( "url" );
		column3EditField.setMaxWidth( column3.getPrefWidth() );
		final TextField column4EditField = new TextField();
		column4EditField.setPromptText( "lastUpdated" );
		column4EditField.setMaxWidth( column4.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new DocumentEntity()
								.withParsedName( column1EditField.getText() )
								.withParsedRawData( column2EditField.getText() )
								.withParsedUrl( column3EditField.getText() )
								.withParsedLastUpdated( column4EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< DocumentEntity > itemList = repository.findAll();

					for ( DocumentEntity item : itemList ) {
						data.add( new DocumentBinder(
								item.getId(),
								item.getName(),
								item.getRawData(),
								item.getUrl(),
								item.getLastUpdated()
						) );
					}

					table.setItems( data );

					message.setText( "New records from Document are created and to the list." );
					column1EditField.clear();
					column2EditField.clear();
					column3EditField.clear();
					column4EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "Document created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: Document could NOT be created!" );
				}
			} catch ( DocumentException documentException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( documentException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< DocumentEntity > itemList = repository.findAll();

			for ( DocumentEntity item : itemList ) {
				data.add( new DocumentBinder(
						item.getId(),
						item.getName(),
						item.getRawData(),
						item.getUrl(),
						item.getLastUpdated()
				) );
			}

			table.setItems( data );

			message.setText( "Document records are refreshed" );

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

