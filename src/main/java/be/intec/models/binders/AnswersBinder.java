package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class AnswersBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleIntegerProperty applicationTestId;
  private SimpleIntegerProperty recruiterId;
  private SimpleStringProperty totalGrades;
  private SimpleStringProperty pass;
  private SimpleStringProperty answerDetails;


  public AnswersBinder ( Integer _id, Integer _applicationTestId, Integer _recruiterId, String _totalGrades, String _pass, String _answerDetails) { 
    this.id = new SimpleIntegerProperty(_id);
    this.applicationTestId = new SimpleIntegerProperty(_applicationTestId);
    this.recruiterId = new SimpleIntegerProperty(_recruiterId);
    this.totalGrades = new SimpleStringProperty(_totalGrades);
    this.pass = new SimpleStringProperty(_pass);
    this.answerDetails = new SimpleStringProperty(_answerDetails);
  }

  public AnswersBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public AnswersBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public AnswersBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public AnswersBinder withParsedId(String _id) {
    this.parseAndSetId(_id);
    return this;
  }


  public Integer getApplicationTestId() {
    return this.applicationTestId.get();
  }

  public void setApplicationTestId(Integer _applicationTestId) {
    this.applicationTestId.set(_applicationTestId);
  }

  public void parseAndSetApplicationTestId(String _applicationTestId) {
    this.setApplicationTestId(Integer.parseInt(_applicationTestId));
  }

  public AnswersBinder withApplicationTestId(Integer _applicationTestId) {
    this.setApplicationTestId(_applicationTestId);
    return this;
  }

  public AnswersBinder withoutApplicationTestId(Integer _applicationTestId) {
    this.setApplicationTestId(null);
    return this;
  }

  public AnswersBinder withParsedApplicationTestId(String _applicationTestId) {
    this.parseAndSetApplicationTestId(_applicationTestId);
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

  public AnswersBinder withRecruiterId(Integer _recruiterId) {
    this.setRecruiterId(_recruiterId);
    return this;
  }

  public AnswersBinder withoutRecruiterId(Integer _recruiterId) {
    this.setRecruiterId(null);
    return this;
  }

  public AnswersBinder withParsedRecruiterId(String _recruiterId) {
    this.parseAndSetRecruiterId(_recruiterId);
    return this;
  }


  public String getTotalGrades() {
    return this.totalGrades.get();
  }

  public void setTotalGrades(String _totalGrades) {
    this.totalGrades.set(_totalGrades);
  }

  public void parseAndSetTotalGrades(String _totalGrades) {
    this.totalGrades = new SimpleStringProperty(_totalGrades);
  }

  public AnswersBinder withTotalGrades(String _totalGrades) {
    this.setTotalGrades(_totalGrades);
    return this;
  }

  public AnswersBinder withoutTotalGrades(String _totalGrades) {
    this.setTotalGrades(null);
    return this;
  }

  public AnswersBinder withParsedTotalGrades(String _totalGrades) {
    this.parseAndSetTotalGrades(_totalGrades);
    return this;
  }


  public String getPass() {
    return this.pass.get();
  }

  public void setPass(String _pass) {
    this.pass.set(_pass);
  }

  public void parseAndSetPass(String _pass) {
    this.pass = new SimpleStringProperty(_pass);
  }

  public AnswersBinder withPass(String _pass) {
    this.setPass(_pass);
    return this;
  }

  public AnswersBinder withoutPass(String _pass) {
    this.setPass(null);
    return this;
  }

  public AnswersBinder withParsedPass(String _pass) {
    this.parseAndSetPass(_pass);
    return this;
  }


  public String getAnswerDetails() {
    return this.answerDetails.get();
  }

  public void setAnswerDetails(String _answerDetails) {
    this.answerDetails.set(_answerDetails);
  }

  public void parseAndSetAnswerDetails(String _answerDetails) {
    this.answerDetails = new SimpleStringProperty(_answerDetails);
  }

  public AnswersBinder withAnswerDetails(String _answerDetails) {
    this.setAnswerDetails(_answerDetails);
    return this;
  }

  public AnswersBinder withoutAnswerDetails(String _answerDetails) {
    this.setAnswerDetails(null);
    return this;
  }

  public AnswersBinder withParsedAnswerDetails(String _answerDetails) {
    this.parseAndSetAnswerDetails(_answerDetails);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AnswersBinder)) return false;
        AnswersBinder otherAnswers = (AnswersBinder) obj;
        return 
        this.getId().equals(otherAnswers.getId()) 
 &&         this.getApplicationTestId().equals(otherAnswers.getApplicationTestId()) 
 &&         this.getRecruiterId().equals(otherAnswers.getRecruiterId()) 
 &&         this.getTotalGrades().equals(otherAnswers.getTotalGrades()) 
 &&         this.getPass().equals(otherAnswers.getPass()) 
 &&         this.getAnswerDetails().equals(otherAnswers.getAnswerDetails()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getApplicationTestId()
,         this.getRecruiterId()
,         this.getTotalGrades()
,         this.getPass()
,         this.getAnswerDetails()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        this.getId() + ", " + 
        this.getApplicationTestId() + ", " + 
        this.getRecruiterId() + ", " + 
        this.getTotalGrades() + ", " + 
        this.getPass() + ", " + 
        this.getAnswerDetails() + ", " + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getApplicationTestId() == null && 
this.getRecruiterId() == null && 
this.getTotalGrades() == null && 
this.getPass() == null && 
this.getAnswerDetails() == null );    }
}
