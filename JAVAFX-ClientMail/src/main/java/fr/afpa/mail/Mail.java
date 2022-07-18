package fr.afpa.mail;

/**
 * La classe d'objet Mail (défini par un destinataire, un objet et un message)
 */
public
class Mail
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private final String destinataire;
    private final String objet;
    private final String message;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur de Mail
     *
     * @param mailInfos Un tableau [destinataire, objet, message] contenant les infos de création d'un mail
     */
    public
    Mail( String[] mailInfos )
    {
        this.destinataire = mailInfos[ 0 ];
        this.objet        = mailInfos[ 1 ];
        this.message      = mailInfos[ 2 ];
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Getter sur le destinataire de l'email
     *
     * @return La String destinataire de l'email
     */
    public
    String getDestinataire()
    {
        return destinataire;
    }

    /**
     * Getter sur l'objet de l'email
     *
     * @return La String objet de l'email
     */
    public
    String getObjet()
    {
        return objet;
    }

    /**
     * Getter sur le message de l'email
     *
     * @return La String message de l'email
     */
    public
    String getMessage()
    {
        return message;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                       REDEFINITION DE TOSTRING()             */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    @Override
    public
    String toString()
    {
        return String.format( "<Destinataire: %s%nObjet: %.15s...%nCorps: %.30s...>", destinataire, objet,
                              message.trim().replaceAll( "\n\n", "\n" ).replaceAll( "\n", " " ) );
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /* @TODO redéfinition de EQUALS() */
}
