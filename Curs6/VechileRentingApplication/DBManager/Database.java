package DBManager;

import Models.Contract;
import Models.Person;
import Models.Type;
import Models.Vehicle;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Database
{

    private static Connection connection = null;

    private static void createConnection()
    {
        try
        {
            String url = "jdbc:sqlserver://127.0.0.1:1433;integratedSecurity=true;database=javaCarsDB";
            connection = DriverManager.getConnection(url);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void closeConnection()
    {
        try
        {
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }




    public static List<Vehicle> selectAllCars()
    {
        createConnection();

        List<Vehicle> vehicles = new LinkedList<>();

        try
        {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery("select * from Car");

            while(rs.next())
            {
                String registrationNumber = rs.getString(1);
                int manufacturingYear = rs.getInt(2);
                String brand = rs.getString(3);
                String color = rs.getString(4);
                String typeStr = rs.getString(5);

                Type type = null;

                switch(typeStr.toUpperCase())
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

                vehicles.add(new Vehicle(registrationNumber, type, brand, manufacturingYear, color));

            }
            closeConnection();
            return vehicles;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            closeConnection();
            return null;
        }


    }

    public static List<Person> selectAllClients()
    {

        createConnection();

        List<Person> clients = new LinkedList<>();

        try
        {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery("select * from Client");

            while(rs.next())
            {
                String identificationNumber = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String gender = rs.getString(4);
                int drivingLicenseYear = rs.getInt(5);

                clients.add(new Person(identificationNumber,lastName,firstName,gender,drivingLicenseYear));

            }
            closeConnection();
            return clients;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            closeConnection();
            return null;
        }
    }

    public static List<Contract> selectAllRents()
    {

        createConnection();

        List<Contract> rents = new LinkedList<>();

        try
        {
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery("select * from Rent");

            while(rs.next())
            {
                String startDate = rs.getString(1);
                String endDate = rs.getString(2);
                int kilometers = rs.getInt(3);
                String identificationNumber = rs.getString(4);
                String registrationNumber = rs.getString(5);

                rents.add(new Contract(startDate,endDate,kilometers,identificationNumber,registrationNumber));

            }
            closeConnection();
            return rents;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            closeConnection();
            return null;
        }
    }



    public static void insertClient(Person client)
    {
        createConnection();

        try
        {
            String query = "INSERT INTO Client(IdentificationNumber,FirstName,LastName,Gender,DrivingLicenseYear) VALUES (?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,client.getIdentificationNumber());
            statement.setString(2,client.getFirstName());
            statement.setString(3,client.getLastName());
            statement.setString(4,client.getGender());
            statement.setInt(5,client.getDrivingLicenseYear());

            statement.execute();
            closeConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            closeConnection();
        }
    }

    public static void insertCar(Vehicle car)
    {
        createConnection();

        try
        {
            String query = "INSERT INTO Car(RegistrationNumber,ManufacturingYear,Brand,Colour,Type) VALUES (?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, car.getRegistrationNumber());
            statement.setInt(2,car.getManufacturingYear());
            statement.setString(3,car.getBrand());
            statement.setString(4,car.getColour());
            statement.setString(5,car.getType().toString());

            statement.execute();
            closeConnection();

        }
        catch(Exception e)
        {
            e.printStackTrace();
            closeConnection();
        }
    }

    public static void insertContract(Contract rent)
    {
        createConnection();

        try
        {
            String query = "INSERT INTO Rent(StartDate,EndDate,Kilometers,IdentificationNumber,RegistrationNumber) VALUES (?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, rent.getStartDate());
            statement.setString(2,rent.getEndDate());
            statement.setInt(3,rent.getKilometers());
            statement.setString(4,rent.getIdentificationNumber());
            statement.setString(5,rent.getRegistrationNumber());

            statement.execute();
            closeConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            closeConnection();
        }
    }

    public static boolean emptyDatabase()
    {
        try
        {
            createConnection();

            Statement statement = connection.createStatement();
            int nrCars=-1, nrClients=-1, nrRents=-1;


            ResultSet rs = statement.executeQuery("select count(*) from Car");
            while(rs.next())
            {
                nrCars = rs.getInt(1);
            }


            rs = statement.executeQuery("select count(*) from Client");
            while(rs.next())
            {
                nrClients = rs.getInt(1);
            }


            rs = statement.executeQuery("select count(*) from Rent");
            while(rs.next())
            {
                nrRents = rs.getInt(1);
            }

            closeConnection();

            if(nrCars==0 && nrClients==0 && nrRents==0)
            {
                return true;
            }
            return false;

        }
        catch(Exception e)
        {
            e.printStackTrace();
            closeConnection();
            return false;
        }
    }

}
