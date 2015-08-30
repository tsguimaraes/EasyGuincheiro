package com.easyguincheirotsguimaraes.easyguincheiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
/*
 Esta é uma tela estática que tem o intuito de verificar se há novas solicitações no servidor
 */

public class TelaInicial extends AppCompatActivity {

    //Caminho do arquivo JSON será o localhost
    public final String url = "http://servicio-monkydevs.rhcloud.com";
    // Caso ocorra erro irá apresentar neste texto
    //TextView textViewResultado;
    TextView resultadoTextView;

    //private Button acordar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        resultadoTextView = (TextView) findViewById(R.id.textViewResultado);

        // Chamada da classe JSON
        RestAdapter restAdapter = new RestAdapter.Builder()
                                      .setEndpoint(url)
                                      .build();
        ServicoJSON servicoJSON = restAdapter.create(ServicoJSON.class);  // Chamada da classe de interface JSON que é passado qual arquivo retrofit

        GuinchoNegocio gn = new GuinchoNegocio(80);

        servicoJSON.getGuincho(new Callback<List<GuinchoNegocio>>() {
            @Override
            public void success(List<GuinchoNegocio> guinchoNegocios, Response response) {

                Intent i = new Intent(TelaInicial.this, RecepcaoDeSinistro.class);
                startActivity(i);
            }

            @Override
            public void failure(RetrofitError retrofitError) {// Caso ocorra o erro abaixo, habilitar a mensagem retrofitError.getMessage()); na mensagem abaixo
                                                              // E veja a mensagem que o retrofit retorna
                resultadoTextView.setText("Não foi possível encontrar o caminho http" +
                                          ", Causas: Sem acesso a internet ou caminho inválido, contate-nos (11)99516-4955.");// + retrofitError.getMessage());
            }
        });
        // Apenas está passando direto para a tela de aceitação pois a lógica de novas requisições ainda não foi implementada
       // Intent i = new Intent(TelaInicial.this, RecepcaoDeSinistro.class);
       // startActivity(i);
        // Chamada manual para não passar direto pela tela, excluir o botão ACORDAR.
        // Chama a tela de aguardo
       /* acordar = (Button) findViewById(R.id.buttonAcorda);
        acordar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, RecepcaoDeSinistro.class);
                startActivity(intent);
                v.animate();

            }
        });
   */
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
}
