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
    private TableColumn<?, ?> tbClienteColumnEndereco;
    
    @FXML
    private TableColumn<?, ?> tbClienteColumnTelefone;
    
    @FXML
    private TableColumn<?, ?> tbClienteColumnEmail;
    
    @FXML
    private TableColumn<?, ?> tbClienteColumnOBS;
    
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
    private TextField txtEmail;
    
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
	        cliente.setEmail(txtEmail.getText());
	        cliente.setOBS(txtObservacao.getText());

	        clienteDAO.save(cliente);
		});
	}
	
	public void carregarTableViewClientes() {
		
		tbClienteColumnID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		tbClienteColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbClienteColumnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		tbClienteColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		tbClienteColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tbClienteColumnOBS.setCellValueFactory(new PropertyValueFactory<>("TTTTTT"));
		
		
		ClienteDAO clienteDAO = new ClienteDAO();
        for (Cliente cliente : clienteDAO.buscarTodos()) {  	
        
        	listClientes.add(cliente);
        }
        		
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
