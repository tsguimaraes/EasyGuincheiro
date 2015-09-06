package com.easyguincheirotsguimaraes.easyguincheiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Placa extends AppCompatActivity {

    private Button buttonEntrar;
    EditText placa; // Placa
    TextView textViewName,textViewAge,textViewword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_placa);

        buttonEntrar = (Button) findViewById(R.id.entrar_placa);

        placa = (EditText) findViewById(R.id.placa_id);

    }

     // Validação

    public void onClick(View view) {

        final String placaText = placa.getText().toString();

        // Valida campos obrigatórios no login
        if (placaText.length() == 0)

        {
            placa.requestFocus();
            placa.setError("Digite uma placa válida.");
        }

        else {
            //Toast.makeText(Login_placa.this, "Campos preenchodos", Toast.LENGTH_LONG).show();
            // verificação se o código existe, onde está Thiago, colocar o campo do BD/ws
            if (placaText.equals("usjt")) {
                // Chamada da tela inicial

                Intent intent = new Intent(Login_Placa.this, TelaInicial.class);
                startActivity(intent);

            }
            else {
                Toast.makeText(Login_Placa.this, "Placa inválida.", Toast.LENGTH_LONG).show();
            }
            // Fim da chamda

        }
    }


    // Fim da validação

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login__placa, menu);
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
