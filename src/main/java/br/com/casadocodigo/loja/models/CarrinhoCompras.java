package br.com.casadocodigo.loja.models;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
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
}
