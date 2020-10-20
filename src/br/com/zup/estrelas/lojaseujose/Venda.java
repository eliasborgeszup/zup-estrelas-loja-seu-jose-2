package br.com.zup.estrelas.lojaseujose;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import br.com.zup.estrelas.lojaseujose.dao.PecaDAO;
import br.com.zup.estrelas.lojaseujose.pojo.Peca;

public class Venda {

	private static Peca peca = new Peca();
	private static PecaDAO pecaDao = new PecaDAO();
	private static Calendar c = Calendar.getInstance();
	
	private double valorCaixa;
	
	public Venda() {
		this.valorCaixa = 0;
	}
		
	public boolean verificaQtdPecaValida(int qtdPecas, String codigoBarras) {
		
		peca = pecaDao.consultaPeca(codigoBarras);
		
		if((peca.getQtdEstoque() - qtdPecas) < 0) {
			System.out.println("\n===================================");
			System.out.println("QUANTIDADE DE PEÇAS NÃO É SUFICIENTE!");
			System.out.println("REABASTEÇA O ESTOQUE,");
			System.out.println("VENDA EM MENOR QUANTIDADE,");
			System.out.println("OU PRESSIONE '0' PARA CANCELAR A COMPRA");
			System.out.println("===================================\n");
			return false;
		}
		return true;
	}
	
	public void efetuarVenda(String codigoBarras, int qtdPecas) throws IOException {
		
		if(qtdPecas <= 0 || codigoBarras.equals(null)) {
			return;
		}
		
		peca = pecaDao.consultaPeca(codigoBarras);
		double valorVenda = peca.getPrecoVenda() * qtdPecas;
		
		pecaDao.retiraPecasVendidas(codigoBarras, qtdPecas);
		setValorCaixa(getValorCaixa() + (valorVenda));
				
		registraVendaNoRelatorio(qtdPecas, valorVenda);
				
	}
	
	public void criaPasta() {
		
		File pasta = new File("lojaseujose");

		if (!pasta.exists()) {
			pasta.mkdir();
		}
	}
	
	public void criaRelatorioDiario() throws IOException {
		
		String nomeRelatorioDiario = "lojaseujose/" + "RELATORIO_" + c.get(Calendar.MONTH) + "_" + c.get(Calendar.DAY_OF_MONTH) + ".txt";
		
		FileWriter escritor = new FileWriter(nomeRelatorioDiario);

		escritor.close();

	}
	
	public void registraVendaNoRelatorio(int qtdPecas, double valorVenda) throws IOException {
		
		String nomeRelatorioDiario = "lojaseujose/" + "RELATORIO_" + c.get(Calendar.MONTH) + "_" + c.get(Calendar.DAY_OF_MONTH) + ".txt";
		
		FileWriter escritor = new FileWriter(nomeRelatorioDiario, true);
		
		escritor.append(String.format(
				"\n=======================================\n"
			  + "[CÓDIGO DE BARRAS]: %s\n"
			  + "[NOME]: %s\n"
			  +	"[QUANTIDADE]: %d\n"
			  + "[VALOR]: R$ %.2f\n"
			  + "=======================================\n"
			  + "[CAIXA]: R$ %.2f\n"
			  + "=======================================\n",
			  peca.getCodigoBarras(), peca.getNome(), qtdPecas, valorVenda, valorCaixa));
		
		
		escritor.close();
		
	}
	
	public void mostraRelatorio() throws IOException {
		
		Calendar c = Calendar.getInstance();
		
		String nomeRelatorioDiario = "lojaseujose/" + "RELATORIO_" + c.get(Calendar.MONTH) + "_" + c.get(Calendar.DAY_OF_MONTH) + ".txt";
		
		FileReader estruturaDaLista = new FileReader(nomeRelatorioDiario);
		BufferedReader leitorDaLista = new BufferedReader(estruturaDaLista);

		String linha;
		
		while ((linha = leitorDaLista.readLine()) != null) {
			System.out.println(linha);
		}
		leitorDaLista.close();
		estruturaDaLista.close();
	}
	
	public void vendaInterrompida(int qtdPecas, double valorVenda) throws IOException {
		
		String nomeRelatorioDiario = "lojaseujose/" + "RELATORIO_" + c.get(Calendar.MONTH) + "_" + c.get(Calendar.DAY_OF_MONTH) + ".txt";
		
		FileWriter escritor = new FileWriter(nomeRelatorioDiario, true);
		
		escritor.append(String.format(
				"\n=======================================\n"
			  + "[CÓDIGO DE BARRAS]: %s\n"
			  + "[NOME]: %s\n"
			  +	"[QUANTIDADE]: %d\n"
			  + "[VALOR]: R$ %.2f\n"
			  + "=======================================\n"
			  + "[CAIXA]: R$ %.2f\n"
			  + "=======================================\n",
			  peca.getCodigoBarras(), peca.getNome(), qtdPecas, valorVenda, valorCaixa));
		
		
		escritor.close();
		
	}
	
	public double getValorCaixa() {
		return this.valorCaixa;
	}
	
	private void setValorCaixa(double valorCaixa) {
		this.valorCaixa = valorCaixa;
	}
}
