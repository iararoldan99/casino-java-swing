package gui;

import controlador.Casino;
import view.ComprobanteView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cobrar extends JFrame {

    private JLabel lblComprobante, lblCredito;
    private JTextField txtComprobante;
    private JButton btnCobrar, btnValidar;
    private float saldo;
    public Cobrar(){
        configurar();
        this.setSize(500, 300);
//        Casino.getInstancia().asignarTamaño(300, 500);
        this.setVisible(true);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void configurar(){
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(6,2));
        lblComprobante = new JLabel("Ingrese el numero de comprobante: ");
        txtComprobante = new JTextField();
        btnCobrar = new JButton("Cobrar");
        btnCobrar.setVisible(false);
        btnValidar = new JButton("Validar");
        lblCredito = new JLabel();
        lblCredito.setVisible(false);

        ManejoBotonesInterna botones = new ManejoBotonesInterna(null);
        btnCobrar.addActionListener(botones);
        btnValidar.addActionListener(botones);

        c.add(new JLabel());
        c.add(new JLabel());
        c.add(lblComprobante);
        c.add(txtComprobante);
        c.add(new JLabel());
        c.add(btnValidar);
        c.add(lblCredito);
        c.add(new JLabel());
        c.add(btnCobrar);
        c.add(new JLabel());
        c.add(new JLabel());
        c.add(new JLabel());
    }

    class ManejoBotonesInterna implements ActionListener {

        private JFrame ventana;

        private Casino casino = Casino.getInstancia();

        private ComprobanteView comprobante = null;

        public ManejoBotonesInterna(JFrame ventana) {
            this.ventana = ventana;
        }

        @Override
        public void actionPerformed(ActionEvent boton) {
            if (boton.getActionCommand() == "Validar"){
                comprobante = casino.buscarComprobante(Integer.parseInt(txtComprobante.getText()));
                if(comprobante != null){
                    saldo = comprobante.getCreditoDisponible();
                    if(saldo > 0){
                        lblCredito.setText("Tiene para cobrar un total de $" + saldo);
                        lblCredito.setVisible(true);
                        btnCobrar.setVisible(true);
                    } else{
                        lblCredito.setText("No tiene saldo disponible");
                        lblCredito.setVisible(true);
                    }

                }else{
                    JOptionPane.showMessageDialog(ventana, "El comprobante ingresado no existe, intente nuevamente");
                }
            }else{
                if(saldo > 0){
                    casino.cobrarJugador(comprobante);
                    JOptionPane.showMessageDialog(ventana, "Ha cobrado su saldo disponible exitosamente. Si quiere volver " +
                            "a jugar, ingrese dinero nuevamente");
                    saldo = 0;
                }else{
                    JOptionPane.showMessageDialog(ventana, "No tiene saldo disponible");
                }

            }
        }
    }

}
