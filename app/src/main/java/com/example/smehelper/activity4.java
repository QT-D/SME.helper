package com.example.smehelper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity4 extends AppCompatActivity {
    EditText name,contact,amount,paymentdate;
    Button View,Update,Delete,Insert;
    data DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4);
        name=(EditText)findViewById(R.id.e1);
        contact=(EditText)findViewById(R.id.e4);
        amount=(EditText)findViewById(R.id.e1);
        paymentdate=(EditText)findViewById(R.id.e2);
        Insert=(Button)findViewById(R.id.button9) ;
        Update=(Button)findViewById(R.id.button10) ;
        Delete=(Button)findViewById(R.id.button12) ;
        View=(Button)findViewById(R.id.button11) ;
        DB=new data(this);
        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                String nameTXT=name.getText().toString();
                String contactTXT=contact.getText().toString();
                String amountTXT=amount.getText().toString();
                String paymentdateTXT=paymentdate.getText().toString();
                Boolean checkinsertdata=DB.insertuserdata(nameTXT,contactTXT,amountTXT,paymentdateTXT);
                if (checkinsertdata==true){
                    Toast.makeText(activity4.this,"New entry inserted",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(activity4.this,"New entry is not inserted",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                String nameTXT=name.getText().toString();
                String contactTXT=contact.getText().toString();
                String amountTXT=amount.getText().toString();
                String paymentdateTXT=paymentdate.getText().toString();
                Boolean checkupdateddata=DB.updateuserdata(nameTXT,contactTXT,amountTXT,paymentdateTXT);
                if (checkupdateddata==true){
                    Toast.makeText(activity4.this,"New entry inserted",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(activity4.this,"New entry is not inserted",Toast.LENGTH_SHORT).show();
                }
            }
        });
       // View.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(android.view.View v) {
             //   String nameTXT=name.getText().toString();
               // String contactTXT=contact.getText().toString();
                //String amountTXT=amount.getText().toString();
                //String paymentdateTXT=paymentdate.getText().toString();
                //Boolean checkviewdata=DB.viewuserdata(nameTXT,contactTXT,amountTXT,paymentdateTXT);
                //if (checkviewdata==true){
                  //  Toast.makeText(activity4.this,"New entry inserted",Toast.LENGTH_SHORT).show();
                //}
                //else {
                  //  Toast.makeText(activity4.this,"New entry is not inserted",Toast.LENGTH_SHORT).show();
                //}
            //}
        //});
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                String contactTXT=contact.getText().toString();
                Boolean checkdeletedata=DB.deletedata(contactTXT);
                if (checkdeletedata==true){
                    Toast.makeText(activity4.this,"New entry inserted",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(activity4.this,"New entry is not inserted",Toast.LENGTH_SHORT).show();
                }
            }
        });
        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Cursor res=DB.getdata();
                if (res.getCount()==0){
                    Toast.makeText(activity4.this,"New entry is not inserted",Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(activity4.this,"This field is empty",Toast.LENGTH_SHORT).show();
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("DEBTORSNAME: "+res.getString(0)+"\n");
                    buffer.append("CONTACT: "+res.getString(1)+"\n");
                    buffer.append("AMOUNT: "+res.getString(2)+"\n");
                    buffer.append("PAYMENT DATE: "+res.getString(3)+"\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(activity4.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
            }
        });

    }
}