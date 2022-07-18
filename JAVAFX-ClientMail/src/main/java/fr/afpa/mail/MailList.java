package fr.afpa.mail;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe MailListe qui va nous fournir une liste pour stocker les objets Mail
 */
public
class MailList
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private static final List< Mail > mailList = new ArrayList<>();

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur privé
     */
    private
    MailList()
    {
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Getter sur la liste de Mail
     *
     * @return La liste de Mail
     */
    public static
    List< Mail > getMailList()
    {
        return mailList;
    }
}
