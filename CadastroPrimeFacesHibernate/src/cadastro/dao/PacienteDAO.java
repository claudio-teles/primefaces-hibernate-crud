package cadastro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import cadastro.model.Paciente;

public class PacienteDAO {
	
	private Paciente paciente = new Paciente();

	public PacienteDAO() {}
	
	public static SessionFactory obterSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Paciente.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		return factory;
	}
	
	public Paciente create(Paciente paciente) {
		Session session = PacienteDAO.obterSessionFactory().openSession();
		session.beginTransaction();
		session.save(paciente);
		session.getTransaction().commit();
		return paciente;
	}
	
	public Paciente readById(Long id) {
		Session session = PacienteDAO.obterSessionFactory().openSession();
		session.beginTransaction();
		Paciente p = session.find(Paciente.class, id);
		session.getTransaction().commit();
		return p;
	}
	
	public Paciente readByCPF(String cpf) {
		Session session = PacienteDAO.obterSessionFactory().openSession();
		session.beginTransaction();
		paciente = (Paciente) session.createQuery("SELECT p FROM Paciente p WHERE p.cpf = '"+cpf+"'").getSingleResult();
		System.out.println("CPF de: "+paciente.getNome()+"= "+paciente.getCpf()+".");
		session.getTransaction().commit();
		return paciente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> readAll() {
		Session session = PacienteDAO.obterSessionFactory().openSession();
		session.beginTransaction();
		List<Paciente> listaPacientes = session.createQuery("SELECT p FROM Paciente p ORDER BY p.id ASC").getResultList();
		session.getTransaction().commit();
		return listaPacientes;
	}
	
	public Paciente updateById(Long id, Paciente pac) {
		
		Session session = PacienteDAO.obterSessionFactory().openSession();
		session.beginTransaction();
		this.paciente = session.find(Paciente.class, id);
		this.paciente.setCpf(pac.getCpf());
		this.paciente.setDataDeAtendimento(pac.getDataDeAtendimento());
		this.paciente.setEmail(pac.getEmail());
		this.paciente.setMedico(pac.getMedico());
		this.paciente.setNome(pac.getNome());
		session.merge(this.paciente);
		session.getTransaction().commit();
		return this.paciente;
	}
	
	public Paciente removeById(Long id) {
		Session session = PacienteDAO.obterSessionFactory().openSession();
		session.beginTransaction();
		this.paciente = session.find(Paciente.class, id);
		session.delete(this.paciente);
		session.getTransaction().commit();
		return this.paciente;
	}

}
