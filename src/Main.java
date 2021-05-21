import model.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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

    public static void main(String[]args) throws ParseException {

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

        //testes issue9 e issue11 20 e 21
        Autorizacoes aut1 = new Autorizacoes(new Date(2021, Calendar.MARCH,10),medico1,pac1,new Exame(Exames.Tomografia,true,new Date(2021, Calendar.MARCH,10)));
        Autorizacoes aut2 = new Autorizacoes(new Date(2021, Calendar.MARCH,9),medico1,pac1,new Exame(Exames.Ecografia,false,new Date()));
        Autorizacoes aut3 = new Autorizacoes(new Date(2021, Calendar.MARCH,11),medico1,pac1,new Exame(Exames.Mamografia,false,new Date(2021, Calendar.MARCH,11)));
        Autorizacoes aut4 = new Autorizacoes(new Date(2021, Calendar.MARCH,12),medico1,pac1,new Exame(Exames.Mamografia,false,new Date(2021, Calendar.MARCH,11)));
        Autorizacoes aut5 = new Autorizacoes(new Date(2021, Calendar.MARCH,8),medico1,pac1,new Exame(Exames.Mamografia,false,new Date(2021, Calendar.MARCH,11)));

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

        System.out.println(adm1.getPercentualDeExamesRealizados());
        System.out.println(adm1.getTotalAutorizacoes());
        System.out.println(adm1.getTotalMedicos());
        System.out.println(adm1.getTotalPacientes());

    }

    public void examesDisponiveis(){
        for (Exames exame : Exames.values()) {
            System.out.println(exame);
        }
    }

    public void VerifyUser() throws ParseException {
        Scanner sc = new Scanner(System.in);
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
                System.out.println("\nDigite seu nome:\n");
                String nome = sc.nextLine();
                System.out.println("\nDigite seu sobrenome:\n");
                String sobrenome = sc.nextLine();
                System.out.println("\nDigite seu CRM:\n");
                String crm = sc.nextLine();
                Medico medico = new Medico(nome, sobrenome, crm);
                System.out.println("\nO que você deseja fazer?\n");
                System.out.println("\n1 - Incluir autorização\n");
                System.out.println("\n2 - Listar autorizaçãos\n");
                int medicValue = scan.nextInt();
                if(medicValue == 1){
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    System.out.println("\nDigite o dia do cadastro:\n");
                    String dia = sc.nextLine();
                    System.out.println("\nDigite o mês do cadastro sendo 1 para janeiro,2 para fevereiro...\n");
                    String mes = sc.nextLine();
                    System.out.println("\nDigite o ano do cadastro:\n");
                    String ano = sc.nextLine();
                    Date dataCadastro = sdf.parse(dia +"/"+ mes +"/"+ ano);
                    System.out.println("\nDigite o nome do paciente: \n");
                    String nomePaciente = sc.nextLine();
                    System.out.println("\nDigite o sobrenome do paciente:\n");
                    String sobreNome = sc.nextLine();
                    System.out.println("\nDigite o email do paciente: \n");
                    String email = sc.nextLine();
                    Paciente paciente = new Paciente(nomePaciente, sobreNome, email);
                    System.out.println("\nQue tipo de exame deseja autorizar ? \n");
                    System.out.println("\nDigite 1 para Raio-x \n");
                    System.out.println("\nDigite 2 para Tomografia\n");
                    System.out.println("\nDigite 3 para MRI\n");
                    System.out.println("\nDigite 4 para Radiografia\n");
                    System.out.println("\nDigite 5 para Mamografia\n");
                    System.out.println("\nDigite 6 para Endoscopia\n");
                    System.out.println("\nDigite 7 para Ecografia\n");
                    System.out.println("\nDigite 8 para Sangue\n");
                    System.out.println("\nDigite 9 para Urina\n");
                    System.out.println("\nDigite 10 para Colonoscopia \n");
                    int opcao = scan.nextInt();
                    Exames exame = Exames.RaioX;
                    switch (opcao){
                        case 1:
                            exame = Exames.RaioX;
                            break;
                        case 2:
                            exame = Exames.Tomografia;
                            break;
                        case 3:
                            exame = Exames.Tomografia;
                            break;
                        case 4:
                            exame = Exames.Radiografia;
                            break;
                        case 5:
                            exame = Exames.Mamografia;
                            break;
                        case 6:
                            exame = Exames.Endoscopia;
                            break;
                        case 7:
                            exame = Exames.Ecografia;
                            break;
                        case 8:
                            exame = Exames.Sangue;
                            break;
                        case 9:
                            exame = Exames.Urina;
                            break;
                        case 10:
                            exame = Exames.Colonoscopia;
                            break;
                    }
                    if(medico.autorizaExame(new Autorizacoes(dataCadastro, medico, paciente, exame))){
                        System.out.println("Autorização realizada!");
                    }
                    else{
                        System.out.println("Autorização não realizada.");
                    }
                }
                else if(medicValue == 2){
                    if(medico.mostrarAutorizacoes().isEmpty()){
                        System.out.println("Não há autorizações disponiveis.");
                    }
                    else {
                        for (Autorizacoes at : medico.mostrarAutorizacoes()) {
                            System.out.println(at.toString());
                        }
                    }
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