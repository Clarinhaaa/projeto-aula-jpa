package br.edu.ifba.projetoaulajpa;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.model.cliente.CategoriaModel;
import br.edu.ifba.model.cliente.ClienteModel;
import br.edu.ifba.model.cliente.EnderecoModel;
import jakarta.persistence.EntityManager;

@SpringBootApplication
public class ProjetoaulajpaApplication {

	public static void main(String[] args) {
		// SpringApplication.run(ProjetoaulajpaApplication.class, args);

		EntityManager em = GetEntityManager.getConnectionJpa();

		/* ClienteModel cli = new ClienteModel();
		cli.setNomeCliente("Vinícius");
		cli.setCpfCliente("87545412396");
		cli.setRgCliente("32541578");
		cli.setCategoriaCliente(em.find(CategoriaModel.class, 1));

		em.getTransaction().begin();
		em.persist(cli);
		em.getTransaction().commit(); */
	}

}
