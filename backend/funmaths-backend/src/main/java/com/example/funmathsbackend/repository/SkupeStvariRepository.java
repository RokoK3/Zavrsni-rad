package com.example.funmathsbackend.repository;

import com.example.funmathsbackend.model.SkupeStvari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkupeStvariRepository extends JpaRepository<SkupeStvari, Long> {
}