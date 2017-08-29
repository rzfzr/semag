package util;

import dao.ReviewDao;
import dao.GameDao;
import modelo.Review;
import modelo.Game;
import org.junit.Test;

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
