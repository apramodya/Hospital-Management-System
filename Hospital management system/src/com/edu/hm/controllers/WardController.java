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
import com.edu.hm.dto.WardDTO;

/**
 *
 * @author Jinadi
 */
public class WardController {

    public static WardDTO searchTest(String wid) throws SQLException, ClassNotFoundException {
        String sql = "select * from ward where WID='" + wid + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        WardDTO dTO = null;
        if (rst.next()) {
            dTO = new WardDTO(rst.getString(1), rst.getString(2), rst.getString(3));
            return dTO;
        } else {
            return null;
        }
    }

    public static boolean addWard(WardDTO dTO) throws SQLException, ClassNotFoundException {
        String sql = "insert into ward values(?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, dTO.getWid());
        ps.setObject(2, dTO.getType());
        ps.setObject(3, dTO.getDescription());
        return ps.executeUpdate() > 0;
    }

    public static ArrayList<WardDTO> getWardDTOs() throws SQLException, ClassNotFoundException {
        String sql = "select * from ward";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<WardDTO> dTOs = new ArrayList();
        while (rst.next()) {
            WardDTO dTO = new WardDTO(rst.getString(1), rst.getString(2), rst.getString(3));
            dTOs.add(dTO);
        }
        return dTOs;

    }
}
