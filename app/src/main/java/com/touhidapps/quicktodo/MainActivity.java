package com.touhidapps.quicktodo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.touhidapps.quicktodo.database.MyTaskGroup;
import com.touhidapps.quicktodo.login.LoginActivity;
import com.touhidapps.quicktodo.login.LoginSession;
import com.touhidapps.quicktodo.todoList.TodoListGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab_addGroup = (FloatingActionButton) findViewById(R.id.fab_addGroup);
        fab_addGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(MainActivity.this);
                View promptsView = li.inflate(R.layout.my_prompts, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        MainActivity.this);

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
                                        // get user input and set it to db
                                        saveGroupNameToDb(userInput.getText().toString());

                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();


            }
        });


    } // End of OnCreate


    // Save group name to db
    private void saveGroupNameToDb(String name) {
        TodoListGroup todoListGroup = new TodoListGroup(name);
        MyTaskGroup myTaskGroup = new MyTaskGroup(getApplicationContext());
        myTaskGroup.addTodoListGroup(todoListGroup);
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
}
