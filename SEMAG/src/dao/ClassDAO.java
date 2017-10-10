package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClassDAO<T> {
	static EntityManagerFactory emf;
    static EntityManager em;
    Class<T> typeClass;
    
    public ClassDAO(Class<T> typeClass){
    	emf = null;
    	em = null;
    	this.typeClass = typeClass;
    }
    
    public static void abrirConexao() {
        emf = Persistence.createEntityManagerFactory("mohr");
        em = emf.createEntityManager();
    }
    
    public T get(int id){
    	abrirConexao();
    	T t = em.find(typeClass, id);
    	emf.close();
    	return t;
    }
    
    public ArrayList<T> getAll(){
    	abrirConexao();
    	em.getTransaction().begin();
    	String classe = typeClass.getTypeName().substring(typeClass.getTypeName().lastIndexOf(".")+1);
    	String hql = "select "  + classe.toLowerCase() + " from " + classe + " " + classe.toLowerCase();
    	Query consulta = em.createQuery(hql);
    	@SuppressWarnings("unchecked")
		List<T> ts = consulta.getResultList();
    	ArrayList<T> arrayT = new ArrayList<>(ts);
    	em.getTransaction().commit();
    	emf.close();
    	return arrayT;
    }
    
    public T getLast(){
    	abrirConexao();
    	em.getTransaction().begin();
    	String classe = typeClass.getTypeName().substring(typeClass.getTypeName().lastIndexOf(".")+1);
    	String hql = "select "  + classe.toLowerCase() + " from " + classe + " " + classe.toLowerCase();
    	Query consulta = em.createQuery(hql);
    	@SuppressWarnings("unchecked")
		List<T> ts = consulta.getResultList();
    	ArrayList<T> arrayT = new ArrayList<>(ts);
    	em.getTransaction().commit();
    	emf.close();
    	return arrayT.get(arrayT.size()-1);
    }
    
    public void save(T t){
    	abrirConexao();
    	em.getTransaction().begin();
    	em.merge(t);
    	em.getTransaction().commit();
    	emf.close();
    }
    
    public void remove(int id){
    	abrirConexao();
    	em.getTransaction().begin();
    	em.remove(em.getReference(typeClass, id));
    	em.getTransaction().commit();
    	emf.close();
    }
}