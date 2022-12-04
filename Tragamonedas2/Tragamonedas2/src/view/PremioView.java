package view;

import model.Fruta;

public class PremioView {

    private Fruta[] combinacion;
    private float cantidadDinero;

    public PremioView(Fruta[] combinacion, float cantidadDinero) {
        this.combinacion = combinacion;
        this.cantidadDinero = cantidadDinero;
    }

    public Fruta[] getCombinacion() {
        return combinacion;
    }

    public void setCombinacion(Fruta[] combinacion) {
        this.combinacion = combinacion;
    }

    public float getCantidadDinero() {
        return cantidadDinero;
    }
}
