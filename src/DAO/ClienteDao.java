package DAO;
import controller.ConnectionFactory;
import javax.persistence.EntityManager;
import model.Cliente;

public class ClienteDAO {
    
    public Cliente save(Cliente cliente){
       EntityManager em = new ConnectionFactory().getConnection();
        try {
          em.getTransaction().begin();
          em.persist(cliente);
          em.getTransaction().commit();
          
        } catch (Exception e) {
            
            //Se der Error aqui vai aparesentar o error e o rollback vai voltar para nao salvar o erro!
            System.err.println(e);
           em.getTransaction().rollback();
        }finally{
            //Para fechar o entityManager.
            em.close();            
        }
        return cliente;   
    }
    
}
