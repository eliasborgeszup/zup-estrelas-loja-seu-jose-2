package br.com.zup.estrelas.lojaseujose;

public enum Categoria {

	MANUTENCAO("MANUTENCAO"),
	RODA("RODA"),
	PERFORMANCE("PERFORMANCE"),
	SOM("SOM");

	private String categoria;
	
	Categoria (String categoria) {
		this.categoria = categoria;
	}
	
	public String getCategoria() {
		return this.categoria;	
	}
}
