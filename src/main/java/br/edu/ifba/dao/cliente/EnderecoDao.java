package br.edu.ifba.dao.cliente;

import java.util.List;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.dao.InterfaceDao;
import br.edu.ifba.model.cliente.EnderecoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class EnderecoDao implements InterfaceDao<EnderecoModel> {
    EntityManager em = GetEntityManager.getConnectionJpa();

    public void insert(EnderecoModel end) {
        em.getTransaction().begin();
        em.persist(end);
        em.getTransaction().commit();
    }

    public List<EnderecoModel> getAll() {
        return em.createQuery("SELECT e FROM Endereco e", EnderecoModel.class).getResultList();
    }

    public EnderecoModel getById(int id) {
        return em.find(EnderecoModel.class, id);
    }

    public List<EnderecoModel> getByBairro(String bairroEnd) {
        TypedQuery<EnderecoModel> query = em.createQuery("SELECT e FROM Endereco e WHERE e.bairro = :bairro",
                EnderecoModel.class);
        query.setParameter("bairro", bairroEnd);
        return query.getResultList();
    }

    public List<EnderecoModel> getByCidade(String cidadeEnd) {
        TypedQuery<EnderecoModel> query = em.createQuery("SELECT e FROM Endereco e WHERE e.cidade = :cidade",
                EnderecoModel.class);
        query.setParameter("cidade", cidadeEnd);
        return query.getResultList();
    }

    public List<EnderecoModel> getByEstado(String estadoEnd) {
        TypedQuery<EnderecoModel> query = em.createQuery("SELECT e FROM Endereco e WHERE e.estado = :estado",
                EnderecoModel.class);
        query.setParameter("estado", estadoEnd);
        return query.getResultList();
    }

    public EnderecoModel getByCliente(int idCli) {
        TypedQuery<EnderecoModel> query = em.createQuery(
                "SELECT e FROM Endereco e JOIN e.clienteEndereco WHERE e.clienteEndereco.idCliente = :id",
                EnderecoModel.class);
        query.setParameter("id", idCli);
        return query.getSingleResult();
    }

    public void update(EnderecoModel end) {
        em.getTransaction().begin();
        em.merge(end);
        em.getTransaction().commit();
    }

    public void remove(EnderecoModel end) {
        em.getTransaction().begin();
        em.remove(end);
        em.getTransaction().commit();
    }
}
