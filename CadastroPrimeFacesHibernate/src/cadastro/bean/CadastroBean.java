package cadastro.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import cadastro.dao.PacienteDAO;
import cadastro.model.Paciente;


public class CadastroBean implements Serializable {
	
	private static final long serialVersionUID = 1840286588260281394L;
	private Paciente paciente;
	private Paciente pacienteConsulta;
	private Paciente pacienteCPF = new Paciente();
	private Paciente pacienteAtualizado;
	private List<Paciente> pacientes;
	private List<Paciente> listaPacAtual;
	private PessoaBean pessoaBean;
	private AtualizaBean atualizaBean;
	private PacienteDAO pacienteDao;
	
	private Long deletePorId;
	
	@PostConstruct
	public void construirObjetos() {
		paciente = new Paciente();
		pacientes = new ArrayList<>();
		listaPacAtual = new ArrayList<>();
		pessoaBean = new PessoaBean();
		atualizaBean = new AtualizaBean();
		pacienteDao = new PacienteDAO();
		pacienteAtualizado= new Paciente();
		pacienteConsulta = new Paciente();
	}


	public CadastroBean() {}
	
	// -------------------------------------------------------------------------- || ---------------------------------------------------------------------------------------
	
	public Paciente salvar() {
		Paciente p = new Paciente(
					pessoaBean.getCpf(), pessoaBean.getAtendimento() , pessoaBean.getEmail(), pessoaBean.getMedico(), pessoaBean.getNome()
				);
		pacientes.add(p);
		pacienteDao.create(p);
		return p;
	}
	
	public Paciente obterPacientePorId(Long id) {
		this.pacienteConsulta = pacienteDao.readById(id);
		return this.pacienteConsulta;
	}
	
	public Paciente obterPacientePorCPF(String cpf) {
		this.pacienteCPF = pacienteDao.readByCPF(cpf);
		this.listaPacAtual.clear();
		this.listaPacAtual.add(this.pacienteCPF);
		return this.pacienteCPF;
	}
	
	public List<Paciente> obterTodosPacientes() {
		pacientes.clear();
		pacientes.addAll(pacienteDao.readAll());
		return pacientes;
	}
	
	public Paciente atualizarPacientePorId(Long id) {
		Paciente p = new Paciente(
				atualizaBean.getCpf(), atualizaBean.getAtendimento() , atualizaBean.getEmail(), atualizaBean.getMedico(), atualizaBean.getNome()
			);
		this.pacienteAtualizado = pacienteDao.updateById(id, p);
		this.obterTodosPacientes();
		return this.pacienteAtualizado;
	}
	
	public Paciente deletarPacientePorId(Long id) {
		this.paciente = pacienteDao.removeById(id);
		this.obterTodosPacientes();
		return this.paciente;
	}
	
	// -------------------------------------------------------------------------- || ---------------------------------------------------------------------------------------

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public cadastro.dao.PacienteDAO getPacienteDao() {
		return pacienteDao;
	}
	
	public void setPacienteDao(cadastro.dao.PacienteDAO pacienteDao) {
		this.pacienteDao = pacienteDao;
	}
	
	public cadastro.bean.PessoaBean getPessoaBean() {
		return pessoaBean;
	}
	
	public void setPessoaBean(cadastro.bean.PessoaBean pessoaBean) {
		this.pessoaBean = pessoaBean;
	}

	public Paciente getPacienteConsulta() {
		return pacienteConsulta;
	}

	public void setPacienteConsulta(Paciente pacienteConsulta) {
		this.pacienteConsulta = pacienteConsulta;
	}

	public Paciente getPacienteAtulaizado() {
		return pacienteAtualizado;
	}

	public void setPacienteAtulaizado(Paciente pacienteAtulaizado) {
		this.pacienteAtualizado = pacienteAtulaizado;
	}

	public Paciente getPacienteCPF() {
		return pacienteCPF;
	}


	public void setPacienteCPF(Paciente pacienteCPF) {
		this.pacienteCPF = pacienteCPF;
	}


	public List<Paciente> getListaPacAtual() {
		return listaPacAtual;
	}

	public void setListaPacAtual(List<Paciente> listaPacAtual) {
		this.listaPacAtual = listaPacAtual;
	}

	public Paciente getPacienteAtualizado() {
		return pacienteAtualizado;
	}

	public void setPacienteAtualizado(Paciente pacienteAtualizado) {
		this.pacienteAtualizado = pacienteAtualizado;
	}

	public Long getDeletePorId() {
		return deletePorId;
	}

	public void setDeletePorId(Long deletePorId) {
		this.deletePorId = deletePorId;
	}

	public AtualizaBean getAtualizaBean() {
		return atualizaBean;
	}

	public void setAtualizaBean(AtualizaBean atualizaBean) {
		this.atualizaBean = atualizaBean;
	}

}
