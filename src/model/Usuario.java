package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Entity e para especificar que vai ser uma tabela no banco , que no banco e TB_Usuario!

@Entity(name = "TB_Usuario")

public class Usuario {

	// ID para especificar para o banco de dados que e um ID
	// Generated e para especificar para o banco que e uma chave primaria de auto Incremental
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	private String usuario;
	private String senha;
	
	

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
