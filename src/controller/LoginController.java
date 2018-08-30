package controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.UsuarioDAO;
import application.Home;
import application.Login;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import model.Usuario;

public class LoginController implements Initializable {

	@FXML
	private TextField txtUsuario;

	@FXML
	private PasswordField txtSenha;

	@FXML
	private Button btnEntrar;

	@FXML
	private Label lblStatus;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		btnEntrar.setOnMouseClicked(MouseEvent -> {
			login();

		});

		btnEntrar.setOnKeyPressed(KeyEvent -> {
			if (KeyEvent.getCode() == KeyCode.ENTER) {
				login();
			}

		});

		txtSenha.setOnKeyPressed(KeyEvent -> {
			if (KeyEvent.getCode() == KeyCode.ENTER) {
				login();
			}
		});
	}

	public void login() {
		if (txtUsuario.getText().equals("adm") && txtSenha.getText().equals("123")) {
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
        Usuario user = userDAO.buscarID(1);
        
        return user.getLogin();
	}
	public String retornoSenhaBD() {
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = userDAO.buscarID(1);
        
        return user.getSenha();
	}
}
