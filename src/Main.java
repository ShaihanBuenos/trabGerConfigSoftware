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
    protected int numMedicos; // Variavel para armazenar o numero de medicos
    protected int numPacientes; // Variavel para armazenar o numero de pacientes

    public Main() {
        scan = new Scanner(System.in);
    }

    public static void main(String[] args) throws ParseException {

        Main main = new Main();
        Scanner in = new Scanner(System.in);

        // adiciona os exames disponíveis na clínica

        // PARA EXEMPLO

        main.VerifyUser();

    }

    public void examesDisponiveis() {
        for (Exames exame : Exames.values()) {
            System.out.println(exame);
        }
    }

    public void VerifyUser() throws ParseException {
        Scanner sc = new Scanner(System.in);
        int userValue;

        do{
            System.out.println("Qual sua classe de usuário ?");
            System.out.println("1 - Admin");
            System.out.println("2 - Médico");
            System.out.println("3 - Paciente");
            System.out.println("4 - Sair");
            userValue = scan.nextInt();
            switch (userValue) {
            case 1:
                Usuario mainAdmin = new Administrador("Daniel", "Callegari");
                currentUser = mainAdmin;
                System.out.println("\nBem vindo Admin!!!\n");
                System.out.println("\n===================\n");
                System.out.println("\nO que você deseja fazer?\n");
                System.out.println("\n1 - Adicionar novo usuário\n");
                System.out.println("\n2 - Ver estatisticas gerais\n");
                System.out.println("\n3 - Buscar as autorizacoes de um medico ou paciente por nome\n");
                System.out.println("\n4 - Voltar\n");
                int adminValue = scan.nextInt();
                switch (adminValue) {

                case 1:
                    AddUser();
                    break;

                case 2:
                    int menu_1_2 = 0;
                    do {
                        System.out.println("[ 1 ] - Numero de médicos");
                        System.out.println("[ 2 ] - Numero de pacientes");
                        System.out.println("[ 3 ] - Numero de autorizacoes emitidas");
                        System.out.println("[ 4 ] - Percentual de autorizacoes com exames ja realizados");
                        System.out.println("[ 0 ] - Voltar");
                        menu_1_2 = sc.nextInt();
                        switch (menu_1_2){
                            case 1:
                                System.out.println(((Administrador)currentUser).getTotalMedicos());
                                break;
                            case 2:
                                System.out.println(((Administrador)currentUser).getTotalPacientes());
                                break;
                            case 3:
                                System.out.println(((Administrador)currentUser).getTotalAutorizacoes());
                                break;
                            case 4:
                                System.out.println(((Administrador)currentUser).getPercentualDeExamesRealizados());
                                break;
                            default:
                                break;
                        }
                    }while (menu_1_2 != 0);

                case 3:
                    int opcao;
                    do {
                        System.out.println("Voce deseja buscar um Medico ou um Paciente: ");
                        System.out.println(" [ 1 ] - Medico");
                        System.out.println(" [ 2 ] - Paciente");
                        System.out.println(" [ 3 ] - Sair do programa");
                        opcao = scan.nextInt();
                        if (opcao == 1) {
                            System.out.println(" Digite o nome do medico: ");
                            String nome = sc.nextLine();
                            System.out.println(((Administrador) mainAdmin).getAutorizacoesMedicoOuPaciente(nome, Users.Medic));
                        } else if (opcao == 2) {
                            System.out.println(" Digite o nome do paciente: ");
                            String nome = sc.nextLine();
                            System.out.println(((Administrador) mainAdmin).getAutorizacoesMedicoOuPaciente(nome, Users.Patient));
                        }
                    }while (opcao != 3);

                default:
                    break;

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
                System.out.println("\n3 - Voltar\n");
                int medicValue = scan.nextInt();
                if (medicValue == 1) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("\nDigite o dia do cadastro:\n");
                    String dia = sc.nextLine();
                    System.out.println("\nDigite o mês do cadastro sendo 1 para janeiro,2 para fevereiro...\n");
                    String mes = sc.nextLine();
                    System.out.println("\nDigite o ano do cadastro:\n");
                    String ano = sc.nextLine();
                    Date dataCadastro = sdf.parse(dia + "/" + mes + "/" + ano);
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
                    switch (opcao) {
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
                    System.out.println("\nDigite o dia do cadastro:\n");
                    String diaExame = sc.nextLine();
                    System.out.println("\nDigite o mês do cadastro sendo 1 para janeiro,2 para fevereiro...\n");
                    String mesExame = sc.nextLine();
                    System.out.println("\nDigite o ano do cadastro:\n");
                    String anoExame = sc.nextLine();
                    Date dataExame = sdf.parse(diaExame + "/" + mesExame + "/" + anoExame);
                    if (medico.autorizaExame(
                            new Autorizacoes(dataCadastro, medico, paciente, new Exame(exame, true, dataExame)))) {
                        System.out.println("Autorização realizada!");
                    } else {
                        System.out.println("Autorização não realizada.");
                    }
                } else if (medicValue == 2) {
                    if (medico.mostrarAutorizacoes().isEmpty()) {
                        System.out.println("Não há autorizações disponiveis.");
                    } else if (medicValue == 3) {
                        break;
                        }
                        else for (Autorizacoes at : medico.mostrarAutorizacoes()) {
                            System.out.println(at.toString());
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
                if (pacienteValue == 1) {
                    System.out.println("\nIMPLEMENTADO POR RAMIRO\n");
                } else if (pacienteValue == 2) {
                    System.out.println("\nIMPLEMENTADO POR LUCAS E FELIPE\n");
                }
                break;
            default:
                System.out.println("\nMuito Obrigado, volte sempre!!!\n");
            }
        }while(userValue!=4);
    }

    public void AddUser() {
        if (currentUser instanceof Administrador) {
            int userValue = -1;
            do {
                System.out.println("Adicionando novo usuário. \nQual é o tipo de usuário? Digite a opção desejada:\n");
                for (Users newUser : Users.values()) {
                    System.out.println(newUser.ordinal() + ": " + newUser);
                }

                userValue = numberReader();
            } while ((userValue < 0) || (userValue >= Users.values().length));

            System.out.println("\nQual é o nome do usuário?\n");

            String nome = scan.nextLine();

            System.out.println("\nQual é o sobrenome do usuário?\n");

            String sobrenome = scan.nextLine();

            switch (Users.values()[userValue]) {
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
        } else {
            System.out.println("Erro - Apenas Administradores podem adicionar usuários.");
        }
    }

    public int numberReader() {
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

    public int numPacientes() { // Chamar o metodo quando o menu for criado para retornar o numero de Pacientes
        return numPacientes; // Retorna o numero de Pacientes
    }

    public int numMedicos() { // Chamar o metodo quando o menu for criado para retornar o numero de Medicos
        return numMedicos; // Retorna o numero de Medicos
    }

}