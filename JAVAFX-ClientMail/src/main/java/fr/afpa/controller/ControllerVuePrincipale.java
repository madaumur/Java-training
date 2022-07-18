package fr.afpa.controller;

import fr.afpa.contact.Contact;
import fr.afpa.contact.ContactList;
import fr.afpa.mail.Mail;
import fr.afpa.mail.MailUtils;
import fr.afpa.utils.Tools;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import static fr.afpa.WindowManager.generateVue;
import static fr.afpa.utils.Tools.*;

/**
 * Le controller de la Vue Principale
 */
public
class ControllerVuePrincipale
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                     ELEMENT D'INTERFACE                      */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    @FXML
    private Button btnBackSend;

    @FXML
    private Button btnMainNew;

    @FXML
    private Button btnMainOpen;

    @FXML
    private Button btnMainSend;

    @FXML
    private MenuItem btnMenuNew;

    @FXML
    private MenuItem btnMenuOpen;

    @FXML
    private MenuItem btnMenuQuit;

    @FXML
    private MenuItem btnMenuSend;

    @FXML
    private TextField textObjet;

    @FXML
    private TextArea textMessage;

    @FXML
    private ComboBox< Contact > cmboxContact;

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                    GESTIONNAIRE D'EVENEMENTS                 */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Gestion des evenements de type Clavier pour textObjet → déclenche la méthode checkField()
     */
    EventHandler< KeyEvent > keyEventTextObjet = keyEvent -> showSendBtn();

    /**
     * Gestion des evenements de type Clavier pour textMessage → déclenche la méthode checkField() & isTextAreaEmpty
     */
    EventHandler< KeyEvent > keyEventTextMessage = keyEvent ->
    {
        showSendBtn();
        isTextAreaEmpty();
    };

    /**
     * Gestion des evenements de type Clavier pour combobox → déclenche la méthode checkField()
     */
    EventHandler< KeyEvent > keyEventCmbox = keyEvent -> showSendBtn();

    /**
     * Gestion des evenements de type Action pour combobox → déclenche la méthode checkField()
     */
    EventHandler< ActionEvent > actionEventCmbox = actionEvent -> showSendBtn();


    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Action lorsque l'on clique sur le bouton 'Nouveau'
     */
    @FXML
    protected
    void onNewBtn()
    {
        if ( ! getTextAreaIsEmpty() )
        {
            generateVue( "vue_new", "nouveau_mail?", true );
            if ( getNewMailIsConfirmed() )
            {
                clearAllField();
                setNewMailIsConfirmed( false );
            }
        }
        else
        {
            clearAllField();
        }
    }

    /**
     * Action lorsque l'on clique sur le bouton 'Ouvrir'
     */
    @FXML
    protected
    void onOpenBtn()
    {
        generateVue( "vue_mail_selection", "Selectionner_un_email?", true );

        if ( Tools.getRepOpenMail() )
        {
            textObjet.setText( getMailTemp().getObjet() );
            textMessage.setText( getMailTemp().getMessage() );
            cmboxContact.getEditor().setText( getMailTemp().getDestinataire() );

            setMailTemp( null );
        }

        isTextAreaEmpty();
        showSendBtn();
    }

    /**
     * Action lorsque l'on clique sur le bouton 'Quitter'
     */
    @FXML
    protected
    void onQuitBtn()
    {
        onCloseAction();
    }

    /**
     * Action lorsque l'on clique sur le bouton 'Envoyer'
     */
    @FXML
    protected
    void onSendBtn()
    {
        String[] mail = new String[ 3 ];

        if ( ( textMessage.getText().trim().length() > 0 ) && ( textObjet.getText().trim().length() > 0 ) &&
             ( cmboxContact.getEditor().getText().trim().length() > 0 ) )
        {
            String[] sublist = cmboxContact.getEditor().getText().split( " " );

            mail[ 0 ] = sublist[ sublist.length-1 ].replace( "<", "" ).replace( ">", "" );
            mail[ 1 ] = textObjet.getText().trim();
            mail[ 2 ] = textMessage.getText().trim();

            System.out.println( new Mail( mail ) );
            MailUtils.addMailToList( new Mail( mail ) );
            MailUtils.addMailToCSV( new Mail( mail ) );
        }

        clearAllField();
    }

    /**
     * Action lorsque l'on fait Entrer dans la combobox → ouverture de la Vue contact_form
     */
    @FXML
    protected
    void enterOnComboBox( KeyEvent event )
    {
        if ( event.getCode().equals( KeyCode.ENTER ) )
        {
            Tools.setAdrMailTemp( cmboxContact.getEditor().getText() );
            generateVue( "vue_contact_form", "ajout_de_contact", true );
            refreshComboBox();
        }
    }

    /**
     * Action lorsque l'on clique sur le bouton 'À propos' → ouverture de la Vue info
     */
    @FXML
    protected
    void onInfoBtn()
    {
        generateVue( "vue_info", "a_propos" );
    }

    /**
     * Méthode qui enable le bouton 'Envoyer' si les champs texte sont non vide + combobox. Disable le bouton sinon.
     */
    @FXML
    private
    void showSendBtn()
    {
        boolean setVisible = ( textObjet.getText().isEmpty() || textMessage.getText().isEmpty() ||
                               cmboxContact.getEditor().getText().isEmpty() );

        btnMainSend.setDisable( setVisible );
        btnBackSend.setDisable( setVisible );
        btnMenuSend.setDisable( setVisible );
    }

    /**
     * Méthode qui actualise les elements dans la combobox depuis la liste de contact
     */
    @FXML
    private
    void refreshComboBox()
    {
        cmboxContact.getItems().clear();
        cmboxContact.getItems().addAll( ContactList.getContactList() );
        cmboxContact.getItems().sorted();
    }

    /**
     * Methode qui transmet l'état de champs TextArea hors du controller (vide/non vide)
     */
    @FXML
    private
    void isTextAreaEmpty()
    {
        setTextAreaIsEmpty( textMessage.getText().isBlank() );
    }

    /**
     * Méthode qui efface tous les champs text
     */
    @FXML
    private
    void clearAllField()
    {
        textMessage.clear();
        textObjet.clear();
        cmboxContact.getEditor().clear();

        isTextAreaEmpty();
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
        btnMainSend.setDisable( true );
        btnBackSend.setDisable( true );
        btnMenuSend.setDisable( true );
        cmboxContact.setEditable( true );

        textObjet.addEventHandler( KeyEvent.ANY, keyEventTextObjet );
        textMessage.addEventHandler( KeyEvent.ANY, keyEventTextMessage );

        cmboxContact.addEventHandler( KeyEvent.ANY, keyEventCmbox );
        cmboxContact.addEventHandler( ActionEvent.ANY, actionEventCmbox );

        refreshComboBox();
        isTextAreaEmpty();
    }
}

