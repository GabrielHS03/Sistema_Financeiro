/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import model.Endereco;

/**
 *
 * @author Alyson-Casa
 */
public class EnderecoDAO {
    
    // Metodo para salvar no banco de dados !
    // Metodo para fazer Update so informar o ID!
	
    public Endereco save(Endereco endereco) {
        EntityManager entityManager = new ConnectionFactory().getConnection();

        try {
            entityManager.getTransaction().begin();
            if (endereco.getID() == null) {

                entityManager.persist(endereco);
            } else {
                entityManager.merge(endereco);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return endereco;
    }

    public Endereco buscarID(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Endereco endereco = null;

        try {
            endereco = entityManager.find(Endereco.class, ID);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return endereco;
    }

    public List<Endereco> buscarTodos() {

        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<Endereco> endereco = null;

        try {

            endereco = entityManager.createQuery("from TB_Endereco").getResultList();

        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error .
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return endereco;
    }

    public Endereco remove(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Endereco endereco = null;

        try {
            endereco = entityManager.find(Endereco.class, ID);
            entityManager.getTransaction().begin();
            entityManager.remove(endereco);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        return endereco;
    }

}
