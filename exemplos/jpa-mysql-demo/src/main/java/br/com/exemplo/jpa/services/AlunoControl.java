package br.com.exemplo.jpa.services;


import jakarta.persistence.PostLoad;

@WebService
@Path("/cadastro/aluno")
public class AlunoControl {
    @Post
    public void cadastrar(Aluno aluno){

    }
}
