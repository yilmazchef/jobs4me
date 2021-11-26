package be.intec.models.responses;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ApplicationTestRequest implements Serializable, Comparable<ApplicationTestRequest> {

  private Integer id;
  private Integer testId;
  private Integer applicationId;
  private Timestamp startTime;
  private Timestamp endTime;

      public ApplicationTestRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public ApplicationTestRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public ApplicationTestRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public ApplicationTestRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public ApplicationTestRequest withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public Integer getTestId() {
    return testId;
  }

  public void setTestId(Integer testId) {
    this.testId = testId;
  }

  public void parseAndSetTestId(String testId) {
    this.testId = Integer.parseInt(testId);
  }

  public ApplicationTestRequest withTestId(Integer testId) {
    this.setTestId(testId);
    return this;
  }

  public ApplicationTestRequest withParsedTestId(String testId) {
    this.parseAndSetTestId(testId);
    return this;
  }

  public ApplicationTestRequest withoutTestId( Integer testId) {
    this.setTestId(null);
    return this;
  }

  public ApplicationTestRequest withoutParsedTestId(String testId) {
    this.setTestId(null);
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

  public ApplicationTestRequest withApplicationId(Integer applicationId) {
    this.setApplicationId(applicationId);
    return this;
  }

  public ApplicationTestRequest withParsedApplicationId(String applicationId) {
    this.parseAndSetApplicationId(applicationId);
    return this;
  }

  public ApplicationTestRequest withoutApplicationId( Integer applicationId) {
    this.setApplicationId(null);
    return this;
  }

  public ApplicationTestRequest withoutParsedApplicationId(String applicationId) {
    this.setApplicationId(null);
    return this;
  }


  public Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(Timestamp startTime) {
    this.startTime = startTime;
  }

  public void parseAndSetStartTime(String startTime) {
    this.startTime = java.sql.Timestamp.valueOf(startTime);
  }

  public ApplicationTestRequest withStartTime(Timestamp startTime) {
    this.setStartTime(startTime);
    return this;
  }

  public ApplicationTestRequest withParsedStartTime(String startTime) {
    this.parseAndSetStartTime(startTime);
    return this;
  }

  public ApplicationTestRequest withoutStartTime( Timestamp startTime) {
    this.setStartTime(null);
    return this;
  }

  public ApplicationTestRequest withoutParsedStartTime(String startTime) {
    this.setStartTime(null);
    return this;
  }


  public Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(Timestamp endTime) {
    this.endTime = endTime;
  }

  public void parseAndSetEndTime(String endTime) {
    this.endTime = java.sql.Timestamp.valueOf(endTime);
  }

  public ApplicationTestRequest withEndTime(Timestamp endTime) {
    this.setEndTime(endTime);
    return this;
  }

  public ApplicationTestRequest withParsedEndTime(String endTime) {
    this.parseAndSetEndTime(endTime);
    return this;
  }

  public ApplicationTestRequest withoutEndTime( Timestamp endTime) {
    this.setEndTime(null);
    return this;
  }

  public ApplicationTestRequest withoutParsedEndTime(String endTime) {
    this.setEndTime(null);
    return this;
  }


    @Override
    public int compareTo(ApplicationTestRequest otherApplicationTest) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicationTestRequest)) return false;
        ApplicationTestRequest otherApplicationTest = (ApplicationTestRequest) obj;
        return 
        this.getId().equals(otherApplicationTest.getId()) 
 &&         this.getTestId().equals(otherApplicationTest.getTestId()) 
 &&         this.getApplicationId().equals(otherApplicationTest.getApplicationId()) 
 &&         this.getStartTime().equals(otherApplicationTest.getStartTime()) 
 &&         this.getEndTime().equals(otherApplicationTest.getEndTime()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getTestId()
,         this.getApplicationId()
,         this.getStartTime()
,         this.getEndTime()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "id:" + this.getId()  + ", " + 
        "testId:" + this.getTestId()  + ", " + 
        "applicationId:" + this.getApplicationId()  + ", " + 
        "startTime:" + this.getStartTime()  + ", " + 
        "endTime:" + this.getEndTime()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getTestId() == null && 
this.getApplicationId() == null && 
this.getStartTime() == null && 
this.getEndTime() == null );    }

}
