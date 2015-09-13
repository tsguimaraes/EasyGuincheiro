package com.easyguincheirotsguimaraes.easyguincheiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ManutencaoGuincho extends AppCompatActivity {
    private Button cadastraGuincho;
    private Button consultaGuincheiro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manutencao_guincho);

        // Chamada da tela de cadastr de frota quando for o usuário do Administrador da empresa de guincho
        cadastraGuincho = (Button) findViewById(R.id.cadastraFrota);
        cadastraGuincho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManutencaoGuincho.this, CadastroFrota.class);
                startActivity(intent);
                v.animate();

            }
        });
        // Implementar consulta no banco de dados para a empresa logada

        consultaGuincheiro = (Button) findViewById(R.id.consultarFrota);
        consultaGuincheiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManutencaoGuincho.this, ConsultaGuinchoFrota.class);
                startActivity(intent);
                v.animate();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_manutencao_guincho, menu);
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
