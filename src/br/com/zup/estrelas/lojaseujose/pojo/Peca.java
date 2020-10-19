package br.com.zup.estrelas.lojaseujose.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estoque")
public class Peca {

	@Id
	@Column(name="codigo_barras")
	private String codigoBarras;
	
	private String nome;
	
	@Column(name="modelo_carro")
	private String modeloCarro;
	
	private String fabricante;
	
	@Column(name="preco_custo")
	private Double precoCusto;
	
	@Column(name="preco_venda")
	private Double precoVenda;
	
	@Column(name="qtd_estoque")
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
	
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getModeloCarro() {
		return this.modeloCarro;
	}
	
	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}
	
	public String getFabricante() {
		return this.fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
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
	
	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
