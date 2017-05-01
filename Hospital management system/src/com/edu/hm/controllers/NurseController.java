/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.edu.hm.dbconnection.DBConnection;
import com.edu.hm.dto.ConsultantDTO;
import com.edu.hm.dto.NurseDTO;

/**
 *
 * @author Jinadi
 */
public class NurseController {

    public static boolean addNurse(NurseDTO dTO) throws SQLException, ClassNotFoundException {
        String sql = "insert into nurse values(?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, dTO.getNid());
        ps.setObject(2, dTO.getEmployeeDTO().getEid());
        ps.setObject(3, dTO.getWardDTO().getWid());
        return ps.executeUpdate() > 0;
    }
}
