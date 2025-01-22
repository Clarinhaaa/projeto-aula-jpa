package br.edu.ifba.projetoaulajpa;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.model.cliente.ClienteModel;
import br.edu.ifba.model.venda.ProdutoModel;
import br.edu.ifba.model.venda.VendaModel;
import jakarta.persistence.EntityManager;

@SpringBootApplication
public class ProjetoaulajpaApplication {

	public static void main(String[] args) {
		// SpringApplication.run(ProjetoaulajpaApplication.class, args);

		EntityManager em = GetEntityManager.getConnectionJpa();

		VendaModel ven1 = new VendaModel();
		ven1.setDescricaoVenda("Venda de caderno");
		ven1.setClienteVenda(em.find(ClienteModel.class, 4));
		ven1.addProduto(em.find(ProdutoModel.class, 1));

		VendaModel ven2 = new VendaModel();
		ven2.setDescricaoVenda("Venda de caderno");
		ven2.setClienteVenda(em.find(ClienteModel.class, 5));
		ven2.addProduto(em.find(ProdutoModel.class, 1));

		VendaModel ven3 = new VendaModel();
		ven3.setDescricaoVenda("Venda de caneta");
		ven3.setClienteVenda(em.find(ClienteModel.class, 4));
		ven2.addProduto(em.find(ProdutoModel.class, 2));

		em.getTransaction().begin();
		em.persist(ven1);
		em.persist(ven2);
		em.persist(ven3);
		em.getTransaction().commit();
	}

}
