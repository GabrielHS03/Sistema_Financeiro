package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import DAO.BoletoDAO;
import DAO.ClienteDAO;
import DAO.EnderecoDAO;
import application.ClienteAlterar;
import application.Login;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Boleto;
import model.Cliente;
import model.Endereco;

public class ClientController implements Initializable {

	@FXML
	private AnchorPane rootPane;

	@FXML
	private TextField searchBox;

	@FXML
	private TableView<Cliente> tbCliente;

	@FXML
	private TableColumn<?, ?> tbClienteColumnID;

	@FXML
	private TableColumn<?, ?> tbClienteColumnNome;

	@FXML
	private TableColumn<?, ?> tbClienteColumnCPF;

	@FXML
	private TableColumn<?, ?> tbClienteColumnCNPJ;

	@FXML
	private TableColumn<?, ?> tbClienteColumnEndereco;

	@FXML
	private TableColumn<?, ?> tbClienteColumnTelefone;

	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private TextField txtID;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtRazaoSocial;

	@FXML
	private TextField txtCPFCNPJ;

	@FXML
	private TextField txtTelefone;

	@FXML
	private TextField txtCelular;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtEndereco;

	@FXML
	Label lblCPFCNPJ;

	@FXML
	private Label lblCNPJ;

	@FXML
	private Label lblNome;

	@FXML
	private TextField txtComplemento;

	@FXML
	private TextField txtBairro;

	@FXML
	private TextField txtCEP;

	@FXML
	private TextField txtCidade;

	@FXML
	private TextField txtEstado;

	@FXML
	private TextArea txtObservacao;

	private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

	// =============================================================================================================

	public void initialize(URL url, ResourceBundle rb) {
		comboBox.getItems().addAll("CPF", "CNPJ");
		choice();
		comboBox.setValue("CPF");
		carregarTableViewClientes();
		// Listener da tabela
		tbCliente.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			
			if(Login.click1 == observable.getValue().getCodigo()) {
				try {
					carregarTelaAlterar(newValue);

				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}
			Login.click1 = observable.getValue().getCodigo();
			
			try {
				recarregarTela();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	// =============================================================================================================

	@FXML
	void imgHome(MouseEvent event) throws IOException {
		carregarTelaHome();
		Login.click1 = -1;
	}

	@FXML
	void btnCadastrarCliente(ActionEvent event) throws IOException {
		boolean controle = true;

		for (Cliente clienteLista : listaClientes) {
			int codigoCliente = Integer.parseInt(txtID.getText());
			int codigoEmString = clienteLista.getCodigo();

			if (codigoEmString == codigoCliente) {
				System.out.println("ID j� existe, digite outro!");
				controle = false;
			}
		}
		//---------CLIENTE--------------------------------------------
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		cliente.setCodigo(Integer.parseInt(txtID.getText()));
		cliente.setNome(txtNome.getText());
		cliente.setTelefoneFixo(txtTelefone.getText());
		cliente.setTelefoneCel(txtCelular.getText());
		cliente.setEmail(txtEmail.getText());
		cliente.setOBS(txtObservacao.getText());
		switch (comboBox.getValue()) {
		case "CPF":
			cliente.setCPF(Long.parseLong(txtCPFCNPJ.getText()));
			break;
		case "CNPJ":
			cliente.setCNPJ(Long.parseLong(txtCPFCNPJ.getText()));
			cliente.setRazaoSocial(txtRazaoSocial.getText());
			break;

		}
		//------------------------------------------------------------
		//---------ENDERE�O-------------------------------------------
		Endereco endereco = new Endereco();
		EnderecoDAO enderecoDAO = new EnderecoDAO();

		endereco.setRua(txtEndereco.getText());
		endereco.setCEP(Integer.parseInt(txtCEP.getText()));
		endereco.setBairro(txtBairro.getText());
		endereco.setComplemento(txtComplemento.getText());
		
		
//		endereco.setCidade(txtCidade.getText());
//		endereco.setEstado(txtEstado.getText());
		
		
		cliente.setEndereco(endereco);
		//------------------------------------------------------------
		//---------BOLETO---------------------------------------------
//		List<Boleto> listaDeBoletos = new ArrayList<>();
//		Boleto boleto1 = new Boleto();
//		Boleto boleto2 = new Boleto();	
//		BoletoDAO boletoDAO = new BoletoDAO();
//		
//		boleto1.setValor(800.50);
//		boleto1.setStatus("PAGO");
//		boleto1.setCliente(cliente);
//		
//		boleto2.setValor(500.00);
//		boleto2.setStatus("DEVENDO");
//		boleto2.setCliente(cliente);
//		
//		listaDeBoletos.add(boleto1);
//		listaDeBoletos.add(boleto2);
//		cliente.setBoletos(listaDeBoletos);
		//------------------------------------------------------------
		
		if (controle == true) {
			clienteDAO.save(cliente);
		}
		enderecoDAO.save(endereco);
//		boletoDAO.save(boleto1);
//		boletoDAO.save(boleto2);
		recarregarTela();				
	}

	@FXML
	void searchBox(KeyEvent event) {
		FilteredList<Cliente> listaClientesFiltered = new FilteredList<>(listaClientes, p -> true);
		searchBox.textProperty().addListener((obsevable, oldvalue, newvalue) -> {
			listaClientesFiltered.setPredicate(cliente -> {

				if (newvalue == null || newvalue.isEmpty()) {
					return true;
				}
				String typedText = newvalue.toLowerCase();

				String codigoEmString = Integer.toString(cliente.getCodigo());
				String cpfEmString = String.valueOf(cliente.getCPF());
				String cnpjEmString = String.valueOf(cliente.getCNPJ());

				if ((cliente.getNome().toLowerCase().indexOf(typedText) != -1)
						|| (codigoEmString.toLowerCase().indexOf(typedText) != -1)
						|| (cpfEmString.toLowerCase().indexOf(typedText) != -1)
						|| (cnpjEmString.toLowerCase().indexOf(typedText) != -1)) {

					return true;
				}

				return false;
			});
			SortedList<Cliente> listaClientesSorted = new SortedList<>(listaClientesFiltered);
			listaClientesSorted.comparatorProperty().bind(tbCliente.comparatorProperty());
			tbCliente.setItems(listaClientesSorted);
		});
	}
	// =============================================================================================================

	public void choice() {

		comboBox.setOnAction(e -> {
			switch (comboBox.getValue()) {
			case "CPF":
				txtRazaoSocial.setVisible(false);
				lblCNPJ.setVisible(false);
				lblCPFCNPJ.setText("CPF:*");
				lblNome.setText("Nome:*");
				break; 
			case "CNPJ":
				txtRazaoSocial.setVisible(true);
				lblCNPJ.setVisible(true);
				lblCPFCNPJ.setText("CNPJ:*");
				lblNome.setText("Nome Fantasia:*");
				break;
			}
		});
	}

	public void carregarTableViewClientes() {

		ClienteDAO clienteDAO = new ClienteDAO();
		for (Cliente cliente : clienteDAO.buscarTodos()) {
			if (cliente.getStatus() == true) {
				listaClientes.add(cliente);
			}
		}

		tbCliente.setItems(listaClientes);
		tbClienteColumnID.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbClienteColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbClienteColumnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		tbClienteColumnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
		tbClienteColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefoneFixo"));
	}


	public void recarregarTela() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Cliente.Principal.fxml"));
		rootPane.getChildren().setAll(pane);
	}

	
    public void carregarTelaHome() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
		rootPane.getChildren().setAll(pane);
    }
    
    public static Cliente clienteSelecionado = new Cliente();
	public void carregarTelaAlterar(Cliente cliente) throws IOException {
		clienteSelecionado = cliente;
		ClienteAlterar clienteAlterar = new ClienteAlterar();
		try {
			clienteAlterar.start(new Stage());
		} catch (Exception e) {
			e.getMessage();
		}
		recarregarTela();
	}

}
