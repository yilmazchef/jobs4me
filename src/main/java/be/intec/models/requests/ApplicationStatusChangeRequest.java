package be.intec.models.requests;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ApplicationStatusChangeRequest implements Serializable, Comparable<ApplicationStatusChangeRequest> {

  private Integer id;
  private Timestamp dateChanged;
  private Integer applicationStatusId;
  private Integer applicationId;

      public ApplicationStatusChangeRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public ApplicationStatusChangeRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public ApplicationStatusChangeRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public ApplicationStatusChangeRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public ApplicationStatusChangeRequest withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public Timestamp getDateChanged() {
    return dateChanged;
  }

  public void setDateChanged(Timestamp dateChanged) {
    this.dateChanged = dateChanged;
  }

  public void parseAndSetDateChanged(String dateChanged) {
    this.dateChanged = java.sql.Timestamp.valueOf(dateChanged);
  }

  public ApplicationStatusChangeRequest withDateChanged(Timestamp dateChanged) {
    this.setDateChanged(dateChanged);
    return this;
  }

  public ApplicationStatusChangeRequest withParsedDateChanged(String dateChanged) {
    this.parseAndSetDateChanged(dateChanged);
    return this;
  }

  public ApplicationStatusChangeRequest withoutDateChanged( Timestamp dateChanged) {
    this.setDateChanged(null);
    return this;
  }

  public ApplicationStatusChangeRequest withoutParsedDateChanged(String dateChanged) {
    this.setDateChanged(null);
    return this;
  }


  public Integer getApplicationStatusId() {
    return applicationStatusId;
  }

  public void setApplicationStatusId(Integer applicationStatusId) {
    this.applicationStatusId = applicationStatusId;
  }

  public void parseAndSetApplicationStatusId(String applicationStatusId) {
    this.applicationStatusId = Integer.parseInt(applicationStatusId);
  }

  public ApplicationStatusChangeRequest withApplicationStatusId(Integer applicationStatusId) {
    this.setApplicationStatusId(applicationStatusId);
    return this;
  }

  public ApplicationStatusChangeRequest withParsedApplicationStatusId(String applicationStatusId) {
    this.parseAndSetApplicationStatusId(applicationStatusId);
    return this;
  }

  public ApplicationStatusChangeRequest withoutApplicationStatusId( Integer applicationStatusId) {
    this.setApplicationStatusId(null);
    return this;
  }

  public ApplicationStatusChangeRequest withoutParsedApplicationStatusId(String applicationStatusId) {
    this.setApplicationStatusId(null);
    return this;
  }


  public Integer getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(Integer applicationId) {
    this.applicationId = applicationId;
  }

  public void parseAndSetApplicationId(String applicationId) {
    this.applicationId = Integer.parseInt(applicationId);
  }

  public ApplicationStatusChangeRequest withApplicationId(Integer applicationId) {
    this.setApplicationId(applicationId);
    return this;
  }

  public ApplicationStatusChangeRequest withParsedApplicationId(String applicationId) {
    this.parseAndSetApplicationId(applicationId);
    return this;
  }

  public ApplicationStatusChangeRequest withoutApplicationId( Integer applicationId) {
    this.setApplicationId(null);
    return this;
  }

  public ApplicationStatusChangeRequest withoutParsedApplicationId(String applicationId) {
    this.setApplicationId(null);
    return this;
  }


    @Override
    public int compareTo(ApplicationStatusChangeRequest otherApplicationStatusChange) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicationStatusChangeRequest)) return false;
        ApplicationStatusChangeRequest otherApplicationStatusChange = (ApplicationStatusChangeRequest) obj;
        return 
        this.getId().equals(otherApplicationStatusChange.getId()) 
 &&         this.getDateChanged().equals(otherApplicationStatusChange.getDateChanged()) 
 &&         this.getApplicationStatusId().equals(otherApplicationStatusChange.getApplicationStatusId()) 
 &&         this.getApplicationId().equals(otherApplicationStatusChange.getApplicationId()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getDateChanged()
,         this.getApplicationStatusId()
,         this.getApplicationId()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "id:" + this.getId()  + ", " + 
        "dateChanged:" + this.getDateChanged()  + ", " + 
        "applicationStatusId:" + this.getApplicationStatusId()  + ", " + 
        "applicationId:" + this.getApplicationId()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getDateChanged() == null && 
this.getApplicationStatusId() == null && 
this.getApplicationId() == null );    }

}
