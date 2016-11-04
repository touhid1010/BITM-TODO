package com.touhidapps.quicktodo.todoList;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.touhidapps.quicktodo.AddNewTask;
import com.touhidapps.quicktodo.R;
import com.touhidapps.quicktodo.commonitems.CommonNames;
import com.touhidapps.quicktodo.customview.MyRecyclerAdapter;
import com.touhidapps.quicktodo.database.MyTaskGroup;

import java.io.Serializable;
import java.util.ArrayList;

public class AllTaskList extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView_taskList;

    CardView cardView_deactivatedTaskGroup,
            cardView_todayTask;

    ArrayList<TodoGroupList> nameAndId;
    TodoGroupList todoGroupList;
    MyTaskGroup myTaskGroup;
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
                startActivity(new Intent(getApplicationContext(), AddNewTask.class));
                break;
        }
    }
}
