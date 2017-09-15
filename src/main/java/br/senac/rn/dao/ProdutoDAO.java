package br.senac.rn.dao;

import br.senac.rn.model.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class ProdutoDAO {
    
    private EntityManager manager;
    private EntityManagerFactory factory;

    public ProdutoDAO() {
        factory = Persistence.createEntityManagerFactory("ConexaoDB");
        manager = factory.createEntityManager();
    }
    
    public void inserir(Produto prod) {
        manager.getTransaction().begin();
        manager.persist(prod); //INSERIR
        manager.getTransaction().commit();
    }
    
    public void excluir(Produto prod) {
        manager.getTransaction().begin();
        manager.remove(prod); //EXCLUIR
        manager.getTransaction().commit();
    }
    
    public void atualizar(Produto prod) {
        manager.getTransaction().begin();
        manager.merge(prod); //ATUALIZAR
        manager.getTransaction().commit();
    }
    
    public List<Produto> buscarTodos() {
        TypedQuery<Produto> consulta = manager.createQuery("SELECT p FROM tb_produto p", Produto.class);
        return consulta.getResultList();
    }
    
    public Produto buscarPorId(int id) {
        return manager.find(Produto.class, id);
    }
    
}
