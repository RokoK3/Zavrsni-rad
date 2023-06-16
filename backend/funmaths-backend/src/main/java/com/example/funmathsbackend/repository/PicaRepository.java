package com.example.funmathsbackend.repository;

import com.example.funmathsbackend.model.Pica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicaRepository extends JpaRepository<Pica, Long> {
}