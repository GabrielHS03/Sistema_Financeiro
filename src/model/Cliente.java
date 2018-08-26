package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//Entity e para especificar que vai ser uma tabela no banco , que no banco e TB_Usuario!
@Entity(name = "TB_Cliente")
public class Cliente {
                
	// ID para especificar para o banco de dados que e um ID
	// Generated e para especificar para o banco que e uma chave primaria de auto Incremental
	
    
        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
        private Integer codigo;
        private String nome;
        private String telefone;
        private String tipo;
        private Long CPF;
        private Long CNPJ;
        private String email;
        private String OBS;
        
        // Chave estrangeira Um para Um
        
        @OneToOne
        private Endereco endereco;

        
        
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getCPF() {
        return CPF;
    }

    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }

    public Long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(Long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOBS() {
        return OBS;
    }

    public void setOBS(String OBS) {
        this.OBS = OBS;
    }
        
        
    

}
