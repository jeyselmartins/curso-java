package org.example.dao.exceptions;

public class AlunoRepetidoException extends RuntimeException{
    @Override
    public String getMessage() {
        return super.getMessage() + "-- Problemas ";
    }
}
