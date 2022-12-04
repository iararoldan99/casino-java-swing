package gui;

import controlador.Casino;
import model.Ticket;
import view.TicketView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargarTicket extends JFrame {

    private JLabel lblMonto;
    private JTextField txtMonto;
    private JButton btnCargar;
    public CargarTicket(){
        configurar();
        this.setSize(500, 300);
//        Casino.getInstancia().asignarTamaño(300, 500);
        this.setVisible(true);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void configurar(){
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(4,2));
        lblMonto = new JLabel("Ingrese el monto que desea ingresar: ");
        txtMonto = new JTextField();
        btnCargar = new JButton("Cargar");

        ManejoBotonesInterna botones = new ManejoBotonesInterna(null);
        btnCargar.addActionListener(botones);

        c.add(new JLabel());
        c.add(new JLabel());
        c.add(lblMonto);
        c.add(txtMonto);
        c.add(new JLabel());
        c.add(btnCargar);
        c.add(new JLabel());
        c.add(new JLabel());
    }

    class ManejoBotonesInterna implements ActionListener {

        private JFrame ventana;

        public ManejoBotonesInterna(JFrame ventana) {
            this.ventana = ventana;
        }

        @Override
        public void actionPerformed(ActionEvent boton) {
            // TODO Auto-generated method stub
            TicketView ticket = Casino.getInstancia().ingresarDineroJugador(Float.parseFloat(txtMonto.getText()));
            JOptionPane.showMessageDialog(ventana, "Su numero de ticket es el: " + (int) ticket.getNumeroId() +
                    ". Recuerde que necesitara ingresar el numero de ticket para jugar.");

        }


    }
}
