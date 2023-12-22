package ecommerce.model;

import ecommerce.model.Ecommerce;

public class EcommerceCamiseta extends Ecommerce{

		private float limite;

		public EcommerceCamiseta (int sku, int tamanho, int tipo, String marca, float quantidade, float limite) {
			super(sku, tamanho, tipo, marca, quantidade);
			this.limite = limite;
		}
		
		public float getLimite() {
			return limite;
		}

		public void setLimite(float limite) {
			this.limite = limite;
		}

		@Override
		public boolean retirar(float valor) { 
			
			if(this.getQuantidade() + this.getLimite() < valor) {
				System.out.println("\n Sem estoque!");
				return false;
			}
			
			this.setQuantidade(this.getQuantidade() - valor);
			return true;
			
		}
		
	    @Override
		public void visualizar() {
			super.visualizar();
			System.out.println("Limite de estoque: " + this.limite);
		}
	    
	}

