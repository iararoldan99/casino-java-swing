package view;

public class ComprobanteView {

    private int numeroComprobante;
    private float creditoDisponible;
    private String idMaquina;

    public String getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(String idMaquina) {
        this.idMaquina = idMaquina;
    }

    public ComprobanteView() {
    }

    public ComprobanteView(int numeroComprobante, float creditoDisponible, String idMaquina) {
        this.numeroComprobante = numeroComprobante;
        this.creditoDisponible = creditoDisponible;
        this.idMaquina = idMaquina;
    }

    public int getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(int numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public float getCreditoDisponible() {
        return creditoDisponible;
    }

    public void setCreditoDisponible(float creditoDisponible) {
        this.creditoDisponible = creditoDisponible;
    }
}
