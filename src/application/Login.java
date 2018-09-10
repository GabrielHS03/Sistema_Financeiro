package application;

import javax.persistence.EntityManager;

import controller.ConnectionFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Login extends Application {

	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage stage) throws Exception {

		EntityManager entityManager = new ConnectionFactory().getConnection();
		Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
		Scene scene = new Scene(root);
		Image image = new Image("images/icon.png");
		stage.getIcons().add(image);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
		setStage(stage);

	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Login.stage = stage;
	}

}
