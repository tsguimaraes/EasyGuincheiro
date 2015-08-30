package com.easyguincheirotsguimaraes.easyguincheiro;

/**
 * Created by Thiago on 30/08/2015.
 */
public class GuinchoNegocio {

    private int id;//Guincho;          // ID do veículo do guincho
    private String modeloGuincho;   // Modelo do veículo do guincho
    private String marcaGuincho;    // Marca do veículo do guincho
    private String anttGuincho;     // Código da Agência Nacional de Transportes Terrestres
    private String placaGuincho;    // Placa do veículo do guincho
    private String corGuincho;      // Cor do veículo do guincho
    private String statusGuincho;   // Status do Guincho 1- Disponível 2- Ocupado

    public GuinchoNegocio(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }

    public void setIdGuincho(int id) {
        this.id = id;
    }

    public String getModeloGuincho() {
        return modeloGuincho;
    }

    public void setModeloGuincho(String modeloGuincho) {
        this.modeloGuincho = modeloGuincho;
    }

    public String getMarcaGuincho() {
        return marcaGuincho;
    }

    public void setMarcaGuincho(String marcaGuincho) {
        this.marcaGuincho = marcaGuincho;
    }

    public String getAnttGuincho() {
        return anttGuincho;
    }

    public void setAnttGuincho(String anttGuincho) {
        this.anttGuincho = anttGuincho;
    }

    public String getPlacaGuincho() {
        return placaGuincho;
    }

    public void setPlacaGuincho(String placaGuincho) {
        this.placaGuincho = placaGuincho;
    }

    public String getCorGuincho() {
        return corGuincho;
    }

    public void setCorGuincho(String corGuincho) {
        this.corGuincho = corGuincho;
    }

    @Override
    public String toString() {
        return "GuinchoNegocio{" +
                "idGuincho=" + id +
                ", modeloGuincho='" + modeloGuincho + '\'' +
                ", marcaGuincho='" + marcaGuincho + '\'' +
                ", anttGuincho='" + anttGuincho + '\'' +
                ", placaGuincho='" + placaGuincho + '\'' +
                ", corGuincho='" + corGuincho + '\'' +
                ", statusGuincho='" + statusGuincho + '\'' +
                '}';
    }
}
