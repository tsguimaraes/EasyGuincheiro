package com.easyguincheirotsguimaraes.easyguincheiro;

/**
 * Created by Thiago on 04/09/2015.
 */
public class Guincheiro {
    private int idGuincheiro;
    private String nomeGuincheiro;
    private String codigoGuincheiro;
    private String placaGuincho;

    public int getIdGuincheiro() {
        return idGuincheiro;
    }

    public void setIdGuincheiro(int idGuincheiro) {
        this.idGuincheiro = idGuincheiro;
    }

    public String getNomeGuincheiro() {
        return nomeGuincheiro;
    }

    public void setNomeGuincheiro(String nomeGuincheiro) {
        this.nomeGuincheiro = nomeGuincheiro;
    }

    public String getCodigoGuincheiro() {
        return codigoGuincheiro;
    }

    public void setCodigoGuincheiro(String codigoGuincheiro) {
        this.codigoGuincheiro = codigoGuincheiro;
    }

    public String getplacaGuincho() {
        return placaGuincho;
    }

    public void setplacaGuincho(String placaGuincho) {
        this.placaGuincho = placaGuincho;
    }

    @Override
    public String toString() {
        return "Guincheiro{" +
                "idGuincheiro=" + idGuincheiro +
                ", nomeGuincheiro='" + nomeGuincheiro + '\'' +
                ", codigoGuincheiro='" + codigoGuincheiro + '\'' +
                ", placaGuincho='" + placaGuincho + '\'' +
                '}';
    }
}

