
package com.example.gradandroidfirsttry;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.util.List;
import java.util.Date;

public class AcceptedRequests
{
  private Date created;
  private String objectId;
  private String donorName;
  private String PatientRHType;
  private String ownerId;
  private String PatientName;
  private String PatientPhone;
  private String donorPhone;
  private Date updated;
  private String PatientBloodType;
  private String PatientHospital;
  private String city;


  public AcceptedRequests() {
  }

  public Date getCreated()
  {
    return created;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getDonorName()
  {
    return donorName;
  }

  public void setDonorName( String donorName )
  {
    this.donorName = donorName;
  }

  public String getPatientRHType()
  {
    return PatientRHType;
  }

  public void setPatientRHType( String PatientRHType )
  {
    this.PatientRHType = PatientRHType;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getPatientName()
  {
    return PatientName;
  }

  public void setPatientName( String PatientName )
  {
    this.PatientName = PatientName;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity( String city )
  {
    this.city = city;
  }

  public String getPatientPhone()
  {
    return PatientPhone;
  }

  public void setPatientPhone( String PatientPhone )
  {
    this.PatientPhone = PatientPhone;
  }

  public String getDonorPhone()
  {
    return donorPhone;
  }

  public void setDonorPhone( String donorPhone )
  {
    this.donorPhone = donorPhone;
  }

  public Date getUpdated()
  {
    return updated;
  }

  public String getPatientBloodType()
  {
    return PatientBloodType;
  }

  public void setPatientBloodType( String PatientBloodType )
  {
    this.PatientBloodType = PatientBloodType;
  }

  public String getPatientHospital()
  {
    return PatientHospital;
  }

  public void setPatientHospital( String PatientHospital )
  {
    this.PatientHospital = PatientHospital;
  }

                                                    
  public AcceptedRequests save()
  {
    return Backendless.Data.of( AcceptedRequests.class ).save( this );
  }

  public void saveAsync( AsyncCallback<AcceptedRequests> callback )
  {
    Backendless.Data.of( AcceptedRequests.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( AcceptedRequests.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( AcceptedRequests.class ).remove( this, callback );
  }

  public static AcceptedRequests findById( String id )
  {
    return Backendless.Data.of( AcceptedRequests.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<AcceptedRequests> callback )
  {
    Backendless.Data.of( AcceptedRequests.class ).findById( id, callback );
  }

  public static AcceptedRequests findFirst()
  {
    return Backendless.Data.of( AcceptedRequests.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<AcceptedRequests> callback )
  {
    Backendless.Data.of( AcceptedRequests.class ).findFirst( callback );
  }

  public static AcceptedRequests findLast()
  {
    return Backendless.Data.of( AcceptedRequests.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<AcceptedRequests> callback )
  {
    Backendless.Data.of( AcceptedRequests.class ).findLast( callback );
  }

  public static List<AcceptedRequests> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( AcceptedRequests.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<AcceptedRequests>> callback )
  {
    Backendless.Data.of( AcceptedRequests.class ).find( queryBuilder, callback );
  }
}