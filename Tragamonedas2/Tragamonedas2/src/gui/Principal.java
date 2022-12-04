package gui;

import controlador.Casino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {

    private static final long serialVersionUID = 4582533290157346374L;
    private JButton btnJugar, btnCargarCredito, btnCobrar;

    public Principal() {
        configurar();
        this.setSize(500, 300);
//        Casino.getInstancia().asignarTamaño(300, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void configurar(){
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(3,3, 20, 25));
        c.setBackground(Color.WHITE);

        btnJugar = new JButton("Jugar");
        btnCargarCredito = new JButton("Cargar credito");
        btnCobrar = new JButton("Cobrar");

        ManejoBotonesInterna botones = new ManejoBotonesInterna(null);
        btnJugar.addActionListener(botones);
        btnCargarCredito.addActionListener(botones);
        btnCobrar.addActionListener(botones);

        c.add(new JLabel());
        c.add(new JLabel());
        c.add(new JLabel());

        c.add(btnCargarCredito);
        c.add(btnJugar);
        c.add(btnCobrar);
        c.add(new JLabel());
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
            if (boton.getActionCommand() == "Jugar") {
                //TODO: QUE SE ABRA UNA VENTANA CON EL JUEGO
                new Jugar();
            } else {
                if(boton.getActionCommand() == "Cobrar"){
                    new Cobrar();
                } else {
                    new CargarTicket();
                }
            }
        }


    }
}
