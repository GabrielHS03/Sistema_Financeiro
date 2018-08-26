package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Client;
import application.Home;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeController implements Initializable {

	@FXML
	private Button btnCliente;

	@FXML
	private Button btnBoleto;

	@FXML
	private Button btnRelatorio;

	@FXML
	private Text lblClient;

	@FXML
	private ImageView imgClient;

	public void initialize(URL url, ResourceBundle rb) {
		btnCliente.setOnMouseClicked(MouseEvent -> {
			Home.getStage().close();
			Client client = new Client();
			try {
				client.start(new Stage());
			} catch (Exception e) {
				e.getMessage();
			}

		});

		
	}
}