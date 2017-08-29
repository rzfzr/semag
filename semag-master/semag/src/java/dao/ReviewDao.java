package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Review;
import util.JpaUtil;

public class ReviewDao implements Serializable {
    EntityManager manager;
    
    public boolean alterar(Review r){
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(r);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
    
    public Review buscarPorCodigo(int cod){
        manager = JpaUtil.getEntityManager();
        Review r = manager.find(Review.class, cod);
        manager.close();
        return r;
    }
        
    public boolean excluir(Review r){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        // recupera a referência ao objeto
        Review temp = manager.find(Review.class, r.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }
    
    public boolean inserir(Review r){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(r);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Review> listarTodos(){
        manager = JpaUtil.getEntityManager();
        CriteriaQuery<Review> query = manager.getCriteriaBuilder().createQuery(Review.class);
        query.select(query.from(Review.class));
        List<Review> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }
 
}