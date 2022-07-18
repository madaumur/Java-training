package fr.afpa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public
class Main extends Application
{
    public static
    void main( String[] args )
    {
        System.out.println( "[system] Lancement de l'application." );

        // Lancement de l'application par l'appel de launch().
        launch( args );
    }

    // Override de la méthode init().
    @Override
    public
    void init()
    {
        System.out.println( "[system] Methode init()." );
    }

    @Override
    public
    void start( Stage myStage ) throws IOException
    {
        System.out.println( "[system] Methode start()." );

        // On appelle la feuille de style fxml
        FXMLLoader fxmlLoader = new FXMLLoader( Main.class.getResource( "view_1.fxml" ) );

        // Création d'une scène
        Scene myScene = new Scene( fxmlLoader.load() );
        // Nom de la fenêtre
        myStage.setTitle( "TITRE" );
        // Integration de la scene dans la fenêtre
        myStage.setScene( myScene );
        // Affichage de la fenêtre
        myStage.show();
    }

    // Override de la méthode stop().
    @Override
    public
    void stop()
    {
        System.out.println( "[system] Methode stop()." );
    }
}