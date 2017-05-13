/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.controllers;

import com.edu.hm.dbconnection.DBConnection;
import com.edu.hm.dto.PaymentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author apramodya
 */
public class PaymentController {
    public static PaymentDTO searchPaymentDTO(String id) throws SQLException, ClassNotFoundException{
        String sql = "select * from payment where ID = '" + id + "' ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        PaymentDTO paymentDTO = null;
        if(rst.next()){
            paymentDTO = new PaymentDTO(rst.getString(1),AddmissionController.searchAddmission(rst.getString(2)),rst.getString(3),rst.getDouble(4),rst.getDouble(5),rst.getDouble(6));
            return paymentDTO;
        }else{
            return null;
        }
    }
    
    public static boolean addPaymentDTO(PaymentDTO p) throws SQLException, ClassNotFoundException{
        String sql = "insert into payment values(?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, p.getId());
        stm.setObject(2, p.getAid());
        stm.setObject(3, p.getPaymentDate());
        stm.setObject(4, p.getTotal());
        stm.setObject(5, p.getDiscount());
        stm.setObject(6, p.getBilledValue());
        return stm.executeUpdate() > 0;
    }
    
    public static ArrayList<PaymentDTO> getAllPayments() throws SQLException, ClassNotFoundException{
        String sql = "select * from paymetns";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<PaymentDTO> paymentList = new ArrayList();
        while(rst.next()){
            PaymentDTO paymentDTO = new PaymentDTO(rst.getString(1),AddmissionController.searchAddmission(rst.getString(2)),rst.getString(3),rst.getDouble(4),rst.getDouble(5),rst.getDouble(6));
            paymentList.add(paymentDTO);
        }
        return paymentList;
    }
}
