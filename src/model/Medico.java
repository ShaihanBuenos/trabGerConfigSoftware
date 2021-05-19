package model;

public class Medico {
	
	private String id;
    private String nome;
    private String sobrenome;
    private String crm;
    private boolean autorizacaoExame;
    //private List<Exame> listaDeExames = new ArrayList<Exame>();

    public Medico(String id,String nome, String sobrenome, String crm){
    	this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.crm = crm;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public boolean getAutorizacaoExame(){
        return autorizacaoExame;
    }

    public void setAutorizacaoExame(boolean autorizacaoExame){
        this.autorizacaoExame = autorizacaoExame;
    }


    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("Id: " + id + "\n");
        msg.append("Nome: " + nome + "\n");
        msg.append("Sobrenome: " + sobrenome + "\n");
        msg.append("CRM: " + crm + "\n");
        return msg.toString();
    }

}