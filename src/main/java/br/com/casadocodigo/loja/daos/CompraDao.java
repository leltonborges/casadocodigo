package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Compra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public class CompraDao implements Serializable {
    private static final long serialVersionUID = 763851197483772003L;

    @PersistenceContext
    private EntityManager manager;

    public void salvar(Compra compra){
        manager.persist(compra);
    }
}
