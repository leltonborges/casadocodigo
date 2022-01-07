package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.daos.UsuarioDao;
import br.com.casadocodigo.loja.models.Usuario;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;

@Model
public class CheckoutBean implements Serializable {
    private static final long serialVersionUID = -6100236659196909211L;
    @Inject
    private Usuario user;
    @Inject
    private CarrinhoCompras carrinho;

    @Transactional
    public void finalizar(){
        carrinho.finalizar(user);
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}

