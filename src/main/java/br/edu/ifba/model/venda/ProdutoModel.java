package br.edu.ifba.model.venda;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity(name = "Produto")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;
    private String descricaoProduto;
    private int estoqueProduto;
    private double valorProduto;

    //* Relação com Venda */
    @ManyToMany(mappedBy = "produtos")
    private List<VendaModel> vendas = new ArrayList<VendaModel>();

    public ProdutoModel() {}

    public ProdutoModel(int idProduto, String descricaoProduto, int estoqueProduto, double valorProduto) {
        this.idProduto = idProduto;
        this.descricaoProduto = descricaoProduto;
        this.estoqueProduto = estoqueProduto;
        this.valorProduto = valorProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public int getEstoqueProduto() {
        return estoqueProduto;
    }

    public void setEstoqueProduto(int estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public List<VendaModel> getVendas() {
        return vendas;
    }

    public void setVendas(List<VendaModel> vendas) {
        this.vendas = vendas;
    }

    @Override
    public String toString() {
        return "ProdutoModel [idProduto=" + idProduto + ", descricaoProduto=" + descricaoProduto + ", estoqueProduto="
                + estoqueProduto + ", valorProduto=" + valorProduto + "]";
    }

}
