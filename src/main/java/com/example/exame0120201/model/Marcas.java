package com.example.exame0120201.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Marcas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(targetEntity = Modelos.class, mappedBy = "marcas", cascade = {CascadeType.ALL})
    private Set<Modelos> modelos = new HashSet<Modelos>();

    private String name;

    public Set<Modelos> getModelos() {
        return modelos;
    }

    public void setModelos(Set<Modelos> modelos) {
        this.modelos = modelos;
    }

    public Marcas() {
        super();
    }

    public Marcas(String name) {
        this.name = name;
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
