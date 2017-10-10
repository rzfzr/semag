package controllers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.ClassDAO;
import entidades.Jogo;

@ManagedBean
@ViewScoped
public class JogosView {
	private ClassDAO<Jogo> jogoDao;
	private ArrayList<Jogo> jogos;
	private Jogo jogoSelecionado;
	private Jogo jogoNovo;

	@PostConstruct
	public void init() {
		this.jogoSelecionado = new Jogo();
		this.jogoNovo = new Jogo();
		this.jogoDao = new ClassDAO<>(Jogo.class);
		this.jogos = jogoDao.getAll();
	}

	public void salvarJogo() {
		this.jogoDao.save(jogoNovo);
		this.jogos = jogoDao.getAll();
		this.jogoNovo = new Jogo();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Jogo adicionado!", "Jogo adicionado!"));
	}

	public void mostrar() {
		System.out.println(jogoSelecionado.getNome());
	}

	public void editarJogo() {
		this.jogoDao.save(jogoSelecionado);
		this.jogos = jogoDao.getAll();
	}

	public void deletarJogo() {
		this.jogoDao.remove(jogoSelecionado.getId());
		this.jogos = jogoDao.getAll();
	}

	public ArrayList<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(ArrayList<Jogo> jogos) {
		this.jogos = jogos;
	}

	public Jogo getJogoSelecionado() {
		return jogoSelecionado;
	}

	public void setJogoSelecionado(Jogo jogoSelecionado) {
		this.jogoSelecionado = jogoSelecionado;
	}

	public Jogo getJogoNovo() {
		return jogoNovo;
	}

	public void setJogoNovo(Jogo jogoNovo) {
		this.jogoNovo = jogoNovo;
	}
}
