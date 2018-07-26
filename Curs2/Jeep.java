public class Jeep extends LandVehicle
{
    public Jeep()
    {
    }

    public Jeep(String name, int maxPassengers, double maxSpeed,int numWheels)
    {
        super(name, maxPassengers, maxSpeed, numWheels);
    }

    public void soundHorn()
    {
        System.out.println(this.name + " -> soundHorn() ... ");
    }



}
