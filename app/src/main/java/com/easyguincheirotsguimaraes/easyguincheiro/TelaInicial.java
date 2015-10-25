package com.easyguincheirotsguimaraes.easyguincheiro;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.easyguincheirotsguimaraes.easyguincheiro.servico.ChamadoJSON;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
/*
 Esta é uma tela estática que tem o intuito de verificar se há novas solicitações no servidor
 */

public class TelaInicial extends AppCompatActivity{

    WebView webView;
    private TextView textViewResultado;
    GuinchoNegocio atual = new GuinchoNegocio();
    ChamadoJSON chamado = new ChamadoJSON();
    int idDoGuincheiro = 1;//(1)-1; // ID do guincheiro obtido no momento do Login
    Double longitudeLocal;
    Double latitudeLocal;
    int delay = 5000; // intervalo de x segundo.
    int period = 60000; // repetir a cada x segundos.
    Timer timer = new Timer();
    public final String dynamic = "c1_2015_10_24_11_55_03_000000.json";
    public String dynamic2 = "";

    public final String urlFim =     "http://tcceasyguincho.esy.es/EasyGuinchoWS/json/chamados_realizados/g_"+idDoGuincheiro;
    //public final String urlFile =    "http://tcceasyguincho.esy.es/EasyGuinchoWS/json/";
    //public final String urlFileFim = "tentativas_acesso_cliente";

    //private String diretorio = "http://tcceasyguincho.esy.es/EasyGuinchoWS/json/chamados_realizados/g_6/";

    TextView resultadoTextView; // Texto da mensagem, por enquanto somente para teste
    ArrayList<ChamadoJSON> arrayList = new ArrayList<>();

    //private Button acordar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        resultadoTextView = (TextView) findViewById(R.id.textViewResultado);
        final String user;
        // Mudar para a classe correta
        //calculaDistancia(-23.57223045692876, -46.70527870000001,-23.575902256929993, -46.70647415000002);

        if (!connectInternet()) {
            Toast.makeText(TelaInicial.this, "Verifique a sua conexão", Toast.LENGTH_SHORT).show();
            return;
        }

        // Método de leitura de JSON Chamado
            timer.scheduleAtFixedRate(new TimerTask() {
                // Temporizador
                public void run() {


                    // Chamada da classe JSON
                    RestAdapter restAdapter = new RestAdapter.Builder()
                            .setEndpoint(urlFim)
                            .build();
                    ServicoJSON servicoJSON = restAdapter.create(ServicoJSON.class);  // Chamada da classe de interface JSON que é passado qual arquivo retrofit

                        servicoJSON.getGuincho(dynamic,//Variavel com o final da url declarada como final e public acima
                                new Callback<List<ChamadoJSON>>() {
                                    @Override
                                    public void success(List<ChamadoJSON> chamadoJSONs, Response response) {

                                        // Chama a tela de Recepção de sinistro (aceitação).

                                        for (int i = 0; i < chamadoJSONs.size(); i++) {

                                            chamado.setId(chamadoJSONs.get(i).getId());
                                            chamado.setEndereco(chamadoJSONs.get(i).getEndereco());
                                            chamado.setBairro(chamadoJSONs.get(i).getBairro());
                                            chamado.setNumero(chamadoJSONs.get(i).getNumero());
                                            chamado.setforma_pagamento(chamadoJSONs.get(i).getforma_pagamento());
                                            chamado.settempo_chegada(chamadoJSONs.get(i).gettempo_chegada());
                                            chamado.setdistancia_a_percorrer(chamadoJSONs.get(i).getdistancia_a_percorrer());
                                            chamado.setveiculo_modelo(chamadoJSONs.get(i).getveiculo_modelo());

                                            arrayList.add(chamado);

                                        }


                                            //Exibe apenas o arquivo JSON com o ID do guincheiro no parametro idDoGuincheiro

                                            resultadoTextView.setText(String.valueOf(arrayList.get(0).toString()));


                                            // Chamada da tela de recepçao de sinistro
                                            timer.cancel();
                                            Intent i = new Intent(TelaInicial.this, RecepcaoDeSinistro.class);
                                            i.putExtra(String.valueOf(arrayList.get(0).toString()), resultadoTextView.toString());
                                            startActivity(i);

                                    }

                                    @Override
                                    public void failure(RetrofitError retrofitError) {// Caso ocorra o erro abaixo, habilitar a mensagem retrofitError.getMessage()); na mensagem abaixo
                                        // E veja a mensagem que o retrofit retorna
                                        resultadoTextView.setText("Erro: " + retrofitError.getMessage());
                                        Intent i = new Intent(TelaInicial.this, TelaInicial.class);
                                        startActivity(i);

                                    }

                                });
                }
            }, delay, period);

        // Fim do método de leitura do JSON chamado

        //lerTodasPessoas();

        }


    public boolean connectInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }

    }

    // Retorna latitude e longitude

    public final Double latitude () {

        latitudeLocal = -23.54585280941764;
        return this.latitudeLocal;
    }


    public final Double longitude (){

        return -46.641223000000025;
        //return longitudeLocal;
    }

    public void notification(){

        Intent intent   = new Intent("ALARM_DISPARADO");
        PendingIntent p = PendingIntent.getBroadcast(this, 0, intent,0);

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.add(Calendar.SECOND, 3);

        AlarmManager alarme = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarme.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), p);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();

        Intent intent   = new Intent("ALARM_DISPARADO");
        PendingIntent p = PendingIntent.getBroadcast(this, 0, intent, 0);

        AlarmManager alarme = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarme.cancel(p);
    }

    /*
    private void lerTodasPessoas() {
        String result = getRESTFileContent(
                "http://tcceasyguincho.esy.es/EasyGuinchoWS/json/chamados_realizados/g_6/");
        if (result == null){
            Log.e("NGVL", "Falha ao acessar WS");
            return;
        }

        try {
            JSONObject json = new JSONObject(result);
            JSONArray pessoasArray =
                    json.getJSONArray("pessoa");

            JSONObject pessoaJson;

            for (int i = 0; i < pessoasArray.length(); i++) {
                pessoaJson = new JSONObject(
                        pessoasArray.getString(i));

                Log.i("NGVL",
                        "------------------------");
                Log.i("NGVL",
                        "id=" + pessoaJson.getInt("id"));
                Log.i("NGVL",
                        "nome="+ pessoaJson.getString("nome"));
            }
        } catch (JSONException e) {
            Log.e("NGVL", "Erro no parsing do JSON", e);
        }
    }

    public String getRESTFileContent(String url) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);

        try {
            HttpResponse response =
                    httpclient.execute(httpget);

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                InputStream instream = entity.getContent();
                String result = toString();

                instream.close();
                return result;
            }
        } catch (Exception e) {
            Log.e("NGVL", "Falha ao acessar Web service", e);
        }
        return null;
    }
*/

    private void lerTodasPessoas() {
        String result = getRESTFileContent(
                "http://tcceasyguincho.esy.es/EasyGuinchoWS/json/chamados_realizados/");
        if (result == null){
            Log.e("NGVL", "Falha lerTodasPessoas "+Log.INFO);
            return;
        }

        try {
            JSONObject json = new JSONObject(result);
            JSONArray pessoasArray =
                    json.getJSONArray("pessoa");

            JSONObject pessoaJson;

            for (int i = 0; i < pessoasArray.length(); i++) {
                pessoaJson = new JSONObject(
                        pessoasArray.getString(i));

                Log.i("NGVL",
                        "------------------------");
                Log.i("NGVL",
                        "id="+ pessoaJson.getInt("id"));
                Log.i("NGVL",
                        "nome="+ pessoaJson.getString("nome"));
                Toast.makeText(TelaInicial.this,"Funcionou**1**", Toast.LENGTH_LONG);
            }
        } catch (JSONException e) {
            Log.e("NGVL", "Erro no parsing do JSON "+ HttpGet.METHOD_NAME, e);
        }
    }

    public String getRESTFileContent(String url) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);

        try {
            HttpResponse response =
                    httpclient.execute(httpget);

            HttpEntity entity = response.getEntity();

                InputStream instream = entity.getContent();
                String result = toString(instream);

                instream.close();
                return result;

        } catch (Exception e) {
            Log.e("NGVL", "Falha ao acessar Web service, getRESTFileContent: "+e.getCause(), e);
        }
        return null;
    }

    private String toString(InputStream is)
            throws IOException {

        byte[] bytes = new byte[1024];
        ByteArrayOutputStream baos =
                new ByteArrayOutputStream();
        int lidos;
        while ((lidos = is.read(bytes)) > 0){
            baos.write(bytes, 0, lidos);
        }
        return new String(baos.toByteArray());
    }

}


