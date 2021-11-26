package be.intec.models.entities;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class TestEntity implements Serializable, Comparable<TestEntity> {

  private Integer id;
  private String code;
  private Integer duration;
  private Integer maxScore;

      public TestEntity(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public TestEntity withId(Integer id) {
    this.setId(id);
    return this;
  }

  public TestEntity withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public TestEntity withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public TestEntity withoutParsedId(String id) {
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

  public TestEntity withCode(String code) {
    this.setCode(code);
    return this;
  }

  public TestEntity withParsedCode(String code) {
    this.parseAndSetCode(code);
    return this;
  }

  public TestEntity withoutCode( String code) {
    this.setCode(null);
    return this;
  }

  public TestEntity withoutParsedCode(String code) {
    this.setCode(null);
    return this;
  }


  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public void parseAndSetDuration(String duration) {
    this.duration = Integer.parseInt(duration);
  }

  public TestEntity withDuration(Integer duration) {
    this.setDuration(duration);
    return this;
  }

  public TestEntity withParsedDuration(String duration) {
    this.parseAndSetDuration(duration);
    return this;
  }

  public TestEntity withoutDuration( Integer duration) {
    this.setDuration(null);
    return this;
  }

  public TestEntity withoutParsedDuration(String duration) {
    this.setDuration(null);
    return this;
  }


  public Integer getMaxScore() {
    return maxScore;
  }

  public void setMaxScore(Integer maxScore) {
    this.maxScore = maxScore;
  }

  public void parseAndSetMaxScore(String maxScore) {
    this.maxScore = Integer.parseInt(maxScore);
  }

  public TestEntity withMaxScore(Integer maxScore) {
    this.setMaxScore(maxScore);
    return this;
  }

  public TestEntity withParsedMaxScore(String maxScore) {
    this.parseAndSetMaxScore(maxScore);
    return this;
  }

  public TestEntity withoutMaxScore( Integer maxScore) {
    this.setMaxScore(null);
    return this;
  }

  public TestEntity withoutParsedMaxScore(String maxScore) {
    this.setMaxScore(null);
    return this;
  }


    @Override
    public int compareTo(TestEntity otherTest) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TestEntity)) return false;
        TestEntity otherTest = (TestEntity) obj;
        return 
        this.getId().equals(otherTest.getId()) 
 &&         this.getCode().equals(otherTest.getCode()) 
 &&         this.getDuration().equals(otherTest.getDuration()) 
 &&         this.getMaxScore().equals(otherTest.getMaxScore()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getCode()
,         this.getDuration()
,         this.getMaxScore()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "id:" + this.getId()  + ", " + 
        "code:" + this.getCode()  + ", " + 
        "duration:" + this.getDuration()  + ", " + 
        "maxScore:" + this.getMaxScore()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getCode() == null && 
this.getDuration() == null && 
this.getMaxScore() == null );    }

}
