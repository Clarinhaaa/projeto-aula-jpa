package br.edu.ifba.app;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifba.dao.cliente.*;
/* import br.edu.ifba.dao.GetEntityManager;
import jakarta.persistence.EntityManager; */

@SpringBootApplication
public class ProjetoaulajpaApplication {
	public static void main(String[] args) {
		// SpringApplication.run(ProjetoaulajpaApplication.class, args);

		//EntityManager em = GetEntityManager.getConnectionJpa();

		ClienteDao cliDao = new ClienteDao();
		EnderecoDao endDao = new EnderecoDao();

		System.out.println("TODOS OS CLIENTES:");
		cliDao.getAll().forEach(System.out::println);
		System.out.println();

		System.out.println("TODOS OS ENDEREÇOS:");
		endDao.getAll().forEach(System.out::println);
		System.out.println();

		System.out.println("ENDEREÇO POR BAIRRO:");
		System.out.println(endDao.getByBairro("caminho dos lagos"));
		System.out.println();
	}
}
