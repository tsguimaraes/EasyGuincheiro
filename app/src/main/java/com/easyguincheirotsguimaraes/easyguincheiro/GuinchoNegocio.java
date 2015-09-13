package com.easyguincheirotsguimaraes.easyguincheiro;

/**
 * Created by Thiago on 30/08/2015.
 */
public class GuinchoNegocio {

    private int idGuincheiro;//Guincho;               // ID do veículo do guincho
    private String modeloGuincho;                  // Modelo do veículo do guincho
    private String marcaGuincho;                   // Marca do veículo do guincho
    private String anttGuincho;                    // Código da Agência Nacional de Transportes Terrestres
    private String placaGuincho;                   // Placa do veículo do guincho
    private String corGuincho;                     // Cor do veículo do guincho
    private String statusGuincho;                  // Status do Guincho 1- Disponível 2- Ocupado
    //criar método para atualizar a localização em tempo real, e gerar um arquivo post que não retorna para o webservice.
    private double latitude;                // Latitude do Guincho,
    private double longitude;               // Longitude do Guincho, criar método para atualizar a localização em tempo real
    private String bairro;                         // Bairro cliente
    private String endereco;                       // Endereço do cliente
    private String distancia;                      // Distancia do guincho para o cliente
    private String formaDePagamento;

    public int getId() {
        return idGuincheiro;
    }

    public void setId(int idGuincheiro) {
        this.idGuincheiro = idGuincheiro;
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

    public String getStatusGuincho() {
        return statusGuincho;
    }

    public void setStatusGuincho(String statusGuincho) {
        this.statusGuincho = statusGuincho;
    }

    public double getlatitude() {
        return latitude;
    }

    public void setlatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitudeCliente(double longitude) {
        this.longitude = longitude;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    @Override
    public String toString() {
        // Original, voltar
        /*
        return "GuinchoNegocio{" +
                "idGuincheiro=" + idGuincheiro +
                ", modeloGuincho='" + modeloGuincho + '\'' +
                ", marcaGuincho='" + marcaGuincho + '\'' +
                ", anttGuincho='" + anttGuincho + '\'' +
                ", placaGuincho='" + placaGuincho + '\'' +
                ", corGuincho='" + corGuincho + '\'' +
                ", statusGuincho='" + statusGuincho + '\'' +
                '}';
                */
            return "idGuincheiro: "+idGuincheiro+"\n"+
                    "latitude: "+latitude+"\n"+
                    "longitude: "+longitude;
        //}
       //else {
        //    return modeloGuincho;
        //}
        }

    }

