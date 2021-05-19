import model.Medico;
import model.Exames;
;


public class Main {

    public static void main(String[]args){

        Exames exames = new Exames();
        //adiciona os exames disponíveis na clínica
        exames.examesDisponiveis();
        
        //PARA EXEMPLO
        //Medico medico = new Medico("123","Luis", "Pereira", "123456");

    }

}