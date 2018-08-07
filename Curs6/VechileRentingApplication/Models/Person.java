package Models;

import java.util.Objects;

public class Person
{
    private String identificationNumber;
    private String firstName;
    private String lastName;
    private String birthday;
    private String gender;
    private  int drivingLicenseYear;

    public Person()
    {

    }

    public Person(String identificationNumber, String lastName, String firstName, String gender, int drivingLicenseYear)
    {
        this.identificationNumber = identificationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = findOutBirthday();
        this.gender = gender;
        this.drivingLicenseYear = drivingLicenseYear;
    }


    public String getIdentificationNumber()
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

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
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


    public String findOutBirthday()
    {
        int y;
        if(this.identificationNumber.charAt(0)=='1' || this.identificationNumber.charAt(0)=='2')
        {
            y = 1900;
        }
        else if(this.identificationNumber.charAt(0)=='3' || this.identificationNumber.charAt(0)=='4')
        {
            y = 1800;
        }
        else
        {
            y = 2000;
        }


        Integer year = y + Integer.parseInt(""+this.identificationNumber.charAt(1)+this.identificationNumber.charAt(2));

        Integer month = Integer.parseInt(""+this.identificationNumber.charAt(3)+this.identificationNumber.charAt(4));

        Integer day = Integer.parseInt(""+this.identificationNumber.charAt(5)+this.identificationNumber.charAt(6));

        return day.toString() + "-" + month.toString() + "-" + year.toString();
    }

    public int getBirthYear()
    {
        String[] array = this.birthday.split("-");
        return Integer.parseInt(array[2]);
    }


    @Override
    public String toString()
    {
        return "[ identificationNumber: " + identificationNumber + ", firstName: " + firstName + ", lastName: " + lastName + ", birthday: '" + birthday + ", gender: " + gender +", drivingLicenseYear: " + drivingLicenseYear + " ]";
    }
}
