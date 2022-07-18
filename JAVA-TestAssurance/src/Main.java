import java.time.LocalDate;

public
class Main
{
    public static
    void main( String[] args )
    {
        Personne patrick = new Personne( LocalDate.parse( "1983-12-05" ), LocalDate.parse( "2002-08-14" ),
                                         LocalDate.parse( "2003-01-26" ), 0 );
        Personne marine = new Personne( LocalDate.parse( "2001-12-05" ), LocalDate.parse( "2014-08-14" ),
                                        LocalDate.parse( "2020-01-26" ), 0 );
        Personne marc = new Personne( LocalDate.parse( "1972-12-05" ), LocalDate.parse( "1992-08-14" ),
                                      LocalDate.parse( "1996-01-26" ), 3 );
        Personne jean = new Personne( LocalDate.parse( "1965-12-05" ), null, null, 0 );
        Personne christelle = new Personne( LocalDate.parse( "1982-12-05" ), LocalDate.parse( "2003-08-14" ),
                                            LocalDate.parse( "2004-01-26" ), 1 );


        System.out.println( patrick.age + " ans, " + patrick.dureePermis + " ans de permis, " + patrick.dureeContrat +
                            " ans d'assure, tarif : " + noteConducteur( patrick ) );
        System.out.println( marine.age + " ans, " + marine.dureePermis + " ans de permis, " + marine.dureeContrat +
                            " ans d'assure, tarif : " + noteConducteur( marine ) );
        System.out.println( marc.age + " ans, " + marc.dureePermis + " ans de permis, " + marc.dureeContrat +
                            " ans d'assure, tarif : " + noteConducteur( marc ) );
        System.out.println( jean.age + " ans, " + jean.dureePermis + " ans de permis, " + jean.dureeContrat +
                            " ans d'assure, tarif : " + noteConducteur( jean ) );
        System.out.println( christelle.age + " ans, " + christelle.dureePermis + " ans de permis, " + christelle.dureeContrat +
                            " ans d'assure, tarif : " + noteConducteur( christelle ) );
    }

    public static
    Tarif noteConducteur( Personne personne )
    {
        if ( ! isValide( personne ) )
        {
            return null;
        }

        int result = 1;

        if ( personne.age > 25 )
        {
            result += 1;
        }
        if ( personne.dureePermis > 2 )
        {
            result += 1;
        }
        if ( personne.dureeContrat > 5 )
        {
            result += 1;
        }

        result -= personne.nbAccident;

        if ( result > 4 )
        {
            result = 4;
        }
        if ( result < 0 )
        {
            result = 0;
        }

        return switch ( result )
                {
                    case 0 -> Tarif.NON_ASSURABLE;
                    case 1 -> Tarif.ROUGE;
                    case 2 -> Tarif.ORANGE;
                    case 3 -> Tarif.VERT;
                    case 4 -> Tarif.BLEU;
                    default -> null;
                };
    }

    public static
    boolean isValide( Personne personne )
    {
        if ( ( personne.age < 18 ) || ( personne.age > 125 ) )
        {
            return false;
        }
        if ( ( personne.dureePermis < 0 ) || ( personne.dureePermis > 107 ) )
        {
            return false;
        }
        if ( personne.agePermis < 18 )
        {
            return false;
        }
        return ! personne.dateSignContrat.isBefore( personne.datePermis );
    }
}