package com.example.exame0120201.services;

import com.example.exame0120201.exceptions.BadRequestException;
import com.example.exame0120201.model.Veiculos;
import com.example.exame0120201.repositories.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculosServices  {

    private VeiculosRepository veiculosRepository;

    @Autowired
    public VeiculosServices(VeiculosRepository veiculosRepository){
        this.veiculosRepository = veiculosRepository;
    }

    public Veiculos findById(long id){
        Veiculos veiculos = veiculosRepository.findById(id).orElseThrow(() -> new BadRequestException("Veiculo não encontrado"));

        return veiculos;
    }

    public List<Veiculos> findAll(){
        return veiculosRepository.findAll();
    }
    public Veiculos findByPlate(String nome){
        Veiculos veiculos = veiculosRepository.findByPlate(nome);

        return veiculos;
    }
    public Veiculos save(Veiculos veiculos){
        Veiculos veiculos1 = veiculosRepository.save(veiculos);

        return veiculos1;
    }
    public Veiculos update(Veiculos veiculos, long id){
        Veiculos veiculos1 = findById(id);

        veiculos.setId(veiculos1.getId());
        return veiculosRepository.save(veiculos);
    }
    public void delete(long id){
        veiculosRepository.deleteById(id);
    }
}
