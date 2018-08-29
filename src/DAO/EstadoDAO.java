/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import model.Estado;

/**
 *
 * @author Alyson-Casa
 */
public class EstadoDAO {
       
    // Metodo para salvar no banco de dados !
    // Metodo para fazer Update so informar o ID!
    public Estado save(Estado usuario) {
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

    public Estado buscarID(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Estado usuario = null;

        try {
            usuario = entityManager.find(Estado.class, ID);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return usuario;
    }

    public List<Estado> buscarTodos() {

        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<Estado> usuarios = null;

        try {

            usuarios = entityManager.createQuery("from TB_Estado").getResultList();

        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error .
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return usuarios;
    }

    public Estado remove(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Estado usuario = null;

        try {
            usuario = entityManager.find(Estado.class, ID);
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
