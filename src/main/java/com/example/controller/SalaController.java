package com.example.controller;


import com.example.entity.Sala;
import com.example.service.SalaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salas")
@CrossOrigin("*")
public class SalaController {

    @Autowired
    SalaService salaService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Sala sala){
        return new ResponseEntity(salaService.save(sala), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Sala>> list(){
        List<Sala> salas = salaService.getSalas();
        return new ResponseEntity(salas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> getSala(@PathVariable("id") int id){
        Optional<Sala> osala = salaService.finById(id);

        if(!osala.isPresent())
            return new ResponseEntity("La sala no existe", HttpStatus.NOT_FOUND);

        return new ResponseEntity(osala.get(),HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!salaService.existsSala(id))
            return new ResponseEntity("La sala no existe", HttpStatus.NOT_FOUND);

        salaService.delete(id);
        return new ResponseEntity("Sala eliminada ",HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody Sala sala){
        if(!salaService.existsSala(id))
            return new ResponseEntity("Esta sala no existe", HttpStatus.NOT_FOUND);
        if(sala.getNumerosala()==0)
            return new ResponseEntity("El numero de sala es requerido", HttpStatus.BAD_REQUEST);

        Sala salaa = salaService.finById(id).get();
        salaa.setNumerosala(sala.getNumerosala());
        salaa.setNumerobutacas(sala.getNumerobutacas());
        salaa.setTipo(sala.getTipo());

        return new ResponseEntity(salaService.save(salaa), HttpStatus.OK);
    }
}
