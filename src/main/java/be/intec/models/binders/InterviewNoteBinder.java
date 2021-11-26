package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class InterviewNoteBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty notes;
  private SimpleIntegerProperty interviewId;
  private SimpleIntegerProperty recruiterId;
  private SimpleStringProperty pass;


  public InterviewNoteBinder ( Integer _id, String _notes, Integer _interviewId, Integer _recruiterId, String _pass) { 
    this.id = new SimpleIntegerProperty(_id);
    this.notes = new SimpleStringProperty(_notes);
    this.interviewId = new SimpleIntegerProperty(_interviewId);
    this.recruiterId = new SimpleIntegerProperty(_recruiterId);
    this.pass = new SimpleStringProperty(_pass);
  }

  public InterviewNoteBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public InterviewNoteBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public InterviewNoteBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public InterviewNoteBinder withParsedId(String _id) {
    this.parseAndSetId(_id);
    return this;
  }


  public String getNotes() {
    return this.notes.get();
  }

  public void setNotes(String _notes) {
    this.notes.set(_notes);
  }

  public void parseAndSetNotes(String _notes) {
    this.notes = new SimpleStringProperty(_notes);
  }

  public InterviewNoteBinder withNotes(String _notes) {
    this.setNotes(_notes);
    return this;
  }

  public InterviewNoteBinder withoutNotes(String _notes) {
    this.setNotes(null);
    return this;
  }

  public InterviewNoteBinder withParsedNotes(String _notes) {
    this.parseAndSetNotes(_notes);
    return this;
  }


  public Integer getInterviewId() {
    return this.interviewId.get();
  }

  public void setInterviewId(Integer _interviewId) {
    this.interviewId.set(_interviewId);
  }

  public void parseAndSetInterviewId(String _interviewId) {
    this.setInterviewId(Integer.parseInt(_interviewId));
  }

  public InterviewNoteBinder withInterviewId(Integer _interviewId) {
    this.setInterviewId(_interviewId);
    return this;
  }

  public InterviewNoteBinder withoutInterviewId(Integer _interviewId) {
    this.setInterviewId(null);
    return this;
  }

  public InterviewNoteBinder withParsedInterviewId(String _interviewId) {
    this.parseAndSetInterviewId(_interviewId);
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

  public InterviewNoteBinder withRecruiterId(Integer _recruiterId) {
    this.setRecruiterId(_recruiterId);
    return this;
  }

  public InterviewNoteBinder withoutRecruiterId(Integer _recruiterId) {
    this.setRecruiterId(null);
    return this;
  }

  public InterviewNoteBinder withParsedRecruiterId(String _recruiterId) {
    this.parseAndSetRecruiterId(_recruiterId);
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

  public InterviewNoteBinder withPass(String _pass) {
    this.setPass(_pass);
    return this;
  }

  public InterviewNoteBinder withoutPass(String _pass) {
    this.setPass(null);
    return this;
  }

  public InterviewNoteBinder withParsedPass(String _pass) {
    this.parseAndSetPass(_pass);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InterviewNoteBinder)) return false;
        InterviewNoteBinder otherInterviewNote = (InterviewNoteBinder) obj;
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
        this.getId() + ", " + 
        this.getNotes() + ", " + 
        this.getInterviewId() + ", " + 
        this.getRecruiterId() + ", " + 
        this.getPass() + ", " + 
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
