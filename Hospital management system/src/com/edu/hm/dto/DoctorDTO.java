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
//doctor dto

public class DoctorDTO {

    private String did;
    private EmployeeDTO employeeDTO;
    private WardDTO wardDTO;
    private String speciality;

    public DoctorDTO(String did, EmployeeDTO employeeDTO, WardDTO wardDTO, String speciality) {
        this.did = did;
        this.employeeDTO = employeeDTO;
        this.wardDTO = wardDTO;
        this.speciality = speciality;
    }

    /**
     * @return the did
     */
    public String getDid() {
        return did;
    }

    /**
     * @param did the did to set
     */
    public void setDid(String did) {
        this.did = did;
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

    /**
     * @return the wardDTO
     */
    public WardDTO getWardDTO() {
        return wardDTO;
    }

    /**
     * @param wardDTO the wardDTO to set
     */
    public void setWardDTO(WardDTO wardDTO) {
        this.wardDTO = wardDTO;
    }

    /**
     * @return the speciality
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * @param speciality the speciality to set
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    
}
