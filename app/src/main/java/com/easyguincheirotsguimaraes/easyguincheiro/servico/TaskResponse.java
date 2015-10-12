package com.easyguincheirotsguimaraes.easyguincheiro.servico;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Thiago on 12/10/2015.
 */
public class TaskResponse {

    private String message;
    private int success;
    private JSONObject recordSet;


    /**
     *
     * @param json
     * @return
     * @throws IOException
     */
    public static TaskResponse parserJSON(String json) throws IOException {

        try {
            JSONObject jsonObject = new JSONObject(json);

            // recebe parâmetros de resposta do ws
            String message = jsonObject.getString("message");
            int success = jsonObject.getInt("success");
            String rs_json = jsonObject.getString("recordSet");

            // salva o json do rs
            JSONObject recordSet = new JSONObject(rs_json);

            // gravar valores no objeto taskRespose
            TaskResponse r = new TaskResponse();
            r.setMessage(message);
            r.setSuccess(success);
            r.setRecordSet(recordSet);

            return r;

        } catch (JSONException e){
            throw new IOException(e.getMessage(), e);
        }
    }


    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public int getSuccess() {
        return success;
    }

    private void setSuccess(int success) {
        this.success = success;
    }

    public JSONObject getRecordSet() {
        return recordSet;
    }

    private void setRecordSet(JSONObject recordSet) {
        this.recordSet = recordSet;
    }
}
