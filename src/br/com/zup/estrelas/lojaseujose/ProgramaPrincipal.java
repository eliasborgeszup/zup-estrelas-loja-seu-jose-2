package br.com.zup.estrelas.lojaseujose;

import java.util.List;
import java.util.Scanner;

import br.com.zup.estrelas.lojaseujose.dao.PecaDAO;
import br.com.zup.estrelas.lojaseujose.pojo.Peca;

public class ProgramaPrincipal {

	public static Peca peca = new Peca();
	public static PecaDAO pecaDao = new PecaDAO();
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);

		int opcaoMenuPrincipal;
		int opcaoMenuPecas;
		int opcaoMenuListas;
		int opcaoMenuVendas;
		
		do {
			
			imprimeMenuPrincipal();
			opcaoMenuPrincipal = teclado.nextInt();
			
			switch (opcaoMenuPrincipal) {
			case 1:
				
				do {
					
					imprimeMenuPecas();
					opcaoMenuPecas = teclado.nextInt();
					
					switch (opcaoMenuPecas) {
					case 1:
						inserePeca(teclado, pecaDao);
						break;
						
					case 2:
						consultaPeca(teclado, pecaDao);
						break;

					case 3:
						
						do {
							
							imprimeMenuListas();
							opcaoMenuListas = teclado.nextInt();
							
							switch (opcaoMenuListas) {
							case 1:
								listaPecas(pecaDao);
								break;
								
							case 2:
								listaPecasPorLetras(teclado, pecaDao);
								break;
								
							case 3:
								listaPecasPorModeloCarro(teclado, pecaDao);
								break;
								
							case 4:
								listaPecasPorCategoria(teclado, pecaDao);
								break;

							case 0:
								break;
								
							default:
								System.out.println("OP��O INV�LIDA, TENTE NOVAMENTE (:");
								break;
							}
							
						} while (opcaoMenuListas != 0);
						
						break;

					case 4:
						removePeca(teclado, pecaDao);
						break;

					case 0:
						break;

					default:
						System.out.println("OP��O INV�LIDA, TENTE NOVAMENTE (:");
						break;
					}
					
				} while (opcaoMenuPecas != 0);
				
				break;

				
			case 2:
				
				imprimeMenuVendas();
				opcaoMenuVendas = teclado.nextInt();
				
				do {
					
					switch (opcaoMenuVendas) {
					case 1:
						
						break;

						
					case 2:
						
						break;
						
					case 0:
						break;
						
					default:
						break;
					}
					
				} while (opcaoMenuVendas != 0);
				
				break;
			
			case 0:
				return;
				
			default:
				
				break;
			}
			
		} while (opcaoMenuPrincipal != 0);
		
		teclado.close();
	}
	
	public static void imprimeMenuPrincipal() {
		System.out.println("\n===================================");
		System.out.println("           |ZUP-ESTRELAS|");
		System.out.println("===================================");
		System.out.println("           [LOJA-SEU-JOS�]");
		System.out.println("===================================");
		System.out.println("[1] - GEST�O DE PE�AS ");
		System.out.println("[2] - GEST�O DE VENDAS ");
		System.out.println("[0] - FECHAR O DIA");
		System.out.println("===================================");
		System.out.print("\nOP��O: ");
	}
	
	public static void imprimeMenuPecas() {
		System.out.println("\n===================================");
		System.out.println("           |ZUP-ESTRELAS|");
		System.out.println("===================================");
		System.out.println("           [LOJA-SEU-JOS�]");
		System.out.println("===================================");
		System.out.println("[1] - CADASTRAR PE�A ");
		System.out.println("[2] - CONSULTAR PE�A ");
		System.out.println("[3] - LISTAR PE�AS");
		System.out.println("[4] - REMOVER PE�A");
		System.out.println("[0] - VOLTAR");
		System.out.println("===================================");
		System.out.print("\nOP��O: ");
	}
	
	public static void imprimeMenuListas() {
		System.out.println("\n===================================");
		System.out.println("           |ZUP-ESTRELAS|");
		System.out.println("===================================");
		System.out.println("           [LOJA-SEU-JOS�]");
		System.out.println("===================================");
		System.out.println("[1] - LISTAR TODAS AS PE�AS ");
		System.out.println("[2] - LISTAR POR LETRAS ");
		System.out.println("[3] - LISTAR POR MODELO DO CARRO");
		System.out.println("[4] - LISTAR POR CATEGORIA");
		System.out.println("[0] - VOLTAR");
		System.out.println("===================================");
		System.out.print("\nOP��O: ");
	}
	
	public static void imprimeMenuVendas() {
		System.out.println("\n===================================");
		System.out.println("           |ZUP-ESTRELAS|");
		System.out.println("===================================");
		System.out.println("           [LOJA-SEU-JOS�]");
		System.out.println("===================================");
		System.out.println("[1] - EFETUAR VENDA ");
		System.out.println("[2] - EXTRAIR RELAT�RIO DO DIA ");
		System.out.println("[0] - VOLTAR");
		System.out.println("===================================");
		System.out.print("\nOP��O: ");
	}
	
	public static void inserePeca(Scanner teclado, PecaDAO pecaDao) {
		
		System.out.print("\nC�DIGO DE BARRAS: ");
		String codigoBarras = teclado.next();
		
		System.out.print("\nNOME: ");
		String nome = teclado.next();
		
		System.out.print("\nMODELO DO CARRO: ");
		String modeloCarro = teclado.next();
		
		System.out.print("\nFABRICANTE: ");
		String fabricante = teclado.next();
		
		System.out.print("\nPRE�O DE CUSTO: ");
		Double precoCusto = teclado.nextDouble();
		
		System.out.print("\nPRE�O DE VENDA: ");
		Double precoVenda = teclado.nextDouble();
		
		System.out.print("\nQUANTIDADE: ");
		Integer qtdEstoque = teclado.nextInt();
		
		System.out.print("\nCATEGORIA: \n");
		System.out.println("===================================");
		System.out.println("[1] - MANUTEN��O ");
		System.out.println("[2] - RODA ");
		System.out.println("[3] - PERFORMANCE ");
		System.out.println("[4] - SOM ");
		System.out.println("===================================");
		
		Categoria categoria = null;
		
		do {
			
			System.out.print("\nOP��O: ");
			int opcaoMenuCategorias = teclado.nextInt();
			
			switch (opcaoMenuCategorias) {
			case 1:
				categoria = Categoria.MANUTENCAO;
				break;

			case 2:
				categoria = Categoria.RODA;
				break;
				
			case 3:
				categoria = Categoria.PERFORMANCE;
				break;
				
			case 4:
				categoria = Categoria.SOM;
				break;
				
			default:
				System.out.println("OP��O INV�LIDA, TENTE NOVAMENTE (:");
				break;
			}
			
		} while (categoria == null);
		
		Peca pecaDB = new Peca(codigoBarras, nome, modeloCarro, fabricante, 
							precoCusto, precoVenda, qtdEstoque, categoria.getCategoria());
		
		pecaDao.inserePeca(pecaDB);
				
	}

	public static void consultaPeca(Scanner teclado, PecaDAO pecaDao) {
		
		System.out.print("\nC�DIGO DE BARRAS: ");
		String codigoBarras = teclado.next();
		
		List<Peca> pecasDB = pecaDao.consultaPeca(codigoBarras);
		
		for (Peca peca : pecasDB) {
			System.out.printf("\nPE�A DE C�DIGO: [%s]\n", peca.getCodigoBarras());
			System.out.println("===================================");
			System.out.println("[NOME]: " + peca.getNome());
			System.out.println("[MODELO DO CARRO]: " + peca.getModeloCarro());
			System.out.println("[FABRICANTE]: " + peca.getFabricante());
			System.out.println("[PRE�O DE CUSTO]: " + peca.getPrecoCusto());
			System.out.println("[PRE�O DE VENDA]: " + peca.getPrecoVenda());
			System.out.println("[QUANTIDADE EM ESTOQUE]: " + peca.getQtdEstoque());
			System.out.println("[CATEGORIA]: " + peca.getCategoria());
			System.out.println("===================================\n");
		}
		
	}
	
	public static void listaPecas(PecaDAO pecaDao) {
		
		List<Peca> pecasDB = pecaDao.listaPecas();
		
		for (Peca peca : pecasDB) {
			System.out.printf("\nPE�A DE C�DIGO: [%s]\n", peca.getCodigoBarras());
			System.out.println("===================================");
			System.out.println("[NOME]: " + peca.getNome());
			System.out.println("[MODELO DO CARRO]: " + peca.getModeloCarro());
			System.out.println("[FABRICANTE]: " + peca.getFabricante());
			System.out.println("[PRE�O DE CUSTO]: " + peca.getPrecoCusto());
			System.out.println("[PRE�O DE VENDA]: " + peca.getPrecoVenda());
			System.out.println("[QUANTIDADE EM ESTOQUE]: " + peca.getQtdEstoque());
			System.out.println("[CATEGORIA]: " + peca.getCategoria());
			System.out.println("===================================\n");
		}
		
	}
	
	public static void listaPecasPorLetras(Scanner teclado, PecaDAO pecaDao) {
		
		System.out.print("\nFILTRO POR LETRAS: ");
		String letras = teclado.next();
		
		List<Peca> pecasDB = pecaDao.listaPecasPorLetras(letras);
		
		for (Peca peca : pecasDB) {
			System.out.printf("\nPE�A DE C�DIGO: [%s]\n", peca.getCodigoBarras());
			System.out.println("===================================");
			System.out.println("[NOME]: " + peca.getNome());
			System.out.println("[MODELO DO CARRO]: " + peca.getModeloCarro());
			System.out.println("[FABRICANTE]: " + peca.getFabricante());
			System.out.println("[PRE�O DE CUSTO]: " + peca.getPrecoCusto());
			System.out.println("[PRE�O DE VENDA]: " + peca.getPrecoVenda());
			System.out.println("[QUANTIDADE EM ESTOQUE]: " + peca.getQtdEstoque());
			System.out.println("[CATEGORIA]: " + peca.getCategoria());
			System.out.println("===================================\n");
		}
		
	}
	
	public static void listaPecasPorModeloCarro(Scanner teclado, PecaDAO pecaDao) {
		
		System.out.print("\nMODELO DO CARRO: ");
		String modeloCarro = teclado.next();
		
		List<Peca> pecasDB = pecaDao.listaPecasPorModeloCarro(modeloCarro);
		
		for (Peca peca : pecasDB) {
			System.out.printf("\nPE�A DE C�DIGO: [%s]\n", peca.getCodigoBarras());
			System.out.println("===================================");
			System.out.println("[NOME]: " + peca.getNome());
			System.out.println("[MODELO DO CARRO]: " + peca.getModeloCarro());
			System.out.println("[FABRICANTE]: " + peca.getFabricante());
			System.out.println("[PRE�O DE CUSTO]: " + peca.getPrecoCusto());
			System.out.println("[PRE�O DE VENDA]: " + peca.getPrecoVenda());
			System.out.println("[QUANTIDADE EM ESTOQUE]: " + peca.getQtdEstoque());
			System.out.println("[CATEGORIA]: " + peca.getCategoria());
			System.out.println("===================================\n");
		}
		
	}
	
	public static void listaPecasPorCategoria(Scanner teclado, PecaDAO pecaDao) {
		
		System.out.print("\nCATEGORIA: \n");
		System.out.println("===================================");
		System.out.println("[1] - MANUTEN��O ");
		System.out.println("[2] - RODA ");
		System.out.println("[3] - PERFORMANCE ");
		System.out.println("[4] - SOM ");
		System.out.println("===================================");
		
		Categoria categoria = null;
		
		do {
			
			System.out.print("\nOP��O: ");
			int opcaoMenuCategorias = teclado.nextInt();
			
			switch (opcaoMenuCategorias) {
			case 1:
				categoria = Categoria.MANUTENCAO;
				break;

			case 2:
				categoria = Categoria.RODA;
				break;
				
			case 3:
				categoria = Categoria.PERFORMANCE;
				break;
				
			case 4:
				categoria = Categoria.SOM;
				break;
				
			default:
				System.out.println("OP��O INV�LIDA, TENTE NOVAMENTE (:");
				break;
			}
			
		} while (categoria == null);
		
		List<Peca> pecasDB = pecaDao.listaPecasPorCategoria(categoria.getCategoria());
		
		for (Peca peca : pecasDB) {
			System.out.printf("\nPE�A DE C�DIGO: [%s]\n", peca.getCodigoBarras());
			System.out.println("===================================");
			System.out.println("[NOME]: " + peca.getNome());
			System.out.println("[MODELO DO CARRO]: " + peca.getModeloCarro());
			System.out.println("[FABRICANTE]: " + peca.getFabricante());
			System.out.println("[PRE�O DE CUSTO]: " + peca.getPrecoCusto());
			System.out.println("[PRE�O DE VENDA]: " + peca.getPrecoVenda());
			System.out.println("[QUANTIDADE EM ESTOQUE]: " + peca.getQtdEstoque());
			System.out.println("[CATEGORIA]: " + peca.getCategoria());
			System.out.println("===================================\n");
		}
		
	}
	
	public static void removePeca(Scanner teclado, PecaDAO pecaDao) {
		
		System.out.print("\nC�DIGO DE BARRAS: ");
		String codigoBarras = teclado.next();
		
		pecaDao.removePeca(codigoBarras);
		
	}
}
