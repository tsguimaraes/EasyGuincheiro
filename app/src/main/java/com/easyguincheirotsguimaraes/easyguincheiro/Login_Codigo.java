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

import com.easyguincheirotsguimaraes.easyguincheiro.servico.UserSessionManager;

/* Classe principal de login
 O intuito desta classe e fazer a chamada de validação de login,
 Entrar na tela de recepção de login, ao clicar no botão entrar,
 Implementar a validação dos dados digitados,
 O cadastro será feito através do telefone, no qual a empresa de guincho terá que ligar,
 Para o mantenedor do sistema, cadastre os dados da empresa de guincho e avalie a reputação dela,
 antes de se associar ao Easy Guincho.
*/
public class Login_Codigo extends AppCompatActivity /*, AppBaseFragment*/{


    private Button buttonEntrar;
    EditText codigo; // Código
    //EditText senha;
    TextView textViewName,textViewAge,textViewword;
    UserSessionManager session;

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
                if (codigoText.equals("codigo")) {
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

    // Login via ws, deve ser feito com fragment, descomentar

    /*
    private TaskInterface<TaskResponse> taskLogin() {
        return new TaskInterface<TaskResponse>() {
            @Override
            public void doAfter(TaskResponse response) {

                if (response.getSuccess() == 1) {
                    try {
                        int id = response.getRecordSet().getInt("id");
                        String nome = response.getRecordSet().getString("nome");
                        String email = response.getRecordSet().getString("email");


                         // Nova sessão de usuário!

                        session.createLoginSession(id, nome, email);

                        // Iniciar MainActivty enviando uma mensagem de sucesso
                        Intent intent = new Intent(getContext(), Login_Placa.class);
                        intent.putExtra("message", response.getMessage());
                        startActivity(intent);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    AlertDialogManager.showAlertDialog(getContext(), null, response.getMessage(), false);
                }
            }
        };
    }


    // Login via ws

    private View.OnClickListener onClickLogar() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Iniciar asyncTask
                TaskWS taskLogin = new TaskWS(getContext(), taskLogin(), "Login");

                // Criar parâmetros de envio
                Map<String, String> paramsWebService = new HashMap<String, String>();
                paramsWebService.put("codigo", codigo.getText().toString());
                //paramsWebService.put("senha", et_senha.getText().toString());

                // Enviar ao web service
                taskLogin.execute(paramsWebService);
            }
        };
    }



    // Fim do login pelo ws
*/

}



