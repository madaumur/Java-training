package com.afpa.application;

/**
 * La classe Tools regroupe les méthodes nécessaires au programme. Notamment de calcul.
 */
public
class Tools
{
    private
    Tools()
    {
    }

    /**
     * Méthode qui transforme une String en entier.
     * Si la saisie n'est pas transformable en Int, une erreur sera levée.
     *
     * @param str La String à convertir en Entier.
     *
     * @return La String d'entrée sous forme de (Int).
     */
    protected static
    int stringToInt( String str )
    {
        return Integer.parseInt( str );
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
    String tabToString( int[] tab )
    {
        String strFinal = "";

        for ( int i = 0; i < tab.length; i++ )
        {
            strFinal = strFinal.concat( String.format( "tableau[%d] = %d%n", i, tab[i] ) );
        }

        return strFinal;
    }

    /**
     * Méthode qui rempli un tableau par des entiers randoms.
     * Ici les valeurs random variant entre - 100 et 100.
     *
     * @param tab Le tableau à remplir d'entiers random.
     */

    // @TODO A tester Arrays.asList (int Array).contains(value)
    protected static
    void fillTabWithRandom( int[] tab )
    {
        for ( int i = 0; i < tab.length; i++ )
        {
            tab[ i ] = ( int ) ( Math.random() * 50 ) + 1;
        }
    }

    /**
     * Méthode qui tri un tableau de manière croissante.
     *
     * @param tab Le tableau à trier.
     */

    // @TODO A tester system.arraycopy()
    protected static
    void sortArrayIncreasing( int[] tab )
    {
        int temp;

        for ( int i = 1; i < tab.length; i++ )
        {
            if ( tab[ i ] < tab[ i - 1 ] )
            {
                int j = 0;

                while ( tab[ j ] < tab[ i ] )
                {
                    j++;
                }

                temp = tab[ i ];

                for ( int k = i - 1; k >= j; k-- )
                {
                    tab[ k + 1 ] = tab[ k ];
                }
                tab[ j ] = temp;
            }
        }
    }
}
