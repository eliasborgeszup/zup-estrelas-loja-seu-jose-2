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

	public static Peca peca = new Peca();
	public static PecaDAO pecaDao = new PecaDAO();
	
	private double valorCaixa;
	
	public Venda() {
		this.valorCaixa = 0;
	}
		
	public boolean verificaQtdPecaValida(int qtdPecas, String codigoBarras) {
		
		peca = pecaDao.retornaPeca(codigoBarras);
		
		if((peca.getQtdEstoque() - qtdPecas) < 0) {
			return false;
		}
		return true;
	}
	
	public void efetuarVenda(String codigoBarras, int qtdPecas) throws IOException {
		
		peca = pecaDao.retornaPeca(codigoBarras);
		double valorDaVenda = peca.getPrecoCusto() * qtdPecas;
		
		pecaDao.retiraPecasVendidas(codigoBarras, qtdPecas);
		setValorCaixa(getValorCaixa() + (valorDaVenda));
		
		Calendar c = Calendar.getInstance();
		
		String nomeRelatorioDiario = "LojaSeuJose/" + "RELATORIO_" + c.get(Calendar.MONTH) + "_" + c.get(Calendar.DAY_OF_MONTH) + ".txt";
		
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
			  peca.getCodigoBarras(), peca.getNome(), qtdPecas, valorDaVenda, valorCaixa));
		
		
		escritor.close();
		
	}
	
	public void criaPasta() {
		File pasta = new File("LojaSeuJose");

		if (!pasta.exists()) {
			pasta.mkdir();
		}
	}
	
	public void criaRelatorioDiario() throws IOException {

		Calendar c = Calendar.getInstance();
		
		String nomeRelatorioDiario = "LojaSeuJose/" + "RELATORIO_" + c.get(Calendar.MONTH) + "_" + c.get(Calendar.DAY_OF_MONTH) + ".txt";
		
		FileWriter escritor = new FileWriter(nomeRelatorioDiario);

		escritor.close();

	}
	
	public void mostraRelatorio() throws IOException {
		
		Calendar c = Calendar.getInstance();
		
		String nomeRelatorioDiario = "LojaSeuJose/" + "RELATORIO_" + c.get(Calendar.MONTH) + "_" + c.get(Calendar.DAY_OF_MONTH) + ".txt";
		
		FileReader estruturaDaLista = new FileReader(nomeRelatorioDiario);
		BufferedReader leitorDaLista = new BufferedReader(estruturaDaLista);

		String linha;
		
		while ((linha = leitorDaLista.readLine()) != null) {
			System.out.println(linha);
		}
		leitorDaLista.close();
		estruturaDaLista.close();
	}
	
	public double getValorCaixa() {
		return this.valorCaixa;
	}
	
	private void setValorCaixa(double valorCaixa) {
		this.valorCaixa = valorCaixa;
	}
}
