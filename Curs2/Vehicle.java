import java.util.Comparator;

public class Vehicle implements Comparator<Vehicle>
{
    protected String name;
    protected int maxPassengers;
    protected double maxSpeed;

    public Vehicle()
    {}

    public Vehicle(String name, int maxPassengers, double maxSpeed)
    {
        this.name = name;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
    }

    public String getName()
    {
        return name;
    }

    public int getMaxPassengers()
    {
        return maxPassengers;
    }

    public double getMaxSpeed()
    {
        return maxSpeed;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setMaxPassengers(int maxPassengers)
    {
        this.maxPassengers = maxPassengers;
    }

    public void setMaxSpeed(double maxSpeed)
    {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString()
    {
        return "Vehicle:     [ name: " + name + ", maxPassengers: " + maxPassengers + ", maxSpeed: " + maxSpeed + " ]";
    }

    @Override
    public int compare(Vehicle o1, Vehicle o2)
    {
        return Integer.compare(o1.getName().length(),o2.getName().length());
    }



}
