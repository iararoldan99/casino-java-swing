package gui;

import controlador.Casino;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Principal extends JFrame {

    private static final long serialVersionUID = 4582533290157346374L;
    private JButton btnJugar, btnCargarCredito, btnCobrar, btnElegirMaquina;

    public Principal() throws IOException {
        configurar();
        this.setSize(1200, 800);
        this.setBounds(300, 100, 1200, 800);
//        Casino.getInstancia().asignarTamaño(300, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void configurar() {

        JLabel background;
        ImageIcon img = new ImageIcon("Tragamonedas2/src/assets/casino.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(200,0,1200,800);
        add(background);

        JPanel header = new JPanel();
        header.setBackground(new Color(0,0,0,80));
        header.setBounds(0,0,1200,90);
        JLabel bienvenida = new JLabel("Bienvenido al Casino!");
        Font fuente = new Font("Serif", Font.BOLD, 55);
        bienvenida.setBounds(200,55,100,300);
        bienvenida.setFont(fuente);
        bienvenida.setForeground(Color.WHITE);
        header.add(bienvenida);

        JPanel subHeader = new JPanel();
        subHeader.setBackground(new Color(0,0,0,80));
        subHeader.setBounds(0,90,1200,50);
        JLabel texto = new JLabel("Para jugar, por favor cargue crédito en la caja y luego elija una máquina.");
        Font f = new Font("Serif", Font.BOLD, 20);
        texto.setBounds(100,225,100,300);
        texto.setFont(f);
        texto.setForeground(Color.WHITE);
        subHeader.add(texto);

        JPanel footer = new JPanel();
        footer.setBackground(new Color(0,0,0,80));
        footer.setBounds(0,620,1200,100);
        JLabel lbl = new JLabel("Para cobrar el dinero ganado, ingrese su número de comprobante:");
        Font font = new Font("Serif", Font.BOLD, 20);
        lbl.setBounds(100,225,100,300);
        lbl.setFont(font);
        lbl.setForeground(Color.WHITE);
        footer.add(lbl);

        // MAQUINAS

        JLabel m1;
        ImageIcon maquina = new ImageIcon("Tragamonedas2/src/assets/m1.png");
        m1 = new JLabel("", maquina, JLabel.LEFT);
        m1.setBounds(200,250,200,300);

        JLabel m2;
        ImageIcon maquina2 = new ImageIcon("Tragamonedas2/src/assets/m1.png");
        m2 = new JLabel("", maquina2, JLabel.CENTER);
        m2.setBounds(500,250,200,300);

        JLabel m3;
        ImageIcon maquina3 = new ImageIcon("Tragamonedas2/src/assets/m1.png");
        m3 = new JLabel("", maquina3, JLabel.RIGHT);
        m3.setBounds(800,250,200,300);

        // Contenedor de botones

        JPanel cargaCredito = new JPanel();
        cargaCredito.setSize(1200,60);
        cargaCredito.setBounds(450,160, 300, 60);
        cargaCredito.setBackground(new Color(0,0,0,0));

        JPanel jugar1 = new JPanel();
        jugar1.setSize(1200,80);
        jugar1.setBounds(-300,550, 1200, 60);
        jugar1.setBackground(new Color(0,0,0, 0));

        JPanel jugar2 = new JPanel();
        jugar2.setSize(1200,80);
        jugar2.setBounds(0,550, 1200, 60);
        jugar2.setBackground(new Color(0,0,0, 0));

        JPanel jugar3 = new JPanel();
        jugar3.setSize(1200,80);
        jugar3.setBounds(290,550, 1200, 60);
        jugar3.setBackground(new Color(0,0,0, 0));

        JPanel cobro = new JPanel();
        cobro.setSize(1200,80);
        cobro.setBounds(0,660, 1200, 60);
        cobro.setBackground(new Color(0,0,0, 0));

        // BOTONES

        ManejoBotonesInterna botones = new ManejoBotonesInterna(null);

        btnCargarCredito = new JButton("Cargar crédito");
        btnCargarCredito.setBounds(0, 210, 200, 80);
        btnCargarCredito.addActionListener(botones);
        btnCargarCredito.setBackground(new Color(59,182,45));
        cargaCredito.add(btnCargarCredito);

        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(100, 550, 100, 80);
        btnJugar.addActionListener(botones);
        btnJugar.setBackground(new Color(247, 255, 0));
        jugar1.add(btnJugar);

        JButton btn2 = new JButton("Jugar");
        btn2.setBounds(90, 550, 100, 80);
        btn2.addActionListener(botones);
        btn2.setBackground(new Color(247, 255, 0));
        jugar2.add(btn2);

        JButton btn3 = new JButton("Jugar");
        btn3.setBounds(600, 550, 100, 80);
        btn3.addActionListener(botones);
        btn3.setBackground(new Color(247, 255, 0));
        jugar3.add(btn3);

        btnCobrar = new JButton("Cobrar");
        btnCobrar.addActionListener(botones);
        btnCobrar.setBounds(0, 0, 100, 80);
        btnCobrar.setBackground(new Color(0, 247, 255));
        cobro.add(btnCobrar);

        // Agregando todos al background

        background.add(header);
        background.add(subHeader);
        background.add(footer);
        background.add(m1);
        background.add(m2);
        background.add(m3);
        background.add(jugar1);
        background.add(jugar2);
        background.add(jugar3);
        background.add(cobro);
        background.add(cargaCredito);
    }

    class ManejoBotonesInterna implements ActionListener {

        private JFrame ventana;

        public ManejoBotonesInterna(JFrame ventana) {
            this.ventana = ventana;
        }

        @Override
        public void actionPerformed(ActionEvent boton) {

            if (boton.getActionCommand() == "Jugar") {
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
