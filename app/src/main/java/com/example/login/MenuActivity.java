package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import static com.example.login.R.layout.activity_menu;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_menu);
        String userID = getIntent().getExtras().getString("userID");
        Button logout = findViewById(R.id.menuLogoutButton);
        Button personalMessages = findViewById(R.id.menuPersonalMessagesButton);
        Button buddies = findViewById(R.id.menuBuddiesButton);

        logout.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        });

        personalMessages.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MessagesActivity.class);
            startActivity(intent);
        });

        personalMessages.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), BuddiesActivity.class);
            startActivity(intent);
        });
    }
}