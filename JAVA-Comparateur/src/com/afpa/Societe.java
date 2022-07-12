package com.afpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public
class Societe
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    ArrayList< Etudiant > listePersonnel;
    Iterator< Etudiant > iterateur;
    Comparator< Etudiant > comparateur;

    static int id = 1;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    public
    Societe()
    {
        listePersonnel = new ArrayList<>();
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

    Salarie recruter( Etudiant personne )
    {
        if ( listePersonnel.contains( personne ) || personne == null )
        {
            System.out.println( "Impossible d'employer la personne" );
            return null;
        }
        else
        {
            Salarie salarie = new Salarie( personne );


            salarie.setId( id++ );

            listePersonnel.add( salarie );
            System.out.printf( "%s a rejoint l'entreprise%n", personne.toStringShort() );
            return salarie;
        }
    }

    void congedier( Salarie personne )
    {
        if ( ! listePersonnel.contains( personne ) || personne == null )
        {
            System.out.println( "Impossible de congedier la personne" );
        }
        else
        {
            listePersonnel.remove( personne );
            listePersonnel.add( new Etudiant( personne.getNom(), personne.getPrenom(), personne.getAge() ) );
            System.out.printf( "%s n'est plus salarie%n", personne.toStringShort() );
        }
    }

    void afficher( boolean ordre )
    {
        trierNom( ordre );

        iterateur = listePersonnel.iterator();

        while ( iterateur.hasNext() )
        {
            System.out.printf( "%s%n", iterateur.next().toString() );
        }
    }

    void trierNom( boolean ordre )
    {
        comparateur = ordre ? new CompareEtudiantSalarie() : Collections.reverseOrder( new CompareEtudiantSalarie() );

        this.listePersonnel.sort( comparateur );
    }
}