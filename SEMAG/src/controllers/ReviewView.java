package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.ClassDAO;
//import entidades.ItemReview;
import entidades.Jogo;
import entidades.Review;

@ViewScoped
@ManagedBean
public class ReviewView {
	ArrayList<Jogo> aux;
    
	private ClassDAO<Jogo> jogoDao;
	private ArrayList<Jogo> jogos;
	private Jogo jogoSelecionado;
	private Jogo jogoNovo;
        
        
        private ClassDAO<Review> reviewDao;
	private ArrayList<Review> reviews;
        private Review reviewSelecionado;
        private Review reviewNovo;
        
	String nome;
	double total;
        
        

	@PostConstruct
	public void init() {
            
            
		total = 0;
                
		aux = new ClassDAO<Jogo>(Jogo.class).getAll();
                
		nome = "";
                this.reviewSelecionado = new Review();
		this.reviewNovo = new Review();
		this.reviewDao = new ClassDAO<>(Review.class);
		this.reviews = reviewDao.getAll();
        }
        
        public void salvarReview() {
		this.reviewDao.save(reviewNovo);
		this.reviews = reviewDao.getAll();
		this.reviewNovo = new Review();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Review adicionado!", "Review adicionado!"));
	}

	public void mostrar() {
		System.out.println(reviewSelecionado.getId());
	}

	public void editarReview() {
		this.reviewDao.save(reviewSelecionado);
		this.reviews = reviewDao.getAll();
	}

	public void deletarJogo() {
		this.reviewDao.remove(reviewSelecionado.getId());
		this.reviews = reviewDao.getAll();
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}

	public Review getReviewSelecionado() {
		return reviewSelecionado;
	}

	public void setReviewSelecionado(Review reviewSelecionado) {
		this.jogoSelecionado = jogoSelecionado;
	}

	public Review getReviewNovo() {
		return reviewNovo;
	}

	public void setReviewNovo(Review reviewNovo) {
		this.reviewNovo = reviewNovo;
	}



}
