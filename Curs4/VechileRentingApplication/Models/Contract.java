package Models;

public class Contract
{
    private int id;
    private Person person;
    private Vehicle vehicle;
    private String startDate;
    private String endDate;

    public Contract()
    {   }


    public Contract(int id,Person person, Vehicle vehicle,String startDate, String endDate)
    {
        this.id = id;
        this.person = person;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
    }



    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    @Override
    public String toString()
    {
        return "[ person:" + person.getId() + ", vehicle: " + this.vehicle.getId() + " ]";

    }

}
