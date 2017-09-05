package modelo;

import dao.ReviewDao;
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
    @Column(name = "idreview")
    private Integer reviewId;
    
    @Column(length = 150, name = "comment")
    private String comment;
    
    @Column(length = 50, name = "rating")
    private Integer rating;    
    
    
    
// iduser,idgame;
    
    
    
    
    public static void newReview(Game game, User user, int rating, String comment){
    Review r = new Review();
    int temp =1;//id do review, TODO: mudar programaticamente
    r.reviewId=temp;
    r.comment=comment;
    r.rating=rating;
    
    ReviewDao daoReview = new ReviewDao();
        daoReview.inserir(r);
        
    }
    public Review(){
        this.rating = 0;
        this.reviewId = 0;
        this.comment = "Teste";
    }
    
    public Integer getCodigo(){
        return reviewId;
    }

    public void setCodigo(Integer ReviewId) {
        this.reviewId = ReviewId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
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