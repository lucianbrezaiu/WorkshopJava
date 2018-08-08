import Business.ContractBusiness;
import Business.VehicleBusiness;
import DataSources.FileManager;
import DataSources.SpringDatabase;
import Models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Application {
    private VehicleBusiness vehicleManager;
    private ContractBusiness contractBusiness;

    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    SpringDatabase db = context.getBean("springDb", SpringDatabase.class);

    public Application() {
        vehicleManager = new VehicleBusiness();
        contractBusiness = new ContractBusiness();
    }


    public void buildingDatabase() {
        if (db.emptyDatabase()) {

            List<Vehicle> vehicles = FileManager.readVehicles();
            List<Person> people = FileManager.readPeople();
            List<Contract> rents = FileManager.readRents();


            if (vehicles != null) {
                db.insertCars(vehicles);
            }
            if (people != null) {
                db.insertClients(people);
            }
            if (rents != null) {
                db.insertContracts(rents);
            }

            System.out.println("\nDatabase built successfully! (Spring)\n");
        } else {
            System.out.println("\nDatabase already built!\n");
        }

    }

    public void run() {



        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.print("1. View all vehicles\n2. View vehicles sorted by manufacturing year\n3. View vehicles sorted by brand\n" +
                    "4. Search vehicles by type\n5. Check for driving license < 18 years\n6. Rent a car\n7. View rented vehicles of a specific user\n8. View all historic of rents\n9. Exit\n\nchoice: ");
            try {
                scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        vehicleManager.viewVehicles(db.selectAllCars());
                        System.out.println();
                        break;
                    case 2:
                        vehicleManager.viewSortedVehiclesByYear(db.selectAllCars());
                        System.out.println();
                        break;
                    case 3:
                        vehicleManager.viewSortedVehiclesByBrand(db.selectAllCars());
                        System.out.println();
                        break;
                    case 4:
                        scanner = new Scanner(System.in);
                        System.out.print("\nTYPE: ");
                        String type = scanner.nextLine();
                        if (type.toUpperCase().equals(Type.MASINA.toString())) {
                            vehicleManager.searchVehicle(db.selectAllCars(), Type.MASINA);
                        } else if (type.toUpperCase().equals(Type.RULOTA.toString())) {
                            vehicleManager.searchVehicle(db.selectAllCars(), Type.RULOTA);
                        } else if (type.toUpperCase().equals(Type.SCOOTER.toString())) {
                            vehicleManager.searchVehicle(db.selectAllCars(), Type.SCOOTER);
                        } else {
                            System.out.print("Wrong input!");
                        }
                        System.out.println();
                        break;
                    case 5:
                        for (Person person : db.selectAllClients()) {
                            int diff = person.getDrivingLicenseYear() - person.getBirthYear();

                            if (diff < 18) {
                                System.out.println(person + " -> " + diff + " years.");
                            }
                        }
                        System.out.println();
                        break;
                    case 6:

                        Contract rent = contractBusiness.rentVehicle();

                        FileWriter fw = new FileWriter(new File("src/inchirieri.txt"), true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write("\n" + rent.toString());
                        bw.close();

                        db.insertContract(rent);

                        System.out.println("\nOperation successfully completed!\n");
                        break;
                    case 7:
                        System.out.print("\nInsert CNP: ");
                        scanner = new Scanner(System.in);
                        String CNP = scanner.nextLine();
                        System.out.println();
                        vehicleManager.viewRentedVehicles(db.selectAllRents(), CNP);
                        System.out.println();
                        break;
                    case 8:
                        System.out.println("\nRents: \n");
                        contractBusiness.viewHistoric(db.selectAllRents());
                        System.out.println();
                        break;
                    case 9:
                        System.out.println("Bye bye!");
                        break;
                    default:
                        System.out.println("Wrong choice!");
                        break;
                }
            } catch (Exception e) {
                choice = 0;
                System.out.println("Eroare!");
            }
        } while (choice != 9);
        scanner.close();
    }

}
