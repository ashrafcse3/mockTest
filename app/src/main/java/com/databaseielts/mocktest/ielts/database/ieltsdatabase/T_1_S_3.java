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

public class T_1_S_3 extends AppCompatActivity implements View.OnClickListener {

    // For the bottom mp3 player
    private ImageView back, play, front;
    private MediaPlayer mediaPlayer;

    private TextView runningTime, finalTime;

    private int forwardTime = 5000; //5000 milliseconds
    private int backwardTime = 5000;  //5000 milliseconds
    private SeekBar seekbar;
    private Button btn3;
    private int res2;
    public String count;

    // For the Data Initialize
    private String module;
    private int testId, sectionId;

    private TextView _21QuestionFirstId, _21QuestionLastId, _22QuestionFirstId, _22QuestionLastId,_23QuestionFirstId, _23QuestionLastId, _24QuestionFirstId, _24QuestionLastId, _25QuestionFirstId, _25QuestionLastId;
    private TextView _26QuestionFirstId, _26QuestionLastId, _27QuestionFirstId, _27QuestionLastId,_28QuestionFirstId, _28QuestionLastId, _29QuestionFirstId, _29QuestionLastId, _30QuestionFirstId, _30QuestionLastId;
    private EditText _21editTextId, _22editTextId, _23editTextId, _24editTextId, _25editTextId, _26QuestionEditId, _27QuestionEditId, _28QuestionEditId, _29QuestionEditId, _30QuestionEditId;

    MyDatabaseHelper myDatabaseHelper;

    String[] question1, question2, question3, question4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_1_s_3);

        // This method will bring and set the data to the xml layout
        btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        fullDataInitialize();

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

        // set fillBlank All text for question 21
        _21QuestionFirstId.setText(question1[0] + ". " + question2[0]);
        _21QuestionLastId.setText(question3[0]);

        // set fillBlank All text for question 22
        _22QuestionFirstId.setText(question1[1] + ". " + question2[1]);
        _22QuestionLastId.setText(question3[1]);

        // set fillBlank All text for question 23
        _23QuestionFirstId.setText(question1[2] + ". " + question2[2]);
        _23QuestionLastId.setText(question3[2]);

        // set fillBlank All text for question 24
        _24QuestionFirstId.setText(question1[3] + ". " + question2[3]);
        _24QuestionLastId.setText(question3[3]);

        // set fillBlank All text for question 25
        _25QuestionFirstId.setText(question1[4] + ". " + question2[4]);
        _25QuestionLastId.setText(question3[4]);

        // set fillBlank All text for question 26
        _26QuestionFirstId.setText(question1[5] + ". " + question2[5]);
        _26QuestionLastId.setText(question3[5]);

        // set fillBlank All text for question 27
        _27QuestionFirstId.setText(question1[6] + ". " + question2[6]);
        _27QuestionLastId.setText(question3[6]);

        // set fillBlank All text for question 28
        _28QuestionFirstId.setText(question1[7] + ". " + question2[7]);
        _28QuestionLastId.setText(question3[7]);

        // set fillBlank All text for question 29
        _29QuestionFirstId.setText(question1[8] + ". " + question2[8]);
        _29QuestionLastId.setText(question3[8]);

        // set fillBlank All text for question 30
        _30QuestionFirstId.setText(question1[9] + ". " + question2[9]);
        _30QuestionLastId.setText(question3[9]);


    } // fullDataInitialize finished

    private void initializeFillBlankId() {
        // for question no 11
        _21QuestionFirstId = findViewById(R.id._21QuestionFirstId);
        _21QuestionLastId = findViewById(R.id._21QuestionLastId);
        _21editTextId = findViewById(R.id._21editTextId);

        // for question no 12
        _22QuestionFirstId = findViewById(R.id._22QuestionFirstId);
        _22QuestionLastId = findViewById(R.id._22QuestionLastId);
        _22editTextId = findViewById(R.id._22editTextId);

        // for question no 13
        _23QuestionFirstId = findViewById(R.id._23QuestionFirstId);
        _23QuestionLastId = findViewById(R.id._23QuestionLastId);
        _23editTextId = findViewById(R.id._23editTextId);

        // for question no 14
        _24QuestionFirstId = findViewById(R.id._24QuestionFirstId);
        _24QuestionLastId = findViewById(R.id._24QuestionLastId);
        _24editTextId = findViewById(R.id._24editTextId);

        // for question no 15
        _25QuestionFirstId = findViewById(R.id._25QuestionFirstId);
        _25QuestionLastId = findViewById(R.id._25QuestionLastId);
        _25editTextId = findViewById(R.id._25editTextId);

        // for question no 16
        _26QuestionFirstId = findViewById(R.id._26QuestionFirstId);
        _26QuestionLastId = findViewById(R.id._26QuestionLastId);
        _26QuestionEditId = findViewById(R.id._26QuestionEditId);

        // for question no 11
        _27QuestionFirstId = findViewById(R.id._27QuestionFirstId);
        _27QuestionLastId = findViewById(R.id._27QuestionLastId);
        _27QuestionEditId = findViewById(R.id._27QuestionEditId);

        // for question no 11
        _28QuestionFirstId = findViewById(R.id._28QuestionFirstId);
        _28QuestionLastId = findViewById(R.id._28QuestionLastId);
        _28QuestionEditId = findViewById(R.id._28QuestionEditId);

        // for question no 11
        _29QuestionFirstId = findViewById(R.id._29QuestionFirstId);
        _29QuestionLastId = findViewById(R.id._29QuestionLastId);
        _29QuestionEditId = findViewById(R.id._29QuestionEditId);

        // for question no 11
        _30QuestionFirstId = findViewById(R.id._30QuestionFirstId);
        _30QuestionLastId = findViewById(R.id._30QuestionLastId);
        _30QuestionEditId = findViewById(R.id._30QuestionEditId);
    }// 21 - 30 question

    private void mp3Initialize() {
        play = findViewById(R.id.playImageId);
        back = findViewById(R.id.backwardImageId);
        front = findViewById(R.id.forwardIdImageId);

        play.setOnClickListener(this);
        back.setOnClickListener(this);
        front.setOnClickListener(this);

        mediaPlayer = MediaPlayer.create(this, R.raw.t_1_s_3);

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
        if (v.getId() == R.id.btn3){

            boolean bal1= true;
            String ss;
            if (_21editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _21editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[0])) res2++;
            }
            if (_22editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _22editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[1])) res2++;
            }
            if (_23editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _23editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[2])) res2++;
            }
            if (_24editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _24editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[3])) res2++;
            }
            if (_25editTextId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _25editTextId.getText().toString();
                if(ss.equalsIgnoreCase(question4[4])) res2++;
            }
            if (_26QuestionEditId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _26QuestionEditId.getText().toString();
                if(ss.equalsIgnoreCase(question4[5])) res2++;
            }
            if (_27QuestionEditId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _27QuestionEditId.getText().toString();
                if(ss.equalsIgnoreCase(question4[6])) res2++;
            }
            if (_28QuestionEditId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _28QuestionEditId.getText().toString();
                if(ss.equalsIgnoreCase(question4[7])) res2++;
            }
            if (_29QuestionEditId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _29QuestionEditId.getText().toString();
                if(ss.equalsIgnoreCase(question4[8])) res2++;
            }
            if (_30QuestionEditId.getText().toString().equalsIgnoreCase(""))
                bal1=false;
            else{
                ss = _30QuestionEditId.getText().toString();
                if(ss.equalsIgnoreCase(question4[9])) res2++;
            }

            if(bal1==true || bal1==false){
                Intent ress = new Intent(getApplicationContext(),result_Activity.class);
                Bundle makeresult = new Bundle();
                makeresult.putInt("result",res2);
                makeresult.putString("time",count);
                ress.putExtras(makeresult);
                startActivity(ress);
            }
            else Toast.makeText(this,"you miss some of item",Toast.LENGTH_SHORT).show();
            res2 = 0;
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
