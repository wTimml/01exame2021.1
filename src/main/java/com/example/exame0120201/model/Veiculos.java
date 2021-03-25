package com.example.exame0120201.model;

import javax.persistence.*;

@Entity
public class Veiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String plate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "modelos_id")
    private Modelos modelos;

    public Veiculos(String plate, Modelos modelos) {
        this.plate = plate;
        this.modelos = modelos;
    }

    public Modelos getModelos() {
        return modelos;
    }

    public void setModelos(Modelos modelos) {
        this.modelos = modelos;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
