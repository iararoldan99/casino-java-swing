package model;

import java.util.ArrayList;
import java.util.List;

public class Caja {
    private int credito;
    private List<Ticket> tickets;
    private List<Comprobante> comprobantes;

    public Caja ( int credito) {
        this.credito = credito;
        this.tickets = new ArrayList<>();
        this.comprobantes = new ArrayList<Comprobante>();
    }

    public void hacerLiquidacion(Comprobante comprobante) {
        credito -= comprobante.obtenerCredito();
        comprobante.cobrarComprobante();
    }

    public Ticket emitirTicket (float valor) {
        Ticket ticket = new Ticket(valor, tickets.size() + 1);
        this.tickets.add(ticket);
        return ticket;
    }

    public Comprobante tengoComprobante(int nroComprobante){
        for (Comprobante c: comprobantes){
            if(c.soyElComprobante(nroComprobante)){
                return c;
            }
        }
        return null;
    }

    public Ticket tengoTicket(int nroTicket){
        for(Ticket t: tickets){
            if(t.soyEseTicket(nroTicket)){
                return t;
            }
        }
        return null;
    }

    public void agregarComprobante(Comprobante comprobante){
        comprobantes.add(comprobante);
    }

    public int getCredito() {
        return credito;
    }


}
