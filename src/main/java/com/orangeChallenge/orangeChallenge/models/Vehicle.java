package com.orangeChallenge.orangeChallenge.models;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Entity
@Table(name = "tb_vehicle")
public class Vehicle {

    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String ano;
    @Column
    private DayOfWeek rotation;
    @Column
    private Boolean aRotation;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    private User user;

    //For the hibernate
    public Vehicle() {
    }

    public Vehicle(String marca, String modelo, String ano, User user) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.user = user;
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

    public DayOfWeek getRotation() {
        switch (this.ano.substring(3)) {
            case "0":
            case "1":
                return rotation = DayOfWeek.MONDAY;
            case "2":
            case "3":
                return rotation = DayOfWeek.TUESDAY;
            case "4":
            case "5":
                return rotation = DayOfWeek.WEDNESDAY;
            case "6":
            case "7":
                return rotation = DayOfWeek.THURSDAY;
        }
        return rotation = DayOfWeek.FRIDAY;
    }

    public Boolean getARotation() {
        if (LocalDate.now().getDayOfWeek() != this.rotation){
            return aRotation = false;
        }
        return aRotation = true;
    }
}
