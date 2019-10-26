package cadastro.bean;

import java.util.Date;

public class AtualizaBean {

	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String medico;
	@SuppressWarnings("deprecation")
	private Date atendimento = new Date(new Date().getYear(), 0, 1);
	
	private String consultarPorCPF;
	
	public AtualizaBean() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public Date getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Date atendimento) {
		this.atendimento = atendimento;
	}
	
	public String getConsultarPorCPF() {
		return consultarPorCPF;
	}
	
	public void setConsultarPorCPF(String consultarPorCPF) {
		this.consultarPorCPF = consultarPorCPF;
	}

}
