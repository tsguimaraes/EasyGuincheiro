package com.easyguincheirotsguimaraes.easyguincheiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.easyguincheirotsguimaraes.easyguincheiro.servico.ChamadoJSON;
import com.easyguincheirotsguimaraes.easyguincheiro.servico.SinistroJSON;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RecepcaoDeSinistro extends AppCompatActivity{
    private Button aceitoSolicitacao;
    private Button naoAceitoSolicitacao;
    TextView recepcaoView;
    ChamadoJSON chamadoJSON = new ChamadoJSON();
    // Retrofit gera requisição ao servidor
    String file_chamado = "teste";
    int aceitou = 1;
    int idAcesso = 8; // será o id do guincheiro
    int idCliente = 1; // Virá do retrofit
    String classRequest = "teste2";
    public final String ENDPOINT = "http://tcceasyguincho.esy.es/EasyGuinchoWS";
    public static final int NETWORK_STATE_REGISTER=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepcao_de_sinistro);
        recepcaoView = (TextView) findViewById(R.id.recepcao);



        // Dados do solicitante
        recepcaoView.setText(chamadoJSON.toString()
                /*
                "Endereço: Avenida Vital Brasil, 50\n"
                +"Bairro: Butantã \n"
                +"chegada aproximada: 40 Minutos\n"
                +"Distância: 20 km\n"
                +"Pagamento: Dinheiro\n"
                */
        );

        // Chamada de tela Sinistro ao aceitar a solicitação de guincho por parte do guincheiro
        aceitoSolicitacao = (Button) findViewById(R.id.buttonAceito);
        aceitoSolicitacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                Intent intent = new Intent(RecepcaoDeSinistro.this, Sinistro.class);
                startActivity(intent);
                v.animate();
                */

                //retrofit tworzenie polecenia

                RestAdapter adapter = new RestAdapter.Builder()
                        .setEndpoint(ENDPOINT)
                        .build();

                //tworzenie api klasy flowers
                SinistroJSON api = adapter.create(SinistroJSON.class);


                api.respostaGuincheiro(
                        file_chamado
                        ,aceitou
                        ,idAcesso
                        ,idCliente
                        ,classRequest
                        ,new Callback<ChamadoJSON>() {

                    @Override
                    public void failure(final RetrofitError error) {
                        //android.util.Log.i("example", "Error, body: " + error.getBody().toString());
                        Toast.makeText(RecepcaoDeSinistro.this, "Erro:"+ error.getMessage(), Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void success(ChamadoJSON resposta, Response response) {
                        // Do something with the User object returned
                        //Log.d("hello", response.toString());
                        Toast.makeText(RecepcaoDeSinistro.this, "OK!!:", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RecepcaoDeSinistro.this, Sinistro.class);
                        startActivity(intent);
                       // Intent intent = new Intent(RecepcaoDeSinistro.this, Sinistro.class);
                       // startActivity(intent);



                    }
                });


         // Fim


            }
        });
        // Chama a tela de aguardo
        naoAceitoSolicitacao = (Button) findViewById(R.id.buttonRecusa);
        naoAceitoSolicitacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecepcaoDeSinistro.this, TelaInicial.class);
                startActivity(intent);
                v.animate();

            }
        });


        // Tem por objetivo, não aceitar a requisição
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recepcao_de_sinistro, menu);
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

}
