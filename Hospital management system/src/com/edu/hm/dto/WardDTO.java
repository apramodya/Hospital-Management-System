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
public class WardDTO {

    private String wid;
    private String type;
    private String description;

    public WardDTO(String wid, String type, String description) {
        this.wid = wid;
        this.type = type;
        this.description = description;
    }

    /**
     * @return the wid
     */
    public String getWid() {
        return wid;
    }

    /**
     * @param wid the wid to set
     */
    public void setWid(String wid) {
        this.wid = wid;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
