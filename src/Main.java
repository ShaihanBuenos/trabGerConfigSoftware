import model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static List<Paciente> listaDePacientes = new ArrayList<>();
    public static List<Medico> listaDeMedicos = new ArrayList<>();
    public static List<Administrador> listaDeAdministradores = new ArrayList<>();

    public static void main(String[] args) {
        popularObjetos();
        Usuario usuarioAtivo = new Administrador("Admin", "Dummy");

        if (usuarioAtivo instanceof Medico) {
            System.out.println("1 Medico");
        }

        if (usuarioAtivo instanceof Administrador) {
            System.out.println("1 Administrador");
        }

        usuarioAtivo = listaDeMedicos.get(0);
        if (usuarioAtivo instanceof Medico) {
            System.out.println("2 Medico");
        }

        if (usuarioAtivo instanceof Paciente) {
            System.out.println("2 Administrador");
        }
    }

    public static void popularObjetos() {

        Usuario paciente1 = new Paciente("Joana", "Silva", "JSilva@gmail.com");
        Usuario paciente2 = new Paciente("Matheus", "Carvalho", "mcar@gmail.com");

        Usuario medico1 = new Medico("Lucas", "Cardoso", "194528-RS");
        Usuario medico2 = new Medico("Rodrigo", "Jardim", "143223-RS");

        Usuario administrador1 = new Administrador("Paulo", "Soarez");
        Usuario administrador2 = new Administrador("Joao", "Luchese");

        listaDePacientes.add((Paciente) paciente1);
        listaDePacientes.add((Paciente) paciente2);
        listaDeMedicos.add((Medico) medico1);
        listaDeMedicos.add((Medico) medico2);
        listaDeAdministradores.add((Administrador) administrador1);
        listaDeAdministradores.add((Administrador) administrador2);

        Autorizacao autorizacao1 = new Autorizacao(new Date(), (Medico) medico1, (Paciente) paciente1,
                new Exame(TipoDeExameEnum.RaioX));
        Autorizacao autorizacao2 = new Autorizacao(new Date(), (Medico) medico2, (Paciente) paciente2,
                new Exame(TipoDeExameEnum.Endoscopia, true, new Date()));
    }

}