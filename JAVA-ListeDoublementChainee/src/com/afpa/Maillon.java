package com.afpa;

public
class Maillon
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private Object element;         // Valeur dans le maillon
    private Maillon maillonSuiv;    // Adresse vers le maillon suivant
    private Maillon maillonPrec;    // Adresse vers le maillon précédent

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    public
    < E > Maillon( E element, Maillon maillonPrec )
    {
        setElement( element );
        setMaillonSuiv( null );
        setMaillonPrec( maillonPrec );
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    public
    Object getElement()
    {
        return this.element;
    }

    public
    < E > void setElement( E element )
    {
        this.element = element;
    }

    public
    Maillon getMaillonSuiv()
    {
        return maillonSuiv;
    }

    public
    void setMaillonSuiv( Maillon maillonSuiv )
    {
        this.maillonSuiv = maillonSuiv;
    }

    public
    Maillon getMaillonPrec()
    {
        return maillonPrec;
    }

    public
    void setMaillonPrec( Maillon maillonPrec )
    {
        this.maillonPrec = maillonPrec;
    }
}
