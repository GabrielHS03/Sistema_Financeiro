package util;

import java.io.InputStream;
import java.util.List;

import model.Boleto;
import model.Carro;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {
	public void gerarRelatorio(List<Boleto> listaBoletos) throws JRException {
		
		InputStream arq = Relatorio.class.getResourceAsStream("/view/RelatorioCarros.jrxml");
	
		JasperReport report = JasperCompileManager.compileReport(arq);
		
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaBoletos));
		
		JasperViewer.viewReport(print, false);
		
	}
}
