package controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.UsuarioDAO;
import application.Home;
import application.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Usuario;

public class LoginController implements Initializable {

	@FXML
	private TextField txtUsuario;

	@FXML
	private PasswordField txtSenha;

	@FXML
	private Label lblStatus;
	
	//=======================================================================================
	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}
	//========================================================================================
   
	@FXML
    void btnEntrar(ActionEvent event) {
    	login();
    }

    @FXML
    void txtSenha(ActionEvent event) {
    	login();
    }
    
	//========================================================================================
    
	public void login() {
		if (txtUsuario.getText().equals(retornoLoginBD()) && txtSenha.getText().equals(retornoSenhaBD())) {
			lblStatus.setText("Login efetuado com sucesso!");                   
			Home home = new Home();                        
			Login.getStage().close();
			try {
				home.start(new Stage());
			} catch (Exception e) {
				e.getMessage();
			}
		} else {
			lblStatus.setText("Login e/ou senha incorretos!");
		}
	}

	public String retornoLoginBD() {
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = userDAO.buscarID(2);
        
        return user.getLogin();
	}
	public String retornoSenhaBD() {
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = userDAO.buscarID(2);
        
        return user.getSenha();
	}
}
