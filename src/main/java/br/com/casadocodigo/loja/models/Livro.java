package br.com.casadocodigo.loja.models;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String titulo;
    @Lob
    @Length(min = 10)
    @NotBlank
    private String descricao;
    @DecimalMin("20")
    private BigDecimal preco;
    @Min(20)
    private Integer numeroPaginas;

    @Temporal(TemporalType.DATE)
    private Calendar dataPublicacao;

    private String capaPath;

    @JoinTable(
            joinColumns = @JoinColumn(name = "id_autor", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_livro", referencedColumnName = "id")
    )
    @ManyToMany
    @NotNull
    @Size(min = 1)
    private List<Autor> autores = new ArrayList<>();

    public Livro() {
    }

    public Livro(Integer id, String titulo, String descricao, BigDecimal preco, Integer numeroPaginas) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.setCapaPath("livros/capas/spring-framework-featured_large.png");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public String getCapaPath() {
        return capaPath;
    }

    public void setCapaPath(String capaPath) {
        this.capaPath = capaPath;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", autores=" + autores +
                '}';
    }
}
