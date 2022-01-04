package br.com.casadocodigo.loja.models;

import java.util.*;

public class CarrinhoCompras {
    
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
