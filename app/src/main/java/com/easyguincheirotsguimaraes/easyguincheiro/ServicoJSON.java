package com.easyguincheirotsguimaraes.easyguincheiro;

// Created by Thiago on 30/08/2015.


import com.easyguincheirotsguimaraes.easyguincheiro.servico.ChamadoJSON;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface ServicoJSON {

    // Recebe o parametro do ws
    @GET("/{owner}")
    void getGuincho(//owner é o final da url estabelicido como parametro
            @Path("owner") String dynamic,
            Callback<List<ChamadoJSON>> cb);


}
