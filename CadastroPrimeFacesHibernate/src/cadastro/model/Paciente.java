package cadastro.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the paciente database table.
 * 
 */
@Entity
@Table(name="paciente")
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=20)
	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="data_de_atendimento", nullable=false)
	private Date dataDeAtendimento;

	@Column(nullable=false, length=40)
	private String email;

	@Column(nullable=false, length=20)
	private String medico;

	@Column(nullable=false, length=20)
	private String nome;

	public Paciente() {}

	public Paciente(String cpf, Date dataDeAtendimento, String email, String medico, String nome) {
		super();
		this.cpf = cpf;
		this.dataDeAtendimento = dataDeAtendimento;
		this.email = email;
		this.medico = medico;
		this.nome = nome;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataDeAtendimento() {
		return this.dataDeAtendimento;
	}

	public void setDataDeAtendimento(Date dataDeAtendimento) {
		this.dataDeAtendimento = dataDeAtendimento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMedico() {
		return this.medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}