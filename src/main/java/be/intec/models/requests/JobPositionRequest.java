package be.intec.models.requests;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class JobPositionRequest implements Serializable, Comparable<JobPositionRequest> {

  private Integer id;
  private String code;
  private String name;
  private String description;

      public JobPositionRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public JobPositionRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public JobPositionRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public JobPositionRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public JobPositionRequest withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void parseAndSetCode(String code) {
    this.code = code;
  }

  public JobPositionRequest withCode(String code) {
    this.setCode(code);
    return this;
  }

  public JobPositionRequest withParsedCode(String code) {
    this.parseAndSetCode(code);
    return this;
  }

  public JobPositionRequest withoutCode( String code) {
    this.setCode(null);
    return this;
  }

  public JobPositionRequest withoutParsedCode(String code) {
    this.setCode(null);
    return this;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void parseAndSetName(String name) {
    this.name = name;
  }

  public JobPositionRequest withName(String name) {
    this.setName(name);
    return this;
  }

  public JobPositionRequest withParsedName(String name) {
    this.parseAndSetName(name);
    return this;
  }

  public JobPositionRequest withoutName( String name) {
    this.setName(null);
    return this;
  }

  public JobPositionRequest withoutParsedName(String name) {
    this.setName(null);
    return this;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void parseAndSetDescription(String description) {
    this.description = description;
  }

  public JobPositionRequest withDescription(String description) {
    this.setDescription(description);
    return this;
  }

  public JobPositionRequest withParsedDescription(String description) {
    this.parseAndSetDescription(description);
    return this;
  }

  public JobPositionRequest withoutDescription( String description) {
    this.setDescription(null);
    return this;
  }

  public JobPositionRequest withoutParsedDescription(String description) {
    this.setDescription(null);
    return this;
  }


    @Override
    public int compareTo(JobPositionRequest otherJobPosition) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof JobPositionRequest)) return false;
        JobPositionRequest otherJobPosition = (JobPositionRequest) obj;
        return 
        this.getId().equals(otherJobPosition.getId()) 
 &&         this.getCode().equals(otherJobPosition.getCode()) 
 &&         this.getName().equals(otherJobPosition.getName()) 
 &&         this.getDescription().equals(otherJobPosition.getDescription()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getCode()
,         this.getName()
,         this.getDescription()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "id:" + this.getId()  + ", " + 
        "code:" + this.getCode()  + ", " + 
        "name:" + this.getName()  + ", " + 
        "description:" + this.getDescription()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getCode() == null && 
this.getName() == null && 
this.getDescription() == null );    }

}
