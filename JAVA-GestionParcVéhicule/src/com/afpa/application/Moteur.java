package com.afpa.application;

import com.afpa.exception.PanneEssenceException;
import com.afpa.exception.PleinNegatif;


public
class Moteur
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private final float tailleReservoir;
    private float qteEssenceReservoir;
    private float qteEssenceCumule;
    private boolean demarre;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur de la classe Moteur
     * Par default, le moteur sera éteint, le reservoir sera vide.
     *
     * @param tailleReservoir Capacité du reservoir
     */
    public
    Moteur ( float tailleReservoir )
    {
        this.tailleReservoir     = tailleReservoir;
        this.qteEssenceReservoir = 0;
        this.demarre             = false;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * getter sur la quantité d'essence ajouté cumulée
     *
     * @return Retourne la quantité d'essence ajoutée cumulée
     */
    public
    float getQteEssenceCumule ()
    {
        return qteEssenceCumule;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                       REDEFINITION DE TOSTRING()             */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Redefinition de toString()
     *
     * @return Une présentation du moteur son état et la quantité d'essence restante par rapport au reservoir
     */
    @Override
    public
    String toString ()
    {
        String etat;
        if ( demarre )
        {
            etat = "en marche";
        }
        else
        {
            etat = "a l'arret";
        }

        return String.format ( "Le moteur est %s et il reste %2.2f / %2.2f litres d'essence", etat,
                               this.qteEssenceReservoir, this.tailleReservoir );
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Démarrage du véhicule s'il est à l'arrêt + s'il contient + de 0.1L d'essence. Sinon rien
     */
    void demarrer ()
    {
        if ( !demarre && this.qteEssenceReservoir > 0.1 )
        {
            demarre = true;
            this.qteEssenceReservoir -= 0.1;
        }
    }

    /**
     * Arrêt du véhicule s'il est en marche. Sinon rien
     */
    void arreter ()
    {
        if ( demarre )
        {
            demarre = false;
        }
    }

    /**
     * Faire le plein du véhicule : Si on ajoute un volume positif (ou nul) d'essence,
     * On ajoute ce volume à la quantité d'essence dans le reservoir + quantité essence cumulé
     * (Si le volume ajouté est supérieur à la taille du reservoir on considère que le plein est fait)
     *
     * @param volumeAjoute Le volume d'essence à ajouter au reservoir.
     * @throws PleinNegatif Peut lever une exception si le volume est négatif
     */
    protected
    void faireLePlein ( float volumeAjoute ) throws PleinNegatif
    {
        if ( volumeAjoute >= 0 )
        {
            if ( this.qteEssenceReservoir + volumeAjoute <= this.tailleReservoir )
            {
                this.qteEssenceCumule += volumeAjoute;
                this.qteEssenceReservoir += volumeAjoute;
            }
            else
            {
                this.qteEssenceCumule += this.tailleReservoir - this.qteEssenceReservoir;
                this.qteEssenceReservoir = this.tailleReservoir;
            }
        }
        else
        {
            throw new PleinNegatif ( "La valeur du plein doit etre positive." );
        }
    }

    /**
     * Utiliser le moteur pour faire un trajet.
     * On vérifie si le moteur est démarré et s'il contient assez d'essence.
     *
     * @param volumeConsommation la qté d'essence que doit consommer le trajet
     * @throws PanneEssenceException Peut lever une exception si consommation du trajet > volumeReservoir
     */
    void utiliser ( float volumeConsommation ) throws PanneEssenceException
    {
        if ( ( demarre && volumeConsommation <= this.qteEssenceReservoir ) ||
             ( !demarre && volumeConsommation <= ( this.qteEssenceReservoir + 0.1 ) ) )
        {
            System.out.printf ( "La trajet doit prendre %2.2f litres ---> Il restera %2.2f litres%n",
                                volumeConsommation, this.qteEssenceReservoir - volumeConsommation );

            this.qteEssenceReservoir -= volumeConsommation;
        }
        else
        {
            this.qteEssenceReservoir = 0;
            this.demarre             = false;
            throw new PanneEssenceException ( "Panne d'essence" );
        }
    }
}
