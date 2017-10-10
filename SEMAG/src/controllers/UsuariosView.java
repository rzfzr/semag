package controllers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.ClassDAO;
import entidades.Usuario;

@ManagedBean
@ViewScoped
public class UsuariosView {
	private ArrayList<Usuario> usuarios;
	private Usuario usuarioSelecionado;
	private Usuario usuarioNovo;
	private ClassDAO<Usuario> dao;
	
	@PostConstruct
	public void init(){
		dao = new ClassDAO<>(Usuario.class);
		usuarios = dao.getAll();
		usuarioSelecionado = new Usuario();
		usuarioNovo = new Usuario();
	}
	
	public void salvarUsuario(){
		if(IndexView.getUsuario().getPermissao()==1){
			dao = new ClassDAO<>(Usuario.class);
			dao.save(usuarioNovo);
			usuarioNovo = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario adicionado!", "Usuario adicionado!"));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Voc� n�o tem permiss�o para isso.", "Voc� n�o tem permiss�o para isso."));
		}
	}
	
	public void mostrar(){
		System.out.println("teste");
		System.out.println(usuarioSelecionado.getNome());
	}
	
	public void editarUsuario(){
		dao.save(usuarioSelecionado);
		usuarios = dao.getAll();
	}
	
	public void deletarUsuario(){
		dao.remove(usuarioSelecionado.getId());
		usuarios = dao.getAll();
	}
	
	public Usuario getUsuarioNovo() {
		return usuarioNovo;
	}

	public void setUsuarioNovo(Usuario usuarioNovo) {
		this.usuarioNovo = usuarioNovo;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
}
