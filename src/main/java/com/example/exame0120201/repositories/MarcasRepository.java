package com.example.exame0120201.repositories;

import com.example.exame0120201.model.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcasRepository extends JpaRepository<Marcas,Long>{
    Marcas findByName(String name);
}
