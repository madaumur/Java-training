package fr.afpa;

import javafx.scene.control.TextField;

public
class Utils
{
    static
    char getrecherche( TextField lettreRecherche )
    {
        return lettreRecherche.getText().trim().charAt( 0 );
    }

    static
    int nbOccurence( char c, String str )
    {
        int count = 0;

        for ( int i = 0; i < str.trim().length(); i++ )
        {
            if ( str.charAt( i ) == c )
            {
                count++;
            }
        }

        return count;
    }
}
