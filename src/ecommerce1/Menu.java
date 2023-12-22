package ecommerce1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.controller.EcommerceController;
import ecommerce.model.EcommerceCamiseta;
import ecommerce.model.EcommerceCalca;
import ecommerce.util.Cores;

public class Menu {
    public static void main(String[] args) throws Exception {
        		
        Scanner leia = new Scanner(System.in);
		
		int opcao, sku, tamanho, tipo, lançamento;
		String marca;
		float quantidade, limite; 

		EcommerceController produtos = new EcommerceController();
		

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("        Ecommmerce Mais Mais para Lojista            ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************         ");
			System.out.println("                                                              ");
			System.out.println("         1 - Criar Produto                                    ");
			System.out.println("         2 - Listar todos os produtos                         ");
			System.out.println("         3 - Buscar Produto			                          ");
			System.out.println("         4 - Atualizar Dados do produto                       ");
			System.out.println("         5 - Apagar Produto                      			  ");
			System.out.println("         6 - Retirar produto já cadastrado do estoque         ");
			System.out.println("         7 - Inserir produto no estoque      			      ");
			System.out.println("         8 - Sair                                             ");
			System.out.println("                                                              ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                                   ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			try {
				opcao = leia.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores da lista!");
				leia.nextLine();
				opcao=0;
			}
				
			if (opcao == 8) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nE-Commerce Mais Mais Agradece a Utilização");
				sobre();
				leia.close();
				System.exit(0);
			}
				
			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE + "Criar Produto \n\n");
				
					System.out.println("Digite o Numero do SKU do produto: ");
					tamanho = leia.nextInt();
					System.out.println("Digite a Marca: ");
					leia.skip("\\R?");
					marca = leia.nextLine();
					
					do {
						System.out.println("Digite o Tipo da produto (1-Camiseta ou 2-Calça): ");
						tipo = leia.nextInt();
					}while(tipo < 1 && tipo > 2);
						
					System.out.println("Digite a quantidade do produto: ");
					quantidade = leia.nextFloat();
					
					switch(tipo) {
						case 1 -> {
							System.out.println("Digite o Limite para o estoque: ");
							limite = leia.nextFloat();
							produtos.cadastrar(new EcommerceCamiseta(produtos.gerarNumero(), tamanho, tipo, marca, quantidade, limite));
						}
						case 2 -> {
							System.out.println("Digite o lançamento do produto:");
							lançamento = leia.nextInt();
							produtos.cadastrar(new EcommerceCalca(produtos.gerarNumero(), tamanho, tipo, marca, quantidade, lançamento));
						}
					}

                    keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "Listar todos os produtos:\n\n");
					
					produtos.listarTodas();

                    keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE + "Buscar Produto por SKU\n\n");
	
					System.out.println("Digite o SKU do produto: ");
					sku = leia.nextInt();
					
					produtos.procurarPorNumero(sku);

                    keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "Atualizar dados do produto\n\n");
					
					System.out.println("Digite o SKU do produto: ");
					sku = leia.nextInt();
					
					var buscaProduto = produtos.buscarNaCollection(sku);

					if (buscaProduto != null) {
						
						System.out.println("Digite o tamanho: ");
						tamanho = leia.nextInt();
						System.out.println("Digite a marca: ");
						leia.skip("\\R?");
						marca = leia.nextLine();
							
						System.out.println("Digite a quantidade de produto: ");
						quantidade = leia.nextFloat();
						
						tipo = buscaProduto.getTipo();
						
						switch(tipo) {
							case 1 -> {
								System.out.println("Digite o Limite de estoque: ");
								limite = leia.nextFloat();
								produtos.atualizar(new EcommerceCamiseta(sku, tamanho, tipo, marca, quantidade, limite));
							}
							case 2 -> {
								System.out.println("Digite o lançamento do produto: ");
								lançamento = leia.nextInt();
								produtos.atualizar(new EcommerceCamiseta(sku, tamanho, tipo, marca, quantidade, lançamento));
							}
							default ->{
								System.out.println("Tipo de produto inválido!");
							}
						}
						
					}else
						System.out.println("\nProduto não encontrado!");

                    keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "Apagar o produto\n\n");
		
					System.out.println("Digite o número do sku: ");
					sku = leia.nextInt();
						
					produtos.deletar(sku);

                    keyPress();
					break;
				case 6:
					System.out.println(Cores.TEXT_WHITE + "Retirar produto já cadastrado do estoque\n\n");

                    keyPress();
					break;
				case 7:
					System.out.println(Cores.TEXT_WHITE + "Inserir mais produtos já cadastrados no estoque \n\n");
					
                    keyPress();
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					
                    keyPress();
					break;
			}
		}	
    }


    private static void sobre() {
		
	}


	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}