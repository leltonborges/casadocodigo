package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LivroDao {

    @PersistenceContext
    private EntityManager manager;

    public void salvar(Livro livro){
        manager.persist(livro);
    }

    public List<Livro> lista() {
        String jpql = "select distinct(l) from Livro l join fetch l.autores order by l.id";
        return manager.createQuery(jpql, Livro.class)
                .getResultList();
    }

    public List<Livro> ultimosLancamentos(){
        String jpql = "select l from Livro l";
        return manager.createQuery(jpql, Livro.class)
                .setMaxResults(5)
                .getResultList();
    }

    public List<Livro> demaisLivros(){
        String jpql = "select l from Livro l order by l.id desc ";
        return manager.createQuery(jpql, Livro.class)
                .setFirstResult(5)
                .getResultList();
    }

    public Livro buscarPorId(Integer id){
        String jpql = "select l from Livro l join fetch l.autores au " +
                "where l.id = :id";
        return manager.createQuery(jpql, Livro.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
