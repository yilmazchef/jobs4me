package be.intec.models.requests;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ApplicationStatusRequest implements Serializable, Comparable<ApplicationStatusRequest> {

  private Integer id;
  private String status;

      public ApplicationStatusRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public ApplicationStatusRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public ApplicationStatusRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public ApplicationStatusRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public ApplicationStatusRequest withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void parseAndSetStatus(String status) {
    this.status = status;
  }

  public ApplicationStatusRequest withStatus(String status) {
    this.setStatus(status);
    return this;
  }

  public ApplicationStatusRequest withParsedStatus(String status) {
    this.parseAndSetStatus(status);
    return this;
  }

  public ApplicationStatusRequest withoutStatus( String status) {
    this.setStatus(null);
    return this;
  }

  public ApplicationStatusRequest withoutParsedStatus(String status) {
    this.setStatus(null);
    return this;
  }


    @Override
    public int compareTo(ApplicationStatusRequest otherApplicationStatus) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicationStatusRequest)) return false;
        ApplicationStatusRequest otherApplicationStatus = (ApplicationStatusRequest) obj;
        return 
        this.getId().equals(otherApplicationStatus.getId()) 
 &&         this.getStatus().equals(otherApplicationStatus.getStatus()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getStatus()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "id:" + this.getId()  + ", " + 
        "status:" + this.getStatus()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getStatus() == null );    }

}
