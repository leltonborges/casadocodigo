package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.daos.CompraDao;
import br.com.casadocodigo.loja.daos.UsuarioDao;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Compra;
import br.com.casadocodigo.loja.models.Usuario;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Named
@SessionScoped
public class CarrinhoCompras implements Serializable {
    private static final long serialVersionUID = -4889749108190966809L;
    @Inject
    private CompraDao compraDao;

    private Set<CarrinhoItem> items = new HashSet<>();

    public void add(CarrinhoItem item) {
        items.add(item);
    }

    public Set<CarrinhoItem> carrinhoItems() {
        return items;
    }

    public List<CarrinhoItem> getItems() {
        return new ArrayList<CarrinhoItem>(items);
    }

    public BigDecimal getTotal() {
        return items.stream().map(i -> i.getLivro().getPreco()
                        .multiply(BigDecimal.valueOf(i.getQuantidade())))
                .reduce((s, t) -> t.add(s)).get();
    }

    public BigDecimal totalItem(CarrinhoItem item) {
        return item.getLivro()
                .getPreco()
                .multiply(BigDecimal.valueOf(item.getQuantidade()));
    }

    public Boolean remover(CarrinhoItem item) {
        boolean result = this.items.remove(item);
        return result;
    }

    public void finalizar(Usuario user) {
        Compra compra = new Compra();
        compra.setUsuario(user);
        compra.setItems(this.toJson());
        compraDao.salvar(compra);
    }

    private String toJson() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        items.forEach(item -> {
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("titulo", item.getLivro().getTitulo())
                    .add("preco", item.getLivro().getPreco())
                    .add("quantidade", item.getQuantidade())
                    .add("total", getTotal());
            builder.add(objectBuilder);
        });

        String json = builder.build().toString();
        System.out.println(json);

        return json;
    }
}
