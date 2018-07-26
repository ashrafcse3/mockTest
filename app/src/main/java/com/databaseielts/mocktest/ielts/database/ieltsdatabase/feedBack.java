package com.databaseielts.mocktest.ielts.database.ieltsdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;

public class feedBack extends AppCompatActivity {
    MyDatabaseHelper myDatabaseHelper;
    private EditText editText1,editText2;
    private String msg,email;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        myDatabaseHelper = new MyDatabaseHelper(this);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        send = findViewById(R.id.send);


        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                msg = editText1.getText().toString();
                email = editText2.getText().toString();
                if(msg.equalsIgnoreCase("") || email.equalsIgnoreCase("")){
                    Toast.makeText(feedBack.this, "Please complete both fields!!", Toast.LENGTH_SHORT).show();
                }

                else {
                    long val =  myDatabaseHelper.storeFeedback(msg,email);

                    if(val!=-1) {
                        Toast.makeText(feedBack.this, "Thank you for your valuable feedback.", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }

                }
            }
        });



    }
}