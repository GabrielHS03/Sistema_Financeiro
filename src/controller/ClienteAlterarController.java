package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.ClienteDAO;
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
import javafx.scene.layout.AnchorPane;
import model.Cliente;

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
	private TableColumn<?, ?> tbClienteColumnEndereco;

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
	private TextArea txtObservacao;
	
	@FXML
	private ImageView imgHome;
	
	
	public void initialize(URL url, ResourceBundle rb) {
		
		setarDados();
		
		imgHome.setOnMouseClicked(MouseEvent -> {
			AnchorPane pane;
			try {
				pane = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
				rootPane.getChildren().setAll(pane);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		});

		btnAlterarCliente.setOnMouseClicked(MouseEvent -> {
			Cliente cliente = new Cliente();
			ClienteDAO clienteDAO = new ClienteDAO();

			cliente.setCodigo(Integer.parseInt(txtID.getText()));
			cliente.setNome(txtNome.getText());
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

	public void recarregarTela() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Cliente.Principal.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	public void setarDados() {
		String codigoEmString = Integer.toString(ClientController.clienteSelecionado.getCodigo());
	    String cpfEmString = String.valueOf(ClientController.clienteSelecionado.getCPF());
        String cnpjEmString = String.valueOf(ClientController.clienteSelecionado.getCNPJ());
        
        System.out.println(cnpjEmString);
        if(cnpjEmString == "null") {
        	txtCPFCNPJ.setText(cpfEmString);
        }
        if(cpfEmString == "null") {
        	txtCPFCNPJ.setText(cnpjEmString);
			txtRazaoSocial.setVisible(true);
			lblCNPJ.setVisible(true);
			lblCPFCNPJ.setText("CNPJ:*");
			lblNome.setText("Nome Fantasia:*");
        }
        
        txtID.setText(codigoEmString);
		txtNome.setText(ClientController.clienteSelecionado.getNome());
		
	}
	

}
