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

                // check error
                if (editText_oldPassword.getText().toString().isEmpty()) {
                    textInputLayout_oldPassword.setError("Set old password");
                } else {
                    textInputLayout_oldPassword.setError(null);
                }

                if (editText_newPassword.getText().toString().isEmpty()) {
                    textInputLayout_newPassword.setError("Set new password");
                } else {
                    textInputLayout_newPassword.setError(null);
                }

                if (!editText_newPassword.getText().toString().equals(editText_newPasswordAgain.getText().toString())) {
                    textInputLayout_newPasswordAgain.setError("Password Mismatch");
                } else {
                    textInputLayout_newPasswordAgain.setError(null);
                }

                if (textInputLayout_oldPassword.getError() == null && textInputLayout_newPasswordAgain.getError() == null) {

                    LoginSession loginSession = new LoginSession();
                    boolean check = loginSession.changePasswordOfPref(getApplicationContext(),
                            editText_oldPassword.getText().toString(),
                            editText_newPassword.getText().toString());
                    if (check) {
                        Toast.makeText(ChangePasswordActivity.this, "Password Changed", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        textInputLayout_oldPassword.setError("Wrong Old Password");
                    }

                }


            }
        });
    }
}
