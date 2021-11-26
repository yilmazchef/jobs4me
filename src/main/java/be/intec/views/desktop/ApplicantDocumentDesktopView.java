package be.intec.views.desktop;


import be.intec.models.binders.ApplicantDocumentBinder;
import be.intec.models.entities.ApplicantDocumentEntity;
import be.intec.repositories.ApplicantDocumentRepository;
import be.intec.services.exceptions.ApplicantDocumentException;
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

public class ApplicantDocumentDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< ApplicantDocumentBinder > table = new TableView<>();
	private final ObservableList< ApplicantDocumentBinder > data = FXCollections.observableArrayList();
	private final ApplicantDocumentRepository repository = new ApplicantDocumentRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "ApplicantDocument Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "ApplicantDocument Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< ApplicantDocumentBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "documentId" );
		column1.setCellValueFactory(
				new PropertyValueFactory< ApplicantDocumentBinder, Integer >( "documentId" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicantDocumentBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setDocumentId( t.getNewValue() );
				}
		);
		TableColumn column2 = new TableColumn( "applicantId" );
		column2.setCellValueFactory(
				new PropertyValueFactory< ApplicantDocumentBinder, Integer >( "applicantId" ) );
		column2.setEditable( true );
		column2.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicantDocumentBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setApplicantId( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1, column2 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "documentId" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );
		final TextField column2EditField = new TextField();
		column2EditField.setPromptText( "applicantId" );
		column2EditField.setMaxWidth( column2.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new ApplicantDocumentEntity()
								.withParsedDocumentId( column1EditField.getText() )
								.withParsedApplicantId( column2EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< ApplicantDocumentEntity > itemList = repository.findAll();

					for ( ApplicantDocumentEntity item : itemList ) {
						data.add( new ApplicantDocumentBinder(
								item.getId(),
								item.getDocumentId(),
								item.getApplicantId()
						) );
					}

					table.setItems( data );

					message.setText( "New records from ApplicantDocument are created and to the list." );
					column1EditField.clear();
					column2EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "ApplicantDocument created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: ApplicantDocument could NOT be created!" );
				}
			} catch ( ApplicantDocumentException applicantdocumentException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( applicantdocumentException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< ApplicantDocumentEntity > itemList = repository.findAll();

			for ( ApplicantDocumentEntity item : itemList ) {
				data.add( new ApplicantDocumentBinder(
						item.getId(),
						item.getDocumentId(),
						item.getApplicantId()
				) );
			}

			table.setItems( data );

			message.setText( "ApplicantDocument records are refreshed" );

		} );

		final Button backButton = new Button( "Back" );
		backButton.setOnAction( onClick -> {
			scene.getWindow().hide();
			new MainMenuDesktopView().start( stage );
		} );

		navBox.getChildren().addAll( backButton );
		navBox.setSpacing( 3 );

		actBox.getChildren().addAll( column1EditField, column2EditField, addButton, viewButton );
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

