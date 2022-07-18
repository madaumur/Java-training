package fr.afpa.controller;

import fr.afpa.utils.Tools;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Le controller de la Vue new (Demande confirmation si demande de nouveau mail alors qu'un mail est en cours)
 */
public
class ControllerVueNew
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                     ELEMENT D'INTERFACE                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnConfirm;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Action lorsque l'on appuie sur le bouton 'Annuler'
     */
    @FXML
    void onCancelBtn()
    {
        Stage stage = ( Stage ) btnCancel.getScene().getWindow();
        stage.close();
    }

    /**
     * Action lorsque l'on appuie sur le bouton 'Confirmer' → Ferme le programme
     */
    @FXML
    void onConfirmBtn()
    {
        Tools.setNewMailIsConfirmed( true );
        onCancelBtn();
    }
}