package model;

import java.util.Date;

public class Exame {
    private static int idCounter = 0;
    private int id;
    private TipoDeExameEnum tipoDeExame;
    private boolean foiRealizado = false;
    private Date dataRealizado;

    public Exame(TipoDeExameEnum tipoDeExame) {
        idCounter++;
        this.id = idCounter;
        this.tipoDeExame = tipoDeExame;
    }

    public Exame(TipoDeExameEnum tipoDeExame, boolean foiRealizado, Date dataRealizado) {
        idCounter++;
        this.id = idCounter;
        this.tipoDeExame = tipoDeExame;
        this.foiRealizado = foiRealizado;
        this.dataRealizado = dataRealizado;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public TipoDeExameEnum getTipoDeExame() {
        return tipoDeExame;
    }

    public void setTipoDeExame(TipoDeExameEnum tipoDeExame) {
        this.tipoDeExame = tipoDeExame;
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

    @Override
    public String toString() {
        if (foiRealizado) {
            return "\n- Tipo de exame: " + tipoDeExame +
                    "\n- Foi realizado: Sim" +
                    "\n- Data de realizacao: " + dataRealizado;
        } else {
            return "\n- Tipo de exame: " + tipoDeExame +
                    "\n- Foi realizado: Nao";
        }
    }
}
