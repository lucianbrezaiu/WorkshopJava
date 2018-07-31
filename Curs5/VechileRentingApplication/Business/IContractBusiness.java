package Business;

import Models.Contract;
import Models.Person;
import Models.Vehicle;

import java.util.List;

public interface IContractBusiness
{

    Contract rentVehicle(Vehicle vehicle, Person person);

    void viewHistoric(List<Contract> list);

}
