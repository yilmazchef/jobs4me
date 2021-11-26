package be.intec.models.requests;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class AnswersRequest implements Serializable, Comparable<AnswersRequest> {

  private Integer id;
  private Integer applicationTestId;
  private Integer recruiterId;
  private String totalGrades;
  private String pass;
  private String answerDetails;

      public AnswersRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public AnswersRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public AnswersRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public AnswersRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public AnswersRequest withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public Integer getApplicationTestId() {
    return applicationTestId;
  }

  public void setApplicationTestId(Integer applicationTestId) {
    this.applicationTestId = applicationTestId;
  }

  public void parseAndSetApplicationTestId(String applicationTestId) {
    this.applicationTestId = Integer.parseInt(applicationTestId);
  }

  public AnswersRequest withApplicationTestId(Integer applicationTestId) {
    this.setApplicationTestId(applicationTestId);
    return this;
  }

  public AnswersRequest withParsedApplicationTestId(String applicationTestId) {
    this.parseAndSetApplicationTestId(applicationTestId);
    return this;
  }

  public AnswersRequest withoutApplicationTestId( Integer applicationTestId) {
    this.setApplicationTestId(null);
    return this;
  }

  public AnswersRequest withoutParsedApplicationTestId(String applicationTestId) {
    this.setApplicationTestId(null);
    return this;
  }


  public Integer getRecruiterId() {
    return recruiterId;
  }

  public void setRecruiterId(Integer recruiterId) {
    this.recruiterId = recruiterId;
  }

  public void parseAndSetRecruiterId(String recruiterId) {
    this.recruiterId = Integer.parseInt(recruiterId);
  }

  public AnswersRequest withRecruiterId(Integer recruiterId) {
    this.setRecruiterId(recruiterId);
    return this;
  }

  public AnswersRequest withParsedRecruiterId(String recruiterId) {
    this.parseAndSetRecruiterId(recruiterId);
    return this;
  }

  public AnswersRequest withoutRecruiterId( Integer recruiterId) {
    this.setRecruiterId(null);
    return this;
  }

  public AnswersRequest withoutParsedRecruiterId(String recruiterId) {
    this.setRecruiterId(null);
    return this;
  }


  public String getTotalGrades() {
    return totalGrades;
  }

  public void setTotalGrades(String totalGrades) {
    this.totalGrades = totalGrades;
  }

  public void parseAndSetTotalGrades(String totalGrades) {
    this.totalGrades = totalGrades;
  }

  public AnswersRequest withTotalGrades(String totalGrades) {
    this.setTotalGrades(totalGrades);
    return this;
  }

  public AnswersRequest withParsedTotalGrades(String totalGrades) {
    this.parseAndSetTotalGrades(totalGrades);
    return this;
  }

  public AnswersRequest withoutTotalGrades( String totalGrades) {
    this.setTotalGrades(null);
    return this;
  }

  public AnswersRequest withoutParsedTotalGrades(String totalGrades) {
    this.setTotalGrades(null);
    return this;
  }


  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public void parseAndSetPass(String pass) {
    this.pass = pass;
  }

  public AnswersRequest withPass(String pass) {
    this.setPass(pass);
    return this;
  }

  public AnswersRequest withParsedPass(String pass) {
    this.parseAndSetPass(pass);
    return this;
  }

  public AnswersRequest withoutPass( String pass) {
    this.setPass(null);
    return this;
  }

  public AnswersRequest withoutParsedPass(String pass) {
    this.setPass(null);
    return this;
  }


  public String getAnswerDetails() {
    return answerDetails;
  }

  public void setAnswerDetails(String answerDetails) {
    this.answerDetails = answerDetails;
  }

  public void parseAndSetAnswerDetails(String answerDetails) {
    this.answerDetails = answerDetails;
  }

  public AnswersRequest withAnswerDetails(String answerDetails) {
    this.setAnswerDetails(answerDetails);
    return this;
  }

  public AnswersRequest withParsedAnswerDetails(String answerDetails) {
    this.parseAndSetAnswerDetails(answerDetails);
    return this;
  }

  public AnswersRequest withoutAnswerDetails( String answerDetails) {
    this.setAnswerDetails(null);
    return this;
  }

  public AnswersRequest withoutParsedAnswerDetails(String answerDetails) {
    this.setAnswerDetails(null);
    return this;
  }


    @Override
    public int compareTo(AnswersRequest otherAnswers) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AnswersRequest)) return false;
        AnswersRequest otherAnswers = (AnswersRequest) obj;
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
        "id:" + this.getId()  + ", " + 
        "applicationTestId:" + this.getApplicationTestId()  + ", " + 
        "recruiterId:" + this.getRecruiterId()  + ", " + 
        "totalGrades:" + this.getTotalGrades()  + ", " + 
        "pass:" + this.getPass()  + ", " + 
        "answerDetails:" + this.getAnswerDetails()  + 
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
