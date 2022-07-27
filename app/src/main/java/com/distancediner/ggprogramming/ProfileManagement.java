package com.distancediner.ggprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.distancediner.ggprogramming.Database.DBHandler;

public class ProfileManagement extends AppCompatActivity {

    EditText username,dob,password;
    RadioButton male,female;
    String gender;
    Button add,updateProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_managemt);

        username = findViewById(R.id.etuserNamePM);
        dob = findViewById(R.id.etDateOfBirthPM);
        password = findViewById(R.id.etPasswordPM);
        male = findViewById(R.id.radioButton);
        female = findViewById(R.id.radioButton2);
        add = findViewById(R.id.button);
        updateProfile = findViewById(R.id.button2);


        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),EditProfile.class);
                startActivity(i);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(male.isChecked()){
                    gender = "Male";
                }else{
                    gender = "Female";
                }

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                long newID = dbHandler.addInfo(username.getText().toString(),dob.getText().toString(),password.getText().toString(),gender);
                Toast.makeText(ProfileManagement.this, "User Added. User ID"+newID, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),EditProfile.class);
                startActivity(i);
            }
        });
    }
}