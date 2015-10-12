package com.easyguincheirotsguimaraes.easyguincheiro.servico;

/**
 * Created by Thiago on 12/10/2015.
 */
public interface TaskAlertDialog {

    /*
    interface Alert {
        public void after();
    }
    */

    interface Confirm {
        public void afterPositive();
        public void afterNegative();
    }
}
