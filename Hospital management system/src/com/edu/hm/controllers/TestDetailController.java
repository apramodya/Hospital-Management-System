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
import com.edu.hm.dto.TestDetailDTO;
import com.edu.hm.dto.TestDetailDTO;

/**
 *
 * @author Jinadi
 */
public class TestDetailController {

    public static boolean addTest(TestDetailDTO dTO) throws SQLException, ClassNotFoundException {
        String sql = "insert into testDetail values(?,?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, dTO.getTdid());
        ps.setObject(2, dTO.getTdto().getTid());
        ps.setObject(3, dTO.getPatientDTO().getPid());
        ps.setObject(4, dTO.getResult());
        ps.setObject(5, dTO.getPrice());
        return ps.executeUpdate() > 0;
    }

 

    public static ArrayList<TestDetailDTO> getTestDetailDTOs() throws SQLException, ClassNotFoundException {
        String sql = "select * from student";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<TestDetailDTO> dTOs = new ArrayList();
        while (rst.next()) {
            TestDetailDTO dTO = new TestDetailDTO(rst.getString(1), TestController.searchTest(rst.getString(2)), PatientController.searchPatientDTO(rst.getString(3)), rst.getString(4), rst.getDouble(5));
            dTOs.add(dTO);
        }
        return dTOs;

    }
}
