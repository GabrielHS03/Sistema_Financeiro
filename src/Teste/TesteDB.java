/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;

/**
 *
 * @author Alyson-Casa
 */
public class TesteDB {
    public static void main(String[] args) {
        Usuario user = new Usuario();
        user.setLogin("Alyson");
        user.setSenha("1587");
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("FinanceiroUnit");
        EntityManager entityManager = factory.createEntityManager();
        
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        
        
        entityManager.close();  
        
    }
    
}
