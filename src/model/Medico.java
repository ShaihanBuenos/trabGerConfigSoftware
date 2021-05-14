package model;

public class Medico {

    private String nome;
    private String sobrenome;
    private String crm;
    private boolean autorizacaoExame;
    private List listaDeExames;

    public Medico(String nome, String sobrenome, String crm, boolean autorizacaoExame){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.crm = crm;
        this.autorizacaoExame = autorizacaoExame;
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
        msg.append("Nome: " + nome + "\n");
        msg.append("Sobrenome: " + sobrenome + "\n");
        msg.append("CRM: " + crm + "\n");
        return msg.toString();
    }

}