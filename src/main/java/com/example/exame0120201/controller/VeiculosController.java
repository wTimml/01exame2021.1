package com.example.exame0120201.controller;

import com.example.exame0120201.model.Veiculos;
import com.example.exame0120201.services.VeiculosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {
    private VeiculosServices veiculosServices;

    @Autowired
    public VeiculosController(VeiculosServices veiculosServices){
        this.veiculosServices = veiculosServices;
    }

    @GetMapping(path = "/{plate}")
    public ResponseEntity<Veiculos> findByPlate(@PathVariable String plate) {
        return ResponseEntity.ok(veiculosServices.findByPlate(plate));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception{
        List<Veiculos> list = veiculosServices.findAll();
        if(!list.isEmpty()){
            return new ResponseEntity<>(list, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, null, HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Veiculos> findById(@PathVariable long id) {
        return ResponseEntity.ok(veiculosServices.findById(id));
    }

    @PostMapping
    public ResponseEntity<Veiculos> save(@RequestBody Veiculos veiculos) {
        return new ResponseEntity<>(veiculosServices.save(veiculos), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        veiculosServices.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculos> replace(@RequestBody Veiculos veiculos,
                                            @PathVariable long id) {
        veiculosServices.update(veiculos, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
