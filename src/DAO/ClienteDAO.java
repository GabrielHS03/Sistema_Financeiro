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
    public Cliente save(Cliente usuario) {
        EntityManager entityManager = new ConnectionFactory().getConnection();

        try {
            entityManager.getTransaction().begin();
            if (usuario.getID() == null) {

                entityManager.persist(usuario);
            } else {
                entityManager.merge(usuario);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return usuario;
    }

    public Cliente buscarID(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Cliente usuario = null;

        try {
            usuario = entityManager.find(Cliente.class, ID);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return usuario;
    }

    public List<Cliente> buscarTodos() {

        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<Cliente> usuarios = null;

        try {

            usuarios = entityManager.createQuery("from TB_Cliente").getResultList();

        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error .
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return usuarios;
    }

    public Cliente remove(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Cliente usuario = null;

        try {
            usuario = entityManager.find(Cliente.class, ID);
            entityManager.getTransaction().begin();
            entityManager.remove(usuario);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        return usuario;
    }
}
