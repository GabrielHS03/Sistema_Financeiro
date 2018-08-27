/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import DAO.ClienteDAO;
import DAO.UsuarioDAO;
import model.Cliente;
import model.Usuario;

/**
 *
 * @author Alyson-Casa
 */
public class TesteDB {

    public static void main(String[] args) {
/*=========================      Exemplo de Inserir novo Usuario!  ================================*/ 
                
        
        Usuario user = new Usuario();
        user.setLogin("Franklin");
        user.setSenha("12345");   
        
        UsuarioDAO userDAO = new UsuarioDAO();
        userDAO.save(user);
        
         
        
/*=========================      Exemplo de Atualizar um Usuario existente!  ================================*/        
 /*       

        Usuario user = new Usuario();
        user.setID(2);
        user.setLogin("Alyson Antonio C");
        user.setSenha("1479"); 
        
        UsuarioDAO userDAO = new UsuarioDAO();
        userDAO.save(user);

         */
/*=========================      Exemplo de Buscar o Usuario pelo ID! ================================*/
 /*          

        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = userDAO.buscarID(2);

        System.out.println("Login : "+user.getLogin());
        System.out.println("Senha : "+user.getSenha());


         */
/*=========================      Exemplo de como Buscar e listar todos Usuario  ================================*/
 /*         
        UsuarioDAO userDAO = new UsuarioDAO();
        for(Usuario user: userDAO.buscarTodos()){
            System.out.println("ID: "+user.getID());
            System.out.println("Usuario: "+user.getLogin());
            System.out.println("Senha: "+user.getSenha());
        }
         */
/*=========================      Exemplo de como Remover Usuario  ================================*/
 /*
        UsuarioDAO userDAO = new UsuarioDAO();
        userDAO.remove(2);
 */
 
 
 /*=========================      Exemplo de Inserir novo Cliente! ================================*/
 /*    ClienteDAO cDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        
        cliente.setCodigo(1010);
        cliente.setNome("Joaozinho");
        cliente.setCNPJ(1010.1);
        cliente.setCPF(159.4);
        cliente.setEmail("Joazinho@hotmail.com");
        cliente.setTipo("Fiel");
        cliente.setOBS("Paga em dia");
        cliente.setTelefone("62992007442");
        
        cDAO.save(cliente);
*/
   
  /*=========================      Exemplo de Atualizar um Cliente Existente! ================================*/
  /*========================= Apenas tem que Mostrar o cliente pelo ID.       ================================*/
  /*
        ClienteDAO cDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        
        cliente.setID(2);
        cliente.setCodigo(1010);
        cliente.setNome("Carlinhos");
        cliente.setCNPJ(1020.1);
        cliente.setCPF(10.1);
        cliente.setEmail("carlinhos@hotmail.com");
        cliente.setTipo("Fiel");
        cliente.setOBS("Paga em dia");
        cliente.setTelefone("629111111"); 
  
        cDAO.save(cliente);
  */
  
 /*=========================      Exemplo Buscar o Cliente pelo ID Existente! ================================*/
 /*========================= Apenas tem que Mostrar o cliente pelo ID.       ================================*/
/*
        ClienteDAO cDAO = new ClienteDAO();
        Cliente cliente = cDAO.buscarID(2);
        
        
        
        System.out.println("Nome: "+cliente.getNome());
        System.out.println("Codigo: "+cliente.getCodigo());
        System.out.println("CNPJ: "+cliente.getCNPJ());
        System.out.println("CPF: "+cliente.getCPF());
        System.out.println("Email: "+cliente.getEmail());
        System.out.println("Tipo: "+cliente.getTipo());
        System.out.println("OBS: "+cliente.getOBS());
        System.out.println("Telefone: "+cliente.getTelefone());

*/
/*=========================      Exemplo de como Buscar e listar todos Clientes  ================================*/
/*      
        ClienteDAO cDAO = new ClienteDAO();
        for(Cliente cliente: cDAO.buscarTodos()){
            System.out.println("Nome: "+cliente.getNome());
            System.out.println("Codigo: "+cliente.getCodigo());
            System.out.println("CNPJ: "+cliente.getCNPJ());
            System.out.println("CPF: "+cliente.getCPF());
            System.out.println("Email: "+cliente.getEmail());
            System.out.println("Tipo: "+cliente.getTipo());
            System.out.println("OBS: "+cliente.getOBS());
            System.out.println("Telefone: "+cliente.getTelefone());
            System.out.println("================================");
        }
*/      
/*=========================      Exemplo de como Remover Usuario  ================================*/
 /*========================= Apenas tem que Mostrar o cliente pelo ID.       ================================*/
/*
        ClienteDAO cDAO = new ClienteDAO();
        cDAO.remove(2);
*/
 
 

   
   
   
 
    }

}
