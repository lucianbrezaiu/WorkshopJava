package DataSources;

import Models.Contract;
import Models.Person;
import Models.Type;
import Models.Vehicle;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class SpringDatabase {

    private DataSource dataSource;

    private JdbcTemplate template;


    public List<Person> selectAllClients() {
        try {

            String sql = "SELECT * FROM Client";

            return template.query(sql, (rs, rowNum) ->
            {
                String identificationNumber = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String gender = rs.getString(4);
                int drivingLicenseYear = rs.getInt(5);
                return new Person(identificationNumber, firstName, lastName, gender, drivingLicenseYear);

            });

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public List<Vehicle> selectAllCars() {
        try {

            String sql = "SELECT * FROM Car";

            return template.query(sql, (rs, rowNum) ->
            {
                String registrationNumber = rs.getString(1);
                int manufacturingYear = rs.getInt(2);
                String brand = rs.getString(3);
                String color = rs.getString(4);
                String typeStr = rs.getString(5);
                Type type = null;

                switch (typeStr.toUpperCase()) {
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
                return new Vehicle(registrationNumber, type, brand, manufacturingYear, color);

            });

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public List<Contract> selectAllRents() {
        try {

            String sql = "SELECT * FROM Rent";

            return template.query(sql, (rs, rowNum) ->
            {
                String startDate = rs.getString(1);
                String endDate = rs.getString(2);
                int kilometers = rs.getInt(3);
                String identificationNumber = rs.getString(4);
                String registrationNumber = rs.getString(5);

                return new Contract(startDate, endDate, kilometers, identificationNumber, registrationNumber);

            });

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }


    public boolean emptyDatabase() {
        try {

            int nrCars = template.queryForInt("select count(*) from Car");

            int nrClients = template.queryForInt("select count(*) from Client");

            int nrRents = template.queryForInt("select count(*) from Rent");

            if (nrCars == 0 && nrClients == 0 && nrRents == 0) {
                return true;
            }

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public void insertClient(Person client) {
        String sql = "INSERT INTO Client(IdentificationNumber,FirstName,LastName,Gender,DrivingLicenseYear) VALUES (?,?,?,?,?)";
        template.update(sql, new Object[]{client.getIdentificationNumber(), client.getFirstName(), client.getLastName(), client.getGender(), client.getDrivingLicenseYear()});
    }

    public void insertCar(Vehicle car) {
        String sql = "INSERT INTO Car(RegistrationNumber,ManufacturingYear,Brand,Colour,Type) VALUES (?,?,?,?,?)";
        template.update(sql, new Object[]{car.getRegistrationNumber(), car.getManufacturingYear(), car.getBrand(), car.getColour(), car.getType().toString()});
    }
s
    public void insertContract(Contract rent) {
        String sql = "INSERT INTO Rent(StartDate,EndDate,Kilometers,IdentificationNumber,RegistrationNumber) VALUES (?,?,?,?,?)";
        template.update(sql, new Object[]{rent.getStartDate(), rent.getEndDate(), rent.getKilometers(), rent.getIdentificationNumber(), rent.getRegistrationNumber()});
    }


    public void insertClients(List<Person> list) {
        for (Person client : list) {
            insertClient(client);
        }
    }

    public void insertCars(List<Vehicle> list) {
        for (Vehicle vehicle : list) {
            insertCar(vehicle);
        }
    }

    public void insertContracts(List<Contract> list) {
        for (Contract rent : list) {
            insertContract(rent);
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

}
