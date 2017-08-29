package util;

import dao.ReviewDao;
import dao.GameDao;
import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Review;
import modelo.Game;
import modelo.User;
import org.junit.Test;


@ManagedBean

public class JpaUtilTest {
    
    
    public JpaUtilTest() {
    }

    @Test
    public void testeconexao(){
//        Review r = new Review();
//        r.setRating(9);
//        r.setCodigo(1);
//        r.setComment("Muito ruim");
//        ReviewDao daoReview = new ReviewDao();
//        daoReview.inserir(r);
//        

Game g = new Game();
User u = new User();

    Review.newReview(g,u,1,"testehtml123");

//Game g = new Game();
//        g.setName("Nome do Game");
//        g.setTotalFavorite(2);
//        g.setGameId(102);
//        GameDao daoProp = new GameDao();
//        daoProp.inserir(g);
    }
}
