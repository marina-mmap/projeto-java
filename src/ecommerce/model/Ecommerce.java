package ecommerce.model;

public class Ecommerce {

private int sku;
private int tamanho;
private int tipo;
private String marca;	
private float quantidade;

public Ecommerce(int sku, int tamanho, int tipo, String marca, float quantidade) {
	this.sku = sku;
	this.tamanho = tamanho;
	this.tipo = tipo;
	this.marca = marca;
	this.quantidade = quantidade;
}

public int getSku() {
	return sku;
}

public void setSku(int sku) {
	this.sku = sku;
}

public int getTamanho() {
	return tamanho;
}

public void setTamanho(int tamanho) {
	this.tamanho = tamanho;
}

public int getTipo() {
	return tipo;
}

public void setTipo(int tipo) {
	this.tipo = tipo;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public float getQuantidade() {
	return quantidade;
}

public void setQuantidade(float quantidade) {
	this.quantidade = quantidade;
}

public boolean retirar(float valor) {
	
	if (this.getQuantidade() < valor) {
		System.out.println("n Sem estoque");
		return false;
	}
	
	this.setQuantidade(this.getQuantidade()-valor);
	return true;
}

public void inserir(float valor) {
	
	this.setQuantidade(this.getQuantidade()+valor);
}

public void visualizar() {

	String tipo = "";
	
	switch(this.tipo) {
	case 1:
		tipo = "Produto Camiseta";
	break;
	case 2:
		tipo = "Produto Calça";
	break;
	}
	
	System.out.println("\n\n***********************************************************");
	System.out.println("Dados do Produto:");
	System.out.println("***********************************************************");
	System.out.println("SKU Produto: " + this.sku);
	System.out.println("Tamnho: " + this.tamanho);
	System.out.println("Tipo de produto: " + tipo);
	System.out.println("Marca: " + this.marca);
	System.out.println("Quantidade: " + this.quantidade);

}

}