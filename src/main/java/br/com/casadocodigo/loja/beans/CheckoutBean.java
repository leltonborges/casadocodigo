package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.daos.UsuarioDao;
import br.com.casadocodigo.loja.models.Usuario;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class CheckoutBean {
    @Inject
    private Usuario user;
    @Inject
    private UsuarioDao usuarioDao;

    @Transactional
    public void finalizar(){
        if(user.equals(null)){
            throw new RuntimeException("usuário nulo");
        }
        usuarioDao.salvar(user);
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}

