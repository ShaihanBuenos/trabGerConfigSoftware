
package model;

public class Administrador extends Usuario{


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
        return msg.toString();
    }
}