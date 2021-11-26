package be.intec.models.responses;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ProcessRequest implements Serializable, Comparable<ProcessRequest> {

  private Integer id;
  private String code;
  private String description;
  private Integer recruiterId;

      public ProcessRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public ProcessRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public ProcessRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public ProcessRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public ProcessRequest withoutParsedId(String id) {
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

  public ProcessRequest withCode(String code) {
    this.setCode(code);
    return this;
  }

  public ProcessRequest withParsedCode(String code) {
    this.parseAndSetCode(code);
    return this;
  }

  public ProcessRequest withoutCode( String code) {
    this.setCode(null);
    return this;
  }

  public ProcessRequest withoutParsedCode(String code) {
    this.setCode(null);
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

  public ProcessRequest withDescription(String description) {
    this.setDescription(description);
    return this;
  }

  public ProcessRequest withParsedDescription(String description) {
    this.parseAndSetDescription(description);
    return this;
  }

  public ProcessRequest withoutDescription( String description) {
    this.setDescription(null);
    return this;
  }

  public ProcessRequest withoutParsedDescription(String description) {
    this.setDescription(null);
    return this;
  }


  public Integer getRecruiterId() {
    return recruiterId;
  }

  public void setRecruiterId(Integer recruiterId) {
    this.recruiterId = recruiterId;
  }

  public void parseAndSetRecruiterId(String recruiterId) {
    this.recruiterId = Integer.parseInt(recruiterId);
  }

  public ProcessRequest withRecruiterId(Integer recruiterId) {
    this.setRecruiterId(recruiterId);
    return this;
  }

  public ProcessRequest withParsedRecruiterId(String recruiterId) {
    this.parseAndSetRecruiterId(recruiterId);
    return this;
  }

  public ProcessRequest withoutRecruiterId( Integer recruiterId) {
    this.setRecruiterId(null);
    return this;
  }

  public ProcessRequest withoutParsedRecruiterId(String recruiterId) {
    this.setRecruiterId(null);
    return this;
  }


    @Override
    public int compareTo(ProcessRequest otherProcess) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ProcessRequest)) return false;
        ProcessRequest otherProcess = (ProcessRequest) obj;
        return 
        this.getId().equals(otherProcess.getId()) 
 &&         this.getCode().equals(otherProcess.getCode()) 
 &&         this.getDescription().equals(otherProcess.getDescription()) 
 &&         this.getRecruiterId().equals(otherProcess.getRecruiterId()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getCode()
,         this.getDescription()
,         this.getRecruiterId()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "id:" + this.getId()  + ", " + 
        "code:" + this.getCode()  + ", " + 
        "description:" + this.getDescription()  + ", " + 
        "recruiterId:" + this.getRecruiterId()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getCode() == null && 
this.getDescription() == null && 
this.getRecruiterId() == null );    }

}
