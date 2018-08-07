package Business;

import Models.*;

import java.util.List;

public interface IVehicleBusiness
{

    void viewVehicles(List<Vehicle> vehicles);

    void viewSortedVehiclesByYear(List<Vehicle> vehicles);

    void viewSortedVehiclesByBrand(List<Vehicle> vehicles);

    void searchVehicle(List<Vehicle> vehicles, Type type);

    void viewRentedVehicles(List<Contract> rents, String identificationNumber);


}
