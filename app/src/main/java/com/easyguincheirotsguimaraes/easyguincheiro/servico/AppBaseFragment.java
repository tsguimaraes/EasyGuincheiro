package com.easyguincheirotsguimaraes.easyguincheiro.servico;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Thiago on 12/10/2015.
 */
public abstract class AppBaseFragment extends DebugFragment {

    protected static final String PREF_LOGIN = "prefsLogin";

    public AppBaseFragment() {
    }

    public Context getContext() {
        return this.getActivity();
    }



    protected void setTextString(int resId, String text) {
        View view = this.getView();
        if(view != null) {
            TextView t = (TextView)view.findViewById(resId);
            if(t != null) {
                t.setText(text);
            }
        }

    }

    protected String getTextString(int resId) {
        View view = this.getView();
        if(view != null) {
            TextView t = (TextView)view.findViewById(resId);
            if(t != null) {
                return t.getText().toString();
            }
        }

        return null;
    }


}
