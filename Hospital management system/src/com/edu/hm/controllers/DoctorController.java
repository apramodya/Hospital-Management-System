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
import com.edu.hm.dto.DoctorDTO;

/**
 *
 * @author Jinadi
 */
public class DoctorController {
    public static boolean addDoctor(DoctorDTO dTO) throws SQLException, ClassNotFoundException {
        String sql = "insert into doctor values(?,?,?,?)";
        Connection connection = DBConnection.getDBConnection().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, dTO.getDid());
        ps.setObject(2, dTO.getEmployeeDTO().getEid());
        ps.setObject(3, dTO.getWardDTO().getWid());
        ps.setObject(4, dTO.getSpeciality());
        return ps.executeUpdate() > 0;
    }
}
