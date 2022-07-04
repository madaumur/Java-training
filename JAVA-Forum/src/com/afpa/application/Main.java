package com.afpa.application;

import static com.afpa.outil.Affichage.informativeWindow;

public
class Main
{
    public static
    void main( String[] args )
    {

        /*  Instanciation forum
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        Forum forum = new Forum( "read-it" );
        /*  version avec saisi utilisateur :
         *  Forum forum = new Forum(questionWindow("Entrer le nom du forum", "forum_name_request"));
         */


        /*  Instanciation abonné
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        Abonne jean    = new Abonne( "Jean", "Steam", 31 );
        Abonne pierre  = new Abonne( "Pierre", "Upright", 28 );
        Abonne patrick = new Abonne( "Patrick", "Regular", 38 );
        Abonne mickael = new Abonne( "Mickael", "Operate", 23 );
        Abonne ibrahim = new Abonne( "Ibrahim", "Disagree", 29 );
        informativeWindow( jean.toString(), "test_abo" );                 //Affichage test


        /*  Instanciation modérateur
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        Moderateur john = new Moderateur( "John", "Do", 31, forum );
        informativeWindow( john.toString(), "test_modo" );                //Affichage test


        /*  Ajout des abonnées au forum par le modo
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        john.ajouterAbonne( jean );
        john.ajouterAbonne( pierre );
        john.ajouterAbonne( patrick );
        john.ajouterAbonne( mickael );
        john.ajouterAbonne( ibrahim );

        john.afficherLesAbonnes();


        /*  Création des nouvelles
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        Nouvelle n1 = jean.creerNouvelle( "Ago Yesterday Not", "Perform, Could, Educate, Favor, Rust" );
        jean.deposerNouvelle( n1 );
        Nouvelle n2 = pierre.creerNouvelle( "SandMountain Elastic", "Earth, Kill, Star, Escape, Cut" );
        pierre.deposerNouvelle( n2 );
        Nouvelle n3 = pierre.creerNouvelle( "Someone Fate", "Chalk, Hammer, Work, Father, Bit, Spread" );
        pierre.deposerNouvelle( n3 );
        Nouvelle n4 = patrick.creerNouvelle( "Sheep Kitchen", "These, Knowledge, Effort, Nephew, Food, Cloth" );
        patrick.deposerNouvelle( n4 );
        Nouvelle n5 = ibrahim.creerNouvelle( "Along Nut", "Nurse, Valuable, Speech, Any, Clock, Write" );
        ibrahim.deposerNouvelle( n5 );


        /*  Test de lecture et de réponse
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        mickael.lireNouvelle( 2 );
        mickael.repondreNouvelle( n3 );
        /*  Ne marche pas grâce à l'abstraction fournie par les interfaces :
         *
         *      pierre.ajouterAbonne(ibrahim);
         *      john.lireNouvelle(2);
         */

        forum.listerMessages();

        /*  Test des fonctions modérateurs
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        john.avertirAbonne( patrick );
        john.avertirAbonne( patrick );
        john.avertirAbonne( patrick ); // 3 avertissements entrainent un ban

        john.avertirAbonne( patrick ); // avertir un abonné non membre du forum

        john.exclureAbonne( patrick ); // exclure un abonné non membre du forum

        john.ajouterAbonne( jean );    // ajouter un abonné deja membre du forum

        john.afficherLesAbonnes();

        informativeWindow( forum.toString(), "info_forum" );
    }
}