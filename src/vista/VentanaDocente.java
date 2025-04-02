package vista;

import java.awt.Color;
import modelo.Usuario;

/**
 *
 * @author JOAN
 */
public class VentanaDocente extends javax.swing.JFrame {

    Usuario usuario;
    
    public VentanaDocente(Usuario usuario) {
        initComponents();
        setLocationRelativeTo(this);
        this.usuario = usuario;
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
        btnAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        AsignarPorcentaje = new javax.swing.JMenu();
        PonerNota = new javax.swing.JMenu();
        TablaHistorial = new javax.swing.JMenu();
        TablaActual = new javax.swing.JMenu();
        Horario = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BIENVENIDO PROFESOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        btnAtras.setBackground(new java.awt.Color(204, 204, 204));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\JOAN\\OneDrive\\Documentos\\NetBeansProjects\\Gestion_Universitaria\\src\\imagenes\\Bienvenido.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAtras))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));

        AsignarPorcentaje.setText("Asignar Porcentaje");
        AsignarPorcentaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AsignarPorcentajeMouseClicked(evt);
            }
        });
        jMenuBar1.add(AsignarPorcentaje);

        PonerNota.setText("Poner Nota");
        PonerNota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PonerNotaMouseClicked(evt);
            }
        });
        jMenuBar1.add(PonerNota);

        TablaHistorial.setText("Historia de Periodo");
        TablaHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaHistorialMouseClicked(evt);
            }
        });
        jMenuBar1.add(TablaHistorial);

        TablaActual.setText("Periodo Actual");
        TablaActual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaActualMouseClicked(evt);
            }
        });
        jMenuBar1.add(TablaActual);

        Horario.setText("Horario");
        Horario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HorarioMouseClicked(evt);
            }
        });
        jMenuBar1.add(Horario);

        setJMenuBar(jMenuBar1);

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

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        VentanaLogin ventana = new VentanaLogin();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void AsignarPorcentajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AsignarPorcentajeMouseClicked
        VentanaPorcentajeNotasDocente ventana = new VentanaPorcentajeNotasDocente(usuario);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AsignarPorcentajeMouseClicked

    private void TablaHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaHistorialMouseClicked
        VentanaTablaHistorialDocente ventana = new VentanaTablaHistorialDocente(usuario);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_TablaHistorialMouseClicked

    private void PonerNotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PonerNotaMouseClicked
        VentanaAsignarNotasDocente ventana = new VentanaAsignarNotasDocente(usuario);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PonerNotaMouseClicked

    private void TablaActualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaActualMouseClicked
        VentanaTablaActualDocente ventana = new VentanaTablaActualDocente(usuario);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_TablaActualMouseClicked

    private void HorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HorarioMouseClicked
        VentanaTablaHorarioDocente ventana = new VentanaTablaHorarioDocente(usuario);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HorarioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AsignarPorcentaje;
    private javax.swing.JMenu Horario;
    private javax.swing.JMenu PonerNota;
    private javax.swing.JMenu TablaActual;
    private javax.swing.JMenu TablaHistorial;
    private javax.swing.JButton btnAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
