package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class StepBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty code;
  private SimpleStringProperty name;


  public StepBinder ( Integer _id, String _code, String _name) { 
    this.id = new SimpleIntegerProperty(_id);
    this.code = new SimpleStringProperty(_code);
    this.name = new SimpleStringProperty(_name);
  }

  public StepBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public StepBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public StepBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public StepBinder withParsedId(String _id) {
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

  public StepBinder withCode(String _code) {
    this.setCode(_code);
    return this;
  }

  public StepBinder withoutCode(String _code) {
    this.setCode(null);
    return this;
  }

  public StepBinder withParsedCode(String _code) {
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

  public StepBinder withName(String _name) {
    this.setName(_name);
    return this;
  }

  public StepBinder withoutName(String _name) {
    this.setName(null);
    return this;
  }

  public StepBinder withParsedName(String _name) {
    this.parseAndSetName(_name);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StepBinder)) return false;
        StepBinder otherStep = (StepBinder) obj;
        return 
        this.getId().equals(otherStep.getId()) 
 &&         this.getCode().equals(otherStep.getCode()) 
 &&         this.getName().equals(otherStep.getName()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getCode()
,         this.getName()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        this.getId() + ", " + 
        this.getCode() + ", " + 
        this.getName() + ", " + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getCode() == null && 
this.getName() == null );    }
}
