package com.afpa.application;

public
class PileEntier
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    private Maillon debutListe;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    public
    PileEntier()
    {
        debutListe = null;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Fonction empiler : rajoute un élément -valeur- à la pile.
     * Pour cela, le dernier maillon actuel va pointer vers un nouveau maillon dont la valeur sera celle rentrée.
     *
     * @param valeur La valeur que contiendra le dernier maillon
     */
    protected
    void empiler( int valeur )
    {
        Maillon maillonActuel = this.debutListe;

        if ( maillonActuel == null ) // Condition si la liste est vide
        {
            this.debutListe = new Maillon( valeur );
        }
        else
        {
            while ( maillonActuel.getSuivant() != null ) // Parcours de la pile jusqu'au dernier maillon
            {
                maillonActuel = maillonActuel.getSuivant();
            }

            maillonActuel.setSuivant( new Maillon( valeur ) );
        }
    }

    /**
     * Fonction dépiler : retire le dernier élément de la pile et renvoie la valeur qu'il contenait.
     * Pour cela, on parcourt la liste jusqu"a l'avant-dernier maillon, on récupère le contenu du dernier maillon et
     * on déréférence le dernier maillon de l'avant-dernier.
     *
     * @return L'entier contenu dans le dernier maillon qui sera dépilé.
     */
    protected
    int depiler()
    {
        Maillon maillonActuel = this.debutListe;
        int     valeur;

        if ( maillonActuel == null ) // Condition si la liste est vide
        {
            throw new IllegalArgumentException( "Impossible de dépiler une pile déjà vide." );
        }
        else if ( maillonActuel.getSuivant() == null ) // Condition s'il n'y a qu'un maillon
        {
            valeur     = maillonActuel.getValeur();
            debutListe = null;
        }
        else
        {
            while ( maillonActuel.getSuivant().getSuivant() !=
                    null ) // Parcours de la pile jusqu'à l'avant-dernier maillon
            {
                maillonActuel = maillonActuel.getSuivant();
            }

            valeur = maillonActuel.getSuivant().getValeur(); // On récupère la valeur du dernier maillon
            maillonActuel.setSuivant( null ); // On déréférence le dernier de l'avant-dernier
        }
        return valeur;
    }

    /**
     * Fonction pour transformer la pile en String affichable de tous les maillons.
     *
     * @return la String du contenu de la pile
     */
    protected
    String pileToString()
    {
        Maillon maillonActuel = this.debutListe;
        String  pile          = "";
        boolean isCorrect     = false;

        if ( maillonActuel == null )
        {
            throw new IllegalArgumentException( "Impossible d'afficher une pile vide." );
        }
        else
        {
            while ( ! isCorrect )
            {
                pile = "%s%s".formatted( String.format( "|%d|%n", maillonActuel.getValeur() ), pile );
                if ( maillonActuel.getSuivant() != null )
                {
                    maillonActuel = maillonActuel.getSuivant();
                }
                else
                {
                    isCorrect = true;
                }
            }
        }

        pile = "%s%s".formatted( String.format( "Voici le contenu de la pile:%n" ), pile );
        return pile;
    }
}
