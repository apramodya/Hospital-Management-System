/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.controllers;

import com.edu.hm.dbconnection.DBConnection;
import com.edu.hm.dto.AttendanceDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author ASUS
 */
public class AttendanceController{
    public static void markAttendanceIn(AttendanceDTO attendance) throws ClassNotFoundException, SQLException{
        String sql="Insert into attendance values('"+attendance.getEmployeeDTO().getEid()+"','"+attendance.getDate()+"','"+attendance.getInTime()+"','"+attendance.getShortLeaveOutTime()+"','"+attendance.getShortLeaveInTime()+"','"+attendance.getOutTime()+"','0')";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        stm.executeUpdate(sql);
    }
    
    public static void updateAttendance(AttendanceDTO attendance) throws ClassNotFoundException, SQLException{
        String sql="Update attendance set outTime='"+attendance.getOutTime()+"',shortLeaveOutTime='"+attendance.getShortLeaveOutTime()+"',shortLeaveInTime='"+attendance.getShortLeaveInTime()+"',otHours='"+attendance.getOtHours()+"' where employeeId='"+attendance.getEmployeeDTO().getEid()+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        stm.executeUpdate(sql);
    }
    
    public static AttendanceDTO getEmployeeAttendance(String employeeId,String date) throws ClassNotFoundException, SQLException{
        String sql="Select * from attendance where date='"+date+"' && employeeId='"+employeeId+"'";        
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        AttendanceDTO attendance=null;
        while(rst.next()){
            attendance=new AttendanceDTO(EmployeeController.searchEmployeeDTO(rst.getString(1)) ,rst.getString("Date"),rst.getString("inTime"),rst.getString("shortLeaveOutTime"),rst.getString("shortLeaveInTime"),rst.getString("outTime"),rst.getInt("otHours"));            
            
        }
        
        return attendance;
        
    }
    
    public static ArrayList<AttendanceDTO> getYearAttendance(int year) throws ClassNotFoundException, SQLException{
        String sql="Select * from attendance where year(date)='"+year+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<AttendanceDTO> attendanceList=new ArrayList<>();
        while(rst.next()){
          AttendanceDTO  attendance=new AttendanceDTO(EmployeeController.searchEmployeeDTO(rst.getString(1)) ,rst.getString("Date"),rst.getString("inTime"),rst.getString("shortLeaveOutTime"),rst.getString("shortLeaveInTime"),rst.getString("outTime"),rst.getInt("otHours"));            
            attendanceList.add(attendance);
        }
        return attendanceList;
    }
    
    public static ArrayList<AttendanceDTO> getMonthAttendance(int month) throws ClassNotFoundException, SQLException{
        String sql="Select * from attendance where month(date)='"+month+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<AttendanceDTO> attendanceList=new ArrayList<>();
        while(rst.next()){
          AttendanceDTO  attendance=new AttendanceDTO(EmployeeController.searchEmployeeDTO(rst.getString(1)) ,rst.getString("Date"),rst.getString("inTime"),rst.getString("shortLeaveOutTime"),rst.getString("shortLeaveInTime"),rst.getString("outTime"),rst.getInt("otHours"));            
            attendanceList.add(attendance);
        }
        return attendanceList;
    }
    
    public static ArrayList<AttendanceDTO> getSelectedDayAttendance(String date) throws ClassNotFoundException, SQLException{
        String sql="Select * from attendance where date='"+date+"'";       
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<AttendanceDTO> attendanceList=new ArrayList<>();
        while(rst.next()){
          AttendanceDTO  attendance=new AttendanceDTO(EmployeeController.searchEmployeeDTO(rst.getString(1)) ,rst.getString("Date"),rst.getString("inTime"),rst.getString("shortLeaveOutTime"),rst.getString("shortLeaveInTime"),rst.getString("outTime"),rst.getInt("otHours"));            
            attendanceList.add(attendance);
        }
        return attendanceList;
    }
    
    public static ArrayList<AttendanceDTO> getTodayAttendance(String date) throws ClassNotFoundException, SQLException{
        String sql="Select * from attendance where date=curdate()";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<AttendanceDTO> attendanceList=new ArrayList<>();
        while(rst.next()){
          AttendanceDTO  attendance=new AttendanceDTO(EmployeeController.searchEmployeeDTO(rst.getString(1)) ,rst.getString("Date"),rst.getString("inTime"),rst.getString("shortLeaveOutTime"),rst.getString("shortLeaveInTime"),rst.getString("outTime"),rst.getInt("otHours"));            
            attendanceList.add(attendance);
        }
        return attendanceList;
    }
    
    public static int getMinutes(String Date, String shortLeaveOutTime, String shortLeaveInTime) throws ClassNotFoundException, SQLException{
        String sql="Select TIMESTAMPDIFF(MINUTE,'"+Date+" "+shortLeaveOutTime+"','"+Date+" "+shortLeaveInTime+"') as minutes";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return rst.getInt("minutes");
        }else{
            return 0;
        }
    }
    
    public static int getAbsenties() throws ClassNotFoundException, SQLException{
        String sql="Select (COUNT(employeeId) - (Select COUNT(employeeId) from Attendance where date=curdate())) as absenties from Employee";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return rst.getInt("absenties");
        }else{
            return 0;
        }
    }
    
    public static int getNormalOt(String employeeId) throws ClassNotFoundException, SQLException{
        String sql="Select SUM(otHours) as totalNormalOt from Attendance where MONTH(date)=MONTH(curdate()) && employeeId='"+employeeId+"' && (DAYNAME(date)!='Saturday' || DAYNAME(date)!='Sunday')";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return rst.getInt("totalNormalOt");
        }else{
            return 0;
        }
    }
    
    public static int getWeekendOt(String employeeId) throws ClassNotFoundException, SQLException{
        String sql="Select SUM(otHours) as totalWeekendOt from Attendance where MONTH(date)=MONTH(curdate()) && employeeId='"+employeeId+"' && (DAYNAME(date)='Saturday' || DAYNAME(Date)='Sunday')";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return rst.getInt("totalWeekendOt");
        }else{
            return 0;
        }
    }
    
    public static int getShortLeaveCount(String employeeId) throws ClassNotFoundException, SQLException{
        String sql="Select COUNT(shortLeaveInTime) as shortLeaveCount from Attendance where employeeId='"+employeeId+"' && MONTH(date)=MONTH(curdate())";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return rst.getInt("shortLeaveCount");
        }else{
            return 0;
        }
    }
    
   
}

        