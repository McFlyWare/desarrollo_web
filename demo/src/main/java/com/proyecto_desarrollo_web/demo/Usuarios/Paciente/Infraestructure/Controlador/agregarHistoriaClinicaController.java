package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Infraestructure.Controlador;

import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Application.AgregarHistoriaClinica.AgregadorHistoria;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Exceptions.idPacienteNoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/Paciente")
public class agregarHistoriaClinicaController {

    @Autowired
    private AgregadorHistoria agregador;

    @PostMapping(value = "/agregar_historia_medica")
    public ResponseEntity execute(@RequestBody Request request){
       this.agregador.execute(request.getIdPaciente(), request.getValoracion(), request.getMedicamentos());
       return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(idPacienteNoEncontrado.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handlerPacienteExiste(idPacienteNoEncontrado exception){
        HashMap<String, String> response = new HashMap<>(){{
            put("Error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    static class Request{

        private String idPaciente;
        private String valoracion;
        private String medicamentos;

        public Request(){}

        public String getIdPaciente() {
            return idPaciente;
        }

        public void setIdPaciente(String idPaciente) {
            this.idPaciente = idPaciente;
        }

        public String getValoracion() {
            return valoracion;
        }

        public void setValoracion(String valoracion) {
            this.valoracion = valoracion;
        }

        public String getMedicamentos() {
            return medicamentos;
        }

        public void setMedicamentos(String medicamentos) {
            this.medicamentos = medicamentos;
        }
    }



}
