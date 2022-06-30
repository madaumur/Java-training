package com.afpa.outil;

import static javax.swing.JOptionPane.*;

/**
 * La classe Affichage regroupe les méthodes qui permettent d'afficher nos fenêtres.
 */
public final
class Affichage
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private
    Affichage ()
    {
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Fenêtre de questionnement.
     *
     * @param question La question à afficher dans la fenêtre.
     * @param title    Le titre à donner à la fenêtre.
     * @return La saisie clavier sous forme de (String).
     */
    public static
    String questionWindow ( String question, String title )
    {
        return showInputDialog ( null, question, title, QUESTION_MESSAGE );
    }

    /**
     * Fenêtre d'information.
     *
     * @param message Le message à afficher dans la fenêtre.
     * @param title   Le titre à donner à la fenêtre.
     */
    public static
    void informativeWindow ( String message, String title )
    {
        showMessageDialog ( null, message, title, INFORMATION_MESSAGE );
    }
}