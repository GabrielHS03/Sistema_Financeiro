package util;

import java.io.InputStream;
import java.util.List;

import model.Boleto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {
	public void gerarRelatorioPorCliente(List<Boleto> listaBoletos) throws JRException {

		InputStream arq = Relatorio.class.getResourceAsStream("/view/RelatorioPorCliente.jrxml");

		JasperReport report = JasperCompileManager.compileReport(arq);

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaBoletos));

		JasperViewer.viewReport(print, false);

	}

	public void gerarRelatorioAReceberPorData(List<Boleto> listaBoletos) throws JRException {

		InputStream arq = Relatorio.class.getResourceAsStream("/view/RelatorioApagarPorData.jrxml");

		JasperReport report = JasperCompileManager.compileReport(arq);

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaBoletos));

		JasperViewer.viewReport(print, false);

	}

	public void gerarRelatorioRecebidosPorData(List<Boleto> listaBoletos) throws JRException {

		InputStream arq = Relatorio.class.getResourceAsStream("/view/RelatorioRecebidoPorData.jrxml");

		JasperReport report = JasperCompileManager.compileReport(arq);

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(listaBoletos));

		JasperViewer.viewReport(print, false);

	}

}
