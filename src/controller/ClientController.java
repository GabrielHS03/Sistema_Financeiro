package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import application.Client;
import application.Home;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Cliente;

public class ClientController implements Initializable {

    @FXML
    private MenuButton btnBoleto;

    @FXML
    private MenuButton btnRelatorio;

    @FXML
    private TableView<Cliente> tbCliente;

    @FXML
    private TableColumn<?, ?> tbClienteColumnID;

    @FXML
    private TableColumn<?, ?> tbClienteColumnNome;

    @FXML
    private TableColumn<?, ?> tbClienteColumnCPF;

    @FXML
    private Button btnCadastrarCliente;

    @FXML
    private ImageView imgReturn;

    private List<Cliente> listClientes = new ArrayList();
    private ObservableList<Cliente> observableListClientes;
    
    
	public void initialize(URL url, ResourceBundle rb) {
		carregarTableViewClientes();
		imgReturn.setOnMouseClicked(MouseEvent -> {
			Client.getStage().close();
			Home home = new Home();
			try {
				home.start(new Stage());
			} catch (Exception e) {
				e.getMessage();
			}

		});
	}
	
	public void carregarTableViewClientes() {
		
		tbClienteColumnID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		tbClienteColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbClienteColumnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		
		Cliente c1 = new Cliente();
		c1.setID(123);
		c1.setNome("Franklin");
		c1.setCPF(1234567.89);
		
		Cliente c2 = new Cliente();
		c2.setID(456);
		c2.setNome("Gabriel");
		c2.setCPF(9876543.21);
		
		Cliente c3 = new Cliente();
		c3.setID(789);
		c3.setNome("Alyson");
		c3.setCPF(7894561.23);
		
		listClientes.add(c1);
		listClientes.add(c2);
		listClientes.add(c3);
		
		observableListClientes = FXCollections.observableArrayList(listClientes);
		
		tbCliente.setItems(observableListClientes);
	}
}
