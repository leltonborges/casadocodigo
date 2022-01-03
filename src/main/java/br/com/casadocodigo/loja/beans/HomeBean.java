package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class HomeBean implements Serializable {
    private static final long serialVersionUID = 4615706666886450516L;

    @Inject
    private LivroDao livroDao;

    public List<Livro> getUltimosLancamentos() {
        return this.livroDao.ultimosLancamentos();
    }

    public List<Livro> getDemaisLivros(){
        return this.livroDao.demaisLivros();
    }
}
