package com.afpa.application;

interface IForumModerateur
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    String getNom();

    void supprimerNouvelle( Nouvelle nouvelle );

    void bannirUnAbonne( Abonne abonne );

    void avertirUnAbonne( Abonne abonne );

    int ajouterAbonne( Abonne abonne );

    void listerAbonnes();
}
