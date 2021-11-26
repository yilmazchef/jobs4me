package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class ProcessBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty code;
  private SimpleStringProperty description;
  private SimpleIntegerProperty recruiterId;


  public ProcessBinder ( Integer _id, String _code, String _description, Integer _recruiterId) { 
    this.id = new SimpleIntegerProperty(_id);
    this.code = new SimpleStringProperty(_code);
    this.description = new SimpleStringProperty(_description);
    this.recruiterId = new SimpleIntegerProperty(_recruiterId);
  }

  public ProcessBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public ProcessBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public ProcessBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public ProcessBinder withParsedId(String _id) {
    this.parseAndSetId(_id);
    return this;
  }


  public String getCode() {
    return this.code.get();
  }

  public void setCode(String _code) {
    this.code.set(_code);
  }

  public void parseAndSetCode(String _code) {
    this.code = new SimpleStringProperty(_code);
  }

  public ProcessBinder withCode(String _code) {
    this.setCode(_code);
    return this;
  }

  public ProcessBinder withoutCode(String _code) {
    this.setCode(null);
    return this;
  }

  public ProcessBinder withParsedCode(String _code) {
    this.parseAndSetCode(_code);
    return this;
  }


  public String getDescription() {
    return this.description.get();
  }

  public void setDescription(String _description) {
    this.description.set(_description);
  }

  public void parseAndSetDescription(String _description) {
    this.description = new SimpleStringProperty(_description);
  }

  public ProcessBinder withDescription(String _description) {
    this.setDescription(_description);
    return this;
  }

  public ProcessBinder withoutDescription(String _description) {
    this.setDescription(null);
    return this;
  }

  public ProcessBinder withParsedDescription(String _description) {
    this.parseAndSetDescription(_description);
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

  public ProcessBinder withRecruiterId(Integer _recruiterId) {
    this.setRecruiterId(_recruiterId);
    return this;
  }

  public ProcessBinder withoutRecruiterId(Integer _recruiterId) {
    this.setRecruiterId(null);
    return this;
  }

  public ProcessBinder withParsedRecruiterId(String _recruiterId) {
    this.parseAndSetRecruiterId(_recruiterId);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ProcessBinder)) return false;
        ProcessBinder otherProcess = (ProcessBinder) obj;
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
        this.getId() + ", " + 
        this.getCode() + ", " + 
        this.getDescription() + ", " + 
        this.getRecruiterId() + ", " + 
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
