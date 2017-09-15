package br.senac.rn.dao;

import br.senac.rn.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class ClienteDAO {
    
     private EntityManager manager;
     private EntityManagerFactory factory;

    public ClienteDAO() {
        factory = Persistence.createEntityManagerFactory("ConexaoDB");
        manager = factory.createEntityManager();
    }
    
    public void inserir(Cliente cli) {
        manager.getTransaction().begin();
        manager.persist(cli); //INSERIR
        manager.getTransaction().commit();
    }
    
    public void excluir(Cliente cli) {
        manager.getTransaction().begin();
        manager.remove(cli); //EXCLUIR
        manager.getTransaction().commit();
    }
    
    public void atualizar(Cliente cli) {
        manager.getTransaction().begin();
        manager.merge(cli); //ATUALIZAR
        manager.getTransaction().commit();
    }
    
    public List<Cliente> buscarTodos() {
        TypedQuery<Cliente> consulta = manager.createQuery("SELECT cli FROM tb_clientes cli", Cliente.class);
        return consulta.getResultList();
    }
    
    public Cliente  buscarPorId(int id) {
        return manager.find(Cliente.class, id);
    }
    
}

