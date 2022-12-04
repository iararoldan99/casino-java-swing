package gui;

import controlador.Casino;
import model.Comprobante;
import model.Fruta;
import model.MaquinaTragamonedas;
import model.Premio;
import view.ComprobanteView;
import view.MaquinaTragamonedasView;
import view.PremioView;
import view.TicketView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class Jugar extends JFrame {


    private JLabel lblTicket,lblCasilla1, lblCasilla2, lblCasilla3;
    private JButton btnJugar, btnComprobante;
    private JTextField txtTicket;

    public Jugar(){
        configurar();
        this.setSize(800, 800);

//        Casino.getInstancia().asignarTamaño(300, 500);
        this.setVisible(true);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void configurar(){
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(5,3, 20, 25));

        lblTicket = new JLabel("Ingrese el numero de ticket: ");
        txtTicket = new JTextField();
        btnJugar = new JButton("Jugar");
        btnComprobante = new JButton("Pedir comprobante");
        lblCasilla1 = new JLabel(new ImageIcon(getClass().getResource("pera.png"))); //en las comillas va el nombre del archivo de imagen
        lblCasilla2 = new JLabel(new ImageIcon(getClass().getResource("frutilla.png"))); //en las comillas va el nombre del archivo de imagen
        lblCasilla3 = new JLabel(new ImageIcon(getClass().getResource("banana.png"))); //en las comillas va el nombre del archivo de imagen

        lblCasilla1.setBounds(30, 400, 100, 100);
//        lblCasilla1.setPreferredSize(new Dimension(100, 100));
        ManejoBotonesInterna botones = new ManejoBotonesInterna(null);
        btnJugar.addActionListener(botones);
        btnComprobante.addActionListener(botones);

        c.add(new JLabel()); c.add(new JLabel()); c.add(new JLabel());
        c.add(lblTicket); c.add(txtTicket); c.add(btnJugar);

        //c.add(new JLabel()); c.add(new JLabel()); c.add(new JLabel());
        c.add(lblCasilla1); c.add(lblCasilla2); c.add(lblCasilla3);
        c.add(new JLabel()); c.add(btnComprobante); c.add(new JLabel());
        c.add(new JLabel()); c.add(new JLabel()); c.add(new JLabel());

    }

    class ManejoBotonesInterna implements ActionListener {

        private JFrame ventana;
        private Casino casino = Casino.getInstancia();

        public ManejoBotonesInterna(JFrame ventana) {
            this.ventana = ventana;
        }

        @Override
        public void actionPerformed(ActionEvent boton) {
            MaquinaTragamonedasView maquina = casino.buscarMaquinaView("1");
            if (boton.getActionCommand() == "Jugar") {
                if(maquina == null){
                    JOptionPane.showMessageDialog(ventana, "Lo sentimos, no puede jugar en este momento");
                }else{
                    TicketView ticket = casino.buscarTicket(Integer.parseInt(txtTicket.getText()));
                    if (ticket != null){
                        if (ticket.getCredito() < maquina.getCosteJugada()){
                            JOptionPane.showMessageDialog(ventana,"Lo sentimos, no tiene el saldo suficiente para jugar :(");
                        }else{
                            Fruta[] combinacion = casino.jugar(ticket, maquina);
                            lblCasilla1.setIcon(new ImageIcon(getClass().getResource(combinacion[0].getArchivo())));
                            lblCasilla2.setIcon(new ImageIcon(getClass().getResource(combinacion[1].getArchivo())));
                            lblCasilla3.setIcon(new ImageIcon(getClass().getResource(combinacion[2].getArchivo())));
                            Optional<PremioView> premio = casino.gano(combinacion,ticket, maquina);
                            if (premio.isPresent()) {
                                JOptionPane.showMessageDialog(ventana,"Felicitaciones! Ha ganado un premio de $" + premio.get().getCantidadDinero());
                            } else {
                                JOptionPane.showMessageDialog(ventana,"Lo sentimos, no ha ganado ningun premio :(");
                            }
                        }

                    }else{
                        JOptionPane.showMessageDialog(ventana,"Lo sentimos, su ticket es inavlido. Intentelo nuevamente.");
                    }
                }
            }else{
//              pedir comprobante
                if(maquina == null){
                    JOptionPane.showMessageDialog(ventana, "Lo sentimos, ha ocurrido un error, intentelo nuevamente");
                }else{
                    TicketView ticket = casino.buscarTicket(Integer.parseInt(txtTicket.getText()));
                    if (ticket != null){
                        Optional<ComprobanteView> comprobante = casino.solicitarComprobante(ticket.getNumeroId(), maquina);
                        if (comprobante.isPresent()){
                            JOptionPane.showMessageDialog(ventana, "Su saldo a cobrar es " + comprobante.get().getCreditoDisponible()
                            + " pesos y su numero de comprobante es: " + comprobante.get().getNumeroComprobante()+ ". No lo olvide ya que" +
                                    " lo necesitara para cobrar su saldo.");
                        } else{
                            JOptionPane.showMessageDialog(ventana, "Lo sentimos, ha ocurrido un error, intentelo nuevamente");
                        }
                    }else{
                        JOptionPane.showMessageDialog(ventana, "Lo sentimos, ha ocurrido un error, intentelo nuevamente");
                    }
                }
            }
        }
    }


}
