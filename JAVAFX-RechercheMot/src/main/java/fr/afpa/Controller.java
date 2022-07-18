package fr.afpa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static fr.afpa.Utils.getrecherche;
import static fr.afpa.Utils.nbOccurence;


public
class Controller
{
    @FXML
    private TextField txtPhrase1;
    @FXML
    private TextField txtPhrase2;
    @FXML
    private TextField txtPhrase3;
    @FXML
    private TextField lettreRecherche;

    @FXML
    private CheckBox chkPhrase1;
    @FXML
    private CheckBox chkPhrase2;
    @FXML
    private CheckBox chkPhrase3;

    @FXML
    private Label resultat;

    @FXML
    private Button rechercher;

    @FXML
    protected
    void onButton()
    {
        char recherche = getrecherche( lettreRecherche );

        int result = 0;

        if ( chkPhrase1.isSelected() )
        {
            result += nbOccurence( recherche, txtPhrase1.getText().trim() );
        }
        if ( chkPhrase2.isSelected() )
        {
            result += nbOccurence( recherche, txtPhrase2.getText().trim() );
        }
        if ( chkPhrase3.isSelected() )
        {
            result += nbOccurence( recherche, txtPhrase3.getText().trim() );
        }

        resultat.setText( "Nb occurences : " + result );
    }

    @FXML
    protected
    void limitChar()
    {
        if ( lettreRecherche.getText().length() > 1 )
        {
            lettreRecherche.setText( String.valueOf( lettreRecherche.getText().charAt( 1 ) ) );
            lettreRecherche.end();

            onButton();
        }
    }
}