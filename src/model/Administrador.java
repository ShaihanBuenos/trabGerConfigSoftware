package model;
import java.util.ArrayList;
import java.util.List;

public class Administrador{
	private String id;
	private String nome;
    private String sobrenome;
	
	//Caso queiram implementar desta maneira
	List<Medico> medicos = new ArrayList<Medico>();
	List<Paciente> pacientes = new ArrayList<Paciente>();

	public Administrador() {
	}

	public Administrador(String id, String nome, String sobrenome, List<Medico> medicos, List<Paciente> pacientes) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.medicos = medicos;
		this.pacientes = pacientes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}	
	

    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("Id: " + id + "\n");
        msg.append("Nome: " + nome + "\n");
        msg.append("Sobrenome: " + sobrenome + "\n");
        return msg.toString();
    }
}
