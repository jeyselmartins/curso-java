package br.com.exemplo.jpa.repo;

import br.com.exemplo.jpa.entity.Aluno;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AlunoRepository {

    private final EntityManager em;

    public AlunoRepository(EntityManager em) {
        this.em = em;
    }

    public Aluno salvar(Aluno e) {
        em.getTransaction().begin();
        if (e.getId() == null) {
            em.persist(e);
        } else {
            e = em.merge(e);
        }
        em.getTransaction().commit();
        return e;
    }

    public Aluno buscarPorId(Long id) {
        return em.find(Aluno.class, id);
    }

    public List<Aluno> listarTodos() {
        return em.createQuery("select e from Aluno e order by e.id", Aluno.class)
                 .getResultList();
    }

    public void remover(Long id) {
        em.getTransaction().begin();
        Aluno e = em.find(Aluno.class, id);
        if (e != null) em.remove(e);
        em.getTransaction().commit();
    }
}
