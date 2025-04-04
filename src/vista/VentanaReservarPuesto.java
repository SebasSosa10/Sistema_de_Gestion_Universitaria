package vista;

import Exepciones.EstudianteNoExisteExepcion;
import Exepciones.LaboratoriaYaEstaEnMantenimientoExepcion;
import Exepciones.NoExisteElIdExepcion;
import Exepciones.NoExisteLaReservaExepcion;
import Exepciones.ReservaPuestoExepcion;
import Exepciones.SoloUnaReservaExepcion;
import Util.IList;
import Util.Lista;
import controladores.ControladorReserva;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.AdminLaboratorio;
import modelo.Estudiante;
import modelo.Laboratorio;
import modelo.Puesto;
import modelo.Reserva;
import modelo.Usuario;

/**
 *
 * @author JOAN
 */
public class VentanaReservarPuesto extends javax.swing.JFrame {

    Laboratorio laboratorio;
    Usuario usuario;
    ControladorReserva controlador;
    Puesto puesto;
    VentanaSalon ventana;
    IList<Reserva> listaReserva;

    public VentanaReservarPuesto(Laboratorio laboratorio, Usuario usuario, Puesto puesto, VentanaSalon ventana) {
        initComponents();
        this.laboratorio = laboratorio;
        this.usuario = usuario;
        this.puesto = puesto;
        this.ventana = ventana;
        this.controlador = new ControladorReserva(laboratorio, usuario, puesto);
        setLocationRelativeTo(this);
        calendario();
        llenarcbx();
        llenarTabla();
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
        txtUsuario = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPrograma = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDateReserva = new com.toedter.calendar.JDateChooser();
        cbxPrestamo = new javax.swing.JButton();
        cbxHora = new javax.swing.JComboBox<>();
        cbxPrestamo1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReserva = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RESERVAR PUESTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        btnAtras.setBackground(new java.awt.Color(204, 204, 204));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        txtUsuario.setBackground(new java.awt.Color(204, 204, 204));
        txtUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(204, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(204, 204, 204));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Programa:");

        txtPrograma.setEditable(false);
        txtPrograma.setBackground(new java.awt.Color(204, 204, 204));
        txtPrograma.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPrograma.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Direccion:");

        txtDireccion.setEditable(false);
        txtDireccion.setBackground(new java.awt.Color(204, 204, 204));
        txtDireccion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(0, 0, 0));

        txtTelefono.setEditable(false);
        txtTelefono.setBackground(new java.awt.Color(204, 204, 204));
        txtTelefono.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Telefono:");

        cbxPrestamo.setBackground(new java.awt.Color(204, 255, 204));
        cbxPrestamo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbxPrestamo.setForeground(new java.awt.Color(0, 0, 0));
        cbxPrestamo.setText("Reserva");
        cbxPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPrestamoActionPerformed(evt);
            }
        });

        cbxHora.setBackground(new java.awt.Color(204, 204, 204));
        cbxHora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbxHora.setForeground(new java.awt.Color(0, 0, 0));

        cbxPrestamo1.setBackground(new java.awt.Color(255, 204, 204));
        cbxPrestamo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbxPrestamo1.setForeground(new java.awt.Color(0, 0, 0));
        cbxPrestamo1.setText("Cancelar");
        cbxPrestamo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPrestamo1ActionPerformed(evt);
            }
        });

        tblReserva.setBackground(new java.awt.Color(204, 204, 204));
        tblReserva.setForeground(new java.awt.Color(0, 0, 0));
        tblReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblReserva);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtras)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDateReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbxPrestamo1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator3)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(cbxHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPrestamo1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        VentanaSalon ventana = new VentanaSalon(laboratorio, usuario);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed

    }//GEN-LAST:event_txtUsuarioMousePressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            Estudiante aux = (Estudiante) controlador.buscarEstudiante(txtUsuario.getText());
            txtNombre.setText(aux.getNombre());
            txtPrograma.setText(String.valueOf(aux.getPrograma()));
            txtTelefono.setText(aux.getTelefono());
            txtDireccion.setText(aux.getDireccion());
        } catch (EstudianteNoExisteExepcion | NoExisteElIdExepcion exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void llenarcbx() {
        cbxHora.removeAllItems();
        for (int i = 7; i <= 22; i++) {
            cbxHora.addItem(String.valueOf(i));
        }
    }

    private void cbxPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPrestamoActionPerformed
        try {
            if (CamposVacios()) {
                Estudiante aux = (Estudiante) controlador.buscarEstudiante(txtUsuario.getText());
                String codigo = puesto.codigoReserva();
                Instant fechaAux = jDateReserva.getDate().toInstant();
                LocalDate fecha = fechaAux.atZone(ZoneId.systemDefault()).toLocalDate();
                int horaSeleccionada = Integer.parseInt((String) cbxHora.getSelectedItem());
                LocalTime hora = LocalTime.of(horaSeleccionada, 0);
                Reserva reserva = new Reserva(codigo, aux, fecha, hora);
                try {
                    controlador.guardarReserva(reserva);
                    JOptionPane.showMessageDialog(null, "Se hizo la reserva al puesto");
                    limpiarCampos();
                    ventana.validarColores();
                    llenarTabla();
                } catch (SoloUnaReservaExepcion | ReservaPuestoExepcion exp) {
                    JOptionPane.showMessageDialog(null, exp.getMessage());
                }
            }
        } catch (NoExisteElIdExepcion | LaboratoriaYaEstaEnMantenimientoExepcion | EstudianteNoExisteExepcion exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage());
        }
    }//GEN-LAST:event_cbxPrestamoActionPerformed

    private void cbxPrestamo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPrestamo1ActionPerformed
        try {
            int selectedRow = tblReserva.getSelectedRow();
            if (selectedRow != -1) {
                String codigo = tblReserva.getValueAt(selectedRow, 0).toString();
                String estudiante = tblReserva.getValueAt(selectedRow, 1).toString();
                String fecha = tblReserva.getValueAt(selectedRow, 2).toString();
                String horaInicio = tblReserva.getValueAt(selectedRow, 3).toString();
                try {
                    Reserva reserva = controlador.buscarReserva(codigo);
                    if (reserva != null) {
                        controlador.eliminarReserva(reserva);
                        JOptionPane.showMessageDialog(null, "Se canceló la Reserva");
                        limpiarCampos();
                        ventana.validarColores();
                        llenarTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la reserva");
                    }
                } catch (LaboratoriaYaEstaEnMantenimientoExepcion | ReservaPuestoExepcion exp) {
                    JOptionPane.showMessageDialog(null, exp.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar en la tabla la reserva que desea Eliminar");
            }
        } catch (NoExisteLaReservaExepcion exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage());
        }
    }//GEN-LAST:event_cbxPrestamo1ActionPerformed

    private void limpiarCampos() {
        txtUsuario.setText("");
        txtTelefono.setText("");
        txtPrograma.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        cbxHora.setSelectedIndex(-1);
        jDateReserva.setDate(null);
    }

    private void calendario() {
        LocalDate fechaActual = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate diaSiguiente = fechaActual.plusDays(1);
        Date date = Date.from(diaSiguiente.atStartOfDay(ZoneId.systemDefault()).toInstant());
        jDateReserva.setMinSelectableDate(date);
    }

    public boolean CamposVacios() {
        String fechareserva = ((JTextField) jDateReserva.getDateEditor().getUiComponent()).getText();
        if (txtUsuario.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtPrograma.getText().isEmpty() || txtNombre.getText().isEmpty()
                || txtDireccion.getText().isEmpty() || cbxHora.getSelectedIndex() == -1 || fechareserva.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private void llenarTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
            "CODIGO", "ESTUDIANTE", "FECHA", "HORA-INICIO"});
        IList<Reserva> listaReserva = puesto.getListaReservas();
        for (int i = 0; i < listaReserva.size(); i++) {
            model.addRow(new Object[]{
                listaReserva.get(i).getCodigoReserva(),
                listaReserva.get(i).getEstudiante().getNombre(),
                listaReserva.get(i).getFecha(),
                listaReserva.get(i).getHoraInicio(),});
        }
        tblReserva.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cbxHora;
    private javax.swing.JButton cbxPrestamo;
    private javax.swing.JButton cbxPrestamo1;
    private com.toedter.calendar.JDateChooser jDateReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tblReserva;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrograma;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
