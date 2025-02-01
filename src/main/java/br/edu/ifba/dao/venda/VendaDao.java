package br.edu.ifba.dao.venda;

import java.util.List;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.dao.InterfaceDao;
import br.edu.ifba.model.venda.VendaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class VendaDao implements InterfaceDao<VendaModel> {
    EntityManager em = GetEntityManager.getConnectionJpa();

    public void insert(VendaModel ven) {
        em.getTransaction().begin();
        em.persist(ven);
        em.getTransaction().commit();
    }

    public List<VendaModel> getAll() {
        return em.createQuery("SELECT v FROM Venda v", VendaModel.class).getResultList();
    }

    public VendaModel getById(int id) {
        return em.find(VendaModel.class, id);
    }

    public List<VendaModel> getByCliente(int idCli) {
        TypedQuery<VendaModel> query = em.createQuery(
                "SELECT v FROM Venda v JOIN v.clienteVenda WHERE v.clienteVenda.idCliente = :id", VendaModel.class);
        query.setParameter("id", idCli);
        return query.getResultList();
    }

    public void update(VendaModel ven) {
        em.getTransaction().begin();
        em.merge(ven);
        em.getTransaction().commit();
    }

    public void remove(VendaModel ven) {
        em.getTransaction().begin();
        em.remove(ven);
        em.getTransaction().commit();
    }
}
