package controlador;

import model.*;
import view.ComprobanteView;
import view.MaquinaTragamonedasView;
import view.PremioView;
import view.TicketView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Casino {
    private static Casino instancia;
    private Caja caja;
//    private Ticket ticket;
    private List<MaquinaTragamonedas> maquinas = new ArrayList<>();

    private Casino () {

    }

    public static Casino getInstancia(){
        if(instancia == null)
            instancia = new Casino();
        return instancia;
    }

    public void altaPremios(String idMaquina, Fruta[] combinacion, float valor) {
        MaquinaTragamonedas maquina = buscarMaquina(idMaquina);
        if(maquina != null){
            maquina.crearPremio(combinacion, valor);
        }
    }

    public void bajaPremios(String idMaquina, String codigoPremio) {
        MaquinaTragamonedas maquina = buscarMaquina(idMaquina);
        Optional.ofNullable(maquina).map(m -> m.getPremios().stream().filter(p -> p.soyEsePremio(codigoPremio)).map(p -> maquina.getPremios().remove(p)));
    }

    public void configurar(String idMaquina, float recaudacionMinima, float coste) {
        MaquinaTragamonedas maquina = buscarMaquina(idMaquina);
        if(maquina != null){
            maquina.modificarConfiguracion(recaudacionMinima, coste);
        }
    }
    public MaquinaTragamonedasView crearMaquina(int cantidadCasillas, float recaudacionInicial, float recaudacionMinima, float coste, String[] frutas) {
        MaquinaTragamonedas maquina = new MaquinaTragamonedas(String.valueOf(maquinas.size() + 1), cantidadCasillas,
                recaudacionInicial, recaudacionMinima, coste, frutas);
        maquinas.add(maquina);
        return maquina.toView();
    }

    private MaquinaTragamonedas buscarMaquina(String idMaquina) {
        for (MaquinaTragamonedas m: maquinas){
            if(m.soyEsaMaquina(idMaquina)){
                return m;
            }
        }
        return null;
    }

    public MaquinaTragamonedasView buscarMaquinaView(String idMaquina){
        for (MaquinaTragamonedas m: maquinas){
            if(m.soyEsaMaquina(idMaquina)){
                return m.toView();
            }
        }
        return null;
    }

    public TicketView ingresarDineroJugador (float valor) {
        System.out.println("ingresa dinero el jugador");
        Ticket ticket = caja.emitirTicket(valor);
        return ticket.toView();
    }

    public void cobrarJugador(ComprobanteView comprobanteView) {
//        ComprobanteView comprobante = buscarComprobante(numeroComprobante);
        MaquinaTragamonedas maquina = buscarMaquina(comprobanteView.getIdMaquina());
        if (maquina != null){
            Comprobante comprobante = maquina.buscarComprobante(comprobanteView.getNumeroComprobante());
            if (comprobante != null){
                caja.hacerLiquidacion(comprobante);
            }
        }

    }
    public ComprobanteView buscarComprobante(int numeroComprobante) {
        Comprobante comprobante = caja.tengoComprobante(numeroComprobante);
        if (comprobante != null){
            return comprobante.toView();
        }
        return null;

    }

    public TicketView buscarTicket(int nroTicket){
        Ticket ticket = caja.tengoTicket(nroTicket);
        if(ticket != null)
            return ticket.toView();
        else
            return null;
    }

    public Fruta[] jugar(TicketView ticket,MaquinaTragamonedasView maquinaView) {
        MaquinaTragamonedas maquina = buscarMaquina(maquinaView.getIdMaquina());
        if(ticket.getCredito() >= maquina.getCosteJugada() && ticket != null) {
            Fruta[] combinacion = maquina.jugar();
            return combinacion;
        }
        return null;
    }

    public Optional<PremioView> gano(Fruta[] combinacion, TicketView ticket, MaquinaTragamonedasView maquinaView){
        MaquinaTragamonedas maquina = buscarMaquina(maquinaView.getIdMaquina());
        Ticket t = caja.tengoTicket(ticket.getNumeroId());
        Premio premio = maquina.hayPremio(combinacion, t);
        if(premio != null){
            return Optional.ofNullable(premio.toView());
        }
        return Optional.empty();

    }

    public Optional<ComprobanteView> solicitarComprobante(int nroTicket, MaquinaTragamonedasView maquinaView) {
        MaquinaTragamonedas maquina = buscarMaquina(maquinaView.getIdMaquina());
        Ticket ticket = caja.tengoTicket(nroTicket);
        if(ticket != null){
            Comprobante comprobante = maquina.emitirComprobante(ticket);
            ticket.vaciar();
            caja.agregarComprobante(comprobante);
            return Optional.of(comprobante.toView());
        }
        return Optional.empty();
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }


}
