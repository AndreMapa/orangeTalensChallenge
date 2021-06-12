package com.orangeChallenge.orangeChallenge.feignbackend.modelsfeign;

public class CarYearClient {

    private String nome;
    private String codigo;

    public CarYearClient(String nome, String codigo) {
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
