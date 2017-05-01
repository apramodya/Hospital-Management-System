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
import com.edu.hm.dto.TestDTO;

/**
 *
 * @author Jinadi
 */
public class TestController {

    /**
     *
     * @param dTO
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public static boolean addTest(TestDTO dTO) throws SQLException, ClassNotFoundException {
        String sql = "insert into test values(?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, dTO.getTid());
        ps.setObject(2, dTO.getDescription());
        ps.setObject(3, dTO.getPrice());
        return ps.executeUpdate() > 0;
    }

    /**
     *
     * @param tid
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static TestDTO searchTest(String tid) throws SQLException, ClassNotFoundException {
        String sql = "select * from test where TID='" + tid + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        TestDTO dTO = null;
        if (rst.next()) {
            dTO = new TestDTO(rst.getString(1), rst.getString(2), rst.getDouble(3));
            return dTO;
        } else {
            return null;
        }
    }

    /**
     *
     * @return @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ArrayList<TestDTO> getTestDTOs() throws SQLException, ClassNotFoundException {
        String sql = "select * from test";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<TestDTO> dTOs = new ArrayList();
        while (rst.next()) {
            TestDTO dTO = new TestDTO(rst.getString(1), rst.getString(2), rst.getDouble(3));
            dTOs.add(dTO);
        }
        return dTOs;

    }
}
