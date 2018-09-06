package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import controller.ConnectionFactory;
import model.Boleto;

public class BoletoDAO {
	 // Metodo para salvar no banco de dados !
    // Metodo para fazer Update so informar o ID!
    public Boleto save(Boleto boleto) {
        EntityManager entityManager = new ConnectionFactory().getConnection();

        try {
            entityManager.getTransaction().begin();
            if (boleto.getID() == null) {

                entityManager.persist(boleto);
            } else {
                entityManager.merge(boleto);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return boleto;
    }

    public Boleto buscarID(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Boleto boleto = null;

        try {
            boleto = entityManager.find(Boleto.class, ID);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return boleto;
    }

    public List<Boleto> buscarTodos() {

        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<Boleto> boletos = null;

        try {

            boletos = entityManager.createQuery("from TB_Boleto").getResultList();

        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error .
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return boletos;
    }

    public Boleto remove(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Boleto boleto = null;

        try {
            boleto = entityManager.find(Boleto.class, ID);
            entityManager.getTransaction().begin();
            entityManager.remove(boleto);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        return boleto;
    }

}
