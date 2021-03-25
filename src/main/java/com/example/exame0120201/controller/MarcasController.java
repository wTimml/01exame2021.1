package com.example.exame0120201.controller;

import com.example.exame0120201.model.Marcas;
import com.example.exame0120201.services.MarcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcasController {
    private MarcasService marcasService;

    @Autowired
    public MarcasController(MarcasService marcasService){
        this.marcasService = marcasService;
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Marcas> findByName(@PathVariable String name) {
        return ResponseEntity.ok(marcasService.findByName(name));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Marcas> findById(@PathVariable long id) {
        return ResponseEntity.ok(marcasService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception{
        List<Marcas> list = marcasService.findAll();
        if(!list.isEmpty()){
            return new ResponseEntity<>(list, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, null, HttpStatus.NO_CONTENT);
    }


    @PostMapping
    public ResponseEntity<Marcas> save(@RequestBody Marcas marcas) {
        return new ResponseEntity<>(marcasService.save(marcas), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        marcasService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marcas> replace(@RequestBody Marcas marcas,
                                           @PathVariable long id) {
        marcasService.update(marcas, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
