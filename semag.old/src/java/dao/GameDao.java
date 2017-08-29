
package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import modelo.Game;
import util.JpaUtil;


public class GameDao implements Serializable {
    EntityManager manager;
    
    public boolean inserir(Game game){
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(game);
        tx.commit();
        manager.close();
        return true;
    }
        
    
}
