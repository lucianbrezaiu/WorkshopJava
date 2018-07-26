public class LandVehicle extends Vehicle
{
    protected int numWheels;

    public LandVehicle()
    {}

    public LandVehicle(String name, int maxPassengers, double maxSpeed, int numWheels)
    {
        super(name, maxPassengers, maxSpeed);
        this.numWheels = numWheels;
    }

    public int getNumWheels()
    {
        return numWheels;
    }

    public void setNumWheels(int numWheels)
    {
        this.numWheels = numWheels;
    }

    public void drive()
    {
        System.out.println(this.name + " -> drive() ...");
    }

    @Override
    public String toString()
    {
        return "LandVehicle: [ name: " + name + ", maxPassengers: " + maxPassengers + ", maxSpeed: " + maxSpeed + ", numWheels: " + numWheels + " ]";
    }

}
