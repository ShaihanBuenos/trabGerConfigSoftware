package model;

public class Paciente extends Usuario{
    private String email;

	public Paciente(String nome, String sobrenome, String email) {
		super(nome, sobrenome);
		setId("P"+getIDCounter());
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	 public String toString() {
	        StringBuilder msg = new StringBuilder();
	        msg.append("Id: " + id + "\n");
	        msg.append("Nome: " + nome + "\n");
	        msg.append("Sobrenome: " + sobrenome + "\n");

			msg.append("Email: " + email + "\n");
			msg.append("Iniciais: " + iniciais + "\n");

			    msg.append("Email: " + email + "\n");
			    msg.append("Iniciais: " + iniciais + "\n");

	        return msg.toString();
	    }

}