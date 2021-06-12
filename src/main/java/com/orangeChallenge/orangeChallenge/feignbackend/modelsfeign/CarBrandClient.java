package com.orangeChallenge.orangeChallenge.feignbackend.modelsfeign;

public class CarBrandClient {

    private String nome;
    private String codigo;


    public CarBrandClient(String nome, String codigo) {
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
