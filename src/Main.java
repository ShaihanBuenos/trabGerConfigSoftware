import model.Medico;
import model.Autorizacoes;
import model.Paciente;
import model.Administrador;
import model.Exames;

public class Main {

    public static void main(String[]args){

        //adiciona os exames disponíveis na clínica
        
        //PARA EXEMPLO
        //Medico medico = new Medico("123","Luis", "Pereira", "123456");
        Medico        medico1 = new Medico       ("Lucas", "Cardoso", "194528-RS");
        Administrador adm1    = new Administrador("Paulo", "Soarez");
        Paciente      pac1    = new Paciente     ("Joana", "Silva", "JSilva@gmail.com");

        System.out.println(medico1.toString());
        System.out.println(adm1.toString());
        System.out.println(pac1.toString());
    }

    public void examesDisponiveis(){
        for (Exames exame : Exames.values()) {
            System.out.println(exame);
          }
    } 

}