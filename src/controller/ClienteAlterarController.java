package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import DAO.BoletoDAO;
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
import javafx.scene.layout.AnchorPane;
import model.Boleto;
import model.Cliente;
import model.Endereco;
import util.TextFieldFormatter;

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
	
	//=============================================================================================================
	// Mascara de Formatacao de Campos!
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

	//=============================================================================================================
	
	public void initialize(URL url, ResourceBundle rb) {
		setarDados();

	}

	//=============================================================================================================
    
	@FXML
    void btnAlterarCliente(ActionEvent event) throws IOException {
		Cliente cliente = new Cliente();
		cliente.setEndereco(new Endereco());
		ClienteDAO clienteDAO = new ClienteDAO();
		
		cliente.setCodigo(Integer.parseInt(txtID.getText()));
		cliente.setNome(txtNome.getText());
		// ----------------------
		String cpfEmString = String.valueOf(ClientController.clienteSelecionado.getCPF());
		String cnpjEmString = String.valueOf(ClientController.clienteSelecionado.getCNPJ());

		if (cnpjEmString == "null") {
			cliente.setCPF((txtCPFCNPJ.getText()));
		}
		if (cpfEmString == "null") {
			cliente.setCNPJ((txtCPFCNPJ.getText()));
			cliente.setRazaoSocial(txtNomeFantasia.getText());
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
		cliente.getEndereco().setCEP((txtCEP.getText()));
		cliente.getEndereco().setEstado(txtEstado.getText());
		cliente.getEndereco().setID(ClientController.clienteSelecionado.getEndereco().getID());
		clienteDAO.save(cliente);
		
		BoletoDAO boletoDAO = new BoletoDAO();
		List<Boleto> listaBoletos = new ArrayList<>();
		listaBoletos = ClientController.clienteSelecionado.getBoletos();
		
		for(Boleto b : listaBoletos) {
			b.setNomeCliente(txtNome.getText());
			boletoDAO.save(b);
		}
		
		
		ClienteAlterar.getStage().close();
		recarregarTelaClientePrincipal();

    }

    @FXML
    void btnExcluir(ActionEvent event) throws IOException {
		Cliente cliente = new Cliente();
		cliente.setEndereco(new Endereco());
		ClienteDAO clienteDAO = new ClienteDAO();
		
		cliente.setCodigo(000000);
		cliente.setNome(txtNome.getText());
		// ----------------------
		String cpfEmString = String.valueOf(ClientController.clienteSelecionado.getCPF());
		String cnpjEmString = String.valueOf(ClientController.clienteSelecionado.getCNPJ());

		if (cnpjEmString == "null") {
			cliente.setCPF((txtCPFCNPJ.getText()));
		}
		if (cpfEmString == "null") {
			cliente.setCNPJ((txtCPFCNPJ.getText()));
			cliente.setRazaoSocial(txtNomeFantasia.getText());
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
		cliente.getEndereco().setCEP((txtCEP.getText()));
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
			txtNomeFantasia.setVisible(true);
			lblCNPJ.setVisible(true);
			lblCPFCNPJ.setText("CNPJ:");
			lblNome.setText("Raz�o Social:");
			txtNomeFantasia.setText(ClientController.clienteSelecionado.getRazaoSocial());
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
