package com.easyguincheirotsguimaraes.easyguincheiro;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import livroandroid.lib.activity.DebugActivity;

/**
 * Created by Thiago on 25/10/2015.
 */
public class AppBaseActivity extends DebugActivity {

    protected static final String PREF_LOGIN = "prefsLogin";


    public AppBaseActivity() {
    }


    /*
     Ativar a Toolbar como ActionBar!
     Quando chamado na criaçao da activity, inicializará a Toolbar.
      */

    //---------------------------------------------------------------------------------------------
    // Opções da Toolbar
    //---------------------------------------------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

        /*
        if (item.getItemId() == R.id.bt_pagamento){

        }
        switch (item.getItemId()) {
            case R.id.action_menu_divider:
                // Última localização
                Location l = LocationServices.FusedLocationApi.getLastLocation(
                        mGoogleApiClient);

                Log.d(TAG, "lastLocation: " + l);

                // Atualiza a localização do mapa
                setMapLocation(l);
                return true;
        }
        return super.onOptionsItemSelected(item);
        */
    }





    //---------------------------------------------------------------------------------------------
    // Métodos auxiliares
    //---------------------------------------------------------------------------------------------

    protected Context getContext() {
        return this;
    }

    protected Activity getActivity() {
        return this;
    }

    protected void log(String msg) {
        Log.d(TAG, msg);
    }

    protected void toast(String msg) {
        Toast.makeText(this.getContext(), msg, Toast.LENGTH_SHORT).show();
    }




    // Adiciona o fragment no centro da tela
    /*
    private void replaceFragment(Fragment frag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_drawer_container,
                frag, "TAG").commit();
    }
    */
}
