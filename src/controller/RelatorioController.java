package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import DAO.CidadeDAO;
import DAO.ClienteDAO;
import DAO.EstadoDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Boleto;
import model.Cidade;
import model.Estado;
import net.sf.jasperreports.engine.JRException;
import model.Carro;
import util.Relatorio;


public class RelatorioController implements Initializable {
	
	@FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView btnHome;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private DatePicker dataInicial;

    @FXML
    private DatePicker dataFinal;
    
    @FXML
    private Label lblDataInicial;

    @FXML
    private Label lblDataFinal;

    @FXML
    private Label lblNome;

    @FXML
    private TextField txtCliente;
    
    @FXML
    private TableView<Boleto> tbRelatorio;

    @FXML
    private TableColumn<?, ?> columnCodigo;

    @FXML
    private TableColumn<?, ?> columnValor;

    @FXML
    private TableColumn<?, ?> columnStatus;

    @FXML
    private TableColumn<?, ?> columnCadastro;

    @FXML
    private TableColumn<?, ?> columnVencimento;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		comboBox.getItems().addAll("Por nome", "A receber por data", "Recebida por data");
		choice();

	}
	
	@FXML
	void btnHome(MouseEvent event) throws IOException {
		//carregarTelaHome();
		
		List<Carro> listaDeCarros = new ArrayList<>();
		
		Carro carro1 = new Carro();
		carro1.setMarca("Toyota");
		carro1.setModelo("Camaro");
		carro1.setCor("Branco");
		carro1.setAno(2018);
		
		Carro carro2 = new Carro();
		carro2.setMarca("Toyota");
		carro2.setModelo("Camaro");
		carro2.setCor("preto");
		carro2.setAno(2018);
		listaDeCarros.add(carro2);
		
			
		Relatorio r = new Relatorio();
		try {
			r.gerarRelatorio(listaDeCarros);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void choice() {

		comboBox.setOnAction(e -> {
			switch (comboBox.getValue()) {
			case "Por nome":
				lblNome.setVisible(true);
				lblDataFinal.setVisible(false);
				lblDataInicial.setVisible(false);
				txtCliente.setVisible(true);
				dataInicial.setVisible(false);
				dataFinal.setVisible(false);
				
				break; 
			case "A receber por data":
				lblNome.setVisible(false);
				lblDataFinal.setVisible(true);
				lblDataInicial.setVisible(true);
				txtCliente.setVisible(false);
				dataInicial.setVisible(true);
				dataFinal.setVisible(true);
				
				break;
			
			case "Recebida por data":
				lblNome.setVisible(false);
				lblDataFinal.setVisible(true);
				lblDataInicial.setVisible(true);
				txtCliente.setVisible(false);
				dataInicial.setVisible(true);
				dataFinal.setVisible(true);
				break;
			}
		});

	}
	  public void carregarTelaHome() throws IOException {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
			rootPane.getChildren().setAll(pane);
	    }

}
