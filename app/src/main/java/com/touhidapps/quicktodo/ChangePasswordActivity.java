package com.touhidapps.quicktodo;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.touhidapps.quicktodo.login.LoginSession;


public class ChangePasswordActivity extends AppCompatActivity {

    TextInputLayout textInputLayout_oldPassword,
            textInputLayout_newPassword,
            textInputLayout_newPasswordAgain;

    EditText editText_oldPassword,
            editText_newPassword,
            editText_newPasswordAgain;

    Button button_submitChanePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        textInputLayout_oldPassword = (TextInputLayout) findViewById(R.id.textInputLayout_oldPassword);
        textInputLayout_newPassword = (TextInputLayout) findViewById(R.id.textInputLayout_newPassword);
        textInputLayout_newPasswordAgain = (TextInputLayout) findViewById(R.id.textInputLayout_newPasswordAgain);

        editText_oldPassword = (EditText) findViewById(R.id.editText_oldPassword);
        editText_newPassword = (EditText) findViewById(R.id.editText_newPassword);
        editText_newPasswordAgain = (EditText) findViewById(R.id.editText_newPasswordAgain);

        button_submitChanePassword = (Button) findViewById(R.id.button_submitChanePassword);
        button_submitChanePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginSession loginSession = new LoginSession();
                boolean check = loginSession.changePasswordOfPref(getApplicationContext(),
                        editText_oldPassword.getText().toString(),
                        editText_newPassword.getText().toString());
                if (check) {
                    Toast.makeText(ChangePasswordActivity.this, "Password Changed", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ChangePasswordActivity.this, "Something Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
