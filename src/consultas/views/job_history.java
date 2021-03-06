/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.views;

import consultas.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Meltsan
 */
public class job_history extends javax.swing.JFrame {
    static final boolean EXL = true; //Execute queries on Local Database    
    DefaultTableModel modelo;
    Database d;
    ResultSet rs;
    String idEdit;//Id que se selecciona para editar
    int bandEdit;//bandera que se activa cuando se presiona el boton de editar      
    /**
     * Creates new form departments
     */
    public job_history() throws SQLException {
        initComponents();
        cargarDatos();
    }
public void cargarDatos() throws SQLException{
            modelo= new DefaultTableModel();        
            //modelo.addColumn("Número Adquisición");
            modelo.addColumn("EMPLOYEE_ID");
            modelo.addColumn("START_DATE");
            modelo.addColumn("END_DATE"); 
            modelo.addColumn("JOB_ID"); 
            modelo.addColumn("DEPARTMENT_ID"); 
            jTable1.setModel(modelo);  
            
            String []Datos= new String[5];
            
		this.d=new Database();
		ResultSet rs;
                String consulta;
                if(EXL)
                    consulta="select * from job_history";
                else 
                    consulta="select * from job_history @LINK_A";
		System.out.println("Conectando con la base de datos:");
		if(d.conectar()){
			rs=d.ejecutarConsulta(consulta);
                        while(rs.next()) {
				for(int i=1; i<=5; i++) {
					Datos[i-1]=rs.getString(i);
				}
                                modelo.addRow(Datos);
                        }
                }
		else
			System.out.println("No se pudo conectar. Revisa los datos introducidos.");
		if(d.desconectar())
			System.out.println("Desconectado tras jecutar la consulta.");
		else
			System.out.println("Por alguna razón no se ha podido desconectar.");            
}
public void cargarDatos(String categoria, String parametro) throws SQLException{
            modelo= new DefaultTableModel();        
            //modelo.addColumn("Número Adquisición");
            modelo.addColumn("EMPLOYEE_ID");
            modelo.addColumn("START_DATE");
            modelo.addColumn("END_DATE"); 
            modelo.addColumn("JOB_ID"); 
            modelo.addColumn("DEPARTMENT_ID"); 
            jTable1.setModel(modelo);  
            
            String []Datos= new String[5];            		                
		System.out.println("Conectando con la base de datos:");
                
                String consulta;
                if(EXL)
                    consulta="select * from job_history where "+categoria+" LIKE '%"+parametro+"%'";
                else
                    consulta="select * from job_history@LINK_A where "+categoria+" LIKE '%"+parametro+"%'";

                System.out.println(consulta);
		if(d.conectar()){
			this.rs=d.ejecutarConsulta(consulta);
                        while(rs.next()) {
				for(int i=1; i<=5; i++) {
					Datos[i-1]=rs.getString(i);
				}
                                modelo.addRow(Datos);
                        }
                }
		else
			System.out.println("No se pudo conectar. Revisa los datos introducidos.");
		if(d.desconectar())
			System.out.println("Desconectado tras jecutar la consulta.");
		else
			System.out.println("Por alguna razón no se ha podido desconectar.");            
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnVerTodo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jTextFieldParam = new javax.swing.JTextField();
        jComboBoxCat = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButtonMenu = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textId1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textDateStart = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textDateEnd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textJobId = new javax.swing.JTextField();
        btnAgregar1 = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textDepId = new javax.swing.JTextField();
        lbl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Historial Empleados");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("HISTORIAL DE EMPLEOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 900, 400));

        btnVerTodo.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        btnVerTodo.setForeground(new java.awt.Color(204, 0, 0));
        btnVerTodo.setText("VER TODOS");
        btnVerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodoActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, -1, 30));

        btnBuscar.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(204, 0, 0));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, 30));

        jTextFieldParam.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        jTextFieldParam.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(jTextFieldParam, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 150, 30));

        jComboBoxCat.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        jComboBoxCat.setForeground(new java.awt.Color(204, 0, 0));
        jComboBoxCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "EMPLOYEE_ID", "START_DATE", "END_DATE", "JOB_ID", "DEPARTMENT_ID" }));
        getContentPane().add(jComboBoxCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 180, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("BUSCAR POR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, 30));

        jButtonMenu.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        jButtonMenu.setForeground(new java.awt.Color(204, 0, 0));
        jButtonMenu.setText("Menu");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 670, 180, -1));

        jLabel6.setText("ID EMPLEADO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        getContentPane().add(textId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 70, 30));

        jLabel7.setText("FECHA INCIO");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));
        getContentPane().add(textDateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 100, 30));

        jLabel8.setText("FECHA FINAL");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));
        getContentPane().add(textDateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 70, 30));

        jLabel9.setText("ID DEL EMPLEO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, -1, -1));
        getContentPane().add(textJobId, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 70, 30));

        btnAgregar1.setText("Guardar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, -1, -1));

        btnEditar1.setText("Editar");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, -1, -1));

        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 180, -1, -1));

        jLabel3.setText("ID DEPARTAMENTO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));
        getContentPane().add(textDepId, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 100, 30));

        lbl_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultas/views/fondo1.jpg"))); // NOI18N
        getContentPane().add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodoActionPerformed
        try {
            cargarDatos();
        } catch (SQLException ex) {
            Logger.getLogger(countries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVerTodoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String categoria = (String) jComboBoxCat.getSelectedItem();
        String parametro = jTextFieldParam.getText();
        System.out.println(categoria);
        if(!categoria.equals("SELECCIONE")){
            if(!"".equals(jTextFieldParam.getText())){
                try {
                    cargarDatos(categoria, parametro);
                } catch (SQLException ex) {
                    Logger.getLogger(countries.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Por favor escribe un parametro de busqueda");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Por favor seleccione una categoria");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        main f = null;
        f = new main();
        f.setVisible (true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        if("".equals(textId1.getText())||"".equals(textDateStart.getText())||"".equals(textDateEnd.getText())||
                "".equals(textJobId.getText()))
        JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos obligatorios");
        else{
            if(bandEdit!=1){
                if(d.conectar()){
                    String id = textId1.getText();
                    String starDate= textDateStart.getText();
                    String endDate =textDateEnd.getText();
                    String jobId = textJobId.getText();
                    String depId = textDepId.getText();
                    if (d.insertarJobHistory(id, starDate, endDate, jobId, depId)){
                        try {
                            cargarDatos();
                        } catch (SQLException ex) {
                            Logger.getLogger(departments.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else{
                System.out.println("No se pudo conectar. Revisa los datos introducidos.");
                }
                if(d.desconectar())
                System.out.println("Desconectado tras jecutar la consulta.");
                else
                System.out.println("Por alguna razón no se ha podido desconectar.");
            }else{
                if(idEdit.equals(textId1.getText())){
                }else{
                    JOptionPane.showMessageDialog(null, "El campo Id no se puede modificar porque es clave primaria, se guardaran los demas valores excepto este");
                }
                if(d.conectar()){
                    String id = idEdit;
                    String starDate= textDateStart.getText();
                    String endDate =textDateEnd.getText();
                    String jobId = textJobId.getText();
                    String depId = textDepId.getText();
                    if (d.actualizarJobHistory(id, starDate, endDate)){
                        try {
                            cargarDatos();
                        } catch (SQLException ex) {
                            Logger.getLogger(countries.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else{
                System.out.println("No se pudo conectar. Revisa los datos introducidos.");
                }
                if(d.desconectar())
                    System.out.println("Desconectado tras jecutar la consulta.");
                else
                    System.out.println("Por alguna razón no se ha podido desconectar.");
                bandEdit=0;
                textId1.setEditable(true);
                textDateEnd.setEditable(true);
                textJobId.setEditable(true);
                limpiarCajas();
            }
            limpiarCajas();
        }
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        if(jTable1.getSelectedRow()!=-1){
            String idSelected=String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));
            String sDate=String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),1));
            String eDate=String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),2));
            String jId=String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),3));
            String dId=String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),4));
            bandEdit=1;
            idEdit=idSelected;
            textId1.setText(idEdit);
            textDateStart.setText(sDate);
            textDateEnd.setText(eDate);
            textJobId.setText(jId);
            textDepId.setText(dId);
            textId1.setEditable(false);
            textDateStart.setEditable(false);
            textJobId.setEditable(false);
            textDepId.setEditable(false);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar el registro que desea Editar");
        }
    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        if(jTable1.getSelectedRow()!=-1){
            String idSelected=String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "¿Eliminar el Registro con ID: "+idSelected,
                "Eliminar Regustro", dialogButton);
            if(dialogResult == 0) {
                if(d.conectar()){

                    if (!d.eliminarDeparment(idSelected)){
                        JOptionPane.showMessageDialog(null, "Por motivos de integridad referencial, no puede eliminarse\n" +
                            "esa tupla");
                    }else{
                        try {
                            cargarDatos();
                        } catch (SQLException ex) {
                            Logger.getLogger(countries.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else
                System.out.println("No se pudo conectar. Revisa los datos introducidos.");
                if(d.desconectar())
                System.out.println("Desconectado tras jecutar la consulta.");
                else
                System.out.println("Por alguna razón no se ha podido desconectar.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar el registro que desea eliminar");
        }
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(job_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(job_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(job_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(job_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new job_history().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(job_history.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
public void limpiarCajas(){
    
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnVerTodo;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JComboBox<String> jComboBoxCat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldParam;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JTextField textDateEnd;
    private javax.swing.JTextField textDateStart;
    private javax.swing.JTextField textDepId;
    private javax.swing.JTextField textId1;
    private javax.swing.JTextField textJobId;
    // End of variables declaration//GEN-END:variables
}
