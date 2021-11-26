package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class JobPositionBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty code;
  private SimpleStringProperty name;
  private SimpleStringProperty description;


  public JobPositionBinder ( Integer _id, String _code, String _name, String _description) { 
    this.id = new SimpleIntegerProperty(_id);
    this.code = new SimpleStringProperty(_code);
    this.name = new SimpleStringProperty(_name);
    this.description = new SimpleStringProperty(_description);
  }

  public JobPositionBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public JobPositionBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public JobPositionBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public JobPositionBinder withParsedId(String _id) {
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

  public JobPositionBinder withCode(String _code) {
    this.setCode(_code);
    return this;
  }

  public JobPositionBinder withoutCode(String _code) {
    this.setCode(null);
    return this;
  }

  public JobPositionBinder withParsedCode(String _code) {
    this.parseAndSetCode(_code);
    return this;
  }


  public String getName() {
    return this.name.get();
  }

  public void setName(String _name) {
    this.name.set(_name);
  }

  public void parseAndSetName(String _name) {
    this.name = new SimpleStringProperty(_name);
  }

  public JobPositionBinder withName(String _name) {
    this.setName(_name);
    return this;
  }

  public JobPositionBinder withoutName(String _name) {
    this.setName(null);
    return this;
  }

  public JobPositionBinder withParsedName(String _name) {
    this.parseAndSetName(_name);
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

  public JobPositionBinder withDescription(String _description) {
    this.setDescription(_description);
    return this;
  }

  public JobPositionBinder withoutDescription(String _description) {
    this.setDescription(null);
    return this;
  }

  public JobPositionBinder withParsedDescription(String _description) {
    this.parseAndSetDescription(_description);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof JobPositionBinder)) return false;
        JobPositionBinder otherJobPosition = (JobPositionBinder) obj;
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
        this.getId() + ", " + 
        this.getCode() + ", " + 
        this.getName() + ", " + 
        this.getDescription() + ", " + 
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
