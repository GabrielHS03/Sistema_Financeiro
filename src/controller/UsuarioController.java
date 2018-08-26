package controller;

import DAO.UsuarioDAO;
import model.Usuario;

public class UsuarioController {

    
	public static void main(String[] args) {
            
        //newUsuario.setID(1) Para fazer Update e so chamar uma classe ID ja existente ai ele ja faz o Update; EX Chamar newUsuario.setID(1) ele vai alterar os dados nele!
                UsuarioDAO dao = new UsuarioDAO();
		//Usuario newUsuario = new Usuario();
                
		//newUsuario.setUsuario("Alyson");		
		//newUsuario.setSenha("159159");

                //dao.save(newUsuario);
                
//                Forma de pesquisar o usuario no banco de dados
//                UsuarioDAO dao = new UsuarioDAO();
//                
//                Usuario buscarUsuario = dao.buscarID(2);
//                
//                System.out.println("ID: "+buscarUsuario.getID());
//                System.out.println("Usuario: "+buscarUsuario.getUsuario());
//                System.out.println("Senha: "+buscarUsuario.getSenha());


//      Para Listar todos membro da tabela!
//                    for(Usuario j: dao.findAll()){
//                        //System.out.println("ID: "+c.getID());
//                        System.out.println("Usuario: "+j.getUsuario());
//                       // System.out.println("Senha: "+c.getSenha());
//                    }

//      Para remover da lista so informar o ID!
//                dao.remove(3);



	}

}
