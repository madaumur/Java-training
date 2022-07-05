package com.afpa;

import java.util.Arrays;

import static com.afpa.Outils.*;

public
class Main
{
    public static
    void main( String[] args )
    {
        int      arraySize     = askArraySize();
        String[] tableauString = new String[ arraySize ];

        for ( int count = 0; count < arraySize; count++ )
        {
            tableauString[ count ] = questionWindow( String.format( "Entrer le mot n°%d%n", count + 1 ),
                                                     "demande_String" ).trim();
        }

        informativeWindow( tabToString( tableauString ), "affichage_Tableau" );
        Arrays.sort( tableauString );
        informativeWindow( tabToString( tableauString ), "affichage_Tableau" );
    }
}