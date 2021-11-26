package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class ApplicationTestBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleIntegerProperty testId;
  private SimpleIntegerProperty applicationId;
  private SimpleStringProperty startTime;
  private SimpleStringProperty endTime;


  public ApplicationTestBinder ( Integer _id, Integer _testId, Integer _applicationId, Timestamp _startTime, Timestamp _endTime) { 
    this.id = new SimpleIntegerProperty(_id);
    this.testId = new SimpleIntegerProperty(_testId);
    this.applicationId = new SimpleIntegerProperty(_applicationId);
    this.startTime = new SimpleStringProperty(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(_startTime));
    this.endTime = new SimpleStringProperty(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(_endTime));
  }

  public ApplicationTestBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public ApplicationTestBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public ApplicationTestBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public ApplicationTestBinder withParsedId(String _id) {
    this.parseAndSetId(_id);
    return this;
  }


  public Integer getTestId() {
    return this.testId.get();
  }

  public void setTestId(Integer _testId) {
    this.testId.set(_testId);
  }

  public void parseAndSetTestId(String _testId) {
    this.setTestId(Integer.parseInt(_testId));
  }

  public ApplicationTestBinder withTestId(Integer _testId) {
    this.setTestId(_testId);
    return this;
  }

  public ApplicationTestBinder withoutTestId(Integer _testId) {
    this.setTestId(null);
    return this;
  }

  public ApplicationTestBinder withParsedTestId(String _testId) {
    this.parseAndSetTestId(_testId);
    return this;
  }


  public Integer getApplicationId() {
    return this.applicationId.get();
  }

  public void setApplicationId(Integer _applicationId) {
    this.applicationId.set(_applicationId);
  }

  public void parseAndSetApplicationId(String _applicationId) {
    this.setApplicationId(Integer.parseInt(_applicationId));
  }

  public ApplicationTestBinder withApplicationId(Integer _applicationId) {
    this.setApplicationId(_applicationId);
    return this;
  }

  public ApplicationTestBinder withoutApplicationId(Integer _applicationId) {
    this.setApplicationId(null);
    return this;
  }

  public ApplicationTestBinder withParsedApplicationId(String _applicationId) {
    this.parseAndSetApplicationId(_applicationId);
    return this;
  }


  public Timestamp getStartTime() {
    return Timestamp.valueOf(this.startTime.get());
  }

  public void setStartTime(Timestamp _startTime) {
    this.startTime.set(String.valueOf(_startTime));
  }

  public void parseAndSetStartTime(String _startTime) {
    this.setStartTime(java.sql.Timestamp.valueOf(_startTime));
  }

  public ApplicationTestBinder withStartTime(Timestamp _startTime) {
    this.setStartTime(_startTime);
    return this;
  }

  public ApplicationTestBinder withoutStartTime(Timestamp _startTime) {
    this.setStartTime(null);
    return this;
  }

  public ApplicationTestBinder withParsedStartTime(String _startTime) {
    this.parseAndSetStartTime(_startTime);
    return this;
  }


  public Timestamp getEndTime() {
    return Timestamp.valueOf(this.endTime.get());
  }

  public void setEndTime(Timestamp _endTime) {
    this.endTime.set(String.valueOf(_endTime));
  }

  public void parseAndSetEndTime(String _endTime) {
    this.setEndTime(java.sql.Timestamp.valueOf(_endTime));
  }

  public ApplicationTestBinder withEndTime(Timestamp _endTime) {
    this.setEndTime(_endTime);
    return this;
  }

  public ApplicationTestBinder withoutEndTime(Timestamp _endTime) {
    this.setEndTime(null);
    return this;
  }

  public ApplicationTestBinder withParsedEndTime(String _endTime) {
    this.parseAndSetEndTime(_endTime);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicationTestBinder)) return false;
        ApplicationTestBinder otherApplicationTest = (ApplicationTestBinder) obj;
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
        this.getId() + ", " + 
        this.getTestId() + ", " + 
        this.getApplicationId() + ", " + 
        this.getStartTime() + ", " + 
        this.getEndTime() + ", " + 
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
