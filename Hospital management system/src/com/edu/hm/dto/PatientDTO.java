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
public class PatientDTO {

    private String pid;
    private ConsultantDTO consultantDTO;
    private String nic;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private int tel;
    private String dob;
    private String bloodGrup;

    public PatientDTO(String pid, ConsultantDTO consultantDTO, String nic, String firstName, String middleName, String lastName, String address, int tel, String dob, String bloodGrup) {
        this.pid = pid;
        this.consultantDTO = consultantDTO;
        this.nic = nic;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.tel = tel;
        this.dob = dob;
        this.bloodGrup = bloodGrup;
    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the consultantDTO
     */
    public ConsultantDTO getConsultantDTO() {
        return consultantDTO;
    }

    /**
     * @param consultantDTO the consultantDTO to set
     */
    public void setConsultantDTO(ConsultantDTO consultantDTO) {
        this.consultantDTO = consultantDTO;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the tel
     */
    public int getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(int tel) {
        this.tel = tel;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the bloodGrup
     */
    public String getBloodGrup() {
        return bloodGrup;
    }

    /**
     * @param bloodGrup the bloodGrup to set
     */
    public void setBloodGrup(String bloodGrup) {
        this.bloodGrup = bloodGrup;
    }
}
