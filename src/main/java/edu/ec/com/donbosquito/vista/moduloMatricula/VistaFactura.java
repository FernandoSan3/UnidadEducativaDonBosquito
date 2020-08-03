/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.vista.moduloMatricula;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import edu.ec.com.donbosquito.controlador.moduloMatricula.ControladorFacturaCabecera;
import edu.ec.com.donbosquito.controlador.moduloMatricula.ControladorFacturaDetalle;
import edu.ec.com.donbosquito.controlador.moduloMatricula.ControladorMatricula;
import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorRepresentante;
import edu.ec.com.donbosquito.modelo.moduloGrupo.AnioLectivo;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Curso;
import edu.ec.com.donbosquito.modelo.moduloGrupo.GrupoCabecera;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Mension;
import edu.ec.com.donbosquito.modelo.moduloMatricula.FacturaCabecera;
import edu.ec.com.donbosquito.modelo.moduloMatricula.FacturaDetalle;
import edu.ec.com.donbosquito.modelo.moduloMatricula.Matricula;
import edu.ec.com.donbosquito.modelo.moduloPersona.Estudiante;
import edu.ec.com.donbosquito.modelo.moduloPersona.Persona;
import edu.ec.com.donbosquito.modelo.moduloPersona.Representante;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorim
 */
public class VistaFactura extends javax.swing.JInternalFrame {

    /**
     * Creates new form FacturaCabecera
     */
    private ControladorRepresentante controladorRepresentante;
    private ControladorFacturaCabecera controladorFacturaCabecera;
    private ControladorFacturaDetalle controladorFacturaDetalle;
    private ControladorMatricula controladorMatricula;
    private FacturaCabecera facturaCabecera;

    public VistaFactura() {
        initComponents();
        this.controladorRepresentante = new ControladorRepresentante();
        this.controladorFacturaCabecera = new ControladorFacturaCabecera();
        this.controladorFacturaDetalle = new ControladorFacturaDetalle();
        this.controladorMatricula = new ControladorMatricula();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        nFacturaJlb = new javax.swing.JLabel();
        codigoTxt = new javax.swing.JTextField();
        fechaTxt = new javax.swing.JTextField();
        fechaJlb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cedulaJlb = new javax.swing.JLabel();
        cedulaReTxt = new javax.swing.JTextField();
        telefonoReTxt = new javax.swing.JTextField();
        telefonoJlb = new javax.swing.JLabel();
        nombreReTxt = new javax.swing.JTextField();
        apellidoReTxt = new javax.swing.JTextField();
        direccionReTxt = new javax.swing.JTextField();
        emailReTxt = new javax.swing.JTextField();
        emailJlb = new javax.swing.JLabel();
        direccionJlb = new javax.swing.JLabel();
        nombreJlb = new javax.swing.JLabel();
        apellidoJlb = new javax.swing.JLabel();
        representanteFac = new javax.swing.JLabel();
        ivaTxt = new javax.swing.JTextField();
        subtotalJb = new javax.swing.JLabel();
        subtotalTxt = new javax.swing.JTextField();
        ivaJlb = new javax.swing.JLabel();
        totalJlb = new javax.swing.JLabel();
        totalTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nuevoBnt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        detalleJtbl = new javax.swing.JTable();
        matriculaFa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        nFacturaJlb1 = new javax.swing.JLabel();
        nFacturaTxt = new javax.swing.JTextField();
        buscarBnt = new javax.swing.JButton();
        eliminarBnt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cedulaJlb1 = new javax.swing.JLabel();
        cedulaReTxt1 = new javax.swing.JTextField();
        telefonoJlb1 = new javax.swing.JLabel();
        telefonoReTxt1 = new javax.swing.JTextField();
        direccionReTxt1 = new javax.swing.JTextField();
        direccionJlb1 = new javax.swing.JLabel();
        nombreReTxt1 = new javax.swing.JTextField();
        nombreJlb1 = new javax.swing.JLabel();
        apellidoJlb1 = new javax.swing.JLabel();
        apellidoReTxt1 = new javax.swing.JTextField();
        emailReTxt1 = new javax.swing.JTextField();
        emailJlb1 = new javax.swing.JLabel();
        representanteFac1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        detalleJtbl1 = new javax.swing.JTable();

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(null);

        nFacturaJlb.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        nFacturaJlb.setForeground(new java.awt.Color(255, 0, 0));
        nFacturaJlb.setText("No. Factura: ");
        jPanel2.add(nFacturaJlb);
        nFacturaJlb.setBounds(390, 20, 160, 30);

        codigoTxt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel2.add(codigoTxt);
        codigoTxt.setBounds(540, 20, 90, 30);
        jPanel2.add(fechaTxt);
        fechaTxt.setBounds(540, 60, 90, 30);

        fechaJlb.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        fechaJlb.setForeground(new java.awt.Color(31, 92, 150));
        fechaJlb.setText("Fecha:");
        jPanel2.add(fechaJlb);
        fechaJlb.setBounds(460, 60, 80, 30);

        jLabel1.setBackground(new java.awt.Color(31, 92, 150));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ec/com/donbosquito/imagenes/Bill_48px.png"))); // NOI18N
        jLabel1.setText("Factura");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(29, 22, 160, 60);

        cedulaJlb.setBackground(new java.awt.Color(31, 92, 150));
        cedulaJlb.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cedulaJlb.setForeground(new java.awt.Color(31, 92, 150));
        cedulaJlb.setText("Cedula: ");
        jPanel2.add(cedulaJlb);
        cedulaJlb.setBounds(30, 120, 60, 20);

        cedulaReTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaReTxtActionPerformed(evt);
            }
        });
        jPanel2.add(cedulaReTxt);
        cedulaReTxt.setBounds(90, 120, 230, 22);
        jPanel2.add(telefonoReTxt);
        telefonoReTxt.setBounds(390, 120, 230, 22);

        telefonoJlb.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        telefonoJlb.setForeground(new java.awt.Color(31, 92, 150));
        telefonoJlb.setText("Telefono: ");
        jPanel2.add(telefonoJlb);
        telefonoJlb.setBounds(320, 120, 70, 20);
        jPanel2.add(nombreReTxt);
        nombreReTxt.setBounds(90, 150, 230, 22);
        jPanel2.add(apellidoReTxt);
        apellidoReTxt.setBounds(90, 180, 230, 22);
        jPanel2.add(direccionReTxt);
        direccionReTxt.setBounds(390, 150, 230, 22);

        emailReTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailReTxtActionPerformed(evt);
            }
        });
        jPanel2.add(emailReTxt);
        emailReTxt.setBounds(390, 180, 230, 22);

        emailJlb.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        emailJlb.setForeground(new java.awt.Color(31, 92, 150));
        emailJlb.setText("e-mail: ");
        jPanel2.add(emailJlb);
        emailJlb.setBounds(340, 180, 70, 20);

        direccionJlb.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        direccionJlb.setForeground(new java.awt.Color(31, 92, 150));
        direccionJlb.setText("Direccion: ");
        jPanel2.add(direccionJlb);
        direccionJlb.setBounds(320, 150, 80, 20);

        nombreJlb.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        nombreJlb.setForeground(new java.awt.Color(31, 92, 150));
        nombreJlb.setText("Nombre: ");
        jPanel2.add(nombreJlb);
        nombreJlb.setBounds(30, 150, 70, 20);

        apellidoJlb.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        apellidoJlb.setForeground(new java.awt.Color(31, 92, 150));
        apellidoJlb.setText("Apellido: ");
        jPanel2.add(apellidoJlb);
        apellidoJlb.setBounds(30, 180, 58, 20);

        representanteFac.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Representante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel2.add(representanteFac);
        representanteFac.setBounds(12, 93, 680, 151);
        jPanel2.add(ivaTxt);
        ivaTxt.setBounds(560, 440, 120, 30);

        subtotalJb.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        subtotalJb.setForeground(new java.awt.Color(31, 92, 150));
        subtotalJb.setText("Subtotal:");
        jPanel2.add(subtotalJb);
        subtotalJb.setBounds(500, 410, 70, 20);
        jPanel2.add(subtotalTxt);
        subtotalTxt.setBounds(560, 410, 120, 30);

        ivaJlb.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        ivaJlb.setForeground(new java.awt.Color(31, 92, 150));
        ivaJlb.setText("IVA:");
        jPanel2.add(ivaJlb);
        ivaJlb.setBounds(530, 440, 50, 20);

        totalJlb.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        totalJlb.setForeground(new java.awt.Color(31, 92, 150));
        totalJlb.setText("Total: ");
        jPanel2.add(totalJlb);
        totalJlb.setBounds(520, 470, 50, 20);
        jPanel2.add(totalTxt);
        totalTxt.setBounds(560, 470, 120, 30);

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.add(jLabel2);
        jLabel2.setBounds(480, 400, 210, 130);

        nuevoBnt.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        nuevoBnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ec/com/donbosquito/imagenes/Save_50px.png"))); // NOI18N
        nuevoBnt.setText("Guardar");
        nuevoBnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBntActionPerformed(evt);
            }
        });
        jPanel2.add(nuevoBnt);
        nuevoBnt.setBounds(20, 410, 130, 50);

        detalleJtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Fecha Matricula", "Materias", "Grupo"
            }
        ));
        jScrollPane2.setViewportView(detalleJtbl);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(20, 270, 660, 120);

        matriculaFa.setBorder(javax.swing.BorderFactory.createTitledBorder("Matricula"));
        jPanel2.add(matriculaFa);
        matriculaFa.setBounds(10, 250, 680, 150);

        jTabbedPane1.addTab("Factura", jPanel2);

        jPanel3.setLayout(null);

        nFacturaJlb1.setForeground(new java.awt.Color(31, 92, 150));
        nFacturaJlb1.setText("No. Factura:");
        jPanel3.add(nFacturaJlb1);
        nFacturaJlb1.setBounds(20, 30, 80, 30);
        jPanel3.add(nFacturaTxt);
        nFacturaTxt.setBounds(100, 30, 100, 30);

        buscarBnt.setText("Buscar");
        buscarBnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBntActionPerformed(evt);
            }
        });
        jPanel3.add(buscarBnt);
        buscarBnt.setBounds(310, 40, 120, 40);

        eliminarBnt.setText("Eliminar");
        eliminarBnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBntActionPerformed(evt);
            }
        });
        jPanel3.add(eliminarBnt);
        eliminarBnt.setBounds(490, 40, 120, 40);

        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));
        jPanel3.add(jLabel3);
        jLabel3.setBounds(250, 20, 410, 80);

        cedulaJlb1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cedulaJlb1.setForeground(new java.awt.Color(31, 92, 150));
        cedulaJlb1.setText("Cedula: ");
        jPanel3.add(cedulaJlb1);
        cedulaJlb1.setBounds(40, 150, 60, 20);

        cedulaReTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaReTxt1ActionPerformed(evt);
            }
        });
        jPanel3.add(cedulaReTxt1);
        cedulaReTxt1.setBounds(100, 150, 230, 22);

        telefonoJlb1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        telefonoJlb1.setForeground(new java.awt.Color(31, 92, 150));
        telefonoJlb1.setText("Telefono: ");
        jPanel3.add(telefonoJlb1);
        telefonoJlb1.setBounds(330, 150, 70, 20);
        jPanel3.add(telefonoReTxt1);
        telefonoReTxt1.setBounds(400, 150, 230, 22);
        jPanel3.add(direccionReTxt1);
        direccionReTxt1.setBounds(400, 180, 230, 22);

        direccionJlb1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        direccionJlb1.setForeground(new java.awt.Color(31, 92, 150));
        direccionJlb1.setText("Direccion: ");
        jPanel3.add(direccionJlb1);
        direccionJlb1.setBounds(330, 180, 80, 20);
        jPanel3.add(nombreReTxt1);
        nombreReTxt1.setBounds(100, 180, 230, 22);

        nombreJlb1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        nombreJlb1.setForeground(new java.awt.Color(31, 92, 150));
        nombreJlb1.setText("Nombre: ");
        jPanel3.add(nombreJlb1);
        nombreJlb1.setBounds(40, 180, 70, 20);

        apellidoJlb1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        apellidoJlb1.setForeground(new java.awt.Color(31, 92, 150));
        apellidoJlb1.setText("Apellido: ");
        jPanel3.add(apellidoJlb1);
        apellidoJlb1.setBounds(40, 210, 58, 20);
        jPanel3.add(apellidoReTxt1);
        apellidoReTxt1.setBounds(100, 210, 230, 22);

        emailReTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailReTxt1ActionPerformed(evt);
            }
        });
        jPanel3.add(emailReTxt1);
        emailReTxt1.setBounds(400, 210, 230, 22);

        emailJlb1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        emailJlb1.setForeground(new java.awt.Color(31, 92, 150));
        emailJlb1.setText("e-mail: ");
        jPanel3.add(emailJlb1);
        emailJlb1.setBounds(350, 210, 70, 20);

        representanteFac1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Representante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel3.add(representanteFac1);
        representanteFac1.setBounds(10, 120, 680, 151);

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Matricula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 290, 670, 140);

        detalleJtbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Fecha Matricula", "Materias", "Grupo"
            }
        ));
        jScrollPane3.setViewportView(detalleJtbl1);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(30, 310, 660, 120);

        jTabbedPane1.addTab("Buscar", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
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

    private void cedulaReTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaReTxtActionPerformed
        /*   nuevoBnt.setEnabled(false);
        if (cedulaReTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese la cédula del cliente.");
        } else {
            buscarPersona();
            if (nombreReTxt.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "No hay Clientes registrados con este numero de cédula.");
                activarCLiente();
                facturaJtbl.setEnabled(false);
                controCliente.contar(codigoPertxt);
            } else {
                desactivarCLiente();
                facturaJtbl.setEnabled(true);
                nuevoBnt.setEnabled(true);
            }
        }
         */
    }//GEN-LAST:event_cedulaReTxtActionPerformed

    private void emailReTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailReTxtActionPerformed
        /*  if (nombreReTxt.getText().equals("") || apellidoReTxt.getText().equals("") || cedulaReTxt.getText().equals("") || direccionReTxt.getText().equals("") || telefonoReTxt.getText().equals("") || emailReTxt.getText().equals("") || codigoPertxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese todos los datos del Cliente.");
        } else {
            crearPersona();
            JOptionPane.showMessageDialog(this, "Cliente Guardado.");
            desactivarCLiente();
            facturaJtbl.setEnabled(true);
            cedulaReTxt.setEditable(true);
            nuevoBnt.setEnabled(true);
        }*/
    }//GEN-LAST:event_emailReTxtActionPerformed

    private void nuevoBntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBntActionPerformed
        /* limpiarTabla();
        codigoDetalleFactura=0;
        subtotal=0;
        limpiarCliente();
        controFacturaCabecera.contar(codigoTxt);
        obtenerFecha();
        limpiarProducto();
        imprimirBnt.setEnabled(false);
        cedulaTxt.requestFocus();
        subtotalTxt.setText("");
        ivaTxt.setText("");
        totalTxt.setText("");*/
        guardarFactura();
    }//GEN-LAST:event_nuevoBntActionPerformed

    private void buscarBntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBntActionPerformed
        /*
        if(nFacturaTxt.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Ingrese el código de la Factura");
            eliminarBnt.setEnabled(false);
        }else{
            buscarFactura();
            listarDetalle();
            eliminarBnt.setEnabled(true);
        }
         */
    }//GEN-LAST:event_buscarBntActionPerformed

    private void eliminarBntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBntActionPerformed
        /*  if(JOptionPane.showConfirmDialog(this, "¿Desea realmente eliminar la Factura?", "Eliminar Factura", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            eliminarFacturaDetalle();
            eliminarFactura();
            limpiarTablaDetalle();
            limpiarTablaFactura();
            JOptionPane.showMessageDialog(this, "Factura Eiminada");
            nFacturaTxt.setText("");
            eliminarBnt.setEnabled(false);
        }*/
    }//GEN-LAST:event_eliminarBntActionPerformed

    private void cedulaReTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaReTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaReTxt1ActionPerformed

    private void emailReTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailReTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailReTxt1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellidoJlb;
    private javax.swing.JLabel apellidoJlb1;
    private javax.swing.JTextField apellidoReTxt;
    private javax.swing.JTextField apellidoReTxt1;
    private javax.swing.JButton buscarBnt;
    private javax.swing.JLabel cedulaJlb;
    private javax.swing.JLabel cedulaJlb1;
    private javax.swing.JTextField cedulaReTxt;
    private javax.swing.JTextField cedulaReTxt1;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JTable detalleJtbl;
    private javax.swing.JTable detalleJtbl1;
    private javax.swing.JLabel direccionJlb;
    private javax.swing.JLabel direccionJlb1;
    private javax.swing.JTextField direccionReTxt;
    private javax.swing.JTextField direccionReTxt1;
    private javax.swing.JButton eliminarBnt;
    private javax.swing.JLabel emailJlb;
    private javax.swing.JLabel emailJlb1;
    private javax.swing.JTextField emailReTxt;
    private javax.swing.JTextField emailReTxt1;
    private javax.swing.JLabel fechaJlb;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JLabel ivaJlb;
    private javax.swing.JTextField ivaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel matriculaFa;
    private javax.swing.JLabel nFacturaJlb;
    private javax.swing.JLabel nFacturaJlb1;
    private javax.swing.JTextField nFacturaTxt;
    private javax.swing.JLabel nombreJlb;
    private javax.swing.JLabel nombreJlb1;
    private javax.swing.JTextField nombreReTxt;
    private javax.swing.JTextField nombreReTxt1;
    private javax.swing.JButton nuevoBnt;
    private javax.swing.JLabel representanteFac;
    private javax.swing.JLabel representanteFac1;
    private javax.swing.JLabel subtotalJb;
    private javax.swing.JTextField subtotalTxt;
    private javax.swing.JLabel telefonoJlb;
    private javax.swing.JLabel telefonoJlb1;
    private javax.swing.JTextField telefonoReTxt;
    private javax.swing.JTextField telefonoReTxt1;
    private javax.swing.JLabel totalJlb;
    private javax.swing.JTextField totalTxt;
    // End of variables declaration//GEN-END:variables

    void guardarFactura() {

        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");

        Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "'", "", "", "", "", "");
        Curso curso = new Curso(0, "", "");
        AnioLectivo anioLectivo = new AnioLectivo(0, "", ParseFecha("0/0/0"), ParseFecha("0/0/0"));
        Mension mension = new Mension(0, "", "", "");
        GrupoCabecera grupoCabecera = new GrupoCabecera(0, "", "", "'", curso, anioLectivo, mension);

        Matricula matricula = new Matricula(0, ParseFecha("0/0/0"), estudiante, grupoCabecera);
        facturaCabecera = new FacturaCabecera(0, 0, ParseFecha("0/0/0"), 0, 0, representante);

        FacturaDetalle facturaDetalle = new FacturaDetalle(0, 0, 0, "", matricula, facturaCabecera);

        controladorFacturaCabecera = new ControladorFacturaCabecera();
        facturaCabecera.setCodigo(Integer.valueOf(codigoTxt.getText()));

        //facturaCabecera.setFechaFacturaCabecera(facturaCabecera);
        facturaCabecera.setRepresentante((Representante)controladorRepresentante.buscarCedulaRepresentante(cedulaReTxt.getText()));
        facturaCabecera.setSubtotal(Integer.valueOf(subtotalTxt.getText()));
        facturaCabecera.setTotal(Integer.valueOf(totalTxt.getText()));
        controladorFacturaCabecera.crearFacturaCabecera(facturaCabecera);
        
  
    }

    void buscarRepresentante() {
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Representante representante = controladorRepresentante.buscarCedulaRepresentante(cedulaReTxt.getText());
        cedulaReTxt.setText(String.valueOf(representante.getCedula()));
        nombreReTxt.setText(String.valueOf(representante.getNombre()));
        apellidoReTxt.setText(String.valueOf(representante.getApellido()));
        telefonoReTxt.setText(String.valueOf(representante.getTelefono()));
        direccionReTxt.setText(String.valueOf(representante.getDireccion()));
        emailReTxt.setText(String.valueOf(representante.getCorreo()));
    }

    void listarMatricula() {
        DefaultTableModel modelo = (DefaultTableModel) detalleJtbl.getModel();
        for (int i = 0; i < detalleJtbl.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;

        }
        for (Matricula j : controladorMatricula.listarMatriculas()) {
            Object[] rowData = {j.getCodigo(), j.getFechaMatricula(), j.getEstudiante(), j.getGrupoCabecera()};
            modelo.addRow(rowData);

        }
        detalleJtbl.setModel(modelo);
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
