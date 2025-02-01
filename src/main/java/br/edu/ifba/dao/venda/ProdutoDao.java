package br.edu.ifba.dao.venda;

import java.util.List;

import br.edu.ifba.dao.GetEntityManager;
import br.edu.ifba.dao.InterfaceDao;
import br.edu.ifba.model.venda.ProdutoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ProdutoDao implements InterfaceDao<ProdutoModel> {
    EntityManager em = GetEntityManager.getConnectionJpa();

    public void insert(ProdutoModel pro) {
        em.getTransaction().begin();
        em.persist(pro);
        em.getTransaction().commit();
    }

    public List<ProdutoModel> getAll() {
        return em.createQuery("SELECT p FROM Produto p", ProdutoModel.class).getResultList();
    }

    public ProdutoModel getById(int id) {
        return em.find(ProdutoModel.class, id);
    }

    public List<ProdutoModel> getByVenda(int idVen) {
        TypedQuery<ProdutoModel> query = em.createQuery(
                "SELECT v.produtos from Venda v WHERE v.idVenda = :id",
                ProdutoModel.class);
        query.setParameter("id", idVen);
        return query.getResultList();
    }

    public void update(ProdutoModel pro) {
        em.getTransaction().begin();
        em.merge(pro);
        em.getTransaction().commit();
    }

    public void remove(ProdutoModel pro) {
        em.getTransaction().begin();
        em.remove(pro);
        em.getTransaction().commit();
    }
}
