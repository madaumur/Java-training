package fr.afpa.controller;

import fr.afpa.contact.Contact;
import fr.afpa.contact.ContactUtils;
import fr.afpa.utils.Tools;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Le controller de la Vue contact_form (Formulaire d'ajout de contact)
 */
public
class ControllerrVueContactForm
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                     ELEMENT D'INTERFACE                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField fieldMail;

    @FXML
    private TextField fieldNom;

    @FXML
    private TextField fieldPrenom;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                    GESTIONNAIRE D'EVENEMENTS                 */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Gestion des evenements de type Clavier pour les text-field → déclenche la méthode showBtnAjouter()
     */
    EventHandler< KeyEvent > keyEventInField = event -> showAddBtn();

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Action lorsque l'on appuie sur le bouton 'Ajouter' → si ok, ajoute le nouveau contact dans la liste et dans le .csv
     */
    @FXML
    private
    void onAddBtn()
    {
        String[] contact = new String[ 3 ];

        if ( ( fieldPrenom.getText().trim().length() > 0 ) && ( fieldNom.getText().trim().length() > 0 ) &&
             ( fieldMail.getText().trim().length() > 0 ) )
        {
            contact[ 0 ] = fieldPrenom.getText().trim();
            contact[ 1 ] = fieldNom.getText().trim();
            contact[ 2 ] = fieldMail.getText().trim();

            ContactUtils.addContactToList( new Contact( contact ) );
            ContactUtils.addContactToCSV( new Contact( contact ) );
        }

        onCancelBtn();
    }

    /**
     * Action lorsque l'on appuie sur le bouton 'Annuler'
     */
    @FXML
    private
    void onCancelBtn()
    {
        Stage stage = ( Stage ) btnCancel.getScene().getWindow();
        stage.close();
    }

    /**
     * Méthode qui enable le bouton 'Ajouter' si les trois champs texte sont non vide. Disable le bouton sinon.
     */
    @FXML
    private
    void showAddBtn()
    {
        btnAdd.setDisable(
                fieldPrenom.getText().isEmpty() || fieldNom.getText().isEmpty() || fieldMail.getText().isEmpty() );
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
        fieldPrenom.addEventHandler( KeyEvent.ANY, keyEventInField );
        fieldNom.addEventHandler( KeyEvent.ANY, keyEventInField );
        fieldMail.addEventHandler( KeyEvent.ANY, keyEventInField );

        fieldMail.setText( Tools.getAdrMailTemp() );
        Tools.setAdrMailTemp( "" );
    }
}
