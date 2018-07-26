package com.databaseielts.mocktest.ielts.database.ieltsdatabase.Fragments;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.databaseielts.mocktest.ielts.database.ieltsdatabase.MyDatabaseHelper;
import com.databaseielts.mocktest.ielts.database.ieltsdatabase.R;

public class FragmentPassage2 extends Fragment {

    private TextView _1PassageId;

    MyDatabaseHelper myDatabaseHelper;

    String[] question1;

    public FragmentPassage2() {
        Log.i("Fragment check", "Fragment Passage Created");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_passage_2, container, false);

        initializePassage(rootView);

        return rootView;
    }

    private void initializePassage(View rootView) {
        myDatabaseHelper = new MyDatabaseHelper(getActivity());

        Cursor result = myDatabaseHelper.fetchReadingPassage(1, 2);

        String texts;
        question1 = new String[2];

        // For result1 cursor
        if (result.getCount() == 0) {
            texts = "Contents are not available";
        }
        else {
            int i = 0;
            StringBuffer sss = new StringBuffer();
            while (result.moveToNext()) {

                question1[i] = result.getString(0);

                i++;

                sss.append(i + " " + result.getString(0));
            }
            texts = sss.toString();
        }

        _1PassageId = rootView.findViewById(R.id._1PassageId);

        _1PassageId.setText(Html.fromHtml(question1[0]));
    }
}
