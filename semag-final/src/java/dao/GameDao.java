package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Game;
import util.JpaUtil;

public class GameDao implements Serializable {
    EntityManager manager;
    
    public boolean alterar(Game g){
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(g);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
    
    public Game buscarPorCodigo(int cod){
        manager = JpaUtil.getEntityManager();
        Game g = manager.find(Game.class, cod);
        manager.close();
        return g;
    }
        
    public boolean excluir(Game g){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        // recupera a referência ao objeto
        Game temp = manager.find(Game.class, g.getGameId());
        manager.remove(temp);
        tx.commit();
        manager.close();
        return true;
    }
    
    public boolean inserir(Game g){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(g);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Game> listarTodos(){
        manager = JpaUtil.getEntityManager();
        CriteriaQuery<Game> query = manager.getCriteriaBuilder().createQuery(Game.class);
        query.select(query.from(Game.class));
        List<Game> lista = manager.createQuery(query).getResultList();
        manager.close();
        return lista;
    }
}