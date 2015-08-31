package com.easyguincheirotsguimaraes.easyguincheiro;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Thiago on 30/08/2015.
 */
public interface ServicoJSON {
    // Parte final da url
    @GET("/clientes/")
    void getGuincho(Callback<List<GuinchoNegocio>> callback);
}
