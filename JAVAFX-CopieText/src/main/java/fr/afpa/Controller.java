package fr.afpa;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public
class Controller
{
    @FXML
    private TextField saisi;
    @FXML
    private Label texteCopie;

    // Bouton recopier → quand on clique dessus
    @FXML
    protected
    void onRecopierButtonClick()
    {
        texteCopie.setText( saisi.getText() );
    }

    // Bouton recopier → quand on fait "Entrer" dessus
    @FXML
    protected
    void onRecopierButtonEnter( KeyEvent e )
    {
        if ( e.getCode().equals( KeyCode.ENTER ) )
        {
            texteCopie.setText( saisi.getText() );
        }
    }

    // Bouton effacer → quand on clique dessus
    @FXML
    protected
    void onEffacerButtonClick()
    {
        saisi.setText( "" );
        texteCopie.setText( "" );
    }

    // Bouton effacer → quand on fait "Entrer" dessus
    @FXML
    protected
    void onEffacerButtonEnter( KeyEvent e )
    {
        if ( e.getCode().equals( KeyCode.ENTER ) )
        {
            saisi.setText( "" );
            texteCopie.setText( "" );
        }
    }

    // Bouton quitter → quand on clique dessus
    @FXML
    protected
    void onQuitterButtonClick()
    {

        Platform.exit();
    }

    // Bouton quitter → quand on fait "Entrer" dessus
    @FXML
    protected
    void onQuitterButtonEnter( KeyEvent e )
    {
        if ( e.getCode().equals( KeyCode.ENTER ) )
        {
            Platform.exit();
        }
    }
}