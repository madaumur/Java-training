package com.afpa;

import java.util.Comparator;

public
class CompareEtudiant implements Comparator< Etudiant >
{
    @Override
    public
    int compare( Etudiant p1, Etudiant p2 )
    {
        int result = p1.getNom().compareToIgnoreCase( p2.getNom() );

        if ( result != 0 )
        {
            return result;
        }
        else
        {
            result = p1.getPrenom().compareToIgnoreCase( p2.getPrenom() );
            if ( result != 0 )
            {
                return result;
            }
            else
            {
                return p1.getAge() - p2.getAge();
            }
        }
    }
}