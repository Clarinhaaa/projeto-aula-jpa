package br.edu.ifba.dao.cliente;

import java.util.List;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.dao.InterfaceDao;
import br.edu.ifba.model.cliente.ClienteModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ClienteDao implements InterfaceDao<ClienteModel> {
    EntityManager em = GetEntityManager.getConnectionJpa();

    public void insert(ClienteModel cli) {
        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();
    }

    public List<ClienteModel> getAll() {
        return em.createQuery("SELECT c FROM Cliente c", ClienteModel.class).getResultList();
    }

    public ClienteModel getById(int id) {
        return em.find(ClienteModel.class, id);
    }
    
    public List<ClienteModel> getByNome(String nomeCli) {
        TypedQuery<ClienteModel> query = em.createQuery("SELECT c FROM Cliente c WHERE c.nomeCliente = :nome", ClienteModel.class);
        query.setParameter("nome", nomeCli);
        return query.getResultList();
    }

    public List<ClienteModel> getByCategoria(int idCat) {
        TypedQuery<ClienteModel> query = em.createQuery("SELECT c FROM Cliente c JOIN c.categoriaCliente WHERE c.categoriaCliente.idCategoria = :id", ClienteModel.class);
        query.setParameter("id", idCat);
        return query.getResultList();
    }

    public void update(ClienteModel cli) {
        em.getTransaction().begin();
        em.merge(cli);
        em.getTransaction().commit();
    }

    public void remove(ClienteModel cli) {
        em.getTransaction().begin();
        em.remove(cli);
        em.getTransaction().commit();
    }
}
