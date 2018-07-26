package Test;

import Business.*;
import Models.*;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test
{

    private List<Vehicle> vehicles;
    private List<Person> people;
    private VehicleBusiness manager;


    private Test()
    {
        manager = new VehicleBusiness();

        vehicles = new LinkedList<>();
        vehicles.add(new Vehicle(1,736736,2001,"dacia","negru", Type.MASINA));
        vehicles.add(new Vehicle(2,123454,1995,"aurora","galben", Type.RULOTA));
        vehicles.add(new Vehicle(3,21423,2009,"moldova","alb", Type.RULOTA));
        vehicles.add(new Vehicle(4,56,2012,"kira","argintiu", Type.SCOOTER));
        vehicles.add(new Vehicle(5,9875,2010,"ford","albastru", Type.MASINA));
        vehicles.add(new Vehicle(6,241543,2009,"bmw","rosu", Type.MASINA));
        vehicles.add(new Vehicle(7,111112,2017,"kira","negru", Type.SCOOTER));
        vehicles.add(new Vehicle(8,4277,2014,"reno","galben", Type.MASINA));
        vehicles.add(new Vehicle(9,999875,2016,"aurora","verde", Type.RULOTA));

        people = new LinkedList<>();
        people.add(new Person(1,8262,"Tudor","Popicu","08-24-2018","M",2018));
        people.add(new Person(2,124253,"Adi","Turea","08-24-2018","M",2015));
        people.add(new Person(3,6547,"Alex ","Mihnea","08-24-2018","M",2018));
        people.add(new Person(4,7483,"Teodor","Ichim","08-24-2018","M",2016));
        people.add(new Person(5,15688,"Alexandra","Vaja","08-24-2018","F",2010));
        people.add(new Person(6,51346143,"Andrei","Constandache","08-24-2018","M",2009));
        people.add(new Person(7,54136,"Raul","Popa","08-24-2018","M",2014));
        people.add(new Person(8,62652,"Florina","Muresean","08-24-2018","F",2018));
        people.add(new Person(9,652622,"Ionel","Petrascu","08-24-2018","M",2005));

    }

    private void start()
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do
        {
            System.out.print("1. View all vehicles\n2. View vehicles sorted by manufacturing year\n3. View vehicles sorted by brand\n4. Search vehicles by type\n5. Exit\n\nchoice: ");
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
                        if(type.equals(Type.MASINA.toString()))
                        {
                            manager.searchVehicle(vehicles,Type.MASINA);
                        }
                        else if(type.equals(Type.RULOTA.toString()))
                        {
                            manager.searchVehicle(vehicles,Type.RULOTA);
                        }
                        else if(type.equals(Type.SCOOTER.toString()))
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
        }while(choice != 5);
        scanner.close();
    }

    public static void main(String[] args)
    {
        Test test = new Test();
        test.start();
    }

}
