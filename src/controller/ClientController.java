package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClientController implements Initializable {

	@FXML
	private MenuButton btnBoleto;

	@FXML
	private MenuButton btnRelatorio;

	@FXML
	private TableView<?> tbCliente;

	@FXML
	private TableColumn<?, ?> tbColumnID;

	@FXML
	private TableColumn<?, ?> tbColumnName;

	@FXML
	private TableColumn<?, ?> tbColumnCPF;

	@FXML
	private Button btnCadastrarCliente;

	public void initialize(URL url, ResourceBundle rb) {
	}
}
