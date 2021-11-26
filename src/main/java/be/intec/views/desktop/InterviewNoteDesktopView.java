package be.intec.views.desktop;


import be.intec.models.binders.InterviewNoteBinder;
import be.intec.models.entities.InterviewNoteEntity;
import be.intec.repositories.InterviewNoteRepository;
import be.intec.services.exceptions.InterviewNoteException;
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

public class InterviewNoteDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< InterviewNoteBinder > table = new TableView<>();
	private final ObservableList< InterviewNoteBinder > data = FXCollections.observableArrayList();
	private final InterviewNoteRepository repository = new InterviewNoteRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "InterviewNote Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "InterviewNote Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< InterviewNoteBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "notes" );
		column1.setCellValueFactory(
				new PropertyValueFactory< InterviewNoteBinder, String >( "notes" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< InterviewNoteBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setNotes( t.getNewValue() );
				}
		);
		TableColumn column2 = new TableColumn( "interviewId" );
		column2.setCellValueFactory(
				new PropertyValueFactory< InterviewNoteBinder, Integer >( "interviewId" ) );
		column2.setEditable( true );
		column2.setOnEditCommit( ( EventHandler< CellEditEvent< InterviewNoteBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setInterviewId( t.getNewValue() );
				}
		);
		TableColumn column3 = new TableColumn( "recruiterId" );
		column3.setCellValueFactory(
				new PropertyValueFactory< InterviewNoteBinder, Integer >( "recruiterId" ) );
		column3.setEditable( true );
		column3.setOnEditCommit( ( EventHandler< CellEditEvent< InterviewNoteBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setRecruiterId( t.getNewValue() );
				}
		);
		TableColumn column4 = new TableColumn( "pass" );
		column4.setCellValueFactory(
				new PropertyValueFactory< InterviewNoteBinder, String >( "pass" ) );
		column4.setEditable( true );
		column4.setOnEditCommit( ( EventHandler< CellEditEvent< InterviewNoteBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setPass( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1, column2, column3, column4 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "notes" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );
		final TextField column2EditField = new TextField();
		column2EditField.setPromptText( "interviewId" );
		column2EditField.setMaxWidth( column2.getPrefWidth() );
		final TextField column3EditField = new TextField();
		column3EditField.setPromptText( "recruiterId" );
		column3EditField.setMaxWidth( column3.getPrefWidth() );
		final TextField column4EditField = new TextField();
		column4EditField.setPromptText( "pass" );
		column4EditField.setMaxWidth( column4.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new InterviewNoteEntity()
								.withParsedNotes( column1EditField.getText() )
								.withParsedInterviewId( column2EditField.getText() )
								.withParsedRecruiterId( column3EditField.getText() )
								.withParsedPass( column4EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< InterviewNoteEntity > itemList = repository.findAll();

					for ( InterviewNoteEntity item : itemList ) {
						data.add( new InterviewNoteBinder(
								item.getId(),
								item.getNotes(),
								item.getInterviewId(),
								item.getRecruiterId(),
								item.getPass()
						) );
					}

					table.setItems( data );

					message.setText( "New records from InterviewNote are created and to the list." );
					column1EditField.clear();
					column2EditField.clear();
					column3EditField.clear();
					column4EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "InterviewNote created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: InterviewNote could NOT be created!" );
				}
			} catch ( InterviewNoteException interviewnoteException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( interviewnoteException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< InterviewNoteEntity > itemList = repository.findAll();

			for ( InterviewNoteEntity item : itemList ) {
				data.add( new InterviewNoteBinder(
						item.getId(),
						item.getNotes(),
						item.getInterviewId(),
						item.getRecruiterId(),
						item.getPass()
				) );
			}

			table.setItems( data );

			message.setText( "InterviewNote records are refreshed" );

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

