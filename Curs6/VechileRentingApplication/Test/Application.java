package Test;

import Business.ContractBusiness;
import Business.VehicleBusiness;
import DBManager.Database;
import Models.*;

import java.io.*;
import java.util.Scanner;

public class Application
{
    private VehicleBusiness vehicleManager;
    private ContractBusiness contractBusiness;

    private Application()
    {
        vehicleManager = new VehicleBusiness();
        contractBusiness = new ContractBusiness();
    }

    private void buildingDatabase()
    {
        if(Database.emptyDatabase())
        {
            readVehicles();
            readPeople();
            readRents();
            System.out.println("\nDatabase built successfully!\n");
        }
        else
        {
            System.out.println("\nDatabase already built!\n");
        }

    }

    private void readVehicles()
    {
        try
        {
            File file = new File("src/vehicles.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] array = line.split(", ");

                Type type = null;
                switch (array[1].toUpperCase())
                {
                    case "MASINA":
                        type = Type.MASINA;
                        break;
                    case "SCOOTER":
                        type = Type.SCOOTER;
                        break;
                    case "RULOTA":
                        type = Type.RULOTA;
                        break;
                }
                Database.insertCar(new Vehicle(array[0],type,array[2],Integer.parseInt(array[3]),array[4]));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void readPeople()
    {
        try
        {
            File file = new File("src/persoane.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] array = line.split(", ");
                Database.insertClient(new Person(array[0],array[1],array[2],array[3],Integer.parseInt(array[4])));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    private void readRents()
    {
        try
        {
            File file = new File("src/inchirieri.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] array = line.split(",");
                for(int i=0;i<array.length;i++)
                {
                    array[i] = array[i].trim();
                }

                Database.insertContract(new Contract(array[0],array[1],Integer.parseInt(array[2]),array[3],array[4]));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


    private void start()
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do
        {
            System.out.print("1. View all vehicles\n2. View vehicles sorted by manufacturing year\n3. View vehicles sorted by brand\n" +
                  "4. Search vehicles by type\n5. Check for driving license < 18 years\n6. Rent a car\n7. View rented vehicles of a specific user\n8. View all historic of rents\n9. Exit\n\nchoice: ");
            try
            {
                scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch(choice)
                {
                    case 1:
                        vehicleManager.viewVehicles(Database.selectAllCars());
                        System.out.println();
                        break;
                    case 2:
                        vehicleManager.viewSortedVehiclesByYear(Database.selectAllCars());
                        System.out.println();
                        break;
                    case 3:
                        vehicleManager.viewSortedVehiclesByBrand(Database.selectAllCars());
                        System.out.println();
                        break;
                    case 4:
                        scanner = new Scanner(System.in);
                        System.out.print("\nTYPE: ");
                        String type = scanner.nextLine();
                        if(type.toUpperCase().equals(Type.MASINA.toString()))
                        {
                            vehicleManager.searchVehicle(Database.selectAllCars(),Type.MASINA);
                        }
                        else if(type.toUpperCase().equals(Type.RULOTA.toString()))
                        {
                            vehicleManager.searchVehicle(Database.selectAllCars(),Type.RULOTA);
                        }
                        else if(type.toUpperCase().equals(Type.SCOOTER.toString()))
                        {
                            vehicleManager.searchVehicle(Database.selectAllCars(),Type.SCOOTER);
                        }
                        else
                        {
                            System.out.print("Wrong input!");
                        }
                        System.out.println();
                        break;
                    case 5:
                        for(Person person : Database.selectAllClients())
                        {
                            int diff = person.getDrivingLicenseYear()-person.getBirthYear();

                            if(diff < 18)
                            {
                                System.out.println(person + " -> " + diff + " years.");
                            }
                        }
                        System.out.println();
                        break;
                    case 6:

                        Contract rent = contractBusiness.rentVehicle();

                        FileWriter fw = new FileWriter(new File("src/inchirieri.txt") ,true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(rent.toString() + "\n");
                        bw.close();

                        Database.insertContract(rent);

                        System.out.println("\nOperation successfully completed!\n");
                        break;
                    case 7:
                        System.out.print("\nInsert CNP: ");
                        scanner = new Scanner(System.in);
                        String CNP = scanner.nextLine();
                        System.out.println();
                        vehicleManager.viewRentedVehicles(Database.selectAllRents(), CNP);
                        System.out.println();
                        break;
                    case 8:
                        System.out.println("\nRents: \n");
                        contractBusiness.viewHistoric(Database.selectAllRents());
                        System.out.println();
                        break;
                    case 9:
                        System.out.println("Bye bye!");
                        break;
                    default:
                        System.out.println("Wrong choice!");
                        break;
                }
            }
            catch(Exception e)
            {
                choice = 0;
                System.out.println("Eroare!");
            }
        }while(choice != 9);
        scanner.close();
    }


    public static void main(String[] args)
    {
        Application app = new Application();

        app.buildingDatabase();

        app.start();

    }

}
