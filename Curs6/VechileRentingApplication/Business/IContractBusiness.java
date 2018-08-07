package Business;

import Models.Contract;
import Models.Person;
import Models.Vehicle;

import java.util.List;

public interface IContractBusiness
{

    Contract rentVehicle();

    void viewHistoric(List<Contract> list);

}
