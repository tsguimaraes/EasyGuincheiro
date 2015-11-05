package com.easyguincheirotsguimaraes.easyguincheiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class Avaliacao extends ActionBarActivity {

    private RatingBar ratingBar;
    private TextView txtValorAvaliacao;
    private Button btnSubmit;
    private Button avaliacaoButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        addListenerOnRatingBar();
        addListenerOnButton();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .3));

    }

    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.dialog_ratingbar);
        txtValorAvaliacao = (TextView) findViewById(R.id.rank_dialog_text1);
        // se o valor de avaliação mudar,
        // exiba o valor de avaliação atual no resultado (textview) automaticamente

        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float avaliacao, boolean fromUser) {

                if (avaliacao == 1.0) {
                    txtValorAvaliacao.setText(String.valueOf("Muito ruim!"));
                }
                if (avaliacao == 2.0) {
                    txtValorAvaliacao.setText(String.valueOf("Regular!"));
                }
                if (avaliacao == 3.0) {
                    txtValorAvaliacao.setText(String.valueOf("Bom!"));
                }
                if (avaliacao == 4.0) {
                    txtValorAvaliacao.setText(String.valueOf("Muito bom!"));
                }
                if (avaliacao == 5.0) {
                    txtValorAvaliacao.setText(String.valueOf("Excelente!"));
                }
            }
        });
    }

    public void addListenerOnButton() {
        //ratingBar = (RatingBar) findViewById(R.id.dialog_ratingbar);
        btnSubmit = (Button) findViewById(R.id.rank_dialog_button); //se o botão for clicado, exiba o valor de avaliação corrente.
        btnSubmit.setOnClickListener(new OnClickListener() {


            @Override public void onClick(View v) {
                //Valor da variável
                /*
                Toast.makeText(Avaliacao.this,String.valueOf(ratingBar.getRating()),
                        Toast.LENGTH_SHORT).show();
                        */
                Intent intent = new Intent(Avaliacao.this, TelaInicial.class);
                startActivity(intent); } });

    }

}