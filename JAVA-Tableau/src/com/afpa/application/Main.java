package com.afpa.application;

import static com.afpa.application.Affichage.informativeWindow;
import static com.afpa.application.Affichage.questionWindow;
import static com.afpa.application.Tools.*;


public
class Main
{
    public static
    void main( String[] args )
    {
        int     arraySize = 0;
        boolean isCorrect = false;

        while ( ! isCorrect )
        {
            try
            {
                arraySize = stringToInt( questionWindow( "Entrer la taille du tableau voulue.", "ask_array_size" ) );
                isCorrect = true;
            }
            catch ( Exception e )
            {
                informativeWindow( "Ceci n'est pas un entier.", "input_error" );
            }
        }

        int[] mainArray = new int[ arraySize ];

        fillTabWithRandom( mainArray );
        informativeWindow( tabToString( mainArray ), "show_array" );
        sortArrayIncreasing( mainArray );
        informativeWindow( tabToString( mainArray ), "show_array_after_sorting" );
    }
}