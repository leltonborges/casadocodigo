package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.daos.AutorDao;
import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.infra.FileSave;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class AdminLivrosBean implements Serializable {
    private static final long serialVersionUID = -1590819766396690851L;

    @Inject
    private Livro livro;
    @Inject
    private LivroDao livroDao;
    @Inject
    private AutorDao autorDao;
    @Inject
    private FacesContext facesContext;
    @Inject
    private Flash flash;

    private Part capaLivro;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Autor> getAutores() {
        return autorDao.getAllAutores();
    }

    public Part getCapaLivro() {
        return capaLivro;
    }

    public void setCapaLivro(Part capaLivro) {
        this.capaLivro = capaLivro;
    }

    @Transactional
    public String salvar(){
        FileSave fileSave = new FileSave();
        this.livro.setCapaPath(fileSave.writerPath(capaLivro, "/livros/capas/"));
        livroDao.salvar(livro);
        flash.setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage("Livro cadastrado com sucesso!!!"));
        return "/livros/lista?faces-redirect=true";
    }



}
