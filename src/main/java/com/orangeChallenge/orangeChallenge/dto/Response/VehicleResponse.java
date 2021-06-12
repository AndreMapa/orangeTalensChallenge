package com.orangeChallenge.orangeChallenge.dto.Response;

import com.orangeChallenge.orangeChallenge.models.Vehicle;

import java.time.DayOfWeek;

public class VehicleResponse {

    private final String marca;
    private final String modelo;
    private final String ano;
    private final String valor;
    private final DayOfWeek rotation;
    private final Boolean aRotation;

    public VehicleResponse(Vehicle vehicle, String value){
        this.marca = vehicle.getMarca();
        this.modelo = vehicle.getModelo();
        this.ano = vehicle.getAno();
        this.valor = value;
        this.rotation = vehicle.getRotation();
        this.aRotation = vehicle.getARotation();
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

    public String getValor() {
        return valor;
    }

    public DayOfWeek getRotation() {
        return rotation;
    }

    public Boolean getARotation() {
        return aRotation;
    }
}
