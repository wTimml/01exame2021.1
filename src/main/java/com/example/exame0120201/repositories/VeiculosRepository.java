package com.example.exame0120201.repositories;

import com.example.exame0120201.model.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;



public interface VeiculosRepository extends JpaRepository<Veiculos,Long> {
    Veiculos findByPlate(String plate);
}
