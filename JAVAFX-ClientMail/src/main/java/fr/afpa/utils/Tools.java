package fr.afpa.utils;

import fr.afpa.mail.Mail;
import javafx.application.Platform;

import static fr.afpa.WindowManager.generateVue;

/**
 * Classe d'utils
 */
public
class Tools
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private static String adrMailTemp;
    private static Mail mailTemp;

    private static boolean textAreaIsEmpty = true;
    private static boolean newMailIsConfirmed = false;
    private static boolean repOpenMail = false;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private
    Tools()
    {
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Action lorsque l'on demande de fermer la fenêtre. Vérifie si un mail est en cours
     */
    public static
    void onCloseAction()
    {
        if ( textAreaIsEmpty )
        {
            Platform.exit();
        }
        else
        {
            generateVue( "vue_exit", "fermer_quand_meme?" );
        }
    }

    /**
     * Getter sur le mail saisi par l'utilisateur
     *
     * @return La String mail saisi
     */
    public static
    String getAdrMailTemp()
    {
        return adrMailTemp;
    }

    /**
     * Setter sur le mail pour stocker la saisie utilisateur
     *
     * @param mail La String mail a stocker
     */
    public static
    void setAdrMailTemp( String mail )
    {
        Tools.adrMailTemp = mail;
    }

    /**
     * Getter sur le mail temporaire stocké
     *
     * @return Le Mail temporaire stocké
     */
    public static
    Mail getMailTemp()
    {
        return mailTemp;
    }

    /**
     * Setter sur le mail temporaire stocké
     *
     * @param mailTemp Le Mail à stocker temporairement
     */
    public static
    void setMailTemp( Mail mailTemp )
    {
        Tools.mailTemp = mailTemp;
    }

    /**
     * Getter sur l'état de la textArea de la fenêtre principale
     *
     * @return Le booléen de l'état stocké de la textArea
     */
    public static
    boolean getTextAreaIsEmpty()
    {
        return textAreaIsEmpty;
    }

    /**
     * Setter sur l'état de la textArea de la fenêtre principale
     *
     * @param textAreaIsEmpty Le booléen de l'état à stocker de la textArea
     */
    public static
    void setTextAreaIsEmpty( boolean textAreaIsEmpty )
    {
        Tools.textAreaIsEmpty = textAreaIsEmpty;
    }

    /**
     * Getter sur l'état de la réponse lors de la création d'un nouveau mail
     *
     * @return Le booléen de la réponse stockée lors de la création d'un nouveau mail
     */
    public static
    boolean getNewMailIsConfirmed()
    {
        return newMailIsConfirmed;
    }

    /**
     * Setter sur l'état de la réponse lors de la création d'un nouveau mail
     *
     * @param newMailIsConfirmed Le booléen de la réponse à stocker lors de la création d'un nouveau mail
     */
    public static
    void setNewMailIsConfirmed( boolean newMailIsConfirmed )
    {
        Tools.newMailIsConfirmed = newMailIsConfirmed;
    }

    /**
     * Getter sur l'état de la réponse lors de l'ouverture d'un nouveau mail
     *
     * @return Le booléen de la réponse stockée lors de l'ouverture d'un nouveau mail
     */
    public static
    boolean getRepOpenMail()
    {
        return repOpenMail;
    }

    /**
     * Setter sur l'état de la réponse lors de l'ouverture d'un nouveau mail
     *
     * @param repOpenMail Le booléen de la réponse à stocker lors de l'ouverture d'un nouveau mail
     */
    public static
    void setRepOpenMail( boolean repOpenMail )
    {
        Tools.repOpenMail = repOpenMail;
    }
}
