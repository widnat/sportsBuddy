package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {

    private String userID;
    private String firstName;
    private String lastName;
    private int locationID;
    private ArrayList<String> userSports;


    public User(String userID, String firstName, String lastName, int locationID) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.locationID = locationID;
        this.userSports = new ArrayList<>();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public ArrayList<String> getUserSports() {
        return userSports;
    }

    public void addSport(String sport) {
        this.userSports.add(sport);
    }

    public void removeSport(String sport) {
        if (userSports.contains(sport)) {
            this.userSports.remove(sport);
        }
    }
}
