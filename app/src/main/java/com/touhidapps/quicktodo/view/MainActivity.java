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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.touhidapps.quicktodo.R;
import com.touhidapps.quicktodo.commonitems.CommonNames;
import com.touhidapps.quicktodo.customview.MyRecyclerAdapterCategory;
import com.touhidapps.quicktodo.helper.TaskCategoryRepository;
import com.touhidapps.quicktodo.login.LoginSession;
import com.touhidapps.quicktodo.model.TodoCategory;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    CardView cardView_deactivatedTaskGroup,
            cardView_todayTask;

    TaskCategoryRepository categoryRepository;
    List<TodoCategory> categoryList;
    TodoCategory todoGroupList;
    MyRecyclerAdapterCategory adapter;
    TextView textView_todayTaskAmount, textView_inactiveTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository(this);

        textView_todayTaskAmount = (TextView) findViewById(R.id.textView_todayTaskAmount);
        textView_inactiveTask = (TextView) findViewById(R.id.textView_inactiveTask);
        textView_todayTaskAmount.setText("" + taskCategoryRepository.countTaskStatusUnderCategory("1"));//
        textView_inactiveTask.setText("" + taskCategoryRepository.countTaskStatusUnderCategory("0"));

        /**
         * Thread used to reduce app opening time
         * Recycler view and card view need some extra time to open
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                categoryRepository = new TaskCategoryRepository(MainActivity.this);
                categoryList = categoryRepository.getAllCategories();
                recyclerView = (RecyclerView) findViewById(R.id.recyclerView_group);
                cardView_deactivatedTaskGroup = (CardView) findViewById(R.id.cardView_deactivatedTaskGroup);
                cardView_todayTask = (CardView) findViewById(R.id.cardView_todayTask);
                cardView_deactivatedTaskGroup.setOnClickListener(MainActivity.this);
                cardView_todayTask.setOnClickListener(MainActivity.this);
                adapter = new MyRecyclerAdapterCategory(MainActivity.this, categoryList); // on Click listener inside it

                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
                //Layout manager for Recycler view
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        }).start();

        FloatingActionButton fab_addGroup = (FloatingActionButton) findViewById(R.id.fab_addGroup);
        fab_addGroup.setOnClickListener(this);

    } // End of OnCreate


    // Save group name to db
    private void saveGroupNameToDb(String name) {
        todoGroupList = new TodoCategory(name);
        categoryRepository.addTaskCategory(todoGroupList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            LoginSession loginSession = new LoginSession();
            boolean check = loginSession.logout(getApplicationContext());
            if (check) {
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Go to previous page when pressing back button
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    // Alert before exit
                    new AlertDialog.Builder(this)
                            .setMessage("Want to exit?")
                            .setNegativeButton("No", null)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).create().show();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_addGroup:

                // Get prompts.xml view
                LayoutInflater li = LayoutInflater.from(MainActivity.this);
                View promptsView = li.inflate(R.layout.my_prompts_category, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        MainActivity.this);

                // set my_prompts_category.xmlegory.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // Set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // Get user input and set it to db
                                        saveGroupNameToDb(userInput.getText().toString());

                                        // Auto refresh group list
                                        categoryList.add(todoGroupList);
                                        adapter.notifyDataSetChanged();
                                        recyclerView.invalidate();
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

            case R.id.cardView_todayTask:
                Intent i = new Intent(getApplicationContext(), AllTaskList.class);
                i.putExtra(CommonNames.MY_INTENT_NAME_CONTAINS_STATUS_ID, "1");
                startActivity(i);
                break;

            case R.id.cardView_deactivatedTaskGroup:
                Intent intent = new Intent(getApplicationContext(), AllTaskList.class);
                intent.putExtra(CommonNames.MY_INTENT_NAME_CONTAINS_STATUS_ID, "0");
                startActivity(intent);
                break;


        }
    }
}


