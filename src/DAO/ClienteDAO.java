/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import model.Cliente;

/**
 *
 * @author Alyson-Casa
 */
public class ClienteDAO {


    // Metodo para salvar no banco de dados !
    // Metodo para fazer Update so informar o ID!
    public Cliente save(Cliente cliente) {
        EntityManager entityManager = new ConnectionFactory().getConnection();

        try {
            entityManager.getTransaction().begin();
            if (cliente.getID() == null) {

                entityManager.persist(cliente);
            } else {
                entityManager.merge(cliente);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return cliente;
    }

    public Cliente buscarID(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Cliente cliente = null;

        try {
            cliente = entityManager.find(Cliente.class, ID);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return cliente;
    }

    public List<Cliente> buscarTodos() {

        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<Cliente> clientes = null;

        try {

            clientes = entityManager.createQuery("from TB_Cliente").getResultList();

        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error .
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return clientes;
    }

    public Cliente remove(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Cliente cliente = null;

        try {
            cliente = entityManager.find(Cliente.class, ID);
            entityManager.getTransaction().begin();
            entityManager.remove(cliente);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        return cliente;
    }
}
