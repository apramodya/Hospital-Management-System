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
import com.edu.hm.controllers.PatientController;
import com.edu.hm.controllers.WardController;
import com.edu.hm.dbconnection.DBConnection;
import com.edu.hm.dto.AdmissionDTO;

/**
 *
 * @author Jinadi
 */
public class AddmissionController {

    public static boolean addAddmission(AdmissionDTO dTO) throws SQLException, ClassNotFoundException {
        String sql = "insert into addmission values(?,?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, dTO.getAid());
        ps.setObject(2, dTO.getPatientDTO().getPid());
        ps.setObject(3, dTO.getWardDTO().getWid());
        ps.setObject(4, dTO.getStartDate());
        ps.setObject(5, dTO.getGurdianName());
        ps.setObject(6, dTO.getGuardianTel());
        return ps.executeUpdate() > 0;
    }

    public static AdmissionDTO searchAddmission(String aid) throws SQLException, ClassNotFoundException {
        String sql = "select * from addmission where AID='" + aid + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        AdmissionDTO dTO = null;
        if (rst.next()) {

            dTO = new AdmissionDTO(rst.getString(1), PatientController.searchPatientDTO(rst.getString(2)), WardController.searchTest(rst.getString(3)), rst.getString(4), rst.getString(5), rst.getInt(6));
            return dTO;
        } else {
            return null;
        }
    }

    public static ArrayList<AdmissionDTO> getAllAddmission() throws SQLException, ClassNotFoundException {
        String sql = "select * from addmission";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<AdmissionDTO> dTOs = new ArrayList();
        while (rst.next()) {
            AdmissionDTO dTO = new AdmissionDTO(rst.getString(1), PatientController.searchPatientDTO(rst.getString(2)), WardController.searchTest(rst.getString(3)), rst.getString(4), rst.getString(5), rst.getInt(6));
            dTOs.add(dTO);
        }
        return dTOs;

    }

}
