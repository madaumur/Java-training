package com.afpa.application;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public
class Main
{
    public static
    void main( String[] args )
    {
        PileEntier pile      = new PileEntier();
        boolean    isCorrect = false;
        int        tempo;

        while ( ! isCorrect )
        {
            try
            {
                tempo = Integer.parseInt(
                        showInputDialog( null, "Entrer une valeurs pour le maillon (0 = EXIT)", "Entrer_entier",
                                         QUESTION_MESSAGE ).trim() );
                if ( tempo == 0 ) // condition d'arrêt
                {
                    isCorrect = true;
                }
                else
                {
                    pile.empiler( tempo );
                }
            }
            catch ( Exception e ) // L'exception est levée par le parseInt
            {
                showMessageDialog( null, String.format( "Veuillez entrer un entier :%n%s", e.getMessage() ), "Erreur",
                                   ERROR_MESSAGE );
            }
        }

        try
        {
            affichagePile( pile );

            // Test dépilage
            System.out.println( "On depile :" + pile.depiler() );
            affichagePile( pile );

            // Test empilage en dur
            pile.empiler( 32 );
            affichagePile( pile );
        }
        catch ( Exception e )
        {
            showMessageDialog( null, String.format( "Voici la cause de l'exception :%n%s", e.getMessage() ), "Erreur",
                               JOptionPane.ERROR_MESSAGE );
        }
    }

    private static
    void affichagePile( PileEntier pile )
    {
        showMessageDialog( null, pile.pileToString(), "Afficher_pile", INFORMATION_MESSAGE );
    }
}