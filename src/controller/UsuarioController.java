package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class UsuarioController {

	public static void main(String[] args) {


		Usuario newUsuario = new Usuario();
		newUsuario.setUsuario("Alessandra");
		
		newUsuario.setSenha("159159");
		
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FinanceiroUnit"); 
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(newUsuario);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
	}

}
