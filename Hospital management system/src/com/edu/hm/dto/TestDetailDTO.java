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
public class TestDetailDTO {

    private String tdid;
    private TestDTO tdto;
    private PatientDTO patientDTO;
    private String result;
    private double price;

    public TestDetailDTO(String tdid, TestDTO tdto, PatientDTO patientDTO, String result, double price) {
        this.tdid = tdid;
        this.tdto = tdto;
        this.patientDTO = patientDTO;
        this.result = result;
        this.price = price;
    }

    /**
     * @return the tdid
     */
    public String getTdid() {
        return tdid;
    }

    /**
     * @param tdid the tdid to set
     */
    public void setTdid(String tdid) {
        this.tdid = tdid;
    }

    /**
     * @return the tdto
     */
    public TestDTO getTdto() {
        return tdto;
    }

    /**
     * @param tdto the tdto to set
     */
    public void setTdto(TestDTO tdto) {
        this.tdto = tdto;
    }

    /**
     * @return the patientDTO
     */
    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    /**
     * @param patientDTO the patientDTO to set
     */
    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
}
