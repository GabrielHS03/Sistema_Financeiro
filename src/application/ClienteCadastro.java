package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ClienteCadastro extends Application {
	
	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/view/aaa.fxml"));
		Scene scene = new Scene(root);
		Image image = new Image("file:icon.png");
		stage.getIcons().add(image);
		stage.setTitle("Home");
		stage.setScene(scene);
		stage.show();
		setStage(stage);

	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		ClienteCadastro.stage = stage;
	}
}
