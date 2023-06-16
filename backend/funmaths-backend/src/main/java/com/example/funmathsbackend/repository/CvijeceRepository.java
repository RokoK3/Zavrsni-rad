package com.example.funmathsbackend.repository;

import com.example.funmathsbackend.model.Cvijece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvijeceRepository extends JpaRepository<Cvijece, Long> {
}