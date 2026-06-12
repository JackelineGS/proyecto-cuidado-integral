package com.argos.proyectocuidadointegral.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String species;
    private String breed;
    private LocalDate birthDate;
    private String age;
    private String color;
    private String sex;
    private String owner;
    private String status;

    @Transient
    private List<Object> triage = new ArrayList<>();
    @Transient
    private List<Object> vaccines = new ArrayList<>();
    @Transient
    private List<Object> surgeries = new ArrayList<>();
    @Transient
    private List<Object> medicalAttentions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Object> getTriage() {
        return triage;
    }

    public void setTriage(List<Object> triage) {
        this.triage = triage;
    }

    public List<Object> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Object> vaccines) {
        this.vaccines = vaccines;
    }

    public List<Object> getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(List<Object> surgeries) {
        this.surgeries = surgeries;
    }

    public List<Object> getMedicalAttentions() {
        return medicalAttentions;
    }

    public void setMedicalAttentions(List<Object> medicalAttentions) {
        this.medicalAttentions = medicalAttentions;
    }
}
