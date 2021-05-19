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

    List<Exames> exames = new ArrayList<>();

    public Exames(String id, Date dataCadastro, Medico medico, Paciente paciente, String exame, boolean autorizacaoExame){
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.medico = medico;
        this.paciente = paciente;
        this.exame = exame;
        this.autorizacaoExame = autorizacaoExame;
    }

    @Override
    public String toString() {
        return "Exame: \n" + "Data de Cadastro: " + dataCadastro + "\n Tipo de exame: " + exame
                + "\nId: " + id + "\nMédico: " + medico.getNome() + "\nPaciente: " + paciente.getNome() ;
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

    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }

    public void remover(Exames umExame){
        exams.remove(umExame);
    }

    @Override
    public void editar(Exames umExame) {
        if(umExame == null){
            throw new IllegalArgumentException("valores inválidos");
        }
        int index = exames.indexOf(umExame);
        if(index > -1){
            exames.add(index, umExame);
        }
    }

}

