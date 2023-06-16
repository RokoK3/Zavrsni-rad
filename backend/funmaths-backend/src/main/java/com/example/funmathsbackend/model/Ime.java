package com.example.funmathsbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "Imena")
public class Ime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Ime;
    private String spol;


    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String Ime) {
        this.Ime = Ime;
    }
    public String getSpol() {
        return spol;
    }

    public void setSpol(String Spol) {
        this.spol = Spol;
    }
}