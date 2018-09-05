package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.ClienteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.input.KeyEvent;
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
	
	private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();;

	
	public void initialize(URL url, ResourceBundle rb) {
		
		setarDados();
		comboBox.getItems().addAll("CPF", "CNPJ");
		choice();
		
		carregarTableViewClientes();
		
		tbCliente.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> carregarDadosCliente(newValue));

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
			
			if(comboBox.getValue() == "CPF") {
				cliente.setCPF(Long.parseLong(txtCPFCNPJ.getText()));
			}else {
				cliente.setCNPJ(Long.parseLong(txtCPFCNPJ.getText()));
				cliente.setRazaoSocial(txtRazaoSocial.getText());
			}
			
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

			listaClientes.add(cliente);
		}
		
		tbCliente.setItems(listaClientes);
		tbClienteColumnID.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbClienteColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbClienteColumnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		tbClienteColumnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
		tbClienteColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
	}
		
    @FXML
    public void pesquisarTabela(KeyEvent event) {

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
                
                if ((cliente.getNome().toLowerCase().indexOf(typedText) != -1) || (codigoEmString.toLowerCase().indexOf(typedText) != -1) || (cpfEmString.toLowerCase().indexOf(typedText) != -1) || (cnpjEmString.toLowerCase().indexOf(typedText) != -1)) {

                    return true;
                }

                
                return false;
            });
            SortedList<Cliente> listaClientesSorted = new SortedList<>(listaClientesFiltered);
            listaClientesSorted.comparatorProperty().bind(tbCliente.comparatorProperty());
            tbCliente.setItems(listaClientesSorted);                      
        });
    }

	public void recarregarTela() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Cliente.Principal.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	public void carregarTelaAlterar() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Cliente.Alterar.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	public void carregarDadosCliente(Cliente cliente) {
		System.out.println(cliente.getNome());
		
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