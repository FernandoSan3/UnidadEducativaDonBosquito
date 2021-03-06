package edu.ec.com.donbosquito.vista.moduloPersona;


import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorDocente;
import edu.ec.com.donbosquito.modelo.moduloPersona.Docente;
import edu.ec.com.donbosquito.modelo.moduloPersona.Estudiante;
import edu.ec.com.donbosquito.modelo.moduloPersona.Persona;
import edu.ec.com.donbosquito.modelo.moduloPersona.Representante;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernandosanchez
 */
public class DocenteListar extends javax.swing.JPanel {
    
    ControladorDocente controladorDocente;
    Color myColor = new Color(255,255,208);

    /**
     * Creates new form DocenteCrear
     */
    public DocenteListar(ControladorDocente controladorDocente) {
        initComponents();
        this.controladorDocente = controladorDocente;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelListarDocente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistrosJtbl = new javax.swing.JTable();
        jbListar = new javax.swing.JButton();

        jPanelListarDocente.setBackground(new java.awt.Color(51, 51, 51));

        tablaRegistrosJtbl.setBackground(new java.awt.Color(102, 102, 102));
        tablaRegistrosJtbl.setForeground(new java.awt.Color(204, 204, 204));
        tablaRegistrosJtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombres", "Apellidos", "Dirección", "Teléfono", "Correo", "Título"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaRegistrosJtbl.setGridColor(new java.awt.Color(102, 102, 102));
        tablaRegistrosJtbl.setSelectionForeground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(tablaRegistrosJtbl);
        if (tablaRegistrosJtbl.getColumnModel().getColumnCount() > 0) {
            tablaRegistrosJtbl.getColumnModel().getColumn(0).setHeaderValue("Cédula");
            tablaRegistrosJtbl.getColumnModel().getColumn(1).setHeaderValue("Nombres");
            tablaRegistrosJtbl.getColumnModel().getColumn(2).setHeaderValue("Apellidos");
            tablaRegistrosJtbl.getColumnModel().getColumn(3).setHeaderValue("Dirección");
            tablaRegistrosJtbl.getColumnModel().getColumn(4).setHeaderValue("Teléfono");
            tablaRegistrosJtbl.getColumnModel().getColumn(5).setHeaderValue("Correo");
            tablaRegistrosJtbl.getColumnModel().getColumn(6).setHeaderValue("Título");
        }

        jbListar.setText("Listar");
        jbListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelListarDocenteLayout = new javax.swing.GroupLayout(jPanelListarDocente);
        jPanelListarDocente.setLayout(jPanelListarDocenteLayout);
        jPanelListarDocenteLayout.setHorizontalGroup(
            jPanelListarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListarDocenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
            .addGroup(jPanelListarDocenteLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jbListar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelListarDocenteLayout.setVerticalGroup(
            jPanelListarDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListarDocenteLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbListar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelListarDocente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelListarDocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarActionPerformed
        // TODO add your handling code here:
        listarControles();
    }//GEN-LAST:event_jbListarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelListarDocente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbListar;
    private javax.swing.JTable tablaRegistrosJtbl;
    // End of variables declaration//GEN-END:variables
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
    
    void listarControles() {
        DefaultTableModel modelo = (DefaultTableModel) tablaRegistrosJtbl.getModel();
        for (int i = 0; i < tablaRegistrosJtbl.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        for (Docente f : controladorDocente.listarUsuario()) {
            
            Object[] rowData = {f.getCedula(), f.getNombre(), f.getApellido(), f.getDireccion(), f.getTelefono(), f.getCorreo(), f.getTituloDocente()};
            modelo.addRow(rowData);
        }
        tablaRegistrosJtbl.setModel(modelo);
    }
}
