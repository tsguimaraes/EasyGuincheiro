package com.easyguincheirotsguimaraes.easyguincheiro;

// Created by Thiago on 30/08/2015.


import com.easyguincheirotsguimaraes.easyguincheiro.servico.ChamadoJSON;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface ServicoJSON {

    TelaInicial tel = new TelaInicial();

    //@GET("/g_1/c2_2015_10_14_20_18_36_000000.json")
     //Call<ChamadoJSON> listRepos();
    //String teste = tel.getTask();

    //@GET("{id}")


    @GET("/{owner}")
    void getGuincho(
            @Path("owner") String dynamic,
            Callback<List<ChamadoJSON>> cb);




    // OK
    // Parte final da url
    //@GET("/c2_2015_10_14_20_18_36_000000.json")

    //void getGuincho(Callback<List<ChamadoJSON>> callback);


}
