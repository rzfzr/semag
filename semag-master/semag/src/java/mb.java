
  
import dao.*;
import java.util.ArrayList;
import java.util.List;   
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.*;
   
@ManagedBean(name="MedicoMB")
@SessionScoped
public class mb {
    private static final long serialVersionUID = 8103328274400432976L;
    private Review r;
    private List<Review> lista = new ArrayList<>();
 
    ReviewDao dao = new ReviewDao();
 
    public mb() {
        r = new Review();
        listar();
    }
    
    public void newReview(){
        
        System.out.println("funcionando");
//        Review.newReview(game, user, rating, comment);
Game g = new Game();
User u = new User();

    Review.newReview(g,u,9,"testehtml");
    }
 
    public void alterar() {
	System.out.println("Alterar medico");
	dao.alterar(r);
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Manutenção de usuário: ",
		"Usuario alterado com sucesso!"));
    }
 
    public void consultar() {
	long matriculaConsulta = r.getCodigo();
	System.out.println("Consultar");
	r = dao.buscarPorCodigo((int) matriculaConsulta);
	if (r == null || r.getCodigo()== 0) {
            FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR,
		"Manutenção de usuário: ",
		"Usuario não encontrado matrícula:" + matriculaConsulta + "!"));
	}
	listar();
    }
 
    public void excluir() {
        System.out.println("Excluir aluno");
	dao.excluir(r);
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
		"Manutenção de usuário: ",
		"Usuario excluído com sucesso!"));
    }
 
    public Review getMedico() {
        return r;
    }
 
    public List<Review> getLista() {
	return lista;
    }
 
    public void incluir() {
	System.out.println("Incluir medico");
	dao.inserir(r);
	listar();
	FacesContext.getCurrentInstance().addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,
		"Manutenção de usuário: ",
		"Usuario incluido com sucesso!"));
    }
 
    public void limpar() {
	System.out.println("Limpar");
	System.out.println(r);
	r = new Review();
    }
 
    public void listar() {
	System.out.println("Listar aluno");
        lista = dao.listarTodos();
    }
// 
//    public void setMedico(Review med) {
//        this.r = med;
//    }
// 
//    public void setLista(List<Medico> lista) {
//        this.lista = lista;
//    }
}