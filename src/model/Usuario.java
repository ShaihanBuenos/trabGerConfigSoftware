package model;

public abstract class Usuario {
    private static int IDCounter = 0;
    protected String id;
    protected String nome;
    protected String sobrenome;
    protected String iniciais;

    protected Usuario(String nome, String sobrenome){
		this.nome = nome;
        this.sobrenome = sobrenome;
        setInitials();
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
        setInitials();
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        setInitials();
    }
    
    public String getInitials(){
        return iniciais;
    }

    private void setInitials(){
        this.iniciais =  new StringBuilder().append(this.nome.charAt(0)).append(this.sobrenome.charAt(0)).toString();
    }

    protected int getIDCounter(){
        IDCounter++;
        return IDCounter;
    }
	
}
