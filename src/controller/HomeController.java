package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    public static AnchorPane rootPaneHome;

	//========================================================================================
	public void initialize(URL url, ResourceBundle rb) {
	    rootPaneHome = rootPane;
		
	}
	//========================================================================================
	
    @FXML
    void btnCliente(ActionEvent event) throws IOException {
    	carregarTelaClientePrincipal();
    }
    
    @FXML
    void btnBoleto(ActionEvent event) throws IOException {
    	carregarTelaBoletoPrincipal();
    }
	//========================================================================================
    
    public void carregarTelaClientePrincipal() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Cliente.Principal.fxml"));
		rootPane.getChildren().setAll(pane);
    }
    
    public void carregarTelaBoletoPrincipal() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Boleto.Principal.fxml"));
		rootPane.getChildren().setAll(pane);
    }

}