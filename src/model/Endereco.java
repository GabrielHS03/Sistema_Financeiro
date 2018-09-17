package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TB_Endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	private String CEP;
	private String rua;
	private String bairro;
    //private String cidade;
   //private String estado;
    private String complemento;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

//	public String getCidade() {
//		return cidade;
//	}
//
//	public void setCidade(String cidade) {
//		this.cidade = cidade;
//	}
//
//	public String getEstado() {
//		return estado;
//	}
//
//	public void setEstado(String estado) {
//		this.estado = estado;
//	}	
	
}
