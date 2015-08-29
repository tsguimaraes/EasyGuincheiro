package com.easyguincheirotsguimaraes.easyguincheiro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
/*
 Esta é uma tela estática que tem o intuito de verificar se há novas solicitações no servidor
 */

public class TelaInicial extends AppCompatActivity {

    //private Button acordar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
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
