/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import DAO.UsuarioDAO;
import model.Usuario;

/**
 *
 * @author Alyson-Casa
 */
public class TesteDB {
    public static void main(String[] args) {
        Usuario user = new Usuario();
        user.setLogin("Alyson02");
        user.setSenha("1587");   
        
        UsuarioDAO userDAO = new UsuarioDAO();
        userDAO.save(user);

        
    }
    
}
