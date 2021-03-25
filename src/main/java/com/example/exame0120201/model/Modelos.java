package com.example.exame0120201.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Modelos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Veiculos.class, mappedBy = "modelos", cascade = {CascadeType.ALL})
    private Set<Veiculos> veiculos= new HashSet<Veiculos>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "marcas_id")
    private Marcas marcas;

    public Modelos() {
        super();
    }

    public Modelos(String name, Set<Veiculos> veiculos) {
        this.name = name;
        this.veiculos = veiculos;
    }

    public Modelos(String name, Set<Veiculos> veiculos, Marcas marcas) {
        this.name = name;
        this.veiculos = veiculos;
        this.marcas = marcas;
    }

    public Set<Veiculos> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Set<Veiculos> veiculos) {
        this.veiculos = veiculos;
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

