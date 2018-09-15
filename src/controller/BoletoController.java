package controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import DAO.BoletoDAO;
import DAO.ClienteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Boleto;
import model.Cliente;


public class BoletoController implements Initializable {
	
    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField txtValor;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextArea txtOBS;

    @FXML
    private TextField txtID;

    @FXML
    private DatePicker dateVencimento;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TableView<Boleto> tbBoletos;

    @FXML
    private TableColumn<?, ?> columnID;

    @FXML
    private TableColumn<?, ?> columnValor;

    @FXML
    private TableColumn<?, ?> columnVencimento;

    @FXML
    private TableColumn<?, ?> columnStatus;

    @FXML
    private TableColumn<?, ?> columnObservação;
    
    
	private ObservableList<Boleto> listaDeBoletos = FXCollections.observableArrayList();
	
	private Cliente clienteSelecionado;
	
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
	
	// =============================================================================================================
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		comboBox.getItems().addAll("A Vista", "Cartão", "Nota Fiscal", "Carne", "Recibo", "Deposito");
		
		
		pesquisarCliente();		

		tbBoletos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			
			System.out.println("TESTE");
			tbBoletos.getItems().removeAll(listaDeBoletos);
			//setarTabelaBoletos(); 
		});
	}

	// =============================================================================================================
    @FXML
    void btnHome(MouseEvent event) throws IOException {
    	carregarTelaHome();
    }
    
    @FXML
    void btnSalvar(ActionEvent event) throws IOException {
    	cadastrarBoleto();
    }
    @FXML
    void txtCodigo(ActionEvent event) {
    	setarTabelaBoletos();    	
    }
    
	// =============================================================================================================
   
    public void cadastrarBoleto() throws IOException {
    	
    	
    	ClienteDAO clienteDAO = new ClienteDAO();
    	List<Boleto> listaBoletos = new ArrayList<>();
		Boleto boleto = new Boleto();	
		BoletoDAO boletoDAO = new BoletoDAO();
		
		boleto.setCodigo(Integer.parseInt(txtID.getText()));
		boleto.setValor(Double.parseDouble(txtValor.getText()));
		boleto.setStatus("A PAGAR");
		boleto.setCliente(clienteSelecionado);
		boleto.setOBS(txtOBS.getText());
		
		LocalDate vencimento = dateVencimento.getValue();
		DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formatado = vencimento.format(formatar);
		boleto.setVencimento(formatado);
		
		listaBoletos.add(boleto);
		clienteSelecionado.setBoletos(listaBoletos);
		
		LocalDate horaCadastro = LocalDate.now();
		DateTimeFormatter formatarCadastro = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formatado2 = horaCadastro.format(formatarCadastro);
		boleto.setCadastro(formatado2);
		boleto.setTipoPagamento(comboBox.getValue());
		
		boletoDAO.save(boleto);
		
		tbBoletos.getItems().removeAll(listaDeBoletos);
		setarTabelaBoletos();  

    }
	
    public void pesquisarCliente() {
		List<Integer> listaDeCodigos = new ArrayList<>();
		
		ClienteDAO clienteDAO = new ClienteDAO();
		for (Cliente cliente : clienteDAO.buscarTodos()) {
			listaDeCodigos.add(cliente.getCodigo());
		}
		
		TextFields.bindAutoCompletion(txtCodigo, listaDeCodigos);
		
	}
	
	public void setarTabelaBoletos() {
		ClienteDAO clienteDAO = new ClienteDAO();
		for (Cliente cliente : clienteDAO.buscarTodos()) {
			if(cliente.getCodigo() == Integer.parseInt(txtCodigo.getText())) {
				clienteSelecionado = cliente;
				for(Boleto b : cliente.getBoletos()){
					listaDeBoletos.add(b);
				}
				tbBoletos.setItems(listaDeBoletos);
				columnID.setCellValueFactory(new PropertyValueFactory<>("codigo"));
				columnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
				columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
				columnObservação.setCellValueFactory(new PropertyValueFactory<>("OBS"));
				columnVencimento.setCellValueFactory(new PropertyValueFactory<>("vencimento"));
				
			}
			
		}
	}
	   public void carregarTelaHome() throws IOException {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
			rootPane.getChildren().setAll(pane);
	    }
	   
	   public void recarregarTela() throws IOException {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Boleto.Principal.fxml"));
			rootPane.getChildren().setAll(pane);
		}

}
