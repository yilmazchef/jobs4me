package be.intec.views.desktop;


import be.intec.models.binders.ApplicantBinder;
import be.intec.models.entities.ApplicantEntity;
import be.intec.repositories.ApplicantRepository;
import be.intec.services.exceptions.ApplicantException;
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

public class ApplicantDesktopView extends Application {

	final HBox actBox = new HBox();
	final HBox navBox = new HBox();
	private final TableView< ApplicantBinder > table = new TableView<>();
	private final ObservableList< ApplicantBinder > data = FXCollections.observableArrayList();
	private final ApplicantRepository repository = new ApplicantRepository();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "Applicant Desktop View" );
		stage.setWidth( 500 );
		stage.setHeight( 650 );

		final Label header = new Label( "Applicant Records" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: Form loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		table.setEditable( true );

		TableColumn column0 = new TableColumn( "id" );
		column0.setCellValueFactory(
				new PropertyValueFactory< ApplicantBinder, Integer >( "id" ) );
		column0.setEditable( false );
		TableColumn column1 = new TableColumn( "firstName" );
		column1.setCellValueFactory(
				new PropertyValueFactory< ApplicantBinder, String >( "firstName" ) );
		column1.setEditable( true );
		column1.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicantBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setFirstName( t.getNewValue() );
				}
		);
		TableColumn column2 = new TableColumn( "lastName" );
		column2.setCellValueFactory(
				new PropertyValueFactory< ApplicantBinder, String >( "lastName" ) );
		column2.setEditable( true );
		column2.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicantBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setLastName( t.getNewValue() );
				}
		);
		TableColumn column3 = new TableColumn( "email" );
		column3.setCellValueFactory(
				new PropertyValueFactory< ApplicantBinder, String >( "email" ) );
		column3.setEditable( true );
		column3.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicantBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setEmail( t.getNewValue() );
				}
		);
		TableColumn column4 = new TableColumn( "phone" );
		column4.setCellValueFactory(
				new PropertyValueFactory< ApplicantBinder, String >( "phone" ) );
		column4.setEditable( true );
		column4.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicantBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setPhone( t.getNewValue() );
				}
		);
		TableColumn column5 = new TableColumn( "summary" );
		column5.setCellValueFactory(
				new PropertyValueFactory< ApplicantBinder, String >( "summary" ) );
		column5.setEditable( true );
		column5.setOnEditCommit( ( EventHandler< CellEditEvent< ApplicantBinder, String > > ) t -> {

					// UPDATE COLUMN IN THE REPO


					// UPDATE TABLE COLUMN

					t.getTableView().getItems().get(
							t.getTablePosition().getRow() ).setSummary( t.getNewValue() );
				}
		);

		table.setItems( data );
		table.getColumns().addAll( column0, column1, column2, column3, column4, column5 );

		final TextField column1EditField = new TextField();
		column1EditField.setPromptText( "firstName" );
		column1EditField.setMaxWidth( column1.getPrefWidth() );
		final TextField column2EditField = new TextField();
		column2EditField.setPromptText( "lastName" );
		column2EditField.setMaxWidth( column2.getPrefWidth() );
		final TextField column3EditField = new TextField();
		column3EditField.setPromptText( "email" );
		column3EditField.setMaxWidth( column3.getPrefWidth() );
		final TextField column4EditField = new TextField();
		column4EditField.setPromptText( "phone" );
		column4EditField.setMaxWidth( column4.getPrefWidth() );
		final TextField column5EditField = new TextField();
		column5EditField.setPromptText( "summary" );
		column5EditField.setMaxWidth( column5.getPrefWidth() );

		final Button addButton = new Button( "Add" );
		addButton.setOnAction( onClick -> {

			// SAVE NEW RECORD TO DB
			try {
				int noOfNewRecords = repository.save(
						new ApplicantEntity()
								.withParsedFirstName( column1EditField.getText() )
								.withParsedLastName( column2EditField.getText() )
								.withParsedEmail( column3EditField.getText() )
								.withParsedPhone( column4EditField.getText() )
								.withParsedSummary( column5EditField.getText() )
				);

				if ( noOfNewRecords > 0 ) {

					// CLEAR TABLE
					table.getItems().clear();

					// MAP DB RECORDS TO VIEW COMPONENTS
					List< ApplicantEntity > itemList = repository.findAll();

					for ( ApplicantEntity item : itemList ) {
						data.add( new ApplicantBinder(
								item.getId(),
								item.getFirstName(),
								item.getLastName(),
								item.getEmail(),
								item.getPhone(),
								item.getSummary()
						) );
					}

					table.setItems( data );

					message.setText( "New records from Applicant are created and to the list." );
					column1EditField.clear();
					column2EditField.clear();
					column3EditField.clear();
					column4EditField.clear();
					column5EditField.clear();

					message.setStyle( "-fx-text-fill: green; -fx-font-size: 16px;" );
					message.setText( "Applicant created!" );

				} else {
					message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
					message.setText( "ERROR: Applicant could NOT be created!" );
				}
			} catch ( ApplicantException applicantException ) {
				message.setStyle( "-fx-text-fill: red; -fx-font-size: 16px;" );
				message.setText( applicantException.getMessage() );
			}

		} );

		final Button viewButton = new Button( "View" );
		viewButton.setOnAction( onClick -> {

			// CLEAR TABLE
			table.getItems().clear();

			// MAP DB RECORDS TO VIEW COMPONENTS
			List< ApplicantEntity > itemList = repository.findAll();

			for ( ApplicantEntity item : itemList ) {
				data.add( new ApplicantBinder(
						item.getId(),
						item.getFirstName(),
						item.getLastName(),
						item.getEmail(),
						item.getPhone(),
						item.getSummary()
				) );
			}

			table.setItems( data );

			message.setText( "Applicant records are refreshed" );

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

