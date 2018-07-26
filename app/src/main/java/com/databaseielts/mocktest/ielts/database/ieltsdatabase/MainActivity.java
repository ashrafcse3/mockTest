package com.databaseielts.mocktest.ielts.database.ieltsdatabase;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyDatabaseHelper myDatabaseHelper;

    private Button listeningButton, readingButton,feedbackid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feedbackid = findViewById(R.id.feedbackid);


        initialize();
    } // onCreate finished

    private void initialize() {

        listeningButton = findViewById(R.id.listeningButtonId);
        readingButton = findViewById(R.id.readingButtonId);

        listeningButton.setOnClickListener(this);
        readingButton.setOnClickListener(this);
        feedbackid.setOnClickListener(this);

        myDatabaseHelper = new MyDatabaseHelper(this);

        // Create "listening MCQs" table and insert the data into database for the first time.
        Cursor cursor = myDatabaseHelper.tableExists("MCQs");
        if (cursor.getCount() == 0) {
            myDatabaseHelper.storeQuestions();
        }
        cursor.close();

        // Create "FillBlank" table and insert the data into database for the first time.
        cursor = myDatabaseHelper.tableExists("FillBlank");
        if (cursor.getCount() == 0) {
            myDatabaseHelper.storeFillBlank();
        }
        cursor.close();

        // Create "Reading MCQs" table and insert the data into database for the first time.
        cursor = myDatabaseHelper.tableExists("MCQs_Reading");
        if (cursor.getCount() == 0) {
            myDatabaseHelper.storeReadingMCQ();
        }
        cursor.close();

        // Create "Reading MatchingThings" table and insert the data into database for the first time.
        cursor = myDatabaseHelper.tableExists("MatchingThings");
        if (cursor.getCount() == 0) {
            myDatabaseHelper.storeMatchingThings();
        }
        cursor.close();

        // Create "Reading Passage" table and insert the data into database for the first time.
        cursor = myDatabaseHelper.tableExists("ReadingPassage");
        if (cursor.getCount() == 0) {
            myDatabaseHelper.storeReadingPassage();
        }
    } // initialize finished

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();

        if (v.getId() == listeningButton.getId()) {
            bundle.putString("module", "listening");
            Intent intent = new Intent(getApplicationContext(), expandableList.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else if (v.getId() == readingButton.getId()) {
            bundle.putString("module", "reading");
            Intent intent = new Intent(getApplicationContext(), expandableList.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }


        else if(v.getId() == R.id.feedbackid){
            Intent ii = new Intent(getApplicationContext(),feedBack.class);
            startActivity(ii);
        }

    }
}
