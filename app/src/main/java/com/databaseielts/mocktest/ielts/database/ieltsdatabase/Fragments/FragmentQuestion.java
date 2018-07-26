package com.databaseielts.mocktest.ielts.database.ieltsdatabase.Fragments;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.databaseielts.mocktest.ielts.database.ieltsdatabase.MyDatabaseHelper;
import com.databaseielts.mocktest.ielts.database.ieltsdatabase.R;
import com.databaseielts.mocktest.ielts.database.ieltsdatabase.result_Activity;

public class FragmentQuestion extends Fragment {

    private TextView _1ReadingQuestionHeaderId, _4ReadingQuestionHeaderId, _8ReadingQuestionHeaderId;

    private TextView _1ReadingQuestionId, _2ReadingQuestionId, _3ReadingQuestionId, _4ReadingQuestionId, _5ReadingQuestionId, _6ReadingQuestionId;
    private TextView _7ReadingQuestionId, _8ReadingQuestionId, _9ReadingQuestionId, _10ReadingQuestionId, _11ReadingQuestionId, _12ReadingQuestionId, _13ReadingQuestionId;

    private TextView _4ReadingFullQuestion, _5ReadingFullQuestion, _6ReadingFullQuestion, _7ReadingFullQuestion, _8ReadingFullQuestion, _9ReadingFullQuestion;
    private TextView _10ReadingFullQuestion, _11ReadingFullQuestion, _12ReadingFullQuestion, _13ReadingFullQuestion;

    private RadioGroup _1ReadingGroup, _2ReadingGroup, _3ReadingGroup;
    private RadioButton _1ReadingAns1, _1ReadingAns2, _1ReadingAns3, _1ReadingAns4, _2ReadingAns1, _2ReadingAns2, _2ReadingAns3, _2ReadingAns4;
    private RadioButton _3ReadingAns1, _3ReadingAns2, _3ReadingAns3, _3ReadingAns4;

    private Spinner _4ReadingSpinnerId, _5ReadingSpinnerId, _6ReadingSpinnerId, _7ReadingSpinnerId, _8ReadingSpinnerId, _9ReadingSpinnerId, _10ReadingSpinnerId, _11ReadingSpinnerId, _12ReadingSpinnerId, _13ReadingSpinnerId;

    private TextView _4ReadingAnswerId;

    MyDatabaseHelper myDatabaseHelper;

    String[] question1, question2, question3, question4, question5, question6, question7, question8, question9, question10;
    String[] matchingFeatureList, matchingInformationList;

    String question4_7List, question1_3Header, question4_7Header, question8_13Header;
    private Button resultbtn1;
    private RadioButton check;
    private int result=0;
    public FragmentQuestion() {
        Log.i("Fragment check", "Fragment Question Created");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_question, container, false);
        resultbtn1 = rootView.findViewById(R.id.resultbtn1);
        initializeNeededStrings();

        resultbtn1 = rootView.findViewById(R.id.resultbtn1);

        fullDataInitialize(rootView);

        resultbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   check = _1ReadingGroup.getCheckedRadioButtonId();
                if(_1ReadingGroup.getCheckedRadioButtonId()==_1ReadingAns1.getId() || _1ReadingGroup.getCheckedRadioButtonId()==_1ReadingAns2.getId() || _1ReadingGroup.getCheckedRadioButtonId()==_1ReadingAns3.getId() || _1ReadingGroup.getCheckedRadioButtonId()==_1ReadingAns4.getId()){
                    check = rootView.findViewById(_1ReadingGroup.getCheckedRadioButtonId());
                    String ss = check.getText().toString();
                    if(ss.equalsIgnoreCase(question7[0])){
                        result++;
                    }
                }

                if(_2ReadingGroup.getCheckedRadioButtonId()==_2ReadingAns1.getId() || _2ReadingGroup.getCheckedRadioButtonId()==_2ReadingAns2.getId() || _2ReadingGroup.getCheckedRadioButtonId()==_2ReadingAns3.getId() || _2ReadingGroup.getCheckedRadioButtonId()==_2ReadingAns4.getId()){
                    check = rootView.findViewById(_2ReadingGroup.getCheckedRadioButtonId());
                    String ss = check.getText().toString();
                    if(ss.equalsIgnoreCase(question7[1])){
                        result++;
                    }
                }

                if(_3ReadingGroup.getCheckedRadioButtonId()==_3ReadingAns1.getId() || _3ReadingGroup.getCheckedRadioButtonId()==_3ReadingAns2.getId() || _3ReadingGroup.getCheckedRadioButtonId()==_3ReadingAns3.getId() || _3ReadingGroup.getCheckedRadioButtonId()==_3ReadingAns4.getId()){
                    check = rootView.findViewById(_2ReadingGroup.getCheckedRadioButtonId());
                    String ss = check.getText().toString();
                    if(ss.equalsIgnoreCase(question7[2])){
                        result++;
                    }
                }
                if (_4ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _4ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question10[0])){
                            result++;
                    }
                }
                if (_5ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _5ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question10[1])){
                        result++;
                    }
                }

                if (_6ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _6ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question10[2])){
                        result++;
                    }
                }
                if (_7ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _7ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question10[3])){
                        result++;
                    }
                }
                if (_8ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _8ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question10[4])){
                        result++;
                    }
                }

                if (_9ReadingSpinnerId.getSelectedItemPosition() < 0) {//Do something

                    String value = _9ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question10[5])){
                        result++;
                    }
                }

                if (_10ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _10ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question10[6])){
                        result++;
                    }
                }

                if (_11ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _11ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question10[7])){
                        result++;
                    }
                }

                if (_12ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _12ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question10[8])){
                        result++;
                    }
                }

                if (_13ReadingSpinnerId.getSelectedItemPosition() > 0){//Do something

                    String value = _13ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question10[9])){
                        result++;
                    }
                }

                Intent ress = new Intent(getContext(),result_Activity.class);
                Bundle makeresult = new Bundle();
                makeresult.putInt("result",result);
                ress.putExtras(makeresult);
                startActivity(ress);

                result = 0;





            }
        });





        return rootView;
    }

    private void fullDataInitialize(View rootView) {
        myDatabaseHelper = new MyDatabaseHelper(getActivity());

        Cursor result1 = myDatabaseHelper.fetchReadingMCQs(1, 1);
        Cursor result2 = myDatabaseHelper.fetchMatchingThings(1, 1);

        String texts;
        String texts2;

        // This array for question example, 1-3
        question1 = new String[4];
        question2 = new String[4];
        question3 = new String[4];
        question4 = new String[4];
        question5 = new String[4];
        question6 = new String[4];
        question7 = new String[4];

        // This array for question example, 4-13
        question8 = new String[11];
        question9 = new String[11];
        question10 = new String[11];

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
                question7[i] = result1.getString(6);

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
            int i = 0;
            StringBuffer sss = new StringBuffer();
            while (result2.moveToNext()) {

                question8[i] = result2.getString(0);
                question9[i] = result2.getString(1);
                question10[i] = result2.getString(2);

                i++;

                sss.append(i + " " + result2.getString(0));
            }
            texts2 = sss.toString();
        }
        // Set Question 1-3
        initializeMCQs(rootView);
        setQuestion_1_3();

        // Set Question 4-13
        initializeMatchingthings(rootView);
        setQuestion_4_13();
    }

    private void setQuestion_4_13() {
        // Set question 4-7
        matchingFeatureList = getResources().getStringArray(R.array.matching_feature_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_view, R.id.textViewSpinnerId, matchingFeatureList);

        // set Question 4-7 extra things
        _4ReadingQuestionHeaderId.setText(Html.fromHtml(question4_7Header));
        _4ReadingAnswerId.setText(Html.fromHtml(question4_7List));

        // set All text for question 4
        _4ReadingQuestionId.setText(question8[0] + ".");
        _4ReadingSpinnerId.setAdapter(arrayAdapter);
        _4ReadingFullQuestion.setText(question9[0]);

        // set All text for question 5
        _5ReadingQuestionId.setText(question8[1] + ".");
        _5ReadingSpinnerId.setAdapter(arrayAdapter);
        _5ReadingFullQuestion.setText(question9[1]);

        // set All text for question 6
        _6ReadingQuestionId.setText(question8[2] + ".");
        _6ReadingSpinnerId.setAdapter(arrayAdapter);
        _6ReadingFullQuestion.setText(question9[2]);

        // set All text for question 7
        _7ReadingQuestionId.setText(question8[3] + ".");
        _7ReadingSpinnerId.setAdapter(arrayAdapter);
        _7ReadingFullQuestion.setText(question9[3]);

        // set Question 8-13 extra things
        _8ReadingQuestionHeaderId.setText(Html.fromHtml(question8_13Header));

        // Set question 8-13
        matchingInformationList = getResources().getStringArray(R.array.matching_information_list);
        ArrayAdapter<String> arrayInformationAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_view, R.id.textViewSpinnerId, matchingInformationList);

        // set All text for question 8
        _8ReadingQuestionId.setText(question8[4] + ".");
        _8ReadingSpinnerId.setAdapter(arrayInformationAdapter);
        _8ReadingFullQuestion.setText(question9[4]);

        // set All text for question 9
        _9ReadingQuestionId.setText(question8[5] + ".");
        _9ReadingSpinnerId.setAdapter(arrayInformationAdapter);
        _9ReadingFullQuestion.setText(question9[5]);

        // set All text for question 10
        _10ReadingQuestionId.setText(question8[6] + ".");
        _10ReadingSpinnerId.setAdapter(arrayInformationAdapter);
        _10ReadingFullQuestion.setText(question9[6]);

        // set All text for question 11
        _11ReadingQuestionId.setText(question8[7] + ".");
        _11ReadingSpinnerId.setAdapter(arrayInformationAdapter);
        _11ReadingFullQuestion.setText(question9[7]);

        // set All text for question 12
        _12ReadingQuestionId.setText(question8[8] + ".");
        _12ReadingSpinnerId.setAdapter(arrayInformationAdapter);
        _12ReadingFullQuestion.setText(question9[8]);

        // set All text for question 13
        _13ReadingQuestionId.setText(question8[9] + ".");
        _13ReadingSpinnerId.setAdapter(arrayInformationAdapter);
        _13ReadingFullQuestion.setText(question9[9]);
    }

    private void setQuestion_1_3() {
        // set Question 1-3 Header
        _1ReadingQuestionHeaderId.setText(Html.fromHtml(question1_3Header));

        // set All text for question 1
        _1ReadingQuestionId.setText(question1[0] +". "+ question2[0]);
        _1ReadingAns1.setText(question3[0]);
        _1ReadingAns2.setText(question4[0]);
        _1ReadingAns3.setText(question5[0]);
        _1ReadingAns4.setText(question6[0]);

        // set All text for question 2
        _2ReadingQuestionId.setText(question1[1] +". "+ question2[1]);
        _2ReadingAns1.setText(question3[1]);
        _2ReadingAns2.setText(question4[1]);
        _2ReadingAns3.setText(question5[1]);
        _2ReadingAns4.setText(question6[1]);

        // set All text for question 3
        _3ReadingQuestionId.setText(question1[2] +". "+ question2[2]);
        _3ReadingAns1.setText(question3[2]);
        _3ReadingAns2.setText(question4[2]);
        _3ReadingAns3.setText(question5[2]);
        _3ReadingAns4.setText(question6[2]);
    }

    private void initializeMatchingthings(View rootView) {

        // Question 4-7 extra things
        _4ReadingQuestionHeaderId = rootView.findViewById(R.id._4ReadingQuestionHeaderId);
        _4ReadingAnswerId = rootView.findViewById(R.id._4ReadingAnswerId);

        // Question no 4
        _4ReadingQuestionId = rootView.findViewById(R.id._4ReadingQuestionId);
        _4ReadingSpinnerId = rootView.findViewById(R.id._4ReadingSpinnerId);
        _4ReadingFullQuestion = rootView.findViewById(R.id._4ReadingFullQuestion);

        // Question no 5
        _5ReadingQuestionId = rootView.findViewById(R.id._5ReadingQuestionId);
        _5ReadingSpinnerId = rootView.findViewById(R.id._5ReadingSpinnerId);
        _5ReadingFullQuestion = rootView.findViewById(R.id._5ReadingFullQuestion);

        // Question no 6
        _6ReadingQuestionId = rootView.findViewById(R.id._6ReadingQuestionId);
        _6ReadingSpinnerId = rootView.findViewById(R.id._6ReadingSpinnerId);
        _6ReadingFullQuestion = rootView.findViewById(R.id._6ReadingFullQuestion);

        // Question no 7
        _7ReadingQuestionId = rootView.findViewById(R.id._7ReadingQuestionId);
        _7ReadingSpinnerId = rootView.findViewById(R.id._7ReadingSpinnerId);
        _7ReadingFullQuestion = rootView.findViewById(R.id._7ReadingFullQuestion);

        // set Question 8-13 Header
        _8ReadingQuestionHeaderId = rootView.findViewById(R.id._8ReadingQuestionHeaderId);

        // Question no 8
        _8ReadingQuestionId = rootView.findViewById(R.id._8ReadingQuestionId);
        _8ReadingSpinnerId = rootView.findViewById(R.id._8ReadingSpinnerId);
        _8ReadingFullQuestion = rootView.findViewById(R.id._8ReadingFullQuestion);

        // Question no 9
        _9ReadingQuestionId = rootView.findViewById(R.id._9ReadingQuestionId);
        _9ReadingSpinnerId = rootView.findViewById(R.id._9ReadingSpinnerId);
        _9ReadingFullQuestion = rootView.findViewById(R.id._9ReadingFullQuestion);

        // Question no 10
        _10ReadingQuestionId = rootView.findViewById(R.id._10ReadingQuestionId);
        _10ReadingSpinnerId = rootView.findViewById(R.id._10ReadingSpinnerId);
        _10ReadingFullQuestion = rootView.findViewById(R.id._10ReadingFullQuestion);

        // Question no 11
        _11ReadingQuestionId = rootView.findViewById(R.id._11ReadingQuestionId);
        _11ReadingSpinnerId = rootView.findViewById(R.id._11ReadingSpinnerId);
        _11ReadingFullQuestion = rootView.findViewById(R.id._11ReadingFullQuestion);

        // Question no 12
        _12ReadingQuestionId = rootView.findViewById(R.id._12ReadingQuestionId);
        _12ReadingSpinnerId = rootView.findViewById(R.id._12ReadingSpinnerId);
        _12ReadingFullQuestion = rootView.findViewById(R.id._12ReadingFullQuestion);

        // Question no 13
        _13ReadingQuestionId = rootView.findViewById(R.id._13ReadingQuestionId);
        _13ReadingSpinnerId = rootView.findViewById(R.id._13ReadingSpinnerId);
        _13ReadingFullQuestion = rootView.findViewById(R.id._13ReadingFullQuestion);
    } // initializeMatchingthings finished

    private void initializeMCQs(View rootview) {

        // set Question 1-3 Header
        _1ReadingQuestionHeaderId = rootview.findViewById(R.id._1ReadingQuestionHeaderId);

        // Question no 1
        _1ReadingQuestionId = rootview.findViewById(R.id._1ReadingQuestionId);
        _1ReadingGroup = rootview.findViewById(R.id._1ReadingGroup);
        _1ReadingAns1 = rootview.findViewById(R.id._1ReadingAns1);
        _1ReadingAns2 = rootview.findViewById(R.id._1ReadingAns2);
        _1ReadingAns3 = rootview.findViewById(R.id._1ReadingAns3);
        _1ReadingAns4 = rootview.findViewById(R.id._1ReadingAns4);

        // Question no 2
        _2ReadingQuestionId = rootview.findViewById(R.id._2ReadingQuestionId);
        _2ReadingGroup = rootview.findViewById(R.id._2ReadingGroup);
        _2ReadingAns1 = rootview.findViewById(R.id._2ReadingAns1);
        _2ReadingAns2 = rootview.findViewById(R.id._2ReadingAns2);
        _2ReadingAns3 = rootview.findViewById(R.id._2ReadingAns3);
        _2ReadingAns4 = rootview.findViewById(R.id._2ReadingAns4);

        // Question no 3
        _3ReadingQuestionId = rootview.findViewById(R.id._3ReadingQuestionId);
        _3ReadingGroup = rootview.findViewById(R.id._3ReadingGroup);
        _3ReadingAns1 = rootview.findViewById(R.id._3ReadingAns1);
        _3ReadingAns2 = rootview.findViewById(R.id._3ReadingAns2);
        _3ReadingAns3 = rootview.findViewById(R.id._3ReadingAns3);
        _3ReadingAns4 = rootview.findViewById(R.id._3ReadingAns4);
    } // initializeMCQs finished

    public void initializeNeededStrings() {
        question4_7List = "<b>List of people</b><br>" +
                "<b>A</b> Roger Chaffin<br>" +
                "<b>B</b> Susan Ball<br>" +
                "<b>C</b> Steven Brown<br>" +
                "<b>D</b> Caroline Palmer<br>" +
                "<b>E</b> Sandra Calvert<br>" +
                "<b>F</b> Leon James";

        question1_3Header = "<i><b>Questions 1-3</b><br>" +
                "Choose the correct answer<br>" +
                "Write your answers in boxes 1-3 on your answer sheet.</i>";

        question4_7Header = "<i><b>Questions 4-7</b><br>" +
                "Look at the following theories, questions 4-7, and the list of people below.<br>" +
                "Match each theory with the person it is credited to.<br>" +
                "Write the correct letter <b>A-F</b> in boxes 4-7 on your answer sheet.</i>";

        question8_13Header = "<i><b>Questions 8-13</b><br>" +
                "Reading Passage 1 has nine paragraphs labelled <b>A-I</b>.<br>" +
                "Which paragraph contains the following information?<br>" +
                "Write the correct letter <b>A-I</b> in boxes 8-13 on your answer sheet.<br>" +
                "<b>NB </b> You may use any letter more than once.</i>";
    } // initializeNeededStrings finished



}
