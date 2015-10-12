package com.easyguincheirotsguimaraes.easyguincheiro.servico;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Thiago on 12/10/2015.
 */
public class TaskWS extends android.os.AsyncTask<Map<String, String>, String, String> {

    private Context context;
    private TaskInterface taskInterface;
    private ProgressDialog progress;
    private String requestTAG;
    private String requestURL;
    private String operacao;


    public TaskWS(Context context, TaskInterface taskInterface, String operacao) {
        this.context = context;
        this.taskInterface = taskInterface;
        this.operacao = operacao;

        // Dados do web service
        requestTAG = WebServiceApp.getInstance().getActionTAG();
        requestURL = WebServiceApp.getInstance().getURL();
    }

    @Override
    protected void onPreExecute() {
        // Iniciar progress
        progress = new ProgressDialog(context);
        progress.show();
    }

    @Override
    protected String doInBackground(Map<String, String>... params) {

        Map paramsWS = new HashMap<String,String>();

        if (params != null) {
            paramsWS = params[0];
        }


        try {
            publishProgress("Aguarde...");
            paramsWS.put(requestTAG, operacao);
            String responseJson = HttpHelper.doPost(requestURL, paramsWS, "UTF-8");

            // Resposta do web service em String json
            return responseJson;
        }
        catch (IOException e) {
            Log.e("WebService", "Erro: " + e.getMessage());
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(String... params) {
        progress.setMessage(params[0]);
    }

    /**
     * O parâmetro de entrada deve ser o mesmo de "T" nomeado em TaskInterface!
     * @param json
     */
    @Override
    protected void onPostExecute(String json) {

        try {
            //Toast.makeText(context, json, Toast.LENGTH_SHORT).show();
            TaskResponse response = TaskResponse.parserJSON(json);
            taskInterface.doAfter(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
        progress.dismiss();
    }


}
