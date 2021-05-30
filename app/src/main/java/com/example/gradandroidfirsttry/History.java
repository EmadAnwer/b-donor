package com.example.gradandroidfirsttry;

import java.util.Date;

public class History {

    private String patientName,bloodType,status;
    private Date date;

    public History(String patientName, String bloodType, String status, Date date) {
        this.patientName = patientName;
        this.bloodType = bloodType;
        this.status = status;
        this.date = date;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

