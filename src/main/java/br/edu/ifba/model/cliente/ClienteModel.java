package br.edu.ifba.model.cliente;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import br.edu.ifba.model.venda.VendaModel;

@Entity(name = "Cliente")
public class ClienteModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nomeCliente;
    private String cpfCliente;
    private String rgCliente;

    //* Relação com Categoria */
    @ManyToOne
    @JoinColumn(name = "fkIdCategoria", nullable = false)
    private CategoriaModel categoriaCliente;

    //* Relação com Endereço */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fkIdEndereco", nullable = false)
    private EnderecoModel enderecoCliente;

    //* Relação com Venda */
    @OneToMany(mappedBy = "clienteVenda", cascade = CascadeType.ALL)
    private List<VendaModel> vendasCliente;

    public ClienteModel() {}

    public ClienteModel(int idCliente, String nomeCliente, String cpfCliente, String rgCliente,
            CategoriaModel categoriaCliente, EnderecoModel enderecoCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.rgCliente = rgCliente;
        this.categoriaCliente = categoriaCliente;
        this.enderecoCliente = enderecoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(String rgCliente) {
        this.rgCliente = rgCliente;
    }

    public CategoriaModel getCategoriaCliente() {
        return categoriaCliente;
    }

    public void setCategoriaCliente(CategoriaModel categoriaCliente) {
        this.categoriaCliente = categoriaCliente;
    }

    public EnderecoModel getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(EnderecoModel enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    @Override
    public String toString() {
        return "ClienteModel [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", cpfCliente=" + cpfCliente
                + ", rgCliente=" + rgCliente + ", categoriaCliente=" + categoriaCliente.getIdCategoria() + ", enderecoCliente="
                + enderecoCliente.getIdEndereco() + "]";
    }
    
}
