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
    public Estado save(Estado estado) {
        EntityManager entityManager = new ConnectionFactory().getConnection();

        try {
            entityManager.getTransaction().begin();
            if (estado.getID() == null) {

                entityManager.persist(estado);
            } else {
                entityManager.merge(estado);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return estado;
    }

    public Estado buscarID(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Estado estado = null;

        try {
            estado = entityManager.find(Estado.class, ID);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return estado;
    }

    public List<Estado> buscarTodos() {

        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<Estado> estados = null;

        try {

            estados = entityManager.createQuery("from TB_Estado").getResultList();

        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error .
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return estados;
    }

    public Estado remove(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Estado estado = null;

        try {
            estado = entityManager.find(Estado.class, ID);
            entityManager.getTransaction().begin();
            entityManager.remove(estado);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        return estado;
    }

}
