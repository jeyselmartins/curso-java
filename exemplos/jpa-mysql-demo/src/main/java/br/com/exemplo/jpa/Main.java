package br.com.exemplo.jpa;

import br.com.exemplo.jpa.config.JpaUtil;
import br.com.exemplo.jpa.entity.Aluno;
import br.com.exemplo.jpa.repo.AlunoDAO;
import jakarta.persistence.EntityManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        AlunoDAO alunoDao = new AlunoDAO(em);

        Aluno novo = new Aluno("Ana Souza", "125.456.789-23", 22);
        novo = alunoDao.salvar(novo);
        System.out.println("Cadastrado: " + novo);

        System.out.println("Lista:");
        List<Aluno> lista = alunoDao.listarTodos();
        for (Aluno e : lista) {
            System.out.println(e);
        }
        //alunoDao.listarTodos().forEach(System.out::println);// Estudem lambda

        Aluno e = alunoDao.buscarPorId(novo.getId());
        e.setIdade(23);
        alunoDao.salvar(e);
        System.out.println("Atualizado: " + alunoDao.buscarPorId(e.getId()));

        alunoDao.remover(Long.parseLong("6"));
        System.out.println("Após remover:");
        alunoDao.listarTodos().forEach(System.out::println);

        em.close();
        JpaUtil.close();
    }
}
