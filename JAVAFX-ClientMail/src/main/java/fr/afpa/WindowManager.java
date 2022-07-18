package fr.afpa;

import fr.afpa.utils.Tools;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * La classe de gestion des fenêtres de notre application
 */
public
class WindowManager
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private static Parent root;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur privé
     */
    private
    WindowManager()
    {
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Création/ouverture de la fenêtre principale de notre application
     *
     * @param primaryStage
     */
    public static
    void vuePrincipale( Stage primaryStage )
    {
        try
        {
        /*
            On charge la feuille de style .fxml dans un FXMLLoader
            Et on crée une scène à partir de celui-ci
         */
            root = FXMLLoader.load(
                    Objects.requireNonNull( WindowManager.class.getResource( "fxml/vue_principale.fxml" ) ) );
            Scene scene = new Scene( root );

        /*
            Nommage de la fenêtre
            Intégration de la scène dans cette fenêtre
            Et affichage
         */
            primaryStage.setTitle( "CLIENT_MAIL" );
            primaryStage.setScene( scene );
            primaryStage.show();
            primaryStage.setOnCloseRequest( e ->
                                            {
                                                e.consume();
                                                Tools.onCloseAction();
                                            } );
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

    /**
     * Création/ouverture d'une fenêtre dont le nom est donné en paramètre
     * '
     *
     * @param nameFxl Le nom du fichier .fxml à appliquer
     * @param title   Le titre à donner à la fenêtre
     */
    public static
    void generateVue( String nameFxl, String title )
    {
        try
        {
        /*
            On charge la feuille de style .fxml dans un FXMLLoader
            Et on crée une scène à partir de celui-ci
        */

            Stage stage = new Stage();
            root = FXMLLoader.load(
                    Objects.requireNonNull( WindowManager.class.getResource( "fxml/" + nameFxl + ".fxml" ) ) );
            Scene scene = new Scene( root );

        /*
            Nommage de la fenêtre
            Intégration de notre scène dans la fenêtre et affichage
            Paramètre : non-resizable et bloque l'appli en arrière-plan
        */
            stage.initModality( Modality.APPLICATION_MODAL );
            stage.setTitle( title.trim().toUpperCase() );
            stage.setScene( scene );
            stage.setResizable( false );
            stage.show();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

    /**
     * Création/ouverture d'une fenêtre dont le nom est donné en paramètre
     * '
     *
     * @param nameFxl Le nom du fichier .fxml à appliquer
     * @param title   Le titre à donner à la fenêtre
     */
    public static
    void generateVue( String nameFxl, String title, boolean wait )
    {
        try
        {
        /*
            On charge la feuille de style .fxml dans un FXMLLoader
            Et on crée une scène à partir de celui-ci
        */

            Stage stage = new Stage();
            root = FXMLLoader.load(
                    Objects.requireNonNull( WindowManager.class.getResource( "fxml/" + nameFxl + ".fxml" ) ) );
            Scene scene = new Scene( root );

        /*
            Nommage de la fenêtre
            Intégration de notre scène dans la fenêtre et affichage
            Paramètre : non-resizable et bloque l'appli en arrière-plan
        */
            stage.initModality( Modality.APPLICATION_MODAL );
            stage.setTitle( title.trim().toUpperCase() );
            stage.setScene( scene );
            stage.setResizable( false );
            if ( wait )
            {
                stage.showAndWait();
            }
            else
            {
                stage.show();
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}
