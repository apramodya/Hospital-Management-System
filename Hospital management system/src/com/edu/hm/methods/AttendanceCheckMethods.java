/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.methods;

import com.edu.hm.controllers.AttendanceController;
import com.edu.hm.controllers.EmployeeController;
import com.edu.hm.controllers.LeavesController;
import com.edu.hm.dto.AttendanceDTO;
import com.edu.hm.dto.EmployeeDTO;
import com.edu.hm.dto.LeavesDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.RadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ASUS
 */
public class AttendanceCheckMethods {

   
    private static void AttendanceCorrector(String time) throws ClassNotFoundException, SQLException {
        Date date = new Date();
        char[] timeNew = {time.charAt(0), time.charAt(1), time.charAt(3), time.charAt(4), time.charAt(6), time.charAt(7)};
        String t = "";
        for (int i = 0; i < timeNew.length; i++) {
            t += timeNew[i];
        }
        ArrayList<AttendanceDTO> todayAttendance = AttendanceController.getTodayAttendance(getDateFormat(date));
        for (AttendanceDTO attendance : todayAttendance) {
            if (attendance != null && attendance.getShortLeaveOutTime() != null && attendance.getShortLeaveInTime().equals("") && Integer.parseInt(t) >= 170000) {
                System.out.println(attendance.getShortLeaveOutTime());
                AttendanceController.updateAttendance(new AttendanceDTO(attendance.getEmployeeDTO(), attendance.getDate(), attendance.getInTime(), "", "", attendance.getShortLeaveOutTime(), 0));
            }
        }
    }

    

    public static String getMonthNumber(String selectedDate) {
        char[] Date = {selectedDate.charAt(8), selectedDate.charAt(9)};
        String month = "";
        for (int i = 0; i < Date.length; i++) {
            month += Date[i];
         }
        return month;
    }

    public static String getDateFormat(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = dateFormat.format(date);
        return newDate;
    }

    public static String getYearMonth(String date) {
        char[] yearMonth = {date.charAt(0), date.charAt(1), date.charAt(2), date.charAt(3), date.charAt(5), date.charAt(6)};
        String newDate = "";
        for (int i = 0; i < yearMonth.length; i++) {
            newDate += yearMonth[i];
        }
        return newDate;
    }

    public static int getTimeHours(String time) {
        char[] timeHours = {time.charAt(0), time.charAt(1)};
        String hours = "";
        for (int i = 0; i < timeHours.length; i++) {
            hours += timeHours[i];
        }
        return Integer.parseInt(hours);
    }

    public static int getTimeMinutes(String time) {
        char[] timeMinutes = {time.charAt(3), time.charAt(4)};
        String minutes = "";
        for (int i = 0; i < timeMinutes.length; i++) {
            minutes += timeMinutes[i];
        }
        return Integer.parseInt(minutes);
    }

    public static void setTodaySummary(JTable tableTodayAttendance, JLabel labelTotalIn, JLabel labelShortLeave, JLabel labelOut) {
        try {
            int totalIn = 0, totalSLOut = 0;
            for (int i = 0; i < tableTodayAttendance.getRowCount(); i++) {
                boolean in = (boolean) tableTodayAttendance.getValueAt(i, 2);
                boolean shortLeave = (boolean) tableTodayAttendance.getValueAt(i, 3);
                if (in) {
                    totalIn += 1;
                }
                if (shortLeave) {
                    totalSLOut += 1;
                }
            }
            labelTotalIn.setText(Integer.toString(totalIn));
            labelShortLeave.setText(Integer.toString(totalSLOut));
            labelOut.setText(Integer.toString(AttendanceController.getAbsenties()));
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }

    public static void setTodayAttendance(JLabel labelDate, JTable tableTodayAttendance) {
        try {
            ArrayList<AttendanceDTO> attendanceList = AttendanceController.getTodayAttendance(labelDate.getText());
            DefaultTableModel dtm;
            dtm = (DefaultTableModel) tableTodayAttendance.getModel();
            dtm.setRowCount(0);
            for (AttendanceDTO attendance : attendanceList) {
                EmployeeDTO employee = EmployeeController.searchEmployeeDTO(attendance.getEmployeeDTO().getEid());
                boolean a = false, b = false;
                if (!"".equals(attendance.getShortLeaveOutTime()) && !"".equals(attendance.getShortLeaveInTime()) && !"".equals(attendance.getOutTime())) {
                    b = true;
                } else if (!"".equals(attendance.getShortLeaveOutTime()) && attendance.getShortLeaveInTime().equals("")) {
                    b = true;
                } else if (!"".equals(attendance.getOutTime())) {
                    b = true;
                } else {
                    a = true;
                }
                Object[] rawData = {employee.getEid(), (employee.getFirstName() + " " + employee.getLastName()), a, b};
                dtm.addRow(rawData);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendanceCheckMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void checkShortLeave(JLabel labelDate) {
        try {
            ArrayList<AttendanceDTO> todayAttendance = AttendanceController.getTodayAttendance(labelDate.getText());
            for (AttendanceDTO attendance : todayAttendance) {
                if (attendance.getShortLeaveOutTime() != null && attendance.getShortLeaveInTime() != null) {
                    int minutes = AttendanceController.getMinutes(labelDate.getText(), attendance.getShortLeaveOutTime(), attendance.getShortLeaveInTime());
                    if (minutes > 90) {
                        LeavesController.addLeave(new LeavesDTO(attendance.getEmployeeDTO(), labelDate.getText(), 1, "Half Day"));
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }

    public static void setHalfDay(JTextField textEmployeeId, JLabel labelDate) {
        try {
            LeavesController.addLeave(new LeavesDTO(EmployeeController.searchEmployeeDTO(textEmployeeId.getText()), labelDate.getText(), 1, "Half Day"));
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }

    public static void setBtnSave(JButton buttonSave, JTextField textFirstName, JTextField textSecondName, JTextField textNic, JTextField date, JTextField textAddress, ButtonGroup gender, JTextField textMobileNum, JTextField txtLandNum, JTextField textEmail, JTextField textJoiningDate, JTextField textBasicSalary, JTextField textAccNum, ButtonGroup transport) {

    }

    public static int writeBackup(String path) throws IOException, InterruptedException {
        Runtime runTime = Runtime.getRuntime();
        Process runtimeProcess = runTime.exec("mysqldump payrollSystem -h localhost -u root -pnu -r  " + path);
        int res = runtimeProcess.waitFor();
        return res;
    }

    public static int restoreBackup(String path) throws IOException, InterruptedException {
        String[] executeCmd = new String[]{"mysql", "payrollSystem", "--user=root", "--password=nu", "-e", " source " + path};
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int res = runtimeProcess.waitFor();
        return res;
    }

}
