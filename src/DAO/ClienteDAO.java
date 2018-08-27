/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.ConnectionFactory;
import javax.persistence.EntityManager;
import model.Cliente;

/**
 *
 * @author Alyson-Casa
 */
public class ClienteDAO {

    public Cliente save(Cliente cliente) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
                
            
            
        } catch (Exception e) {
            System.out.println(e);
            entityManager.getTransaction().rollback();
        }finally{
            entityManager.close();
        }
        return cliente;
    }
}
