package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Home extends Application {

	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
		Scene scene = new Scene(root);
		Image image = new Image("images/icon.png");
		stage.getIcons().add(image);
		stage.setTitle("Maxima Seguranša");
		stage.setScene(scene);
		stage.show();
		setStage(stage);
	}
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Home.stage = stage;
	}
}
