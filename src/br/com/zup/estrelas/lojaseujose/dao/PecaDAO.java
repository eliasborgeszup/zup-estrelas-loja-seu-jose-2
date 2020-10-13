package br.com.zup.estrelas.lojaseujose.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.zup.estrelas.lojaseujose.factory.ConnectionFactory;
import br.com.zup.estrelas.lojaseujose.pojo.Peca;

public class PecaDAO {
	
	private Connection conn;
	
	public PecaDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public boolean inserePeca(Peca pecaDataBase) {
		
		String sql = "insert into estoque"
				+ "(codigo_barras, nome, modelo_carro, fabricante, " 
				+ "preco_custo, preco_venda, qtd_estoque, categoria)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
		
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, pecaDataBase.getCodigoBarras());
			stmt.setString(2, pecaDataBase.getNome());
			stmt.setString(3, pecaDataBase.getModeloCarro());
			stmt.setString(4, pecaDataBase.getFabricante());
			stmt.setDouble(5, pecaDataBase.getPrecoCusto());
			stmt.setDouble(6, pecaDataBase.getPrecoVenda());
			stmt.setInt(7, pecaDataBase.getQtdEstoque());
			stmt.setString(8, pecaDataBase.getCategoria());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			
			System.err.println("Impossível cadastrar uma peça no momento ):");
			System.err.println(e.getMessage());
			
			return false;
		}
		
		return true;
	}
	
}
