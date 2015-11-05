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

public class Sinistro extends AppCompatActivity {
    TextView dadosClienteView;
    private Button pagar;
    public int contador = 1; // Numero de cancelamentos
    private Button cancelarSolicitacao;
    private Button mapsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinistro);
        dadosClienteView = (TextView) findViewById(R.id.dadosClienteView);

        dadosClienteView.setText(
                "Cliente: Thiago Santos Guimarães\n"
                        + "Endereço: Avenida Vital Brasil, 50\n"
                        + "Bairro: Butantã \n"
                        + "chegada aproximada: 40 Minutos\n"
                        + "Distância: 20 km\n"
                        + "Pagamento: Dinheiro\n");

        // Ao clicar em pagar abrirá a tela de pagamento

        pagar = (Button) findViewById(R.id.button_pagar);
        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sinistro.this, Pagamento.class);
                startActivity(intent);
                v.animate();

            }
        });

        // Ao clicar em cancelar, retornará para a telaInicial


        cancelarSolicitacao = (Button) findViewById(R.id.buttonCancelar);
        cancelarSolicitacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //TelaInicial
                Intent intent = new Intent(Sinistro.this, Avaliacao.class);
                startActivity(intent);
                v.animate();
                // Implementar mais de 3 cancelamentos por dia.
          if (contador >=3) {
              Toast.makeText(Sinistro.this, "Acesso bloqueado por 24 horas.", Toast.LENGTH_LONG).show();
              Intent intent2 = new Intent(Sinistro.this, Login_Codigo.class);
              startActivity(intent2);
            }

           }

        });

        // Chama tela de rota para abrir o maps
        /*
        mapsButton = (Button) findViewById(R.id.buttonMaps);
        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sinistro.this, Rota.class);
                startActivity(intent);
                v.animate();

            }
        });
        */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sinistro, menu);
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
