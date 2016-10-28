package com.touhidapps.quicktodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        button_login = (Button)findViewById(R.id.button_login);
        button_login.setOnClickListener(this);


    } // End of onCreate

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                startActivity(new Intent(this, MainActivity.class));

                break;
        }
    }
}















