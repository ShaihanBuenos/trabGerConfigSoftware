import model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class Main {
    private static Usuario currentUser;
    private Scanner scan;
    protected int numMedicos;           //Variavel para armazenar o numero de medicos
    protected int numPacientes;         //Variavel para armazenar o numero de pacientes


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

        //testes issue9 e issue11
        Autorizacoes aut1 = new Autorizacoes(new Date(2021, Calendar.MARCH,10),medico1,pac1,Exames.Colonoscopia);
        Autorizacoes aut2 = new Autorizacoes(new Date(2021, Calendar.MARCH,9),medico1,pac1,Exames.Ecografia);
        Autorizacoes aut3 = new Autorizacoes(new Date(2021, Calendar.MARCH,11),medico1,pac1,Exames.Mamografia);
        Autorizacoes aut4 = new Autorizacoes(new Date(2021, Calendar.MARCH,12),medico1,pac1,Exames.MRI);
        Autorizacoes aut5 = new Autorizacoes(new Date(2021, Calendar.MARCH,8),medico1,pac1,Exames.Tomografia);

        System.out.println("Voce deseja buscar um Medico ou um Paciente: ");
        System.out.println(" [ 1 ] - Medico");
        System.out.println(" [ 2 ] - Paciente");
        String opcao_issue11 = main.scan.nextLine();
        if (opcao_issue11.equals("1")) {
            System.out.println(" Digite o nome do medico: ");
        }
        else if (opcao_issue11.equals("2")){
            System.out.println(" Digite o nome do paciente: ");
        }
        else{
            System.out.println("Opcao invalida");
        }
        String nome = main.scan.nextLine();
        if (opcao_issue11.equals("1")) {
            System.out.println(adm1.getAutorizacoesMedicoOuPaciente(nome, Users.Medic));
        }
        else if (opcao_issue11.equals("2")){
            System.out.println(adm1.getAutorizacoesMedicoOuPaciente(nome, Users.Patient));
        }




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
                    numMedicos++;
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
                    numPacientes++;
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

    public int numPacientes(){                //Chamar o metodo quando o menu for criado para retornar o numero de Pacientes
        return numPacientes;                    //Retorna o numero de Pacientes
    }

    public int numMedicos(){                   //Chamar o metodo quando o menu for criado para retornar o numero de Medicos
        return numMedicos;                     //Retorna o numero de Medicos
    }




}