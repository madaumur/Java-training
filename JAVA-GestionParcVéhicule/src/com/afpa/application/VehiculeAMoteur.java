package com.afpa.application;

import com.afpa.exception.PanneEssenceException;
import com.afpa.exception.PleinNegatif;

public abstract
class VehiculeAMoteur extends Vehicule
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private final Moteur moteur;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur de la classe VehiculeAMoteur
     * Fait appelle au constructeur de la classe mère Vehicule.
     * Et rajoute un moteur.
     *
     * @param marque          Provient de la classe mère ( marque du véhicule )
     * @param modele          Provient de la classe mère ( modele du vehicule )
     * @param tailleReservoir Capacitié du reservoir à fournir au constructeur de moteur
     */
    protected
    VehiculeAMoteur ( String marque, String modele, float tailleReservoir )
    {
        super ( marque, modele );
        this.moteur = new Moteur ( tailleReservoir );
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                         GETTER / SETTER                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * getter sur le moteur du vehicule_à_moteur
     *
     * @return Retourne l'instance de moteur du véhicule
     */
    public
    Moteur getMoteur ()
    {
        return moteur;
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                       REDEFINITION DE TOSTRING()             */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Redefinition de toString()
     *
     * @return Une présentation du véhicule_à_moteur avec sa marque et son modèle
     * puis son type et fait appel à toString du moteur pour afficher ses caracteristiques
     */
    @Override
    public
    String toString ()
    {
        return String.format ( "Je etre %s %s, un vehicule de type '%s'%n%s", getMarque (), getModele (),
                               this.getClass ().getSimpleName ().toLowerCase (), moteur );
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Démmarage du véhicule. Appel de la méthode démarrer de moteur
     */
    void demarrer ()
    {
        this.moteur.demarrer ();
    }

    /**
     * Arrêt du véhicule. Appel de la méthode arreter de moteur
     */
    public
    void arreter ()
    {
        this.moteur.arreter ();
    }

    /**
     * Faire le plein du véhicule. Appelle les méthodes de moteur
     * En 3 étapes : arrêter - faire le plein - démarrer
     *
     * @param volumeAjoute Le volume d'essence à ajouter au reservoir. Passe dans faireLePlein()
     * @throws PleinNegatif Peut lever une exception si le volume est négatif
     */
    public
    void faireLePlein ( float volumeAjoute ) throws PleinNegatif
    {
        this.moteur.arreter ();
        this.moteur.faireLePlein ( volumeAjoute );
        this.moteur.demarrer ();
    }

    /**
     * Faire un trajet. Appel de la méthode utiliser de moteur
     *
     * @param volumeConsommation la qté d'essence que doit consommer le trajet
     * @throws PanneEssenceException Peut lever une exception si consommation du trajet > volumeReservoir
     */
    public
    void rouler ( float volumeConsommation ) throws PanneEssenceException
    {
        System.out.printf ( "%s : %n", super.toString () );
        this.moteur.utiliser ( volumeConsommation );
    }
}
