package model;

import java.util.Date;

public class Autorizacao {
    private static int idCounter = 0;
    private int id;
    private Date dataCadastro;
    private Medico medico;
    private Paciente paciente;
    private Exame exame;

    public Autorizacao(Date dataCadastro, Medico medico, Paciente paciente, Exame exame) {
        idCounter++;
        this.id = idCounter;
        this.dataCadastro = dataCadastro;
        this.medico = medico;
        this.paciente = paciente;
        this.exame = exame;
    }

    public static int getIdCounter() {
        return idCounter;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    @Override
    public String toString() {
        return "Autorização: \n" + "Id: " + id + "\nData de Cadastro: " + dataCadastro + "\nExame: " + exame
                + "\nMédico: " + medico.getNome() + " " + medico.getSobrenome() + "\nPaciente: " + paciente.getNome()
                + " " + paciente.getSobrenome();
    }

}

