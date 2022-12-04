package app;

import gui.Principal;
import model.*;
import controlador.Casino;
import view.ComprobanteView;
import view.MaquinaTragamonedasView;
import view.PremioView;
import view.TicketView;

import java.util.Optional;

public class App {
    public static void main(String[] args) {

        Principal ventanaPrinicpal = new Principal();

        Casino casino = Casino.getInstancia();
        MaquinaTragamonedasView maquina = casino.crearMaquina(3, 1000, 100, 60, new String[]{"Banana", "Uva", "Pera", "Manzana", "Sandia", "Granada", "Naranja", "Guinda"});

        //alta y baja de premios
        casino.altaPremios("1", new Fruta[]{Fruta.BANANA, Fruta.BANANA, Fruta.BANANA}, 300);
        casino.altaPremios("1", new Fruta[]{Fruta.FRUTILLA, Fruta.FRUTILLA, Fruta.FRUTILLA}, 200);
        casino.altaPremios("1", new Fruta[]{Fruta.PERA, Fruta.PERA, Fruta.PERA}, 100);
       // casino.altaPremios("1", new Fruta[]{Fruta.PERA, Fruta.FRUTILLA, Fruta.FRUTILLA}, 200);
        //casino.altaPremios("1", new Fruta[]{Fruta.PERA, Fruta.FRUTILLA, Fruta.BANANA}, 100);
        //casino.bajaPremios("1", "5");

        Caja caja = new Caja(100000);
        casino.setCaja(caja);
        /*
        TicketView ticket = casino.ingresarDineroJugador(1000);
        System.out.println("Numero de ticket: " + ticket.getNumeroId());
        System.out.println("Estado de la caja antes de la jugada: " + caja.getCredito());
        System.out.println("Estado de la Maquina antes de la jugada: " + maquina.getRecaudacionInicial());
        System.out.println("------------------------------------------------------------------------------");

        Fruta[] combinacion = casino.jugar(ticket, maquina);
        System.out.println("Combinacion generada: " + combinacion[0].toString() + " | " + combinacion[1].toString() + " | " + combinacion[2].toString());
        Optional<PremioView> premio = casino.gano(combinacion,ticket, maquina);

        if (premio.isPresent()) {
            System.out.println("Ganaste!");
            Optional<ComprobanteView> comprobante = casino.solicitarComprobante((int) ticket.getNumeroId(), maquina);
            System.out.println("El comprobante es " + comprobante.get().getNumeroComprobante());
            casino.cobrarJugador(comprobante.get());
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Estado de la caja despues de ganar: " + caja.getCredito());
            System.out.println("Estado de la Maquina despues de ganar: " + maquina.getRecaudacion());
        }
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Estado de la caja despues de terminar la jugada: " + caja.getCredito());
        System.out.println("Estado de la Maquina despues de terminar la jugada: " + maquina.getRecaudacion());
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Termino la jugada");
*/

    }

}

