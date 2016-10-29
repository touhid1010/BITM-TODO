package com.touhidapps.quicktodo.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Md. Touhidul Islam on 10/29/2016.
 */

public class LoginSession {

    private SharedPreferences prefs;
    private static String MY_PREFERENCE_NAME = "_LOGIN_PREF_NAME";
    private static String MY_PREFERENCE_KEY_PASSWORD = "_LOGIN_PREF_KEY_PASSWORD";
    private static String MY_PREFERENCE_KEY_SESSION = "_LOGIN_PREF_KEY_SESSION";
    private static String MY_PREFERENCE_KEY_CHECK_CONTAINS = "_LOGIN_PREF_KEY_CHECK";

    public LoginSession() {

    }

    public void loginSessionMake(Context context, TextView textView) {

        // Make pref if not exists and set default value
        prefs = context.getSharedPreferences(MY_PREFERENCE_NAME, context.MODE_PRIVATE);

        if (!prefs.getBoolean(MY_PREFERENCE_KEY_CHECK_CONTAINS, false)) {  // first time this will not get true value so default false will return

            // Put a true value to check app is opened first time
            prefs.edit().putBoolean(MY_PREFERENCE_KEY_CHECK_CONTAINS, true).apply();

            // Make default value after making the pref
            assert prefs != null;
            prefs.edit().putString(MY_PREFERENCE_KEY_PASSWORD, "0000").apply();

            // Show default value
            textView.setText("Default Password is: " + context.getSharedPreferences(MY_PREFERENCE_NAME, context.MODE_PRIVATE).getString(MY_PREFERENCE_KEY_PASSWORD, ""));
        } else {
            textView.setText("");
        }

    }

    public boolean setSession(Context context, String password) {
        if (password.equals(context.getSharedPreferences(MY_PREFERENCE_NAME, context.MODE_PRIVATE).getString(MY_PREFERENCE_KEY_PASSWORD, ""))) {
            prefs.edit().putBoolean(MY_PREFERENCE_KEY_SESSION, true).apply();
            return true;
        } else {
            return false;
        }

    }

    public boolean isLoggedIn(Context context) {

        if (context.getSharedPreferences(MY_PREFERENCE_NAME, context.MODE_PRIVATE).getBoolean(MY_PREFERENCE_KEY_SESSION, false)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean changePasswordOfPref(Context context, String oldPassword, String newPassword) {

        if (oldPassword.equals(context.getSharedPreferences(MY_PREFERENCE_NAME, context.MODE_PRIVATE).getString(MY_PREFERENCE_KEY_PASSWORD, ""))) {
            // Change value
            context.getSharedPreferences(MY_PREFERENCE_NAME, context.MODE_PRIVATE).edit().putString(MY_PREFERENCE_KEY_PASSWORD, newPassword).apply();
            return true;
        } else {
            return false;
        }
    }


}
