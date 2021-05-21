package model;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario{

	public static List<Administrador> listaDeAdministradores = new ArrayList<>();

	public Administrador(String nome, String sobrenome) {
		super(nome, sobrenome);
		setId("A"+getIDCounter());
		listaDeAdministradores.add(this);
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


    public String getAutorizacoesMedicoOuPaciente(String nome, Users user){
		Usuario usuario = null;
		if (user.equals(Users.Medic)){
			for (Medico medico : Medico.listaDeMedicos) {
				if (medico.getNome().equals(nome)){
					usuario = medico;
					break;
				}
			}
		}
		else if(user.equals(Users.Patient)){
			for (Paciente paciente : Paciente.listaDePacientes) {
				if (paciente.getNome().equals(nome)){
					usuario = paciente;
					break;
				}
			}
		}

		if (usuario instanceof Medico) {
			return ((Medico) usuario).getAutorizacoesPorData();
		}
		else if (usuario instanceof Paciente){
			return ((Paciente) usuario).getAutorizacoesPorData();
		}
		else{
			if (user.equals(Users.Medic)){
				return "Medico nao encontrado.";
			}
			else if (user.equals(Users.Patient)){
				return "Paciente nao encontrado.";
			}
		}
		return null;
	}

}