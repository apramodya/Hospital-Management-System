/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.gui;

import com.edu.hm.controllers.TestController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.edu.hm.controllers.WardController;
import com.edu.hm.dto.TestDTO;
import com.edu.hm.dto.WardDTO;

/**
 *
 * @author Jinadi
 */
public class NewTestForm extends javax.swing.JPanel {

    /**
     * Creates new form WardForm
     */
    public NewTestForm() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtWardType = new javax.swing.JTextField();
        txtWid = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1040, 590));
        setPreferredSize(new java.awt.Dimension(1040, 590));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("   add new test");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 320, 100));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel2.setText("name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 155, 58));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel3.setText("test number");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 155, 49));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel5.setText("price");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 155, 58));

        txtWardType.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jPanel1.add(txtWardType, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 330, 58));

        txtWid.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jPanel1.add(txtWid, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 330, 57));

        txtDesc.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jPanel1.add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 340, 58));

        jButton2.setBackground(new java.awt.Color(0, 204, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("add ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 190, 60));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("cancel");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 190, 60));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 870, 480));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       addTest();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtWardType;
    private javax.swing.JTextField txtWid;
    // End of variables declaration//GEN-END:variables

    
    private void addTest() {
        try {
            String tid=txtWid.getText();
            String discri=txtDesc.getText();
            double price=Double.parseDouble(txtWardType.getText());
            TestDTO dTO=new TestDTO(tid, discri, price);
            boolean add=TestController.addTest(dTO);
        } catch (SQLException ex) {
            Logger.getLogger(NewTestForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewTestForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}