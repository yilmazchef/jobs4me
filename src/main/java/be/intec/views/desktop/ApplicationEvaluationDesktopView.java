package be.intec.views.desktop;


import be.intec.models.binders.ApplicationEvaluationBinder;
import be.intec.models.entities.ApplicationEvaluationEntity;
import be.intec.repositories.ApplicationEvaluationRepository;
import be.intec.services.exceptions.ApplicationEvaluationException;
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

public class ApplicationEvaluationDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< ApplicationEvaluationBinder > table = new TableView<>();
	private final ObservableList< ApplicationEvaluationBinder > data = FXCollections.observableArrayList();
	private final ApplicationEvaluationRepository repository = new ApplicationEvaluationRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "ApplicationEvaluation Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "ApplicationEvaluation Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< ApplicationEvaluationBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "notes" );
		column1.setCellValueFactory(
				new PropertyValueFactory< ApplicationEvaluationBinder, String >( "notes" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationEvaluationBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setNotes( t.getNewValue() );
				}
		);
		TableColumn column2 = new TableColumn( "recruiterId" );
		column2.setCellValueFactory(
				new PropertyValueFactory< ApplicationEvaluationBinder, Integer >( "recruiterId" ) );
		column2.setEditable( true );
		column2.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationEvaluationBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setRecruiterId( t.getNewValue() );
				}
		);
		TableColumn column3 = new TableColumn( "applicationId" );
		column3.setCellValueFactory(
				new PropertyValueFactory< ApplicationEvaluationBinder, Integer >( "applicationId" ) );
		column3.setEditable( true );
		column3.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationEvaluationBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setApplicationId( t.getNewValue() );
				}
		);
		TableColumn column4 = new TableColumn( "hired" );
		column4.setCellValueFactory(
				new PropertyValueFactory< ApplicationEvaluationBinder, String >( "hired" ) );
		column4.setEditable( true );
		column4.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationEvaluationBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setHired( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1, column2, column3, column4 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "notes" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );
		final TextField column2EditField = new TextField();
		column2EditField.setPromptText( "recruiterId" );
		column2EditField.setMaxWidth( column2.getPrefWidth() );
		final TextField column3EditField = new TextField();
		column3EditField.setPromptText( "applicationId" );
		column3EditField.setMaxWidth( column3.getPrefWidth() );
		final TextField column4EditField = new TextField();
		column4EditField.setPromptText( "hired" );
		column4EditField.setMaxWidth( column4.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new ApplicationEvaluationEntity()
								.withParsedNotes( column1EditField.getText() )
								.withParsedRecruiterId( column2EditField.getText() )
								.withParsedApplicationId( column3EditField.getText() )
								.withParsedHired( column4EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< ApplicationEvaluationEntity > itemList = repository.findAll();

					for ( ApplicationEvaluationEntity item : itemList ) {
						data.add( new ApplicationEvaluationBinder(
								item.getId(),
								item.getNotes(),
								item.getRecruiterId(),
								item.getApplicationId(),
								item.getHired()
						) );
					}

					table.setItems( data );

					message.setText( "New records from ApplicationEvaluation are created and to the list." );
					column1EditField.clear();
					column2EditField.clear();
					column3EditField.clear();
					column4EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "ApplicationEvaluation created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: ApplicationEvaluation could NOT be created!" );
				}
			} catch ( ApplicationEvaluationException applicationevaluationException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( applicationevaluationException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< ApplicationEvaluationEntity > itemList = repository.findAll();

			for ( ApplicationEvaluationEntity item : itemList ) {
				data.add( new ApplicationEvaluationBinder(
						item.getId(),
						item.getNotes(),
						item.getRecruiterId(),
						item.getApplicationId(),
						item.getHired()
				) );
			}

			table.setItems( data );

			message.setText( "ApplicationEvaluation records are refreshed" );

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

