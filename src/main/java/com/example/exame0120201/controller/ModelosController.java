package com.example.exame0120201.controller;


import com.example.exame0120201.model.Modelos;
import com.example.exame0120201.services.ModelosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModelosController {
    private ModelosService modelosService;

    @Autowired
    public ModelosController(ModelosService modelosService){
        this.modelosService = modelosService;
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Modelos> findByName(@PathVariable String name) {
        return ResponseEntity.ok(modelosService.findByName(name));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Modelos> findById(@PathVariable long id) {
        return ResponseEntity.ok(modelosService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception{
        List<Modelos> list = modelosService.findAll();
        if(!list.isEmpty()){
            return new ResponseEntity<>(list, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, null, HttpStatus.NO_CONTENT);
    }


    @PostMapping
    public ResponseEntity<Modelos> save(@RequestBody Modelos modelos) {
        return new ResponseEntity<>(modelosService.save(modelos), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        modelosService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelos> replace(@RequestBody Modelos modelos,
                                            @PathVariable long id) {
        modelosService.update(modelos, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
