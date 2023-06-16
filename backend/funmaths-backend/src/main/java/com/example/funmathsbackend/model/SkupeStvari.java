package com.example.funmathsbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "skupestvari")
public class SkupeStvari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imeproizvoda;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImeProizvoda() {
        return imeproizvoda;
    }

    public void setImeProizvoda(String imeProizvoda) {
        this.imeproizvoda = imeProizvoda;
    }
}