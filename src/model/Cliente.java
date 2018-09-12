package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "TB_Cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private Integer codigo;
    private String nome;
    private String razaoSocial;
    private String telefoneFixo;
    private String telefoneCel;
    private Long CPF;
    private Long CNPJ;
    private String email;
    private String OBS;
    @OneToOne(cascade = CascadeType.ALL)
   	private Endereco endereco;
    //@OneToMany(targetEntity = Boleto.class, mappedBy = "cliente", cascade = CascadeType.ALL)
    //private List <Boleto> boletos;
    private boolean status = true;
    

	public Cliente() {
		super();
	}

	public Cliente(Integer iD, Integer codigo, String nome, String razaoSocial, String telefoneFixo, String telefoneCel,
			Long cPF, Long cNPJ, String email, String oBS, Endereco endereco) {
		super();
		ID = iD;
		this.codigo = codigo;
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCel = telefoneCel;
		CPF = cPF;
		CNPJ = cNPJ;
		this.email = email;
		OBS = oBS;
		this.endereco = endereco;
	}

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
    
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public String getTelefoneCel() {
        return telefoneCel;
    }

    public void setTelefoneCel(String telefoneCel) {
        this.telefoneCel = telefoneCel;
    }
    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
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
    public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

//	public List<Boleto> getBoletos() {
//		return boletos;
//	}
//
//	public void setBoletos(List<Boleto> boletos) {
//		this.boletos = boletos;
//	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
    
    
}
