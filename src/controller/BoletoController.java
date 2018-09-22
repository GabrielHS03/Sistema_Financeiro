package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import DAO.BoletoDAO;
import DAO.ClienteDAO;
import application.BoletoDataPagamento;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.DefaultStringConverter;
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
    private TableColumn<Boleto, String> columnVencimento;

    @FXML
    private TableColumn<Boleto, String> columnStatus;

    @FXML
    private TableColumn<?, ?> columnObserva��o;
    
    @FXML
    private TextField searchBox;
    
	private ObservableList<Boleto> listaDeBoletos = FXCollections.observableArrayList();

	private Cliente clienteSelecionado;
	private Integer codigoDoBoletoSelecionado;
	public static Date dataPagamento;
	public static int codigoBoleto; //� usado para setar a data de pagamento do boleto
	
	// =============================================================================================================
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		comboBox.getItems().addAll("Nota Fiscal", "Carne", "Recibo", "Deposito");
		
		
		pesquisarCliente();		

		tbBoletos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			codigoDoBoletoSelecionado = newValue.getCodigo();
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
    
//    @FXML
//    void searchBox(KeyEvent event) {
//    	FilteredList<Boleto> listaBoletosFiltered = new FilteredList<>(listaDeBoletos, p -> true);
//		searchBox.textProperty().addListener((obsevable, oldvalue, newvalue) -> {
//			listaBoletosFiltered.setPredicate(boleto -> {
//
//				if (newvalue == null || newvalue.isEmpty()) {
//					return true;
//				}
//				String typedText = newvalue.toLowerCase();
//
//				String data = boleto.getVencimento();
//
//				if ((boleto.getVencimento().toLowerCase().indexOf(typedText) != -1)) {
//					return true;
//				}
//
//				return false;
//			});
//			SortedList<Boleto> listaBoletosSorted = new SortedList<>(listaBoletosFiltered);
//			listaBoletosSorted.comparatorProperty().bind(tbBoletos.comparatorProperty());
//			tbBoletos.setItems(listaBoletosSorted);
//		});
//    }
    
	// =============================================================================================================
   
    public void cadastrarBoleto() throws IOException {
		BoletoDAO boletoDAO = new BoletoDAO();
    	//-------------CONTROLE-----------------------------------------
    	boolean controle = true; 	
    	for(Boleto b : boletoDAO.buscarTodos()) {
    		if(b.getCodigo() == Integer.parseInt(txtID.getText())) {
				System.out.println("ID j� existe, digite outro!");
				controle = false;
    		}
    	}
    	//--------------------------------------------------------------
    	List<Boleto> listaBoletos = new ArrayList<>();
		Boleto boleto = new Boleto();	
		
		boleto.setCodigo(Integer.parseInt(txtID.getText()));
		boleto.setValor(Double.parseDouble(txtValor.getText()));
		boleto.setStatus("A PAGAR");
		boleto.setCliente(clienteSelecionado);
		boleto.setOBS(txtOBS.getText());
		boleto.setVencimento(java.sql.Date.valueOf(dateVencimento.getValue()));
		LocalDate horaCadastro = LocalDate.now();
		boleto.setCadastro(java.sql.Date.valueOf(horaCadastro));
		boleto.setTipoPagamento(comboBox.getValue());
		boleto.setNomeCliente(clienteSelecionado.getNome());
		listaBoletos.add(boleto);
		clienteSelecionado.setBoletos(listaBoletos);
		

		
		if(controle == true) {
			boletoDAO.save(boleto);
		}
		
		setarTabelaBoletos();  

    }
	
    public void pesquisarCliente() {
		List<Integer> listaDeCodigos = new ArrayList<>();
		
		ClienteDAO clienteDAO = new ClienteDAO();
		for (Cliente cliente : clienteDAO.buscarTodos()) {
			listaDeCodigos.add(cliente.getCodigo());
		}
		
		TextFields.bindAutoCompletion(txtCodigo, listaDeCodigos);
		txtCodigo.textProperty().addListener((obsevable, oldvalue, newvalue) -> {
			for (Cliente cliente : clienteDAO.buscarTodos()) {
				if(cliente.getCodigo() == Integer.parseInt(txtCodigo.getText())) {
					setarTabelaBoletos();  
				}
			}
		});
	}
	
	public void setarTabelaBoletos() {
		
		tbBoletos.getItems().removeAll(listaDeBoletos);
		ClienteDAO clienteDAO = new ClienteDAO();
		for (Cliente cliente : clienteDAO.buscarTodos()) {
			if(cliente.getCodigo() == Integer.parseInt(txtCodigo.getText())) {
				clienteSelecionado = cliente;
				for(Boleto b : cliente.getBoletos()){
					listaDeBoletos.add(b);
				}
				
				Collections.sort(listaDeBoletos);
				tbBoletos.setItems(listaDeBoletos);
				columnID.setCellValueFactory(new PropertyValueFactory<>("codigo"));
				columnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
				columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
				columnStatus.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), FXCollections.observableArrayList("PAGO","A PAGAR")));
				columnStatus.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Boleto,String>>() {
					
					@Override
					public void handle(CellEditEvent<Boleto, String> event) {
						
						List<Boleto> listaDeBoletos = new ArrayList<>();
						BoletoDAO boletoDAO = new BoletoDAO();
						listaDeBoletos = boletoDAO.buscarTodos();
						
						for(Boleto b : listaDeBoletos) {
							if(b.getCodigo().equals(codigoDoBoletoSelecionado)){
								if(b.getStatus().equals("PAGO")) {
									Alert msg = new Alert(Alert.AlertType.ERROR);
									msg.setTitle("Status");
									msg.setContentText("Este pagamento j� foi efetuado!");
									msg.setHeaderText(null);
									msg.showAndWait();
									try {
										recarregarTela();
										break;
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
								b.setStatus(event.getNewValue());
								carregarTelaDataPagamento();
								codigoBoleto = b.getCodigo();
								boletoDAO.save(b);
							}
	
						}														
					}
				});
				tbBoletos.setEditable(true);
				columnObserva��o.setCellValueFactory(new PropertyValueFactory<>("OBS"));
				columnVencimento.setCellValueFactory(
				           Job -> {
				               SimpleStringProperty property = new SimpleStringProperty();
				               DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				               property.setValue(dateFormat.format(Job.getValue().getVencimento()));
				               return property;
				            });
				
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
	   
	   public void carregarTelaDataPagamento() {
		   BoletoDataPagamento boletoDataPagamento= new BoletoDataPagamento();
			try {
				boletoDataPagamento.start(new Stage());
			} catch (Exception e) {
				e.getMessage();
			}
		}

}
