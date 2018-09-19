package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class BoletoDataPagamento extends Application {

	private static Stage stage;
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/Boleto.DataPagamento.fxml"));
		Scene scene = new Scene(root);
		Image image = new Image("images/icon.png");
		stage.getIcons().add(image);
		stage.setTitle("Maxima Segurança");
		stage.setScene(scene);
		stage.show();
		setStage(stage);
	}
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		BoletoDataPagamento.stage = stage;
	}
}
