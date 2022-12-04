package model;

import view.PremioView;

import java.util.List;

public class Premio {

    private Fruta[] combinacion;
    private float cantidadDinero;
    private String codigo;

    public Premio (Fruta[] combinacion, float cantidadDinero, String codigo) {
        this.combinacion = combinacion;
        this.cantidadDinero = cantidadDinero;
        this.codigo = codigo;
    }

    public boolean soyEsePremio(String codigo) {
        return codigo == this.codigo;
    }

    public Premio soyEsaCombinacion(String combinacion, List<Premio> premios) {
        for (Premio p: premios){
            if(p.getCombinacion().equals(combinacion)){
                return p;
            }
        }
        return null;
    }

    public Fruta[] getCombinacion() {
        return combinacion;
    }


    public float getCantidadDinero() {
        return cantidadDinero;
    }

    public PremioView toView(){
        return new PremioView(combinacion, cantidadDinero);
    }
}
