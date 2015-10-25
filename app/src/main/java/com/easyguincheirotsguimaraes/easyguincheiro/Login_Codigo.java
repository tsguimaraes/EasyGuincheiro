package com.easyguincheirotsguimaraes.easyguincheiro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.easyguincheirotsguimaraes.easyguincheiro.servico.AlertDialogManager;
import com.easyguincheirotsguimaraes.easyguincheiro.servico.TaskInterface;
import com.easyguincheirotsguimaraes.easyguincheiro.servico.TaskResponse;
import com.easyguincheirotsguimaraes.easyguincheiro.servico.UserSessionManager;

import org.json.JSONException;
import org.json.JSONObject;

/* Classe principal de login
 O intuito desta classe e fazer a chamada de validação de login,
 Entrar na tela de recepção de login, ao clicar no botão entrar,
 Implementar a validação dos dados digitados,
 O cadastro será feito através do telefone, no qual a empresa de guincho terá que ligar,
 Para o mantenedor do sistema, cadastre os dados da empresa de guincho e avalie a reputação dela,
 antes de se associar ao Easy Guincho.
*/
public class Login_Codigo extends AppBaseActivity /*, AppBaseFragment*/ {


    private Button buttonEntrar;
    EditText codigo; // Código
    //EditText senha;
    TextView textViewName, textViewAge, textViewword;
    UserSessionManager session;
    Intent i = new Intent();
    // Placa fake
    String placa = "4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_codigo);

        session = new UserSessionManager(getContext());

        buttonEntrar = (Button) findViewById(R.id.entrar_codigo);

        codigo = (EditText) findViewById(R.id.codigoText);

        toast("User Login Status: " + session.isLoggedIn() +
                "\n User id: " + session.getUserDetails().get(UserSessionManager.KEY_ID) +
                "\n Codigo: " + session.getUserDetails().get(UserSessionManager.KEY_CODIGO));

    }

    // Valida se os campos estão vazios antes de entrar
    public void onClick(View view) {

        final String codigoText = codigo.getText().toString();

        // Descomentar esta parte para chamar o Web Service
        /*
        session = new UserSessionManager(getContext());
        // Iniciar asyncTask
        TaskWS taskLogin = new TaskWS(Login_Codigo.this, taskLogin(), "Login");

        // Criar parâmetros de envio
        Map<String, String> paramsWebService = new HashMap<String, String>();
        paramsWebService.put("idTB_ACESSO_GUINCHEIRO", codigo.getText().toString());
        paramsWebService.put("idTB_VEICULO_GUINCHO", placa);
        // Enviar ao web service
        taskLogin.execute(paramsWebService);
        */
        // {
        //final String senhaGuincheiro = senha.getText().toString();


            // Valida campos obrigatórios no login
            if (codigoText.length() == 0)

            {
                codigo.requestFocus();
                codigo.setError("Digite um código válido.");
            }

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
        //}
        // Fim da chamda

    }

    private TaskInterface<TaskResponse> taskLogin() {
        return new TaskInterface<TaskResponse>() {
            @Override
            public void doAfter(TaskResponse response) {

                if (response.getSuccess() == 1) {
                    try {
                        // resgatar objeto Cliente
                        JSONObject jsonObject = response.getRecordSet().getJSONObject(0);

                        int id = jsonObject.getInt("id");

                        //String email = "tsg@asd";//response.getRecordSet().getString("email");


                        // Nova sessão de usuário!

                        session.createLoginSession(id, codigo,placa);

                        // Iniciar MainActivty enviando uma mensagem de sucesso
                        Intent intent = new Intent(Login_Codigo.this, Login_Placa.class);
                        intent.putExtra("message", response.getMessage());
                        startActivity(intent);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    AlertDialogManager.showAlertDialog(Login_Codigo.this, null, response.getMessage(), false);
                }
            }
        };
    }

    // Fim do login pelo ws

}



