package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import DAO.ClienteDAO;
import DAO.UsuarioDAO;
import application.Client;
import application.ClienteCadastro;
import application.ClienteTableView;
import application.Home;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Cliente;
import model.Usuario;

public class ClientController implements Initializable {


    @FXML
    private TableView<Cliente> tbCliente;

    @FXML
    private TableColumn<?, ?> tbClienteColumnID;

    @FXML
    private TableColumn<?, ?> tbClienteColumnNome;

    @FXML
    private TableColumn<?, ?> tbClienteColumnCPF;
    @FXML
    private ImageView imgReturn;

    @FXML
    private Button btnCadastrarCliente;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtNomeFantasia;

    @FXML
    private TextField txtCPFCNPJ;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtEndereco;

    @FXML
    private Label lblCNPJ;

    @FXML
    private TextField txtComplemento;

    @FXML
    private TextField txtBairro;

    @FXML
    private TextField txtCEP;

    @FXML
    private TextArea txtObservacao;

    @FXML
    private ImageView imgHome;
    private List<Cliente> listClientes = new ArrayList<Cliente>();
    private ObservableList<Cliente> observableListClientes;
    
    
	public void initialize(URL url, ResourceBundle rb) {
		//ComboBox
		ObservableList<String> options = 
                FXCollections.observableArrayList(
                    "CPF",
                    "CNPJ"
                    
                   
                );
		
        comboBox.setItems(options);
		
		
		carregarTableViewClientes();
		tbCliente.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> abrirTableViewCompleta());
		
		imgReturn.setOnMouseClicked(MouseEvent -> {
			Client.getStage().close();
			Home home = new Home();
			try {
				home.start(new Stage());
			} catch (Exception e) {
				e.getMessage();
			}
		});
		
		btnCadastrarCliente.setOnMouseClicked(MouseEvent -> {
	        Cliente cliente = new Cliente();
	        ClienteDAO clienteDAO = new ClienteDAO();
	        
	        cliente.setCodigo(Integer.parseInt(txtID.getText()));
	        cliente.setNome(txtNome.getText());
	        cliente.setCPF(Double.parseDouble(txtCPFCNPJ.getText()));
	        cliente.setTelefone(txtTelefone.getText());
	        cliente.setOBS(txtObservacao.getText());

	        clienteDAO.save(cliente);
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
	
	public void abrirTableViewCompleta(){
		System.out.println("TESTE");
		ClienteTableView clienteTableView = new ClienteTableView();
		try {
			clienteTableView.start(new Stage());
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
