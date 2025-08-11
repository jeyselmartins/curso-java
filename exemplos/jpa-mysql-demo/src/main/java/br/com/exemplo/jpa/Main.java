package br.com.exemplo.jpa;

import br.com.exemplo.jpa.config.JpaUtil;
import br.com.exemplo.jpa.entity.Aluno;
import br.com.exemplo.jpa.repo.AlunoRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        AlunoRepository repo = new AlunoRepository(em);

        Aluno novo = new Aluno("Ana Souza", "123.456.789-00", 22);
        novo = repo.salvar(novo);
        System.out.println("Cadastrado: " + novo);

        System.out.println("Lista:");
        List<Aluno> lista = repo.listarTodos();
        for (Aluno e : lista) {
            System.out.println(e);
        }
        //repo.listarTodos().forEach(System.out::println); Estudem lambda

        Aluno e = repo.buscarPorId(novo.getId());
        e.setIdade(23);
        repo.salvar(e);
        System.out.println("Atualizado: " + repo.buscarPorId(e.getId()));

        repo.remover(e.getId());
        System.out.println("Após remover:");
        repo.listarTodos().forEach(System.out::println);

        em.close();
        JpaUtil.close();
    }
}
