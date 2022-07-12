package com.afpa;

public
class Etudiant
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private String prenom;
    private String nom;
    private int age;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    public
    Etudiant( String nom, String prenom, int age )
    {
        setPrenom( prenom );
        setNom( nom );
        setAge( age );
    }
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    public
    String getPrenom()
    {
        return prenom;
    }

    public
    void setPrenom( String prenom )
    {
        this.prenom = prenom;
    }

    public
    String getNom()
    {
        return nom;
    }

    public
    void setNom( String nom )
    {
        this.nom = nom;
    }

    public
    int getAge()
    {
        return age;
    }

    public
    void setAge( int age )
    {
        if ( age > 0 && age < 150 )
        {
            this.age = age;
        }
    }
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                       REDEFINITION DE TOSTRING()             */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    @Override
    public
    String toString()
    {
        return String.format( "Etudiant : %s %s %d ans", this.getNom(), this.getPrenom(), this.getAge() );
    }

    public
    String toStringShort()
    {
        return String.format( "%s %s", this.getPrenom(), this.getNom() );
    }
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*             REDEFINITION DE EQUALS() & HASHCODE()            */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    @Override
    public
    boolean equals( Object obj )
    {
        // Test si même instance
        if ( this == obj )
        {
            return true;
        }

        // Test si même classe et si obj non null
        if ( obj == null || obj.getClass() != this.getClass() )
        {
            return false;
        }

        // Cast en class étudiant
        Etudiant toCompare = ( Etudiant ) obj;

        // Test de comparaison
        return ( toCompare.getAge() == this.age ) && ( toCompare.getNom().trim().equalsIgnoreCase( this.getNom() ) ) &&
               ( toCompare.getPrenom().trim().equalsIgnoreCase( this.getPrenom() ) );
    }

    @Override
    public
    int hashCode()
    {
        int result = 17;

        result = 31 * result + this.prenom.toLowerCase().hashCode();
        result = 31 * result + this.nom.toLowerCase().hashCode();
        result = 31 * result + age;

        return result;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
}
