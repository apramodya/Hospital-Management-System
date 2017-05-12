/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.dto;

/**
 *
 * @author ASUS
 */
public class LeavesDTO {

    private EmployeeDTO employeeDTO;
    private String leaveDate;
    private int noOfDays;
    private String leaveType;

    public LeavesDTO() {
    }

    public LeavesDTO(EmployeeDTO employeeDTO, String leaveDate, int noOfDays, String leaveType) {
        this.employeeDTO = employeeDTO;
        this.leaveDate = leaveDate;
        this.noOfDays = noOfDays;
        this.leaveType = leaveType;
    }

    

    /**
     * @return the leaveDate
     */
    public String getLeaveDate() {
        return leaveDate;
    }

    /**
     * @param leaveDate the leaveDate to set
     */
    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    /**
     * @return the noOfDays
     */
    public int getNoOfDays() {
        return noOfDays;
    }

    /**
     * @param noOfDays the noOfDays to set
     */
    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    /**
     * @return the leaveType
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * @param leaveType the leaveType to set
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
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
