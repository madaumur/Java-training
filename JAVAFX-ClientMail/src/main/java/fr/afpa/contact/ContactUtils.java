package fr.afpa.contact;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import static fr.afpa.contact.ContactList.getContactList;

/**
 * La classe ContactUtils qui contient les méthodes et outils de gestion de contact
 */
public
class ContactUtils
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private static final String CSV_CONTACT_URL = "src/main/resources/fr/afpa/csv/contact/contact.csv";

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur privé
     */
    private
    ContactUtils()
    {
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Méthode pour ajouter un Contact dans notre liste de Contact
     *
     * @param contact Le Contact à intégrer dans contactList
     */
    public static
    void addContactToList( Contact contact )
    {
        if ( ! getContactList().contains( contact ) )
        {
            getContactList().add( contact );
        }
    }

    /**
     * Méthode pour ajouter un Contact dans notre fichier de stockage de contact .csv
     *
     * @param contact Le Contact à intégrer dans contact.csv
     */
    public static
    void addContactToCSV( Contact contact )
    {
        try ( FileWriter writer = new FileWriter( CSV_CONTACT_URL, true ) )
        {
            String formattedContact = String.format( "%s|%s|%s;", contact.getPrenom(), contact.getNom().toUpperCase(),
                                                     contact.getAdresseMail() );
            writer.write( formattedContact );
        }
        catch ( Exception e )
        {
            System.out.printf( "[Error] %s%n", e.getMessage() );
        }
    }

    /**
     * Méthode pour ajouter dans notre liste de Contact tous les contacts de notre fichier de stockage de contact .csv
     */
    public static
    void fillContactListFromCSV()
    {
        try ( Scanner scanner = new Scanner( new File( CSV_CONTACT_URL ) ) )
        {
            scanner.useDelimiter( ";" );

            while ( scanner.hasNext() )
            {
                String[] contactInfos = scanner.next().trim().split( "\\|" );

                if ( contactInfos.length == 3 )
                {
                    ContactUtils.addContactToList( new Contact( contactInfos ) );
                }
                else
                {
                    System.out.printf( "Erreur avec l'entree '%s' du fichier .csv%n", Arrays.toString( contactInfos ) );
                }
            }
        }
        catch ( Exception e )
        {
            System.out.printf( "[Error] %s%n", e.getMessage() );
        }
    }
}
