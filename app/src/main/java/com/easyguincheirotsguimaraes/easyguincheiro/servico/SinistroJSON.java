package com.easyguincheirotsguimaraes.easyguincheiro.servico;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Thiago on 18/10/2015.
 */
public interface SinistroJSON {

    @FormUrlEncoded
    @POST("/index.ph")
    void respostaGuincheiro(
            @Field("file_chamado") String file_chamado
            ,@Field("aceitou") int aceitou
            ,@Field("idAcesso") int idAcesso
            ,@Field("idCliente") int idCliente
            ,@Field("classRequest") String classRequest
            ,Callback<ChamadoJSON> cb);

    //void respostaGuincheiro(@Body ChamadoJSON resposta, Callback<ChamadoJSON> cb);
    /*
     @FormUrlEncoded
  @POST("/login")
  public void login(@Field("email") String email, @Field("password") String password,
    Callback < User > callback)


    */

    /* Ok */
    /*
    @FormUrlEncoded
    @POST("/index.php")
    void respostaGuincheiro(@Field("file_chamado")String file_chamado
                            ,@Field("aceitou")int aceito
                            ,@Field("idAcesso")int idAcesso
                            ,@Field("idCliente")int idCliente
                            ,@Field("classRequest")String classRequest
                            ,Callback<ChamadoJSON> cb);
    */
}
