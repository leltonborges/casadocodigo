package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public class UsuarioDao implements Serializable {
    private static final long serialVersionUID = -6878748834240314330L;

    @PersistenceContext
    private EntityManager manager;

    public void salvar(Usuario usuario){
        manager.persist(usuario);
    }

}
