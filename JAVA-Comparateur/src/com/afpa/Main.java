package com.afpa;

public
class Main
{
    public static
    void main( String[] args )
    {
        String separator = "---------------------";
        /*  Instanciation des étudiants
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        Etudiant etudiant1 = new Etudiant( "Dupont", "Albert", 22 );
        Etudiant etudiant2 = new Etudiant( "DUPONT", "albert", 22 );
        Etudiant etudiant3 = new Etudiant( "Mercier", "Jean", 55 );

        /*  Test des comparaisons des étudiants
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        System.out.printf( "%s%n%s%n", etudiant1.equals( etudiant2 ), etudiant1.equals( etudiant3 ));

        /*  Affichage des étudiants
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        System.out.println( separator );
        System.out.printf( "%s%n%s%n%s%n", etudiant1, etudiant2, etudiant3 );
        System.out.println( separator );


        /*  Instanciation de la société + recruter / congédier test
        /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
        Societe societe = new Societe();

        Salarie durand      = societe.recruter( new Etudiant( "Durand", "Michel", 55 ) );
        Salarie leclerc     = societe.recruter( new Etudiant( "Leclerc", "Claude", 50 ) );
        Salarie mercier     = societe.recruter( new Etudiant( "Mercier", "Paul", 38 ) );
        Salarie dubois      = societe.recruter( new Etudiant( "Dubois", "Paul", 38 ) );
        Salarie martin      = societe.recruter( new Etudiant( "Martin", "Catherine", 21 ) );
        Salarie charpentier = societe.recruter( new Etudiant( "Charpentier", "Pierre", 25 ) );
        Salarie vannier     = societe.recruter( new Etudiant( "Vannier", "Guillaume", 38 ) );
        Salarie rodriguez   = societe.recruter( new Etudiant( "Rodriguez", "Isabelle", 25 ) );

        societe.recruter( durand );

        System.out.println( separator );
        societe.afficher( true );// affichage par tri croissant des noms + statut
        System.out.println( separator );

        societe.congedier( vannier );
        societe.congedier( martin );
        Salarie duval = societe.recruter( new Etudiant( "Duval", "Isabelle", 30 ) );
        societe.congedier( duval );
        societe.congedier( duval );

        System.out.println( separator );
        societe.afficher( false );// affichage par tri decroissant des noms + statut
    }
}