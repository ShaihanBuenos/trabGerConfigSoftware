package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Medico extends Usuario{
    private String crm;
    private boolean autorizacaoExame;
    private  List<Autorizacoes> listaAutorizacoes = new ArrayList<Autorizacoes>();
    private List<Paciente> pacientes = new ArrayList<>();
    //private List<Exame> listaDeExames = new ArrayList<Exame>();
    public static List<Medico> listaDeMedicos = new ArrayList<>();

    public Medico(String nome, String sobrenome, String crm){
        super(nome, sobrenome);
        setId("M"+getIDCounter());
        this.crm = crm;
        this.autorizacaoExame = true;
        listaDeMedicos.add(this);
    }

    public static List<Medico> getListaDeMedicos() { return listaDeMedicos; }

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

    public boolean autorizaExame(Autorizacoes autorizacao){
        return  listaAutorizacoes.add(autorizacao);
    }

    public List<Autorizacoes> mostrarAutorizacoes(){
        return listaAutorizacoes;
      
    public String getAutorizacoesPorData(){
        StringBuilder string_return = new StringBuilder();
        ArrayList<Autorizacoes> autorizacoesReturn = new ArrayList<>();
        int add_index = 0;
        for (Autorizacoes autorizacao : Autorizacoes.getListaAutorizacoes()) { //passa por cada autorizacao ja criada pra montar o novo array de retorno
            if (autorizacao.getMedico().getId().equals(this.id)) { // valida se é do paciente que está solicitando
                if (autorizacoesReturn.isEmpty()) { // se for o primeiro caso, ja adiciona direto pro return
                    autorizacoesReturn.add(autorizacao);
                } else {
                    for (Autorizacoes aut_return : autorizacoesReturn) { // depois de adicionar, ordena
                        if (autorizacao.getDataCadastro().before(aut_return.getDataCadastro())) { // se a proxima autorizacao for antes, adiciona no lugar da posicao do return
                            autorizacoesReturn.add(autorizacoesReturn.indexOf(aut_return), autorizacao);
                            break;
                        }
                        if (autorizacoesReturn.indexOf(aut_return) + 1 == autorizacoesReturn.size()) { // checka se existe um proximo loop nesse for each
                            add_index = autorizacoesReturn.indexOf(aut_return); // caso nao haja, ele adiciona no final do array de return
                            autorizacoesReturn.add(autorizacao);
                            break;
                        }
                    }
                }
            }
        }
        string_return.append("Autorizacoes do Paciente: ").append(this.nome).append("\n");
        for (Autorizacoes aut_return : autorizacoesReturn) {
            string_return.append(aut_return.toString());
        }
        return string_return.toString();
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