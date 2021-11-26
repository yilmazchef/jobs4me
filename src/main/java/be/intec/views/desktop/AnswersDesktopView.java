package be.intec.views.desktop;


import be.intec.models.binders.AnswersBinder;
import be.intec.models.entities.AnswersEntity;
import be.intec.repositories.AnswersRepository;
import be.intec.services.exceptions.AnswersException;
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

public class AnswersDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< AnswersBinder > table = new TableView<>();
	private final ObservableList< AnswersBinder > data = FXCollections.observableArrayList();
	private final AnswersRepository repository = new AnswersRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "Answers Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "Answers Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< AnswersBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "applicationTestId" );
		column1.setCellValueFactory(
				new PropertyValueFactory< AnswersBinder, Integer >( "applicationTestId" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< AnswersBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setApplicationTestId( t.getNewValue() );
				}
		);
		TableColumn column2 = new TableColumn( "recruiterId" );
		column2.setCellValueFactory(
				new PropertyValueFactory< AnswersBinder, Integer >( "recruiterId" ) );
		column2.setEditable( true );
		column2.setOnEditCommit( ( EventHandler< CellEditEvent< AnswersBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setRecruiterId( t.getNewValue() );
				}
		);
		TableColumn column3 = new TableColumn( "totalGrades" );
		column3.setCellValueFactory(
				new PropertyValueFactory< AnswersBinder, String >( "totalGrades" ) );
		column3.setEditable( true );
		column3.setOnEditCommit( ( EventHandler< CellEditEvent< AnswersBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setTotalGrades( t.getNewValue() );
				}
		);
		TableColumn column4 = new TableColumn( "pass" );
		column4.setCellValueFactory(
				new PropertyValueFactory< AnswersBinder, String >( "pass" ) );
		column4.setEditable( true );
		column4.setOnEditCommit( ( EventHandler< CellEditEvent< AnswersBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setPass( t.getNewValue() );
				}
		);
		TableColumn column5 = new TableColumn( "answerDetails" );
		column5.setCellValueFactory(
				new PropertyValueFactory< AnswersBinder, String >( "answerDetails" ) );
		column5.setEditable( true );
		column5.setOnEditCommit( ( EventHandler< CellEditEvent< AnswersBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setAnswerDetails( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1, column2, column3, column4, column5 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "applicationTestId" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );
		final TextField column2EditField = new TextField();
		column2EditField.setPromptText( "recruiterId" );
		column2EditField.setMaxWidth( column2.getPrefWidth() );
		final TextField column3EditField = new TextField();
		column3EditField.setPromptText( "totalGrades" );
		column3EditField.setMaxWidth( column3.getPrefWidth() );
		final TextField column4EditField = new TextField();
		column4EditField.setPromptText( "pass" );
		column4EditField.setMaxWidth( column4.getPrefWidth() );
		final TextField column5EditField = new TextField();
		column5EditField.setPromptText( "answerDetails" );
		column5EditField.setMaxWidth( column5.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new AnswersEntity()
								.withParsedApplicationTestId( column1EditField.getText() )
								.withParsedRecruiterId( column2EditField.getText() )
								.withParsedTotalGrades( column3EditField.getText() )
								.withParsedPass( column4EditField.getText() )
								.withParsedAnswerDetails( column5EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< AnswersEntity > itemList = repository.findAll();

					for ( AnswersEntity item : itemList ) {
						data.add( new AnswersBinder(
								item.getId(),
								item.getApplicationTestId(),
								item.getRecruiterId(),
								item.getTotalGrades(),
								item.getPass(),
								item.getAnswerDetails()
						) );
					}

					table.setItems( data );

					message.setText( "New records from Answers are created and to the list." );
					column1EditField.clear();
					column2EditField.clear();
					column3EditField.clear();
					column4EditField.clear();
					column5EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "Answers created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: Answers could NOT be created!" );
				}
			} catch ( AnswersException answersException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( answersException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< AnswersEntity > itemList = repository.findAll();

			for ( AnswersEntity item : itemList ) {
				data.add( new AnswersBinder(
						item.getId(),
						item.getApplicationTestId(),
						item.getRecruiterId(),
						item.getTotalGrades(),
						item.getPass(),
						item.getAnswerDetails()
				) );
			}

			table.setItems( data );

			message.setText( "Answers records are refreshed" );

		} );

		final Button backButton = new Button( "Back" );
		backButton.setOnAction( onClick -> {
			scene.getWindow().hide();
			new MainMenuDesktopView().start( stage );
		} );

		navBox.getChildren().addAll( backButton );
		navBox.setSpacing( 3 );

		actBox.getChildren().addAll( column1EditField, column2EditField, column3EditField, column4EditField, column5EditField, addButton, viewButton );
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

