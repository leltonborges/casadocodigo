package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.models.CarrinhoItem;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Named
@SessionScoped
public class CarrinhoCompras implements Serializable {
    private static final long serialVersionUID = -4889749108190966809L;

    private Set<CarrinhoItem> items = new HashSet<>();

    public void add(CarrinhoItem item){
        items.add(item);
    }

    public Set<CarrinhoItem> carrinhoItems(){
        return items;
    }

    public List<CarrinhoItem> getItems() {
        return new ArrayList<CarrinhoItem>(items);
    }

    public BigDecimal getTotal(){
        return items.stream().map(i -> i.getLivro().getPreco()
                .multiply(BigDecimal.valueOf(i.getQuantidade())))
                .reduce((s,t ) -> t.add(s)).get();
    }

    public BigDecimal totalItem(CarrinhoItem item){
        return item.getLivro()
                .getPreco()
                .multiply(BigDecimal.valueOf(item.getQuantidade()));
    }

    public Boolean remover(CarrinhoItem item) {
        boolean result = this.items.remove(item);
        return result;
    }
}
