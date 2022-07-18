package com.afpa;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public
class Main
{
    public static
    void main( String[] args )
    {
        // variables
        int    recommencer = 0;
        String input;

        // corps du main
        while ( recommencer == 0 )
        {
            int    numLu  = 0;
            String ligneLue;
            String finale = "";

            // fenêtre de saisie du nom du fichier
            input = showInputDialog( null, "Entrer le fichier à ouvrir", "demande_nom",
                                     JOptionPane.QUESTION_MESSAGE ).trim();

            // on essaye d'ouvrir le fichier et de le passer dans un reader de ligne
            // le try- with ressource garanti la fermeture du fichier en fin de try, pas besoin de close()
            try ( LineNumberReader lineNumberReader = new LineNumberReader( new FileReader( input ) ) )
            {
                do
                {
                    ligneLue = lineNumberReader.readLine(); // on lit la ligne actuelle

                    if ( ligneLue != null ) // on la stocke si non nulle
                    {
                        finale = String.format( "%s%d - %s%n", finale, numLu + 1, ligneLue );
                    }

                    lineNumberReader.setLineNumber( numLu++ ); // on incrémente la ligne à lire
                }
                while ( ligneLue != null );

                // affichage du contenu du fichier
                showMessageDialog( null, String.format( "%s", finale ), input, JOptionPane.INFORMATION_MESSAGE );
            }
            catch ( FileNotFoundException e )
            {
                showMessageDialog( null, String.format( "Le fichier %s est introuvable.%nErreur : %s", input,
                                                        e.getMessage() ), "erreur", JOptionPane.ERROR_MESSAGE );
            }
            catch ( IOException e )
            {
                showMessageDialog( null, String.format( "Erreur : %s", e.getMessage() ), "erreur",
                                   JOptionPane.ERROR_MESSAGE );
            }

            // fenêtre de proposition pour recommencer
            recommencer = JOptionPane.showConfirmDialog( null, "Voulez-vous recommencer ?", "demande_recommencer?",
                                                         JOptionPane.OK_CANCEL_OPTION );
        }
    }
}
