package br.edu.ifba.dao.cliente;

import java.util.List;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.dao.InterfaceDao;
import br.edu.ifba.model.cliente.CategoriaModel;
import jakarta.persistence.EntityManager;

public class CategoriaDao implements InterfaceDao<CategoriaModel> {
    EntityManager em = GetEntityManager.getConnectionJpa();

    public void insert(CategoriaModel cat) {
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }

    public List<CategoriaModel> getAll() {
        return em.createQuery("SELECT c FROM Categoria c", CategoriaModel.class).getResultList();
    }

    public CategoriaModel getById(int id) {
        return em.find(CategoriaModel.class, id);
    }

    public void update(CategoriaModel cat) {
        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();
    }

    public void remove(CategoriaModel cat) {
        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();
    }
}
