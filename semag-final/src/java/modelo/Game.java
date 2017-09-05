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
@Table(name = "GameTable")

public class Game implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameId")
    private Integer gameId;
    
    @Column(length = 14, name = "totalFavorite")
    private Integer totalFavorite;
    
    @Column(length = 150, name = "name")
    private String name;
    
//string description
    //totalplayed
    //intreview[]
    
    public Game(){
        this.gameId = 0;
        this.totalFavorite = 0;
        this.name = "";
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getTotalFavorite() {
        return totalFavorite;
    }

    public void setTotalFavorite(Integer totalFavorite) {
        this.totalFavorite = totalFavorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String Nome) {
        this.name = Nome;
    }


    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.getGameId());
        hash = 43 * hash + Objects.hashCode(this.getName());
        hash = 43 * hash + Objects.hashCode(this.getTotalFavorite());
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
