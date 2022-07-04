package com.afpa.application;

import com.afpa.outil.Grade;

class Moderateur extends Personne
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    IForumModerateur forum;
    Grade grade;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur de la classe modérateur.
     * Initialise de base du modérateur avec un grade 'MODERATEUR'
     *
     * @param prenom Le prénom du modérateur
     * @param nom    Le nom du modérateur
     * @param age    L'age du modérateur
     * @param forum  Le forum à assigner au moderateur
     */
    protected
    Moderateur( String prenom, String nom, int age, Forum forum )
    {
        super( prenom, nom, age );
        setForum( forum );
        this.grade = Grade.MODERATEUR;
    }

    /*
     *  Implémentation du constructeur possible sans forum, actuellement non utilisée
     *
     * @param prenom Le prénom du modérateur
     * @param nom Le nom du modérateur
     * @param age L'age du modérateur
     *
     * @deprecated
     *
     *
     *      protected
     *      Moderateur(String prenom, String nom, int age)
     *      {
     *          super(prenom, nom, age);
     *          this.forum = null;
     *          this.grade = Grade.MODERATEUR;
     *      }
     */

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Setter pour assigner un forum à l'abonné
     *
     * @param forum Le forum à assigner à l'objet modérateur
     */
    protected
    void setForum( Forum forum )
    {
        this.forum = forum;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                    REDEFINITION DE TOSTRING()                */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Redefinition de toString()
     *
     * @return Une présentation du modérateur sous forme de String
     */
    @Override
    public
    String toString()
    {
        if ( this.forum == null )
        {
            return String.format( "Je suis %s %s. J'ai %d et je suis %s et je nouvelle'ai pas de forum.", prenom, nom,
                                  age, grade.toString() );
        }
        else
        {
            return String.format( "Je suis %s %s. J'ai %d et je suis %s sur le forum %s.", prenom, nom, age,
                                  grade.toString(), forum.getNom() );
        }
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Ajouter un abonné au forum du modérateur
     *
     * @param abonne L'abonné à ajouter au forum du modérateur
     *
     * @return L'index auquel se trouve l'abonné dans la liste de stockage. (-1 si échec)
     */
    protected
    int ajouterAbonne( Abonne abonne )
    {
        if ( this.forum != null )
        {
            return forum.ajouterAbonne( abonne );
        }
        return - 1;
    }

    /**
     * Avertir un abonné sur le forum du modérateur
     *
     * @param abonne L'abonné à avertir sur le forum du modérateur
     */
    protected
    void avertirAbonne( Abonne abonne )
    {
        if ( this.forum != null )
        {
            forum.avertirUnAbonne( abonne );
        }
    }

    /**
     * Exclure un abonné du forum du modérateur
     *
     * @param abonne L'abonné à exclure au forum du modérateur
     */
    protected
    void exclureAbonne( Abonne abonne )
    {
        if ( this.forum != null )
        {
            forum.bannirUnAbonne( abonne );
        }
    }

    /**
     * Supprimer une nouvelle du forum du modérateur
     *
     * @param nouvelle La nouvelle à supprimer du forum
     */
    protected
    void supprimerNouvelle( Nouvelle nouvelle )
    {
        if ( this.forum != null )
        {
            forum.supprimerNouvelle( nouvelle );
        }
    }

    /**
     * Afficher une liste des abonnés
     */
    protected
    void afficherLesAbonnes()
    {
        if ( this.forum != null )
        {
            forum.listerAbonnes();
        }
    }
}
