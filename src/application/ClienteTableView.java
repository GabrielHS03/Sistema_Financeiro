package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ClienteTableView extends Application {

	private static Stage stage;


	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/view/Cliente.TableView.fxml"));
		Scene scene = new Scene(root);
		Image image = new Image("file:icon.png");
		stage.getIcons().add(image);
		stage.setTitle("ClienteTableView");
		stage.setScene(scene);
		stage.show();
		setStage(stage);

	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		ClienteTableView.stage = stage;
	}

}
