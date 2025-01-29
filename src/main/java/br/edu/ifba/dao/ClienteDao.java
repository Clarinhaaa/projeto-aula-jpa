package br.edu.ifba.dao;

import java.util.List;

import br.edu.ifba.model.cliente.ClienteModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ClienteDao {
    EntityManager em = GetEntityManager.getConnectionJpa();

    public void insertCliente(ClienteModel cli) {
        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();
    }

    public ClienteModel getClienteById(int id) {
        return em.find(ClienteModel.class, id);
    }
    
    public List<ClienteModel> getClienteByNome(String nomeCli) {
        TypedQuery<ClienteModel> query = em.createQuery("SELECT c FROM Cliente c WHERE c.nomeCliente = :nome", ClienteModel.class);
        query.setParameter("nome", nomeCli);
        return query.getResultList();
    }

    public List<ClienteModel> getClienteByCategoria(int idCat) {
        TypedQuery<ClienteModel> query = em.createQuery("SELECT c FROM Cliente c JOIN c.categoriaCliente WHERE c.categoriaCliente.idCategoria = :id", ClienteModel.class);
        query.setParameter("id", idCat);
        return query.getResultList();
    }

    /* public CategoriaModel getCategoriaByIdCliente(int idCli) {
        TypedQuery<ClienteModel> query = em.createQuery("SELECT c FROM Cliente c JOIN c.categoriaCliente WHERE c.idCliente = :id", ClienteModel.class);
        query.setParameter("id", idCli);
        return query.getSingleResult().getCategoriaCliente();
    } */

    public void updateCliente(ClienteModel cli) {
        em.getTransaction().begin();
        em.merge(cli);
        em.getTransaction().commit();
    }

    public void removeCliente(ClienteModel cli) {
        em.getTransaction().begin();
        em.remove(cli);
        em.getTransaction().commit();
    }

    public List<ClienteModel> getAllClientes() {
        return em.createQuery("SELECT c FROM Cliente c", ClienteModel.class).getResultList();
    }
}
