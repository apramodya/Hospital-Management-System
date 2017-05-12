/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.dto;

/**
 * 
 * @author Jinadi
 */
public class AttendanceDTO {

    private EmployeeDTO employeeDTO;
    private String date;
    private String inTime;
    private String outTime;
    private String shortLeaveOutTime;
    private String shortLeaveInTime;
    private int otHours;

    public AttendanceDTO() {
    }

    public AttendanceDTO(EmployeeDTO employeeDTO, String date, String inTime, String shortLeaveOutTime, String shortLeaveInTime, String outTime, int otHours) {
        this.employeeDTO=employeeDTO;
        this.date = date;
        this.inTime = inTime;
        this.shortLeaveOutTime = shortLeaveOutTime;
        this.shortLeaveInTime = shortLeaveInTime;
        this.outTime = outTime;
        this.otHours = otHours;
    }

   

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the inTime
     */
    public String getInTime() {
        return inTime;
    }

    /**
     * @param inTime the inTime to set
     */
    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    /**
     * @return the outTime
     */
    public String getOutTime() {
        return outTime;
    }

    /**
     * @param outTime the outTime to set
     */
    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    /**
     * @return the shortLeaveOutTime
     */
    public String getShortLeaveOutTime() {
        return shortLeaveOutTime;
    }

    /**
     * @param shortLeaveOutTime the shortLeaveOutTime to set
     */
    public void setShortLeaveOutTime(String shortLeaveOutTime) {
        this.shortLeaveOutTime = shortLeaveOutTime;
    }

    /**
     * @return the shortLeaveInTime
     */
    public String getShortLeaveInTime() {
        return shortLeaveInTime;
    }

    /**
     * @param shortLeaveInTime the shortLeaveInTime to set
     */
    public void setShortLeaveInTime(String shortLeaveInTime) {
        this.shortLeaveInTime = shortLeaveInTime;
    }

    /**
     * @return the otHours
     */
    public int getOtHours() {
        return otHours;
    }

    /**
     * @param otHours the otHours to set
     */
    public void setOtHours(int otHours) {
        this.otHours = otHours;
    }

    /**
     * @return the employeeDTO
     */
    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    /**
     * @param employeeDTO the employeeDTO to set
     */
    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

}
