package com.easyguincheirotsguimaraes.easyguincheiro;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.easyguincheirotsguimaraes.easyguincheiro.servico.ChamadoJSON;

import java.util.ArrayList;
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
    public String verificaStatus;
    int idDoGuincheiro = 6;//(1)-1; // ID do guincheiro obtido no momento do Login
    Double longitudeLocal;
    Double latitudeLocal;
    int delay = 1000; // intervalo de 2 segundo.
    int period = 60000; // repetir a cada 10 segundos.
    Timer timer = new Timer();
    public final String dynamic = "c2_2015_10_14_20_18_36_000000.json";

    //public final String urlFim = "http://tcceasyguincho.esy.es/EasyGuinchoWS/json/";
    public final String urlFim =   "http://tcceasyguincho.esy.es/EasyGuinchoWS/json/chamados/g_"+idDoGuincheiro;

    TextView resultadoTextView; // Texto da mensagem, por enquanto somente para teste
    ArrayList<ChamadoJSON> arrayList = new ArrayList<>();

    //private Button acordar;

    public TelaInicial() {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        resultadoTextView = (TextView) findViewById(R.id.textViewResultado);
        final String user;
        /*
        // Teste

        Gson gson = new GsonBuilder()
                .create();
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Content-Type", "application/json");
            }
        };
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(urlFim)
                .setRequestInterceptor(requestInterceptor)
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build();
        ServicoJSON servicoJson = restAdapter.create(ServicoJSON.class);
        */
        // TESTE




        //leArquivo();

            timer.scheduleAtFixedRate(new TimerTask() {
                // Temporizador
                public void run() {

                    // Verifica se há conexão
                    if (!connectInternet()) {
                        Toast.makeText(TelaInicial.this, "Verifique a sua conexão", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Chamada da classe JSON
                    RestAdapter restAdapter = new RestAdapter.Builder()
                            .setEndpoint(urlFim)
                            .build();
                    ServicoJSON servicoJSON = restAdapter.create(ServicoJSON.class);  // Chamada da classe de interface JSON que é passado qual arquivo retrofit
                      //servicoJSON.getGuincho(new Callback<List<ChamadoJSON>>() {
                        servicoJSON.getGuincho(dynamic,
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

                                        //Verifica se tem objeto no JSON, não permite passar nulo,
                                        /*
                                        if (arrayList.size() > 0 && arrayList.size() >= idDoGuincheiro &&
                                                (String.valueOf(arrayList.get(idDoGuincheiro).getId())).equals
                                                ((String.valueOf(arrayList.get(idDoGuincheiro).getId())))) {
                                         */
                                            //Exibe apenas o arquivo JSON com o ID do guincheiro no parametro idDoGuincheiro

                                            resultadoTextView.setText(String.valueOf(arrayList.get(0).toString()));
                                            verificaStatus =
                                                    "Endereço: "//+chamado.getEndereco() +"\n"
                                                            + "Bairro: "//+chamado.getBairro() +"\n"
                                                            + "chegada aproximada: "//+chamado.gettempo_chegada()+"\n"
                                                            + "Distância:"//+chamado.getdistancia_a_percorrer() +"\n"
                                                            + "Pagamento: ";//+chamado.getforma_pagamento()+"\n";

                                            // Chamada da tela de recepçao de sinistro
                                            Intent i = new Intent(TelaInicial.this, RecepcaoDeSinistro.class);
                                            timer.cancel();
                                            startActivity(i);

                                    }

                                    @Override
                                    public void failure(RetrofitError retrofitError) {// Caso ocorra o erro abaixo, habilitar a mensagem retrofitError.getMessage()); na mensagem abaixo
                                        // E veja a mensagem que o retrofit retorna
                                        //Intent i = new Intent(TelaInicial.this, TelaInicial.class);
                                        //startActivity(i);
                                        resultadoTextView.setText("Erro: " + retrofitError.getMessage());
                                        run();
                                    }

                                });
                }
            }, delay, period);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_inicial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
    public String getTask(){

        return "c2_2015_10_14_20_18_36_000000.json";
    }
}
