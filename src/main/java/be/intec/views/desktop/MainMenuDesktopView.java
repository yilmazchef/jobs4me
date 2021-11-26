package be.intec.views.desktop;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenuDesktopView extends Application {

	final HBox hBox = new HBox();


	public static void main( String[] args ) {

		launch( args );
	}


	@Override
	public void start( Stage stage ) {

		Scene scene = new Scene( new Group() );
		stage.setTitle( "Main Menu View" );
		stage.setWidth( 750 );
		stage.setHeight( 600 );

		final Label header = new Label( "Main Menu" );
		header.setFont( new Font( "Arial", 14 ) );

		final Label message = new Label( "Status: loaded." );
		header.setFont( new Font( "Arial", 10 ) );

		final VBox vbox = new VBox();
		vbox.setSpacing( 5 );
		vbox.setPadding( new Insets( 10, 0, 0, 10 ) );
		vbox.getChildren().addAll( header, hBox, message );

		( ( Group ) scene.getRoot() ).getChildren().addAll( vbox );

		stage.setScene( scene );

		stage.show();
	}

}

