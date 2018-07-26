public class SeaVessel extends Vehicle
{
    protected int displacement;

    public SeaVessel()
    {}

    public SeaVessel(String name, int maxPassengers, double maxSpeed, int displacement)
    {
        super(name, maxPassengers, maxSpeed);
        this.displacement = displacement;
    }

    public int getDisplacement()
    {
        return displacement;
    }

    public void setDisplacement(int displacement)
    {
        this.displacement = displacement;
    }

    public void launch()
    {
        System.out.println(this.name + " -> launch() ...");
    }

    @Override
    public String toString()
    {
        return "SeaVessel:   [ name: " + name + ", maxPassengers: " + maxPassengers + ", maxSpeed: " + maxSpeed + ", displacement: " + displacement + " ]";
    }
}
