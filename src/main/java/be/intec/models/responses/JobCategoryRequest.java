package be.intec.models.responses;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class JobCategoryRequest implements Serializable, Comparable<JobCategoryRequest> {

  private Integer id;
  private String code;
  private String name;
  private String description;

      public JobCategoryRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public JobCategoryRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public JobCategoryRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public JobCategoryRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public JobCategoryRequest withoutParsedId(String id) {
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

  public JobCategoryRequest withCode(String code) {
    this.setCode(code);
    return this;
  }

  public JobCategoryRequest withParsedCode(String code) {
    this.parseAndSetCode(code);
    return this;
  }

  public JobCategoryRequest withoutCode( String code) {
    this.setCode(null);
    return this;
  }

  public JobCategoryRequest withoutParsedCode(String code) {
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

  public JobCategoryRequest withName(String name) {
    this.setName(name);
    return this;
  }

  public JobCategoryRequest withParsedName(String name) {
    this.parseAndSetName(name);
    return this;
  }

  public JobCategoryRequest withoutName( String name) {
    this.setName(null);
    return this;
  }

  public JobCategoryRequest withoutParsedName(String name) {
    this.setName(null);
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

  public JobCategoryRequest withDescription(String description) {
    this.setDescription(description);
    return this;
  }

  public JobCategoryRequest withParsedDescription(String description) {
    this.parseAndSetDescription(description);
    return this;
  }

  public JobCategoryRequest withoutDescription( String description) {
    this.setDescription(null);
    return this;
  }

  public JobCategoryRequest withoutParsedDescription(String description) {
    this.setDescription(null);
    return this;
  }


    @Override
    public int compareTo(JobCategoryRequest otherJobCategory) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof JobCategoryRequest)) return false;
        JobCategoryRequest otherJobCategory = (JobCategoryRequest) obj;
        return 
        this.getId().equals(otherJobCategory.getId()) 
 &&         this.getCode().equals(otherJobCategory.getCode()) 
 &&         this.getName().equals(otherJobCategory.getName()) 
 &&         this.getDescription().equals(otherJobCategory.getDescription()) 
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
        "id:" + this.getId()  + ", " + 
        "code:" + this.getCode()  + ", " + 
        "name:" + this.getName()  + ", " + 
        "description:" + this.getDescription()  + 
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
