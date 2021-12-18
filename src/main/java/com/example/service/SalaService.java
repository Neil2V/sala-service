package com.example.service;

import com.example.entity.Sala;
import com.example.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    SalaRepository salaRepository;

    public Sala save(Sala sala){
        return salaRepository.save(sala);
    }

    public List<Sala> getSalas(){
        return salaRepository.findAll();
    }

    public Optional<Sala> finById(int id){
        return salaRepository.findById(id);
    }

    public boolean existsSala(int id){
        return salaRepository.existsById(id);
    }

    public void delete(int id){
        salaRepository.deleteById(id);
    }


}
