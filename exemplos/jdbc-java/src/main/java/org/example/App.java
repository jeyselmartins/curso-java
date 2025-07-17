package org.example;

import org.example.dao.AlunoDAO;
import org.example.dao.exceptions.AlunoRepetidoException;
import org.example.dao.exceptions.DAOException;
import org.example.model.Aluno;

public class App {

        public static void main(String[] args) {
            AlunoDAO dao = new AlunoDAO();
            try {
                dao.cadastrar(new Aluno("Jeysel Martins", "72774010187", 43));
            }catch (DAOException e){
                e.printStackTrace();
                System.out.println("Atenção! Houve um problema ao cadastrar o aluno no banco de dados... contate o adminsitrador!!");
            }catch (AlunoRepetidoException alunoRepetidoException){
                alunoRepetidoException.printStackTrace();
                System.out.println("Atenção, Aluno repetido!!");
            }
        }
    }
