package be.intec.models.responses;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ApplicationEvaluationRequest implements Serializable, Comparable<ApplicationEvaluationRequest> {

  private Integer id;
  private String notes;
  private Integer recruiterId;
  private Integer applicationId;
  private String hired;

      public ApplicationEvaluationRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public ApplicationEvaluationRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public ApplicationEvaluationRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public ApplicationEvaluationRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public ApplicationEvaluationRequest withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public void parseAndSetNotes(String notes) {
    this.notes = notes;
  }

  public ApplicationEvaluationRequest withNotes(String notes) {
    this.setNotes(notes);
    return this;
  }

  public ApplicationEvaluationRequest withParsedNotes(String notes) {
    this.parseAndSetNotes(notes);
    return this;
  }

  public ApplicationEvaluationRequest withoutNotes( String notes) {
    this.setNotes(null);
    return this;
  }

  public ApplicationEvaluationRequest withoutParsedNotes(String notes) {
    this.setNotes(null);
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

  public ApplicationEvaluationRequest withRecruiterId(Integer recruiterId) {
    this.setRecruiterId(recruiterId);
    return this;
  }

  public ApplicationEvaluationRequest withParsedRecruiterId(String recruiterId) {
    this.parseAndSetRecruiterId(recruiterId);
    return this;
  }

  public ApplicationEvaluationRequest withoutRecruiterId( Integer recruiterId) {
    this.setRecruiterId(null);
    return this;
  }

  public ApplicationEvaluationRequest withoutParsedRecruiterId(String recruiterId) {
    this.setRecruiterId(null);
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

  public ApplicationEvaluationRequest withApplicationId(Integer applicationId) {
    this.setApplicationId(applicationId);
    return this;
  }

  public ApplicationEvaluationRequest withParsedApplicationId(String applicationId) {
    this.parseAndSetApplicationId(applicationId);
    return this;
  }

  public ApplicationEvaluationRequest withoutApplicationId( Integer applicationId) {
    this.setApplicationId(null);
    return this;
  }

  public ApplicationEvaluationRequest withoutParsedApplicationId(String applicationId) {
    this.setApplicationId(null);
    return this;
  }


  public String getHired() {
    return hired;
  }

  public void setHired(String hired) {
    this.hired = hired;
  }

  public void parseAndSetHired(String hired) {
    this.hired = hired;
  }

  public ApplicationEvaluationRequest withHired(String hired) {
    this.setHired(hired);
    return this;
  }

  public ApplicationEvaluationRequest withParsedHired(String hired) {
    this.parseAndSetHired(hired);
    return this;
  }

  public ApplicationEvaluationRequest withoutHired( String hired) {
    this.setHired(null);
    return this;
  }

  public ApplicationEvaluationRequest withoutParsedHired(String hired) {
    this.setHired(null);
    return this;
  }


    @Override
    public int compareTo(ApplicationEvaluationRequest otherApplicationEvaluation) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicationEvaluationRequest)) return false;
        ApplicationEvaluationRequest otherApplicationEvaluation = (ApplicationEvaluationRequest) obj;
        return 
        this.getId().equals(otherApplicationEvaluation.getId()) 
 &&         this.getNotes().equals(otherApplicationEvaluation.getNotes()) 
 &&         this.getRecruiterId().equals(otherApplicationEvaluation.getRecruiterId()) 
 &&         this.getApplicationId().equals(otherApplicationEvaluation.getApplicationId()) 
 &&         this.getHired().equals(otherApplicationEvaluation.getHired()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getNotes()
,         this.getRecruiterId()
,         this.getApplicationId()
,         this.getHired()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "id:" + this.getId()  + ", " + 
        "notes:" + this.getNotes()  + ", " + 
        "recruiterId:" + this.getRecruiterId()  + ", " + 
        "applicationId:" + this.getApplicationId()  + ", " + 
        "hired:" + this.getHired()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getNotes() == null && 
this.getRecruiterId() == null && 
this.getApplicationId() == null && 
this.getHired() == null );    }

}
