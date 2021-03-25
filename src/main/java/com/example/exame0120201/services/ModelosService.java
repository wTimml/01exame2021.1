package com.example.exame0120201.services;

import com.example.exame0120201.exceptions.BadRequestException;
import com.example.exame0120201.model.Modelos;
import com.example.exame0120201.repositories.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelosService {

    private ModeloRepository modeloRepository;

    @Autowired
    public ModelosService( ModeloRepository modeloRepository){
        this.modeloRepository = modeloRepository;
    }

    public Modelos findById(long id){
        Modelos modelos = modeloRepository.findById(id).orElseThrow(() -> new BadRequestException("Modelo não encontrado"));

        return modelos;
    }
    public Modelos findByName(String nome){
        Modelos modelos = modeloRepository.findByName(nome);

        return modelos;
    }
    public List<Modelos> findAll(){
        return modeloRepository.findAll();
    }
    public Modelos save(Modelos modelos){
        return modeloRepository.save(modelos);
    }

    public boolean checkIfMarcasExists(String marcas) {
        return modeloRepository.findByName(marcas) != null;
    }
    public Modelos update(Modelos modelos, long id){
        Modelos modelos1= findById(id);

        modelos.setId(modelos1.getId());
        return modeloRepository.save(modelos);
    }
    public void delete(long id){
        modeloRepository.deleteById(id);
    }
}
