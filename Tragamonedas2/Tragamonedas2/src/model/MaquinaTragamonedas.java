package model;

import view.MaquinaTragamonedasView;

import java.util.*;

public class MaquinaTragamonedas {
    private String idMaquina;
    private int cantidadCasillas;
    private float recaudacion;
    private float recaudacionInicial;
    private float recaudacionMinima;
    private List<Premio> premios;
    private float costeJugada;
    private String[] frutas;
    private List<Comprobante> comprobantes = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();



    public MaquinaTragamonedas(String idMaquina, int cantidadCasillas, float recaudacionInicial, float recaudacionMinima,
                                float costeJugada, String[] frutas) {
        this.idMaquina = idMaquina;
        this.cantidadCasillas = cantidadCasillas;
        this.recaudacionInicial = recaudacionInicial;
        this.recaudacionMinima = recaudacionMinima;
        this.costeJugada = costeJugada;
        this.frutas = frutas;
        this.premios = new ArrayList<Premio>();
        this.comprobantes = new ArrayList<Comprobante>();
        this.tickets = new ArrayList<Ticket>();
    }

    public Optional<Premio> buscaPremio (String codigo) {
        return premios.stream().filter(p -> p.soyEsePremio(codigo)).findFirst();
    }

    public float incrementarRecaudacion(float incremento) {
        return this.recaudacion + incremento;
    }

    public void disminuirRecaudacion(float decremento) {
        this.recaudacion -= decremento;
    }

    public String mostrarMensaje() {
        return "Se ha alcanzado la recaudación mínima y existe posibilidad de no poder pagar los próximos premios.";
    }

    private List<Fruta[]> obtenerCombinaciones(){

        List<Fruta[]> combinaciones =  new ArrayList<Fruta[]>();
        combinaciones.add(new Fruta[]{Fruta.BANANA, Fruta.BANANA, Fruta.BANANA});
        combinaciones.add(new Fruta[]{Fruta.BANANA, Fruta.PERA, Fruta.PERA});
        combinaciones.add(new Fruta[]{Fruta.BANANA, Fruta.FRUTILLA, Fruta.PERA});
        combinaciones.add(new Fruta[]{Fruta.BANANA, Fruta.FRUTILLA, Fruta.PERA});
        combinaciones.add(new Fruta[]{Fruta.PERA, Fruta.PERA, Fruta.PERA});
        combinaciones.add(new Fruta[]{Fruta.PERA, Fruta.FRUTILLA, Fruta.FRUTILLA});
        combinaciones.add(new Fruta[]{Fruta.PERA, Fruta.FRUTILLA, Fruta.BANANA});
        combinaciones.add(new Fruta[]{Fruta.PERA, Fruta.FRUTILLA, Fruta.PERA});
        combinaciones.add(new Fruta[]{Fruta.FRUTILLA, Fruta.FRUTILLA, Fruta.FRUTILLA});
        combinaciones.add(new Fruta[]{Fruta.FRUTILLA, Fruta.PERA, Fruta.FRUTILLA});
        combinaciones.add(new Fruta[]{Fruta.FRUTILLA, Fruta.BANANA, Fruta.FRUTILLA});
        combinaciones.add(new Fruta[]{Fruta.FRUTILLA, Fruta.PERA, Fruta.BANANA});
        return combinaciones;
    }

    public Fruta[] generarCombinacion(int cantidadCasillas) {
        List<Fruta[]> combinaciones =  obtenerCombinaciones();
        Random random = new Random();
        int x = random.nextInt(combinaciones.size()-1);
        return combinaciones.get(x);
    }

    public Comprobante emitirComprobante (Ticket ticket) {
        Comprobante comprobante = new Comprobante(comprobantes.size() + 1, ticket.obtenerCredito(), idMaquina);
        comprobantes.add(comprobante);

        return comprobante;
    }

    public Premio crearPremio (Fruta[] combinacion, float valor) {
        Premio premio = new Premio(combinacion, valor, String.valueOf(premios.size() + 1));
        premios.add(premio);
        return premio;
    }

    public Ticket tengoTicket(int nroTicket){

        for(Ticket t: tickets){
            if(t.soyEseTicket(nroTicket)){
                return t;
            }
        }
        return null;
    }

    public Premio generoPremio(Fruta[] combinacionJugada){
        for (Premio premio: premios) {
            if(Arrays.equals(premio.getCombinacion(), combinacionJugada)) {
                return premio;
            }
        }
        return null;
    }

    public boolean soyEsaMaquina (String idMaquina) {
        return idMaquina.equals(this.idMaquina);
    }

    public void modificarConfiguracion (float recaudacionMinima, float coste) {
        modificarRecaudacion(recaudacionMinima);
        modificarCosteJugada(coste);
    }

    public Fruta[] jugar () {

        if(verificarRecaudacionMinima()){
            mostrarMensaje();
        };
        return generarCombinacion(cantidadCasillas);

    }
    public Premio hayPremio(Fruta[] combinacionMaquina, Ticket ticket){
        Premio premio = generoPremio(combinacionMaquina);

        if(premio != null) {
            disminuirRecaudacion(premio.getCantidadDinero());
            ticket.aumentarCredito(premio.getCantidadDinero());
            return premio;
        } else {
            incrementarRecaudacion(this.costeJugada);
            ticket.disminuirCredito(this.costeJugada);
            return null;
        }
    }

    private void modificarRecaudacion (float valor) {
        this.recaudacionMinima = valor;
    }

    public void modificarCosteJugada (float valor) {
        this.costeJugada = valor;
    }

    public boolean verificarRecaudacionMinima () {
        return this.recaudacion < this.recaudacionMinima;
    }

    public float getRecaudacion() {
        return recaudacion;
    }

    public float getRecaudacionInicial() {
        return recaudacionInicial;
    }

    public List<Premio> getPremios() {
        return premios;
    }

    public float getCosteJugada() {
        return costeJugada;
    }

    public Comprobante buscarComprobante(int nroComprobante){
        for(Comprobante c: comprobantes){
            if(c.getNumeroComprobante() == nroComprobante){
                return c;
            }
        }
        return null;
    }

    public MaquinaTragamonedasView toView(){
        return new MaquinaTragamonedasView(frutas, idMaquina, recaudacionInicial, recaudacion, costeJugada);
    }

}
