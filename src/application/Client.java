package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {

	private static Stage stage;


	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/view/Cliente.Principal.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Client");
		stage.setScene(scene);
		stage.show();
		setStage(stage);

	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Client.stage = stage;
	}

}
