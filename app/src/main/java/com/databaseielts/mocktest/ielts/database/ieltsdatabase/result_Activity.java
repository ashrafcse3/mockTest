package com.databaseielts.mocktest.ielts.database.ieltsdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class result_Activity extends AppCompatActivity {
    private String module,time;
    private int testId, sectionId,result;
    private TextView textid,textid1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_);
        textid = findViewById(R.id.textresultid2);
        textid1 = findViewById(R.id.textresultid3);
        Bundle bundle = getIntent().getExtras();
        result = bundle.getInt("result");
        //time = bundle.getString("time");
        textid.setText(String.valueOf(result));
      //  textid1.setText(time);

    }
}
