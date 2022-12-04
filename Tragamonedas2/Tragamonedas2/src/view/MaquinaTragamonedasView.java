package view;

public class MaquinaTragamonedasView {

    private String[] frutas;

    private String idMaquina;

    private float recaudacionInicial;

    private float recaudacion;

    private float costeJugada;

    public MaquinaTragamonedasView() {
    }

    public MaquinaTragamonedasView(String[] frutas, String idMaquina, float recaudacionInicial, float recaudacion, float costeJugada) {
        this.frutas = frutas;
        this.idMaquina = idMaquina;
        this.recaudacionInicial = recaudacionInicial;
        this.recaudacion = recaudacion;
        this.costeJugada = costeJugada;
    }

    public String[] getFrutas() {
        return frutas;
    }

    public void setFrutas(String[] frutas) {
        this.frutas = frutas;
    }

    public String getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(String idMaquina) {
        this.idMaquina = idMaquina;
    }

    public float getRecaudacionInicial() {
        return recaudacionInicial;
    }

    public void setRecaudacionInicial(float recaudacionInicial) {
        this.recaudacionInicial = recaudacionInicial;
    }

    public float getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(float recaudacion) {
        this.recaudacion = recaudacion;
    }

    public float getCosteJugada() {
        return costeJugada;
    }

    public void setCosteJugada(float costeJugada) {
        this.costeJugada = costeJugada;
    }
}
