package com.afpa;

import java.util.Comparator;

public
class CompareEtudiantSalarie extends CompareEtudiant implements Comparator< Etudiant >
{
    @Override
    public
    int compare( Etudiant p1, Etudiant p2 )
    {
        if ( p1 instanceof Salarie && ! ( p2 instanceof Salarie ) )
        {
            return - 1;
        }
        else if ( ! ( p1 instanceof Salarie ) && ( p2 instanceof Salarie ) )
        {
            return + 1;
        }
        else if ( ! ( p1 instanceof Salarie ) && ! ( p2 instanceof Salarie ) )
        {
            return super.compare( p1, p2 );
        }
        else
        {
            return ( ( Salarie ) p1 ).getId() - ( ( Salarie ) p2 ).getId();
        }
    }
}