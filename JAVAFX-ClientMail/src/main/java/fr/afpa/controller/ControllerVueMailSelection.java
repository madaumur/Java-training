package fr.afpa.controller;

import fr.afpa.mail.Mail;
import fr.afpa.mail.MailList;
import fr.afpa.utils.Tools;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * Le controller de la Vue mail_selection
 */
public
class ControllerVueMailSelection
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                     ELEMENT D'INTERFACE                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnConfirm;

    @FXML
    private ListView< Mail > listMail;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Action lorsque l'on appuie sur le bouton 'Annuler'
     */
    @FXML
    void onCancelBtn()
    {

        Tools.setRepOpenMail( false );
        Stage stage = ( Stage ) btnCancel.getScene().getWindow();
        stage.close();
    }

    /**
     * Action lorsque l'on appuie sur le bouton 'Confirmer' → Ferme le programme
     */
    @FXML
    void onConfirmBtn()
    {
        Tools.setRepOpenMail( true );
        Tools.setMailTemp( listMail.getSelectionModel().getSelectedItem() );
        Stage stage = ( Stage ) btnCancel.getScene().getWindow();
        stage.close();
    }

    /**
     * Méthode qui actualise les elements dans la combobox depuis la liste de contact
     */
    @FXML
    private
    void refreshListView()
    {
        listMail.getItems().clear();
        listMail.getItems().addAll( MailList.getMailList() );
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                            INITIALIZE                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Initialisation des éléments pour la fenêtre
     */
    @FXML
    protected
    void initialize()
    {
        refreshListView();
    }
}
