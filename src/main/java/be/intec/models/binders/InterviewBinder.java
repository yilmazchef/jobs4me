package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class InterviewBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty startTime;
  private SimpleStringProperty endTime;
  private SimpleIntegerProperty applicationId;


  public InterviewBinder ( Integer _id, Timestamp _startTime, Timestamp _endTime, Integer _applicationId) { 
    this.id = new SimpleIntegerProperty(_id);
    this.startTime = new SimpleStringProperty(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(_startTime));
    this.endTime = new SimpleStringProperty(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(_endTime));
    this.applicationId = new SimpleIntegerProperty(_applicationId);
  }

  public InterviewBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public InterviewBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public InterviewBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public InterviewBinder withParsedId(String _id) {
    this.parseAndSetId(_id);
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

  public InterviewBinder withStartTime(Timestamp _startTime) {
    this.setStartTime(_startTime);
    return this;
  }

  public InterviewBinder withoutStartTime(Timestamp _startTime) {
    this.setStartTime(null);
    return this;
  }

  public InterviewBinder withParsedStartTime(String _startTime) {
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

  public InterviewBinder withEndTime(Timestamp _endTime) {
    this.setEndTime(_endTime);
    return this;
  }

  public InterviewBinder withoutEndTime(Timestamp _endTime) {
    this.setEndTime(null);
    return this;
  }

  public InterviewBinder withParsedEndTime(String _endTime) {
    this.parseAndSetEndTime(_endTime);
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

  public InterviewBinder withApplicationId(Integer _applicationId) {
    this.setApplicationId(_applicationId);
    return this;
  }

  public InterviewBinder withoutApplicationId(Integer _applicationId) {
    this.setApplicationId(null);
    return this;
  }

  public InterviewBinder withParsedApplicationId(String _applicationId) {
    this.parseAndSetApplicationId(_applicationId);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InterviewBinder)) return false;
        InterviewBinder otherInterview = (InterviewBinder) obj;
        return 
        this.getId().equals(otherInterview.getId()) 
 &&         this.getStartTime().equals(otherInterview.getStartTime()) 
 &&         this.getEndTime().equals(otherInterview.getEndTime()) 
 &&         this.getApplicationId().equals(otherInterview.getApplicationId()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getStartTime()
,         this.getEndTime()
,         this.getApplicationId()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        this.getId() + ", " + 
        this.getStartTime() + ", " + 
        this.getEndTime() + ", " + 
        this.getApplicationId() + ", " + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getStartTime() == null && 
this.getEndTime() == null && 
this.getApplicationId() == null );    }
}
