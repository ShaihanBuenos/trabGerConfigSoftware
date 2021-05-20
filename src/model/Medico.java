package model;

public class Medico extends Usuario{
    private String crm;
    private boolean autorizacaoExame;
    //private List<Exame> listaDeExames = new ArrayList<Exame>();

    public Medico(String nome, String sobrenome, String crm){
        super(nome, sobrenome);
        setId("M"+getIDCounter());
        this.crm = crm;
        this.autorizacaoExame = true;
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
        msg.append("Iniciais: " + iniciais + "\n");
        msg.append("CRM: " + crm + "\n");
        msg.append("Autorizado exames: "+ ((autorizacaoExame)?"Sim":"Não") +"\n");
        return msg.toString();
    }

}