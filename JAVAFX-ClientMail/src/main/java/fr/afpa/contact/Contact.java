package fr.afpa.contact;

/**
 * La classe d'objet Contact (défini par un prénom, un nom et une adresse email)
 */
public
class Contact
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private final String nom;
    private final String prenom;
    private final String adresseMail;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur de Contact
     *
     * @param contactInfos Un tableau [prénom, nom, mail] contenant les infos de création d'un contact
     */
    public
    Contact( String[] contactInfos )
    {
        this.prenom      = contactInfos[ 0 ];
        this.nom         = contactInfos[ 1 ];
        this.adresseMail = contactInfos[ 2 ];
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Getter sur le prénom du contact
     *
     * @return La String prénom du contact
     */
    public
    String getPrenom()
    {
        return prenom;
    }

    /**
     * Getter sur le nom du contact
     *
     * @return La String nom du contact
     */
    public
    String getNom()
    {
        return nom;
    }

    /**
     * Getter sur l'adresse mail du contact
     *
     * @return La String adresse mail du contact
     */
    public
    String getAdresseMail()
    {
        return adresseMail;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                       REDEFINITION DE TOSTRING()             */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    @Override
    public
    String toString()
    {
        return String.format( "%s %s; <%s>", prenom, nom.toUpperCase(), adresseMail );
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /* @TODO redéfinition de EQUALS() */
}

