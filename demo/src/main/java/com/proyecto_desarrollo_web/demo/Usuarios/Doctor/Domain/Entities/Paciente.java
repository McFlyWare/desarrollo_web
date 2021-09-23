package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Entities;

import java.util.Objects;

public class Paciente {
    private String nombre;
    private String animal;
    private String raza;
    private Integer edad;
    private String valoracion;
    private Integer ccDuenio;

    public Paciente(String nombre, String animal, String raza, Integer edad, String valoracion, Integer ccDuenio) {
        this.nombre = nombre;
        this.animal = animal;
        this.raza = raza;
        this.edad = edad;
        this.valoracion = valoracion;
        this.ccDuenio = ccDuenio;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return ccDuenio == paciente.ccDuenio && Objects.equals(nombre, paciente.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, ccDuenio);
    }
}