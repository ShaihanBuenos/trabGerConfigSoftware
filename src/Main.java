import model.Medico;
import model.Autorizacoes;
import model.Paciente;
import model.Usuario;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Administrador;
import model.Exames;
import model.Users;

public class Main {
    private static Usuario currentUser;
    private Scanner scan;

    public Main(){
        scan = new Scanner(System.in);
    }
    public static void main(String[]args){
        Main main = new Main();
        //adiciona os exames disponíveis na clínica
        
        //PARA EXEMPLO
        //Medico medico = new Medico("123","Luis", "Pereira", "123456");
        Medico        medico1 = new Medico       ("Lucas", "Cardoso", "194528-RS");
        Administrador adm1    = new Administrador("Paulo", "Soarez");
        Paciente      pac1    = new Paciente     ("Joana", "Silva", "JSilva@gmail.com");

        System.out.println(medico1.toString());
        System.out.println(adm1.toString());
        System.out.println(pac1.toString());

        currentUser = medico1;

        main.AddUser();

        currentUser = adm1;

        main.AddUser();
    }

    public void examesDisponiveis(){
        for (Exames exame : Exames.values()) {
            System.out.println(exame);
          }
    } 

    public void AddUser(){
        if (currentUser instanceof Administrador){
            int userValue = -1;
            do {
                System.out.println("Adicionando novo usuário. \nQual é o tipo de usuário? Digite a opção desejada:\n");
                for (Users newUser : Users.values()) {
                    System.out.println(newUser.ordinal()+": "+ newUser);
                }
                
                userValue = numberReader();
            } while ((userValue < 0) || (userValue >= Users.values().length));

            System.out.println("\nQual é o nome do usuário?\n");

            String nome = scan.nextLine();

            System.out.println("\nQual é o sobrenome do usuário?\n");

            String sobrenome = scan.nextLine();

            switch(Users.values()[userValue]){
                case Medic:
                    System.out.println("\nQual é o CRM do médico?\n");
                    String crm = scan.nextLine();
                    Medico newMedico = new Medico(nome, sobrenome, crm);
                    System.out.println("\nNovo médico: \n" + newMedico.toString());
                    break;
                case Admin:
                    Administrador newAdmin = new Administrador(nome, sobrenome);
                    System.out.println("\nNovo administrador: \n" + newAdmin.toString());
                    break;
                case Patient:
                    System.out.println("\nQual é o e-mail do paciente?\n");
                    String email = scan.nextLine();
                    Paciente newPatient = new Paciente(nome, sobrenome, email);
                    System.out.println("\nNovo paciente: \n" + newPatient.toString());
                    break;
            }
        }
        else{
            System.out.println("Erro - Apenas Administradores podem adicionar usuários.");
        }
    }

    public int numberReader(){
        int aux;
        try {
          aux = scan.nextInt();
          scan.nextLine();
          return aux;
        } catch (InputMismatchException e) {
          scan.next();
          System.out.println("\nFavor digitar numero.\n");
          aux = -1;
          return aux;
        }
      }


}