package be.intec.views.desktop;


import be.intec.models.binders.JobBinder;
import be.intec.models.entities.JobEntity;
import be.intec.repositories.JobRepository;
import be.intec.services.exceptions.JobException;
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

public class JobDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< JobBinder > table = new TableView<>();
	private final ObservableList< JobBinder > data = FXCollections.observableArrayList();
	private final JobRepository repository = new JobRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "Job Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "Job Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< JobBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "code" );
		column1.setCellValueFactory(
				new PropertyValueFactory< JobBinder, String >( "code" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< JobBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setCode( t.getNewValue() );
				}
		);
		TableColumn column2 = new TableColumn( "name" );
		column2.setCellValueFactory(
				new PropertyValueFactory< JobBinder, String >( "name" ) );
		column2.setEditable( true );
		column2.setOnEditCommit( ( EventHandler< CellEditEvent< JobBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setName( t.getNewValue() );
				}
		);
		TableColumn column3 = new TableColumn( "description" );
		column3.setCellValueFactory(
				new PropertyValueFactory< JobBinder, String >( "description" ) );
		column3.setEditable( true );
		column3.setOnEditCommit( ( EventHandler< CellEditEvent< JobBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setDescription( t.getNewValue() );
				}
		);
		TableColumn column4 = new TableColumn( "datePublished" );
		column4.setCellValueFactory(
				new PropertyValueFactory< JobBinder, java.sql.Timestamp >( "datePublished" ) );
		column4.setEditable( true );
		column4.setOnEditCommit( ( EventHandler< CellEditEvent< JobBinder, java.sql.Timestamp > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setDatePublished( t.getNewValue() );
				}
		);
		TableColumn column5 = new TableColumn( "jobStartDate" );
		column5.setCellValueFactory(
				new PropertyValueFactory< JobBinder, java.sql.Timestamp >( "jobStartDate" ) );
		column5.setEditable( true );
		column5.setOnEditCommit( ( EventHandler< CellEditEvent< JobBinder, java.sql.Timestamp > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setJobStartDate( t.getNewValue() );
				}
		);
		TableColumn column6 = new TableColumn( "noOfVacancies" );
		column6.setCellValueFactory(
				new PropertyValueFactory< JobBinder, Integer >( "noOfVacancies" ) );
		column6.setEditable( true );
		column6.setOnEditCommit( ( EventHandler< CellEditEvent< JobBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setNoOfVacancies( t.getNewValue() );
				}
		);
		TableColumn column7 = new TableColumn( "jobCategoryId" );
		column7.setCellValueFactory(
				new PropertyValueFactory< JobBinder, Integer >( "jobCategoryId" ) );
		column7.setEditable( true );
		column7.setOnEditCommit( ( EventHandler< CellEditEvent< JobBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setJobCategoryId( t.getNewValue() );
				}
		);
		TableColumn column8 = new TableColumn( "jobPositionId" );
		column8.setCellValueFactory(
				new PropertyValueFactory< JobBinder, Integer >( "jobPositionId" ) );
		column8.setEditable( true );
		column8.setOnEditCommit( ( EventHandler< CellEditEvent< JobBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setJobPositionId( t.getNewValue() );
				}
		);
		TableColumn column9 = new TableColumn( "jobPlatformId" );
		column9.setCellValueFactory(
				new PropertyValueFactory< JobBinder, Integer >( "jobPlatformId" ) );
		column9.setEditable( true );
		column9.setOnEditCommit( ( EventHandler< CellEditEvent< JobBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setJobPlatformId( t.getNewValue() );
				}
		);
		TableColumn column10 = new TableColumn( "organizationId" );
		column10.setCellValueFactory(
				new PropertyValueFactory< JobBinder, Integer >( "organizationId" ) );
		column10.setEditable( true );
		column10.setOnEditCommit( ( EventHandler< CellEditEvent< JobBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setOrganizationId( t.getNewValue() );
				}
		);
		TableColumn column11 = new TableColumn( "processId" );
		column11.setCellValueFactory(
				new PropertyValueFactory< JobBinder, Integer >( "processId" ) );
		column11.setEditable( true );
		column11.setOnEditCommit( ( EventHandler< CellEditEvent< JobBinder, Integer > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setProcessId( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1, column2, column3, column4, column5, column6, column7, column8, column9, column10, column11 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "code" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );
		final TextField column2EditField = new TextField();
		column2EditField.setPromptText( "name" );
		column2EditField.setMaxWidth( column2.getPrefWidth() );
		final TextField column3EditField = new TextField();
		column3EditField.setPromptText( "description" );
		column3EditField.setMaxWidth( column3.getPrefWidth() );
		final TextField column4EditField = new TextField();
		column4EditField.setPromptText( "datePublished" );
		column4EditField.setMaxWidth( column4.getPrefWidth() );
		final TextField column5EditField = new TextField();
		column5EditField.setPromptText( "jobStartDate" );
		column5EditField.setMaxWidth( column5.getPrefWidth() );
		final TextField column6EditField = new TextField();
		column6EditField.setPromptText( "noOfVacancies" );
		column6EditField.setMaxWidth( column6.getPrefWidth() );
		final TextField column7EditField = new TextField();
		column7EditField.setPromptText( "jobCategoryId" );
		column7EditField.setMaxWidth( column7.getPrefWidth() );
		final TextField column8EditField = new TextField();
		column8EditField.setPromptText( "jobPositionId" );
		column8EditField.setMaxWidth( column8.getPrefWidth() );
		final TextField column9EditField = new TextField();
		column9EditField.setPromptText( "jobPlatformId" );
		column9EditField.setMaxWidth( column9.getPrefWidth() );
		final TextField column10EditField = new TextField();
		column10EditField.setPromptText( "organizationId" );
		column10EditField.setMaxWidth( column10.getPrefWidth() );
		final TextField column11EditField = new TextField();
		column11EditField.setPromptText( "processId" );
		column11EditField.setMaxWidth( column11.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new JobEntity()
								.withParsedCode( column1EditField.getText() )
								.withParsedName( column2EditField.getText() )
								.withParsedDescription( column3EditField.getText() )
								.withParsedDatePublished( column4EditField.getText() )
								.withParsedJobStartDate( column5EditField.getText() )
								.withParsedNoOfVacancies( column6EditField.getText() )
								.withParsedJobCategoryId( column7EditField.getText() )
								.withParsedJobPositionId( column8EditField.getText() )
								.withParsedJobPlatformId( column9EditField.getText() )
								.withParsedOrganizationId( column10EditField.getText() )
								.withParsedProcessId( column11EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< JobEntity > itemList = repository.findAll();

					for ( JobEntity item : itemList ) {
						data.add( new JobBinder(
								item.getId(),
								item.getCode(),
								item.getName(),
								item.getDescription(),
								item.getDatePublished(),
								item.getJobStartDate(),
								item.getNoOfVacancies(),
								item.getJobCategoryId(),
								item.getJobPositionId(),
								item.getJobPlatformId(),
								item.getOrganizationId(),
								item.getProcessId()
						) );
					}

					table.setItems( data );

					message.setText( "New records from Job are created and to the list." );
					column1EditField.clear();
					column2EditField.clear();
					column3EditField.clear();
					column4EditField.clear();
					column5EditField.clear();
					column6EditField.clear();
					column7EditField.clear();
					column8EditField.clear();
					column9EditField.clear();
					column10EditField.clear();
					column11EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "Job created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: Job could NOT be created!" );
				}
			} catch ( JobException jobException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( jobException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< JobEntity > itemList = repository.findAll();

			for ( JobEntity item : itemList ) {
				data.add( new JobBinder(
						item.getId(),
						item.getCode(),
						item.getName(),
						item.getDescription(),
						item.getDatePublished(),
						item.getJobStartDate(),
						item.getNoOfVacancies(),
						item.getJobCategoryId(),
						item.getJobPositionId(),
						item.getJobPlatformId(),
						item.getOrganizationId(),
						item.getProcessId()
				) );
			}

			table.setItems( data );

			message.setText( "Job records are refreshed" );

		} );

		final Button backButton = new Button( "Back" );
		backButton.setOnAction( onClick -> {
			scene.getWindow().hide();
			new MainMenuDesktopView().start( stage );
		} );

		navBox.getChildren().addAll( backButton );
		navBox.setSpacing( 3 );

		actBox.getChildren().addAll( column1EditField, column2EditField, column3EditField, column4EditField, column5EditField, column6EditField, column7EditField, column8EditField, column9EditField, column10EditField, column11EditField, addButton, viewButton );
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

