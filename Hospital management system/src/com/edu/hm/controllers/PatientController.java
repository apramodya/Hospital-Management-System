/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.controllers;

import static com.edu.hm.controllers.EmployeeController.addEmployeeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.edu.hm.dbconnection.DBConnection;
import com.edu.hm.dto.AdmissionDTO;
import com.edu.hm.dto.ConsultantDTO;
import com.edu.hm.dto.DoctorDTO;
import com.edu.hm.dto.EmployeeDTO;
import com.edu.hm.dto.JanitorDTO;
import com.edu.hm.dto.NurseDTO;
import com.edu.hm.dto.PatientDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jinadi
 */
public class PatientController {

    public static boolean addPatientDTO(PatientDTO s) throws SQLException, ClassNotFoundException {
        String sql = "insert into patient values(?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, s.getPid());
        stm.setObject(2, s.getConsultantDTO().getCid());
        stm.setObject(3, s.getNic());
        stm.setObject(4, s.getFirstName());
        stm.setObject(5, s.getMiddleName());
        stm.setObject(6, s.getLastName());
        stm.setObject(7, s.getAddress());
        stm.setObject(8, s.getTel());
        stm.setObject(9, s.getDob());
        stm.setObject(10, s.getBloodGrup());
        return stm.executeUpdate() > 0;
    }

    public static PatientDTO searchPatientDTO(String pid) throws SQLException, ClassNotFoundException {
        String sql = "select * from  patient where PID='" + pid + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        PatientDTO DTO = null;
        if (rst.next()) {
            DTO = new PatientDTO(rst.getString(1), ConsultantController.searchConsultant(rst.getString(2)), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getInt(8), rst.getString(9), rst.getString(10));
            return DTO;
        } else {
            return null;
        }
    }

    public static boolean removePatientDTO(String eid) throws SQLException, ClassNotFoundException {
        String sql = "Delete from employee where eid='" + eid + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(sql) > 0;
    }

    public static ArrayList<PatientDTO> getAllPatientDTO() throws SQLException, ClassNotFoundException {
        String sql = "select * from employee";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<PatientDTO> List = new ArrayList();
        while (rst.next()) {
            PatientDTO DTO = new PatientDTO(rst.getString(1), ConsultantController.searchConsultant(rst.getString(2)), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getInt(8), rst.getString(9), rst.getString(10));
            List.add(DTO);
        }
        return List;

    }

    public static boolean newPatienceDetails(PatientDTO patientDTO, AdmissionDTO admissionDTO) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        conn.setAutoCommit(false);
        boolean addAd = false;
        boolean addPa = false;
        try {
            addPa = addPatientDTO(patientDTO);
            addAd = AddmissionController.addAddmission(admissionDTO);
            conn.commit();

        } catch (ClassNotFoundException | SQLException SQLException) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            throw SQLException;
        } finally {
            conn.setAutoCommit(true);
        }
        return addAd && addPa;
    }
}
