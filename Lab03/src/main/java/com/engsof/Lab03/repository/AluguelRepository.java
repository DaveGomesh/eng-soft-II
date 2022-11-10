package com.engsof.Lab03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engsof.Lab03.model.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Integer> {
    
}
