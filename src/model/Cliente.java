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
        //private String nome;
        //private String telefone;
        //private String tipo;
        //private Integer CPF;
        //private Integer CNPJ;
       // private String email;
       // private String OBS;
        
        // Chave estrangeira Um para Um
        
       // @OneToOne
        //private Endereco endereco;

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

}
