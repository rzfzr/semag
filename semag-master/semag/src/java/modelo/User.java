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
@Table(name = "UserTable")

public class User implements Serializable {
    
    
    //id,username,password, []favorites[]wishlist[]played[]review[]
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserTable")
    private Integer userId;
    
    @Column(length = 14, name = "CPF")
    private Integer CPF;
    // CPF = LOGIN
    
    @Column(length = 100, name ="Senha")
    private String Senha; 
            
    @Column(length = 150, name = "Nome")
    private String Nome;
    
    public User() {
        this.userId = 0;
        this.CPF = 0;
        this.Nome = "";
        this.Senha = "";
    }

    public Integer getCodigo() {
        return userId;
    }

    public void setCodigo(Integer IdFuncionario) {
        this.userId = IdFuncionario;
    }

    public Integer getCPF() {
        return CPF;
    }

    public void setCPF(Integer CPF) {
        this.CPF = CPF;
    }
    
    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getNome() {
        return Nome;
    }
  
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.getCodigo());
        hash = 43 * hash + Objects.hashCode(this.getNome());
        hash = 43 * hash + Objects.hashCode(this.getCPF());
        hash = 43 * hash + Objects.hashCode(this.getSenha());
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
