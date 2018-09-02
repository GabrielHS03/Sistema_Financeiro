package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import DAO.ClienteDAO;
import application.Client;
import application.Home;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Cliente;

public class ClientController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    
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
	Label lblCPFCNPJ;

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
		// ComboBox
		/*
		 * ObservableList<String> options = FXCollections.observableArrayList( "CPF",
		 * "CNPJ" );
		 * 
		 * comboBox.setItems(options);
		 */

		comboBox.getItems().addAll("CPF", "CNPJ");

		choice();
		carregarTableViewClientes();
		tbCliente.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> System.out.println("TESTE"));

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

			cliente.setCPF(Long.parseLong(txtCPFCNPJ.getText()));
			cliente.setTelefone(txtTelefone.getText());
			cliente.setEmail(txtEmail.getText());
			cliente.setOBS(txtObservacao.getText());

			clienteDAO.save(cliente);
			try {
				recarregarTela();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	}

	public void choice() {

		comboBox.setOnAction(e -> {
			switch (comboBox.getValue()) {
			case "CPF":
				txtNomeFantasia.setVisible(false);
				lblCNPJ.setVisible(false);
				lblCPFCNPJ.setText("CPF:");
				break;
			case "CNPJ":
				txtNomeFantasia.setVisible(true);
				lblCNPJ.setVisible(true);
				lblCPFCNPJ.setText("CNPJ:");

				break;
			}
		});
	}

	public void carregarTableViewClientes() {

		tbClienteColumnID.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbClienteColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbClienteColumnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		tbClienteColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		tbClienteColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tbClienteColumnOBS.setCellValueFactory(new PropertyValueFactory<>("OBS"));

		ClienteDAO clienteDAO = new ClienteDAO();
		for (Cliente cliente : clienteDAO.buscarTodos()) {

			listClientes.add(cliente);
		}

		observableListClientes = FXCollections.observableArrayList(listClientes);

		tbCliente.setItems(observableListClientes);
	}
	
	public void recarregarTela() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Cliente.Principal.fxml"));
		rootPane.getChildren().setAll(pane);
	}

}
