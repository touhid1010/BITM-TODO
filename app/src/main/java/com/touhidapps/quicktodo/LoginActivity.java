package com.touhidapps.quicktodo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences prefs;
    private static String MY_PREFERENCE_NAME = "_LOGIN_PREF_NAME";
    private static String MY_PREFERENCE_KEY_DEFAULT_PASSWORD = "_LOGIN_PREF_KEY_PASSWORD";
    private static String MY_PREFERENCE_KEY_CHECK_CONTAINS = "_LOGIN_PREF_KEY_CHECK";

    TextView textView_defaultPassword;
    TextInputLayout textInputLayout_password;
    EditText editText_password;
    Button button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        // Initialize
        textView_defaultPassword = (TextView) findViewById(R.id.textView_defaultPassword);
        textInputLayout_password = (TextInputLayout) findViewById(R.id.textInputLayout_password);
        editText_password = (EditText) findViewById(R.id.editText_password);
        button_login = (Button) findViewById(R.id.button_login);


        // Make pref if not exists and set default value
        prefs = this.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);

        if (!prefs.getBoolean(MY_PREFERENCE_KEY_CHECK_CONTAINS, false)) {  // first time this will not get true value so default false will return

            // Put a true value to check app is opened first time
            prefs.edit().putBoolean(MY_PREFERENCE_KEY_CHECK_CONTAINS, true).apply();


            // Make default value after making the pref
            assert prefs != null;
            prefs.edit().putString(MY_PREFERENCE_KEY_DEFAULT_PASSWORD, "0000").apply();

            // Show default value
            textView_defaultPassword.setText("Default Password is: " + getSharedPreferences(MY_PREFERENCE_NAME, MODE_PRIVATE).getString(MY_PREFERENCE_KEY_DEFAULT_PASSWORD, ""));
        } else {
            textView_defaultPassword.setText("");
        }



        button_login.setOnClickListener(this);


        Log.d("touhid1", "onCreate: " + getSharedPreferences(MY_PREFERENCE_NAME, MODE_PRIVATE).getString(MY_PREFERENCE_KEY_DEFAULT_PASSWORD, ""));


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















