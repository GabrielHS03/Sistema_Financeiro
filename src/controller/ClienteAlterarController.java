package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.ClienteDAO;
import application.ClienteAlterar;
import javafx.event.ActionEvent;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Cliente;
import model.Endereco;

public class ClienteAlterarController implements Initializable {

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
	private TableColumn<?, ?> tbClienteColumnTelefone;

	@FXML
	private Button btnAlterarCliente;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnExcluir;

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

	//=============================================================================================================
	
	public void initialize(URL url, ResourceBundle rb) {
		
		setarDados();

	}

	//=============================================================================================================
    
	@FXML
    void btnAlterarCliente(ActionEvent event) throws IOException {
		Cliente cliente = new Cliente(null, null, null, null, null, null, null, null, null, null, new Endereco());
		ClienteDAO clienteDAO = new ClienteDAO();
		
		cliente.setCodigo(Integer.parseInt(txtID.getText()));
		cliente.setNome(txtNome.getText());
		// ----------------------
		String cpfEmString = String.valueOf(ClientController.clienteSelecionado.getCPF());
		String cnpjEmString = String.valueOf(ClientController.clienteSelecionado.getCNPJ());

		if (cnpjEmString == "null") {
			cliente.setCPF(Long.parseLong(txtCPFCNPJ.getText()));
		}
		if (cpfEmString == "null") {
			cliente.setCNPJ(Long.parseLong(txtCPFCNPJ.getText()));
			cliente.setRazaoSocial(txtRazaoSocial.getText());
		}
		// ----------------------
		cliente.setTelefoneCel(txtCelular.getText());
		cliente.setTelefoneFixo(txtTelefone.getText());
		cliente.setEmail(txtEmail.getText());
		cliente.setOBS(txtObservacao.getText());
		cliente.setID(ClientController.clienteSelecionado.getID());
		cliente.getEndereco().setRua(txtEndereco.getText());
		cliente.getEndereco().setBairro(txtBairro.getText());
		cliente.getEndereco().setComplemento(txtComplemento.getText());
		cliente.getEndereco().setCidade(txtCidade.getText());
		cliente.getEndereco().setCEP(Integer.parseInt(txtCEP.getText()));
		cliente.getEndereco().setEstado(txtEstado.getText());
		cliente.getEndereco().setID(ClientController.clienteSelecionado.getEndereco().getID());
		clienteDAO.save(cliente);
		
		ClienteAlterar.getStage().close();
		recarregarTelaClientePrincipal();

    }

    @FXML
    void btnExcluir(ActionEvent event) throws IOException {
		Cliente cliente = new Cliente(null, null, null, null, null, null, null, null, null, null, new Endereco());
		ClienteDAO clienteDAO = new ClienteDAO();
		
		cliente.setCodigo(null);
		cliente.setNome(txtNome.getText());
		// ----------------------
		String cpfEmString = String.valueOf(ClientController.clienteSelecionado.getCPF());
		String cnpjEmString = String.valueOf(ClientController.clienteSelecionado.getCNPJ());

		if (cnpjEmString == "null") {
			cliente.setCPF(Long.parseLong(txtCPFCNPJ.getText()));
		}
		if (cpfEmString == "null") {
			cliente.setCNPJ(Long.parseLong(txtCPFCNPJ.getText()));
			cliente.setRazaoSocial(txtRazaoSocial.getText());
		}
		// ----------------------
		cliente.setTelefoneCel(txtCelular.getText());
		cliente.setTelefoneFixo(txtTelefone.getText());
		cliente.setEmail(txtEmail.getText());
		cliente.setOBS(txtObservacao.getText());
		cliente.setID(ClientController.clienteSelecionado.getID());
		cliente.getEndereco().setRua(txtEndereco.getText());
		cliente.getEndereco().setBairro(txtBairro.getText());
		cliente.getEndereco().setComplemento(txtComplemento.getText());
		cliente.getEndereco().setCidade(txtCidade.getText());
		cliente.getEndereco().setCEP(Integer.parseInt(txtCEP.getText()));
		cliente.getEndereco().setEstado(txtEstado.getText());
		cliente.getEndereco().setID(ClientController.clienteSelecionado.getEndereco().getID());
		cliente.setStatus(false);
		
		clienteDAO.save(cliente);
		
		ClienteAlterar.getStage().close();
		recarregarTelaClientePrincipal();

    }
    
	//=============================================================================================================
	public void recarregarTelaClientePrincipal() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Cliente.Principal.fxml"));
		HomeController.rootPaneHome.getChildren().setAll(pane);
	}

	public void setarDados() {
		String codigoEmString = Integer.toString(ClientController.clienteSelecionado.getCodigo());
		String cpfEmString = String.valueOf(ClientController.clienteSelecionado.getCPF());
		String cnpjEmString = String.valueOf(ClientController.clienteSelecionado.getCNPJ());

		if (cnpjEmString == "null") {
			txtCPFCNPJ.setText(cpfEmString);
		}
		if (cpfEmString == "null") {
			txtCPFCNPJ.setText(cnpjEmString);
			txtRazaoSocial.setVisible(true);
			lblCNPJ.setVisible(true);
			lblCPFCNPJ.setText("CNPJ:");
			lblNome.setText("Nome Fantasia:");
			txtRazaoSocial.setText(ClientController.clienteSelecionado.getRazaoSocial());
		}

		txtID.setText(codigoEmString);
		txtNome.setText(ClientController.clienteSelecionado.getNome());
		txtEmail.setText(ClientController.clienteSelecionado.getEmail());
		txtCelular.setText(ClientController.clienteSelecionado.getTelefoneCel());
		txtTelefone.setText(ClientController.clienteSelecionado.getTelefoneFixo());
		txtObservacao.setText(ClientController.clienteSelecionado.getOBS());
		txtEndereco.setText(ClientController.clienteSelecionado.getEndereco().getRua() );
		String CEPemString = String.valueOf((ClientController.clienteSelecionado.getEndereco().getCEP()));
		txtCEP.setText(CEPemString);
		txtBairro.setText(ClientController.clienteSelecionado.getEndereco().getBairro());
		txtComplemento.setText(ClientController.clienteSelecionado.getEndereco().getComplemento());
		txtCidade.setText(ClientController.clienteSelecionado.getEndereco().getCidade());
		txtEstado.setText(ClientController.clienteSelecionado.getEndereco().getEstado());
	}
}
