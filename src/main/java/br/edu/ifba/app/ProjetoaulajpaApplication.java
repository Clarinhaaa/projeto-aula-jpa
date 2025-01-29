package br.edu.ifba.app;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifba.dao.ClienteDao;
import br.edu.ifba.dao.GetEntityManager;
import jakarta.persistence.EntityManager;

@SpringBootApplication
public class ProjetoaulajpaApplication {
	public static void main(String[] args) {
		// SpringApplication.run(ProjetoaulajpaApplication.class, args);

		//EntityManager em = GetEntityManager.getConnectionJpa();

		ClienteDao cliDao = new ClienteDao();

		System.out.println("TODOS OS CLIENTES:");
		cliDao.getAllClientes().forEach(System.out::println);
		System.out.println();
		
		System.out.println("CLIENTE POR ID:");
		System.out.println(cliDao.getClienteById(3));
		System.out.println();

		System.out.println("CLIENTES POR CATEGORIA:");
		cliDao.getClienteByCategoria(2).forEach(System.out::println);
		System.out.println();
	}
}
