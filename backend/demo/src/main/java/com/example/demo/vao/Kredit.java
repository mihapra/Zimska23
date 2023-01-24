package com.example.demo.vao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Kredit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int velikostKredita;

    private int steviloMesecev;

    private int mesecniObrok;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "komitent_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Komitent komitent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVelikostKredita() {
        return velikostKredita;
    }

    public void setVelikostKredita(int velikostKredita) {
        this.velikostKredita = velikostKredita;
    }

    public int getSteviloMesecev() {
        return steviloMesecev;
    }

    public void setSteviloMesecev(int steviloMesecev) {
        this.steviloMesecev = steviloMesecev;
    }

    public int getMesecniObrok() {
        return mesecniObrok;
    }

    public void setMesecniObrok(int mesecniObrok) {
        this.mesecniObrok = mesecniObrok;
    }

    public Komitent getKomitent() {
        return komitent;
    }

    public void setKomitent(Komitent komitent) {
        this.komitent = komitent;
    }
}
