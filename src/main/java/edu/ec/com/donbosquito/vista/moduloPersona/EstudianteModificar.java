package edu.ec.com.donbosquito.vista.moduloPersona;

import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorEstudiante;
import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorRepresentante;
import edu.ec.com.donbosquito.modelo.moduloPersona.Docente;
import edu.ec.com.donbosquito.modelo.moduloPersona.Estudiante;
import edu.ec.com.donbosquito.modelo.moduloPersona.Persona;
import edu.ec.com.donbosquito.modelo.moduloPersona.Representante;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fernandosanchez
 */
public class EstudianteModificar extends javax.swing.JPanel {

    ControladorEstudiante controladorEstudiante = new ControladorEstudiante();
    ControladorRepresentante controladorRepresentante = new ControladorRepresentante();
    String aux;

    /**
     * Creates new form NewJPanel
     */
    public EstudianteModificar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBuscarEstudiante = new javax.swing.JPanel();
        jlCedulaModificarEstudiante = new javax.swing.JLabel();
        jlNombreModificarEstudiante = new javax.swing.JLabel();
        txtCedulaModificarEstudiante = new javax.swing.JTextField();
        txtNombreModificarEstudiante = new javax.swing.JTextField();
        jLApellidosModificarEstudiante = new javax.swing.JLabel();
        txtApellidosModificarEstudiante = new javax.swing.JTextField();
        jlDireccionModificarEstudiante = new javax.swing.JLabel();
        txtDireccionModificarEstudiante = new javax.swing.JTextField();
        jlTelefonoModificarEstudiante = new javax.swing.JLabel();
        txtTelefonoModificarEstudiante = new javax.swing.JTextField();
        jlCorreoModificarEstudiante = new javax.swing.JLabel();
        txtCorreoModificarEstudiante = new javax.swing.JTextField();
        jlFechaNacimientoModificarEstudiante = new javax.swing.JLabel();
        txtFechaNacimientoModificarEstudiante = new javax.swing.JTextField();
        jbBuscarModificarEstudiante = new javax.swing.JButton();
        jbLimpiarModificarEstudiante = new javax.swing.JButton();
        jlBuscarModificarCedula = new javax.swing.JLabel();
        txtBuscarCedulaModificarEstudiante = new javax.swing.JTextField();
        txtEdadModificarEstudiante = new javax.swing.JTextField();
        jlEdadModificarEstudiante = new javax.swing.JLabel();
        txtFechaInscripcionModificarEstudiante = new javax.swing.JTextField();
        jlFechaIncripcionModificarEstudiante = new javax.swing.JLabel();
        jlRepresentanteModificar = new javax.swing.JLabel();
        jlCedulaModificarRepresentante = new javax.swing.JLabel();
        txtCedulaModificarRepresentante = new javax.swing.JTextField();
        jlNombreModificarRepresentante = new javax.swing.JLabel();
        txtNombreModificarRepresentante = new javax.swing.JTextField();
        jLApellidosModificarRepresentante = new javax.swing.JLabel();
        txtApellidosModificarRepresentante = new javax.swing.JTextField();
        jlDireccionModificarRepresentante = new javax.swing.JLabel();
        txtDireccionModificarRepresentante = new javax.swing.JTextField();
        jlTelefonoModificarRepresentante = new javax.swing.JLabel();
        txtTelefonoModificarRepresentante = new javax.swing.JTextField();
        jlCorreoModificarRepresentante = new javax.swing.JLabel();
        txtCorreoModificarRepresentante = new javax.swing.JTextField();
        jlParentescoFamiliarModificarRepresentante = new javax.swing.JLabel();
        txtParentescoFamiliarModificarRepresentante = new javax.swing.JTextField();
        jbModificarModificarEstudiante = new javax.swing.JButton();

        jPanelBuscarEstudiante.setBackground(new java.awt.Color(51, 51, 51));

        jlCedulaModificarEstudiante.setForeground(new java.awt.Color(204, 204, 204));
        jlCedulaModificarEstudiante.setText("Cédula:");

        jlNombreModificarEstudiante.setForeground(new java.awt.Color(204, 204, 204));
        jlNombreModificarEstudiante.setText("Nombre:");

        txtCedulaModificarEstudiante.setBackground(new java.awt.Color(153, 153, 153));

        txtNombreModificarEstudiante.setBackground(new java.awt.Color(153, 153, 153));

        jLApellidosModificarEstudiante.setBackground(new java.awt.Color(204, 204, 204));
        jLApellidosModificarEstudiante.setForeground(new java.awt.Color(204, 204, 204));
        jLApellidosModificarEstudiante.setText("Apellidos:");

        txtApellidosModificarEstudiante.setBackground(new java.awt.Color(153, 153, 153));

        jlDireccionModificarEstudiante.setForeground(new java.awt.Color(204, 204, 204));
        jlDireccionModificarEstudiante.setText("Dirección:");

        txtDireccionModificarEstudiante.setBackground(new java.awt.Color(153, 153, 153));

        jlTelefonoModificarEstudiante.setForeground(new java.awt.Color(204, 204, 204));
        jlTelefonoModificarEstudiante.setText("Teléfono:");

        txtTelefonoModificarEstudiante.setBackground(new java.awt.Color(153, 153, 153));

        jlCorreoModificarEstudiante.setForeground(new java.awt.Color(204, 204, 204));
        jlCorreoModificarEstudiante.setText("Correo:");

        txtCorreoModificarEstudiante.setBackground(new java.awt.Color(153, 153, 153));

        jlFechaNacimientoModificarEstudiante.setForeground(new java.awt.Color(204, 204, 204));
        jlFechaNacimientoModificarEstudiante.setText("Fecha Nacimiento:");

        txtFechaNacimientoModificarEstudiante.setBackground(new java.awt.Color(153, 153, 153));

        jbBuscarModificarEstudiante.setBackground(new java.awt.Color(51, 51, 51));
        jbBuscarModificarEstudiante.setForeground(new java.awt.Color(204, 204, 204));
        jbBuscarModificarEstudiante.setText("Buscar");
        jbBuscarModificarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarModificarEstudianteActionPerformed(evt);
            }
        });

        jbLimpiarModificarEstudiante.setBackground(new java.awt.Color(51, 51, 51));
        jbLimpiarModificarEstudiante.setForeground(new java.awt.Color(204, 204, 204));
        jbLimpiarModificarEstudiante.setText("Limpiar");
        jbLimpiarModificarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarModificarEstudianteActionPerformed(evt);
            }
        });

        jlBuscarModificarCedula.setForeground(new java.awt.Color(204, 204, 204));
        jlBuscarModificarCedula.setText("Ingresar Cédula Estudiante:");

        txtBuscarCedulaModificarEstudiante.setBackground(new java.awt.Color(153, 153, 153));

        txtEdadModificarEstudiante.setBackground(new java.awt.Color(153, 153, 153));

        jlEdadModificarEstudiante.setForeground(new java.awt.Color(204, 204, 204));
        jlEdadModificarEstudiante.setText("Edad:");

        txtFechaInscripcionModificarEstudiante.setBackground(new java.awt.Color(153, 153, 153));

        jlFechaIncripcionModificarEstudiante.setForeground(new java.awt.Color(204, 204, 204));
        jlFechaIncripcionModificarEstudiante.setText("Fecha Inscripción:");

        jlRepresentanteModificar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlRepresentanteModificar.setForeground(new java.awt.Color(204, 204, 204));
        jlRepresentanteModificar.setText("Representante:");

        jlCedulaModificarRepresentante.setForeground(new java.awt.Color(204, 204, 204));
        jlCedulaModificarRepresentante.setText("Cédula:");

        txtCedulaModificarRepresentante.setBackground(new java.awt.Color(153, 153, 153));

        jlNombreModificarRepresentante.setForeground(new java.awt.Color(204, 204, 204));
        jlNombreModificarRepresentante.setText("Nombre:");

        txtNombreModificarRepresentante.setBackground(new java.awt.Color(153, 153, 153));

        jLApellidosModificarRepresentante.setBackground(new java.awt.Color(204, 204, 204));
        jLApellidosModificarRepresentante.setForeground(new java.awt.Color(204, 204, 204));
        jLApellidosModificarRepresentante.setText("Apellidos:");

        txtApellidosModificarRepresentante.setBackground(new java.awt.Color(153, 153, 153));

        jlDireccionModificarRepresentante.setForeground(new java.awt.Color(204, 204, 204));
        jlDireccionModificarRepresentante.setText("Dirección:");

        txtDireccionModificarRepresentante.setBackground(new java.awt.Color(153, 153, 153));

        jlTelefonoModificarRepresentante.setForeground(new java.awt.Color(204, 204, 204));
        jlTelefonoModificarRepresentante.setText("Teléfono:");

        txtTelefonoModificarRepresentante.setBackground(new java.awt.Color(153, 153, 153));

        jlCorreoModificarRepresentante.setForeground(new java.awt.Color(204, 204, 204));
        jlCorreoModificarRepresentante.setText("Correo:");

        txtCorreoModificarRepresentante.setBackground(new java.awt.Color(153, 153, 153));

        jlParentescoFamiliarModificarRepresentante.setForeground(new java.awt.Color(204, 204, 204));
        jlParentescoFamiliarModificarRepresentante.setText("Parentesco Familiar:");

        txtParentescoFamiliarModificarRepresentante.setBackground(new java.awt.Color(153, 153, 153));

        jbModificarModificarEstudiante.setBackground(new java.awt.Color(51, 51, 51));
        jbModificarModificarEstudiante.setForeground(new java.awt.Color(204, 204, 204));
        jbModificarModificarEstudiante.setText("Modificar");
        jbModificarModificarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarModificarEstudianteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscarEstudianteLayout = new javax.swing.GroupLayout(jPanelBuscarEstudiante);
        jPanelBuscarEstudiante.setLayout(jPanelBuscarEstudianteLayout);
        jPanelBuscarEstudianteLayout.setHorizontalGroup(
            jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarEstudianteLayout.createSequentialGroup()
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscarEstudianteLayout.createSequentialGroup()
                        .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBuscarEstudianteLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlCedulaModificarEstudiante)
                                    .addComponent(jlNombreModificarEstudiante)
                                    .addComponent(jLApellidosModificarEstudiante)
                                    .addComponent(jlDireccionModificarEstudiante)
                                    .addComponent(jlTelefonoModificarEstudiante)
                                    .addComponent(jlCorreoModificarEstudiante)
                                    .addComponent(jlFechaNacimientoModificarEstudiante)
                                    .addComponent(jlEdadModificarEstudiante)
                                    .addComponent(jlFechaIncripcionModificarEstudiante))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreModificarEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(txtApellidosModificarEstudiante)
                                    .addComponent(txtDireccionModificarEstudiante)
                                    .addComponent(txtTelefonoModificarEstudiante)
                                    .addComponent(txtCorreoModificarEstudiante)
                                    .addComponent(txtFechaNacimientoModificarEstudiante)
                                    .addComponent(txtEdadModificarEstudiante)
                                    .addComponent(txtFechaInscripcionModificarEstudiante)
                                    .addComponent(txtCedulaModificarEstudiante)))
                            .addGroup(jPanelBuscarEstudianteLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(txtBuscarCedulaModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jbBuscarModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBuscarEstudianteLayout.createSequentialGroup()
                                .addComponent(jlNombreModificarRepresentante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreModificarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBuscarEstudianteLayout.createSequentialGroup()
                                .addComponent(jLApellidosModificarRepresentante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtApellidosModificarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBuscarEstudianteLayout.createSequentialGroup()
                                .addComponent(jlDireccionModificarRepresentante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                .addComponent(txtDireccionModificarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBuscarEstudianteLayout.createSequentialGroup()
                                .addComponent(jlTelefonoModificarRepresentante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTelefonoModificarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelBuscarEstudianteLayout.createSequentialGroup()
                                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlCorreoModificarRepresentante)
                                    .addComponent(jlParentescoFamiliarModificarRepresentante))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtParentescoFamiliarModificarRepresentante, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(txtCorreoModificarRepresentante)))
                            .addGroup(jPanelBuscarEstudianteLayout.createSequentialGroup()
                                .addComponent(jlCedulaModificarRepresentante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlRepresentanteModificar)
                                    .addComponent(txtCedulaModificarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanelBuscarEstudianteLayout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jbModificarModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimpiarModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
            .addGroup(jPanelBuscarEstudianteLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jlBuscarModificarCedula)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBuscarEstudianteLayout.setVerticalGroup(
            jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarEstudianteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlBuscarModificarCedula)
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscarEstudianteLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jlRepresentanteModificar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarEstudianteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarCedulaModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscarModificarEstudiante))))
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCedulaModificarEstudiante)
                    .addComponent(txtCedulaModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCedulaModificarRepresentante)
                    .addComponent(txtCedulaModificarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNombreModificarEstudiante)
                    .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombreModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlNombreModificarRepresentante)
                        .addComponent(txtNombreModificarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLApellidosModificarEstudiante)
                    .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApellidosModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLApellidosModificarRepresentante)
                        .addComponent(txtApellidosModificarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDireccionModificarEstudiante)
                    .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDireccionModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlDireccionModificarRepresentante)
                        .addComponent(txtDireccionModificarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTelefonoModificarEstudiante)
                    .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTelefonoModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlTelefonoModificarRepresentante)
                        .addComponent(txtTelefonoModificarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCorreoModificarEstudiante)
                    .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCorreoModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlCorreoModificarRepresentante)
                        .addComponent(txtCorreoModificarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlFechaNacimientoModificarEstudiante)
                    .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFechaNacimientoModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlParentescoFamiliarModificarRepresentante)
                        .addComponent(txtParentescoFamiliarModificarRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdadModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEdadModificarEstudiante))
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaInscripcionModificarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlFechaIncripcionModificarEstudiante))
                .addGap(15, 15, 15)
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiarModificarEstudiante)
                    .addComponent(jbModificarModificarEstudiante))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBuscarEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbLimpiarModificarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarModificarEstudianteActionPerformed
        // TODO add your handling code here:
        limpiar();

    }//GEN-LAST:event_jbLimpiarModificarEstudianteActionPerformed

    private void jbBuscarModificarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarModificarEstudianteActionPerformed
        // TODO add your handling code here:

        buscarEstudiante();

    }//GEN-LAST:event_jbBuscarModificarEstudianteActionPerformed

    private void jbModificarModificarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarModificarEstudianteActionPerformed
        // TODO add your handling code here:
        modificarEstudiante();
    }//GEN-LAST:event_jbModificarModificarEstudianteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLApellidosModificarEstudiante;
    private javax.swing.JLabel jLApellidosModificarRepresentante;
    private javax.swing.JPanel jPanelBuscarEstudiante;
    private javax.swing.JButton jbBuscarModificarEstudiante;
    private javax.swing.JButton jbLimpiarModificarEstudiante;
    private javax.swing.JButton jbModificarModificarEstudiante;
    private javax.swing.JLabel jlBuscarModificarCedula;
    private javax.swing.JLabel jlCedulaModificarEstudiante;
    private javax.swing.JLabel jlCedulaModificarRepresentante;
    private javax.swing.JLabel jlCorreoModificarEstudiante;
    private javax.swing.JLabel jlCorreoModificarRepresentante;
    private javax.swing.JLabel jlDireccionModificarEstudiante;
    private javax.swing.JLabel jlDireccionModificarRepresentante;
    private javax.swing.JLabel jlEdadModificarEstudiante;
    private javax.swing.JLabel jlFechaIncripcionModificarEstudiante;
    private javax.swing.JLabel jlFechaNacimientoModificarEstudiante;
    private javax.swing.JLabel jlNombreModificarEstudiante;
    private javax.swing.JLabel jlNombreModificarRepresentante;
    private javax.swing.JLabel jlParentescoFamiliarModificarRepresentante;
    private javax.swing.JLabel jlRepresentanteModificar;
    private javax.swing.JLabel jlTelefonoModificarEstudiante;
    private javax.swing.JLabel jlTelefonoModificarRepresentante;
    private javax.swing.JTextField txtApellidosModificarEstudiante;
    private javax.swing.JTextField txtApellidosModificarRepresentante;
    private javax.swing.JTextField txtBuscarCedulaModificarEstudiante;
    private javax.swing.JTextField txtCedulaModificarEstudiante;
    private javax.swing.JTextField txtCedulaModificarRepresentante;
    private javax.swing.JTextField txtCorreoModificarEstudiante;
    private javax.swing.JTextField txtCorreoModificarRepresentante;
    private javax.swing.JTextField txtDireccionModificarEstudiante;
    private javax.swing.JTextField txtDireccionModificarRepresentante;
    private javax.swing.JTextField txtEdadModificarEstudiante;
    private javax.swing.JTextField txtFechaInscripcionModificarEstudiante;
    private javax.swing.JTextField txtFechaNacimientoModificarEstudiante;
    private javax.swing.JTextField txtNombreModificarEstudiante;
    private javax.swing.JTextField txtNombreModificarRepresentante;
    private javax.swing.JTextField txtParentescoFamiliarModificarRepresentante;
    private javax.swing.JTextField txtTelefonoModificarEstudiante;
    private javax.swing.JTextField txtTelefonoModificarRepresentante;
    // End of variables declaration//GEN-END:variables
    void buscarEstudiante() {
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Docente docente = new Docente(0, "", persona, 0, "", "", "", "", "", "");

        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");

        estudiante = controladorEstudiante.buscarCedulaEstudiante(txtBuscarCedulaModificarEstudiante.getText());
        txtCedulaModificarEstudiante.setText(estudiante.getCedula());
        txtNombreModificarEstudiante.setText(estudiante.getNombre());
        txtApellidosModificarEstudiante.setText(estudiante.getApellido());
        txtDireccionModificarEstudiante.setText(estudiante.getDireccion());
        txtTelefonoModificarEstudiante.setText(estudiante.getTelefono());
        txtCorreoModificarEstudiante.setText(estudiante.getCorreo());
        txtFechaNacimientoModificarEstudiante.setText(fecha(String.valueOf(estudiante.getFechaNaciemiento())));
        txtEdadModificarEstudiante.setText(String.valueOf(estudiante.getEdad()));
        txtFechaInscripcionModificarEstudiante.setText(fecha(String.valueOf(estudiante.getFechaInscripcion())));
        representante = controladorRepresentante.buscarUsuario(estudiante.getRepresentante().getCodigoPersona());
        txtCedulaModificarRepresentante.setText(representante.getCedula());
        txtNombreModificarRepresentante.setText(representante.getNombre());
        txtApellidosModificarRepresentante.setText(representante.getApellido());
        txtDireccionModificarRepresentante.setText(representante.getDireccion());
        txtTelefonoModificarRepresentante.setText(representante.getTelefono());
        txtCorreoModificarRepresentante.setText(representante.getCorreo());
        txtParentescoFamiliarModificarRepresentante.setText(representante.getParentescoFamiliar());
        aux = txtBuscarCedulaModificarEstudiante.getText();
        

        txtBuscarCedulaModificarEstudiante.setText("");
    }

    void modificarEstudiante() {
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Docente docente = new Docente(0, "", persona, 0, "", "", "", "", "", "");
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");
        estudiante = controladorEstudiante.buscarCedulaEstudiante(aux);

        estudiante.setCedula(txtCedulaModificarEstudiante.getText());
        estudiante.setNombre(txtNombreModificarEstudiante.getText());
        estudiante.setApellido(txtApellidosModificarEstudiante.getText());
        estudiante.setDireccion(txtDireccionModificarEstudiante.getText());
        estudiante.setTelefono(txtTelefonoModificarEstudiante.getText());
        estudiante.setCorreo(txtCorreoModificarEstudiante.getText());
        estudiante.setFechaNaciemiento(ParseFecha(txtFechaNacimientoModificarEstudiante.getText()));
        estudiante.setEdad(Integer.valueOf(txtEdadModificarEstudiante.getText()));
        estudiante.setFechaInscripcion(ParseFecha(txtFechaInscripcionModificarEstudiante.getText()));
        estudiante.setCodigoPersona(estudiante.getCodigoPersona());
        estudiante.setCodigoEstudiante(estudiante.getCodigoEstudiante());  
        
        estudiante.setRepresentante((Representante) controladorRepresentante.buscarCedulaRepresentante(txtCedulaModificarRepresentante.getText()));  
        estudiante.setPersona(estudiante);

        controladorEstudiante.modificarUsuario(estudiante, docente, representante, persona);
        limpiar();
    }

    void limpiar() {
        txtBuscarCedulaModificarEstudiante.setText("");
        txtCedulaModificarEstudiante.setText("");
        txtCedulaModificarRepresentante.setText("");
        txtNombreModificarEstudiante.setText("");
        txtNombreModificarRepresentante.setText("");
        txtApellidosModificarEstudiante.setText("");
        txtApellidosModificarRepresentante.setText("");
        txtDireccionModificarEstudiante.setText("");
        txtDireccionModificarRepresentante.setText("");
        txtTelefonoModificarEstudiante.setText("");
        txtTelefonoModificarRepresentante.setText("");
        txtCorreoModificarEstudiante.setText("");
        txtCorreoModificarRepresentante.setText("");
        txtFechaNacimientoModificarEstudiante.setText("");
        txtEdadModificarEstudiante.setText("");
        txtParentescoFamiliarModificarRepresentante.setText("");
        txtFechaInscripcionModificarEstudiante.setText("");
    }

    String fecha(String fecha) {
    
        String[] parts = fecha.split("-");
        String part1 = parts[0]; 
        String part2 = parts[1];
        String part3 = parts[2]; 
        fecha = part3+"/"+part2+"/"+part1;
        return fecha;
    }

    public static Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }
}
