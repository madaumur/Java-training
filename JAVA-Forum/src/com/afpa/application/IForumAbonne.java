package com.afpa.application;

interface IForumAbonne
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    String getNom();

    int getIndex( Nouvelle nouvelle );

    void ajouterNouvelle( Nouvelle nouvelle );

    Nouvelle consulterNouvelle( int index );

    void repondreNouvelle( int index, Personne auteur );
}
