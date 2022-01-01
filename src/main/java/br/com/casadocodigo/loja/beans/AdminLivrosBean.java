package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.models.Livro;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AdminLivrosBean {
    @Inject
    private Livro livro;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public void salvar(){
        System.out.println("Livro salvo com Sucesso!");
        System.out.println(livro);
    }
}
