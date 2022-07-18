package fr.afpa;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;

import static javafx.scene.paint.Color.*;

public
class Controller
{
    @FXML
    private CheckBox checkbox_modif;

    @FXML
    private Pane color_pane;

    @FXML
    private RadioButton modif_aucune;

    @FXML
    private RadioButton modif_bleu;

    @FXML
    private RadioButton modif_rouge;

    @FXML
    private RadioButton modif_vert;


    @FXML
    protected
    void onCheckBlue()
    {
        if ( checkbox_modif.isSelected() )
        {
            color_pane.setBackground(
                    new Background( new BackgroundFill( LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY ) ) );
        }
    }

    @FXML
    protected
    void onCheckVert()
    {
        if ( checkbox_modif.isSelected() )
        {
            color_pane.setBackground(
                    new Background( new BackgroundFill( LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY ) ) );
        }
    }

    @FXML
    protected
    void onCheckRouge()
    {
        if ( checkbox_modif.isSelected() )
        {
            color_pane.setBackground(
                    new Background( new BackgroundFill( LIGHTCORAL, CornerRadii.EMPTY, Insets.EMPTY ) ) );
        }
    }

    @FXML
    protected
    void onUnCheck()
    {
        if ( checkbox_modif.isSelected() )
        {
            color_pane.setBackground( null );
        }
    }

    @FXML
    protected
    void initialize()
    {
        modif_aucune.setSelected( true );
    }
}