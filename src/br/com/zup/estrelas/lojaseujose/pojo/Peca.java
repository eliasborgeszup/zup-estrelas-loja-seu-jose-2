package br.com.zup.estrelas.lojaseujose.pojo;

public class Peca {

	private String codigoBarras;
	private String nome;
	private String modeloCarro;
	private String fabricante;
	private Double precoCusto;
	private Double precoVenda;
	private Integer qtdEstoque;
	private String categoria;

	public Peca() {

	}

	public Peca(String codigoBarras, String nome, String modeloCarro, String fabricante,
				 Double precoCusto, Double precoVenda, Integer qtdEstoque, String categoria) {
		
		this.codigoBarras = codigoBarras;
		this.nome = nome;
		this.modeloCarro = modeloCarro;
		this.fabricante = fabricante;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.qtdEstoque = qtdEstoque;
		this.categoria = categoria;
	}
	
	public String getCodigoBarras() {
		return this.codigoBarras;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getModeloCarro() {
		return this.modeloCarro;
	}
	
	public String getFabricante() {
		return this.fabricante;
	}
	
	public Double getPrecoCusto() {
		return this.precoCusto;
	}
	
	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}
	
	public Double getPrecoVenda() {
		return this.precoVenda;
	}
	
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public Integer getQtdEstoque() {
		return this.qtdEstoque;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
}