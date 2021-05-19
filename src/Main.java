import model.Medico;
import model.Autorizacoes;
import model.Exames;
;

public class Main {

    public static void main(String[]args){

        //adiciona os exames disponíveis na clínica
        
        //PARA EXEMPLO
        //Medico medico = new Medico("123","Luis", "Pereira", "123456");

    }

    public void examesDisponiveis(){
        for (Exames exame : Exames.values()) {
            System.out.println(exame);
          }
    } 

}