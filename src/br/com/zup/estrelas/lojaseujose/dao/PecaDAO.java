package br.com.zup.estrelas.lojaseujose.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zup.estrelas.lojaseujose.factory.ConnectionFactory;
import br.com.zup.estrelas.lojaseujose.pojo.Peca;

public class PecaDAO {
	
	private Connection conn;
	
	public PecaDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}

	public Peca retornaPeca(String codigoBarras) {
		
		Peca peca = new Peca();
		
		String sql = "select * from estoque where codigo_barras = ?";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, codigoBarras);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				peca.setCodigoBarras(rs.getString("codigo_barras"));
				peca.setNome(rs.getString("nome"));
				peca.setModeloCarro(rs.getString("modelo_carro"));
				peca.setFabricante(rs.getString("fabricante"));
				peca.setPrecoCusto(rs.getDouble("preco_custo"));
				peca.setPrecoVenda(rs.getDouble("preco_venda"));
				peca.setQtdEstoque(rs.getInt("qtd_estoque"));
				peca.setCategoria(rs.getString("categoria"));
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			
			System.err.println("IMPOSSÍVEL ENCONTRAR A QUANTIDADE DE PEÇAS NO MOMENTO ):");
			System.err.println(e.getMessage());
			
		}
		return peca;
	}
	
	public boolean inserePeca(Peca pecaDB) {
		
		String sql = "insert into estoque"
				+ "(codigo_barras, nome, modelo_carro, fabricante, " 
				+ "preco_custo, preco_venda, qtd_estoque, categoria)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
		
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, pecaDB.getCodigoBarras());
			stmt.setString(2, pecaDB.getNome());
			stmt.setString(3, pecaDB.getModeloCarro());
			stmt.setString(4, pecaDB.getFabricante());
			stmt.setDouble(5, pecaDB.getPrecoCusto());
			stmt.setDouble(6, pecaDB.getPrecoVenda());
			stmt.setInt(7, pecaDB.getQtdEstoque());
			stmt.setString(8, pecaDB.getCategoria());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			
			System.err.println("IMPOSSÍVEL CADASTRAR UMA PEÇA NO MOMENTO ):");
			System.err.println(e.getMessage());
			
			return false;
		}
		
		return true;
	}
	
	public List<Peca> consultaPeca(String codigoBarras) {
		
		List<Peca> pecas = new ArrayList<>();
		
		String sql = "select e.* from estoque e where codigo_barras = ?";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, codigoBarras);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {

				Peca peca = new Peca();
				
				peca.setCodigoBarras(rs.getString("codigo_barras"));
				peca.setNome(rs.getString("nome"));
				peca.setModeloCarro(rs.getString("modelo_carro"));
				peca.setFabricante(rs.getString("fabricante"));
				peca.setPrecoCusto(rs.getDouble("preco_custo"));
				peca.setPrecoVenda(rs.getDouble("preco_venda"));
				peca.setQtdEstoque(rs.getInt("qtd_estoque"));
				peca.setCategoria(rs.getString("categoria"));
				
				pecas.add(peca);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			
			System.err.println("IMPOSSÍVEL LISTAR PEÇAS NO MOMENTO ):");
			System.err.println(e.getMessage());
			
		}
		
		return pecas;
	}
	
	public List<Peca> listaPecas() {
		
		List<Peca> pecas = new ArrayList<>();
		
		String sql = "select * from estoque";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {

				Peca peca = new Peca();
				
				peca.setCodigoBarras(rs.getString("codigo_barras"));
				peca.setNome(rs.getString("nome"));
				peca.setModeloCarro(rs.getString("modelo_carro"));
				peca.setFabricante(rs.getString("fabricante"));
				peca.setPrecoCusto(rs.getDouble("preco_custo"));
				peca.setPrecoVenda(rs.getDouble("preco_venda"));
				peca.setQtdEstoque(rs.getInt("qtd_estoque"));
				peca.setCategoria(rs.getString("categoria"));
				
				pecas.add(peca);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			
			System.err.println("IMPOSSÍVEL LISTAR PEÇAS NO MOMENTO ):");
			System.err.println(e.getMessage());
			
		}
		
		return pecas;
	}
	
	public List<Peca> listaPecasPorLetras(String letras) {
		
		List<Peca> pecas = new ArrayList<>();
		
		String sql = "select e.* from estoque e where e.nome like ?";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, letras + "%");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {

				Peca peca = new Peca();
				
				peca.setCodigoBarras(rs.getString("codigo_barras"));
				peca.setNome(rs.getString("nome"));
				peca.setModeloCarro(rs.getString("modelo_carro"));
				peca.setFabricante(rs.getString("fabricante"));
				peca.setPrecoCusto(rs.getDouble("preco_custo"));
				peca.setPrecoVenda(rs.getDouble("preco_venda"));
				peca.setQtdEstoque(rs.getInt("qtd_estoque"));
				peca.setCategoria(rs.getString("categoria"));
				
				pecas.add(peca);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			
			System.err.println("IMPOSSÍVEL LISTAR PEÇAS NO MOMENTO ):");
			System.err.println(e.getMessage());
			
		}
		
		return pecas;
	}
	
	public List<Peca> listaPecasPorModeloCarro(String modeloCarro) {
		
		List<Peca> pecas = new ArrayList<>();
		
		String sql = "select e.* from estoque e where e.modelo_carro = ?";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, modeloCarro);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {

				Peca peca = new Peca();
				
				peca.setCodigoBarras(rs.getString("codigo_barras"));
				peca.setNome(rs.getString("nome"));
				peca.setModeloCarro(rs.getString("modelo_carro"));
				peca.setFabricante(rs.getString("fabricante"));
				peca.setPrecoCusto(rs.getDouble("preco_custo"));
				peca.setPrecoVenda(rs.getDouble("preco_venda"));
				peca.setQtdEstoque(rs.getInt("qtd_estoque"));
				peca.setCategoria(rs.getString("categoria"));
				
				pecas.add(peca);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			
			System.err.println("IMPOSSÍVEL LISTAR PEÇAS NO MOMENTO ):");
			System.err.println(e.getMessage());
			
		}
		
		return pecas;
	}
	
	public List<Peca> listaPecasPorCategoria(String categoria) {
		
		List<Peca> pecas = new ArrayList<>();
		
		String sql = "select e.* from estoque e where e.categoria = ?";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, categoria);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {

				Peca peca = new Peca();
				
				peca.setCodigoBarras(rs.getString("codigo_barras"));
				peca.setNome(rs.getString("nome"));
				peca.setModeloCarro(rs.getString("modelo_carro"));
				peca.setFabricante(rs.getString("fabricante"));
				peca.setPrecoCusto(rs.getDouble("preco_custo"));
				peca.setPrecoVenda(rs.getDouble("preco_venda"));
				peca.setQtdEstoque(rs.getInt("qtd_estoque"));
				peca.setCategoria(rs.getString("categoria"));
				
				pecas.add(peca);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			
			System.err.println("IMPOSSÍVEL LISTAR PEÇAS NO MOMENTO ):");
			System.err.println(e.getMessage());
			
		}
		
		return pecas;
	}
	
	public boolean removePeca(String codigoBarras) {
		
		String sql = "delete from estoque where codigo_barras = ?";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, codigoBarras);
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			
			System.err.println("IMPOSSÍVEL REMOVER UMA PEÇA NO MOMENTO ):");
			System.err.println(e.getMessage());
			
			return false;
		}
		
		return true;
		
	}
		
	public boolean retiraPecasVendidas(String codigoBarras, int qtdPecas) {
		
		String sql = "update estoque set qtd_estoque = qtd_estoque - ? where codigo_barras = ?";
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, qtdPecas);
			stmt.setString(2, codigoBarras);
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			
			System.err.println("IMPOSSÍVEL REMOVER UMA PEÇA NO MOMENTO ):");
			System.err.println(e.getMessage());
			
			return false;
		}
		
		return true;
		
	}
		
}
