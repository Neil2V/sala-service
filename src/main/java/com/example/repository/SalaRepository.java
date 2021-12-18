package com.example.repository;

import com.example.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {
}
