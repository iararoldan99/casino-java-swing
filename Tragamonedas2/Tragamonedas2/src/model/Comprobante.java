package model;

import view.ComprobanteView;

public class Comprobante {

    private int numeroComprobante;
    private float creditoDisponible;

    private String idMaquina;

    public Comprobante( int numeroComprobante, float creditoDisponible, String idMaquina) {
        this.numeroComprobante = numeroComprobante;
        this.creditoDisponible = creditoDisponible;
        this.idMaquina = idMaquina;
    }

    public boolean soyElComprobante(int numComprobante) {
        return this.numeroComprobante == numComprobante;
    }

    public float obtenerCredito(){
        return this.creditoDisponible;
    }

    public int getNumeroComprobante() {
        return numeroComprobante;
    }

    public float getCreditoDisponible() {
        return creditoDisponible;
    }

    public void cobrarComprobante(){
        creditoDisponible = 0;
    }

    public ComprobanteView toView(){
        return new ComprobanteView(numeroComprobante, creditoDisponible, idMaquina);
    }
}
