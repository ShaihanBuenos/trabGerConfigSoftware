package model;

import jdk.jfr.Percentage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exame {
    private static int idCounter = 0;
    private int id;
    private Exames exame;
    private boolean foiRealizado = false;
    private Date dataRealizado;

    SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

    public Exame(Exames exame) {
        idCounter++;
        this.id = idCounter;
        this.exame = exame;
    }

    public Exame(Exames exame, boolean foiRealizado, Date dataRealizado) {
        idCounter++;
        this.id = idCounter;
        this.exame = exame;
        this.foiRealizado = foiRealizado;
        this.dataRealizado = dataRealizado;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public Exames getTipoDeExame() {
        return exame;
    }

    public void setTipoDeExame(Exames exame) {
        this.exame = exame;
    }

    public boolean isFoiRealizado() {
        return foiRealizado;
    }

    public void setFoiRealizado(boolean foiRealizado) {
        this.foiRealizado = foiRealizado;
    }

    public Date getDataRealizado() {
        return dataRealizado;
    }

    public void setDataRealizado(Date dataRealizado) {
        this.dataRealizado = dataRealizado;
    }

    public static double getTotalExamesRealizados(){
        int contador=0;
        for (Autorizacoes autorizacao : Autorizacoes.getListaAutorizacoes()) {
            if (autorizacao.getExame().foiRealizado){
                contador++;
            }
        }
        return (double) ((double)contador/(Autorizacoes.getListaAutorizacoes().size())*100);
    }

    @Override
    public String toString() {
        if (foiRealizado) {
            return  "\n- Tipo de exame: " + exame +
                    "\n- Foi realizado: Sim" +

                    "\n- Data de realizacao: " + sfd.format(dataRealizado);
                    

        } else {
            return "\n- Tipo de exame: " + exame +
                    "\n- Foi realizado: Nao";
        }
    }
}
