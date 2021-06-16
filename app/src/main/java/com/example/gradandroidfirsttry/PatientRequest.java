package com.example.gradandroidfirsttry;
import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.util.List;
import java.util.Date;

public class PatientRequest {
    private Boolean accepted;
    private String picture_url;
    private Integer patientAge;
    private String gender;
    private String phone;
    private String hospital;
    private String objectId;
    private String bloodType;
    private Date updated;
    private String ownerId;
    private Date created;
    private String RHType;
    private Integer quantity;
    private String name;
    private String city;
    public String getPicture_url()
    {
        return picture_url;
    }

    public PatientRequest() {
    }

    public Boolean getAccepted()
    {
        return accepted;
    }
    public void setAccepted( Boolean accepted )
    {
        this.accepted = accepted;
    }
    public void setPicture_url(String picture_url )
    {
        this.picture_url = picture_url;
    }

    public Integer getPatientAge()
    {
        return patientAge;
    }

    public void setPatientAge( Integer patientAge )
    {
        this.patientAge = patientAge;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender( String gender )
    {
        this.gender = gender;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public String getHospital()
    {
        return hospital;
    }

    public void setHospital( String hospital )
    {
        this.hospital = hospital;
    }

    public String getObjectId()
    {
        return objectId;
    }

    public String getBloodType()
    {
        return bloodType;
    }

    public void setBloodType( String bloodType )
    {
        this.bloodType = bloodType;
    }

    public Date getUpdated()
    {
        return updated;
    }

    public String getOwnerId()
    {
        return ownerId;
    }

    public Date getCreated()
    {
        return created;
    }

    public String getRHType()
    {
        return RHType;
    }

    public void setRHType( String RHType )
    {
        this.RHType = RHType;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity( Integer quantity )
    {
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }


    public PatientRequest save()
    {
        return Backendless.Data.of( PatientRequest.class ).save( this );
    }

    public void saveAsync( AsyncCallback<PatientRequest> callback )
    {
        Backendless.Data.of( PatientRequest.class ).save( this, callback );
    }

    public Long remove()
    {
        return Backendless.Data.of( PatientRequest.class ).remove( this );
    }

    public void removeAsync( AsyncCallback<Long> callback )
    {
        Backendless.Data.of( PatientRequest.class ).remove( this, callback );
    }

    public static PatientRequest findById( String id )
    {
        return Backendless.Data.of( PatientRequest.class ).findById( id );
    }

    public static void findByIdAsync( String id, AsyncCallback<PatientRequest> callback )
    {
        Backendless.Data.of( PatientRequest.class ).findById( id, callback );
    }

    public static PatientRequest findFirst()
    {
        return Backendless.Data.of( PatientRequest.class ).findFirst();
    }

    public static void findFirstAsync( AsyncCallback<PatientRequest> callback )
    {
        Backendless.Data.of( PatientRequest.class ).findFirst( callback );
    }

    public static PatientRequest findLast()
    {
        return Backendless.Data.of( PatientRequest.class ).findLast();
    }

    public static void findLastAsync( AsyncCallback<PatientRequest> callback )
    {
        Backendless.Data.of( PatientRequest.class ).findLast( callback );
    }

    public static List<PatientRequest> find( DataQueryBuilder queryBuilder )
    {
        return Backendless.Data.of( PatientRequest.class ).find( queryBuilder );
    }

    public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<PatientRequest>> callback )
    {
        Backendless.Data.of( PatientRequest.class ).find( queryBuilder, callback );
    }
}
