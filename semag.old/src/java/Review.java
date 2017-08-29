/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rzfzr
 */

public class Review {
    int id;
    int nota;
    String comment;
    int idUser;
    int idGame;
    

public void newReview(Game game, User user, int nota, String comment){
    Review r = new Review();
    int temp=1;
    
    r.id = temp;
    r.idGame=game.id;
    r.idUser= user.id;
    user.review[temp]=r.id;
    game.review[temp]=r.id;
    r.nota= nota;
    r.comment=comment;
}

}