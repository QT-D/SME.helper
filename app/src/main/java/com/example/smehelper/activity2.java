package com.example.smehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class activity2 extends AppCompatActivity {
    Button LOGIN;
    CheckBox remember;
    EditText Password,Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        Name = findViewById(R.id.edittext);
        Password = findViewById(R.id.editTextPassword);
        remember = findViewById(R.id.checkbox);

        LOGIN = (Button) findViewById(R.id.button);
        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");
        if (checkbox.equals("true")) {
            Intent intent = new Intent(activity2.this, activity3.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please sign in", Toast.LENGTH_SHORT).show();

        }
        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatePassword(Password.getText().toString());
                validateName(Name.getText().toString());


                // validate(Attributes.Name.getText().toString(), Password.getText().toString());
            }
        });

        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked){

                if (compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(activity2.this, "checked", Toast.LENGTH_SHORT).show();

                } else {
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                    Toast.makeText(activity2.this, "unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +//atleast one digit
                    // "(?=.*[a-z])" +//atleast one letter
                    //"(?=.*[A-Z])" +
                    "(?=.*[a-zA-Z])" +
                    //"(?=.*[@#$%^+=&])" +
                    // "(?=\\s=$)" +
                    ".{6,}" )
            //"$")
            ;
    private boolean validateName(String userName){
        if (userName.isEmpty()){
            Name.setError("FIELD CAN'T BE EMPTY");
            return false;
        }
        return true;

    }

    private boolean validatePassword(String userPassword) {
        if (!PASSWORD_PATTERN.matcher(userPassword).matches()) {
            Password.setError("Either the password field is empty/your password is too weak and can easily be copied include characters and numbers");
            return false;

            // if (userPassword.isEmpty()) {
            // Password.setError("FIELD CAN'T BE EMPTY");
            //return false;
        }
        else  {

            Intent intent = new Intent(this, activity3.class);
            startActivity(intent);


        }
//
//
        return true;

    }

}
