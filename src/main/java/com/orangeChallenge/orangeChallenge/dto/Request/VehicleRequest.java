package com.orangeChallenge.orangeChallenge.dto.Request;

import com.orangeChallenge.orangeChallenge.models.User;
import com.orangeChallenge.orangeChallenge.models.Vehicle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class VehicleRequest {

    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotBlank
    private String ano;
    @NotNull
    private Long idUser;

    public VehicleRequest(String marca, String modelo, String ano, String valor, Long idUser) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.idUser = idUser;
    }

    public Vehicle toModel(User user){
        return new Vehicle(this.marca, this.modelo, this.ano, user);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAno() {
        return ano;
    }

    public Long getIdUser() {
        return idUser;
    }
}
