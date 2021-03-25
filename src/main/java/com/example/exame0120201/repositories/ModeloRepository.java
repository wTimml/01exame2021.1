package com.example.exame0120201.repositories;

import com.example.exame0120201.model.Modelos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelos,Long> {
    Modelos findByName(String name);
}
