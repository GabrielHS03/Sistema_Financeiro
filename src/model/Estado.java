package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "TB_Estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	private String nome;
	private String uf;
	//@OneToMany(targetEntity = Cidade.class, mappedBy = "cidade", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private List<Cidade> cidade;


	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

//	public List<Cidade> getCidade() {
//		return cidade;
//	}
//
//	public void setCidade(List<Cidade> cidade) {
//		this.cidade = cidade;
//	}

}
