package com.example.funmathsbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "cvijece")
public class Cvijece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Naziv;

    // Getters and setters

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String Naziv) {
        this.Naziv = Naziv;
    }
}