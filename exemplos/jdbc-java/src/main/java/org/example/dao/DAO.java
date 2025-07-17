package org.example.dao;

import org.example.model.Aluno;

import java.util.ArrayList;

public interface DAO {
    public void cadastrar(Aluno aluno);
    public void atualizar(Aluno aluno);
    public void excluir(String cpf);
    public ArrayList<Aluno> pesquisarByNome(String nome);
    public ArrayList<Aluno> pesquisarTodos();
    public Aluno pesquisarByCpf(String cpf);
}
