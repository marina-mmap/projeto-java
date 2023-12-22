package ecommerce.model;

import ecommerce.model.Ecommerce;

public class EcommerceCalca extends Ecommerce{

	
		private int lançamento;

		public EcommerceCalca(int sku, int tamanho, int tipo, String marca, float quantidade, int lançamento) {
			super(sku, tamanho, tipo, marca, quantidade);
			this.lançamento = lançamento;
		}

		public int getLançamento() {
			return lançamento;
		}

		public void setLançamento(int lançamento) {
			this.lançamento = lançamento;
		}
		
	    @Override
		public void visualizar() {
			super.visualizar();
			System.out.println("Lançamento da marca: " + this.lançamento);
		}
	    
	}

