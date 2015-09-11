package com.easyguincheirotsguimaraes.easyguincheiro;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
/*
 Esta é uma tela estática que tem o intuito de verificar se há novas solicitações no servidor
 */

public class TelaInicial extends AppCompatActivity {

    //int validar;
    private TextView textViewResultado;
    public String verificaStatus;
    int idDoGuincheiro = (7)-1; // ID do guincheiro obtido no momento do Login
    //Caminho do arquivo JSON será o localhost
    public final String url = "http://servicio-monkydevs.rhcloud.com";
    //10.0.3.2:3310
    //public final String url = "http://10.0.2.3:3310/EasyGuinchoWS/json/chamados";

    TextView resultadoTextView; // Texto da mensagem, por enquanto somente para teste
    ArrayList<GuinchoNegocio> arrayList = new ArrayList<>();

    //private Button acordar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        resultadoTextView = (TextView) findViewById(R.id.textViewResultado);

        // Verifica se há conxão
        if (!connectInternet()){
            Toast.makeText(this,"Verifique a sua conexão",Toast.LENGTH_SHORT).show();
            return;
        }
        //validar = 0;
        // Chamada da classe JSON
        RestAdapter restAdapter = new RestAdapter.Builder()
                                      .setEndpoint(url)
                                      .build();
        ServicoJSON servicoJSON = restAdapter.create(ServicoJSON.class);  // Chamada da classe de interface JSON que é passado qual arquivo retrofit
        servicoJSON.getGuincho(new Callback<List<GuinchoNegocio>>() {
            @Override
            public void success(List<GuinchoNegocio> guinchoNegocios, Response response) {
                // Chama a tela de Recepção de sinistro (aceitação).

                for (int i = 0; i < guinchoNegocios.size(); i++){
                    GuinchoNegocio atual = new GuinchoNegocio();

                    atual.setId(guinchoNegocios.get(i).getId());
                    atual.setModeloGuincho(guinchoNegocios.get(i).getModeloGuincho());
                    atual.setAnttGuincho(guinchoNegocios.get(i).getAnttGuincho());
                    atual.setCorGuincho(guinchoNegocios.get(i).getCorGuincho());
                    atual.setMarcaGuincho(guinchoNegocios.get(i).getMarcaGuincho());
                    atual.setPlacaGuincho(guinchoNegocios.get(i).getPlacaGuincho());


                    arrayList.add(atual);

                }
                /*Verifica se tem objeto no JSON */
                if (arrayList.size() > 0 && arrayList.size() >=  idDoGuincheiro
                                         && (String.valueOf(arrayList.get(idDoGuincheiro).getId())).equals
                                            ((String.valueOf(arrayList.get(idDoGuincheiro).getId()))))
                        //String.valueOf(arrayList.get(idDoGuincheiro).getId()) != null )
                {

                //    if ((String.valueOf(arrayList.get(idDoGuincheiro).getId())) //.equals(4))
                //            .equals ((String.valueOf(arrayList.get(idDoGuincheiro).getId())))) {



                    /*Exibe apenas o arquivo JSON com o ID do guincheiro no parametro idDoGuincheiro
                    *
                    * */
                        //Toast.makeText(TelaInicial.this, "Deu certo!", Toast.LENGTH_SHORT).show();
                        //resultadoTextView.setText(guinchoNegocios.toString());
                        //resultadoTextView.setText(String.valueOf(arrayList.get(idDoGuincheiro).getId())); // Está funcionando
                        //if (resultadoTextView.setText(guinchoNegocios.toString()) == );
                        //textViewResultado.setText(String.valueOf(arrayList.get(9).getIdGuincho()));
                    /*textViewResultado.setText(String.valueOf(arrayList.get(0).getModeloGuincho()));
                    resultadoTextView.setText(String.valueOf(arrayList.get(0).getAnttGuincho()));
                    resultadoTextView.setText(String.valueOf(arrayList.get(0).getCorGuincho()));
                    resultadoTextView.setText(String.valueOf(arrayList.get(0).getMarcaGuincho()));
                    resultadoTextView.setText(String.valueOf(arrayList.get(0).getPlacaGuincho()));*/
                        /*resultadoTextView.setText(
                         "Solicitante: Gabriel Freire Braz \n"
                        +"Endereço: Avenida Vital Brasil, 50 \n"
                        +"Distância: 20 km \n"
                        +"Pagamento: Dinheiro \n"
                        +"Veículo: Mitsubish L200 \n");*/
                        //resultadoTextView.setText("Filho da p");
                        // Chamada da tela de recepçao de sinistro
                        Intent i = new Intent(TelaInicial.this, RecepcaoDeSinistro.class);
                        startActivity(i);
                    }
                }

        //  }

            @Override
            public void failure(RetrofitError retrofitError) {// Caso ocorra o erro abaixo, habilitar a mensagem retrofitError.getMessage()); na mensagem abaixo
                                                              // E veja a mensagem que o retrofit retorna
                resultadoTextView.setText("Sem acesso a internet, verifique a sua conexão com a internt."+ retrofitError.getMessage());
            }

        });
    }

    public boolean connectInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()){
            return true;
        }
        else{
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
}
