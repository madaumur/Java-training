package fr.afpa;

public
class Utils
{
    static
    double convertToCels( double tempInFar )
    {
        return ( ( tempInFar - 32 ) / 1.8 );
    }

    static
    double convertToFar( double tempInCels )
    {
        return ( ( tempInCels * 1.8 ) + 32 );
    }
}
