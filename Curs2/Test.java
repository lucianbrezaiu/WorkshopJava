import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test
{

    public static void main(String[] args)
    {

        List<Vehicle> vehicles = new LinkedList<>();

        vehicles.add(new Vehicle("masina de familie",4,124.5));
        vehicles.add(new Vehicle("caruta",9,50));

        vehicles.add(new LandVehicle("bmw", 7, 95.7,5));
        vehicles.add(new LandVehicle("ford", 7, 95.7,5));

        vehicles.add(new SeaVessel("Regina Maria",100,280,9500));
        vehicles.add(new SeaVessel("Vlad Duricu", 150, 300, 7963));

        vehicles.add(new Jeep("my jeep", 6, 250.5, 4));
        vehicles.add(new Jeep("your jeep", 6, 290, 4));

        vehicles.add(new Frigate("USA",490,280,8673));
        vehicles.add(new Frigate("Marta", 230, 500, 6535));


        Collections.sort(vehicles, new Vehicle());
        vehicles.forEach(System.out::println);

        System.out.println();

        for (Vehicle vehicle : vehicles)
        {
            if(vehicle instanceof LandVehicle)
            {
                ((LandVehicle) vehicle).drive();
            }
            else if(vehicle instanceof Frigate)
            {
                ((Frigate) vehicle).fireGun();
            }
        }
    }
}
