package com.afpa;

public
class ListeDoublChain
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    Maillon debutListe;
    Maillon finListe;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    public
    ListeDoublChain()
    {
        debutListe = null;
        finListe   = null;
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

    protected
    < E > void ajouterMaillon( E element )
    {
        Maillon maillonActuel = this.debutListe;

        if ( maillonActuel == null ) // Condition si la liste est vide
        {
            this.debutListe = new Maillon( element, null );
            this.finListe   = debutListe;
        }
        else
        {
            while ( maillonActuel.getMaillonSuiv() != null ) // Parcours de la pile jusqu'au dernier maillon
            {
                maillonActuel = maillonActuel.getMaillonSuiv();
            }

            maillonActuel.setMaillonSuiv( new Maillon( element, maillonActuel ) );
            this.finListe = maillonActuel.getMaillonSuiv();
        }
    }
}
