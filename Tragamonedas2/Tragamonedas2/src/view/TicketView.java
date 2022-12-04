package view;

public class TicketView {

    private float credito;
    private int numeroId;

    public TicketView(float credito, int numeroId) {
        this.credito = credito;
        this.numeroId = numeroId;
    }

    public TicketView() {
    }

    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
    }

    public int getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }
}
