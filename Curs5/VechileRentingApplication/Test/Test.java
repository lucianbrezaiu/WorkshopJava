package Test;

import Business.*;
import Models.*;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test
{

    private List<Vehicle> vehicles;
    private List<Person> people;
    private List<Contract> rents;
    private VehicleBusiness manager;

    private Test()
    {
        manager = new VehicleBusiness();
        people = new LinkedList<>();
        vehicles = new LinkedList<>();
        rents = new LinkedList<>();

        readVehicles();
        readPeople();
        readRents();
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
                vehicles.add(new Vehicle(array[0],type,array[2],Integer.parseInt(array[3]),array[4]));
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
                people.add(new Person(array[0],array[1],array[2],array[3],Integer.parseInt(array[4])));
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


                rents.add(new Contract(array[0],array[1],Integer.parseInt(array[2]),array[3],array[4]));
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
                                                                        "4. Search vehicles by type\n5. Check for driving license < 18 years\n6. Rent a car\n7. Exit\n\nchoice: ");
            try
            {
                scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch(choice)
                {
                    case 1:
                        manager.viewVehicles(vehicles);
                        System.out.println();
                        break;
                    case 2:
                        manager.viewSortedVehiclesByYear(vehicles);
                        System.out.println();
                        break;
                    case 3:
                        manager.viewSortedVehiclesByBrand(vehicles);
                        System.out.println();
                        break;
                    case 4:
                        scanner = new Scanner(System.in);
                        System.out.print("\nTYPE: ");
                        String type = scanner.nextLine();
                        if(type.toUpperCase().equals(Type.MASINA.toString()))
                        {
                            manager.searchVehicle(vehicles,Type.MASINA);
                        }
                        else if(type.toUpperCase().equals(Type.RULOTA.toString()))
                        {
                            manager.searchVehicle(vehicles,Type.RULOTA);
                        }
                        else if(type.toUpperCase().equals(Type.SCOOTER.toString()))
                        {
                            manager.searchVehicle(vehicles,Type.SCOOTER);
                        }
                        else
                        {
                            System.out.print("Wrong input!");
                        }
                        System.out.println();
                        break;
                    case 5:
                        for(Person person : people)
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
                        scanner = new Scanner(System.in);
                        System.out.print("Start date: ");String startDate = scanner.nextLine();
                        System.out.print("End date: ");String endDate = scanner.nextLine();
                        System.out.print("Identification number: ");String identificationNumber = scanner.nextLine();
                        System.out.print("Registration number: ");String registrationNumber = scanner.nextLine();
                        System.out.print("Kilometers: ");Integer kilom = scanner.nextInt();

                        Contract rent = new Contract(startDate,endDate,kilom,identificationNumber,registrationNumber);

                        FileWriter fw = new FileWriter(new File("src/inchirieri.txt") , true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(rent.toString() + "\n");
                        bw.close();

                        System.out.println("\nOperation successfully completed!\n");
                        break;
                    case 7:
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
        }while(choice != 7);
        scanner.close();
    }

    public static void main(String[] args)
    {
        Test test = new Test();
        test.start();
    }

}
