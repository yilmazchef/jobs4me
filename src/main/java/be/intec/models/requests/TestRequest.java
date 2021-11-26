package be.intec.models.requests;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class TestRequest implements Serializable, Comparable<TestRequest> {

  private Integer id;
  private String code;
  private Integer duration;
  private Integer maxScore;

      public TestRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public TestRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public TestRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public TestRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public TestRequest withoutParsedId(String id) {
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

  public TestRequest withCode(String code) {
    this.setCode(code);
    return this;
  }

  public TestRequest withParsedCode(String code) {
    this.parseAndSetCode(code);
    return this;
  }

  public TestRequest withoutCode( String code) {
    this.setCode(null);
    return this;
  }

  public TestRequest withoutParsedCode(String code) {
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

  public TestRequest withDuration(Integer duration) {
    this.setDuration(duration);
    return this;
  }

  public TestRequest withParsedDuration(String duration) {
    this.parseAndSetDuration(duration);
    return this;
  }

  public TestRequest withoutDuration( Integer duration) {
    this.setDuration(null);
    return this;
  }

  public TestRequest withoutParsedDuration(String duration) {
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

  public TestRequest withMaxScore(Integer maxScore) {
    this.setMaxScore(maxScore);
    return this;
  }

  public TestRequest withParsedMaxScore(String maxScore) {
    this.parseAndSetMaxScore(maxScore);
    return this;
  }

  public TestRequest withoutMaxScore( Integer maxScore) {
    this.setMaxScore(null);
    return this;
  }

  public TestRequest withoutParsedMaxScore(String maxScore) {
    this.setMaxScore(null);
    return this;
  }


    @Override
    public int compareTo(TestRequest otherTest) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TestRequest)) return false;
        TestRequest otherTest = (TestRequest) obj;
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
