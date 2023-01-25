package com.example.demo.vao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Collection;

@Entity
public class Komitent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 20)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;

    @OneToMany(mappedBy = "komitent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Kredit> krediti;

    public Komitent(String firstName, String lastName, Collection<Kredit> krediti) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.krediti = krediti;
    }

    public Komitent() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Kredit> getKrediti() {
        return krediti;
    }

    public void setKrediti(Collection<Kredit> krediti) {
        this.krediti = krediti;
    }
}
