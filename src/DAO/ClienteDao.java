package DAO;
import controller.ConnectionFactory;
import javax.persistence.EntityManager;
import model.Cliente;

public class ClienteDao {
    
    public Cliente save(Cliente cliente){
       EntityManager entityManager = new ConnectionFactory().getConnection();
        try {
          entityManager.getTransaction().begin();
          entityManager.persist(cliente);
          entityManager.getTransaction().commit();
          
        } catch (Exception e) {
            
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
            entityManager.getTransaction().rollback();
        }finally{
            //Para fechar o entityManager.
            entityManager.close();            
        }
        return cliente;   
    }
    
}
