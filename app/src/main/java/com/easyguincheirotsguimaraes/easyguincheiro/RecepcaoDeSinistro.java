package com.easyguincheirotsguimaraes.easyguincheiro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.easyguincheirotsguimaraes.easyguincheiro.servico.ChamadoJSON;
import com.easyguincheirotsguimaraes.easyguincheiro.servico.TaskInterface;
import com.easyguincheirotsguimaraes.easyguincheiro.servico.TaskResponse;
import com.easyguincheirotsguimaraes.easyguincheiro.servico.TaskWS;

import java.util.HashMap;
import java.util.Map;

public class RecepcaoDeSinistro extends AppCompatActivity{
    private Button aceitoSolicitacao;
    private Button naoAceitoSolicitacao;
    TextView recepcaoView;
    ChamadoJSON chamadoJSON = new ChamadoJSON();
    RetornoJSON retornoJSON = new RetornoJSON();
    // Retrofit gera requisição ao servidor
    String file_chamado = "teste";
    int aceitou = 1;
    int idAcesso = 8; // será o id do guincheiro
    int idCliente = 1; // Virá do retrofit
    String classRequest = "teste2";
    public final String ENDPOINT = "http://tcceasyguincho.esy.es/EasyGuinchoWS/index.php/";

    final Context context = this;

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
                String responseJson = HttpHelper.doPost(requestURL, paramsWS, "UTF-8");
                Map paramsWS = new HashMap<String,String>();
                paramWS.put("aceitou","1");
                paramWS.put("idCliente","2");
                */

                /*
                Intent intent = new Intent(RecepcaoDeSinistro.this, Sinistro.class);
                startActivity(intent);
                v.animate();
                */

                TaskWS taskRespostaGuincheiro = new TaskWS(context, taskResposta(), "RespostaGuinhceiro");

                Map paramsWS = new HashMap<String,String>();

                paramsWS.put("file_chamado","c1_2015_10_18_22_58_19_000000.json");
                paramsWS.put("aceitou","1");
                paramsWS.put("idCliente","2");
                paramsWS.put("idAcesso","8");

                taskRespostaGuincheiro.execute(paramsWS);

                Intent intent = new Intent(RecepcaoDeSinistro.this, Sinistro.class);
                startActivity(intent);
                v.animate();

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


    private TaskInterface<TaskResponse> taskResposta() {

        return new TaskInterface<TaskResponse>() {

            @Override
            public void doAfter(TaskResponse response) {

                if (response.getSuccess() == 1) {
                    Intent intent = new Intent(context, Sinistro.class);
                    startActivity(intent);
                }
            }
        };
    }

}
