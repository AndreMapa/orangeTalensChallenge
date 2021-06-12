package com.orangeChallenge.orangeChallenge.dto.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.orangeChallenge.orangeChallenge.models.User;
import com.orangeChallenge.orangeChallenge.models.Vehicle;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private final String name;
    private final String email;
    private final String cpf;
    private final Date birthDate;
    private final List<Vehicle> vehicleResponseList;

    public UserResponse (User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.birthDate = user.getBirthDate();
        this.vehicleResponseList = user.getVehicles();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<Vehicle> getVehicleResponseList() {
        return vehicleResponseList;
    }
}
