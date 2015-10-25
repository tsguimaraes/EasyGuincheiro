package com.easyguincheirotsguimaraes.easyguincheiro.servico;

import android.app.Application;
import android.util.Log;

/**
 * Created by Thiago on 12/10/2015.
 */
public class WebServiceApp extends Application {

    private static final String TAG = "EasyGuinchoApp";
    private static WebServiceApp instance = null;




    public static WebServiceApp getInstance(){
        return instance; // Singleton
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "EasyGuinchoApp.onCreate()");
        // Salva a instância para termos acesso como Singleton
        instance = this;
    }



    public static String getActionTAG() {
        return "classRequest";
    }

    public static String getURL() {
        return "http://tcceasyguincho.esy.es/EasyGuinchoWS/index.php";
        //return "http://10.0.3.2:3310/EasyGuinchoWS/index.php";
    }




    @Override
    public void onTerminate(){
        super.onTerminate();
        Log.d(TAG, "EasyGuinchoApp.onTerminate()");
    }

}
