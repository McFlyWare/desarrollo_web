package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.CrearDoctor;

import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.*;

public class CrearDoctor {

    private DoctorRepositorio repositorio;

    public CrearDoctor(DoctorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void execute(String id,Integer cedula, String estudios, Integer horarioInicial, Integer horarioFinal, String nombre){

        Doctor doctor = Doctor.Create( new DocId(id), new DocNombre(nombre), new DocCedula(cedula), new DocHorarioInicial(horarioInicial), new DocHorarioFinal(horarioFinal), new DocEstudios(estudios));
        repositorio.guardar(doctor);
    }
}