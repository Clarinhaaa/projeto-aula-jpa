package br.edu.ifba.model.venda;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.model.cliente.ClienteModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity(name = "Venda")
public class VendaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenda;
    private String descricaoVenda;

    //* Relação com Produto */
    @ManyToMany
    @JoinTable(
        name = "ItensVendas",
        joinColumns = @JoinColumn(name = "idVendas"),
        inverseJoinColumns = @JoinColumn(name = "idProdutos"))
    private List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();

    //* Relação com Cliente */
    @ManyToOne
    @JoinColumn(name = "fkIdCliente", nullable = false)
    private ClienteModel clienteVenda;

    public VendaModel() {}

    public VendaModel(int idVenda, String descricaoVenda, ClienteModel clienteVenda) {
        this.idVenda = idVenda;
        this.descricaoVenda = descricaoVenda;
        this.clienteVenda = clienteVenda;
    }

    //* addProduto */
    public void addProduto(ProdutoModel pro) {
        produtos.add(pro);
        pro.getVendas().add(this);
    }

    //* removeProduto */
    public void removeProduto(ProdutoModel pro) {
        produtos.remove(pro);
        pro.getVendas().remove(this);
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getDescricaoVenda() {
        return descricaoVenda;
    }

    public void setDescricaoVenda(String descricaoVenda) {
        this.descricaoVenda = descricaoVenda;
    }

    public ClienteModel getClienteVenda() {
        return clienteVenda;
    }

    public void setClienteVenda(ClienteModel clienteVenda) {
        this.clienteVenda = clienteVenda;
    }

    public List<ProdutoModel> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoModel> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "VendaModel [idVenda=" + idVenda + ", descricaoVenda=" + descricaoVenda + ", produtos=" + produtos
                + ", clienteVenda=" + clienteVenda.getIdCliente() + "]";
    }

}
