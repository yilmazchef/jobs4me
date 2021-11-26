package be.intec.views.desktop;


import be.intec.models.binders.ApplicationBinder;
import be.intec.models.entities.ApplicationEntity;
import be.intec.repositories.ApplicationRepository;
import be.intec.services.exceptions.ApplicationException;
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

public class ApplicationDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< ApplicationBinder > table = new TableView<>();
	private final ObservableList< ApplicationBinder > data = FXCollections.observableArrayList();
	private final ApplicationRepository repository = new ApplicationRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "Application Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "Application Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< ApplicationBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "dateOfApplication" );
		column1.setCellValueFactory(
				new PropertyValueFactory< ApplicationBinder, java.sql.Timestamp >( "dateOfApplication" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationBinder, java.sql.Timestamp > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setDateOfApplication( t.getNewValue() );
				}
		);
		TableColumn column2 = new TableColumn( "education" );
		column2.setCellValueFactory(
				new PropertyValueFactory< ApplicationBinder, String >( "education" ) );
		column2.setEditable( true );
		column2.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setEducation( t.getNewValue() );
				}
		);
		TableColumn column3 = new TableColumn( "experience" );
		column3.setCellValueFactory(
				new PropertyValueFactory< ApplicationBinder, String >( "experience" ) );
		column3.setEditable( true );
		column3.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setExperience( t.getNewValue() );
				}
		);
		TableColumn column4 = new TableColumn( "otherInfo" );
		column4.setCellValueFactory(
				new PropertyValueFactory< ApplicationBinder, String >( "otherInfo" ) );
		column4.setEditable( true );
		column4.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setOtherInfo( t.getNewValue() );
				}
		);
		TableColumn column5 = new TableColumn( "jobId" );
		column5.setCellValueFactory(
				new PropertyValueFactory< ApplicationBinder, Integer >( "jobId" ) );
		column5.setEditable( true );
		column5.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setJobId( t.getNewValue() );
				}
		);
		TableColumn column6 = new TableColumn( "applicantId" );
		column6.setCellValueFactory(
				new PropertyValueFactory< ApplicationBinder, Integer >( "applicantId" ) );
		column6.setEditable( true );
		column6.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicationBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setApplicantId( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1, column2, column3, column4, column5, column6 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "dateOfApplication" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );
		final TextField column2EditField = new TextField();
		column2EditField.setPromptText( "education" );
		column2EditField.setMaxWidth( column2.getPrefWidth() );
		final TextField column3EditField = new TextField();
		column3EditField.setPromptText( "experience" );
		column3EditField.setMaxWidth( column3.getPrefWidth() );
		final TextField column4EditField = new TextField();
		column4EditField.setPromptText( "otherInfo" );
		column4EditField.setMaxWidth( column4.getPrefWidth() );
		final TextField column5EditField = new TextField();
		column5EditField.setPromptText( "jobId" );
		column5EditField.setMaxWidth( column5.getPrefWidth() );
		final TextField column6EditField = new TextField();
		column6EditField.setPromptText( "applicantId" );
		column6EditField.setMaxWidth( column6.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new ApplicationEntity()
								.withParsedDateOfApplication( column1EditField.getText() )
								.withParsedEducation( column2EditField.getText() )
								.withParsedExperience( column3EditField.getText() )
								.withParsedOtherInfo( column4EditField.getText() )
								.withParsedJobId( column5EditField.getText() )
								.withParsedApplicantId( column6EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< ApplicationEntity > itemList = repository.findAll();

					for ( ApplicationEntity item : itemList ) {
						data.add( new ApplicationBinder(
								item.getId(),
								item.getDateOfApplication(),
								item.getEducation(),
								item.getExperience(),
								item.getOtherInfo(),
								item.getJobId(),
								item.getApplicantId()
						) );
					}

					table.setItems( data );

					message.setText( "New records from Application are created and to the list." );
					column1EditField.clear();
					column2EditField.clear();
					column3EditField.clear();
					column4EditField.clear();
					column5EditField.clear();
					column6EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "Application created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: Application could NOT be created!" );
				}
			} catch ( ApplicationException applicationException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( applicationException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< ApplicationEntity > itemList = repository.findAll();

			for ( ApplicationEntity item : itemList ) {
				data.add( new ApplicationBinder(
						item.getId(),
						item.getDateOfApplication(),
						item.getEducation(),
						item.getExperience(),
						item.getOtherInfo(),
						item.getJobId(),
						item.getApplicantId()
				) );
			}

			table.setItems( data );

			message.setText( "Application records are refreshed" );

		} );

		final Button backButton = new Button( "Back" );
		backButton.setOnAction( onClick -> {
			scene.getWindow().hide();
			new MainMenuDesktopView().start( stage );
		} );

		navBox.getChildren().addAll( backButton );
		navBox.setSpacing( 3 );

		actBox.getChildren().addAll( column1EditField, column2EditField, column3EditField, column4EditField, column5EditField, column6EditField, addButton, viewButton );
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

