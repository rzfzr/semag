package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ReviewTable")

public class Review implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedico")
    private Integer reviewId;
    
    @Column(length = 150, name = "crmv")
    private Integer comment;
    
    @Column(length = 50, name = "nome")
    private Integer rating;    
    
    //int iduser,idgame
    
//    
//    public void newReview(Game game, User user, int nota, String comment){
//    Review r = new Review();
//    int temp=1;
//    
//    r.id = temp;
//    r.idGame=game.id;
//    r.idUser= user.id;
//    user.review[temp]=r.id;
//    game.review[temp]=r.id;
//    r.nota= nota;
//    r.comment=comment;
//}
    public Review(){
        this.rating = 0;
        this.reviewId = 0;
        this.comment = 2;
    }
    
    public Integer getCodigo(){
        return reviewId;
    }

    public void setCodigo(Integer ReviewId) {
        this.reviewId = ReviewId;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment= comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.getCodigo());
        hash = 43 * hash + Objects.hashCode(this.getComment());
        hash = 43 * hash + Objects.hashCode(this.getRating());
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        return true;
    }    
}