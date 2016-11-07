package com.touhidapps.quicktodo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.touhidapps.quicktodo.login.ChangePasswordActivity;
import com.touhidapps.quicktodo.login.LoginSession;
import com.touhidapps.quicktodo.view.MainActivity;
import com.touhidapps.quicktodo.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView_defaultPassword;
    TextInputLayout textInputLayout_password;
    EditText editText_password;
    Button button_login, button_changePassword;

    LoginSession loginSession;

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
        button_changePassword = (Button) findViewById(R.id.button_changePassword);
        button_login.setOnClickListener(this);
        button_changePassword.setOnClickListener(this);

        // Make login session
        loginSession = new LoginSession();
        loginSession.loginSessionMake(this, textView_defaultPassword);

        /**
         * if get logged in start home activity
         */
        if (loginSession.isLoggedIn(this)) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }


    } // End of onCreate

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:

                boolean check = loginSession.setSession(getApplicationContext(), editText_password.getText().toString());

                if (check) {
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "Password Error, Please Try again!", Toast.LENGTH_SHORT).show();
                    editText_password.getText().clear();
                }

                break;

            case R.id.button_changePassword:

                startActivity(new Intent(getApplicationContext(), ChangePasswordActivity.class));

                break;
        }
    }
}















