package br.com.zup.estrelas.lojaseujose.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;

import br.com.zup.estrelas.lojaseujose.pojo.Peca;

public class PecaDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja_seu_jose");
	EntityManager manager = factory.createEntityManager();
	
	public boolean inserePeca(Peca peca) {
		
		peca.setCodigoBarras(peca.getCodigoBarras());
		peca.setNome(peca.getNome());
		peca.setModeloCarro(peca.getModeloCarro());
		peca.setFabricante(peca.getFabricante());
		peca.setPrecoCusto(peca.getPrecoCusto());
		peca.setPrecoVenda(peca.getPrecoVenda());
		peca.setQtdEstoque(peca.getQtdEstoque());
		peca.setCategoria(peca.getCategoria());

		manager.getTransaction().begin();
		manager.persist(peca);
		manager.getTransaction().commit();

		return true;
	}

	public Peca consultaPeca(String codigoBarras) {
		
		manager.clear();
		
		Peca peca = manager.find(Peca.class, codigoBarras);
		
		return peca;
	}

	public List<Peca> listaPecas() {

		manager.clear();
		
		Query query = manager.createQuery("select p from Peca as p");
		
		@SuppressWarnings("unchecked")
		List<Peca> pecas = query.getResultList();
		
		return pecas;
	}

	public List<Peca> listaPecasPorLetras(String letras) {

		manager.clear();
		
		Query query = manager.createQuery("select p from Peca as p where p.nome like :letras");

		query.setParameter("letras", letras + "%");

		@SuppressWarnings("unchecked")
		List<Peca> pecas = query.getResultList();
		
		return pecas;
	}

	public List<Peca> listaPecasPorModeloCarro(String modeloCarro) {

		manager.clear();
		
		Query query = manager.createQuery("select p from Peca as p where p.modeloCarro = :modeloCarro");

		query.setParameter("modeloCarro", modeloCarro);

		@SuppressWarnings("unchecked")
		List<Peca> pecas = query.getResultList();
		
		return pecas;

	}

	public List<Peca> listaPecasPorCategoria(String categoria) {
		
		manager.clear();
		
		Query query = manager.createQuery("select p from Peca as p where p.categoria = :categoria");

		query.setParameter("categoria", categoria);

		@SuppressWarnings("unchecked")
		List<Peca> pecas = query.getResultList();
		
		return pecas;
	}

	public boolean removePeca(String codigoBarras) {

		Peca peca = manager.find(Peca.class, codigoBarras);

		manager.getTransaction().begin();
		manager.remove(peca);
		manager.getTransaction().commit();

		return true;

	}

	public boolean retiraPecasVendidas(String codigoBarras, int qtdPecas) {

		Peca peca = manager.find(Peca.class, codigoBarras);
		
		int novaQtdEstoque = peca.getQtdEstoque() - qtdPecas;
		peca.setQtdEstoque(novaQtdEstoque);
		
		manager.getTransaction().begin();
		manager.merge(peca);
		manager.getTransaction().commit();
		
		return true;

	}
	
}
