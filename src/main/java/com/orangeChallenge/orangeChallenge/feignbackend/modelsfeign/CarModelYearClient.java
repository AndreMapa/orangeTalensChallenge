package com.orangeChallenge.orangeChallenge.feignbackend.modelsfeign;

import java.util.List;

public class CarModelYearClient {

    private List<CarModelClient> modelos;
    private List<CarYearClient> anos;

    public CarModelYearClient(List<CarModelClient> modelos, List<CarYearClient> anos) {
        this.modelos = modelos;
        this.anos = anos;
    }

    public List<CarModelClient> getModelos() {
        return modelos;
    }

    public List<CarYearClient> getAnos() {
        return anos;
    }
}
