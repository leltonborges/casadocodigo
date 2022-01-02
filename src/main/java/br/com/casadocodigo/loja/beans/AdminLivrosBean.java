package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.daos.AutorDao;
import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AdminLivrosBean implements Serializable{

    private static final long serialVersionUID = -1590819766396690851L;
    @Inject
    private Livro livro;
    @Inject
    private LivroDao livroDao;
    @Inject
    private AutorDao autorDao;

    private List<Integer> autoresId = new ArrayList<>();

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Integer> getAutoresId() {
        return autoresId;
    }

    public void setAutoresId(List<Integer> autoresId) {
        this.autoresId = autoresId;
    }

    public List<Autor> getAutores(){
        return autorDao.getAllAutores();
    }

    @Transactional
    public String salvar(){
        autoresId.forEach(id -> livro.getAutores().add(new Autor(id)));
        livroDao.salvar(livro);

        FacesContext.getCurrentInstance()
                .getExternalContext()
                .getFlash()
                .setKeepMessages(true);

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Livro cadastrado com sucesso!!!"));

        return "/livros/lista?faces-redirect=true";
    }



}
