package com.example.funmathsbackend.repository;

import com.example.funmathsbackend.model.Ime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImeRepository extends JpaRepository<Ime, Long> {
    List<Ime> findBySpol(String Spol);
}