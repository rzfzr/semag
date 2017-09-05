/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.ReviewDao;
import modelo.Review;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rzfzr
 */
public class JpaUtilTest {
    
    public JpaUtilTest() {
    }

        @Test
    public void testeconexao(){
        Review r = new Review();
        r.setRating(9);
        r.setCodigo(1);
//        r.setComment("Muito ruim");
        ReviewDao daoReview = new ReviewDao();
        daoReview.inserir(r);
        
//        Game g = new Game();
//        g.setName("Nome do Game");
//        g.setTotalFavorite(2);
//        g.setGameId(102);
//        GameDao daoProp = new GameDao();
//        daoProp.inserir(g);
    }
}
