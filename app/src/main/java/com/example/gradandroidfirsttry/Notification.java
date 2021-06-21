package com.example.gradandroidfirsttry;


import java.util.Date;

public class Notification {
    private String patientName,quantity,bloodType,rhType,location,hospital,phoneNo;
    private Date date;

    public Notification(String patientName, String quantity, String bloodType, String rhType , String location, String hospital, String phoneNo , Date date) {
        this.patientName = patientName;
        this.quantity = quantity;
        this.bloodType = bloodType;
        this.rhType = rhType;
        this.location = location;
        this.hospital = hospital;
        this.phoneNo = phoneNo;
        this.date = date;

    }


    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getRhType() {
        return rhType;
    }

    public void setRhType(String rhType) {
        this.rhType = rhType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHospital() { return hospital; }

    public void setHospital(String ho) {
        this.hospital = hospital;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}

