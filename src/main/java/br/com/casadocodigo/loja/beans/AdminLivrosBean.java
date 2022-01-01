package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
@RequestScoped
public class AdminLivrosBean {
    @Inject
    private Livro livro;

    @Inject
    private LivroDao livroDao;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Transactional
    public void salvar(){
        System.out.println("Livro salvo com Sucesso!");
        System.out.println(livro);
        livroDao.salvar(livro);
    }
}
