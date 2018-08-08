package Models;

public class Contract {
    private String registrationNumber;
    private int kilometers;
    private String identificationNumber;
    private String startDate;
    private String endDate;

    public Contract() {
    }


    public Contract(String startDate, String endDate, int kilometers, String identificationNumber, String registrationNumber) {
        this.registrationNumber = registrationNumber;
        this.identificationNumber = identificationNumber;
        this.kilometers = kilometers;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }


    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return startDate + ", " + endDate + ", " + kilometers + ", " + identificationNumber + ", " + registrationNumber;
    }

}
