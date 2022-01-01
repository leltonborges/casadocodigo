package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class LivroDao {

    @PersistenceContext
    private EntityManager manager;

    public void salvar(Livro livro){
        manager.persist(livro);
    }
}
