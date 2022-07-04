package com.afpa.application;

public
class Maillon
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    private int valeur;         // Valeur dans le maillon
    private Maillon suivant;    // Adresse vers le maillon suivant

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    public
    Maillon( int valeur )
    {
        setValeur( valeur );
        setSuivant( null );
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    public
    int getValeur()
    {
        return valeur;
    }

    public
    void setValeur( int valeur )
    {
        this.valeur = valeur;
    }

    public
    Maillon getSuivant()
    {
        return suivant;
    }

    public
    void setSuivant( Maillon suivant )
    {
        this.suivant = suivant;
    }
}
