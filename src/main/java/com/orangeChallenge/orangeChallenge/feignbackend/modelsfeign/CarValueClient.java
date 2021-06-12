package com.orangeChallenge.orangeChallenge.feignbackend.modelsfeign;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CarValueClient {

    @JsonProperty("Valor")
    private String valor;

    @JsonCreator
    public CarValueClient(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
