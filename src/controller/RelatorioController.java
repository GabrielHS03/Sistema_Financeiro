package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import DAO.BoletoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
import model.Cliente;
import net.sf.jasperreports.engine.JRException;
import util.Relatorio;


public class RelatorioController implements Initializable {
	
	@FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView btnHome;

    @FXML
    private Button btnGerarRelatorio;
    
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
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		comboBox.getItems().addAll("Por nome", "A receber por data", "Recebida por data");
		choice();

	}
	
	@FXML
	void btnHome(MouseEvent event) throws IOException {
		carregarTelaHome();
	}
	
    @FXML
    void btnGerarRelatorio(ActionEvent event) {
    	Date initialDate;
    	Date finalDate;
		List<Boleto> listaDeBoletos = new ArrayList<>();
		List<Boleto> listaRelatorio = new ArrayList<>();
		Relatorio r = new Relatorio();
		BoletoDAO boletoDAO = new BoletoDAO();
		listaDeBoletos = boletoDAO.buscarTodos();
		
		
    	switch(comboBox.getValue()) {
    		case "Por nome":
    			for(Boleto b : listaDeBoletos) {
    				if(b.getNomeCliente().equals(txtCliente.getText())) {
    					listaRelatorio.add(b);
    				}
    			}
    			
    			try {
    				r.gerarRelatorioPorCliente(listaRelatorio);
    			} catch (JRException e) {
    				e.printStackTrace();
    			}
    			break;
    		case "A receber por data": 	
    	    	initialDate = java.sql.Date.valueOf(dataInicial.getValue());
    	    	finalDate = java.sql.Date.valueOf(dataFinal.getValue());
    			for(Boleto b : listaDeBoletos) {
    				if((b.getVencimento().compareTo(initialDate)>0) && (b.getVencimento().compareTo(finalDate)<0)) {
    					if(b.getStatus().equals("A PAGAR")) {
    						listaRelatorio.add(b);
    					}		
    				}
    			}	
    			
    			try {
    				r.gerarRelatorioAReceberPorData(listaRelatorio);
    			} catch (JRException e) {
    				e.printStackTrace();
    			}
    			break;
    		case "Recebida por data":
    	    	initialDate = java.sql.Date.valueOf(dataInicial.getValue());
    	    	finalDate = java.sql.Date.valueOf(dataFinal.getValue());
    			for(Boleto b : listaDeBoletos) {
    				if((b.getDataPagamento().compareTo(initialDate)>0) && (b.getDataPagamento().compareTo(finalDate)<0)) {
    					if(b.getStatus().equals("PAGO")) {
    						listaRelatorio.add(b);
    					}
    				}
    			}
    			
    			try {
    				r.gerarRelatorioRecebidosPorData(listaRelatorio);
    			} catch (JRException e) {
    				e.printStackTrace();
    			}
    			break;
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
