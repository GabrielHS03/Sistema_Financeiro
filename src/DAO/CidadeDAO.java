package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import controller.ConnectionFactory;
import model.Cidade;

public class CidadeDAO {
	 // Metodo para salvar no banco de dados !
    // Metodo para fazer Update so informar o ID!
	
	
//    public Cidade save(Cidade cidade) {
//        EntityManager entityManager = new ConnectionFactory().getConnection();
//
//        try {
//            entityManager.getTransaction().begin();
//            if (cidade.getID() == null) {
//
//                entityManager.persist(cidade);
//            } else {
//                entityManager.merge(cidade);
//            }
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//     //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
//            System.err.println(e);
//            entityManager.getTransaction().rollback();
//        } finally {
//            entityManager.close();
//        }
//        return cidade;
//    }

    public Cidade buscarID(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Cidade cidade = null;

        try {
            cidade = entityManager.find(Cidade.class, ID);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return cidade;
    }

    public List<Cidade> buscarTodos() {

        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<Cidade> cidades = null;

        try {

            cidades = entityManager.createQuery("from TB_Cidade").getResultList();

        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error .
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return cidades;
    }

//    public Cidade remove(Integer ID) {
//        EntityManager entityManager = new ConnectionFactory().getConnection();
//        Cidade cidade = null;
//
//        try {
//            cidade = entityManager.find(Cidade.class, ID);
//            entityManager.getTransaction().begin();
//            entityManager.remove(cidade);
//
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
//            System.err.println(e);
//            entityManager.getTransaction().rollback();
//        } finally {
//            entityManager.close();
//        }
//
//        return cidade;
//    }

}
