package com.easyguincheirotsguimaraes.easyguincheiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/* Classe principal de login
 O intuito desta classe e fazer a chamada de validação de login,
 Entrar na tela de recepção de login, ao clicar no botão entrar,
 Implementar a validação dos dados digitados,
 O cadastro será feito através do telefone, no qual a empresa de guincho terá que ligar,
 Para o mantenedor do sistema, cadastre os dados da empresa de guincho e avalie a reputação dela,
 antes de se associar ao Easy Guincho.
*/
public class MainActivity extends AppCompatActivity {

    private Button buttonEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ao clicar no botão entrar, chamará a tela de recepção de sinistro
        buttonEntrar = (Button) findViewById(R.id.buttonEntrar);
        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecepcaoDeSinistro.class);
                startActivity(intent);
                v.animate();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

