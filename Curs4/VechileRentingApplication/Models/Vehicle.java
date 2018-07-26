package Models;

import java.util.Objects;

public class Vehicle
{
    private int id;
    private int registrationNumber;
    private int manufacturingYear;
    private String brand;
    private String colour;
    private Type type;

    public Vehicle()
    {

    }

    public Vehicle(int id, int registrationNumber, int manufacturingYear, String brand, String colour, Type type)
    {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.manufacturingYear = manufacturingYear;
        this.brand = brand;
        this.colour = colour;
        this.type = type;
    }

    public int getId()
    {
        return id;
    }

    public int getRegistrationNumber()
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


    public void setId(int id)
    {
        this.id = id;
    }

    public void setRegistrationNumber(int registrationNumber)
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
        return "[ registrationNumber: " + registrationNumber + ", manufacturingYear: " + manufacturingYear + ", brand: '" + brand + '\'' + ", colour: '" + colour + '\'' + ", type: " + type + " ]";
    }
}
