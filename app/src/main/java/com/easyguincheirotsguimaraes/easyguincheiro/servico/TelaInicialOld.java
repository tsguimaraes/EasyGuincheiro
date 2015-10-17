/*
package com.easyguincheirotsguimaraes.easyguincheiro.servico;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.easyguincheirotsguimaraes.easyguincheiro.GuinchoNegocio;
import com.easyguincheirotsguimaraes.easyguincheiro.R;
import com.easyguincheirotsguimaraes.easyguincheiro.RecepcaoDeSinistro;
import com.easyguincheirotsguimaraes.easyguincheiro.ServicoJSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


// Created by Thiago on 14/10/2015.

public class TelaInicialOld {

    private TextView textViewResultado;
    GuinchoNegocio atual = new GuinchoNegocio();
    public String verificaStatus;
    int idDoGuincheiro = (2)-1; // ID do guincheiro obtido no momento do Login
    Double longitudeLocal;
    Double latitudeLocal;
    int delay = 2000; // intervalo de 2 segundo.
    int period = 30000; // repetir a cada 10 segundos.
    Timer timer = new Timer();

    public final String urlInicio = "guincheiros.json";
    //public final String urlFim = "http://tcceasyguincho.esy.es/EasyGuinchoWS/json/";
    public final String urlFim =   "http://tcceasyguincho.esy.es/EasyGuinchoWS/json/chamados/g_1";

    TextView resultadoTextView; // Texto da mensagem, por enquanto somente para teste
    ArrayList<GuinchoNegocio> arrayList = new ArrayList<>();

    //private Button acordar;

    public TelaInicialOld() {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        resultadoTextView = (TextView) findViewById(R.id.textViewResultado);

        timer.scheduleAtFixedRate(new TimerTask() {
            // Temporizador
            public void run() {

                // Verifica se há conexão
                if (!connectInternet()) {
                    Toast.makeText(TelaInicialOld.this, "Verifique a sua conexão", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Chamada da classe JSON
                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint(urlFim)
                        .build();
                ServicoJSON servicoJSON = restAdapter.create(ServicoJSON.class);  // Chamada da classe de interface JSON que é passado qual arquivo retrofit
                servicoJSON.getGuincho(new Callback<List<GuinchoNegocio>>() {
                    @Override
                    public void success(List<GuinchoNegocio> guinchoNegocios, Response response) {

                        // Chama a tela de Recepção de sinistro (aceitação).

                        for (int i = 0; i < guinchoNegocios.size(); i++) {

                            atual.setId(guinchoNegocios.get(i).getId());
                            atual.setModeloGuincho(guinchoNegocios.get(i).getModeloGuincho());
                            atual.setAnttGuincho(guinchoNegocios.get(i).getAnttGuincho());
                            atual.setCorGuincho(guinchoNegocios.get(i).getCorGuincho());
                            atual.setMarcaGuincho(guinchoNegocios.get(i).getMarcaGuincho());
                            atual.setPlacaGuincho(guinchoNegocios.get(i).getPlacaGuincho());
                            atual.setLatitudeCliente(guinchoNegocios.get(i).getlatitude());
                            atual.setLongitudeCliente(guinchoNegocios.get(i).getLongitude());

                            arrayList.add(atual);

                        }

                        //Verifica se tem objeto no JSON, não permite passar nulo,
                        if (arrayList.size() > 0 && arrayList.size() >= idDoGuincheiro
                                && (String.valueOf(arrayList.get(idDoGuincheiro).getId())).equals
                                ((String.valueOf(arrayList.get(idDoGuincheiro).getId())))) {

                            //Exibe apenas o arquivo JSON com o ID do guincheiro no parametro idDoGuincheiro

                            resultadoTextView.setText(String.valueOf(arrayList.get(idDoGuincheiro).toString()));
                            verificaStatus =
                                    "Endereço: Avenida Vital Brasil, 50\n"
                                            + "Bairro: Butantã \n"
                                            + "chegada aproximada: 40 Minutos\n"
                                            + "Distância: 20 km\n"
                                            + "Pagamento: Dinheiro\n";

                            // Chamada da tela de recepçao de sinistro
                            Intent i = new Intent(TelaInicialOld.this, RecepcaoDeSinistro.class);
                            timer.cancel();
                            startActivity(i);
                        }
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {// Caso ocorra o erro abaixo, habilitar a mensagem retrofitError.getMessage()); na mensagem abaixo
                        // E veja a mensagem que o retrofit retorna
                        resultadoTextView.setText("Sem acesso a internet, verifique a sua conexão com a internt." + retrofitError.getMessage());
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

}
*/