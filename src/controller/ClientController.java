package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import DAO.CidadeDAO;
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
import javafx.scene.control.Alert;
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
import model.Cidade;
import model.Cliente;
import model.Endereco;
import util.TextFieldFormatter;

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
	private TextField txtNomeFantasia;

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
	
	@FXML
	private void FormatacaoCPF(){
		TextFieldFormatter msk = new TextFieldFormatter();
		
		if(lblCPFCNPJ.getText().equals("CPF:")) {
		
		//Aqui coloca o formato que vai ser a mascara!
		msk.setMask("###.###.###-##");
		//Aqui coloca oq pode ter na mascara!
		msk.setCaracteresValidos("0123456789");
		//Aqui coloca o campo que a mascara vai entra!
		msk.setTf(txtCPFCNPJ);
		//Aqui esta verificando a string e fazendo a formatacao!!
		msk.formatter();
			}
		
		if (lblCPFCNPJ.getText().equals("CNPJ:")) {
			msk.setMask("##.###.###/####-##");
			msk.setCaracteresValidos("0123456789");
			msk.setTf(txtCPFCNPJ);
			msk.formatter();
			
		}
	}
	@FXML
	private void FormatacaoTel(){
		TextFieldFormatter msk = new TextFieldFormatter();
		//Aqui coloca o formato que vai ser a mascara!
		msk.setMask("(##)####-####");
		//Aqui coloca oq pode ter na mascara!
		msk.setCaracteresValidos("0123456789");
		//Aqui coloca o campo que a mascara vai entra!
		msk.setTf(txtTelefone);
		//Aqui esta verificando a string e fazendo a formatacao!!
		msk.formatter();
	}
	@FXML
	private void FormatacaoCel(){
		TextFieldFormatter msk = new TextFieldFormatter();
		//Aqui coloca o formato que vai ser a mascara!
		msk.setMask("(##)#####-####");
		//Aqui coloca oq pode ter na mascara!
		msk.setCaracteresValidos("0123456789");
		//Aqui coloca o campo que a mascara vai entra!
		msk.setTf(txtCelular);
		//Aqui esta verificando a string e fazendo a formatacao!!
		msk.formatter();
	}
	@FXML
	private void FormatacaoCEP(){
		TextFieldFormatter msk = new TextFieldFormatter();
		//Aqui coloca o formato que vai ser a mascara!
		msk.setMask("#####-###");
		//Aqui coloca oq pode ter na mascara!
		msk.setCaracteresValidos("0123456789");
		//Aqui coloca o campo que a mascara vai entra!
		msk.setTf(txtCEP);
		//Aqui esta verificando a string e fazendo a formatacao!!
		msk.formatter();
	}	

	private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

	// =============================================================================================================

	public void initialize(URL url, ResourceBundle rb) {
		comboBox.getItems().addAll("CPF", "CNPJ");
		choice();
		comboBox.setValue("CPF");
		pesquisarCidade();
		carregarTableViewClientes();
		// Listener da tabela
		tbCliente.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			try {
				recarregarTela();
				carregarTelaAlterar(newValue);

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}

	// =============================================================================================================

	@FXML
	void imgHome(MouseEvent event) throws IOException {
		carregarTelaHome();
	}

	@FXML
	void btnCadastrarCliente(ActionEvent event) throws IOException {
		boolean controle = true;

		for (Cliente clienteLista : listaClientes) {
			int codigoCliente = Integer.parseInt(txtID.getText());
			int codigoEmString = clienteLista.getCodigo();

			if (codigoEmString == codigoCliente) {
				Alert msg = new Alert(Alert.AlertType.ERROR);
				msg.setTitle("ERRO");
				msg.setContentText("O código digitado já existe, digite outro!");
				msg.setHeaderText(null);
				msg.showAndWait();
				controle = false;
				break;
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
			cliente.setCPF((txtCPFCNPJ.getText()));
			break;
		case "CNPJ":
			cliente.setCNPJ((txtCPFCNPJ.getText()));
			cliente.setRazaoSocial(txtNomeFantasia.getText());
			break;

		}
		//------------------------------------------------------------
		//---------ENDEREÇO-------------------------------------------
		Endereco endereco = new Endereco();
		EnderecoDAO enderecoDAO = new EnderecoDAO();

		endereco.setRua(txtEndereco.getText());
		endereco.setCEP((txtCEP.getText()));
		endereco.setBairro(txtBairro.getText());
		endereco.setComplemento(txtComplemento.getText());
		endereco.setCidade(txtCidade.getText());
		endereco.setEstado(txtEstado.getText());

		cliente.setEndereco(endereco);
		//------------------------------------------------------------
		
		if (controle == true) {
			clienteDAO.save(cliente);
			enderecoDAO.save(endereco);
			recarregarTela();	
		}
			
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
				txtCPFCNPJ.clear();
				txtNomeFantasia.setVisible(false);
				lblCNPJ.setVisible(false);
				lblCPFCNPJ.setText("CPF:");
				lblNome.setText("Nome:");
				break; 
			case "CNPJ":
				txtCPFCNPJ.clear();
				txtNomeFantasia.setVisible(true);
				lblCNPJ.setVisible(true);
				lblCPFCNPJ.setText("CNPJ:");
				lblNome.setText("Razão Social:");
				break;
			}
		});
	}
   
	public void pesquisarCidade() {
		List<String> listaDeCidades = new ArrayList<>();
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		for(Cidade cidade : cidadeDAO.buscarTodos()) {		
			listaDeCidades.add(cidade.getNome());
		}
		
		TextFields.bindAutoCompletion(txtCidade, listaDeCidades);
		txtCidade.textProperty().addListener((obsevable, oldvalue, newvalue) -> {
			for (Cidade cidade : cidadeDAO.buscarTodos()) {
				if(cidade.getNome().equals(txtCidade.getText())) {
					txtEstado.setText(cidade.getEstado().getUf());
				}		
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

		Collections.sort(listaClientes);
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
