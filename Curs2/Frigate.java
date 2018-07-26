public class Frigate extends SeaVessel
{
    public Frigate()
    {
    }

    public Frigate(String name, int maxPassengers, double maxSpeed, int displacement)
    {
        super(name, maxPassengers, maxSpeed, displacement);
    }

    public void fireGun()
    {
        System.out.println(this.name + " -> fireGun() ... ");
    }

}
