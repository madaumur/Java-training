package fr.afpa;

import fr.afpa.contact.ContactUtils;
import fr.afpa.mail.MailUtils;
import javafx.application.Application;
import javafx.stage.Stage;

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

        // On initialise notre liste de contact et notre liste de mail
        ContactUtils.fillContactListFromCSV();
        MailUtils.fillMailListFromCSV();

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
    void start( Stage primaryStage )
    {
        System.out.println( "[system] Methode start()." );

        WindowManager.vuePrincipale( primaryStage );
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