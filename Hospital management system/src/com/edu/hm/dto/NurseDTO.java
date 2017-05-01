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
public class NurseDTO {

    private String nid;
    private EmployeeDTO employeeDTO;
    private WardDTO wardDTO;

    public NurseDTO(String nid, EmployeeDTO employeeDTO, WardDTO wardDTO) {
        this.nid = nid;
        this.employeeDTO = employeeDTO;
        this.wardDTO = wardDTO;
    }

    /**
     * @return the nid
     */
    public String getNid() {
        return nid;
    }

    /**
     * @param nid the nid to set
     */
    public void setNid(String nid) {
        this.nid = nid;
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

}
