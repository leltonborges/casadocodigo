package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

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

    public List<Autor> getAutores(){
        return Arrays.asList(
                new Autor(1, "Lia"),
                new Autor(2, "Bia"),
                new Autor(3, "Alex"),
                new Autor(4, "Bob")
        );
    }

    @Transactional
    public void salvar(){
        livroDao.salvar(livro);
    }
}
