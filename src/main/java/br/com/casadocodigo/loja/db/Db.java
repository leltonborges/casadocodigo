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
        Autor a1 = new Autor(null, "Lia");
        Autor a2 = new Autor(null, "Bia");
        Autor a3 = new Autor(null, "Bob");
        Autor a4 = new Autor(null, "Maria");
        Autor a5 = new Autor(null, "Ana");
        Autor a6 = new Autor(null, "Alex");

        Livro l1 = new Livro(null, "Java 8", "Java LTS 8 with lambdas", BigDecimal.valueOf(20), 100);
        l1.getAutores().addAll(Arrays.asList(a1, a2, a3));
        Livro l2 = new Livro(null, "Java 13", "Java 13 with Text Blocks", BigDecimal.valueOf(20), 40);
        l2.getAutores().addAll(Arrays.asList(a6, a5, a2));
        Livro l3 = new Livro(null, "java 15", "Java 15 parttern default Text Blocks", BigDecimal.valueOf(20), 50);
        l3.getAutores().addAll(Arrays.asList(a4, a6));
        Livro l4 = new Livro(null, "Java 9", "Java 9 with Modules", BigDecimal.valueOf(20), 80);
        l4.getAutores().addAll(Arrays.asList(a2, a5, a6));
        Livro l5 = new Livro(null, "Java 11", "Java 11 LTS Stream, FunctionInterfaces and  type 'var' ", BigDecimal.valueOf(20), 50);
        l5.getAutores().addAll(Arrays.asList(a3, a5, a1));
        Livro l6 = new Livro(null, "Java 17", "Java 17 LTS new switch and scolped class", BigDecimal.valueOf(20), 100);
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
