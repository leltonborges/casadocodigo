package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class LivroDetalheBean {
    @Inject
    private LivroDao livroDao;
    @Inject
    private Livro livro;
    private Integer id;

    @PostConstruct
    private void init(){
    }

    public void carragaDetalhe(){
        this.livro = this.livroDao.buscarPorId(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
