package edu.ec.com.donbosquito.vista.moduloPersona;

import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorDocente;
import edu.ec.com.donbosquito.modelo.moduloPersona.Docente;
import edu.ec.com.donbosquito.modelo.moduloPersona.Estudiante;
import edu.ec.com.donbosquito.modelo.moduloPersona.Persona;
import edu.ec.com.donbosquito.modelo.moduloPersona.Representante;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernandosanchez
 */
public class DocenteEliminar extends javax.swing.JPanel {
    
    ControladorDocente controladorDocente = new ControladorDocente();
    

    /**
     * Creates new form NewJPanel
     */
    public DocenteEliminar() {
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

        jPanelEliminarDocente = new javax.swing.JPanel();
        jlCedulaEliminar = new javax.swing.JLabel();
        jlNombreEliminar = new javax.swing.JLabel();
        txtCedulaEliminar = new javax.swing.JTextField();
        txtNombreEliminar = new javax.swing.JTextField();
        jLApellidosEliminar = new javax.swing.JLabel();
        txtApellidosEliminar = new javax.swing.JTextField();
        jlDireccionEliminar = new javax.swing.JLabel();
        txtDireccionEliminar = new javax.swing.JTextField();
        jlTelefonoEliminar = new javax.swing.JLabel();
        txtTelefonoEliminar = new javax.swing.JTextField();
        jlCorreoEliminar = new javax.swing.JLabel();
        txtCorreoEliminar = new javax.swing.JTextField();
        jlTituloEliminar = new javax.swing.JLabel();
        txtTituloEliminar = new javax.swing.JTextField();
        jbEliminar = new javax.swing.JButton();
        jbLimpiarEliminar = new javax.swing.JButton();
        jlBuscarEliminar = new javax.swing.JLabel();
        txtBuscarEliminar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();

        jPanelEliminarDocente.setBackground(new java.awt.Color(51, 51, 51));

        jlCedulaEliminar.setForeground(new java.awt.Color(204, 204, 204));
        jlCedulaEliminar.setText("Cédula:");

        jlNombreEliminar.setForeground(new java.awt.Color(204, 204, 204));
        jlNombreEliminar.setText("Nombre:");

        txtCedulaEliminar.setBackground(new java.awt.Color(153, 153, 153));

        txtNombreEliminar.setBackground(new java.awt.Color(153, 153, 153));
        txtNombreEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEliminarActionPerformed(evt);
            }
        });

        jLApellidosEliminar.setBackground(new java.awt.Color(204, 204, 204));
        jLApellidosEliminar.setForeground(new java.awt.Color(204, 204, 204));
        jLApellidosEliminar.setText("Apellidos:");

        txtApellidosEliminar.setBackground(new java.awt.Color(153, 153, 153));

        jlDireccionEliminar.setForeground(new java.awt.Color(204, 204, 204));
        jlDireccionEliminar.setText("Dirección:");

        txtDireccionEliminar.setBackground(new java.awt.Color(153, 153, 153));

        jlTelefonoEliminar.setForeground(new java.awt.Color(204, 204, 204));
        jlTelefonoEliminar.setText("Teléfono:");

        txtTelefonoEliminar.setBackground(new java.awt.Color(153, 153, 153));

        jlCorreoEliminar.setForeground(new java.awt.Color(204, 204, 204));
        jlCorreoEliminar.setText("Correo:");

        txtCorreoEliminar.setBackground(new java.awt.Color(153, 153, 153));

        jlTituloEliminar.setForeground(new java.awt.Color(204, 204, 204));
        jlTituloEliminar.setText("Titulo:");

        txtTituloEliminar.setBackground(new java.awt.Color(153, 153, 153));

        jbEliminar.setBackground(new java.awt.Color(51, 51, 51));
        jbEliminar.setForeground(new java.awt.Color(204, 204, 204));
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbLimpiarEliminar.setBackground(new java.awt.Color(51, 51, 51));
        jbLimpiarEliminar.setForeground(new java.awt.Color(204, 204, 204));
        jbLimpiarEliminar.setText("Limpiar");
        jbLimpiarEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarEliminarActionPerformed(evt);
            }
        });

        jlBuscarEliminar.setForeground(new java.awt.Color(204, 204, 204));
        jlBuscarEliminar.setText("Ingresar Cédula:");

        txtBuscarEliminar.setBackground(new java.awt.Color(153, 153, 153));

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEliminarDocenteLayout = new javax.swing.GroupLayout(jPanelEliminarDocente);
        jPanelEliminarDocente.setLayout(jPanelEliminarDocenteLayout);
        jPanelEliminarDocenteLayout.setHorizontalGroup(
            jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEliminarDocenteLayout.createSequentialGroup()
                .addGroup(jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEliminarDocenteLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addGroup(jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlCedulaEliminar)
                            .addComponent(jlNombreEliminar)
                            .addComponent(jLApellidosEliminar)
                            .addComponent(jlDireccionEliminar)
                            .addComponent(jlTelefonoEliminar)
                            .addComponent(jlCorreoEliminar)
                            .addComponent(jlTituloEliminar)
                            .addComponent(jlBuscarEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCedulaEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(txtNombreEliminar)
                            .addComponent(txtApellidosEliminar)
                            .addComponent(txtDireccionEliminar)
                            .addComponent(txtTelefonoEliminar)
                            .addComponent(txtCorreoEliminar)
                            .addComponent(txtTituloEliminar)
                            .addComponent(txtBuscarEliminar))
                        .addGap(44, 44, 44)
                        .addComponent(jbBuscar))
                    .addGroup(jPanelEliminarDocenteLayout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jbLimpiarEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanelEliminarDocenteLayout.setVerticalGroup(
            jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEliminarDocenteLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlBuscarEliminar)
                    .addComponent(txtBuscarEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCedulaEliminar)
                    .addComponent(txtCedulaEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNombreEliminar)
                    .addComponent(txtNombreEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLApellidosEliminar)
                    .addComponent(txtApellidosEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDireccionEliminar)
                    .addComponent(txtDireccionEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTelefonoEliminar)
                    .addComponent(txtTelefonoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCorreoEliminar)
                    .addComponent(txtCorreoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTituloEliminar)
                    .addComponent(txtTituloEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelEliminarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminar)
                    .addComponent(jbLimpiarEliminar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelEliminarDocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanelEliminarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbLimpiarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarEliminarActionPerformed
        // TODO add your handling code here:
        limpiar();
        
    }//GEN-LAST:event_jbLimpiarEliminarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        
        eliminarDocente();
        
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void txtNombreEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEliminarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
        buscarDocente();
    }//GEN-LAST:event_jbBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLApellidosEliminar;
    private javax.swing.JPanel jPanelEliminarDocente;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbLimpiarEliminar;
    private javax.swing.JLabel jlBuscarEliminar;
    private javax.swing.JLabel jlCedulaEliminar;
    private javax.swing.JLabel jlCorreoEliminar;
    private javax.swing.JLabel jlDireccionEliminar;
    private javax.swing.JLabel jlNombreEliminar;
    private javax.swing.JLabel jlTelefonoEliminar;
    private javax.swing.JLabel jlTituloEliminar;
    private javax.swing.JTextField txtApellidosEliminar;
    private javax.swing.JTextField txtBuscarEliminar;
    private javax.swing.JTextField txtCedulaEliminar;
    private javax.swing.JTextField txtCorreoEliminar;
    private javax.swing.JTextField txtDireccionEliminar;
    private javax.swing.JTextField txtNombreEliminar;
    private javax.swing.JTextField txtTelefonoEliminar;
    private javax.swing.JTextField txtTituloEliminar;
    // End of variables declaration//GEN-END:variables
    
    void buscarDocente(){
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Docente docente = new Docente(0, "", persona, 0, "", "", "", "", "", "");
        docente = controladorDocente.buscarDocenteCedula(txtBuscarEliminar.getText());
        txtCedulaEliminar.setText(docente.getCedula());
        txtNombreEliminar.setText(docente.getNombre());
        txtApellidosEliminar.setText(docente.getApellido());
        txtDireccionEliminar.setText(docente.getDireccion());
        txtTelefonoEliminar.setText(docente.getTelefono());
        txtCorreoEliminar.setText(docente.getCorreo());
        txtTituloEliminar.setText(docente.getTituloDocente());
        txtBuscarEliminar.setText("");   
    }
    
    void eliminarDocente(){
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Docente docente = new Docente(0, "", persona, 0, "", "", "", "", "", "");
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");
        docente = controladorDocente.buscarDocenteCedula(txtCedulaEliminar.getText());  
        docente.setCodigoPersona(docente.getCodigoPersona());
        controladorDocente.eliminarUsuario(estudiante, docente, representante, persona);
        limpiar();
              
    }
    
    void limpiar(){
        txtBuscarEliminar.setText("");
        txtCedulaEliminar.setText("");
        txtNombreEliminar.setText("");
        txtApellidosEliminar.setText("");
        txtDireccionEliminar.setText("");
        txtTelefonoEliminar.setText("");
        txtCorreoEliminar.setText("");
        txtTituloEliminar.setText("");
    }
    
    public static java.util.Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }
}