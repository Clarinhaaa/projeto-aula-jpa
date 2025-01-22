package br.edu.ifba.model.venda;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Venda")
public class VendaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenda;

    private String descricaoVenda;

    public VendaModel() {}

    public VendaModel(int idVenda, String descricaoVenda) {
        this.idVenda = idVenda;
        this.descricaoVenda = descricaoVenda;
    }
}
