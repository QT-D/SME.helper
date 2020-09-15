package com.example.smehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity3 extends AppCompatActivity {
    Button debtors,creditors,budget,reminders,store,sales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
        debtors=(Button)findViewById(R.id.button2);
        creditors=(Button)findViewById(R.id.button4);
        budget=(Button)findViewById(R.id.button8);
        reminders=(Button)findViewById(R.id.button6);
        store=(Button)findViewById(R.id.button7);
        sales=(Button)findViewById(R.id.button5);
        debtors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity3.this,activity4.class);
                startActivity(intent);

            }
        });

        creditors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity3.this,activity5.class);
                startActivity(intent);

            }
        });

    }
}