package com.example.gradandroidfirsttry;


import java.util.Date;

public class Notification {
    private String patientName,quantity,bloodType,location;
    private Date date;

    public Notification(String patientName, String quantity, String bloodType, String location , Date date) {
        this.patientName = patientName;
        this.quantity = quantity;
        this.bloodType = bloodType;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}

