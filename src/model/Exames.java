package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Exames {
    private Medico medico;
    private Paciente paciente;
    private String id;
    private Date dataCadastro;
    private String exame;
    private boolean autorizacaoExame;
    private List<Exames> exames = new ArrayList<>();
    private ArrayList<String> listaExames = new ArrayList<>(); 

    public Exames(){}

    public Exames(String id, Date dataCadastro, Medico medico, Paciente paciente, String exame, boolean autorizacaoExame){
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.medico = medico;
        this.paciente = paciente;
        this.exame = exame;
        this.autorizacaoExame = autorizacaoExame;
    }



    public boolean isAutorizacaoExame() {
        return autorizacaoExame;
    }

    public void setAutorizacaoExame(boolean autorizacaoExame) {
        this.autorizacaoExame = autorizacaoExame;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getExame(int i) {
        int index = (i -1);
        String exame = listaExames.get(index);
        return exame;
    }

    public void remover(Exames umExame){
        exames.remove(umExame);
    }


    public void editar(Exames umExame) {
        if(umExame == null){
            throw new IllegalArgumentException("valores inválidos");
        }
        int index = exames.indexOf(umExame);
        if(index > -1){
            exames.add(index, umExame);
        }
    }
    public void examesDisponiveis(){
  
        listaExames.add("Raio-x");
        listaExames.add("Tomografia");
        listaExames.add("Ressonância Magnética");
        listaExames.add("Ultrassonografia");
        listaExames.add("Radiografia");
        listaExames.add("Mamografia");
        listaExames.add("Densitometria Óssea");

        
    }

    public String toStringExamesDisponiveis(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < listaExames.size(); i++ ){
            int index = (listaExames.indexOf(listaExames.get(i)) + 1);
            s.append(index +" - " + listaExames.get(i).toString());
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return "Exame: \n" + "Data de Cadastro: " + dataCadastro + "\n Tipo de exame: " + exame
                + "\nId: " + id + "\nMédico: " + medico.getNome() + "\nPaciente: " + paciente.getNome() ;
    }
    
}

