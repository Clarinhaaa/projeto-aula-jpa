package br.edu.ifba.projetoaulajpa;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.model.CategoriaModel;
import br.edu.ifba.model.ClienteModel;
import jakarta.persistence.EntityManager;

@SpringBootApplication
public class ProjetoaulajpaApplication {

	public static void main(String[] args) {
		// SpringApplication.run(ProjetoaulajpaApplication.class, args);

		EntityManager em = GetEntityManager.getConnectionJpa();

		ClienteModel cli = new ClienteModel();
		cli.setNomeCliente("Ana Clara");
		cli.setCpfCliente("1234567890");
		cli.setRgCliente("12345678");
		cli.setCategoriaCliente(em.find(CategoriaModel.class, 1));

		em.getTransaction().begin();
		em.persist(cli);
		em.getTransaction().commit();
	}

}
