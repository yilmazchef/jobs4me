package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class ApplicationEvaluationBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty notes;
  private SimpleIntegerProperty recruiterId;
  private SimpleIntegerProperty applicationId;
  private SimpleStringProperty hired;


  public ApplicationEvaluationBinder ( Integer _id, String _notes, Integer _recruiterId, Integer _applicationId, String _hired) { 
    this.id = new SimpleIntegerProperty(_id);
    this.notes = new SimpleStringProperty(_notes);
    this.recruiterId = new SimpleIntegerProperty(_recruiterId);
    this.applicationId = new SimpleIntegerProperty(_applicationId);
    this.hired = new SimpleStringProperty(_hired);
  }

  public ApplicationEvaluationBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public ApplicationEvaluationBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public ApplicationEvaluationBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public ApplicationEvaluationBinder withParsedId(String _id) {
    this.parseAndSetId(_id);
    return this;
  }


  public String getNotes() {
    return this.notes.get();
  }

  public void setNotes(String _notes) {
    this.notes.set(_notes);
  }

  public void parseAndSetNotes(String _notes) {
    this.notes = new SimpleStringProperty(_notes);
  }

  public ApplicationEvaluationBinder withNotes(String _notes) {
    this.setNotes(_notes);
    return this;
  }

  public ApplicationEvaluationBinder withoutNotes(String _notes) {
    this.setNotes(null);
    return this;
  }

  public ApplicationEvaluationBinder withParsedNotes(String _notes) {
    this.parseAndSetNotes(_notes);
    return this;
  }


  public Integer getRecruiterId() {
    return this.recruiterId.get();
  }

  public void setRecruiterId(Integer _recruiterId) {
    this.recruiterId.set(_recruiterId);
  }

  public void parseAndSetRecruiterId(String _recruiterId) {
    this.setRecruiterId(Integer.parseInt(_recruiterId));
  }

  public ApplicationEvaluationBinder withRecruiterId(Integer _recruiterId) {
    this.setRecruiterId(_recruiterId);
    return this;
  }

  public ApplicationEvaluationBinder withoutRecruiterId(Integer _recruiterId) {
    this.setRecruiterId(null);
    return this;
  }

  public ApplicationEvaluationBinder withParsedRecruiterId(String _recruiterId) {
    this.parseAndSetRecruiterId(_recruiterId);
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

  public ApplicationEvaluationBinder withApplicationId(Integer _applicationId) {
    this.setApplicationId(_applicationId);
    return this;
  }

  public ApplicationEvaluationBinder withoutApplicationId(Integer _applicationId) {
    this.setApplicationId(null);
    return this;
  }

  public ApplicationEvaluationBinder withParsedApplicationId(String _applicationId) {
    this.parseAndSetApplicationId(_applicationId);
    return this;
  }


  public String getHired() {
    return this.hired.get();
  }

  public void setHired(String _hired) {
    this.hired.set(_hired);
  }

  public void parseAndSetHired(String _hired) {
    this.hired = new SimpleStringProperty(_hired);
  }

  public ApplicationEvaluationBinder withHired(String _hired) {
    this.setHired(_hired);
    return this;
  }

  public ApplicationEvaluationBinder withoutHired(String _hired) {
    this.setHired(null);
    return this;
  }

  public ApplicationEvaluationBinder withParsedHired(String _hired) {
    this.parseAndSetHired(_hired);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicationEvaluationBinder)) return false;
        ApplicationEvaluationBinder otherApplicationEvaluation = (ApplicationEvaluationBinder) obj;
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
        this.getId() + ", " + 
        this.getNotes() + ", " + 
        this.getRecruiterId() + ", " + 
        this.getApplicationId() + ", " + 
        this.getHired() + ", " + 
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
