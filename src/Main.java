import model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Usuario currentUser;
    private Scanner scan;
    protected int numMedicos;           //Variavel para armazenar o numero de medicos
    protected int numPacientes;         //Variavel para armazenar o numero de pacientes

    public static List<Paciente> listaDePacientes = new ArrayList<>();
    public static List<Medico> listaDeMedicos = new ArrayList<>();
    public static List<Administrador> listaDeAdministradores = new ArrayList<>();

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

        main.VerifyUser();

        //currentUser = medico1;

        //main.AddUser();

        //currentUser = adm1;

        //main.AddUser();

    }

    public void examesDisponiveis(){
        for (Exames exame : Exames.values()) {
            System.out.println(exame);
        }
    }

    public void VerifyUser(){
        int userValue = -1;
        System.out.println("Qual sua classe de usuário ?");
        System.out.println("1 - Amdin");
        System.out.println("2 - Médico");
        System.out.println("3 - Paciente");
        System.out.println("4 - Sair");
        userValue = scan.nextInt();

        switch(userValue){
            case 1:
                Usuario mainAdmin = new Administrador("Daniel", "Callegari");
                System.out.println("\nBem vindo Admin!!!\n");
                System.out.println("\n===================\n");
                System.out.println("\nO que você deseja fazer?\n");
                System.out.println("\n1 - Adicionar novo usuário\n");
                System.out.println("\n2 - Adicionar novo usuário\n");
                System.out.println("\n3 - Ver estatisticas gerais\n");
                int adminValue = scan.nextInt();
                if(adminValue == 1){
                    currentUser = mainAdmin;
                    AddUser();
                }
                else if(adminValue == 2){
                    System.out.println("\nSENDO IMPLEMENTADO POR RAMIRO\n");
                }
                else if(adminValue == 3){
                    System.out.println("\nSENDO IMPLEMENTADO POR LAURA\n");
                }
                break;
            case 2:
                System.out.println("\nBem vindo Médico!!!\n");
                System.out.println("\n===================\n");
                System.out.println("\nO que você deseja fazer?\n");
                System.out.println("\n1 - Incluir autorização\n");
                System.out.println("\n2 - Listar autorizaçãos\n");
                int medicValue = scan.nextInt();
                if(medicValue == 1){
                    System.out.println("\nSERÁ IMPLEMENTADO POR VINICIO\n");
                }
                else if(medicValue == 2){
                    System.out.println("\nSENDO IMPLEMENTADO sla\n");
                }
                break;
            case 3:
                System.out.println("\nBem vindo Paciente!!!\n");
                System.out.println("\n===================\n");
                System.out.println("\nO que você deseja fazer?\n");
                System.out.println("\n1 - Marcar exame como realizado\n");
                System.out.println("\n2 - Listar autorizaçãos\n");
                int pacienteValue = scan.nextInt();
                if(pacienteValue == 1){
                    System.out.println("\nIMPLEMENTADO POR RAMIRO\n");
                }
                else if(pacienteValue == 2){
                    System.out.println("\nIMPLEMENTADO POR LUCAS E FELIPE\n");
                }
                break;
            default:
                System.out.println("\nMuito Obrigado, volte sempre!!!\n");
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