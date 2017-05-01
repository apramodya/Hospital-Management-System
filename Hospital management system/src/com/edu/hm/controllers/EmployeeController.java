/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.controllers;

import com.sun.deploy.uitoolkit.impl.fx.ui.FXUIFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.edu.hm.dbconnection.DBConnection;
import com.edu.hm.dto.ConsultantDTO;
import com.edu.hm.dto.DoctorDTO;
import com.edu.hm.dto.EmployeeDTO;
import com.edu.hm.dto.JanitorDTO;
import com.edu.hm.dto.NurseDTO;

/**
 *
 * @author Jinadi
 */
public class EmployeeController {

    public static boolean addEmployeeDTO(EmployeeDTO s) throws SQLException, ClassNotFoundException {
        String sql = "insert into employee values(?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, s.getEid());
        stm.setObject(2, s.getFirstName());
        stm.setObject(3, s.getMiddleName());
        stm.setObject(4, s.getLastName());
        stm.setObject(5, s.getAddress());
        stm.setObject(6, s.getTel());
        stm.setObject(7, s.getDob());
        stm.setObject(8, s.getStartDate());
        return stm.executeUpdate() > 0;
    }

    public static EmployeeDTO searchEmployeeDTO(String eid) throws SQLException, ClassNotFoundException {
        String sql = "select * from employee where eid='" + eid + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        EmployeeDTO employeeDTO = null;
        if (rst.next()) {
            employeeDTO = new EmployeeDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getInt(6), rst.getString(7), rst.getString(8));
            return employeeDTO;
        } else {
            return null;
        }
    }

    public static boolean updateEmployeeDTO(EmployeeDTO s) throws SQLException, ClassNotFoundException {
        String sql = "Update student set firstName=?, middleName=?, lastName=?,address=?,tel=?,dob=?,startDate=?  where eid=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(8, s.getEid());
        stm.setObject(1, s.getFirstName());
        stm.setObject(2, s.getMiddleName());
        stm.setObject(3, s.getLastName());
        stm.setObject(4, s.getAddress());
        stm.setObject(5, s.getTel());
        stm.setObject(6, s.getDob());
        stm.setObject(7, s.getStartDate());
        int res = stm.executeUpdate();
        return res > 0;
    }

    public static boolean removeEmployeeDTO(String eid) throws SQLException, ClassNotFoundException {
        String sql = "Delete from employee where eid='" + eid + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(sql) > 0;
    }

    public static ArrayList<EmployeeDTO> getAllEmployeeDTO() throws SQLException, ClassNotFoundException {
        String sql = "select * from employee";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<EmployeeDTO> employeeList = new ArrayList();
        while (rst.next()) {
            EmployeeDTO employeeDTO = new EmployeeDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getInt(6), rst.getString(7), rst.getString(8));
            employeeList.add(employeeDTO);
        }
        return employeeList;

    }

    public static boolean newEmployeeDetails(EmployeeDTO employeeDTO, ConsultantDTO consultantDTO, NurseDTO nurseDTO, JanitorDTO janitorDTO, DoctorDTO doctorDTO, int index) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        conn.setAutoCommit(false);
        boolean addDetail = false;
        boolean addEmployee = false;
        try {
            addEmployee = addEmployeeDTO(employeeDTO);
            switch (index) {
                case 0:
                    addDetail = ConsultantController.addConsultant(consultantDTO);
                    break;
                case 1:
                    addDetail = DoctorController.addDoctor(doctorDTO);
                    break;
                case 2:
                    addDetail = NurseController.addNurse(nurseDTO);
                    break;
                default:
                    addDetail = JanitorController.addJanitor(janitorDTO);
                    break;
            }
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
        return addEmployee && addDetail;
    }
}
