package com.databaseielts.mocktest.ielts.database.ieltsdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import com.databaseielts.mocktest.ielts.database.ieltsdatabase.tabs.QuestionTabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class expandableList extends AppCompatActivity {

    private ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private CustomAdapter customAdapter;

    String module;

    private int lastexpanposition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);

        Toolbar toolbar = findViewById(R.id.expandableToolbarId);
        setSupportActionBar(toolbar);
        // Adding back button to the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final Bundle bundle = getIntent().getExtras();
        module = bundle.getString("module");

        expandableListView = findViewById(R.id.expandListView);

        prepareListData();

        customAdapter = new CustomAdapter(this, listDataHeader, listDataChild);
        expandableListView.setAdapter(customAdapter);

        /*expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(expandableList.this, "onGroup clicked", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

            }
        });*/

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                int mGroupPosition = 1;
                int mChildPosition = childPosition + 1;

                Bundle bundle1 = new Bundle();
                bundle1.putString("module", module);
                bundle1.putInt("test_id", mGroupPosition);
                bundle1.putInt("section_id", mChildPosition);

                if (module.equals("listening")) {
                    if (mGroupPosition == 1){
                        if (mChildPosition == 1) {
                            Intent intent = new Intent(expandableList.this, T_1_S_1.class);
                            intent.putExtras(bundle1);
                            startActivity(intent);
                        }
                        else if (mChildPosition == 2) {
                            Intent intent = new Intent(expandableList.this, T_1_S_2.class);
                            intent.putExtras(bundle1);
                            startActivity(intent);
                        }
                        else if (mChildPosition == 3) {
                            Intent intent = new Intent(expandableList.this, T_1_S_3.class);
                            intent.putExtras(bundle1);
                            startActivity(intent);
                        }
                        else if (mChildPosition == 4) {
                            Intent intent = new Intent(expandableList.this, T_1_S_2.class);
                            intent.putExtras(bundle1);
                            startActivity(intent);
                        }
                    }

                }
                else if(module.equals("reading")) {
                    if (mGroupPosition == 1) {
                        Intent intent = new Intent(getApplicationContext(), QuestionTabs.class);
                        intent.putExtras(bundle1);
                        startActivity(intent);
                    }
                }

                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastexpanposition != -1 && lastexpanposition != groupPosition) {
                    expandableListView.collapseGroup(lastexpanposition);
                }
                lastexpanposition = groupPosition;
            }
        });
    } // onCreate finished

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add("Test 1");
        listDataHeader.add("Test 2");
        listDataHeader.add("Test 3");
        listDataHeader.add("Test 4");
        listDataHeader.add("Test 5");
        listDataHeader.add("Test 6");
        listDataHeader.add("Test 7");
        listDataHeader.add("Test 8");
        listDataHeader.add("Test 9");

        if (module.equals("listening")) {
            List<String> test_1 = new ArrayList<>();
            test_1.add("Section 1");
            test_1.add("Section 2");
            test_1.add("Section 3");
            test_1.add("Section 4");

            listDataChild.put(listDataHeader.get(0), test_1);
            listDataChild.put(listDataHeader.get(1), test_1);
            listDataChild.put(listDataHeader.get(2), test_1);
            listDataChild.put(listDataHeader.get(3), test_1);
            listDataChild.put(listDataHeader.get(4), test_1);
            listDataChild.put(listDataHeader.get(5), test_1);
            listDataChild.put(listDataHeader.get(6), test_1);
            listDataChild.put(listDataHeader.get(7), test_1);
            listDataChild.put(listDataHeader.get(8), test_1);
        }
        else if (module.equals("reading")) {
            List<String> test_1 = new ArrayList<>();
            test_1.add("Section 1");
            test_1.add("Section 2");
            test_1.add("Section 3");

            listDataChild.put(listDataHeader.get(0), test_1);
            listDataChild.put(listDataHeader.get(1), test_1);
            listDataChild.put(listDataHeader.get(2), test_1);
            listDataChild.put(listDataHeader.get(3), test_1);
            listDataChild.put(listDataHeader.get(4), test_1);
            listDataChild.put(listDataHeader.get(5), test_1);
            listDataChild.put(listDataHeader.get(6), test_1);
            listDataChild.put(listDataHeader.get(7), test_1);
            listDataChild.put(listDataHeader.get(8), test_1);
        }
    } // PrepareListData ended
}
