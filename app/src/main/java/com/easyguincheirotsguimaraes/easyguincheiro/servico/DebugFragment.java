package com.easyguincheirotsguimaraes.easyguincheiro.servico;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Thiago on 12/10/2015.
 */
public class DebugFragment extends Fragment {
    protected static final String TAG = "easyguincho";

    public DebugFragment() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.isLogLifecycle()) {
            this.log(this.getClassName() + ".onCreate().");
        }

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(this.isLogLifecycle()) {
            this.log(this.getClassName() + ".onCreateView().");
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(this.isLogLifecycle()) {
            this.log(this.getClassName() + ".onActivityCreated().");
        }

    }

    public void onStart() {
        super.onStart();
        if(this.isLogLifecycle()) {
            this.log(this.getClassName() + ".onStart().");
        }

    }

    public void onResume() {
        super.onResume();
        if(this.isLogLifecycle()) {
            this.log(this.getClassName() + ".onResume().");
        }

    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(this.isLogLifecycle()) {
            this.log(this.getClassName() + ".onSaveInstanceState().");
        }

    }

    public void onPause() {
        super.onPause();
        if(this.isLogLifecycle()) {
            this.log(this.getClassName() + ".onPause().");
        }

    }

    public void onStop() {
        super.onStop();
        if(this.isLogLifecycle()) {
            this.log(this.getClassName() + ".onStop().");
        }

    }

    public void onDetach() {
        super.onDetach();
        if(this.isLogLifecycle()) {
            this.log(this.getClassName() + ".onDetach().");
        }

    }

    public void onDestroyView() {
        super.onDestroyView();
        if(this.isLogLifecycle()) {
            this.log(this.getClassName() + ".onDestroyView().");
        }

    }

    public void onDestroy() {
        super.onDestroy();
        if(this.isLogLifecycle()) {
            this.log(this.getClassName() + ".onDestroy().");
        }

    }

    public String getClassName() {
        Class cls = this.getClass();
        String s = cls.getSimpleName();
        return s;
    }

    protected void log(String msg) {
        if(this.isLogOn()) {
            Log.d("livroandroid", msg);
        }

    }

    protected boolean isLogOn() {
        return true;
    }

    protected boolean isLogLifecycle() {
        return false;
    }
}
