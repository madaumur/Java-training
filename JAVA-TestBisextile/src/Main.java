public
class Main
{
    public static
    void main( String[] args )
    {
        System.out.println( dateValide( 32, 1, 1996 ) );
        System.out.println( dateValide( 4, 3, 408 ) );
        System.out.println( dateValide( 29, 2, 1204 ) );
        System.out.println( dateValide( 29, 2, 900 ) );
    }

    static
    boolean dateValide( int jour, int mois, int annee )
    {
        if ( ( mois < 1 || mois > 12 ) || ( jour < 1 || jour > 31 ) || ( annee < 0 ) )
        {
            return false;
        }

        int nbJour[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if ( ( ( annee % 4 == 0 ) && ( annee % 100 != 0 ) ) || ( annee % 400 == 0 ) )
        {
            nbJour[ 1 ] += 1;
        }

        if ( jour <= nbJour[ mois - 1 ] )
        {
            return true;
        }

        return false;
    }
}