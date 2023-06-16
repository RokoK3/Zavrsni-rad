package com.example.funmathsbackend.controller;

import com.example.funmathsbackend.model.Ime;
import com.example.funmathsbackend.repository.ImeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImeController {

    private final ImeRepository imeRepository;

    public ImeController(ImeRepository imeRepository) {
        this.imeRepository = imeRepository;
    }

    @GetMapping("/api/imeni")
    public List<Ime> getAllImeni() {
        return imeRepository.findAll();
    }
}