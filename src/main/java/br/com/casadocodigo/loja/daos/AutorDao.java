package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AutorDao {

    @PersistenceContext
    private EntityManager manager;

    public void salvar(Autor autor){
        manager.persist(autor);
    }

    public List<Autor> getAllAutores(){
        return manager
                .createQuery("select a from Autor a", Autor.class)
                .getResultList();
    }
}
