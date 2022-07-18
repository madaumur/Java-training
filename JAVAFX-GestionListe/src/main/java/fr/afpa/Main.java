package fr.afpa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * La classe Principale de notre application
 */
public
class Main extends Application
{
    /**
     * Point d'entrée de notre application : méthode main()
     *
     * @param args → Arguments potentiels à execution
     */
    public static
    void main( String[] args )
    {
        System.out.println( "[system] Lancement de l'application." );

        // On lance l'application par la méthode launch de la classe Application
        launch( args );
    }

    /**
     * Méthode init() de la classe Application, potentiel Override
     * (ici on fait juste un affichage de contrôle dans la console)
     */
    @Override
    public
    void init()
    {
        System.out.println( "[system] Methode init()." );
    }

    /**
     * Méthode start() de la classe Application
     * c'est ici que l'on va créer la fenêtre correspondant au fichier .fxml
     */
    @Override
    public
    void start( Stage myStage ) throws IOException
    {
        System.out.println( "[system] Methode start()." );

        /*
            On charge la feuille de style .fxml dans un FXMLLoader
            Et on crée une scène à partir de celui-ci
         */
        FXMLLoader fxmlLoader = new FXMLLoader( fr.afpa.Main.class.getResource( "view_1.fxml" ) );
        Scene myScene = new Scene( fxmlLoader.load() );

        /*
            Nommage de la fenêtre
            Intégration de la scène dans cette fenêtre
            Et affichage
         */
        myStage.setTitle( "TITRE" );
        myStage.setScene( myScene );
        myStage.show();
    }

    /**
     * Méthode stop() de la classe Application, potentiel Override
     * (ici on fait juste un affichage de contrôle dans la console)
     */
    @Override
    public
    void stop()
    {
        System.out.println( "[system] Methode stop()." );
    }
}