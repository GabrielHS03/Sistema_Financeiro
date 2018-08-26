package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Client;
import application.Home;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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

    @FXML
    private ImageView imgReturn;

	public void initialize(URL url, ResourceBundle rb) {
		imgReturn.setOnMouseClicked(MouseEvent -> {
			Client.getStage().close();
			Home home = new Home();
			try {
				home.start(new Stage());
			} catch (Exception e) {
				e.getMessage();
			}

		});
	}
}
