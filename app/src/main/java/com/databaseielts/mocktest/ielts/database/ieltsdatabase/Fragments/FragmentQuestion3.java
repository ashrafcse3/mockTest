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

public class FragmentQuestion3 extends Fragment {

    private TextView _28ReadingQuestionHeaderId, _34ReadingQuestionHeaderId;

    private TextView _28ReadingAnswerId;

    private TextView _28ReadingQuestionId, _29ReadingQuestionId, _30ReadingQuestionId, _31ReadingQuestionId, _32ReadingQuestionId, _33ReadingQuestionId;
    private TextView _34QuestionFirstId, _34QuestionLastId,_35QuestionFirstId, _35QuestionLastId,_36QuestionFirstId, _36QuestionLastId,_37QuestionFirstId, _37QuestionLastId,_38QuestionFirstId, _38QuestionLastId;

    private EditText _34editTextId, _35editTextId, _36editTextId, _37editTextId, _38editTextId;

    private TextView _28ReadingFullQuestion, _29ReadingFullQuestion, _30ReadingFullQuestion, _31ReadingFullQuestion, _32ReadingFullQuestion, _33ReadingFullQuestion;
    private Spinner _28ReadingSpinnerId, _29ReadingSpinnerId, _30ReadingSpinnerId, _31ReadingSpinnerId, _32ReadingSpinnerId, _33ReadingSpinnerId;

    MyDatabaseHelper myDatabaseHelper;
    private Button resultbtn3;
    private RadioButton check;
    private int result=0;


    // 3 array for matchingThings, 4 array for fill in the Blank.
    String[] question1, question2, question3, question4, question5, question6, question7;
    String[] matchingSentence;

    String question28_33List, question28_33Header, question34_38Header;

    public FragmentQuestion3() {
        Log.i("Fragment check", "Fragment Question Created");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_question_3, container, false);
        resultbtn3 = rootView.findViewById(R.id.resultbtn3);
        initializeNeededStrings();

        fullDataInitialize(rootView);
        resultbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_28ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _28ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question3[0])){
                        result++;
                    }
                }
                if (_29ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _29ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question3[1])){
                        result++;
                    }
                }
                if (_30ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _30ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question3[2])){
                        result++;
                    }
                }
                if (_31ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _31ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question3[3])){
                        result++;
                    }
                }
                if (_32ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _32ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question3[4])){
                        result++;
                    }
                }
                if (_33ReadingSpinnerId.getSelectedItemPosition() > 0) {//Do something

                    String value = _33ReadingSpinnerId.getSelectedItem().toString();
                    if(value.equalsIgnoreCase(question3[5])){
                        result++;
                    }
                }
                if (_34editTextId.getText().toString().equalsIgnoreCase(question7[0])){
                    result++;
                }
                if (_35editTextId.getText().toString().equalsIgnoreCase(question7[1])){
                    result++;
                }
                if (_36editTextId.getText().toString().equalsIgnoreCase(question7[2])){
                    result++;
                }
                if (_37editTextId.getText().toString().equalsIgnoreCase(question7[3])){
                    result++;
                } if (_38editTextId.getText().toString().equalsIgnoreCase(question7[4])){
                    result++;
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

        Cursor result1 = myDatabaseHelper.fetchMatchingThings(1, 3);
        Cursor result2 = myDatabaseHelper.fetchFillBlankData("reading",1, 3);

        String texts;
        String texts2;

        // This array for question 28-33
        question1 = new String[7];
        question2 = new String[7];
        question3 = new String[7];

        // This array for question 34-38
        question4 = new String[7];
        question5 = new String[7];
        question6 = new String[7];
        question7 = new String[7];

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

        // Set Question 14-19
        initializeMatchingthings(rootView);
        setQuestion_28_33();

        // Set Question 20-25
        initializeFillBlank(rootView);
        setQuestion_34_38();
    }

    private void setQuestion_28_33() {

        matchingSentence = getResources().getStringArray(R.array.matching_sentence_ending);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_view, R.id.textViewSpinnerId, matchingSentence);

        // set Question 28-33 extra things
        _28ReadingQuestionHeaderId.setText(Html.fromHtml(question28_33Header));
        _28ReadingAnswerId.setText(Html.fromHtml(question28_33List));

        // set All text for question 28
        _28ReadingQuestionId.setText(question1[0] + ".");
        _28ReadingSpinnerId.setAdapter(arrayAdapter);
        _28ReadingFullQuestion.setText(question2[0]);

        // set All text for question 29
        _29ReadingQuestionId.setText(question1[1] + ".");
        _29ReadingSpinnerId.setAdapter(arrayAdapter);
        _29ReadingFullQuestion.setText(question2[1]);

        // set All text for question 30
        _30ReadingQuestionId.setText(question1[2] + ".");
        _30ReadingSpinnerId.setAdapter(arrayAdapter);
        _30ReadingFullQuestion.setText(question2[2]);

        // set All text for question 31
        _31ReadingQuestionId.setText(question1[3] + ".");
        _31ReadingSpinnerId.setAdapter(arrayAdapter);
        _31ReadingFullQuestion.setText(question2[3]);

        // set All text for question 32
        _32ReadingQuestionId.setText(question1[4] + ".");
        _32ReadingSpinnerId.setAdapter(arrayAdapter);
        _32ReadingFullQuestion.setText(question2[4]);

        // set All text for question 33
        _33ReadingQuestionId.setText(question1[5] + ".");
        _33ReadingSpinnerId.setAdapter(arrayAdapter);
        _33ReadingFullQuestion.setText(question2[5]);
    }

    private void setQuestion_34_38() {
        // set Question 34-38 Header
        _34ReadingQuestionHeaderId.setText(Html.fromHtml(question34_38Header));

        // set fillBlank All text for question 34
        _34QuestionFirstId.setText(question4[0] + "." + question5[0]);
        _34QuestionLastId.setText(question6[0]);

        // set fillBlank All text for question 35
        _35QuestionFirstId.setText(question4[1] + "." + question5[1]);
        _35QuestionLastId.setText(question6[1]);

        // set fillBlank All text for question 36
        _36QuestionFirstId.setText(question4[2] + "." + question5[2]);
        _36QuestionLastId.setText(question6[2]);

        // set fillBlank All text for question 37
        _37QuestionFirstId.setText(question4[3] + "." + question5[3]);
        _37QuestionLastId.setText(question6[3]);

        // set fillBlank All text for question 38
        _38QuestionFirstId.setText(question4[4] + "." + question5[4]);
        _38QuestionLastId.setText(question6[4]);

    }

    private void initializeMatchingthings(View rootView) {

        // Question 28-33 extra things
        _28ReadingQuestionHeaderId = rootView.findViewById(R.id._28ReadingQuestionHeaderId);
        _28ReadingAnswerId = rootView.findViewById(R.id._28ReadingAnswerId);

        // Question no 28
        _28ReadingQuestionId = rootView.findViewById(R.id._28ReadingQuestionId);
        _28ReadingSpinnerId = rootView.findViewById(R.id._28ReadingSpinnerId);
        _28ReadingFullQuestion = rootView.findViewById(R.id._28ReadingFullQuestion);

        // Question no 29
        _29ReadingQuestionId = rootView.findViewById(R.id._29ReadingQuestionId);
        _29ReadingSpinnerId = rootView.findViewById(R.id._29ReadingSpinnerId);
        _29ReadingFullQuestion = rootView.findViewById(R.id._29ReadingFullQuestion);

        // Question no 30
        _30ReadingQuestionId = rootView.findViewById(R.id._30ReadingQuestionId);
        _30ReadingSpinnerId = rootView.findViewById(R.id._30ReadingSpinnerId);
        _30ReadingFullQuestion = rootView.findViewById(R.id._30ReadingFullQuestion);

        // Question no 31
        _31ReadingQuestionId = rootView.findViewById(R.id._31ReadingQuestionId);
        _31ReadingSpinnerId = rootView.findViewById(R.id._31ReadingSpinnerId);
        _31ReadingFullQuestion = rootView.findViewById(R.id._31ReadingFullQuestion);

        // Question no 32
        _32ReadingQuestionId = rootView.findViewById(R.id._32ReadingQuestionId);
        _32ReadingSpinnerId = rootView.findViewById(R.id._32ReadingSpinnerId);
        _32ReadingFullQuestion = rootView.findViewById(R.id._32ReadingFullQuestion);

        // Question no 33
        _33ReadingQuestionId = rootView.findViewById(R.id._33ReadingQuestionId);
        _33ReadingSpinnerId = rootView.findViewById(R.id._33ReadingSpinnerId);
        _33ReadingFullQuestion = rootView.findViewById(R.id._33ReadingFullQuestion);
    } // initializeMatchingthings finished

    private void initializeFillBlank(View rootView) {

        // set Question 34-38 Header
        _34ReadingQuestionHeaderId = rootView.findViewById(R.id._34ReadingQuestionHeaderId);

        _34QuestionFirstId = rootView.findViewById(R.id._34QuestionFirstId);
        _34QuestionLastId = rootView.findViewById(R.id._34QuestionLastId);
        _34editTextId = rootView.findViewById(R.id._34editTextId);

        _35QuestionFirstId = rootView.findViewById(R.id._35QuestionFirstId);
        _35QuestionLastId = rootView.findViewById(R.id._35QuestionLastId);
        _35editTextId = rootView.findViewById(R.id._35editTextId);

        _36QuestionFirstId = rootView.findViewById(R.id._36QuestionFirstId);
        _36QuestionLastId = rootView.findViewById(R.id._36QuestionLastId);
        _36editTextId = rootView.findViewById(R.id._36editTextId);

        _37QuestionFirstId = rootView.findViewById(R.id._37QuestionFirstId);
        _37QuestionLastId = rootView.findViewById(R.id._37QuestionLastId);
        _37editTextId = rootView.findViewById(R.id._37editTextId);

        _38QuestionFirstId = rootView.findViewById(R.id._38QuestionFirstId);
        _38QuestionLastId = rootView.findViewById(R.id._38QuestionLastId);
        _38editTextId = rootView.findViewById(R.id._38editTextId);
    }

    public void initializeNeededStrings() {
        question28_33List =
                "<b>A</b> activities of tourists and scientists have harmed the environment.<br>" +
                "<b>B</b> some sites in space could be important in the history of space exploration.<br>" +
                "<b>C</b> vehicles used for tourism have polluted the environment.<br>" +
                "<b>D</b> it may be unclear who has responsibility for historic human footprints.<br>" +
                "<b>E</b> past explorers used technology in order to find new places to live.<br>" +
                "<b>F</b> man-made objects left in space are regarded as rubbish.<br>" +
                "<b>G</b> astronauts may need to work more closely with archaeologists.<br>" +
                "<b>I</b> important sites on the Moon may be under threat.<br>";

        question28_33Header = "<i><b>Questions 28-33</b><br>" +
                "Complete each sentence with the correct ending <b>A-H</b><br>" +
                "Write the correct letter <b>A-H</b> in boxes 28-33 on your answer sheet.</i>";

        question34_38Header = "<i><b>Questions 34-38</b><br>" +
                "Complete the flowchart below.<br>" +
                "Choose <b>ONE WORD ONLY</b> from the passage for each answer.<br></i>";

    } // initializeNeededStrings finished
}
