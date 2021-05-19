package model;

public class Location {

    private int locationID;
    private String city;
    private String state;
    private String country;
    private int zipCode;

    public Location(int locationID, String city, String state, String country, int zipCode) {
        this.locationID = locationID;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
