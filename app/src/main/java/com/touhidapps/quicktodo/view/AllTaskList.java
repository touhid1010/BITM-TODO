package com.touhidapps.quicktodo.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.touhidapps.quicktodo.customview.MyRecyclerAdapterTask;
import com.touhidapps.quicktodo.helper.TaskRepository;
import com.touhidapps.quicktodo.model.TodoCategory;
import com.touhidapps.quicktodo.R;
import com.touhidapps.quicktodo.commonitems.CommonNames;
import com.touhidapps.quicktodo.helper.TaskCategoryRepository;
import com.touhidapps.quicktodo.model.TodoTask;

import java.util.ArrayList;
import java.util.List;

public class AllTaskList extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView_taskList;

    List<TodoTask> todoTaskList;
    TodoTask todoTask;
    TaskRepository taskRepository;
    MyRecyclerAdapterTask adapter;
    String catID="", catStatus="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_task_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // fab
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);


        /**
         * Get intent data, getting from MainActivity
         */
        if (getIntent().hasExtra(CommonNames.MY_INTENT_NAME_CONTAINS_CATEGORY_ID)) {
            Intent intent = getIntent();
            catID = intent.getStringExtra(CommonNames.MY_INTENT_NAME_CONTAINS_CATEGORY_ID);
            Toast.makeText(this, catID+" aaa ", Toast.LENGTH_SHORT).show();

        }
        if (getIntent().hasExtra(CommonNames.MY_INTENT_NAME_CONTAINS_STATUS_ID)) {
            Intent intent = getIntent();
            catStatus = intent.getStringExtra(CommonNames.MY_INTENT_NAME_CONTAINS_STATUS_ID);
            Toast.makeText(this, catStatus+" aaa ", Toast.LENGTH_SHORT).show();
        }

        /**
         * Hide fab if active or inactive task selected
         */
        if (catStatus.equals("1") || catStatus.equals("0")) { // if catStatus.equals(""), fab will remain visible, which is define in instance scope
            fab.setVisibility(View.GONE);
        } else {
            fab.setVisibility(View.VISIBLE);
        }

        /**
         * Recycler view and adapter
         */
        taskRepository = new TaskRepository(AllTaskList.this);
//        todoTaskList = taskRepository.addNewTask(todoTaskList);
        recyclerView_taskList = (RecyclerView) findViewById(R.id.recyclerView_taskList);
        adapter = new MyRecyclerAdapterTask(this, todoTaskList);
        recyclerView_taskList.setAdapter(adapter);
        recyclerView_taskList.setHasFixedSize(true);

        // Layout manager for Recycler view
        recyclerView_taskList.setLayoutManager(new LinearLayoutManager(this));


    } // end of onCreate

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
//                startActivity(new Intent(getApplicationContext(), TaskDetails.class));

                // Get prompts.xml view
                LayoutInflater li = LayoutInflater.from(AllTaskList.this);
                View promptsView = li.inflate(R.layout.my_prompts_task, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AllTaskList.this);

                // Set my_prompts_category_category.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInputTaskTitle);

                // Set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
//                                        // Get user input and set it to db
                                        saveTaskTitleToDb(userInput.getText().toString());
//
                                        // Auto refresh group list
//                                        todoTaskList.add(todoTask);
//                                        adapter.notifyDataSetChanged();
//                                        recyclerView_taskList.invalidate();
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

                // Show it
                alertDialog.show();

                break;
        }
    }

    // Save group name to db
    private void saveTaskTitleToDb(String title) {
        todoTask = new TodoTask(title);
        taskRepository.addNewTask(todoTask);
    }
}
