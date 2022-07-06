package com.afpa;

public
class Outils
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private
    Outils()
    {
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                       REDEFINITION DE TOSTRING()             */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    protected static
    String listToString( ListeDoublChain list, boolean sens )
    {

        String strFinal = "";

        if ( sens )
        {
            Maillon maillonActuel = list.debutListe;
            do
            {
                strFinal      = strFinal.concat( String.format( "| %s ", maillonActuel.getElement() ) );
                maillonActuel = maillonActuel.getMaillonSuiv();
            }
            while ( maillonActuel != null );
        }
        else
        {
            Maillon maillonActuel = list.finListe;
            do
            {
                strFinal      = strFinal.concat( String.format( "| %s ", maillonActuel.getElement() ) );
                maillonActuel = maillonActuel.getMaillonPrec();
            }
            while ( maillonActuel != null );
        }


        strFinal = strFinal.concat( "|" );
        return strFinal;
    }
}
