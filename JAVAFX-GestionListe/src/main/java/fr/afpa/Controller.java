package fr.afpa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

/**
 * Le Controller de notre fenêtre principale
 */
public
class Controller
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                     ELEMENT D'INTERFACE                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    @FXML
    private Button btnAddAll;

    @FXML
    private Button btnAddOne;

    @FXML
    private Button btnUp;

    @FXML
    private Button btnRmAll;

    @FXML
    private Button btnRmOne;

    @FXML
    private Button btnDown;

    @FXML
    private ChoiceBox< Pays > chceSource;

    @FXML
    private ListView< Pays > listCible;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Action lorsque l'on appuie sur le bouton [>>]
     * <p>
     * Ajoute tout les éléments de la liste de gauche dans celle de droite
     */
    @FXML
    private
    void onBtnAddAll()
    {
        Utils.fillListView( listCible );
    }

    /**
     * Action lorsque l'on appuie sur le bouton [<<]
     * <p>
     * Supprime tous les éléments de la liste de droite
     */
    @FXML
    private
    void onBtnRmAll()
    {
        Utils.clearListView( listCible );
    }

    /**
     * Action lorsque l'on appuie sur le bouton [>]
     * <p>
     * Ajoute l'élément en surbrillance dans la liste de gauche vers celle de droite
     */
    @FXML
    private
    void onBtnAddOne()
    {
        Utils.addInListView( chceSource, listCible );
    }

    /**
     * Action lorsque l'on appuie sur le bouton [<]
     * <p>
     * Supprime l'élément en surbrillance de la liste de droite
     */
    @FXML
    private
    void onBtnRmOne()
    {
        Utils.rmInListView( listCible );
    }

    /**
     * Action lorsque l'on appuie sur le bouton [↑]
     * <p>
     * Fait monter d'une place dans la liste l'élément en surbrillance (lorsque c'est possible)
     */
    @FXML
    private
    void onBtnUp()
    {
        Utils.up( listCible );
    }

    /**
     * Action lorsque l'on appuie sur le bouton [↓]
     * <p>
     * Fait descendre d'une place dans la liste l'élément en surbrillance (lorsque c'est possible)
     */
    @FXML
    private
    void onBtnDown()
    {
        Utils.down( listCible );
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                            INITIALIZE                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Initialisation des éléments pour la fenêtre
     */
    @FXML
    private
    void initialize()
    {
        Utils.fillChoicebox( chceSource );

        listCible.getSelectionModel().setSelectionMode( SelectionMode.SINGLE );
    }
}
