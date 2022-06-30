package com.afpa.outil;

public
class Outils
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private
    Outils ()
    {
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Méthode qui transforme une String en entier.
     * Si la saisie n'est pas transformable en Int, une erreur sera levée.
     *
     * @param str La String à convertir en Entier.
     * @return La String d'entrée sous forme de (Int).
     */
    public static
    int stringToInt ( String str )
    {
        try
        {
            return Integer.parseInt ( str );
        }
        catch ( Exception e )
        {
            System.out.println ( "Erreur?" );
        }

        return -1;
    }
}
