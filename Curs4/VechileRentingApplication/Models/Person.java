package Models;

import java.util.Objects;

public class Person
{
    private int id;
    private int identificationNumber;
    private String firstName;
    private String lastName;
    private String birthday;
    private String gender;
    private  int drivingLicenseYear;

    public Person()
    {

    }

    public Person(int id, int identificationNumber, String firstName, String lastName, String birthday, String gender, int drivingLicenseYear)
    {
        this.id = id;
        this.identificationNumber = identificationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.drivingLicenseYear = drivingLicenseYear;
    }

    public int getId()
    {
        return id;
    }

    public int getIdentificationNumber()
    {
        return identificationNumber;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public String getGender()
    {
        return gender;
    }

    public int getDrivingLicenseYear()
    {
        return drivingLicenseYear;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setDrivingLicenseYear(int drivingLicenseYear)
    {
        this.drivingLicenseYear = drivingLicenseYear;
    }


    @Override
    public String toString()
    {
        return "[ identificationNumber: " + identificationNumber + ", firstName: '" + firstName + '\'' + ", lastName: '" + lastName + '\'' + ", birthday: '" + birthday + '\'' + ", gender: '" + gender + '\'' + ", drivingLicenseYear: " + drivingLicenseYear + " ]";
    }
}
