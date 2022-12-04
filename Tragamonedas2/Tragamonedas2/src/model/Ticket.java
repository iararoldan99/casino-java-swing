package model;

import view.TicketView;

public class Ticket {
    private float credito;
    private int numeroId;

    public Ticket (float credito, int numeroId) {
        this.credito = credito;
        this.numeroId = numeroId;
    }

    public boolean soyEseTicket(int nro) {
        return this.numeroId == nro;
    }

    public void aumentarCredito (float valor) {
        this.credito += valor;
    }

    public void disminuirCredito (float valor) {
        this.credito -= valor;
    }

    public float obtenerCredito(){
        return this.credito;
    }

    public void vaciar(){
        credito = 0;
    }

    public int getNumeroId() { return this.numeroId; }

    public TicketView toView(){
        return new TicketView(credito, numeroId);
    }
}
