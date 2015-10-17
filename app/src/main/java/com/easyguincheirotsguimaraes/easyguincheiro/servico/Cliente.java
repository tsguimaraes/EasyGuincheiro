package com.easyguincheirotsguimaraes.easyguincheiro.servico;

/**
 * Created by Thiago on 14/10/2015.
 */
public class Cliente {

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
    String formaDePagamento;
    String cartao;
    Double tempoDeChegada;
    Double distanciaPercorrer;

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

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public Double getTempoDeChegada() {
        return tempoDeChegada;
    }

    public void setTempoDeChegada(Double tempoDeChegada) {
        this.tempoDeChegada = tempoDeChegada;
    }

    public Double getDistanciaPercorrer() {
        return distanciaPercorrer;
    }

    public void setDistanciaPercorrer(Double distanciaPercorrer) {
        this.distanciaPercorrer = distanciaPercorrer;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", status='" + status + '\'' +
                ", formaDePagamento='" + formaDePagamento + '\'' +
                ", cartao='" + cartao + '\'' +
                ", tempoDeChegada=" + tempoDeChegada +
                ", distanciaPercorrer=" + distanciaPercorrer +
                '}';
    }
}
