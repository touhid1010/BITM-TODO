package com.touhidapps.quicktodo.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.touhidapps.quicktodo.model.TodoCategory;
import com.touhidapps.quicktodo.R;
import com.touhidapps.quicktodo.commonitems.CommonNames;
import com.touhidapps.quicktodo.customview.MyRecyclerAdapter;
import com.touhidapps.quicktodo.helper.TaskCategory;

import java.util.ArrayList;

public class AllTaskList extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView_taskList;

    CardView cardView_deactivatedTaskGroup,
            cardView_todayTask;

    ArrayList<TodoCategory> nameAndId;
    TodoCategory todoGroupList;
    TaskCategory myTaskGroup;
    MyRecyclerAdapter adapter;
    String gName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_task_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        recyclerView_taskList = (RecyclerView)findViewById(R.id.recyclerView_taskList);
//        adapter = new MyRecyclerAdapter(this, groupName);
//        recyclerView_taskList.setAdapter(adapter);
//        recyclerView_taskList.setHasFixedSize(true);
//
//        //Layout manager for Recycler view
//        recyclerView_taskList.setLayoutManager(new LinearLayoutManager(this));

        if (getIntent() != null) {
            Intent intent = getIntent();
            gName = intent.getStringExtra(CommonNames.MY_INTENT_NAME_CONTAINS_GROUP_NAME);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
//                startActivity(new Intent(getApplicationContext(), AddNewTask.class));

                // Get prompts.xml view
                LayoutInflater li = LayoutInflater.from(AllTaskList.this);
                View promptsView = li.inflate(R.layout.my_prompts_task, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        AllTaskList.this);

                // set my_prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // Get user input and set it to db
//                                        saveGroupNameToDb(userInput.getText().toString());

                                        // Auto refresh group list
//                                        groupNameAndId.add(todoGroupList);
                                        adapter.notifyDataSetChanged();
//                                        recyclerView.invalidate();
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // Create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

                break;
        }
    }
}
