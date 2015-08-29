package com.easyguincheirotsguimaraes.easyguincheiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class RecepcaoDeSinistro extends AppCompatActivity {
    private Button aceitoSolicitacao;
    private Button naoAceitoSolicitacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepcao_de_sinistro);

        // Tem por objetivo executar, aceitar a requisição.

        // Chamada de tela de mapa após aceitar o pedido de guincho
        aceitoSolicitacao = (Button) findViewById(R.id.buttonAceito);
        aceitoSolicitacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecepcaoDeSinistro.this, Rota.class);
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
}
