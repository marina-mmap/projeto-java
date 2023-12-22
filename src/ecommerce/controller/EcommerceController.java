package ecommerce.controller;

import java.util.ArrayList;

import ecommerce.model.Ecommerce;
import ecommerce.repository.EcommerceRepository;

public class EcommerceController implements EcommerceRepository {

   
    private ArrayList<Ecommerce> listaProdutos = new ArrayList<Ecommerce>();
    int sku = 0;
    
   
    @Override
    public void procurarPorNumero(int sku) {
        var produto = buscarNaCollection(sku);
		
		if (produto != null)
			produto.visualizar();
		else
			System.out.println("\nA Produto com SKU: " + sku + " não foi encontrado!");
    }

    @Override
    public void listarTodas() {
        for (var produto : listaProdutos) {
			produto.visualizar();
		}        
    }

    @Override
    public void cadastrar(Ecommerce produto) {
    	listaProdutos.add(produto);
		System.out.println("\nA  Produto: " + produto.getSku() + " foi criado com sucesso!");
    }

    @Override
    public void atualizar(Ecommerce produto) {
        var buscaProduto = buscarNaCollection(produto.getSku());
		
		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.println("\nA Produto: " + produto.getSku() + " foi atualizado com sucesso!");
		}else
			System.out.println("\nA Produto: " + produto.getSku() + " não foi encontrado!");
    }

    @Override
    public void deletar(int sku) {
        var produto = buscarNaCollection(sku);
		
		if (produto != null) {
			if(listaProdutos.remove(produto) == true)
				System.out.println("\nA Produto com: " + sku + " foi deletado com sucesso!");
		}else
			System.out.println("\nA Produto com: " + sku + " não foi encontrado!");
    }

    @Override
    public void retirar(int sku, float valor) {
        
        
    }

    @Override
    public void inserir(int sku, float valor) {
        
        
    }

	public int gerarNumero() {
		return ++ sku;
	}


	public Ecommerce buscarNaCollection(int sku) {
		for (var produto : listaProdutos) {
			if (produto.getSku() == sku) {
				return produto;
			}
		}
		
		return null;
	}
    
}