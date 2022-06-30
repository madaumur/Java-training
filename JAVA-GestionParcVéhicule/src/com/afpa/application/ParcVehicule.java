package com.afpa.application;

import com.afpa.exception.PleinNegatif;

import java.util.ArrayList;

import static com.afpa.outil.Affichage.informativeWindow;

public
class ParcVehicule
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    protected static ArrayList< Vehicule > listVehicule = new ArrayList<> ();
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private
    ParcVehicule ()
    {
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    public static
    ArrayList< Vehicule > getArrayListVehicule ()
    {
        return listVehicule;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                       REDEFINITION DE TOSTRING()             */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    static
    void controlerVehicules ( ArrayList< Vehicule > listVehicule ) throws PleinNegatif
    {
        StringBuilder str = new StringBuilder ();
        for ( Vehicule element : listVehicule )
        {
            element.demarrer ();
            try
            {
                element.rouler ( ( float ) ( 1.0f + Math.random () * ( 5.0f - 1.0f ) ) );
            }
            catch ( Exception e )
            {
                informativeWindow ( "Le véhicule est en panne : " + e.getMessage (), "panne" );
                element.faireLePlein ( ( float ) ( 1.0f + Math.random () * ( 10.0f - 1.0f ) ) );
            }
            element.arreter ();
            str.append ( String.format ( "--------------%n%s%n--------------", element ) );
        }
        informativeWindow ( str.toString (), "Description" );
    }
}
