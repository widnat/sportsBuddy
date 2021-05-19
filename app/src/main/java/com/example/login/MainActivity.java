package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import data.DummyData;
import model.Conversation;
import model.Location;
import model.Message;
import model.User;

public class MainActivity extends AppCompatActivity {

    private DummyData data = DummyData.getInstance();
    private ArrayList<Conversation> conversations;
    private ArrayList<Location> locations;
    private ArrayList<Message> messages;
    private ArrayList<User> users;
    private EditText loginUserID;
    private EditText newUserUserID;
    private EditText newUserFirstName;
    private EditText newUserLastName;
    private EditText newUserCity;
    private EditText newUserState;
    private EditText newUserCountry;
    private EditText newUserZipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginUserID = findViewById(R.id.loginUserIDInput);
        newUserUserID = findViewById(R.id.newUserUserIDInput);
        newUserFirstName = findViewById(R.id.newUserFirstNameInput);
        newUserLastName = findViewById(R.id.newUserLastNameInput);
        newUserCity = findViewById(R.id.newUserCityInput);
        newUserState = findViewById(R.id.newUserStateInput);
        newUserCountry = findViewById(R.id.newUserCountryInput);
        newUserZipCode = findViewById(R.id.newUserZipCodeInput);

        Button login = findViewById(R.id.loginButton);
        Button signUp = findViewById(R.id.signUpButton);

        login.setOnClickListener(view -> {
            users = data.getUsers();
            boolean userFound = false;
            String loginInput = getLoginUserIDValue();
            for (int i = 0; i < users.size(); ++i) {
                if (users.get(i).getUserID().equals(loginInput)) {
                    userFound = true;
                    break;
                }
            }
            if (userFound) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("userID", loginInput);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "invalid", Toast.LENGTH_LONG).show();
            }
        });

        signUp.setOnClickListener(view -> {
            if (checkNewUser()) {
                users = data.getUsers();
                boolean userFound = false;
                String userIDInput = getNewUserUserIDValue();
                String firstNameInput = getNewUserFirstNameValue();
                String lastNameInput = getNewUserLastNameValue();
                String cityInput = getNewUserCityValue();
                String stateInput = getNewUserStateValue();
                String countryInput = getNewUserCountryValue();
                int zipCodeInput = getNewUserZipCodeValue();
                for (int i = 0; i < users.size(); ++i) {
                    if (users.get(i).getUserID().equals(userIDInput)) {
                        userFound = true;
                        break;
                    }
                }
                if (!userFound) {
                    locations = data.getLocations();
                    boolean foundLocation = false;
                    Location location = null;
                    for (int i = 0; i  < locations.size(); ++i) {
                        if (locations.get(i).getZipCode() == zipCodeInput) {
                            foundLocation = true;
                            location = locations.get(i);
                        }
                    }
                    if (!foundLocation) {
                        location = new Location(locations.size(), cityInput, stateInput, countryInput, zipCodeInput);
                        //add location to database
                        data.addLocation(location);
                    }
                    User newUser = new User(userIDInput, firstNameInput, lastNameInput, location.getZipCode());
                    // add user to database
                    data.addUser(newUser);
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    intent.putExtra("userID", userIDInput);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "invalid", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getLoginUserIDValue() {
        return loginUserID.getText().toString();
    }

    private boolean checkNewUser() {
        boolean canCreateNewUser = false;
        if (!getNewUserUserIDValue().equals("")
            && !getNewUserFirstNameValue().equals("")
            && !getNewUserLastNameValue().equals("")
            && !getNewUserCityValue().equals("")
            && !getNewUserStateValue().equals("")
            && !getNewUserCountryValue().equals("")
            && !getNewUserZipCodeValue().equals("")) {
            canCreateNewUser = true;
        }
        return canCreateNewUser;
    }

    private String getNewUserUserIDValue() {
        return newUserUserID.getText().toString();
    }

    private String getNewUserFirstNameValue() {
        return newUserFirstName.getText().toString();
    }

    private String getNewUserLastNameValue() {
        return newUserLastName.getText().toString();
    }

    private String getNewUserCityValue() {
        return newUserCity.getText().toString();
    }

    private String getNewUserStateValue() {
        return newUserState.getText().toString();
    }

    private String getNewUserCountryValue() {
        return newUserCountry.getText().toString();
    }

    private Integer getNewUserZipCodeValue() {
        return Integer.parseInt(newUserZipCode.getText().toString());
    }
}