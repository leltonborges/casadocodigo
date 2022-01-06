package br.com.casadocodigo.loja.beans;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Livro;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class CarrinhoComprasBean {
    @Inject
    private LivroDao livroDao;
    @Inject
    private CarrinhoCompras carrinhoCompras;

    public String addLivro(Integer id){
        Livro livro = livroDao.buscarPorId(id);
        System.out.println(livro);
        CarrinhoItem item = new CarrinhoItem(livro);
        carrinhoCompras.add(item);
        return "/carrinho/carrinho?faces-redirect=true";
    }

    public CarrinhoCompras getCarrinhoCompras() {
        return carrinhoCompras;
    }

    public String remover(CarrinhoItem item){
        Boolean isRemove = this.carrinhoCompras.remover(item);

        return isRemove? "/carrinho/carrinho?faces-redirect=true&success=true" :
                "/carrinho/carrinho?faces-redirect=true&success=false";
    }
}
