package com.example.exame0120201.services;

import com.example.exame0120201.exceptions.BadRequestException;
import com.example.exame0120201.model.Marcas;
import com.example.exame0120201.repositories.MarcasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcasService {

    private MarcasRepository marcasRepository;

    @Autowired
    public MarcasService( MarcasRepository marcasRepository){
        this.marcasRepository = marcasRepository;
    }

    public Marcas findById(long id){
        Marcas marcas = marcasRepository.findById(id).orElseThrow(() -> new BadRequestException("Marca não encontrado"));

        return marcas;
    }
    public List<Marcas> findAll(){
        return marcasRepository.findAll();
    }
    public Marcas findByName(String nome){
        Marcas marcas= marcasRepository.findByName(nome);

        return marcas;
    }
    public Marcas save(Marcas marcas){
        Marcas marcas1= marcasRepository.save(marcas);

        return marcas1;
    }
    public Marcas update(Marcas marcas, long id){
        Marcas marcas1= findById(id);

        marcas.setId(marcas1.getId());
        return marcasRepository.save(marcas);
    }
    public void delete(long id){
        marcasRepository.deleteById(id);
    }

}
