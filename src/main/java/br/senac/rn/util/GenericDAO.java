package br.senac.rn.util;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Criteria;

public abstract class GenericDAO<T> {

    protected static EntityManager manager;

    public abstract Class<T> getClassType();

    public EntityManager getEntiManger() {
        if (manager == null || !manager.isOpen()) {
            manager = DataBase.getInstance().getEntiManger();
        }
        return manager;
    }

    public T insert(T t) {
        try {
            getEntiManger().getTransaction().begin();
            getEntiManger().persist(t);
            getEntiManger().getTransaction().commit();
        } catch (Exception error) {
            error.printStackTrace();
            getEntiManger().getTransaction().rollback();
        }
        return t;
    }
    
    public T delete(T t) {
        try {
            getEntiManger().getTransaction().begin();
            getEntiManger().remove(t);
            getEntiManger().getTransaction().commit();
        } catch (Exception error) {
            error.printStackTrace();
            getEntiManger().getTransaction().rollback();
        }
        return t;
    }
    
    public T atualizar(T t) {
        try {
            getEntiManger().getTransaction().begin();
            getEntiManger().merge(t);
            getEntiManger().getTransaction().commit();
        } catch (Exception error) {
            error.printStackTrace();
            getEntiManger().getTransaction().rollback();  // rollback serve para desfazer erros, só funciona para inserir, atualizar e deletar;
        }
        return t;
    }
    
    public T selectById(int id){
        EntityManager em = getEntiManger();
        return em.find(getClassType(), id);
    }
    
    public List<T> selectAll(){
        EntityManager em = getEntiManger();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getClassType());
        TypedQuery<T> typedQuery = em.createQuery(query.select(query.from(getClassType())));
        return typedQuery.getResultList();
    }
}
