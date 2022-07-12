package com.afpa;

import javax.swing.*;
import java.util.HashMap;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;

public
class Main
{
    public static
    void main( String[] args )
    {
        /* Création de la hashmap + instanciation des définitions
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        HashMap< String, String > glossaire = new HashMap<>();

        glossaire.put( "sous classe", "Classe héritant d'une autre classe" );
        glossaire.put( "méthode", "Une fonction destinatrice d'un message" );
        glossaire.put( "polymorphisme", "Un comportement different pour un même message" );
        glossaire.put( "collection", "Instance d'une classe gérant un ensemble d'élément" );
        glossaire.put( "bonheur", "Maîtriser Java et ses subtilités .. oui oui ..." );
        glossaire.put( "interface", "Classe dont toutes les méthodes sont abstraites" );
        glossaire.put( "instance", "Objet créé à partir d'une classe" );


        /* Choix de la définition à l'utilisateur puis affichage
         * Pour cela on va convertir les clés de la map en tableau de String
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        String[] choix = glossaire.keySet().toArray( new String[ 0 ] );

        String saisi = ( String ) showInputDialog( null, "Quelle définition voulez-vous ?", "hash_map",
                                                   QUESTION_MESSAGE, null, choix, choix[ 0 ] );

        switch ( saisi )
        {
            case "sous classe", "méthode", "polymorphisme", "collection", "bonheur", "interface", "instance" -> JOptionPane.showMessageDialog(
                    null, glossaire.get( saisi ), String.format( "définition: '%s'", saisi ),
                    JOptionPane.INFORMATION_MESSAGE );
        }

        /* Affichage du glossaire via du code html
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        String affichage = "<html><table style=\"border: 2px orange dashed\"><thead><tr><th colspan='2'>Glossaire</th></tr></thead><tbody>";

        for ( HashMap.Entry elements : glossaire.entrySet() )
        {
            affichage = String.format( "%s%s%s%s%s%s", affichage, "<tr style=\"border: 1px black solid\"><td>",
                                       elements.getKey(), "</td><td>", elements.getValue(), "</tr>" );
        }
        affichage = String.format( "%s%s", affichage, "</tbody></table>" );

        JOptionPane.showMessageDialog( null, affichage, "glossaire", JOptionPane.INFORMATION_MESSAGE );
    }
}