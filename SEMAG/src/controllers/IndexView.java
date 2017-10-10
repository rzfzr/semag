package controllers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import dao.ClassDAO;
import entidades.Usuario;

@ApplicationScoped
@ManagedBean
public class IndexView {
	
	ClassDAO<Usuario> usuariod;
	ArrayList<Usuario> usuarios;
	static Usuario usuario;
	String login;
	String senha;
	
	@PostConstruct
	public void init(){
		usuariod = new ClassDAO<>(Usuario.class);
		usuarios = usuariod.getAll();
		login = "";
		senha = "";
		usuario = new Usuario();
	}

	public String logar(){
		System.out.println(usuarios.size());
		if(usuarios.isEmpty()){
			Usuario usuario = new Usuario();
			usuario.setLogin("admin");
			usuario.setSenha("admin");
			usuario.setPermissao(1);
			usuario.setNome("Administrador");
			usuarios.add(usuario);
		}
		for(Usuario usuario : usuarios){
			if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
				IndexView.usuario = usuario;
				return "/jogos.xhtml";
			}
		}
		return "";
		
	}
	
	public static Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		IndexView.usuario = usuario;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
