package com.easyguincheirotsguimaraes.easyguincheiro.servico;

/**
 * Created by Thiago on 14/10/2015.
 */
public class ChamadoJSON {

    int id;
    String nome;
    String sobrenome;
    String endereco;
    String numero;
    String bairro;
    String telefone;
    String email;
    String senha;
    String status;
    String forma_pagamento;
    String cartao;
    String tempo_chegada;
    String distancia_a_percorrer;
    int idVeiculo;
    String veiculo_modelo;
    String modelo;
    String cor;
    String placa;
    String file_chamado = "";
    int aceitou = 0;
    int idAcesso = 0; // será o id do guincheiro
    int idCliente = 0; // Virá do retrofit
    String classRequest = "";


    //"forma_pagamento":"cartao","tempo_chegada":"23 minutos","distancia_a_percorrer":"12.1 km","veiculo"


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getforma_pagamento() {
        return forma_pagamento;
    }

    public void setforma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public String gettempo_chegada() {
        return tempo_chegada;
    }

    public void settempo_chegada(String tempo_chegada) {
        this.tempo_chegada = tempo_chegada;
    }

    public String getdistancia_a_percorrer() {
        return distancia_a_percorrer;
    }

    public void setdistancia_a_percorrer(String distancia_a_percorrer) {
        this.distancia_a_percorrer = distancia_a_percorrer;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getveiculo_modelo() {
        return veiculo_modelo;
    }

    public void setveiculo_modelo(String veiculo_modelo) {
        this.veiculo_modelo = veiculo_modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFile_chamado() {
        return file_chamado;
    }

    public void setFile_chamado(String file_chamado) {
        this.file_chamado = file_chamado;
    }

    public int getaceitou() {
        return aceitou;
    }

    public void setaceitou(int aceitou) {
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
        return //"ChamadoJSON" + '\n' +
                "endereco: " + endereco + '\n' +
                "bairro: " + bairro + '\n' +
                "numero: " + numero + '\n' +
                "forma_pagamento: " + forma_pagamento + '\n' +
                "tempo_chegada: " + tempo_chegada + '\n' +
                "distancia_a_percorrer: " + distancia_a_percorrer + '\n' +
                "veiculo_modelo: " + veiculo_modelo;

        /*

         chamado.setId(chamadoJSONs.get(i).getId());
                                chamado.setEndereco(chamadoJSONs.get(i).getEndereco());
                                chamado.setBairro(chamadoJSONs.get(i).getBairro());
                                chamado.setNumero(chamadoJSONs.get(i).getNumero());
                                chamado.setforma_pagamento(chamadoJSONs.get(i).getforma_pagamento());
                                chamado.settempo_chegada(chamadoJSONs.get(i).gettempo_chegada());
                                chamado.setdistancia_a_percorrer(chamadoJSONs.get(i).getdistancia_a_percorrer());
                                chamado.setveiculo_modelo(chamadoJSONs.get(i).getveiculo_modelo());
         */

    }
}