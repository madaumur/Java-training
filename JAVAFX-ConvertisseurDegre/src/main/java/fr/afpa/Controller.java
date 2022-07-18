package fr.afpa;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static fr.afpa.Utils.*;
import static java.lang.Double.parseDouble;

public
class Controller
{
    @FXML
    private Label affichageFinal;
    @FXML
    private TextField saisi;
    @FXML
    private CheckBox case1;
    @FXML
    private CheckBox case2;

    @FXML
    protected
    void onHelloButtonClick()
    {
        String saisiUser = saisi.getText();

        try
        {
            Double tempToConvert = parseDouble( saisiUser );

            if ( case1.isSelected() && ! case2.isSelected() )
            {
                affichageFinal.setText( String.format( "%.2f %s", ( convertToFar( tempToConvert ) ), "°F" ) );
            }
            else if ( ! case1.isSelected() && case2.isSelected() )
            {
                affichageFinal.setText( String.format( "%.2f %s", ( convertToCels( tempToConvert ) ), "°C" ) );
            }
            else
            {
                affichageFinal.setText( "Impossible" );
            }
        }
        catch ( Exception e )
        {
            System.out.println( "Erreur" + e );
            affichageFinal.setText( "Impossible" );
        }
    }
}