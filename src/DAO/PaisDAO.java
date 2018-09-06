/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import model.Pais;

/**
 *
 * @author Alyson-Casa
 */
public class PaisDAO {
       
    // Metodo para salvar no banco de dados !
    // Metodo para fazer Update so informar o ID!
    public Pais save(Pais pais) {
        EntityManager entityManager = new ConnectionFactory().getConnection();

        try {
            entityManager.getTransaction().begin();
            if (pais.getID() == null) {

                entityManager.persist(pais);
            } else {
                entityManager.merge(pais);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return pais;
    }

    public Pais buscarID(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Pais pais = null;

        try {
            pais = entityManager.find(Pais.class, ID);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return pais;
    }

    public List<Pais> buscarTodos() {

        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<Pais> paiss = null;

        try {

            paiss = entityManager.createQuery("from TB_Pais").getResultList();

        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error .
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return paiss;
    }

    public Pais remove(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Pais pais = null;

        try {
            pais = entityManager.find(Pais.class, ID);
            entityManager.getTransaction().begin();
            entityManager.remove(pais);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        return pais;
    }

}
