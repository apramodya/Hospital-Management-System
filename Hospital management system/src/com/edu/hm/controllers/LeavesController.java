/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.controllers;

import com.edu.hm.dbconnection.DBConnection;
import com.edu.hm.dto.LeavesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 * @author Jinadi
 */
public class LeavesController {

    public static boolean addLeave(LeavesDTO leave) throws ClassNotFoundException, SQLException {
        String sql = "Insert into leaves values(?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, leave.getEmployeeDTO().getEid());
        stm.setObject(2, leave.getLeaveDate());
        stm.setObject(3, leave.getNoOfDays());
        stm.setObject(4, leave.getLeaveType());
        int res = stm.executeUpdate();
        return res>0;
    }

    public static int getLeaveCount(String employeeId, String leaveType) throws ClassNotFoundException, SQLException {
        String sql ="Select SUM(noOfDays) as leaveCount from leaves where EID='"+employeeId+"' && YEAR(leaveDate)=YEAR(curdate()) && leaveType='"+leaveType+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return rst.getInt("leaveCount");
        }else{
            return 0;
        }
    }
    
    public static ArrayList<LeavesDTO> getAllEmployeeLeaves(String employeeId) throws ClassNotFoundException, SQLException{
        String sql="Select * from leaves where EID='"+employeeId+"' && YEAR(leaveDate)=YEAR(curdate())";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<LeavesDTO> leaveList=new ArrayList<>();
        while(rst.next()){
            leaveList.add(new LeavesDTO(EmployeeController.searchEmployeeDTO(rst.getString(1)),rst.getString("leaveDate"),rst.getInt("noOfDays"),rst.getString("leaveType")));
        }
        return leaveList;
    }
    
    public static int getMonthlyLeaveCount(String employeeId,String leaveType) throws ClassNotFoundException, SQLException{
        String sql="Select SUM(noOfDays) as leaveCount from leaves where EID='"+employeeId+"' && MONTH(Date)=MONTH(curdate()) && leaveType='"+leaveType+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return rst.getInt("leaveCount");
        }else{
            return 0;
        }
    }
    
    public static int getMonthlyAllLeaveCount(String employeeId) throws ClassNotFoundException, SQLException{
        String sql="Select SUM(noOfDays) as leaveCount from leaves where EID='"+employeeId+"' && MONTH(leaveDate)=MONTH(curdate())";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return rst.getInt("leaveCount");
        }else{
            return 0;
        }
    }
        

}
