package com.afpa;

import javax.swing.*;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public
class Outils
{
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             VARIABLES                        */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                           CONSTRUCTEUR                       */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    private
    Outils()
    {
    }

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                          GETTER / SETTER                     */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */
    /*                             METHODES                         */
    /*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   */

    /**
     * Demande d'un Entier par saisie utilisateur via une fenêtre.
     * Le parseInt lève une exception du type NumberFormatException s'il ne peut convertir la saisie en entier.
     *
     * @return La saisie clavier sous forme de (int).
     */
    protected static
    int askInt()
    {
        return parseInt(
                showInputDialog( null, "Entrer un entier", "demande_entier", JOptionPane.QUESTION_MESSAGE ).trim() );
    }

    /**
     * Demande d'un Float par saisie utilisateur via une fenêtre.
     * Le parseFloat lève une exception du type NumberFormatException s'il ne peut convertir la saisie en flottant.
     *
     * @return La saisie clavier sous forme de (float).
     */
    protected static
    float askFloat()
    {
        return parseFloat( showInputDialog( null, "Entrer un flottant", "demande_flottant",
                                            JOptionPane.QUESTION_MESSAGE ).trim() );
    }

    /**
     * Demande d'un Opérateur par saisi utilisateur via une fenêtre.
     * Le premier char de la saisie sera renvoyé. La verification de l'opérateur se fait dans le calcul.
     *
     * @return Le premier char de la saisie.
     */
    protected static
    char askOperator()
    {
        return showInputDialog( null, "Entrer l'operateur", "demande_operateur",
                                JOptionPane.QUESTION_MESSAGE ).trim().charAt( 0 );
    }

    /**
     * Méthode choisissant le calcul à effectuer en fonction de l'opérateur.
     * Si format non correct, une erreur sera levée.
     * La méthode propose l'affichage du résultat sous forme de fenêtre.
     *
     * @param number1  Le premier float pour l'opération.
     * @param number2  Le second float pour l'opération.
     * @param operator L'opérateur.
     *
     * @return Le résultat de l'opération (double)
     *
     * @throws CalculException Lorsque l'opérateur n'est pas reconnu
     */
    protected static
    double doCalcul( float number1, float number2, char operator ) throws CalculException
    {
        double result = switch ( operator )
                {
                    case '+' -> addition( number1, number2 );
                    case '-' -> soustraction( number1, number2 );
                    case '*' -> multiplication( number1, number2 );
                    case '/' -> division( number1, number2 );
                    default -> throw new CalculException( String.format( "L'operateur %s est inconnu", operator ) );
                };

        showMessageDialog( null, String.format( "Résultat : %.2f %c %.2f = %.2f", number1, operator, number2, result ),
                           "Résultat de l'opération", JOptionPane.INFORMATION_MESSAGE );

        return result;
    }

    /**
     * La méthode doFacto fait le calcul du factoriel d'un nombre. Elle affiche le résultat dans une fenêtre et le renvoi.
     * Par limite technique, nous ce nombre ne peut être supérieur à 20, car le résultat ne rentrerait plus dans un long.
     * De plus, nous ne pouvons faire le factoriel d'un nombre négatif.
     *
     * @param number Le nombre dont nous voulons calculer le factoriel
     *
     * @return Le résultat du calcul de factoriel (long)
     *
     * @throws CalculException Erreur si le nombre n'est pas dans [0;20]
     */
    protected static
    long doFacto( int number ) throws CalculException
    {
        long result = 1;

        if ( number < 0 || number > 20 )
        {
            throw new CalculException( "Le nombre doit être entre 0 et 20" );
        }
        else if ( number > 1 )
        {
            for ( int i = 2; i <= number; i++ )
            {
                result *= i;
            }
        }

        showMessageDialog( null, String.format( "Résultat : %d! = %d", number, result ), "Résultat de l'opération",
                           JOptionPane.INFORMATION_MESSAGE );

        return result;
    }

    /**
     * Fonction d'addition
     *
     * @param number1 Le premier float à addition.
     * @param number2 Le second float à addition.
     *
     * @return Le résultat de l'addition.
     */
    private static
    float addition( float number1, float number2 )
    {
        return ( number1 + number2 );
    }

    /**
     * Fonction de soustraction.
     *
     * @param number1 Le float à soustraire.
     * @param number2 Le float duquel on soustrait.
     *
     * @return Le résultat de la soustraction.
     */
    private static
    float soustraction( float number1, float number2 )
    {
        return ( number1 - number2 );
    }

    /**
     * Fonction de multiplication.
     *
     * @param number1 Le premier float à multiplier.
     * @param number2 Le second float à multiplier.
     *
     * @return Le résultat de la multiplication.
     */
    private static
    float multiplication( float number1, float number2 )
    {
        return ( number1 * number2 );
    }

    /**
     * Fonction de division.
     * Test si le dénominateur est négatif ou nul. Si oui, une fenêtre d'erreur est affichée.
     *
     * @param number1 Le float à diviser.
     * @param number2 Le float qui divise.
     *
     * @return Le résultat de la division.
     */
    private static
    float division( float number1, float number2 ) throws CalculException
    {
        if ( number2 != 0 )
        {
            return ( number1 / number2 );
        }
        else
        {
            throw new CalculException( "La division par zero est interdite" );
        }
    }
}
