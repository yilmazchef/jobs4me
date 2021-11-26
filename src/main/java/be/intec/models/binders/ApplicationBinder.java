package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class ApplicationBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty dateOfApplication;
  private SimpleStringProperty education;
  private SimpleStringProperty experience;
  private SimpleStringProperty otherInfo;
  private SimpleIntegerProperty jobId;
  private SimpleIntegerProperty applicantId;


  public ApplicationBinder ( Integer _id, Timestamp _dateOfApplication, String _education, String _experience, String _otherInfo, Integer _jobId, Integer _applicantId) { 
    this.id = new SimpleIntegerProperty(_id);
    this.dateOfApplication = new SimpleStringProperty(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(_dateOfApplication));
    this.education = new SimpleStringProperty(_education);
    this.experience = new SimpleStringProperty(_experience);
    this.otherInfo = new SimpleStringProperty(_otherInfo);
    this.jobId = new SimpleIntegerProperty(_jobId);
    this.applicantId = new SimpleIntegerProperty(_applicantId);
  }

  public ApplicationBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public ApplicationBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public ApplicationBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public ApplicationBinder withParsedId(String _id) {
    this.parseAndSetId(_id);
    return this;
  }


  public Timestamp getDateOfApplication() {
    return Timestamp.valueOf(this.dateOfApplication.get());
  }

  public void setDateOfApplication(Timestamp _dateOfApplication) {
    this.dateOfApplication.set(String.valueOf(_dateOfApplication));
  }

  public void parseAndSetDateOfApplication(String _dateOfApplication) {
    this.setDateOfApplication(java.sql.Timestamp.valueOf(_dateOfApplication));
  }

  public ApplicationBinder withDateOfApplication(Timestamp _dateOfApplication) {
    this.setDateOfApplication(_dateOfApplication);
    return this;
  }

  public ApplicationBinder withoutDateOfApplication(Timestamp _dateOfApplication) {
    this.setDateOfApplication(null);
    return this;
  }

  public ApplicationBinder withParsedDateOfApplication(String _dateOfApplication) {
    this.parseAndSetDateOfApplication(_dateOfApplication);
    return this;
  }


  public String getEducation() {
    return this.education.get();
  }

  public void setEducation(String _education) {
    this.education.set(_education);
  }

  public void parseAndSetEducation(String _education) {
    this.education = new SimpleStringProperty(_education);
  }

  public ApplicationBinder withEducation(String _education) {
    this.setEducation(_education);
    return this;
  }

  public ApplicationBinder withoutEducation(String _education) {
    this.setEducation(null);
    return this;
  }

  public ApplicationBinder withParsedEducation(String _education) {
    this.parseAndSetEducation(_education);
    return this;
  }


  public String getExperience() {
    return this.experience.get();
  }

  public void setExperience(String _experience) {
    this.experience.set(_experience);
  }

  public void parseAndSetExperience(String _experience) {
    this.experience = new SimpleStringProperty(_experience);
  }

  public ApplicationBinder withExperience(String _experience) {
    this.setExperience(_experience);
    return this;
  }

  public ApplicationBinder withoutExperience(String _experience) {
    this.setExperience(null);
    return this;
  }

  public ApplicationBinder withParsedExperience(String _experience) {
    this.parseAndSetExperience(_experience);
    return this;
  }


  public String getOtherInfo() {
    return this.otherInfo.get();
  }

  public void setOtherInfo(String _otherInfo) {
    this.otherInfo.set(_otherInfo);
  }

  public void parseAndSetOtherInfo(String _otherInfo) {
    this.otherInfo = new SimpleStringProperty(_otherInfo);
  }

  public ApplicationBinder withOtherInfo(String _otherInfo) {
    this.setOtherInfo(_otherInfo);
    return this;
  }

  public ApplicationBinder withoutOtherInfo(String _otherInfo) {
    this.setOtherInfo(null);
    return this;
  }

  public ApplicationBinder withParsedOtherInfo(String _otherInfo) {
    this.parseAndSetOtherInfo(_otherInfo);
    return this;
  }


  public Integer getJobId() {
    return this.jobId.get();
  }

  public void setJobId(Integer _jobId) {
    this.jobId.set(_jobId);
  }

  public void parseAndSetJobId(String _jobId) {
    this.setJobId(Integer.parseInt(_jobId));
  }

  public ApplicationBinder withJobId(Integer _jobId) {
    this.setJobId(_jobId);
    return this;
  }

  public ApplicationBinder withoutJobId(Integer _jobId) {
    this.setJobId(null);
    return this;
  }

  public ApplicationBinder withParsedJobId(String _jobId) {
    this.parseAndSetJobId(_jobId);
    return this;
  }


  public Integer getApplicantId() {
    return this.applicantId.get();
  }

  public void setApplicantId(Integer _applicantId) {
    this.applicantId.set(_applicantId);
  }

  public void parseAndSetApplicantId(String _applicantId) {
    this.setApplicantId(Integer.parseInt(_applicantId));
  }

  public ApplicationBinder withApplicantId(Integer _applicantId) {
    this.setApplicantId(_applicantId);
    return this;
  }

  public ApplicationBinder withoutApplicantId(Integer _applicantId) {
    this.setApplicantId(null);
    return this;
  }

  public ApplicationBinder withParsedApplicantId(String _applicantId) {
    this.parseAndSetApplicantId(_applicantId);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicationBinder)) return false;
        ApplicationBinder otherApplication = (ApplicationBinder) obj;
        return 
        this.getId().equals(otherApplication.getId()) 
 &&         this.getDateOfApplication().equals(otherApplication.getDateOfApplication()) 
 &&         this.getEducation().equals(otherApplication.getEducation()) 
 &&         this.getExperience().equals(otherApplication.getExperience()) 
 &&         this.getOtherInfo().equals(otherApplication.getOtherInfo()) 
 &&         this.getJobId().equals(otherApplication.getJobId()) 
 &&         this.getApplicantId().equals(otherApplication.getApplicantId()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getDateOfApplication()
,         this.getEducation()
,         this.getExperience()
,         this.getOtherInfo()
,         this.getJobId()
,         this.getApplicantId()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        this.getId() + ", " + 
        this.getDateOfApplication() + ", " + 
        this.getEducation() + ", " + 
        this.getExperience() + ", " + 
        this.getOtherInfo() + ", " + 
        this.getJobId() + ", " + 
        this.getApplicantId() + ", " + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getDateOfApplication() == null && 
this.getEducation() == null && 
this.getExperience() == null && 
this.getOtherInfo() == null && 
this.getJobId() == null && 
this.getApplicantId() == null );    }
}
