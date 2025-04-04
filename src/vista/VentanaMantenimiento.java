/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import Exepciones.ExisteUnMantenimiientoEsediaExepcion;
import controladores.ControladorMantenimientoLaboratorio;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Laboratorio;
import modelo.Mantenimiento;
import modelo.Usuario;

/**
 *
 * @author JOAN
 */
public class VentanaMantenimiento extends javax.swing.JFrame {

    Usuario usuario;
    Laboratorio laboratorio;
    ControladorMantenimientoLaboratorio controlador;

    public VentanaMantenimiento(Laboratorio laboratorio, Usuario usuario) {
        initComponents();
        this.laboratorio = laboratorio;
        this.usuario = usuario;
        this.controlador = new ControladorMantenimientoLaboratorio(laboratorio);
        setLocationRelativeTo(this);
        calendario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        jdMantenimiento = new com.toedter.calendar.JDateChooser();
        btnMantenimiento = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MANTENIMIENTO DE LABORATORIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        jScrollPane1.setViewportView(txtMensaje);

        jdMantenimiento.setBackground(new java.awt.Color(204, 204, 204));
        jdMantenimiento.setForeground(new java.awt.Color(0, 0, 0));

        btnMantenimiento.setBackground(new java.awt.Color(204, 204, 255));
        btnMantenimiento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMantenimiento.setForeground(new java.awt.Color(0, 0, 0));
        btnMantenimiento.setText("Solicitar Mantenimiento");
        btnMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenimientoActionPerformed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(204, 204, 204));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(btnMantenimiento)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jdMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAtras))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jdMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenimientoActionPerformed
        try {
            if (CamposVacios()) {
                String mensaje = txtMensaje.getText();
                Instant fechaAux = jdMantenimiento.getDate().toInstant();
                LocalDate fecha = fechaAux.atZone(ZoneId.systemDefault()).toLocalDate();
                Mantenimiento mantenimiento = new Mantenimiento(laboratorio, mensaje, fecha);
                controlador.guardarMantenimiento(mantenimiento);
                JOptionPane.showMessageDialog(null, "Se solicito un mantenimiento con exito");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Favor no dejar Campos VACIOS");
            }
        } catch (ExisteUnMantenimiientoEsediaExepcion exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage());
        }
    }//GEN-LAST:event_btnMantenimientoActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        VentanaLaboratorio ventana = new VentanaLaboratorio(usuario);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void limpiar() {
        txtMensaje.setText("");
        jdMantenimiento.setDate(null);
    }

    public boolean CamposVacios() {
        String fechaMantenimiento = ((JTextField) jdMantenimiento.getDateEditor().getUiComponent()).getText();
        if (txtMensaje.getText().isEmpty() || fechaMantenimiento.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private void calendario() {
        LocalDate fechaActual = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate diaSiguiente = fechaActual.plusDays(1);
        Date date = Date.from(diaSiguiente.atStartOfDay(ZoneId.systemDefault()).toInstant());
        jdMantenimiento.setMinSelectableDate(date);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnMantenimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdMantenimiento;
    private javax.swing.JTextArea txtMensaje;
    // End of variables declaration//GEN-END:variables
}
