package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity(name = "TB_Boleto")
public class Boleto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	private Float valor;
	private String status;
	private String OBS;
	private String tipoPagamento;
	@OneToMany(cascade = CascadeType.ALL)
	private Cliente cliente;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOBS() {
		return OBS;
	}

	public void setOBS(String oBS) {
		OBS = oBS;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	

}
