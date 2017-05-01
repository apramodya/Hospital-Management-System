/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.edu.hm.dbconnection.DBConnection;
import com.edu.hm.dto.ConsultantDTO;

/**
 *
 * @author Jinadi
 */
public class ConsultantController {

    public static boolean addConsultant(ConsultantDTO dTO) throws SQLException, ClassNotFoundException {
        String sql = "insert into consultant values(?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, dTO.getCid());
        ps.setObject(2, dTO.getEmployeeDTO().getEid());
        ps.setObject(3, dTO.getWardDTO().getWid());
        ps.setObject(4, dTO.getSpeciality());
        return ps.executeUpdate() > 0;
    }

    public static ConsultantDTO searchConsultant(String cid) throws SQLException, ClassNotFoundException {
        String sql = "select * from consultant where CID='" + cid + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ConsultantDTO dTO = null;
        if (rst.next()) {

            dTO = new ConsultantDTO(rst.getString(1), EmployeeController.searchEmployeeDTO(rst.getString(2)), WardController.searchTest(rst.getString(3)), rst.getString(4));
            return dTO;
        } else {
            return null;
        }
    }

    public static ArrayList<ConsultantDTO> getAllCunsultant() throws SQLException, ClassNotFoundException {
        String sql = "select * from consultant";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<ConsultantDTO> consultantList = new ArrayList();
        while (rst.next()) {
            ConsultantDTO dTO = new ConsultantDTO(rst.getString(1), EmployeeController.searchEmployeeDTO(rst.getString(2)), WardController.searchTest(rst.getString(3)), rst.getString(4));
            consultantList.add(dTO);
        }
        return consultantList;

    }
}
