import java.time.LocalDate;
import java.time.Period;

public
class Personne
{
    static LocalDate dateAujd;

    final LocalDate dateNaissance;
    final LocalDate datePermis;
    LocalDate dateSignContrat;
    int nbAccident;

    int age;
    int agePermis;
    int dureeContrat;
    int dureePermis;

    public
    Personne( LocalDate dateNaissance, LocalDate datePermis, LocalDate dateSignContrat, int nbAccident )
    {
        this.dateNaissance   = dateNaissance;
        this.datePermis      = datePermis;
        this.dateSignContrat = dateSignContrat;
        this.nbAccident      = nbAccident;


        setAge( dateNaissance );
        setDureePermis( datePermis );
        setDureeContrat( dateSignContrat );
        setAgePermis( dateNaissance, datePermis );

    }

    private
    void setAge( LocalDate dateNaissance )
    {
        dateAujd = LocalDate.now();

        if ( dateNaissance != null )
        {
            Period period = Period.between( dateNaissance, dateAujd );

            this.age = period.getYears();
        }
    }

    private
    void setDureePermis( LocalDate datePermis )
    {
        dateAujd = LocalDate.now();

        if ( datePermis != null )
        {
            Period period = Period.between( datePermis, dateAujd );

            this.dureePermis = period.getYears();
        }
    }

    private
    void setDureeContrat( LocalDate dateSignContrat )
    {
        dateAujd = LocalDate.now();
        if ( dateSignContrat != null )
        {
            Period period = Period.between( dateSignContrat, dateAujd );

            this.dureeContrat = period.getYears();
        }
    }

    private
    void setAgePermis( LocalDate dateNaissance, LocalDate datePermis )
    {
        if ( ( dateSignContrat != null ) && ( datePermis != null ) )
        {
            Period period = Period.between( dateNaissance, datePermis );

            this.agePermis = period.getYears();
        }
    }
}
