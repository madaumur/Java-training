package fr.afpa.contact;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe ContactListe qui va nous fournir une liste pour stocker les objets Contact
 */
public
class ContactList
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private static final List< Contact > contactList = new ArrayList<>();

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur privé
     */
    private
    ContactList()
    {
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Getter sur la liste de Contact
     *
     * @return La liste de Contact
     */
    public static
    List< Contact > getContactList()
    {
        return contactList;
    }
}
