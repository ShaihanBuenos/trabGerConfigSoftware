package model;

public class Paciente {
	private String id;
	private String nome;
    private String sobrenome;
    private String email;
    
	public Paciente() {
	}

	public Paciente(String id, String nome, String sobrenome, String email) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
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
	        return msg.toString();
	    }

}
