package org.example.dao;

import org.example.dao.exceptions.AlunoRepetidoException;
import org.example.dao.exceptions.DAOException;
import org.example.model.Aluno;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlunoDAO implements DAO{

    @Override
    public void cadastrar(Aluno aluno) {

        Aluno temp = pesquisarByCpf(aluno.getCpf());
        if(temp != null){
            throw new AlunoRepetidoException();//interrompe o fluxo
        }


        try {
            Connection con = FactoryConnection.createCon();
            Statement stm = con.createStatement();
            String sql = "INSERT INTO ESTUDANTE (CODIGO, NOME, CPF, IDADE) VALUES ('"+aluno.getCodigo()+"','"+aluno.getNome()+"',"+aluno.getCpf()+"," +aluno.getIdade()+")";
            System.out.println(sql);
            stm.execute(sql);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException();
        }


    }

    @Override
    public void atualizar(Aluno aluno) {

    }

    @Override
    public void excluir(String cpf) {

    }

    @Override
    public ArrayList<Aluno> pesquisarByNome(String nome) {
        return null;
    }

    @Override
    public ArrayList<Aluno> pesquisarTodos() {
        return null;
    }

    @Override
    public Aluno pesquisarByCpf(String cpf) {

        return null;
    }
}
