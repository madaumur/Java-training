package com.afpa;

import javax.swing.*;

import static com.afpa.Outils.listToString;

public
class Main
{
    public static
    void main( String[] args )
    {
        ListeDoublChain phraseList = new ListeDoublChain();
        String[] phraseTab = { "Les", "listes", "doublement chainees", "en", "Java", "ce n'est qu'une", "question",
                               "de", "references" };

        for ( String str : phraseTab )
        {
            phraseList.ajouterMaillon( str );
        }

        JOptionPane.showMessageDialog( null, listToString( phraseList, true ) );
        JOptionPane.showMessageDialog( null, listToString( phraseList, false ) );
    }
}