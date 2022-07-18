package fr.afpa.mail;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import static fr.afpa.mail.MailList.getMailList;

/**
 * La classe contenant les méthodes et outils de gestion de mail
 */
public
class MailUtils
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private static final String CSV_MAIL_URL = "src/main/resources/fr/afpa/csv/mail/mail.csv";

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur privé
     */
    private
    MailUtils()
    {
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Méthode pour ajouter un Mail dans notre liste de Mail
     *
     * @param mail Le Mail à intégrer dans mailList
     */
    public static
    void addMailToList( Mail mail )
    {
        if ( ! getMailList().contains( mail ) )
        {
            getMailList().add( mail );
        }
    }

    /**
     * Méthode pour ajouter un Mail dans notre fichier de stockage de mail .csv
     *
     * @param mail Le Mail à intégrer dans mail.csv
     */
    public static
    void addMailToCSV( Mail mail )
    {
        try ( FileWriter writer = new FileWriter( CSV_MAIL_URL, true ) )
        {
            String formattedMail = String.format( "%s|%s|%s;", mail.getDestinataire(), mail.getObjet(),
                                                  mail.getMessage() );
            writer.write( formattedMail );
        }
        catch ( Exception e )
        {
            System.out.printf( "[Error] %s%n", e.getMessage() );
        }
    }

    /**
     * Méthode pour ajouter dans notre liste de Mail tous les mails de notre fichier de stockage de mail .csv
     */
    public static
    void fillMailListFromCSV()
    {
        try ( Scanner scanner = new Scanner( new File( CSV_MAIL_URL ) ) )
        {
            scanner.useDelimiter( ";" );

            while ( scanner.hasNext() )
            {
                String[] mailInfos = scanner.next().split( "\\|" );

                if ( mailInfos.length == 3 )
                {
                    MailUtils.addMailToList( new Mail( mailInfos ) );
                }
                else
                {
                    System.out.printf( "Erreur avec l'entree '%s' du fichier .csv%n", Arrays.toString( mailInfos ) );
                }
            }
        }
        catch ( Exception e )
        {
            System.out.printf( "[Error] %s%n", e.getMessage() );
        }
    }
}
