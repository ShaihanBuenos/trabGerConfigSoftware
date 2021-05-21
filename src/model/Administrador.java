package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Administrador extends Usuario{
	private List<String> listaExames = new ArrayList<>();
	private List<Medico> medicos = new ArrayList<>();
	private List<Paciente> pacientes = new ArrayList<>();

	public Administrador(String nome, String sobrenome) {
		super(nome, sobrenome);
		setId("A"+getIDCounter());
	}
	
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("Id: " + id + "\n");
        msg.append("Nome: " + nome + "\n");

		msg.append("Sobrenome: " + sobrenome + "\n");
		msg.append("Iniciais: " + iniciais + "\n");
		    msg.append("Sobrenome: " + sobrenome + "\n");
		    msg.append("Iniciais: " + iniciais + "\n");

        return msg.toString();
    }

}