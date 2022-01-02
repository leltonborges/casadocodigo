package br.com.casadocodigo.loja.db;

import br.com.casadocodigo.loja.daos.AutorDao;
import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;

@ApplicationScoped
public class Db {
    @Inject
    private LivroDao livroDao;
    @Inject
    private AutorDao autorDao;

    @Transactional
    public void onStart(@Observes @Initialized(ApplicationScoped.class) Object obj) {
        listLivros();
    }

    public void listLivros() {
        Autor a1 = new Autor(null, "Lia");
        Autor a2 = new Autor(null, "Bia");
        Autor a3 = new Autor(null, "Bob");
        Autor a4 = new Autor(null, "Maria");
        Autor a5 = new Autor(null, "Ana");
        Autor a6 = new Autor(null, "Alex");

        Livro l1 = new Livro(null, "Java 1", "Java 1", BigDecimal.valueOf(20), 10);
        l1.getAutores().addAll(Arrays.asList(a1, a2, a3));
        Livro l2 = new Livro(null, "Java 2", "Java 2", BigDecimal.valueOf(20), 10);
        l2.getAutores().addAll(Arrays.asList(a6, a5, a2));
        Livro l3 = new Livro(null, "Java 3", "Java 3", BigDecimal.valueOf(20), 10);
        l3.getAutores().addAll(Arrays.asList(a4, a6));
        Livro l4 = new Livro(null, "Java 4", "Java 4", BigDecimal.valueOf(20), 10);
        l4.getAutores().addAll(Arrays.asList(a2, a5, a6));
        Livro l5 = new Livro(null, "Java 5", "Java 5", BigDecimal.valueOf(20), 10);
        l5.getAutores().addAll(Arrays.asList(a3, a5, a1));
        Livro l6 = new Livro(null, "Java 6", "Java 6", BigDecimal.valueOf(20), 10);
        l6.getAutores().addAll(Arrays.asList(a3, a5, a1, a6));

        autorDao.salvar(a1);
        autorDao.salvar(a2);
        autorDao.salvar(a3);
        autorDao.salvar(a4);
        autorDao.salvar(a5);
        autorDao.salvar(a6);

        livroDao.salvar(l1);
        livroDao.salvar(l2);
        livroDao.salvar(l3);
        livroDao.salvar(l4);
        livroDao.salvar(l5);
        livroDao.salvar(l6);
    }
}
