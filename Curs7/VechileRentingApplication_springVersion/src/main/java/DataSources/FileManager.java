package DataSources;

import Models.Contract;
import Models.Person;
import Models.Type;
import Models.Vehicle;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public static List<Vehicle> readVehicles() {

        List<Vehicle> list = new LinkedList<>();

        try {
            File file = new File("src/main/resources/vehicles.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] array = line.split(", ");

                Type type = null;
                switch (array[1].toUpperCase()) {
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
                list.add(new Vehicle(array[0],type,array[2],Integer.parseInt(array[3]),array[4]));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Person> readPeople() {

        List<Person> list = new LinkedList<>();

        try {
            File file = new File("src/main/resources/persoane.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] array = line.split(", ");
                list.add(new Person(array[0], array[1], array[2], array[3], Integer.parseInt(array[4])));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<Contract> readRents() {

        List<Contract> list = new LinkedList<>();

        try {
            File file = new File("src/main/resources/inchirieri.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] array = line.split(",");
                for (int i = 0; i < array.length; i++) {
                    array[i] = array[i].trim();
                }

               list.add(new Contract(array[0], array[1], Integer.parseInt(array[2]), array[3], array[4]));
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
