package Business;

import Models.Contract;
import Models.Person;
import Models.Vehicle;

import java.util.List;
import java.util.Scanner;

public class ContractBusiness implements IContractBusiness
{

    @Override
    public Contract rentVehicle()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Start date: ");String startDate = scanner.nextLine();
        System.out.print("End date: ");String endDate = scanner.nextLine();
        System.out.print("Identification number: ");String identificationNumber = scanner.nextLine();
        System.out.print("Registration number: ");String registrationNumber = scanner.nextLine();
        System.out.print("Kilometers: ");Integer kilom = scanner.nextInt();

        Contract rent = new Contract(startDate.trim(),endDate.trim(),kilom,identificationNumber.trim(),registrationNumber.trim());

        return rent;
    }


    @Override
    public void viewHistoric(List<Contract> list)
    {
        list.forEach(x -> System.out.println( "vehicle: " + x.getRegistrationNumber() + " -> client: " + x.getIdentificationNumber()));
    }
}
