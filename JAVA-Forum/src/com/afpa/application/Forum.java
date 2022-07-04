package com.afpa.application;

import java.util.ArrayList;
import java.util.Date;

import static com.afpa.outil.Affichage.informativeWindow;
import static com.afpa.outil.Affichage.questionWindow;

class Forum implements IForumAbonne, IForumModerateur
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    String nom;
    Date dateCreation;
    ArrayList< Nouvelle > listNouvelle = new ArrayList<>();
    ArrayList< Abonne > listAbonne = new ArrayList<>();

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur de la classe forum, assigne la date d'aujourd'hui pour la création
     *
     * @param nom Le nom du forum
     */
    protected
    Forum( String nom )
    {
        setNom( nom );
        this.dateCreation = new Date();
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * getter sur le nom du forum
     *
     * @return Le nom du forum en String
     */
    public
    String getNom()
    {
        return nom;
    }

    /**
     * Setter pour le nom du forum, vérifie qu'il n'est pas nul et met en lower case
     *
     * @param nom Le nom à donner au forum
     */
    protected
    void setNom( String nom )
    {
        if ( ! ( nom.equals( "" ) ) )
        {
            this.nom = nom.trim().toUpperCase();
        }
    }

    /**
     * getter sur la liste des nouvelles qui renvoie l'index d'une nouvelle passée en paramètre
     *
     * @param nouvelle La nouvelle à rechercher dans la liste des nouvelles pour récupérer son index
     *
     * @return L'index de position de la nouvelle
     */
    public
    int getIndex( Nouvelle nouvelle )
    {
        return listNouvelle.indexOf( nouvelle );
    }
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                    REDEFINITION DE TOSTRING()                */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Redefinition de toString()
     *
     * @return Une présentation du forum avec nom et date de création sous forme de String
     */
    @Override
    public
    String toString()
    {
        return String.format( "Le forum '%s' a été créé le '%2$td %2$tB %2$tY'%n", nom, dateCreation );
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Permet d'afficher une liste des messages présents sur le forum.
     * Fait appel à toStrong() de Nouvelle
     */
    protected
    void listerMessages()
    {
        StringBuilder strListeMessage = new StringBuilder();

        for ( Nouvelle nouvelle : listNouvelle )
        {
            strListeMessage.append( nouvelle.toString() ).append( "\n" );
        }

        informativeWindow( String.format( "Liste messages :%n%n%s", strListeMessage ), "liste_message" );
    }

    /*  -  Implémentation des droits abonnés    -   -   -   -   -   */

    /**
     * Ajoute une nouvelle à la liste-stockage du forum
     *
     * @param nouvelle La nouvelle à ajouter au stockage du forum
     */
    @Override
    public
    void ajouterNouvelle( Nouvelle nouvelle )
    {
        this.listNouvelle.add( nouvelle );
    }

    /**
     * Permet de consulter situé à 'index' dans la liste-stockage du forum
     *
     * @param index l'index de la nouvelle à afficher
     *
     * @return La nouvelle située à l'index
     */
    @Override
    public
    Nouvelle consulterNouvelle( int index )
    {
        return listNouvelle.get( index );
    }

    /**
     * Créé une nouvelle dans la liste-stockage du forum en réponse à celle située à Index
     * Le titre sera donc le même.
     *
     * @param index  La position de la nouvelle d'origine à laquelle on souhaite répondre
     * @param auteur L'auteur de la réponse pour la création de la nouvelle-réponse
     */
    @Override
    public
    void repondreNouvelle( int index, Personne auteur )
    {
        if ( listAbonne.contains( auteur ) )
        {
            this.listNouvelle.add( new Nouvelle( this.listNouvelle.get( index ).sujet, questionWindow(
                    String.format( "Entrer votre réponse au sujet '%s'.", this.listNouvelle.get( index ).sujet ),
                    "votre_réponse" ), auteur ) );
        }
        else
        {
            System.out.printf( "L'auteur %s n'est pas membre du forum %s%n", auteur.toStringShort(), this.nom );
        }
    }

    /*  -  Implémentation des droits modérateur -   -   -   -   -   */

    /**
     * Supprime la nouvelle passée en paramètre de la liste-stockage du forum
     *
     * @param nouvelle La nouvelle à supprimer
     */
    @Override
    public
    void supprimerNouvelle( Nouvelle nouvelle )
    {
        this.listNouvelle.remove( nouvelle );
    }

    /**
     * Permet de bannir un abonné du forum
     * pour cela, lui supprime son attribut forum et le supprime de la liste-stockage des abonnés du forum
     *
     * @param abonne L'abonné à bannir
     */
    @Override
    public
    void bannirUnAbonne( Abonne abonne )
    {
        if ( listAbonne.contains( abonne ) )
        {
            System.out.printf( "L'abonne %s a ete banni..%n", abonne.toStringShort() );
            abonne.setForum( null );
            abonne.avertissement = 0;
            this.listAbonne.remove( abonne );
        }
        else
        {
            System.out.printf( "L'abonne %s n'est pas membre du forum %s%n", abonne.toStringShort(), this.nom );
        }
    }

    @Override
    public
    void avertirUnAbonne( Abonne abonne )
    {
        if ( listAbonne.contains( abonne ) )
        {
            abonne.avertissement += 1;
            System.out.printf( "L'abonne %s a ete averti. Ca lui fait %d avertissement(s)%n", abonne.toStringShort(),
                               abonne.avertissement );
            if ( abonne.avertissement > 2 )
            {
                bannirUnAbonne( abonne );
            }
        }
        else
        {
            System.out.printf( "L'abonne %s n'est pas membre du forum %s%n", abonne.toStringShort(), this.nom );
        }
    }

    /**
     * Ajouter un abonné au forum
     *
     * @param abonne L'abonné à ajouter au forum
     *
     * @return L'index de position de l'abonné dans la liste-stockage des abonnés du forum, -1 si échec
     */
    @Override
    public
    int ajouterAbonne( Abonne abonne )
    {
        if ( ! ( listAbonne.contains( abonne ) ) )
        {
            this.listAbonne.add( abonne );
            abonne.forum = this;
            return this.listAbonne.indexOf( abonne );
        }
        else
        {
            System.out.printf( "L'abonne %s est deja membre du forum %s%n", abonne.toStringShort(), this.nom );
            return - 1;
        }
    }

    /**
     * Affichage des abonnées du forum via le toStringShort d'abonné
     */
    @Override
    public
    void listerAbonnes()
    {
        StringBuilder strListeAbonne = new StringBuilder();

        for ( Abonne abonne : listAbonne )
        {
            strListeAbonne.append( abonne.toStringShort() ).append( "\n" );
        }

        informativeWindow( String.format( "Les abonnés sont :%n%n%s", strListeAbonne ), "liste_abonnés" );
    }
}
