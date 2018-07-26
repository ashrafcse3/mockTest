package com.databaseielts.mocktest.ielts.database.ieltsdatabase.Fragments;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.databaseielts.mocktest.ielts.database.ieltsdatabase.MyDatabaseHelper;
import com.databaseielts.mocktest.ielts.database.ieltsdatabase.R;
import com.databaseielts.mocktest.ielts.database.ieltsdatabase.result_Activity;

public class FragmentQuestion2 extends Fragment {

    private TextView _14ReadingQuestionHeaderId, _20ReadingQuestionHeaderId, _26ReadingQuestionHeaderId;

    private TextView _14ReadingAnswerId;

    private TextView _14ReadingQuestionId, _15ReadingQuestionId, _16ReadingQuestionId, _17ReadingQuestionId, _18ReadingQuestionId, _19ReadingQuestionId;
    private TextView _26ReadingQuestionId, _27ReadingQuestionId;
    private TextView _20QuestionFirstId, _20QuestionLastId,_21QuestionFirstId, _21QuestionLastId,_22QuestionFirstId, _22QuestionLastId,_23QuestionFirstId, _23QuestionLastId,_24QuestionFirstId, _24QuestionLastId,_25QuestionFirstId, _25QuestionLastId;

    private EditText _20editTextId, _21editTextId, _22editTextId, _23editTextId, _24editTextId, _25editTextId;

    private TextView _14ReadingFullQuestion, _15ReadingFullQuestion, _16ReadingFullQuestion, _17ReadingFullQuestion, _18ReadingFullQuestion, _19ReadingFullQuestion;
    private Spinner _14ReadingSpinnerId, _15ReadingSpinnerId, _16ReadingSpinnerId, _17ReadingSpinnerId, _18ReadingSpinnerId, _19ReadingSpinnerId;

    private RadioGroup _26ReadingGroup, _27ReadingGroup;
    private RadioButton _26ReadingAns1, _26ReadingAns2, _26ReadingAns3, _26ReadingAns4, _27ReadingAns1, _27ReadingAns2, _27ReadingAns3, _27ReadingAns4;

    MyDatabaseHelper myDatabaseHelper;

    // 3 array for matchingThings, 4 array for fill in the Blank, 7 array for Reading MCQs.
    String[] question1, question2, question3, question4, question5, question6, question7, question8, question9, question10, question11, question12, question13, question14;
    String[] matchingStatements;

    private Button resultbtn2;
    private RadioButton check;
    private int result=0;

    String question14_19List, question14_19Header, question20_25Header, question26_27Header;

    public FragmentQuestion2() {
        Log.i("Fragment check", "Fragment Question Created");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_question_2, container, false);

        initializeNeededStrings();

        fullDataInitialize(rootView);

        resultbtn2 = rootView.findViewById(R.id.resultbtn2);

        resultbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (_14ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _14ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question3[0])){
                        result++;
                    }
                }
                if (_15ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _15ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question3[1])){
                        result++;
                    }
                }
                if (_16ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _16ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question3[2])){
                        result++;
                    }
                }
                if (_17ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _17ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question3[3])){
                        result++;
                    }
                }
                if (_18ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _18ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question3[4])){
                        result++;
                    }
                }
                if (_19ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _19ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question3[5])){
                        result++;
                    }
                }
                if (_20editTextId.getText().toString().equalsIgnoreCase(question7[0])){
                    result++;
                }
                if (_21editTextId.getText().toString().equalsIgnoreCase(question7[1])){
                    result++;
                }
                if (_22editTextId.getText().toString().equalsIgnoreCase(question7[2])){
                    result++;
                }
                if (_23editTextId.getText().toString().equalsIgnoreCase(question7[3])){
                    result++;
                }
                if (_24editTextId.getText().toString().equalsIgnoreCase(question7[4])){
                    result++;
                }
                if (_25editTextId.getText().toString().equalsIgnoreCase(question7[5])){
                    result++;
                }


                if(_26ReadingGroup.getCheckedRadioButtonId()==_26ReadingAns1.getId() || _26ReadingGroup.getCheckedRadioButtonId()==_26ReadingAns2.getId() || _26ReadingGroup.getCheckedRadioButtonId()==_26ReadingAns3.getId() || _26ReadingGroup.getCheckedRadioButtonId()==_26ReadingAns4.getId()){
                    check = rootView.findViewById(_26ReadingGroup.getCheckedRadioButtonId());
                    String ss = check.getText().toString();
                    if(ss.equalsIgnoreCase(question14[0])){
                        result++;
                    }
                }

                if(_27ReadingGroup.getCheckedRadioButtonId()==_27ReadingAns1.getId() || _27ReadingGroup.getCheckedRadioButtonId()==_27ReadingAns2.getId() || _27ReadingGroup.getCheckedRadioButtonId()==_27ReadingAns3.getId() || _27ReadingGroup.getCheckedRadioButtonId()==_27ReadingAns4.getId()){
                    check = rootView.findViewById(_27ReadingGroup.getCheckedRadioButtonId());
                    String ss = check.getText().toString();
                    if(ss.equalsIgnoreCase(question14[1])){
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

        Cursor result1 = myDatabaseHelper.fetchMatchingThings(1, 2);
        Cursor result2 = myDatabaseHelper.fetchFillBlankData("reading",1, 2);
        Cursor result3 = myDatabaseHelper.fetchReadingMCQs(1, 2);

        String texts;
        String texts2;
        String texts3;

        // This array for question 14-19
        question1 = new String[7];
        question2 = new String[7];
        question3 = new String[7];

        // This array for question 20-25
        question4 = new String[7];
        question5 = new String[7];
        question6 = new String[7];
        question7 = new String[7];

        // This array for question 26-27
        question8 = new String[3];
        question9 = new String[3];
        question10 = new String[3];
        question11 = new String[3];
        question12 = new String[3];
        question13 = new String[3];
        question14 = new String[3];

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

                question4[i] = result2.getString(0);
                question5[i] = result2.getString(1);
                question6[i] = result2.getString(2);
                question7[i] = result2.getString(3);

                i++;

                sss.append(i + " " + result2.getString(0));
            }
            texts2 = sss.toString();
        }

        // For result3 cursor
        if (result3.getCount() == 0) {
            texts3 = "Contents are not available";
        }
        else {
            int i = 0;
            StringBuffer sss = new StringBuffer();
            while (result3.moveToNext()) {

                question8[i] = result3.getString(0);
                question9[i] = result3.getString(1);
                question10[i] = result3.getString(2);
                question11[i] = result3.getString(3);
                question12[i] = result3.getString(4);
                question13[i] = result3.getString(5);
                question14[i] = result3.getString(6);

                i++;

                sss.append(i + " " + result3.getString(0));
            }
            texts3 = sss.toString();
        }

        // Set Question 14-19
        initializeMatchingthings(rootView);
        setQuestion_14_19();

        // Set Question 20-25
        initializeFillBlank(rootView);
        setQuestion_20_25();

        // Set Question 26-27
        initializeMCQs(rootView);
        setQuestion_26_27();
    }

    private void setQuestion_14_19() {

        matchingStatements = getResources().getStringArray(R.array.matching_statements);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_view, R.id.textViewSpinnerId, matchingStatements);

        // set Question 14-19 extra things
        _14ReadingQuestionHeaderId.setText(Html.fromHtml(question14_19Header));
        _14ReadingAnswerId.setText(Html.fromHtml(question14_19List));

        // set All text for question 14
        _14ReadingQuestionId.setText(question1[0] + ".");
        _14ReadingSpinnerId.setAdapter(arrayAdapter);
        _14ReadingFullQuestion.setText(question2[0]);

        // set All text for question 15
        _15ReadingQuestionId.setText(question1[1] + ".");
        _15ReadingSpinnerId.setAdapter(arrayAdapter);
        _15ReadingFullQuestion.setText(question2[1]);

        // set All text for question 16
        _16ReadingQuestionId.setText(question1[2] + ".");
        _16ReadingSpinnerId.setAdapter(arrayAdapter);
        _16ReadingFullQuestion.setText(question2[2]);

        // set All text for question 17
        _17ReadingQuestionId.setText(question1[3] + ".");
        _17ReadingSpinnerId.setAdapter(arrayAdapter);
        _17ReadingFullQuestion.setText(question2[3]);

        // set All text for question 18
        _18ReadingQuestionId.setText(question1[4] + ".");
        _18ReadingSpinnerId.setAdapter(arrayAdapter);
        _18ReadingFullQuestion.setText(question2[4]);

        // set All text for question 19
        _19ReadingQuestionId.setText(question1[5] + ".");
        _19ReadingSpinnerId.setAdapter(arrayAdapter);
        _19ReadingFullQuestion.setText(question2[5]);
    }

    private void setQuestion_20_25() {
        // set Question 20-25 Header
        _20ReadingQuestionHeaderId.setText(Html.fromHtml(question20_25Header));

        // set fillBlank All text for question 20
        _20QuestionFirstId.setText(question4[0] + "." + question5[0]);
        _20QuestionLastId.setText(question6[0]);

        // set fillBlank All text for question 21
        _21QuestionFirstId.setText(question4[1] + "." + question5[1]);
        _21QuestionLastId.setText(question6[1]);

        // set fillBlank All text for question 22
        _22QuestionFirstId.setText(question4[2] + "." + question5[2]);
        _22QuestionLastId.setText(question6[2]);

        // set fillBlank All text for question 23
        _23QuestionFirstId.setText(question4[3] + "." + question5[3]);
        _23QuestionLastId.setText(question6[3]);

        // set fillBlank All text for question 24
        _24QuestionFirstId.setText(question4[4] + "." + question5[4]);
        _24QuestionLastId.setText(question6[4]);

        // set fillBlank All text for question 25
        _25QuestionFirstId.setText(question4[5] + "." + question5[5]);
        _25QuestionLastId.setText(question6[5]);

    }

    private void setQuestion_26_27() {
        // set Question 26-27 Header
        _26ReadingQuestionHeaderId.setText(Html.fromHtml(question26_27Header));

        // set All text for question 26
        _26ReadingQuestionId.setText(question8[0] +". "+ question9[0]);
        _26ReadingAns1.setText(question10[0]);
        _26ReadingAns2.setText(question11[0]);
        _26ReadingAns3.setText(question12[0]);
        _26ReadingAns4.setText(question13[0]);

        // set All text for question 27
        _27ReadingQuestionId.setText(question8[1] +". "+ question9[1]);
        _27ReadingAns1.setText(question10[1]);
        _27ReadingAns2.setText(question11[1]);
        _27ReadingAns3.setText(question12[1]);
        _27ReadingAns4.setText(question13[1]);
    }

    private void initializeMatchingthings(View rootView) {

        // Question 14-19 extra things
        _14ReadingQuestionHeaderId = rootView.findViewById(R.id._14ReadingQuestionHeaderId);
        _14ReadingAnswerId = rootView.findViewById(R.id._14ReadingAnswerId);

        // Question no 14
        _14ReadingQuestionId = rootView.findViewById(R.id._14ReadingQuestionId);
        _14ReadingSpinnerId = rootView.findViewById(R.id._14ReadingSpinnerId);
        _14ReadingFullQuestion = rootView.findViewById(R.id._14ReadingFullQuestion);

        // Question no 15
        _15ReadingQuestionId = rootView.findViewById(R.id._15ReadingQuestionId);
        _15ReadingSpinnerId = rootView.findViewById(R.id._15ReadingSpinnerId);
        _15ReadingFullQuestion = rootView.findViewById(R.id._15ReadingFullQuestion);

        // Question no 16
        _16ReadingQuestionId = rootView.findViewById(R.id._16ReadingQuestionId);
        _16ReadingSpinnerId = rootView.findViewById(R.id._16ReadingSpinnerId);
        _16ReadingFullQuestion = rootView.findViewById(R.id._16ReadingFullQuestion);

        // Question no 17
        _17ReadingQuestionId = rootView.findViewById(R.id._17ReadingQuestionId);
        _17ReadingSpinnerId = rootView.findViewById(R.id._17ReadingSpinnerId);
        _17ReadingFullQuestion = rootView.findViewById(R.id._17ReadingFullQuestion);

        // Question no 18
        _18ReadingQuestionId = rootView.findViewById(R.id._18ReadingQuestionId);
        _18ReadingSpinnerId = rootView.findViewById(R.id._18ReadingSpinnerId);
        _18ReadingFullQuestion = rootView.findViewById(R.id._18ReadingFullQuestion);

        // Question no 19
        _19ReadingQuestionId = rootView.findViewById(R.id._19ReadingQuestionId);
        _19ReadingSpinnerId = rootView.findViewById(R.id._19ReadingSpinnerId);
        _19ReadingFullQuestion = rootView.findViewById(R.id._19ReadingFullQuestion);
    } // initializeMatchingthings finished

    private void initializeFillBlank(View rootView) {
        // set Question 20-25 Header
        _20ReadingQuestionHeaderId = rootView.findViewById(R.id._20ReadingQuestionHeaderId);

        _20QuestionFirstId = rootView.findViewById(R.id._20QuestionFirstId);
        _20QuestionLastId = rootView.findViewById(R.id._20QuestionLastId);
        _20editTextId = rootView.findViewById(R.id._20editTextId);

        _21QuestionFirstId = rootView.findViewById(R.id._21QuestionFirstId);
        _21QuestionLastId = rootView.findViewById(R.id._21QuestionLastId);
        _21editTextId = rootView.findViewById(R.id._21editTextId);

        _22QuestionFirstId = rootView.findViewById(R.id._22QuestionFirstId);
        _22QuestionLastId = rootView.findViewById(R.id._22QuestionLastId);
        _22editTextId = rootView.findViewById(R.id._22editTextId);

        _23QuestionFirstId = rootView.findViewById(R.id._23QuestionFirstId);
        _23QuestionLastId = rootView.findViewById(R.id._23QuestionLastId);
        _23editTextId = rootView.findViewById(R.id._23editTextId);

        _24QuestionFirstId = rootView.findViewById(R.id._24QuestionFirstId);
        _24QuestionLastId = rootView.findViewById(R.id._24QuestionLastId);
        _24editTextId = rootView.findViewById(R.id._24editTextId);

        _25QuestionFirstId = rootView.findViewById(R.id._25QuestionFirstId);
        _25QuestionLastId = rootView.findViewById(R.id._25QuestionLastId);
        _25editTextId = rootView.findViewById(R.id._25editTextId);
    }

    private void initializeMCQs(View rootview) {

        // set Question 14-19 Header
        _26ReadingQuestionHeaderId = rootview.findViewById(R.id._26ReadingQuestionHeaderId);

        // Question no 26
        _26ReadingQuestionId = rootview.findViewById(R.id._26ReadingQuestionId);
        _26ReadingGroup = rootview.findViewById(R.id._26ReadingGroup);
        _26ReadingAns1 = rootview.findViewById(R.id._26ReadingAns1);
        _26ReadingAns2 = rootview.findViewById(R.id._26ReadingAns2);
        _26ReadingAns3 = rootview.findViewById(R.id._26ReadingAns3);
        _26ReadingAns4 = rootview.findViewById(R.id._26ReadingAns4);

        // Question no 27
        _27ReadingQuestionId = rootview.findViewById(R.id._27ReadingQuestionId);
        _27ReadingGroup = rootview.findViewById(R.id._27ReadingGroup);
        _27ReadingAns1 = rootview.findViewById(R.id._27ReadingAns1);
        _27ReadingAns2 = rootview.findViewById(R.id._27ReadingAns2);
        _27ReadingAns3 = rootview.findViewById(R.id._27ReadingAns3);
        _27ReadingAns4 = rootview.findViewById(R.id._27ReadingAns4);
    } // initializeMCQs finished

    public void initializeNeededStrings() {
        question14_19List =
                "<b>YES</b> if the statement agrees with the view of the writer<br>" +
                "<b>NO</b> if the statement contradicts with tthe view of the writer<br>" +
                "<b>NOT GIVEN</b> Steven Brown<br>";

        question14_19Header = "<i><b>Questions 14-19</b></i><br>" +
                "Do the following statements reflect the claims of the writer in Reading Passage 2?<br>" +
                "<i>In boxes 14-19 on your answer sheet, write</i>";

        question20_25Header = "<i><b>Questions 20-25</b><br>" +
                "Complete the summary below.<br>" +
                "Choose <b>ONE WORD ONLY</b> from the passage for each answer.<br>" +
                "Write your answers in boxes 20-25 on your answer sheet.</i>";

        question26_27Header = "<i><b>Questions 26 and 27</b><br>" +
                "Choose the correct answer<br>" +
                "Write your answers in boxes 26 and 27 on your answer sheet.</i>";
    } // initializeNeededStrings finished
}
