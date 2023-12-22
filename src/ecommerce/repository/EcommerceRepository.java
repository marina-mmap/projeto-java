package ecommerce.repository;

import ecommerce.model.Ecommerce;

public interface EcommerceRepository {

	public void procurarPorNumero(int sku);
	public void listarTodas();
	public void cadastrar(Ecommerce conta);
	public void atualizar(Ecommerce conta);
	public void deletar(int sku);
	
	
	public void retirar(int sku, float quantidade);
	public void inserir(int numero, float quantidade);

}