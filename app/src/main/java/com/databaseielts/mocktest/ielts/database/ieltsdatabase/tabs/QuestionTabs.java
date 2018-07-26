package com.databaseielts.mocktest.ielts.database.ieltsdatabase.tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.databaseielts.mocktest.ielts.database.ieltsdatabase.Fragments.FragmentPassage;
import com.databaseielts.mocktest.ielts.database.ieltsdatabase.Fragments.FragmentPassage2;
import com.databaseielts.mocktest.ielts.database.ieltsdatabase.Fragments.FragmentPassage3;
import com.databaseielts.mocktest.ielts.database.ieltsdatabase.Fragments.FragmentQuestion;
import com.databaseielts.mocktest.ielts.database.ieltsdatabase.Fragments.FragmentQuestion2;
import com.databaseielts.mocktest.ielts.database.ieltsdatabase.Fragments.FragmentQuestion3;
import com.databaseielts.mocktest.ielts.database.ieltsdatabase.R;
import com.databaseielts.mocktest.ielts.database.ieltsdatabase.adapters.QuestionTabsAdapter;

import java.util.ArrayList;
import java.util.List;

public class QuestionTabs extends AppCompatActivity {

    // For the Data Initialize
    private String module;
    private int testId, sectionId;

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    private ViewPager viewPager;
    private QuestionTabsAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_tabs);

        passDataToFragment();

        initialize();

        prepareDataResource();

        adapter = new QuestionTabsAdapter(getSupportFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void passDataToFragment() {
        Bundle bundle = getIntent().getExtras();
        module = bundle.getString("module");
        testId = bundle.getInt("test_id");
        sectionId = bundle.getInt("section_id");
    }

    private void initialize() {
        Toolbar toolbar = findViewById(R.id.questionToolbarId);
        toolbar.setTitle("Reading Module");

        viewPager = findViewById(R.id.viewPagerId);
        tabLayout = findViewById(R.id.readingTabs);
    }

    private void prepareDataResource() {
        if (sectionId == 1) {
            addData(new FragmentPassage(), "Passage");
            addData(new FragmentQuestion(), "Question");
        }
        else if (sectionId == 2) {
            addData(new FragmentPassage2(), "Passage");
            addData(new FragmentQuestion2(), "Question");
        }
        else if (sectionId == 3) {
            addData(new FragmentPassage3(), "Passage");
            addData(new FragmentQuestion3(), "Question");
        }
    }

    private void addData(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }
}
