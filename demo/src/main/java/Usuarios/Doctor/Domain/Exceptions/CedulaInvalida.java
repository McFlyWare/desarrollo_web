package Usuarios.Doctor.Domain.Exceptions;

public class CedulaInvalida extends RuntimeException {
    public CedulaInvalida(String s) {
        super(s);
    }
}
