package vista;

import controladores.ControladorPrestamo;
import controladores.ControladorPuestos;
import controladores.ControladorReserva;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.annotation.processing.Messager;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.AdminLaboratorio;
import modelo.Estado;
import modelo.Estudiante;
import modelo.Laboratorio;
import modelo.NumRol;
import modelo.Puesto;
import modelo.Usuario;

/**
 *
 * @author JOAN
 */
public class VentanaSalon extends javax.swing.JFrame implements ActionListener {

    Laboratorio laboratorio;
    Usuario usuario;
    ControladorPuestos controladorPuestos;
    ControladorReserva controladorReserva;
    ControladorPrestamo controladorPrestamo;
    JButton[][] botones;

    public VentanaSalon(Laboratorio laboratorio, Usuario usuario) {
        initComponents();
        this.laboratorio = laboratorio;
        this.usuario = usuario;
        this.controladorPuestos = new ControladorPuestos(laboratorio);
        this.controladorReserva = new ControladorReserva(usuario);
        this.controladorPrestamo = new ControladorPrestamo(laboratorio);
        setLocationRelativeTo(this);
        if (usuario.getRol().equals(NumRol.ADMINLABORATIRIO)) {
            panelAdmin.setVisible(true);
        } else if (usuario.getRol().equals(NumRol.ESTUDIANTE)) {
            panelAdmin.setVisible(false);
        }
        cargarBotones();
        validarColores();
    }

    public void cargarBotones() {
        int cantidadPuestos = controladorPuestos.getCantidadPuestos();
        int filas = cantidadPuestos / 4;
        JButton[][] matrizPuestos;

        if (cantidadPuestos % 4 != 0) {
            matrizPuestos = new JButton[filas + 1][];

            for (int i = 0; i < filas; i++) {
                matrizPuestos[i] = new JButton[4];
            }
            int puestosFaltantes = cantidadPuestos % 4;
            matrizPuestos[matrizPuestos.length - 1] = new JButton[puestosFaltantes];
        } else {
            matrizPuestos = new JButton[filas][4];
        }
        this.botones = matrizPuestos;
        cargarPuestos();
    }

    public void cargarPuestos() {
        int ancho = 80;
        int alto = 75;
        int separado = 30;
        int contador = 1;
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setBounds(j * ancho + separado, i * alto + separado, ancho, alto);
                botones[i][j].setBackground(Color.WHITE);
                botones[i][j].addActionListener(this);
                botones[i][j].setText(String.valueOf(contador));
                panelSalon.add(botones[i][j]);
                contador += 1;
            }
        }
        int anchoPanel = (botones[0].length) * ancho + separado + 40;
        int altoPanel = (botones.length) * ancho + separado + 40;
        panelSalon.setPreferredSize(new Dimension(anchoPanel, altoPanel));
        controladorReserva.finalizarReservasPasadas();
        controladorPrestamo.finalizarPrestamosPasados();
        validarColores();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                if (ae.getSource().equals(botones[i][j])) {
                    Puesto puesto = controladorPuestos.getPuesto(i, j);
                    controladorPuestos.cambiarEstado(puesto);
                    if (usuario.getRol().equals(NumRol.ESTUDIANTE)) {
                        controladorPuestos.cambiarEstado(puesto);
                        int paso = JOptionPane.showOptionDialog(null, "¿Vas a reservar el puesto?", "Bienvenido",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, new Object[]{"Reserva"}, "Reserva");
                        if (paso == 0) {
                            VentanaReservarPuesto ventana = new VentanaReservarPuesto(laboratorio, usuario, puesto, this);
                            ventana.setVisible(true);
                            this.dispose();
                        }
                    } else if (usuario.getRol().equals(NumRol.ADMINLABORATIRIO)) {
                        controladorPuestos.cambiarEstado(puesto);
                        Object[] options = {"Reserva", "Préstamo"};
                        int paso = JOptionPane.showOptionDialog(null, "¿Qué quieres hacer?", "Bienvenido",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, options, options[0]);
                        if (paso == 0) {
                            VentanaReservarPuesto ventana = new VentanaReservarPuesto(laboratorio, usuario, puesto, this);
                            ventana.setVisible(true);
                            this.dispose();
                        } else if (paso == 1) {
                            VentanaPrestamoPuesto ventana = new VentanaPrestamoPuesto(laboratorio, usuario, puesto);
                            ventana.setVisible(true);
                            this.dispose();
                        }
                    }
                }
            }
        }
    }

    public void validarColores() {
        controladorReserva.finalizarReservasPasadas();
        controladorPrestamo.finalizarPrestamosPasados();
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                Puesto puesto = controladorPuestos.getPuesto(i, j);
                controladorPuestos.cambiarEstado(puesto);
                if (puesto.getEstado().equals(Estado.OCUPADO)) {
                    botones[i][j].setBackground(Color.RED);
                } else {
                    botones[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSalon = new javax.swing.JPanel();
        panelAdmin = new javax.swing.JPanel();
        btnPuesto = new javax.swing.JButton();
        btnPuesto1 = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelSalon.setBackground(new java.awt.Color(204, 204, 204));
        panelSalon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PUESTOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        panelAdmin.setBackground(new java.awt.Color(204, 204, 204));

        btnPuesto.setBackground(new java.awt.Color(204, 204, 204));
        btnPuesto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPuesto.setForeground(new java.awt.Color(0, 0, 0));
        btnPuesto.setText("Editar");
        btnPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuestoActionPerformed(evt);
            }
        });

        btnPuesto1.setBackground(new java.awt.Color(204, 204, 204));
        btnPuesto1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPuesto1.setForeground(new java.awt.Color(0, 0, 0));
        btnPuesto1.setText("Mantenimiento");
        btnPuesto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuesto1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPuesto1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPuesto1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnAtras.setBackground(new java.awt.Color(204, 204, 204));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSalonLayout = new javax.swing.GroupLayout(panelSalon);
        panelSalon.setLayout(panelSalonLayout);
        panelSalonLayout.setHorizontalGroup(
            panelSalonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        panelSalonLayout.setVerticalGroup(
            panelSalonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSalonLayout.createSequentialGroup()
                .addContainerGap(425, Short.MAX_VALUE)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSalonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSalon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSalon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuestoActionPerformed
        VentanaEditarPuestos ventana = new VentanaEditarPuestos(laboratorio, usuario);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPuestoActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        VentanaLaboratorio ventana = new VentanaLaboratorio(usuario);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnPuesto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuesto1ActionPerformed
        VentanaMantenimiento ventana = new VentanaMantenimiento(laboratorio, usuario);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPuesto1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnPuesto;
    private javax.swing.JButton btnPuesto1;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel panelSalon;
    // End of variables declaration//GEN-END:variables

}
