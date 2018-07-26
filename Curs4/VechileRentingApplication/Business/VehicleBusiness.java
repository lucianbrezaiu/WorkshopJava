package Business;

import Models.Contract;
import Models.Person;
import Models.Type;
import Models.Vehicle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleBusiness implements IVehicleBusiness
{

    @Override
    public void viewVehicles(List<Vehicle> vehicles)
    {
        vehicles.forEach(System.out::println);
    }

    @Override
    public void viewSortedVehiclesByYear(List<Vehicle> vehicles)
    {
        List<Vehicle> sortedList = new LinkedList<>(vehicles);

        Collections.sort(sortedList,(o1,o2) -> Integer.compare(o1.getManufacturingYear(),o2.getManufacturingYear()));

        sortedList.forEach(System.out::println);
    }

    @Override
    public void viewSortedVehiclesByBrand(List<Vehicle> vehicles)
    {
        List<Vehicle> sortedList = new LinkedList<>(vehicles);

        Collections.sort(sortedList, (o1,o2) -> Integer.compare(o1.getBrand().length(),o2.getBrand().length()));

        sortedList.forEach(System.out::println);
    }

    @Override
    public void searchVehicle(List<Vehicle> vehicles, Type type)
    {
        List<Vehicle> result = vehicles.stream().filter(x -> x.getType() == type).collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    @Override
    public void viewRentedVehicles(Person person)
    {
        //TODO
    }

}
