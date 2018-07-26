package com.databaseielts.mocktest.ielts.database.ieltsdatabase;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class T_1_S_2 extends AppCompatActivity implements View.OnClickListener {

    // For the bottom mp3 player
    private ImageView back, play, front;
    private MediaPlayer mediaPlayer;
    private boolean bal1=true;
    private  int res1 = 0;
    private String count;
    private TextView runningTime, finalTime;

    private int forwardTime = 5000; //5000 milliseconds
    private int backwardTime = 5000;  //5000 milliseconds
    private SeekBar seekbar;

    // For the Data Initialize
    private String module;
    private int testId, sectionId;

    private Button result1;

    private TextView _11QuestionFirstId, _11QuestionLastId, _12QuestionFirstId, _12QuestionLastId,_13QuestionFirstId, _13QuestionLastId, _14QuestionFirstId, _14QuestionLastId, _15QuestionFirstId, _15QuestionLastId;
    private TextView _16QuestionFirstId, _16QuestionLastId, _17QuestionFirstId, _17QuestionLastId,_18QuestionFirstId, _18QuestionLastId, _19QuestionFirstId, _19QuestionLastId, _20QuestionFirstId, _20QuestionLastId;
    private EditText _11editTextId, _12editTextId, _13editTextId, _14editTextId, _15editTextId,_16editTextId, _17editTextId, _18editTextId, _19editTextId, _20editTextId;
    private TextView _11QuestionId, _12QuestionId, _13QuestionId, _14QuestionId, _15QuestionId, _16QuestionId, _17QuestionId, _18QuestionId, _19QuestionId, _20QuestionId;

    MyDatabaseHelper myDatabaseHelper;

    String[] question1, question2, question3, question4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_1_s_2);

        // This method will bring and set the data to the xml layout
        fullDataInitialize();
        result1 = findViewById(R.id.btn1);
        result1.setOnClickListener(this);
        // This method help to initialize the mp3 file
        mp3Initialize();
    }

    private void fullDataInitialize() {
        myDatabaseHelper = new MyDatabaseHelper(this);

        Bundle bundle = getIntent().getExtras();
        module = bundle.getString("module");
        testId = bundle.getInt("test_id");
        sectionId = bundle.getInt("section_id");

        Cursor result1 = myDatabaseHelper.fetchFillBlankData(module, testId, sectionId);

        String texts;
        // This array for question example, 1 - 10
        question1 = new String[11];
        question2 = new String[11];
        question3 = new String[11];
        question4 = new String[11];

        // For result1 cursor
        if (result1.getCount() == 0) {
            texts = "Contents are not available";
        }
        else {
            int i = 0;
            StringBuffer sss = new StringBuffer();
            while (result1.moveToNext()) {

                question1[i] = result1.getString(0);
                question2[i] = result1.getString(1);
                question3[i] = result1.getString(2);
                question4[i] = result1.getString(3);

                i++;

                sss.append(i + " " + result1.getString(0));
            }
            texts = sss.toString();
        }

        // For linking the fill Blank question
        initializeFillBlankId();

        // set fillBlank All text for question 11
        _11QuestionFirstId.setText(Html.fromHtml(question2[0]));
        _11QuestionId.setText(question1[0] + ". ");
        _11QuestionLastId.setText(Html.fromHtml(question3[0]));

        // set fillBlank All text for question 12
        _12QuestionFirstId.setText(Html.fromHtml(question2[1]));
        _12QuestionId.setText(question1[1] + ". ");
        _12QuestionLastId.setText(Html.fromHtml(question3[1]));

        // set fillBlank All text for question 13
        _13QuestionFirstId.setText(Html.fromHtml(question2[2]));
        _13QuestionId.setText(question1[2] + ". ");
        _13QuestionLastId.setText(Html.fromHtml(question3[2]));

        // set fillBlank All text for question 14
        _14QuestionFirstId.setText(Html.fromHtml(question2[3]));
        _14QuestionId.setText(question1[3] + ". ");
        _14QuestionLastId.setText(Html.fromHtml(question3[3]));

        // set fillBlank All text for question 15
        _15QuestionFirstId.setText(Html.fromHtml(question2[4]));
        _15QuestionId.setText(question1[4] + ". ");
        _15QuestionLastId.setText(Html.fromHtml(question3[4]));

        // set fillBlank All text for question 16
        _16QuestionFirstId.setText(Html.fromHtml(question2[5]));
        _16QuestionId.setText(question1[5] + ". ");
        _16QuestionLastId.setText(Html.fromHtml(question3[5]));

        // set fillBlank All text for question 17
        _17QuestionFirstId.setText(Html.fromHtml(question2[6]));
        _17QuestionId.setText(question1[6] + ". ");
        _17QuestionLastId.setText(Html.fromHtml(question3[6]));

        // set fillBlank All text for question 18
        _18QuestionFirstId.setText(Html.fromHtml(question2[7]));
        _18QuestionId.setText(question1[7] + ". ");
        _18QuestionLastId.setText(Html.fromHtml(question3[7]));

        // set fillBlank All text for question 19
        _19QuestionFirstId.setText(Html.fromHtml(question2[8]));
        _19QuestionId.setText(question1[8] + ". ");
        _19QuestionLastId.setText(Html.fromHtml(question3[8]));

        // set fillBlank All text for question 20
        _20QuestionFirstId.setText(Html.fromHtml(question2[9]));
        _20QuestionId.setText(question1[9] + ". ");
        _20QuestionLastId.setText(Html.fromHtml(question3[9]));


    } // fullDataInitialize finished

    private void initializeFillBlankId() {
        // for question no 11
        _11QuestionFirstId = findViewById(R.id._11QuestionFirstId);
        _11QuestionId = findViewById(R.id._11QuestionId);
        _11QuestionLastId = findViewById(R.id._11QuestionLastId);
        _11editTextId = findViewById(R.id._11editTextId);

        // for question no 12
        _12QuestionFirstId = findViewById(R.id._12QuestionFirstId);
        _12QuestionId = findViewById(R.id._12QuestionId);
        _12QuestionLastId = findViewById(R.id._12QuestionLastId);
        _12editTextId = findViewById(R.id._12editTextId);

        // for question no 13
        _13QuestionFirstId = findViewById(R.id._13QuestionFirstId);
        _13QuestionId = findViewById(R.id._13QuestionId);
        _13QuestionLastId = findViewById(R.id._13QuestionLastId);
        _13editTextId = findViewById(R.id._13editTextId);

        // for question no 14
        _14QuestionFirstId = findViewById(R.id._14QuestionFirstId);
        _14QuestionId = findViewById(R.id._14QuestionId);
        _14QuestionLastId = findViewById(R.id._14QuestionLastId);
        _14editTextId = findViewById(R.id._14editTextId);

        // for question no 15
        _15QuestionFirstId = findViewById(R.id._15QuestionFirstId);
        _15QuestionId = findViewById(R.id._15QuestionId);
        _15QuestionLastId = findViewById(R.id._15QuestionLastId);
        _15editTextId = findViewById(R.id._15editTextId);

        // for question no 16
        _16QuestionFirstId = findViewById(R.id._16QuestionFirstId);
        _16QuestionId = findViewById(R.id._16QuestionId);
        _16QuestionLastId = findViewById(R.id._16QuestionLastId);
        _16editTextId = findViewById(R.id._16editTextId);

        // for question no 11
        _17QuestionFirstId = findViewById(R.id._17QuestionFirstId);
        _17QuestionId = findViewById(R.id._17QuestionId);
        _17QuestionLastId = findViewById(R.id._17QuestionLastId);
        _17editTextId = findViewById(R.id._17editTextId);

        // for question no 11
        _18QuestionFirstId = findViewById(R.id._18QuestionFirstId);
        _18QuestionId = findViewById(R.id._18QuestionId);
        _18QuestionLastId = findViewById(R.id._18QuestionLastId);
        _18editTextId = findViewById(R.id._18editTextId);

        // for question no 11
        _19QuestionFirstId = findViewById(R.id._19QuestionFirstId);
        _19QuestionId = findViewById(R.id._19QuestionId);
        _19QuestionLastId = findViewById(R.id._19QuestionLastId);
        _19editTextId = findViewById(R.id._19editTextId);

        // for question no 11
        _20QuestionFirstId = findViewById(R.id._20QuestionFirstId);
        _20QuestionId = findViewById(R.id._20QuestionId);
        _20QuestionLastId = findViewById(R.id._20QuestionLastId);
        _20editTextId = findViewById(R.id._20editTextId);
    }

    private void mp3Initialize() {
        play = findViewById(R.id.playImageId);
        back = findViewById(R.id.backwardImageId);
        front = findViewById(R.id.forwardIdImageId);

        play.setOnClickListener(this);
        back.setOnClickListener(this);
        front.setOnClickListener(this);

        if (sectionId == 2) {
            mediaPlayer = MediaPlayer.create(this, R.raw.t_1_s_2);
        }
        else if (sectionId == 4) {
            mediaPlayer = MediaPlayer.create(this, R.raw.t_1_s_4);
        }

        // final or full audio time
        finalTime = findViewById(R.id.fullTimeId);
        int time = mediaPlayer.getDuration();
        String timef = Integer.toString(time);
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;
        String timeFinalLabel = "";
        timeFinalLabel = min + ":";
        if (sec < 10) timeFinalLabel += "0";
        timeFinalLabel += sec;
        finalTime.setText(timeFinalLabel);

        // Running timelabel
        runningTime = findViewById(R.id.runningTimeId);

        // Seekbar control
        seekbar = findViewById(R.id.seekBarId);
        seekbar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            mediaPlayer.seekTo(progress);
                            seekBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );


        // Thread (Update positionBar & timelabel)
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mediaPlayer != null) {
                    try {
                        Message message = new Message();
                        message.what = mediaPlayer.getCurrentPosition();
                        handler.sendMessage(message);

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                }
            }
        }).start();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int currentPosition = msg.what;

            // Update Seekbar
            seekbar.setProgress(currentPosition);

            // Update Timelabel
            String elapsedTime = createTimeLabel(currentPosition);
            runningTime.setText(elapsedTime);
            count = elapsedTime;
        }
    };

    public String createTimeLabel(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    };

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.playImageId) {

            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                play.setBackgroundResource(R.drawable.play);
            } else {
                mediaPlayer.start();
                seekbar.setMax(mediaPlayer.getDuration());
                play.setBackgroundResource(R.drawable.pause);
            }
        }


        if (v.getId() == R.id.backwardImageId) {
            //get current song position
            int currentPosition = mediaPlayer.getCurrentPosition();

            //check backward time is greater than 0 sec
            if (currentPosition - backwardTime >= 0) {
                //backward song
                mediaPlayer.seekTo(currentPosition - backwardTime);
            } else {
                //backward to starting position
                mediaPlayer.seekTo(0);
            }
        }


        if (v.getId() == R.id.forwardIdImageId) {
            //get current song position
            int currentPosition = mediaPlayer.getCurrentPosition();

            //check if seekForward time is lesser than song duration
            if (currentPosition + forwardTime <= mediaPlayer.getDuration()) {
                //forward song
                mediaPlayer.seekTo(currentPosition + forwardTime);
            } else {
                mediaPlayer.seekTo(mediaPlayer.getDuration());
            }
        }

        if (v.getId() == R.id.btn1){
            bal1= true;
            String ss;
            if (_11editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _11editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[0])) res1++;
            }
            if (_12editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _12editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[1])) res1++;
            }
            if (_13editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _13editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[2])) res1++;
            }
            if (_14editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _14editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[3])) res1++;
            }
            if (_15editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _15editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[4])) res1++;
            }
            if (_16editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _16editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[5])) res1++;
            }
            if (_17editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _17editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[6])) res1++;
            }
            if (_18editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _18editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[7])) res1++;
            }
            if (_19editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _19editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[8])) res1++;
            }
            if (_20editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _20editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[9])) res1++;
            }

            if(bal1==true || bal1==false){
                Intent ress = new Intent(getApplicationContext(),result_Activity.class);
                Bundle makeresult = new Bundle();
                makeresult.putString("module",module);
                makeresult.putInt("test_id",testId);
                makeresult.putString("time",count);
                makeresult.putInt("result",res1);
                ress.putExtras(makeresult);
                startActivity(ress);
            }
            else Toast.makeText(this,"you miss some of item"+res1,Toast.LENGTH_SHORT).show();
            res1 = 0;
        }

    }

    @Override
    protected void onDestroy () {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
