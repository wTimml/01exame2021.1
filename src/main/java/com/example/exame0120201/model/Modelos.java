package com.example.exame0120201.model;

import javax.persistence.*;

@Entity
public class Modelos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Marcas marcas;

    public Modelos() {
        super();
    }

    public Modelos(String name, Marcas marcas) {
        this.name = name;
        this.marcas = marcas;
    }

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

