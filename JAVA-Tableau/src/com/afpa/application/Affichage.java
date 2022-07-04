package com.afpa.application;

import static javax.swing.JOptionPane.*;

/**
 * La classe Affichage regroupe les méthodes qui permettent d'afficher nos fenêtres.
 */
public
class Affichage
{
    private
    Affichage()
    {
    }

    /**
     * Fenêtre de questionnement.
     *
     * @param question La question à afficher dans la fenêtre.
     * @param title    Le titre à donner à la fenêtre.
     *
     * @return La saisie clavier sous forme de (String).
     */
    protected static
    String questionWindow( String question, String title )
    {
        return showInputDialog( null, question, title, QUESTION_MESSAGE );
    }

    /**
     * Fenêtre d'information.
     *
     * @param message Le message à afficher dans la fenêtre.
     * @param title   Le titre à donner à la fenêtre.
     */
    protected static
    void informativeWindow( String message, String title )
    {
        showMessageDialog( null, message, title, INFORMATION_MESSAGE );
    }
}

