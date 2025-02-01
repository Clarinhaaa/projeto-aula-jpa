package br.edu.ifba.app;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifba.dao.cliente.*;
import br.edu.ifba.dao.venda.*;
import br.edu.ifba.model.cliente.*;
import br.edu.ifba.model.venda.*;

@SpringBootApplication
public class ProjetoaulajpaApplication {
	public static void main(String[] args) {
		// SpringApplication.run(ProjetoaulajpaApplication.class, args);

		ProdutoDao proDao = new ProdutoDao();

		System.out.println("PRODUTOS PELA VENDA:");
		proDao.getByVenda(7).forEach(System.out::println);
	}
}
