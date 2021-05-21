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
        Scanner in = new Scanner(System.in);

        //adiciona os exames disponíveis na clínica

        //PARA EXEMPLO
        //Medico medico = new Medico("123","Luis", "Pereira", "123456");
        Medico        medico1 = new Medico       ("Lucas", "Cardoso", "194528-RS");
        Administrador adm1    = new Administrador("Paulo", "Soarez");
        Paciente      pac1    = new Paciente     ("Joana", "Silva", "JSilva@gmail.com");

        System.out.println(medico1.toString());
        System.out.println(adm1.toString());
        System.out.println(pac1.toString());

        //testes issue9 e issue11 20 e 21
        Autorizacoes aut1 = new Autorizacoes(new Date(2021, Calendar.MARCH,10),medico1,pac1,new Exame(Exames.Tomografia,true,new Date(2021, Calendar.MARCH,10)));
        Autorizacoes aut2 = new Autorizacoes(new Date(2021, Calendar.MARCH,9),medico1,pac1,new Exame(Exames.Ecografia,false,new Date()));
        Autorizacoes aut3 = new Autorizacoes(new Date(2021, Calendar.MARCH,11),medico1,pac1,new Exame(Exames.Mamografia,false,new Date(2021, Calendar.MARCH,11)));
        Autorizacoes aut4 = new Autorizacoes(new Date(2021, Calendar.MARCH,12),medico1,pac1,new Exame(Exames.Mamografia,false,new Date(2021, Calendar.MARCH,11)));
        Autorizacoes aut5 = new Autorizacoes(new Date(2021, Calendar.MARCH,8),medico1,pac1,new Exame(Exames.Mamografia,false,new Date(2021, Calendar.MARCH,11)));
        
        int firstMenu;
        int mainMenu;
        do{
        System.out.println("Digite 1 para escolher o usuário. ");
        System.out.println("Digite 2 para o menu de usuário. ");
        firstMenu = in.nextInt();

        switch(firstMenu){
            case 1:

            int codigoDeUsuario;
            System.out.println("Digite 1 para administrador.");
            System.out.println("Digite 2 para médico. ");
            System.out.println("Digite 3 para paciente. ");
            codigoDeUsuario = in.nextInt();
            switch(codigoDeUsuario){
               case 1: currentUser = adm1;
               System.out.println("Administrador logado. "); break;

               case 2: currentUser = medico1;
               System.out.println("Médico logado. "); break;

               case 3: currentUser = pac1;
               System.out.println("Paciente logado."); break;

               default: System.out.println("código inválido. "); break;
            }
            break;

            case 2: 
            do{
                    System.out.println("Digite 1 para pesquisar um médico ou paciente. ");
                    System.out.println("Digite 2 para adicionar um usuário. ");
                    System.out.println("Digite 3 para voltar ao menu inicial. ");
                    mainMenu = in.nextInt();
                    switch(mainMenu){

                    case 1:
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
                    
                    System.out.println(adm1.getPercentualDeExamesRealizados());
                    System.out.println(adm1.getTotalAutorizacoes());
                    System.out.println(adm1.getTotalMedicos());
                    System.out.println(adm1.getTotalPacientes());
                    break;
                    
                    case 2: main.AddUser(); 
                    break;

                    case 3: break;
        
                    default: break;
                }
                
            }while(mainMenu!=3); break;
            
            default: break;
        }
        
        
    }while(firstMenu!=0);
    
    System.out.println("Fim do programa.");
    

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