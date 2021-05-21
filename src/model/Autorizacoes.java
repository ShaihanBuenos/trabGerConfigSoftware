package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Autorizacoes {
    private Medico medico;
    private Paciente paciente;
    private static int idCounter = 0;
    private int id;
    private Date dataCadastro;
    private Exames exame;
    private List<String> listaExames = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Autorizacoes(Date dataCadastro, Medico medico, Paciente paciente, Exames exame){
        idCounter++;
        this.id = idCounter;
        this.dataCadastro = dataCadastro;
        this.medico = medico;
        this.paciente = paciente;
        this.exame = exame;
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

    @Override
    public String toString() {
        return "Autorização: \n" + "Data de Cadastro: " + sdf.format( dataCadastro) + "\n Tipo de exame: " + exame
                + "\nId: " + id + "\nMédico: " + medico.getNome() + "\nPaciente: " + paciente.getNome() ;
    }
    
}

