package com.afpa;

import javax.swing.*;

import static com.afpa.Outils.*;
import static javax.swing.JOptionPane.*;

public
class Main
{
    public static
    void main( String[] args )
    {
        int recommencer;

        /* Calcul aves saisie manuelle
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        String[] choix = { "Factoriel", "Calcul"  };

        String saisi = ( String ) showInputDialog( null, "Quelle opération voulez-vous faire ?", "quelle_opération",
                                                   QUESTION_MESSAGE, null, choix, choix[ 0 ] );
        do
        {
            try
            {
                switch ( saisi )
                {
                    case "Factoriel" :
                        doFacto( askInt() );
                        break;
                    case "Calcul" :
                        doCalcul( askFloat(), askFloat(), askOperator() );
                        break;
                }
            }
            catch ( NumberFormatException nfe )
            {
                showMessageDialog( null, "La valeur saisi n'est pas un flottant ", "Erreur",
                                   JOptionPane.ERROR_MESSAGE );
            }
            catch ( CalculException ce )
            {
                showMessageDialog( null, String.format( "Voici la cause de l'exception :%n%s", ce.getMessage() ),
                                   "Erreur", JOptionPane.ERROR_MESSAGE );
            }
            recommencer = JOptionPane.showConfirmDialog( null, "Voulez-vous recommencer", "recommencer?",
                                                         JOptionPane.OK_CANCEL_OPTION );
        }
        while ( recommencer == 0 );

        /*  vérification des calculs avec valeur en dur
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

        //Tests();
    }

    private static
    void Tests()
    {
        try
        {
            doCalcul( 1.45F, 2.8F, '!' ); // Mauvais opérateur
        }
        catch ( CalculException ce )
        {
            showMessageDialog( null, String.format( "Voici la cause de l'exception :%n%s", ce.getMessage() ),
                               "Erreur", JOptionPane.ERROR_MESSAGE );
        }

        try
        {
            doCalcul( 3.75F , 0, '/' ); // Division par zero
        }
        catch ( CalculException ce )
        {
            showMessageDialog( null, String.format( "Voici la cause de l'exception :%n%s", ce.getMessage() ),
                               "Erreur", JOptionPane.ERROR_MESSAGE );
        }
    }
}