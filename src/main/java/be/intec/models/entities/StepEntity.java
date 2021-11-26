package be.intec.models.entities;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class StepEntity implements Serializable, Comparable<StepEntity> {

  private Integer id;
  private String code;
  private String name;

      public StepEntity(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public StepEntity withId(Integer id) {
    this.setId(id);
    return this;
  }

  public StepEntity withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public StepEntity withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public StepEntity withoutParsedId(String id) {
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

  public StepEntity withCode(String code) {
    this.setCode(code);
    return this;
  }

  public StepEntity withParsedCode(String code) {
    this.parseAndSetCode(code);
    return this;
  }

  public StepEntity withoutCode( String code) {
    this.setCode(null);
    return this;
  }

  public StepEntity withoutParsedCode(String code) {
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

  public StepEntity withName(String name) {
    this.setName(name);
    return this;
  }

  public StepEntity withParsedName(String name) {
    this.parseAndSetName(name);
    return this;
  }

  public StepEntity withoutName( String name) {
    this.setName(null);
    return this;
  }

  public StepEntity withoutParsedName(String name) {
    this.setName(null);
    return this;
  }


    @Override
    public int compareTo(StepEntity otherStep) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StepEntity)) return false;
        StepEntity otherStep = (StepEntity) obj;
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
        "id:" + this.getId()  + ", " + 
        "code:" + this.getCode()  + ", " + 
        "name:" + this.getName()  + 
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
