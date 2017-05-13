/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.dto;

/**
 *
 * @author apramodya
 */
public class PaymentDTO {
    private String id;
    private AdmissionDTO aid;
    private String paymentDate;
    private double total;
    private double discount;
    private double billedValue;

    public PaymentDTO(String id,AdmissionDTO aid,String paymentDate,double total,double discount,double billedValue){
        this.id = id;
        this.aid = aid;
        this.paymentDate = paymentDate;
        this.total = total;
        this.discount = discount;
        this.billedValue = billedValue;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the aid
     */
    public AdmissionDTO getAid() {
        return aid;
    }

    /**
     * @param aid the aid to set
     */
    public void setAid(AdmissionDTO aid) {
        this.aid = aid;
    }

    /**
     * @return the paymentDate
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the billedValue
     */
    public double getBilledValue() {
        return billedValue;
    }

    /**
     * @param billedValue the billedValue to set
     */
    public void setBilledValue(double billedValue) {
        this.billedValue = billedValue;
    }
    
}
