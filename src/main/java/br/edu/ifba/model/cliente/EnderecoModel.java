package br.edu.ifba.model.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "Endereco")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEndereco;
    private String rua;
    private int numeroCasa;
    private String bairro;
    private String cidade;
    private String estado;

    //* Relação com Cliente */
    @OneToOne(mappedBy = "enderecoCliente")
    private ClienteModel clienteEndereco;

    public EnderecoModel() {}

    public EnderecoModel(int idEndereco, String rua, int numeroCasa, String bairro, String cidade, String estado,
            ClienteModel clienteEndereco) {
        this.idEndereco = idEndereco;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.clienteEndereco = clienteEndereco;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ClienteModel getClienteEndereco() {
        return clienteEndereco;
    }

    public void setClienteEndereco(ClienteModel clienteEndereco) {
        this.clienteEndereco = clienteEndereco;
    }

    @Override
    public String toString() {
        return "EnderecoModel [idEndereco=" + idEndereco + ", rua=" + rua + ", numeroCasa=" + numeroCasa + ", bairro="
                + bairro + ", cidade=" + cidade + ", estado=" + estado + ", clienteEndereco=" + clienteEndereco.getIdCliente() + "]";
    }

}
