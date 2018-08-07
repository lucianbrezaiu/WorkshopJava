package Models;

import java.util.Objects;

public class Vehicle
{
    private String registrationNumber;
    private int manufacturingYear;
    private String brand;
    private String colour;
    private Type type;

    public Vehicle()
    {

    }

    public Vehicle(String registrationNumber, Type type, String brand, int manufacturingYear, String colour)
    {
        this.registrationNumber = registrationNumber;
        this.manufacturingYear = manufacturingYear;
        this.brand = brand;
        this.colour = colour;
        this.type = type;
    }


    public String getRegistrationNumber()
    {
        return registrationNumber;
    }

    public int getManufacturingYear()
    {
        return manufacturingYear;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getColour()
    {
        return colour;
    }

    public Type getType()
    {
        return type;
    }



    public void setRegistrationNumber(String registrationNumber)
    {
        this.registrationNumber = registrationNumber;
    }

    public void setManufacturingYear(int manufacturingYear)
    {
        this.manufacturingYear = manufacturingYear;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "[ registrationNumber: " + registrationNumber + ", type: " + type + ", brand: " + brand + ", manufacturingYear: " + manufacturingYear + ", colour: " + colour + " ]";
    }
}
