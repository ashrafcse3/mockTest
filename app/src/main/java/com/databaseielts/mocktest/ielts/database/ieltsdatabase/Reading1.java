package com.databaseielts.mocktest.ielts.database.ieltsdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Reading1 extends AppCompatActivity {

    private String module;
    private int testId, sectionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading1);

        Bundle bundle = getIntent().getExtras();
        module = bundle.getString("module");
        testId = bundle.getInt("test_id");
        sectionId = bundle.getInt("section_id");

    }
}
