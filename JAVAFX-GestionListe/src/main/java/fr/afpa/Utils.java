package fr.afpa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

/**
 * Classe d'outils pour notre application
 */
public
class Utils
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Constructeur privé
     */
    private
    Utils()
    {
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Fonction de remplissage de la ChoiceBox à partir des valeurs de l'énumération
     *
     * @param box → La choiceBox à remplir
     */
    public static
    void fillChoicebox( ChoiceBox< Pays > box )
    {
        ObservableList< Pays > enumPays = FXCollections.observableArrayList( Pays.values() );

        box.setItems( enumPays );
    }

    /**
     * Fonction qui remplie la ListView avec toutes les valeurs de la ChoiceBox
     * (ici on récup directement les valeurs de l'enum, donc potentiel TODO)
     *
     * @param list → La liste à remplir avec les item de la ChoiceBox
     */
    public static
    void fillListView( ListView< Pays > list )
    {
        ObservableList< Pays > enumPays = FXCollections.observableArrayList( Pays.values() );

        list.getItems().addAll( enumPays );
    }

    /**
     * Fonction de vidage de la ListView.
     * (supprime tout les éléments)
     *
     * @param list → La liste à vider de ses items
     */
    public static
    void clearListView( ListView< Pays > list )
    {
        list.getItems().clear();
    }

    /**
     * Fonction pour rajouter un item de la ChoiceBox à la ListView
     * Ici on récupère l'élément selectionné, et on l'ajoute à la liste s'il n'est pas null
     *
     * @param box  → La ChoiceBox dans laquelle on va récupérer element à ajouter
     * @param list → La liste à remplir avec l'item de la ChoiceBox
     */
    public static
    void addInListView( ChoiceBox< Pays > box, ListView< Pays > list )
    {
        if ( box.getValue() != null )
        {
            list.getItems().add( box.getValue() );
        }
    }

    /**
     * Fonction pour supprimer un element selectionné de la liste
     *
     * @param list → La liste dans laquelle on veut suppr l'élément selectionné
     */
    public static
    void rmInListView( ListView< Pays > list )
    {
        list.getItems().remove( list.getSelectionModel().getSelectedItem() );
    }

    /**
     * Fonction pour déplacer un élément de la list selectionné vers une place au-dessus si cela est possible
     *
     * @param list → La liste dans laquelle on a select l'élément à monter
     */
    public static
    void up( ListView< Pays > list )
    {
        if ( list.getSelectionModel().getSelectedIndex() > 0 )
        {
            int index = list.getSelectionModel().getSelectedIndex();

            Pays actual = list.getSelectionModel().getSelectedItem();
            Pays prec   = list.getItems().get( index - 1 );

            list.getItems().set( index, prec );
            list.getItems().set( index - 1, actual );

            list.getSelectionModel().select( index - 1 );
        }
    }

    /**
     * Fonction pour déplacer un élément de la list selectionné vers une place en dessous si cela est possible
     *
     * @param list → La liste dans laquelle on a select l'élément à descendre
     */
    public static
    void down( ListView< Pays > list )
    {
        if ( list.getSelectionModel().getSelectedIndex() < ( list.getItems().size() - 1 ) )
        {
            int index = list.getSelectionModel().getSelectedIndex();

            Pays actual = list.getSelectionModel().getSelectedItem();
            Pays suiv   = list.getItems().get( index + 1 );

            list.getItems().set( index, suiv );
            list.getItems().set( index + 1, actual );

            list.getSelectionModel().select( index + 1 );
        }
    }
}
