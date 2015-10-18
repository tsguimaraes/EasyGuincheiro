package com.easyguincheirotsguimaraes.easyguincheiro;

/**
 * Created by Thiago on 18/10/2015.
 */


public class RetornoJSON {

    String file_chamado = "teste";
    int aceitou = 1;
    int idAcesso = 8; // será o id do guincheiro
    int idCliente = 1; // Virá do retrofit
    String classRequest = "teste2";

    public String getFile_chamado() {
        return file_chamado;
    }

    public void setFile_chamado(String file_chamado) {
        this.file_chamado = file_chamado;
    }

    public int getAceitou() {
        return aceitou;
    }

    public void setAceitou(int aceitou) {
        this.aceitou = aceitou;
    }

    public int getIdAcesso() {
        return idAcesso;
    }

    public void setIdAcesso(int idAcesso) {
        this.idAcesso = idAcesso;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getClassRequest() {
        return classRequest;
    }

    public void setClassRequest(String classRequest) {
        this.classRequest = classRequest;
    }

    @Override
    public String toString() {
        return "RetornoJSON{" +
                "file_chamado='" + file_chamado + '\'' +
                ", aceitou=" + aceitou +
                ", idAcesso=" + idAcesso +
                ", idCliente=" + idCliente +
                ", classRequest='" + classRequest + '\'' +
                '}';
    }
}
