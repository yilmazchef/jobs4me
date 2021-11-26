package be.intec.models.requests;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class InterviewNoteRequest implements Serializable, Comparable<InterviewNoteRequest> {

  private Integer id;
  private String notes;
  private Integer interviewId;
  private Integer recruiterId;
  private String pass;

      public InterviewNoteRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public InterviewNoteRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public InterviewNoteRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public InterviewNoteRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public InterviewNoteRequest withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public void parseAndSetNotes(String notes) {
    this.notes = notes;
  }

  public InterviewNoteRequest withNotes(String notes) {
    this.setNotes(notes);
    return this;
  }

  public InterviewNoteRequest withParsedNotes(String notes) {
    this.parseAndSetNotes(notes);
    return this;
  }

  public InterviewNoteRequest withoutNotes( String notes) {
    this.setNotes(null);
    return this;
  }

  public InterviewNoteRequest withoutParsedNotes(String notes) {
    this.setNotes(null);
    return this;
  }


  public Integer getInterviewId() {
    return interviewId;
  }

  public void setInterviewId(Integer interviewId) {
    this.interviewId = interviewId;
  }

  public void parseAndSetInterviewId(String interviewId) {
    this.interviewId = Integer.parseInt(interviewId);
  }

  public InterviewNoteRequest withInterviewId(Integer interviewId) {
    this.setInterviewId(interviewId);
    return this;
  }

  public InterviewNoteRequest withParsedInterviewId(String interviewId) {
    this.parseAndSetInterviewId(interviewId);
    return this;
  }

  public InterviewNoteRequest withoutInterviewId( Integer interviewId) {
    this.setInterviewId(null);
    return this;
  }

  public InterviewNoteRequest withoutParsedInterviewId(String interviewId) {
    this.setInterviewId(null);
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

  public InterviewNoteRequest withRecruiterId(Integer recruiterId) {
    this.setRecruiterId(recruiterId);
    return this;
  }

  public InterviewNoteRequest withParsedRecruiterId(String recruiterId) {
    this.parseAndSetRecruiterId(recruiterId);
    return this;
  }

  public InterviewNoteRequest withoutRecruiterId( Integer recruiterId) {
    this.setRecruiterId(null);
    return this;
  }

  public InterviewNoteRequest withoutParsedRecruiterId(String recruiterId) {
    this.setRecruiterId(null);
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

  public InterviewNoteRequest withPass(String pass) {
    this.setPass(pass);
    return this;
  }

  public InterviewNoteRequest withParsedPass(String pass) {
    this.parseAndSetPass(pass);
    return this;
  }

  public InterviewNoteRequest withoutPass( String pass) {
    this.setPass(null);
    return this;
  }

  public InterviewNoteRequest withoutParsedPass(String pass) {
    this.setPass(null);
    return this;
  }


    @Override
    public int compareTo(InterviewNoteRequest otherInterviewNote) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InterviewNoteRequest)) return false;
        InterviewNoteRequest otherInterviewNote = (InterviewNoteRequest) obj;
        return 
        this.getId().equals(otherInterviewNote.getId()) 
 &&         this.getNotes().equals(otherInterviewNote.getNotes()) 
 &&         this.getInterviewId().equals(otherInterviewNote.getInterviewId()) 
 &&         this.getRecruiterId().equals(otherInterviewNote.getRecruiterId()) 
 &&         this.getPass().equals(otherInterviewNote.getPass()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getNotes()
,         this.getInterviewId()
,         this.getRecruiterId()
,         this.getPass()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "id:" + this.getId()  + ", " + 
        "notes:" + this.getNotes()  + ", " + 
        "interviewId:" + this.getInterviewId()  + ", " + 
        "recruiterId:" + this.getRecruiterId()  + ", " + 
        "pass:" + this.getPass()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getNotes() == null && 
this.getInterviewId() == null && 
this.getRecruiterId() == null && 
this.getPass() == null );    }

}
