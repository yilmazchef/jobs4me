package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class TestBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty code;
  private SimpleIntegerProperty duration;
  private SimpleIntegerProperty maxScore;


  public TestBinder ( Integer _id, String _code, Integer _duration, Integer _maxScore) { 
    this.id = new SimpleIntegerProperty(_id);
    this.code = new SimpleStringProperty(_code);
    this.duration = new SimpleIntegerProperty(_duration);
    this.maxScore = new SimpleIntegerProperty(_maxScore);
  }

  public TestBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public TestBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public TestBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public TestBinder withParsedId(String _id) {
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

  public TestBinder withCode(String _code) {
    this.setCode(_code);
    return this;
  }

  public TestBinder withoutCode(String _code) {
    this.setCode(null);
    return this;
  }

  public TestBinder withParsedCode(String _code) {
    this.parseAndSetCode(_code);
    return this;
  }


  public Integer getDuration() {
    return this.duration.get();
  }

  public void setDuration(Integer _duration) {
    this.duration.set(_duration);
  }

  public void parseAndSetDuration(String _duration) {
    this.setDuration(Integer.parseInt(_duration));
  }

  public TestBinder withDuration(Integer _duration) {
    this.setDuration(_duration);
    return this;
  }

  public TestBinder withoutDuration(Integer _duration) {
    this.setDuration(null);
    return this;
  }

  public TestBinder withParsedDuration(String _duration) {
    this.parseAndSetDuration(_duration);
    return this;
  }


  public Integer getMaxScore() {
    return this.maxScore.get();
  }

  public void setMaxScore(Integer _maxScore) {
    this.maxScore.set(_maxScore);
  }

  public void parseAndSetMaxScore(String _maxScore) {
    this.setMaxScore(Integer.parseInt(_maxScore));
  }

  public TestBinder withMaxScore(Integer _maxScore) {
    this.setMaxScore(_maxScore);
    return this;
  }

  public TestBinder withoutMaxScore(Integer _maxScore) {
    this.setMaxScore(null);
    return this;
  }

  public TestBinder withParsedMaxScore(String _maxScore) {
    this.parseAndSetMaxScore(_maxScore);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TestBinder)) return false;
        TestBinder otherTest = (TestBinder) obj;
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
        this.getId() + ", " + 
        this.getCode() + ", " + 
        this.getDuration() + ", " + 
        this.getMaxScore() + ", " + 
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
