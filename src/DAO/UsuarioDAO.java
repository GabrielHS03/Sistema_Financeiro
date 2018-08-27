package DAO;

import controller.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import model.Usuario;

public class UsuarioDAO {

    // Metodo para salvar no banco de dados !
    // Metodo para fazer Update so informar o ID!
    public Usuario save(Usuario usuario) {
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

    public Usuario buscarID(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Usuario usuario = null;

        try {
            usuario = entityManager.find(Usuario.class, ID);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return usuario;
    }

    public List<Usuario> buscarTodos() {

        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<Usuario> usuarios = null;

        try {

            usuarios = entityManager.createQuery("from TB_Usuario").getResultList();

        } catch (Exception e) {
            //Se der Error aqui vai aparesentar o error .
            System.err.println(e);
        } finally {
            entityManager.close();
        }
        return usuarios;
    }

    public Usuario remove(Integer ID) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Usuario usuario = null;

        try {
            usuario = entityManager.find(Usuario.class, ID);
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