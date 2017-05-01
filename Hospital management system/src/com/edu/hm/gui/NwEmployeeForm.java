/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.gui;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.edu.hm.controllers.EmployeeController;
import com.edu.hm.controllers.WardController;
import com.edu.hm.dto.ConsultantDTO;
import com.edu.hm.dto.DoctorDTO;
import com.edu.hm.dto.EmployeeDTO;
import com.edu.hm.dto.JanitorDTO;
import com.edu.hm.dto.NurseDTO;
import com.edu.hm.dto.WardDTO;

/**
 *
 * @author Jinadi
 */
public class NwEmployeeForm extends javax.swing.JPanel {

    /**
     * Creates new form Patience
     */
    public NwEmployeeForm() {
        initComponents();
        lblS1.setVisible(false);
        txtSpeci.setVisible(false);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        cmbDOB.setDateFormat(format);
        cmbSD.setDateFormat(format);
        loadWard();

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
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEid = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        lblS = new javax.swing.JLabel();
        cmboWard = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbSD = new org.freixas.jcalendar.JCalendarCombo();
        cmbDOB = new org.freixas.jcalendar.JCalendarCombo();
        jLabel2 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAdd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtN1 = new javax.swing.JTextField();
        txtN2 = new javax.swing.JTextField();
        txtN3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSpeci = new javax.swing.JTextField();
        lblS1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        cmboWardTy = new javax.swing.JComboBox<>();

        setBackground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(1040, 1040));
        setPreferredSize(new java.awt.Dimension(1040, 590));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setMaximumSize(new java.awt.Dimension(1040, 1040));
        jPanel1.setPreferredSize(new java.awt.Dimension(1040, 590));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel8.setText("date of birth");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 217, 70));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel10.setText("employee id");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 217, 65));

        txtEid.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel1.add(txtEid, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 190, 50));

        jButton5.setBackground(new java.awt.Color(0, 204, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("add");
        jButton5.setOpaque(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 220, 60));

        lblS.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lblS.setText("ward");
        jPanel1.add(lblS, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 160, 70));

        cmboWard.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        cmboWard.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboWardItemStateChanged(evt);
            }
        });
        jPanel1.add(cmboWard, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 290, 140, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel5.setText("start date");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 217, 70));

        cmbSD.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel1.add(cmbSD, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 270, 50));

        cmbDOB.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel1.add(cmbDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 270, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel2.setText("tel");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 217, 70));

        txtTel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });
        jPanel1.add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 250, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel7.setText("address");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 217, 65));

        txtAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel1.add(txtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 440, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("name ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 217, 52));

        txtN1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel1.add(txtN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 200, 50));

        txtN2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel1.add(txtN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 230, 50));

        txtN3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jPanel1.add(txtN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 230, 50));

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("cancel");
        jButton2.setOpaque(false);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 220, 60));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel4.setText("designation");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 217, 70));

        txtSpeci.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        txtSpeci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSpeciActionPerformed(evt);
            }
        });
        jPanel1.add(txtSpeci, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 250, 50));

        lblS1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lblS1.setText("speciality");
        jPanel1.add(lblS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 160, 70));

        jComboBox1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "consultant", "doctor", "nurse", "janitor" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, 250, 50));

        cmboWardTy.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        cmboWardTy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboWardTyItemStateChanged(evt);
            }
        });
        jPanel1.add(cmboWardTy, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 140, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    private void cmboWardItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboWardItemStateChanged
        if (jComboBox1.getSelectedIndex() == 0) {
            lblS1.setVisible(true);
            txtSpeci.setVisible(true);
        } else {
            lblS1.setVisible(false);
            txtSpeci.setVisible(false);
        }
    }//GEN-LAST:event_cmboWardItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        addEmployee();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void cmboWardTyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboWardTyItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboWardTyItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txtSpeciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSpeciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSpeciActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.freixas.jcalendar.JCalendarCombo cmbDOB;
    private org.freixas.jcalendar.JCalendarCombo cmbSD;
    private javax.swing.JComboBox<String> cmboWard;
    private javax.swing.JComboBox<String> cmboWardTy;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblS;
    private javax.swing.JLabel lblS1;
    private javax.swing.JTextField txtAdd;
    private javax.swing.JTextField txtEid;
    private javax.swing.JTextField txtN1;
    private javax.swing.JTextField txtN2;
    private javax.swing.JTextField txtN3;
    private javax.swing.JTextField txtSpeci;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables

    private void addEmployee() {
        try {
            String empID = txtEid.getText();
            String name1 = txtN1.getText();
            String name2 = txtN2.getText();
            String name3 = txtN3.getText();
            int tel = Integer.parseInt(txtTel.getText());
            String addres = txtAdd.getText();
            String dob = (String) cmbDOB.getSelectedItem();
            String startDate = (String) cmbSD.getSelectedItem();
            String wardID = (String) cmboWard.getSelectedItem();
            WardDTO wardDTO = WardController.searchTest(wardID);
            String Spec = "";
            if (jComboBox1.getSelectedIndex() == 0) {
                Spec = txtSpeci.getText();
            }
            EmployeeDTO employeeDTO = new EmployeeDTO(empID, name1, name2, name3, addres, tel, dob, startDate);
            ConsultantDTO consultantDTO = new ConsultantDTO(empID + wardID, employeeDTO, wardDTO, Spec);
            DoctorDTO doctorDTO = new DoctorDTO(empID + wardID, employeeDTO, wardDTO, Spec);
            NurseDTO nurseDTO = new NurseDTO(empID + wardID, employeeDTO, wardDTO);
            JanitorDTO janitorDTO = new JanitorDTO(empID + wardID, employeeDTO, wardDTO);
            boolean addEm = EmployeeController.newEmployeeDetails(employeeDTO, consultantDTO, nurseDTO, janitorDTO, doctorDTO, jComboBox1.getSelectedIndex());
            if (addEm) {
                JOptionPane.showMessageDialog(this, "Employee added successfully..");
            } else {
                JOptionPane.showMessageDialog(this, "Added fail");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "OOPS!");
            Logger.getLogger(NwEmployeeForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadWard() {
        try {
            ArrayList<WardDTO> arrayList = WardController.getWardDTOs();
            for (WardDTO wardDTO : arrayList) {
                cmboWardTy.addItem(wardDTO.getType());
                cmboWard.addItem(wardDTO.getWid());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NwEmployeeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}