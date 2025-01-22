package br.edu.ifba.model.venda;

import jakarta.persistence.Entity;

@Entity(name = "ItensVenda")
public class ItensVendaModel {
    private ProdutoModel produto;
    private VendaModel venda;
}
