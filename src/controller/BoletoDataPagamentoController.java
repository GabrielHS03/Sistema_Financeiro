package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import DAO.BoletoDAO;
import application.BoletoDataPagamento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import model.Boleto;

public class BoletoDataPagamentoController implements Initializable {

    @FXML
    private DatePicker pikerDataPagamento;
	@FXML
    private Button btnOK;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

    @FXML
    void btnOK(ActionEvent event) {
	
		List<Boleto> listaDeBoletos = new ArrayList<>();
		BoletoDAO boletoDAO = new BoletoDAO();
		listaDeBoletos = boletoDAO.buscarTodos();
		
		for(Boleto b : listaDeBoletos) {
			if(b.getCodigo() == BoletoController.codigoBoleto) {
				b.setDataPagamento(java.sql.Date.valueOf(pikerDataPagamento.getValue()));
				boletoDAO.save(b);
				
			}

		}	
		
    	BoletoDataPagamento.getStage().close();
    }
}
