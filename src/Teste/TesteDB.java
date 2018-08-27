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

        /*       Exemplo de Inserir novo Usuario! 
        
        Usuario user = new Usuario();
        user.setLogin("Alyson02");
        user.setSenha("1587");   
        
        UsuarioDAO userDAO = new UsuarioDAO();
        userDAO.save(user);
        
         */
 /*       Exemplo de Atualizar um Usuario existente! 

        Usuario user = new Usuario();
        user.setID(2);
        user.setLogin("Alyson Antonio C");
        user.setSenha("1479"); 
        
        UsuarioDAO userDAO = new UsuarioDAO();
        userDAO.save(user);

         */

 /*          Exemplo de Buscar o Usuario pelo ID!

        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = userDAO.buscarID(2);

        System.out.println("Login : "+user.getLogin());
        System.out.println("Senha : "+user.getSenha());


         */

 /*         Exemplo de como Buscar e listar todos Usuario
        UsuarioDAO userDAO = new UsuarioDAO();
        for(Usuario user: userDAO.buscarTodos()){
            System.out.println("ID: "+user.getID());
            System.out.println("Usuario: "+user.getLogin());
            System.out.println("Senha: "+user.getSenha());
        }
         */
 /*         Exemplo de como Remover Usuario pelo ID
         UsuarioDAO userDAO = new UsuarioDAO();
         userDAO.remove(2);
 */
 
 
 /*=======================================================================*/
        ClienteDAO cDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        
        cliente.setCodigo(1010);
        cliente.setNome("Paulinho");
        cliente.setCNPJ(1010.1);
        cliente.setCPF(159.4);
        cliente.setEmail("paulinho@hotmail.com");
        cliente.setTipo("Fiel");
        cliente.setOBS("Paga em dia");
        cliente.setTelefone("62992007442");
        
        cDAO.save(cliente);
 
 
 
 
    }

}
