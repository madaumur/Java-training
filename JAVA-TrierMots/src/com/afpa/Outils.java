package com.afpa;

import static javax.swing.JOptionPane.*;

public
class Outils
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private
    Outils()
    {
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */


    /**
     * Procédure de demande de taille d'un tableau.
     *
     * @return Un entier positif
     */
    protected static
    int askArraySize()
    {
        int     arraySize = 0;
        boolean isCorrect = false;

        do
        {
            try
            {
                arraySize = Integer.parseInt(
                        questionWindow( "Entrer la taille du tableau.", "demande_taille_tableau" ) );
                if ( arraySize > 0 )
                {
                    isCorrect = true;
                }
                else
                {
                    informativeWindow( "Ceci n'est pas un entier positif.", "input_error" );
                }
            }
            catch ( Exception e )
            {
                informativeWindow( "Ceci n'est pas un entier positif.", "input_error" );
            }
        }
        while ( ! isCorrect );

        return arraySize;
    }

    /**
     * Méthode qui transforme un tableau en String.
     * Format de la string finale | XX | XX | XX | ...
     *
     * @param tab Le tableau à convertir en String.
     *
     * @return Le tableau d'entrée sous forme de String.
     */
    protected static
    < E > String tabToString( E[] tab )
    {
        String strFinal = "";

        for ( E element : tab )
        {
            strFinal = strFinal.concat( String.format( "| %s ", element ) );
        }

        strFinal = strFinal.concat( "|" );
        return strFinal;
    }

    /**
     * Affichage d'une fenêtre de questionnement.
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
     * Affichage d'une fenêtre d'information.
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
