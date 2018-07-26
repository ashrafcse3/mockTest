package com.databaseielts.mocktest.ielts.database.ieltsdatabase;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class T_1_S_1 extends AppCompatActivity implements View.OnClickListener {

        // For the bottom mp3 player
        private ImageView back, play, front;
        private MediaPlayer mediaPlayer;
        public String count;
        private TextView runningTime, finalTime;

        private int forwardTime = 5000; //5000 milliseconds
        private int backwardTime = 5000;  //5000 milliseconds
        private SeekBar seekbar;
        private  int res=0;
        private  boolean bal=true;

        // For the Data Initialize
        private String module;
        private int testId, sectionId;
       private RadioButton check;

        private TextView exampleQuestion, Question1, Question2, Question3, Question4, Question5;
        private RadioGroup exampleGroup, Group1, Group2, Group3, Group4, Group5;
        private RadioButton eQAns1, eQAns2, eQAns3, _1Ans1, _1Ans2, _1Ans3, _2Ans1, _2Ans2, _2Ans3;
        private RadioButton _3Ans1, _3Ans2, _3Ans3, _4Ans1, _4Ans2, _4Ans3, _5Ans1, _5Ans2, _5Ans3;
        private TextView _6QuestionFirstId, _6QuestionLastId, _7QuestionFirstId, _7QuestionLastId;
        private TextView _8QuestionFirstId, _8QuestionLastId, _9QuestionFirstId, _9QuestionLastId, _10QuestionFirstId, _10QuestionLastId;
        private EditText _6AnsEditText, _7AnsEditText, _8AnsEditText, _9AnsEditText, _10AnsEditText;
        private Button result;

        MyDatabaseHelper myDatabaseHelper;

        String[] question1, question2, question3, question4, question5, question6, question7, question8, question9, question10;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_t_1_s_1);

                // This method will bring and set the data to the xml layout
                fullDataInitialize();
                result = findViewById(R.id.btn);
                result.setOnClickListener(this);
                //dataInitialize();

                // This method help to initialize the mp3 file
                mp3Initialize();

        }//onCreate finished






    private void fullDataInitialize() {
        myDatabaseHelper = new MyDatabaseHelper(this);

        Bundle bundle = getIntent().getExtras();
        module = bundle.getString("module");
        testId = bundle.getInt("test_id");
        sectionId = bundle.getInt("section_id");

        Cursor result1 = myDatabaseHelper.fetchTableWholeData(module, testId, sectionId);
        Cursor result2 = myDatabaseHelper.fetchFillBlankData(module, testId, sectionId);

        String texts;
        String texts2;
        // This array for question example, 1 - 5
        question1 = new String[6];
        question2 = new String[6];
        question3 = new String[6];
        question4 = new String[6];
        question5 = new String[6];
        question6 = new String[6];

        // This array for question 6 - 10
        question7 = new String[5];
        question8 = new String[5];
        question9 = new String[5];
        question10 = new String[5];

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
                question5[i] = result1.getString(4);
                question6[i] = result1.getString(5);

                i++;

                sss.append(i + " " + result1.getString(0));
            }
            texts = sss.toString();
        }

        // For result2 cursor
        if (result2.getCount() == 0) {
            texts2 = "Contents are not available";
        }
        else {
            int j = 0;
            StringBuffer stringBuffer = new StringBuffer();
            while (result2.moveToNext()) {

                question7[j] = result2.getString(0);
                question8[j] = result2.getString(1);
                question9[j] = result2.getString(2);
                question10[j] = result2.getString(3);

                j++;

                stringBuffer.append(j + " " + result2.getString(0));
            }
            texts2 = stringBuffer.toString();
        }

        // For linking the question.
        initializeQuestionId();

        // For linking the fill Blank question
        initializeFillBlankId();

        // set All text for example question
        exampleQuestion.setText(question2[0]);
        eQAns1.setText(question3[0]);
        eQAns2.setText(question4[0]);
        eQAns3.setText(question5[0]);

        // set All text for question 1
        Question1.setText(question1[1]+"."+question2[1]);
        _1Ans1.setText(question3[1]);
        _1Ans2.setText(question4[1]);
        _1Ans3.setText(question5[1]);

        // set All text for question 2
        Question2.setText(question1[2]+"."+question2[2]);
        _2Ans1.setText(question3[2]);
        _2Ans2.setText(question4[2]);
        _2Ans3.setText(question5[2]);

        // set All text for question 3
        Question3.setText(question1[3]+"."+question2[3]);
        _3Ans1.setText(question3[3]);
        _3Ans2.setText(question4[3]);
        _3Ans3.setText(question5[3]);

        // set All text for question 4
        Question4.setText(question1[4]+"."+question2[4]);
        _4Ans1.setText(question3[4]);
        _4Ans2.setText(question4[4]);
        _4Ans3.setText(question5[4]);

        // set All text for question 5
        Question5.setText(question1[5]+"."+question2[5]);
        _5Ans1.setText(question3[5]);
        _5Ans2.setText(question4[5]);
        _5Ans3.setText(question5[5]);


        // set fillBlank All text for question 6
        _6QuestionFirstId.setText(question7[0] + "." + question8[0]);
        _6QuestionLastId.setText(question9[0]);

        // set fillBlank All text for question 7
        _7QuestionFirstId.setText(question7[1] + "." + question8[1]);
        _7QuestionLastId.setText(question9[1]);

        // set fillBlank All text for question 8
        _8QuestionFirstId.setText(question7[2] + "." + question8[2]);
        _8QuestionLastId.setText(question9[2]);

        // set fillBlank All text for question 9
        _9QuestionFirstId.setText(question7[3] + "." + question8[3]);
        _9QuestionLastId.setText(question9[3]);

        // set fillBlank All text for question 10
        _10QuestionFirstId.setText(question7[4] + "." + question8[4]);
        _10QuestionLastId.setText(question9[4]);

    } // fullDataInitialize finished

    private void initializeFillBlankId() {
        // for question no 6
        _6QuestionFirstId = findViewById(R.id._6QuestionFirstId);
        _6QuestionLastId = findViewById(R.id._6QuestionLastId);
        _6AnsEditText = findViewById(R.id._6Ans);

        // for question no 7
        _7QuestionFirstId = findViewById(R.id._7QuestionFirstId);
        _7QuestionLastId = findViewById(R.id._7QuestionLastId);
        _7AnsEditText = findViewById(R.id._7Ans);

        // for question no 8
        _8QuestionFirstId = findViewById(R.id._8QuestionFirstId);
        _8QuestionLastId = findViewById(R.id._8QuestionLastId);
        _8AnsEditText = findViewById(R.id._8Ans);

        // for question no 6
        _9QuestionFirstId = findViewById(R.id._9QuestionFirstId);
        _9QuestionLastId = findViewById(R.id._9QuestionLastId);
        _9AnsEditText = findViewById(R.id._9Ans);

        // for question no 6
        _10QuestionFirstId = findViewById(R.id._10QuestionFirstId);
        _10QuestionLastId = findViewById(R.id._10QuestionLastId);
        _10AnsEditText = findViewById(R.id._10Ans);
    }

    private void initializeQuestionId() {
        // for example question
        exampleQuestion = findViewById(R.id.exampleQuestionId);
        exampleGroup = findViewById(R.id._exampleGroup);
        eQAns1 = findViewById(R.id.exampleAns1);
        eQAns2 = findViewById(R.id.exampleAns2);
        eQAns3 = findViewById(R.id.exampleAns3);

        // for question no 1
        Question1 = findViewById(R.id._1QuestionId);
        Group1 = findViewById(R.id._1Group);
        _1Ans1 = findViewById(R.id._1Ans1);
        _1Ans2 = findViewById(R.id._1Ans2);
        _1Ans3 = findViewById(R.id._1Ans3);

        // for question no 2
        Question2 = findViewById(R.id._2QuestionId);
        Group2 = findViewById(R.id._2Group);
        _2Ans1 = findViewById(R.id._2Ans1);
        _2Ans2 = findViewById(R.id._2Ans2);
        _2Ans3 = findViewById(R.id._2Ans3);

        // for question no 3
        Question3 = findViewById(R.id._3QuestionId);
        Group3 = findViewById(R.id._3Group);
        _3Ans1 = findViewById(R.id._3Ans1);
        _3Ans2 = findViewById(R.id._3Ans2);
        _3Ans3 = findViewById(R.id._3Ans3);

        // for question no 4
        Question4 = findViewById(R.id._4QuestionId);
        Group4 = findViewById(R.id._4Group);
        _4Ans1 = findViewById(R.id._4Ans1);
        _4Ans2 = findViewById(R.id._4Ans2);
        _4Ans3 = findViewById(R.id._4Ans3);

        // for question no 5
        Question5 = findViewById(R.id._5QuestionId);
        Group5 = findViewById(R.id._5Group);
        _5Ans1 = findViewById(R.id._5Ans1);
        _5Ans2 = findViewById(R.id._5Ans2);
        _5Ans3 = findViewById(R.id._5Ans3);
    }

    private void dataInitialize() {
                myDatabaseHelper = new MyDatabaseHelper(this);

                Bundle bundle = getIntent().getExtras();
                module = bundle.getString("module");
                testId = bundle.getInt("test_id");
                sectionId = bundle.getInt("section_id");

                Cursor result1 = myDatabaseHelper.fetchData(module, testId, sectionId, 3);

                String texts;
                question1 = new String[5];
                //String[] question2 = new String[5];
                //String[] question3 = new String[5];
                //String[] question4 = new String[5];
                //String[] question5 = new String[5];

                if (result1.getCount() == 0) {
                        texts = "Contents are not available";
                }
                else {
                        int i = 0;
                        StringBuffer sss = new StringBuffer();
                        while (result1.moveToNext()) {

                                question1[0] = result1.getString(0);
                                question1[1] = result1.getString(1);
                                question1[2] = result1.getString(2);
                                question1[3] = result1.getString(3);
                                question1[4] = result1.getString(4);

                                i++;

                                sss.append(i + " " + result1.getString(0));
                        }
                        texts = sss.toString();
                }

                exampleQuestion = findViewById(R.id.exampleQuestionId);
                eQAns1 = findViewById(R.id.exampleAns1);
                eQAns2 = findViewById(R.id.exampleAns2);
                eQAns3 = findViewById(R.id.exampleAns3);

                exampleQuestion.setText(question1[0]);
                eQAns1.setText(question1[1]);
                eQAns2.setText(question1[2]);
                eQAns3.setText(question1[3]);
        } // DataInitialize finished

    private void mp3Initialize() {
            play = findViewById(R.id.playImageId);
            back = findViewById(R.id.backwardImageId);
            front = findViewById(R.id.forwardIdImageId);

            play.setOnClickListener(this);
            back.setOnClickListener(this);
            front.setOnClickListener(this);

            mediaPlayer = MediaPlayer.create(this, R.raw.t1_section_1);

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

            // for result button
            if(v.getId()==R.id.btn){
                _6QuestionFirstId = findViewById(R.id._6QuestionFirstId);
                _6QuestionLastId = findViewById(R.id._6QuestionLastId);
                _6AnsEditText = findViewById(R.id._6Ans);

                // for question no 7
                _7QuestionFirstId = findViewById(R.id._7QuestionFirstId);
                _7QuestionLastId = findViewById(R.id._7QuestionLastId);
                _7AnsEditText = findViewById(R.id._7Ans);

                // for question no 8
                _8QuestionFirstId = findViewById(R.id._8QuestionFirstId);
                _8QuestionLastId = findViewById(R.id._8QuestionLastId);
                _8AnsEditText = findViewById(R.id._8Ans);

                // for question no 6
                _9QuestionFirstId = findViewById(R.id._9QuestionFirstId);
                _9QuestionLastId = findViewById(R.id._9QuestionLastId);
                _9AnsEditText = findViewById(R.id._9Ans);

                // for question no 6
                _10QuestionFirstId = findViewById(R.id._10QuestionFirstId);
                _10QuestionLastId = findViewById(R.id._10QuestionLastId);
                _10AnsEditText = findViewById(R.id._10Ans);



                if(Group1.getCheckedRadioButtonId()==_1Ans1.getId() || Group1.getCheckedRadioButtonId()==_1Ans2.getId()|| Group1.getCheckedRadioButtonId()==_1Ans3.getId()){
                    check = findViewById(Group1.getCheckedRadioButtonId());
                    String ss = check.getText().toString();
                    if(ss.equalsIgnoreCase(question6[1])){
                        res++;
                    }
                }
                else{bal =false;}
                if(Group2.getCheckedRadioButtonId()==_2Ans1.getId() || Group2.getCheckedRadioButtonId()==_2Ans2.getId()|| Group2.getCheckedRadioButtonId()==_2Ans3.getId()){
                    check = findViewById(Group2.getCheckedRadioButtonId());
                    String ss = check.getText().toString();
                    if(ss.equalsIgnoreCase(question6[2])){
                        res++;
                    }
                }
                else{bal =false;}
                if(Group3.getCheckedRadioButtonId()==_3Ans1.getId() || Group3.getCheckedRadioButtonId()==_3Ans2.getId()|| Group3.getCheckedRadioButtonId()==_3Ans3.getId()){
                    check = findViewById(Group3.getCheckedRadioButtonId());
                    String ss = check.getText().toString();
                    if(ss.equalsIgnoreCase(question6[3])){
                        res++;
                    }
                }
                else{bal =false;}
                if(Group4.getCheckedRadioButtonId()==_4Ans1.getId() || Group4.getCheckedRadioButtonId()==_4Ans2.getId()|| Group4.getCheckedRadioButtonId()==_4Ans3.getId()){
                    check = findViewById(Group4.getCheckedRadioButtonId());
                    String ss = check.getText().toString();
                    if(ss.equalsIgnoreCase(question6[4])){
                        res++;
                    }
                }
                else{bal =false;}
                if(Group5.getCheckedRadioButtonId()==_5Ans1.getId() || Group5.getCheckedRadioButtonId()==_5Ans2.getId()|| Group5.getCheckedRadioButtonId()==_5Ans3.getId()){
                    check = findViewById(Group5.getCheckedRadioButtonId());
                    String ss = check.getText().toString();
                    if(ss.equalsIgnoreCase(question6[5])){
                        res++;
                    }
                }
                else{bal =false;}
                if(_6AnsEditText.getText().toString().equalsIgnoreCase("")) bal = false;

                else   if(_6AnsEditText.getText().toString().equalsIgnoreCase(question10[0])) res++;

                if(_7AnsEditText.getText().toString().equalsIgnoreCase("")) bal = false;

                else  if(_7AnsEditText.getText().toString().equalsIgnoreCase(question10[1])) res++;


                if(_8AnsEditText.getText().toString().equalsIgnoreCase("")) bal = false;

                else  if(_8AnsEditText.getText().toString().equalsIgnoreCase(question10[2])) res++;

                if(_9AnsEditText.getText().toString().equalsIgnoreCase("")) bal = false;

                else  if(_9AnsEditText.getText().toString().equalsIgnoreCase(question10[3])) res++;


                if(_10AnsEditText.getText().toString().equalsIgnoreCase("")) bal = false;

                else  if(_10AnsEditText.getText().toString().equalsIgnoreCase(question10[4])) res++;

                if(bal==true || bal==false){
                    Intent ress = new Intent(getApplicationContext(),result_Activity.class);
                    Bundle makeresult = new Bundle();
                    makeresult.putString("module",module);
                    makeresult.putInt("test_id",testId);
                    makeresult.putInt("section_id",sectionId);
                    makeresult.putInt("result",res);
                    makeresult.putString("time",count);
                    ress.putExtras(makeresult);
                    startActivity(ress);
                }
                else Toast.makeText(this,"you miss some of item",Toast.LENGTH_SHORT).show();
                res = 0;
                bal=true;

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


