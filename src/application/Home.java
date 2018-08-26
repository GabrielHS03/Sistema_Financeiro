package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Home extends Application {

	private static Stage stage;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Home");
			stage.setScene(scene);
			stage.show();
			setStage(stage);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Home.stage = stage;
	}
	
}

