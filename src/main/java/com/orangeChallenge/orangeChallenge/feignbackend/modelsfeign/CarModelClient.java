package com.orangeChallenge.orangeChallenge.feignbackend.modelsfeign;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarModelClient {

    @JsonProperty
    private String nome;
    @JsonProperty
    private String codigo;

    public CarModelClient(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

}
