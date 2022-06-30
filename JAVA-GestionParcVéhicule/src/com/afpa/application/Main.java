package com.afpa.application;

import com.afpa.exception.PanneEssenceException;
import com.afpa.exception.PleinNegatif;

import static com.afpa.application.ParcVehicule.controlerVehicules;
import static com.afpa.application.ParcVehicule.listVehicule;
import static com.afpa.outil.Affichage.informativeWindow;
import static com.afpa.outil.Affichage.questionWindow;
import static com.afpa.outil.Outils.stringToInt;

public
class Main
{
    /**
     * @TODO Penser à créer les test pour rentrer dans les méthodes
     */
    public static
    void main ( String[] args ) throws PleinNegatif, PanneEssenceException
    {

        /*  Étape 1 - Creation d'instance
            Étape 2 - affichage type dans le terminal
            Étape 3 - affichage joli test + plein
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        Voiture laguna = new Voiture ( "Renault", "Laguna", 66.0f );
        System.out.println ( laguna );
        laguna.faireLePlein ( 30f );
        laguna.arreter ();

        /*  Étape 4 - faire un trajet
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        System.out.println ( laguna );
        laguna.rouler ( 25f );
        System.out.println ( laguna );

        try
        {
            laguna.rouler ( 50f );
        }
        catch ( PanneEssenceException e )
        {
            informativeWindow ( "La Lagune vient de tomber en panne : " + e.getMessage (), "Panne" );
            laguna.faireLePlein (
                    stringToInt ( questionWindow ( "Veuillez saisir le nombre de litre", "Plein obligatoire" ) ) );
        }

        /*  Étape 6 - Test trajet 6 x 10L
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        Voiture c5 = new Voiture ( "Citroen", "C5", 71.0f );
        c5.faireLePlein ( 40f );

        int i = 0;
        while ( i < 6 )
        {
            try
            {
                c5.rouler ( 10f );
            }
            catch ( PanneEssenceException e )
            {
                informativeWindow ( String.format ( "%s%nCause probable : %s", c5, e.getMessage () ),
                                    "Le coup de la panne" );
                c5.faireLePlein (
                        stringToInt ( questionWindow ( "Veuillez saisir le nombre de litre", "Plein obligatoire" ) ) );
            }
            i += 1;
        }
        c5.arreter ();
        informativeWindow (
                String.format ( "%s%nJ'ai reçu au total %2.2f d'essence", c5, c5.getMoteur ().getQteEssenceCumule () ),
                null );

        /*  Étape 7 - Test scooter trajet 3 x 10L
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        Scooter xmax = new Scooter ( "Yamaha", "X-MAX", 20f );
        informativeWindow ( xmax.toString (), null );
        xmax.faireLePlein ( 30.0f );
        System.out.println ( xmax );

        i = 0;
        while ( i < 3 )
        {
            try
            {
                xmax.rouler ( 10f );
            }
            catch ( PanneEssenceException e )
            {
                informativeWindow ( String.format ( "%s%nCause probable : %s", xmax, e.getMessage () ),
                                    "Le coup de la panne" );
                xmax.faireLePlein (
                        stringToInt ( questionWindow ( "Veuillez saisir le nombre de litre", "Plein obligatoire" ) ) );
            }
            i += 1;
        }
        xmax.arreter ();
        informativeWindow ( String.format ( "%s%nJ'ai reçu au total %2.2f litres d'essence", xmax,
                                            xmax.getMoteur ().getQteEssenceCumule () ), null );

        /*  Étape 8 - Instantiation de plusieurs véhicules pour les
            mettre dans la collection du parc

            Le constructeur est fait pour que le reservoir soit vide
            à l'instanciation, nous leur ferons le plein à 25L + affichage contrôle.

            On contrôlera ensuite tous les véhicules.
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        ParcVehicule.listVehicule.add ( new Voiture ( "Renault", "Megane", 65.0f ) );
        ParcVehicule.listVehicule.add ( new Voiture ( "Renault", "Twingo", 40.0f ) );
        ParcVehicule.listVehicule.add ( new Voiture ( "Volkswagen", "Polo", 45.0f ) );
        ParcVehicule.listVehicule.add ( new Voiture ( "Peugeot", "208", 50.0f ) );

        ParcVehicule.listVehicule.add ( new Scooter ( "Yamaha", "T-MAX", 12f ) );
        ParcVehicule.listVehicule.add ( new Scooter ( "Honda", "Forza 125", 11.5f ) );
        ParcVehicule.listVehicule.add ( new Scooter ( "Piaggio", "Medley 125", 7f ) );

        for ( Vehicule vehicule : listVehicule )
        {
            vehicule.faireLePlein ( 25 );
            System.out.println ( vehicule );
        }

        controlerVehicules ( ParcVehicule.getArrayListVehicule () );
    }
}