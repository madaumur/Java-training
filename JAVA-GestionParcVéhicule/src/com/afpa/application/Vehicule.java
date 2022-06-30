package com.afpa.application;

import com.afpa.exception.PanneEssenceException;
import com.afpa.exception.PleinNegatif;

abstract
class Vehicule
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private final String marque;
    private final String modele;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur de la classe véhicule
     *
     * @param marque La marque du véhicule
     * @param modele Le modèle du véhicule
     */
    protected
    Vehicule ( String marque, String modele )
    {
        this.marque = marque;
        this.modele = modele;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * getter sur la marque du véhicule
     *
     * @return Retourne la marque du véhicule
     */
    public
    String getMarque ()
    {
        return marque;
    }

    /**
     * getter sur le modèle du véhicule
     *
     * @return Retourne le modèle du véhiculé
     */
    public
    String getModele ()
    {
        return modele;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                       REDEFINITION DE TOSTRING()             */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Redefinition de toString()
     *
     * @return Une présentation du véhicule avec sa marque et son modèle
     */
    @Override
    public
    String toString ()
    {
        return String.format ( "Vehicule %s %s", getMarque (), getModele () );
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * METHODE ABSTRAITE → démarrer le véhicule
     */
    abstract
    void demarrer ();

    /**
     * METHODE ABSTRAITE → arrêter le véhicule
     */
    abstract
    void arreter ();

    /**
     * METHODE ABSTRAITE → faire le plein du véhicule
     *
     * @param volumeAjoute Le volume d'essence à ajouter au reservoir
     * @throws PleinNegatif Peut lever une exception si le volume est négatif
     */
    abstract
    void faireLePlein ( float volumeAjoute ) throws PleinNegatif;

    /**
     * METHODE ABSTRAITE → faire rouler le véhicule
     *
     * @param volumeConsommation La consommation attendue pour le trajet
     * @throws PanneEssenceException Peut lever une exception si on pense consommer plus qu'il n'y a dans le reservoir
     */
    abstract
    void rouler ( float volumeConsommation ) throws PanneEssenceException;
}
