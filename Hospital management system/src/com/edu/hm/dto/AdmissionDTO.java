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
public class AdmissionDTO {

    private String aid;
    private PatientDTO patientDTO;
    private WardDTO wardDTO;
    private String startDate;
    private String gurdianName;
    private int guardianTel;

    public AdmissionDTO(String aid, PatientDTO patientDTO, WardDTO wardDTO, String startDate, String gurdianName, int guardianTel) {
        this.aid = aid;
        this.patientDTO = patientDTO;
        this.wardDTO = wardDTO;
        this.startDate = startDate;
        this.gurdianName = gurdianName;
        this.guardianTel = guardianTel;
    }

    /**
     * @return the aid
     */
    public String getAid() {
        return aid;
    }

    /**
     * @param aid the aid to set
     */
    public void setAid(String aid) {
        this.aid = aid;
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
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the gurdianName
     */
    public String getGurdianName() {
        return gurdianName;
    }

    /**
     * @param gurdianName the gurdianName to set
     */
    public void setGurdianName(String gurdianName) {
        this.gurdianName = gurdianName;
    }

    /**
     * @return the guardianTel
     */
    public int getGuardianTel() {
        return guardianTel;
    }

    /**
     * @param guardianTel the guardianTel to set
     */
    public void setGuardianTel(int guardianTel) {
        this.guardianTel = guardianTel;
    }
    
}
