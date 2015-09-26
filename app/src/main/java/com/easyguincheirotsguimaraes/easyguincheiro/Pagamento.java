package com.easyguincheirotsguimaraes.easyguincheiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;

public class Pagamento extends AppCompatActivity {

    private Button ButtonsalvarPagamento;
    private Button ButtonCancelarPagamento;
    EditText valorTotalLocal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Tela de pagamento
        setContentView(R.layout.activity_pagamento);

        // Botão de salvar o pagamento
        ButtonsalvarPagamento = (Button) findViewById(R.id.salvarServico);
        // Botão cancelar o processo de pagamento
        ButtonCancelarPagamento = (Button) findViewById(R.id.cancelarPagamentoServ) ;
        // Campo com o valor do pagamento
        valorTotalLocal = (EditText) findViewById(R.id.valorServText);

        valorTotalLocal.setInputType(InputType.TYPE_CLASS_NUMBER);
        valorTotalLocal.addTextChangedListener(new TextWatcher() {

            private boolean isUpdating = false;
            // Pega a formatacao do sistema, se for brasil R$ se EUA US$

            private NumberFormat nf = NumberFormat.getCurrencyInstance();

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int after) {
                // Evita que o método seja executado varias vezes.
                // Se tirar ele entre em loop
                if (isUpdating) {
                    isUpdating = false;
                    return;
                }

                isUpdating = true;
                String str = s.toString();
                // Verifica se já existe a máscara no texto.
                boolean hasMask = ((str.indexOf("R$") > -1 || str.indexOf("$") > -1) &&
                        (str.indexOf(".") > -1 || str.indexOf(",") > -1));
                // Verificamos se existe máscara
                if (hasMask) {
                    // Retiramos a máscara.
                    str = str.replaceAll("[R$]", "").replaceAll("[,]", "")
                            .replaceAll("[.]", "");
                }

                try {
                    // Transformamos o número que está escrito no EditText em
                    // monetário.

                    str = nf.format(Double.parseDouble(str) / 100);
                    valorTotalLocal.setText(str);
                    valorTotalLocal.setSelection(valorTotalLocal.getText().length());
                } catch (NumberFormatException e) {
                    s = "";
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // Não utilizamos
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Não utilizamos
            }
        });
        // Ao clicar no botão cancelar
        ButtonCancelarPagamento = (Button) findViewById(R.id.cancelarPagamentoServ);
        ButtonCancelarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pagamento.this, Sinistro.class);
                startActivity(intent);
                v.animate();

            }
        });

    }
    public void onClick(View view) {

        // Ao clicar em salvar o pagamento
        final String valorServText = valorTotalLocal.getText().toString();
        // Cancelar o processo de pagamento

        //if (valorSer)

        // Não deixa salvar com valor de pagamento zerado
        if (valorServText.length() == 0)

        {
            valorTotalLocal.requestFocus();
            valorTotalLocal.setError("O valor informado é inválido.");
        }
        // Sucesso ao fazer o pagamento.
        else {
            // Implementar a chamada ao JSON para enviar o valor pago
            Toast.makeText(Pagamento.this, "O pagamento foi realizado.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Pagamento.this, TelaInicial.class);
            startActivity(intent);

            //   v.animate();

            //}
            //});
        }
    }
    // Fim do método

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
