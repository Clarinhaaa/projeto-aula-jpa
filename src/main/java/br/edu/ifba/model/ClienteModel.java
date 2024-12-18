package br.edu.ifba.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "Cliente")
public class ClienteModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    private String nomeCliente;
    private String cpfCliente;
    private String rgCliente;

    @ManyToOne
    @JoinColumn(name = "fkIdCategoria", nullable = false)
    private CategoriaModel categoriaCliente;

    

    public ClienteModel() {}

    public ClienteModel(int idCliente, String nomeCliente, String cpfCliente, String rgCliente,
            CategoriaModel categoriaCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.rgCliente = rgCliente;
        this.categoriaCliente = categoriaCliente;
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

    @Override
    public String toString() {
        return "ClienteModel [id=" + idCliente + ", nome=" + nomeCliente + ", cpf=" + cpfCliente
                + ", rg=" + rgCliente + ", categoria=" + categoriaCliente.getNomeCategoria() + "]";
    }
    
}
