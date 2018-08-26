package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Login extends Application {

	private static Stage stage;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
			Scene scene = new Scene(root,393,193);
			stage.setTitle("Login");
			stage.setScene(scene);
			stage.show();
			setStage(stage);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public static Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	

}
