package com.easyguincheirotsguimaraes.easyguincheiro;

/**
 * Created by Thiago on 30/08/2015.
 */
public class GuinchoNegocio {

    private int idGuincho;//Guincho;               // ID do veículo do guincho
    private String modeloGuincho;                  // Modelo do veículo do guincho
    private String marcaGuincho;                   // Marca do veículo do guincho
    private String anttGuincho;                    // Código da Agência Nacional de Transportes Terrestres
    private String placaGuincho;                   // Placa do veículo do guincho
    private String corGuincho;                     // Cor do veículo do guincho
    private String statusGuincho;                  // Status do Guincho 1- Disponível 2- Ocupado
    //criar método para atualizar a localização em tempo real, e gerar um arquivo post que não retorna para o webservice.
    private double latitudeCliente;                // Latitude do Guincho,
    private double longitudeCliente;               // Longitude do Guincho, criar método para atualizar a localização em tempo real
    private String bairro;                         // Bairro cliente
    private String endereco;                       // Endereço do cliente
    private String distancia;                      // Distancia do guincho para o cliente
    private String formaDePagamento;

    public int getId() {
        return idGuincho;
    }

    public void setId(int idGuincho) {
        this.idGuincho = idGuincho;
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

    public double getLatitudeCliente() {
        return latitudeCliente;
    }

    public void setLatitudeCliente(double latitudeCliente) {
        this.latitudeCliente = latitudeCliente;
    }

    public double getLongitudeCliente() {
        return longitudeCliente;
    }

    public void setLongitudeCliente(double longitudeCliente) {
        this.longitudeCliente = longitudeCliente;
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
                "idGuincho=" + idGuincho +
                ", modeloGuincho='" + modeloGuincho + '\'' +
                ", marcaGuincho='" + marcaGuincho + '\'' +
                ", anttGuincho='" + anttGuincho + '\'' +
                ", placaGuincho='" + placaGuincho + '\'' +
                ", corGuincho='" + corGuincho + '\'' +
                ", statusGuincho='" + statusGuincho + '\'' +
                '}';
                */
        // Retorna para o display.
        //if (id == 5 ) //&& equals(id))
        //{
            return ""+idGuincho;
        //}
       //else {
        //    return modeloGuincho;
        //}
        }

    }

