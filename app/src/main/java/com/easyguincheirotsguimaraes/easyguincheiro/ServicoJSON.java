package com.easyguincheirotsguimaraes.easyguincheiro;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;


 // Created by Thiago on 30/08/2015.


public interface ServicoJSON {

    // Parte final da url
    //@GET("/clientes/")
    @GET("/guincheiros.json")
    void getGuincho(Callback<List<GuinchoNegocio>> callback);
}


/*
package com.easyguincheirotsguimaraes.easyguincheiro;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;


 // Created by Thiago on 30/08/2015.

public interface ServicoJSON {

    // Parte final da url
    // @GET("/guincheiros.json")
    // void getGuincho(Callback<List<GuinchoNegocio>> callback);

    @GET("/group/{id}/users")
    List<Guincheiro> groupList(@Path("id") int groupId, @Query("sort") String sort);

}

*/