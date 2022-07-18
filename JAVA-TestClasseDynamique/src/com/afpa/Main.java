package com.afpa;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public
class Main
{
    public static
    void main( String[] args )
    {
        // Récupère le nom de la classe actuelle
        final String PACKAGE     = Main.class.getPackage().getName();
        int          recommencer = 0;
        String       className   = "";

        while ( recommencer == 0 )
        {
            try
            {
                // Demande du nom de la classe
                className = showInputDialog( null, "Nom de la classe ( avec package )", "Classe",
                                             JOptionPane.QUESTION_MESSAGE ).trim();

                System.out.println( testPackage( PACKAGE, className ) );

                // Test de création dynamique de classe
                Class  maClasse = Class.forName( className );
                Object objet    = maClasse.getDeclaredConstructor().newInstance();

                showMessageDialog( null, "Vous avez créé une instance à partir de la création dynamique" +
                                         " d'une classe de type : " + objet.getClass().getName() );
            }
            catch ( ClassNotFoundException cnfe )
            {
                showMessageDialog( null, "La classe " + className + " n'existe pas" );
            }
            catch ( InstantiationException e )
            {
                throw new RuntimeException( e );
            }
            catch ( IllegalAccessException e )
            {
                throw new RuntimeException( e );
            }
            catch ( InvocationTargetException e )
            {
                throw new RuntimeException( e );
            }
            catch ( NoSuchMethodException e )
            {
                throw new RuntimeException( e );
            }
            finally
            {
                recommencer = JOptionPane.showConfirmDialog( null, "Voulez-vous recommencer", "recommencer?",
                                                             JOptionPane.OK_CANCEL_OPTION );
            }
        }
    }

    /**
     * Fonction de test si la String rentrée équivaut au package actuel.
     *
     * @param PACKAGE   constante, nom du package principal
     * @param className La saisie utilisateur
     * @return          Le booleen, réponse au test d'égalité.
     */
    private static
    boolean testPackage( String PACKAGE, String className )
    {
        for ( int i = 0; i < PACKAGE.length(); i++ )
        {
            if ( PACKAGE.charAt( i ) != className.charAt( i ) )
            {
                return false;
            }
        }
        return true;
    }
}