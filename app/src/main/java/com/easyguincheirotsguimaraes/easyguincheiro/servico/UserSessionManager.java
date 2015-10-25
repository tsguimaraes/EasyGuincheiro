package com.easyguincheirotsguimaraes.easyguincheiro.servico;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.easyguincheirotsguimaraes.easyguincheiro.Login_Codigo;

import java.util.HashMap;

/**
 * Created by Thiago on 12/10/2015.
 */
public class UserSessionManager {

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "LoginPref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User id (make variable public to access from outside)
    public static final String KEY_ID = "id";

    // User name (make variable public to access from outside)
    public static final String KEY_CODIGO = "idTB_ACESSO_GUINCHEIRO";


    // User name (make variable public to access from outside)
    public static final String KEY_PLACA = "idTB_VEICULO_GUINCHO";


    // Constructor
    public UserSessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();

        /**
         * Se aparecer o erro: java.lang.Integer cannot be cast to java.lang.Boolean
         *
         * Execute:
         * editor.clear();
         * editor.commit();
         *
         */
    }

    /**
     * Create login session
     */
    public void createLoginSession(int id, EditText codigo, String placa) {

        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing id in pref
        editor.putInt(KEY_ID, id);

        // Storing name in pref

        editor.putString(KEY_CODIGO, codigo.getText().toString());

        editor.putString(KEY_PLACA, placa);

        // commit changes
        editor.commit();
    }


    /**
     * Get stored session data
     */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        // user id
        user.put(KEY_ID, String.valueOf(pref.getInt(KEY_ID, 0)));

        // user name
        user.put(KEY_CODIGO, pref.getString(KEY_CODIGO, null));

        // user email id
        user.put(KEY_PLACA, pref.getString(KEY_PLACA, null));

        // return user
        return user;
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     */
    public boolean checkLogin() {
        // Check login status
        if (!this.isLoggedIn()) {
            // user is not logged in redirect him to Login Activity // Classe teste
            Intent i = new Intent(_context, Login_Codigo.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);

            return true;
        }
        return false;
    }

    /**
     * Clear session details
     */
    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, Login_Codigo.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
