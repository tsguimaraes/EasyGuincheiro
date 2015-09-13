package com.easyguincheirotsguimaraes.easyguincheiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/* Classe principal de login
 O intuito desta classe e fazer a chamada de validação de login,
 Entrar na tela de recepção de login, ao clicar no botão entrar,
 Implementar a validação dos dados digitados,
 O cadastro será feito através do telefone, no qual a empresa de guincho terá que ligar,
 Para o mantenedor do sistema, cadastre os dados da empresa de guincho e avalie a reputação dela,
 antes de se associar ao Easy Guincho.
*/
public class Login_Codigo extends AppCompatActivity {

    private Button buttonEntrar;
    EditText codigo; // Código
    //EditText senha;
    TextView textViewName,textViewAge,textViewword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_codigo);

        buttonEntrar = (Button) findViewById(R.id.entrar_codigo);

        codigo = (EditText) findViewById(R.id.codigoText);

        //senha = (EditText) findViewById(R.id.senha);


        // Ao clicar no botão entrar, chamará a tela de recepção de sinistro
        /*
        buttonEntrar = (Button) findViewById(R.id.buttonEntrar);
        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Codigo.this, TelaInicial.class);
                startActivity(intent);
                v.animate();

            }
        });
        */
    }
        // Valida se os campos estão vazios antes de entrar
        public void onClick(View view) {

            final String codigoText = codigo.getText().toString();

            //final String senhaGuincheiro = senha.getText().toString();

            // Valida campos obrigatórios no login
            if (codigoText.length() == 0)

            {
                codigo.requestFocus();
                codigo.setError("Digite um código válido.");
            }
            /*
            else if(!Name.matches("[a-zA-Z ]+"))
            {
                codigo.requestFocus();
                codigo.setError("ENTER ONLY ALPHABETICAL CHARACTER");
            }
            */
            /*
            else if (senhaGuincheiro.length() == 0) {
                senha.requestFocus();
                senha.setError("O campo senha deve ser preenchido");
            }
            */
            else {
                //Toast.makeText(Login_Codigo.this, "Campos preenchodos", Toast.LENGTH_LONG).show();
                // verificação se o código existe, onde está Thiago, colocar o campo do BD/ws
                if (codigoText.equals("thiago")) {
                    // Chamada da tela inicial

                    //buttonEntrar = (Button) findViewById(R.id.buttonEntrar);
                    //buttonEntrar.setOnClickListener(new View.OnClickListener() {
                      //  @Override
                       // public void onClick(View v) {
                            Intent intent = new Intent(Login_Codigo.this, Login_Placa.class);
                            startActivity(intent);
                         //   v.animate();

                        //}
                    //});
                }
                else if

                    //
                       (codigoText.equals("masterAjax")) {
                            // Chamada da tela inicial

                            //buttonEntrar = (Button) findViewById(R.id.buttonEntrar);
                            //buttonEntrar.setOnClickListener(new View.OnClickListener() {
                            //  @Override
                            // public void onClick(View v) {
                            Intent intent = new Intent(Login_Codigo.this, ManutencaoGuincho.class);
                            startActivity(intent);
                            //   v.animate();

                            //}
                            //});
                        }
                        else {
                            Toast.makeText(Login_Codigo.this, "Código inválido.", Toast.LENGTH_LONG).show();
                        }
                        // Fim da chamda
                    }

                    //

                   // Toast.makeText(Login_Codigo.this, "Código inválido.", Toast.LENGTH_LONG).show();
                }
                // Fim da chamda





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

