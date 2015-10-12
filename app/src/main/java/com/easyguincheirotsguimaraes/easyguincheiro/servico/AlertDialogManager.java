package com.easyguincheirotsguimaraes.easyguincheiro.servico;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import com.easyguincheirotsguimaraes.easyguincheiro.R;

/**
 * Created by Thiago on 12/10/2015.
 */
public class AlertDialogManager {
    /**
     * Function to display simple Alert Dialog
     * @param context - application context
     * @param title - alert dialog title
     * @param message - alert message
     * @param status - success/failure (used to set icon)
     *               - pass null if you don't want icon
     * */
    public static void showAlertDialog(Context context, String title, String message,
                                       Boolean status) {

        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);

        if(status != null)
            // Setting alert dialog icon
            alertDialog.setIcon((status) ? R.drawable.ic_success : R.drawable.ic_fail);

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }




    /**
     *
     * @param context
     * @param title
     * @param message
     * @param task
     */
    public static void showConfirmDialog(Context context,
                                         String title,
                                         String message,
                                         View viewInflater,
                                         final TaskAlertDialog.Confirm task) {

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        if (viewInflater != null) {
            builder.setView(viewInflater);
        }

        builder
                .setMessage(message)
                .setTitle(title)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        task.afterPositive();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        task.afterNegative();
                    }
                }).create();
        builder.show();
    }
}