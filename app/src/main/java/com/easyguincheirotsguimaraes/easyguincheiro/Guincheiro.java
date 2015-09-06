package com.easyguincheirotsguimaraes.easyguincheiro;

/**
 * Created by Thiago on 04/09/2015.
 */
public class Guincheiro {
    private int idGuincheiro;
    private int nomeGuincheiro;
    private int codigoGuincheiro;
    private int senhaGuincheiro;

    public int getIdGuincheiro() {
        return idGuincheiro;
    }

    public void setIdGuincheiro(int idGuincheiro) {
        this.idGuincheiro = idGuincheiro;
    }

    public int getNomeGuincheiro() {
        return nomeGuincheiro;
    }

    public void setNomeGuincheiro(int nomeGuincheiro) {
        this.nomeGuincheiro = nomeGuincheiro;
    }

    public int getCodigoGuincheiro() {
        return codigoGuincheiro;
    }

    public void setCodigoGuincheiro(int codigoGuincheiro) {
        this.codigoGuincheiro = codigoGuincheiro;
    }

    public int getSenhaGuincheiro() {
        return senhaGuincheiro;
    }

    public void setSenhaGuincheiro(int senhaGuincheiro) {
        this.senhaGuincheiro = senhaGuincheiro;
    }

    @Override
    public String toString() {
        return "Guincheiro{" +
                "idGuincheiro=" + idGuincheiro +
                ", nomeGuincheiro=" + nomeGuincheiro +
                ", codigoGuincheiro=" + codigoGuincheiro +
                ", senhaGuincheiro=" + senhaGuincheiro +
                '}';
    }
}

