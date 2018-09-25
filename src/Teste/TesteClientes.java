package Teste;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DAO.BoletoDAO;
import DAO.ClienteDAO;
import DAO.EnderecoDAO;
import javafx.util.converter.LocalDateStringConverter;
import model.Boleto;
import model.Cliente;
import model.Endereco;

public class TesteClientes {

	public static void main(String[] args) {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		//------------------------------------------------------
		Cliente cliente1 = new Cliente();
		Endereco endereco1 = new Endereco();
		cliente1.setCodigo(12345);
		cliente1.setNome("Franklin N. Silva");
		cliente1.setCPF("754.862.611-87");
		cliente1.setEmail("franklin.tekk@hotmail.com");
		cliente1.setTelefoneFixo("(15)98824-0132");
		cliente1.setTelefoneCel("(15)99924-0132");
		cliente1.setOBS("Teste");
		
		endereco1.setRua("Trv. Maurity N. 46");
		endereco1.setCEP("75020-270");
		endereco1.setBairro("Centro");
		endereco1.setComplemento("próximo a praça");
		endereco1.setCidade("Anápolis");
		endereco1.setEstado("GO");

		cliente1.setEndereco(endereco1);
		
		clienteDAO.save(cliente1);
		enderecoDAO.save(endereco1);
		//------------------------------------------------------
		//------------------------------------------------------
		Cliente cliente2 = new Cliente();
		Endereco endereco2 = new Endereco();
		cliente2.setCodigo(24156);
		cliente2.setNome("Gabriel Henrique Silva");
		cliente2.setCPF("742.214.472-85");
		cliente2.setEmail("gabriel.hs03@outlook.com");
		cliente2.setTelefoneFixo(null);
		cliente2.setTelefoneCel("(62)99914-7541");
		cliente2.setOBS("Teste2");
		
		endereco2.setRua("rua 15 numero 02");
		endereco2.setCEP("52417-240");
		endereco2.setBairro("Jundiai");
		endereco2.setComplemento("próximo ao supervi");
		endereco2.setCidade("Anápolis");
		endereco2.setEstado("GO");

		cliente2.setEndereco(endereco2);
		
		clienteDAO.save(cliente2);
		enderecoDAO.save(endereco2);
		//------------------------------------------------------
		//------------------------------------------------------
		Cliente cliente3 = new Cliente();
		Endereco endereco3 = new Endereco();
		cliente3.setCodigo(45217);
		cliente3.setNome("das das das ");
		cliente3.setCPF("345.123.756-34");
		cliente3.setEmail("dasdasd@adsdas");
		cliente3.setTelefoneFixo(null);
		cliente3.setTelefoneCel("(62)43567-1234");
		cliente3.setOBS("Teste3");
		
		endereco3.setRua("fasdf asdf asd");
		endereco3.setCEP("74521-965");
		endereco3.setBairro("fsadfsadf");
		endereco3.setComplemento("rutyurtyu");
		endereco3.setCidade("Anápolis");
		endereco3.setEstado("GO");

		cliente3.setEndereco(endereco3);
		
		clienteDAO.save(cliente3);
		enderecoDAO.save(endereco3);
		//------------------------------------------------------
		//------------------------------------------------------
		Cliente cliente4 = new Cliente();
		Endereco endereco4 = new Endereco();
		cliente4.setCodigo(74526);
		cliente4.setNome("dfgjdtfyhj asdfd");
		cliente4.setCPF("852.142.742-34");
		cliente4.setEmail("fasdfsadf@adsdas");
		cliente4.setTelefoneFixo(null);
		cliente4.setTelefoneCel("(62)74521-1234");
		cliente4.setOBS("Teste4");
		
		endereco4.setRua("gsdfg sdfg d f");
		endereco4.setCEP("74521-965");
		endereco4.setBairro("fsadfsadf");
		endereco4.setComplemento("rutyurtyu");
		endereco4.setCidade("Anápolis");
		endereco4.setEstado("GO");

		cliente4.setEndereco(endereco4);
		
		clienteDAO.save(cliente4);
		enderecoDAO.save(endereco4);
		//------------------------------------------------------
		//------------------------------------------------------
		Cliente cliente5 = new Cliente();
		Endereco endereco5 = new Endereco();
		cliente5.setCodigo(56241);
		cliente5.setNome("tyiotyiu tyui yu");
		cliente5.setCPF("985.421.742-34");
		cliente5.setEmail("fasdfsadf@adsdas");
		cliente5.setTelefoneFixo(null);
		cliente5.setTelefoneCel("(62)74521-1234");
		cliente5.setOBS("Teste5");
		
		endereco5.setRua("gsdfg sdfg gdsf");
		endereco5.setCEP("74521-965");
		endereco5.setBairro("fsadfsadf");
		endereco5.setComplemento("rutyurtyu");
		endereco5.setCidade("Anápolis");
		endereco5.setEstado("GO");

		cliente5.setEndereco(endereco5);
		
		clienteDAO.save(cliente5);
		enderecoDAO.save(endereco5);
		//------------------------------------------------------
		Cliente cliente6 = new Cliente();
		Endereco endereco6 = new Endereco();
		cliente6.setCodigo(41258);
		cliente6.setNome("erwt wert wer");
		cliente6.setCPF("241.746.742-34");
		cliente6.setEmail("fasdfsadf@adsdas");
		cliente6.setTelefoneFixo("(62)74521-1234");
		cliente6.setTelefoneCel(null);
		cliente6.setOBS("Teste6");
		
		endereco6.setRua("gsdfg sdfg gdsf");
		endereco6.setCEP("74521-965");
		endereco6.setBairro("fsadfsadf");
		endereco6.setComplemento("rutyurtyu");
		endereco6.setCidade("Anápolis");
		endereco6.setEstado("GO");

		cliente6.setEndereco(endereco6);
		
		clienteDAO.save(cliente6);
		enderecoDAO.save(endereco6);
		//------------------------------------------------------
		//------------------------------------------------------
		Cliente cliente7 = new Cliente();
		Endereco endereco7 = new Endereco();
		cliente7.setCodigo(74695);
		cliente7.setNome("qwer qwer qwe");
		cliente7.setCPF("124.986.742-34");
		cliente7.setEmail("fasdfsadf@adsdas");
		cliente7.setTelefoneFixo("(62)74521-1234");
		cliente7.setTelefoneCel(null);
		cliente7.setOBS("Teste7");
		
		endereco7.setRua("gsdfg sdfg gdsf");
		endereco7.setCEP("74521-965");
		endereco7.setBairro("fsadfsadf");
		endereco7.setComplemento("rutyurtyu");
		endereco7.setCidade("Anápolis");
		endereco7.setEstado("GO");

		cliente7.setEndereco(endereco7);
		
		clienteDAO.save(cliente7);
		enderecoDAO.save(endereco7);
		//------------------------------------------------------
		//------------------------------------------------------
		Cliente cliente8 = new Cliente();
		Endereco endereco8 = new Endereco();
		cliente8.setCodigo(78452);
		cliente8.setNome("mbvnmbm vbnm");
		cliente8.setCPF("524.784.742-34");
		cliente8.setEmail("fasdfsadf@adsdas");
		cliente8.setTelefoneFixo("(62)74521-1234");
		cliente8.setTelefoneCel(null);
		cliente8.setOBS("Teste8");
		
		endereco8.setRua("gsdfg sdfg gdsf");
		endereco8.setCEP("74521-965");
		endereco8.setBairro("fsadfsadf");
		endereco8.setComplemento("rutyurtyu");
		endereco8.setCidade("Anápolis");
		endereco8.setEstado("GO");

		cliente8.setEndereco(endereco8);
		
		clienteDAO.save(cliente8);
		enderecoDAO.save(endereco8);
		//------------------------------------------------------
		//------------------------------------------------------
		Cliente cliente9 = new Cliente();
		Endereco endereco9 = new Endereco();
		cliente9.setCodigo(12475);
		cliente9.setNome("zxcv zxcv zxc ");
		cliente9.setCPF("741.125.742-34");
		cliente9.setEmail("fasdfsadf@adsdas");
		cliente9.setTelefoneFixo("(62)74521-1234");
		cliente9.setTelefoneCel(null);
		cliente9.setOBS("Teste9");
		
		endereco9.setRua("gsdfg sdfg gdsf");
		endereco9.setCEP("74521-965");
		endereco9.setBairro("fsadfsadf");
		endereco9.setComplemento("rutyurtyu");
		endereco9.setCidade("Anápolis");
		endereco9.setEstado("GO");

		cliente9.setEndereco(endereco9);
		
		clienteDAO.save(cliente9);
		enderecoDAO.save(endereco9);
		//------------------------------------------------------
		//------------------------------------------------------
		Cliente cliente10 = new Cliente();
		Endereco endereco10 = new Endereco();
		cliente10.setCodigo(14256);
		cliente10.setNome("cxbv cvb xcvb");
		cliente10.setCPF("542.784.742-34");
		cliente10.setEmail("fasdfsadf@adsdas");
		cliente10.setTelefoneFixo("(62)74521-1234");
		cliente10.setTelefoneCel(null);
		cliente10.setOBS("Teste10");
		
		endereco10.setRua("gsdfg sdfg gdsf");
		endereco10.setCEP("74521-965");
		endereco10.setBairro("fsadfsadf");
		endereco10.setComplemento("rutyurtyu");
		endereco10.setCidade("Anápolis");
		endereco10.setEstado("GO");

		cliente10.setEndereco(endereco10);
		
		clienteDAO.save(cliente10);
		enderecoDAO.save(endereco10);
		//------------------------------------------------------
		//------------------------------------------------------
		Cliente cliente11 = new Cliente();
		Endereco endereco11 = new Endereco();
		cliente11.setCodigo(74521);
		cliente11.setNome("Mc Donalds");
		cliente11.setRazaoSocial("Mmb Comercio De Alimentos Ltda.");
		cliente11.setCNPJ("03.449.275/0001-03");
		cliente11.setEmail("comercial@mcdonalds.com");
		cliente11.setTelefoneFixo("(11)33215-478");
		cliente11.setTelefoneCel(null);
		cliente11.setOBS("Teste11");
		
		endereco11.setRua("R Serra De Braganca, 395");
		endereco11.setCEP("03318-000");
		endereco11.setBairro("Jardim Paulista");
		endereco11.setComplemento("rutyurtyu");
		endereco11.setCidade("São Paulo");
		endereco11.setEstado("SP");

		cliente11.setEndereco(endereco11);
		
		clienteDAO.save(cliente11);
		enderecoDAO.save(endereco11);
		//------------------------------------------------------
		//------------------------------------------------------
		Cliente cliente12 = new Cliente();
		Endereco endereco12 = new Endereco();
		cliente12.setCodigo(65214);
		cliente12.setNome("Burger King ");
		cliente12.setRazaoSocial("Fast Burger Comercio De Alimentos S/a");
		cliente12.setCNPJ("07.415.082/0001-84");
		cliente12.setEmail("contato@burgerking.com");
		cliente12.setTelefoneFixo("(11)32145-742");
		cliente12.setTelefoneCel(null);
		cliente12.setOBS("Teste12");
		
		endereco12.setRua("Rod Br Trezentos E Cinquenta E Seis, 3049");
		endereco12.setCEP("30320-055");
		endereco12.setBairro("Belvedere");
		endereco12.setComplemento("rutyurtyu");
		endereco12.setCidade("Belo Horizonte");
		endereco12.setEstado("MG");

		cliente12.setEndereco(endereco12);
		
		clienteDAO.save(cliente12);
		enderecoDAO.save(endereco12);
		//------------------------------------------------------
		BoletoDAO boletoDAO = new BoletoDAO();
		List<Boleto> listaBoletos = new ArrayList<>();
		//=========================================================

		Boleto boleto = new Boleto();	
		
		boleto.setCodigo(111);
		boleto.setValor(100);
		boleto.setStatus("A PAGAR");
		boleto.setCliente(cliente2);
		boleto.setOBS(null);
		
        String date = "2018-10-01";
        LocalDate localDate = LocalDate.parse(date);
		
		boleto.setVencimento(java.sql.Date.valueOf(localDate));
		LocalDate horaCadastro = LocalDate.now();
		boleto.setCadastro(java.sql.Date.valueOf(horaCadastro));
		boleto.setTipoPagamento("Nota Fiscal");
		boleto.setNomeCliente(cliente2.getNome());
		listaBoletos.add(boleto);
		cliente2.setBoletos(listaBoletos);
		boletoDAO.save(boleto);
		//=========================================================
		//=========================================================
		Boleto boleto2 = new Boleto();	
		
		boleto2.setCodigo(222);
		boleto2.setValor(200);
		boleto2.setStatus("A PAGAR");
		boleto2.setCliente(cliente2);
		boleto2.setOBS(null);
		
        String date2 = "2018-10-03";
        LocalDate localDate2 = LocalDate.parse(date2);
		
		boleto2.setVencimento(java.sql.Date.valueOf(localDate2));
		boleto2.setCadastro(java.sql.Date.valueOf(horaCadastro));
		boleto2.setTipoPagamento("Carne");
		boleto2.setNomeCliente(cliente2.getNome());
		listaBoletos.add(boleto2);
		cliente2.setBoletos(listaBoletos);
		boletoDAO.save(boleto2);
		//=========================================================

		//=========================================================
		Boleto boleto3 = new Boleto();	
		
		boleto3.setCodigo(333);
		boleto3.setValor(300);
		boleto3.setStatus("A PAGAR");
		boleto3.setCliente(cliente2);
		boleto3.setOBS(null);
		
        String date3 = "2018-10-05";
        LocalDate localDate3 = LocalDate.parse(date3);
		
		boleto3.setVencimento(java.sql.Date.valueOf(localDate3));
		boleto3.setCadastro(java.sql.Date.valueOf(horaCadastro));
		boleto3.setTipoPagamento("Recibo");
		boleto3.setNomeCliente(cliente2.getNome());
		listaBoletos.add(boleto3);
		cliente2.setBoletos(listaBoletos);
		boletoDAO.save(boleto3);
		//=========================================================

		//=========================================================
		Boleto boleto4 = new Boleto();	
		
		boleto4.setCodigo(444);
		boleto4.setValor(400);
		boleto4.setStatus("A PAGAR");
		boleto4.setCliente(cliente2);
		boleto4.setOBS(null);
		
        String date4 = "2018-10-08";
        LocalDate localDate4 = LocalDate.parse(date4);
		
		boleto4.setVencimento(java.sql.Date.valueOf(localDate4));
		boleto4.setCadastro(java.sql.Date.valueOf(horaCadastro));
		boleto4.setTipoPagamento("Deposito");
		boleto4.setNomeCliente(cliente2.getNome());
		listaBoletos.add(boleto4);
		cliente2.setBoletos(listaBoletos);
		boletoDAO.save(boleto4);
		//=========================================================
		System.exit(0);
	}

}
