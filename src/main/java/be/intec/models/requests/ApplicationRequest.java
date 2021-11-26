package be.intec.models.requests;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ApplicationRequest implements Serializable, Comparable<ApplicationRequest> {

  private Integer id;
  private Timestamp dateOfApplication;
  private String education;
  private String experience;
  private String otherInfo;
  private Integer jobId;
  private Integer applicantId;

      public ApplicationRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public ApplicationRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public ApplicationRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public ApplicationRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public ApplicationRequest withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public Timestamp getDateOfApplication() {
    return dateOfApplication;
  }

  public void setDateOfApplication(Timestamp dateOfApplication) {
    this.dateOfApplication = dateOfApplication;
  }

  public void parseAndSetDateOfApplication(String dateOfApplication) {
    this.dateOfApplication = java.sql.Timestamp.valueOf(dateOfApplication);
  }

  public ApplicationRequest withDateOfApplication(Timestamp dateOfApplication) {
    this.setDateOfApplication(dateOfApplication);
    return this;
  }

  public ApplicationRequest withParsedDateOfApplication(String dateOfApplication) {
    this.parseAndSetDateOfApplication(dateOfApplication);
    return this;
  }

  public ApplicationRequest withoutDateOfApplication( Timestamp dateOfApplication) {
    this.setDateOfApplication(null);
    return this;
  }

  public ApplicationRequest withoutParsedDateOfApplication(String dateOfApplication) {
    this.setDateOfApplication(null);
    return this;
  }


  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public void parseAndSetEducation(String education) {
    this.education = education;
  }

  public ApplicationRequest withEducation(String education) {
    this.setEducation(education);
    return this;
  }

  public ApplicationRequest withParsedEducation(String education) {
    this.parseAndSetEducation(education);
    return this;
  }

  public ApplicationRequest withoutEducation( String education) {
    this.setEducation(null);
    return this;
  }

  public ApplicationRequest withoutParsedEducation(String education) {
    this.setEducation(null);
    return this;
  }


  public String getExperience() {
    return experience;
  }

  public void setExperience(String experience) {
    this.experience = experience;
  }

  public void parseAndSetExperience(String experience) {
    this.experience = experience;
  }

  public ApplicationRequest withExperience(String experience) {
    this.setExperience(experience);
    return this;
  }

  public ApplicationRequest withParsedExperience(String experience) {
    this.parseAndSetExperience(experience);
    return this;
  }

  public ApplicationRequest withoutExperience( String experience) {
    this.setExperience(null);
    return this;
  }

  public ApplicationRequest withoutParsedExperience(String experience) {
    this.setExperience(null);
    return this;
  }


  public String getOtherInfo() {
    return otherInfo;
  }

  public void setOtherInfo(String otherInfo) {
    this.otherInfo = otherInfo;
  }

  public void parseAndSetOtherInfo(String otherInfo) {
    this.otherInfo = otherInfo;
  }

  public ApplicationRequest withOtherInfo(String otherInfo) {
    this.setOtherInfo(otherInfo);
    return this;
  }

  public ApplicationRequest withParsedOtherInfo(String otherInfo) {
    this.parseAndSetOtherInfo(otherInfo);
    return this;
  }

  public ApplicationRequest withoutOtherInfo( String otherInfo) {
    this.setOtherInfo(null);
    return this;
  }

  public ApplicationRequest withoutParsedOtherInfo(String otherInfo) {
    this.setOtherInfo(null);
    return this;
  }


  public Integer getJobId() {
    return jobId;
  }

  public void setJobId(Integer jobId) {
    this.jobId = jobId;
  }

  public void parseAndSetJobId(String jobId) {
    this.jobId = Integer.parseInt(jobId);
  }

  public ApplicationRequest withJobId(Integer jobId) {
    this.setJobId(jobId);
    return this;
  }

  public ApplicationRequest withParsedJobId(String jobId) {
    this.parseAndSetJobId(jobId);
    return this;
  }

  public ApplicationRequest withoutJobId( Integer jobId) {
    this.setJobId(null);
    return this;
  }

  public ApplicationRequest withoutParsedJobId(String jobId) {
    this.setJobId(null);
    return this;
  }


  public Integer getApplicantId() {
    return applicantId;
  }

  public void setApplicantId(Integer applicantId) {
    this.applicantId = applicantId;
  }

  public void parseAndSetApplicantId(String applicantId) {
    this.applicantId = Integer.parseInt(applicantId);
  }

  public ApplicationRequest withApplicantId(Integer applicantId) {
    this.setApplicantId(applicantId);
    return this;
  }

  public ApplicationRequest withParsedApplicantId(String applicantId) {
    this.parseAndSetApplicantId(applicantId);
    return this;
  }

  public ApplicationRequest withoutApplicantId( Integer applicantId) {
    this.setApplicantId(null);
    return this;
  }

  public ApplicationRequest withoutParsedApplicantId(String applicantId) {
    this.setApplicantId(null);
    return this;
  }


    @Override
    public int compareTo(ApplicationRequest otherApplication) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicationRequest)) return false;
        ApplicationRequest otherApplication = (ApplicationRequest) obj;
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
        "id:" + this.getId()  + ", " + 
        "dateOfApplication:" + this.getDateOfApplication()  + ", " + 
        "education:" + this.getEducation()  + ", " + 
        "experience:" + this.getExperience()  + ", " + 
        "otherInfo:" + this.getOtherInfo()  + ", " + 
        "jobId:" + this.getJobId()  + ", " + 
        "applicantId:" + this.getApplicantId()  + 
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
