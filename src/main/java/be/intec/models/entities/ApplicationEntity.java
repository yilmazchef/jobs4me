package be.intec.models.entities;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ApplicationEntity implements Serializable, Comparable<ApplicationEntity> {

  private Integer id;
  private Timestamp dateOfApplication;
  private String education;
  private String experience;
  private String otherInfo;
  private Integer jobId;
  private Integer applicantId;

      public ApplicationEntity(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public ApplicationEntity withId(Integer id) {
    this.setId(id);
    return this;
  }

  public ApplicationEntity withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public ApplicationEntity withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public ApplicationEntity withoutParsedId(String id) {
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

  public ApplicationEntity withDateOfApplication(Timestamp dateOfApplication) {
    this.setDateOfApplication(dateOfApplication);
    return this;
  }

  public ApplicationEntity withParsedDateOfApplication(String dateOfApplication) {
    this.parseAndSetDateOfApplication(dateOfApplication);
    return this;
  }

  public ApplicationEntity withoutDateOfApplication( Timestamp dateOfApplication) {
    this.setDateOfApplication(null);
    return this;
  }

  public ApplicationEntity withoutParsedDateOfApplication(String dateOfApplication) {
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

  public ApplicationEntity withEducation(String education) {
    this.setEducation(education);
    return this;
  }

  public ApplicationEntity withParsedEducation(String education) {
    this.parseAndSetEducation(education);
    return this;
  }

  public ApplicationEntity withoutEducation( String education) {
    this.setEducation(null);
    return this;
  }

  public ApplicationEntity withoutParsedEducation(String education) {
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

  public ApplicationEntity withExperience(String experience) {
    this.setExperience(experience);
    return this;
  }

  public ApplicationEntity withParsedExperience(String experience) {
    this.parseAndSetExperience(experience);
    return this;
  }

  public ApplicationEntity withoutExperience( String experience) {
    this.setExperience(null);
    return this;
  }

  public ApplicationEntity withoutParsedExperience(String experience) {
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

  public ApplicationEntity withOtherInfo(String otherInfo) {
    this.setOtherInfo(otherInfo);
    return this;
  }

  public ApplicationEntity withParsedOtherInfo(String otherInfo) {
    this.parseAndSetOtherInfo(otherInfo);
    return this;
  }

  public ApplicationEntity withoutOtherInfo( String otherInfo) {
    this.setOtherInfo(null);
    return this;
  }

  public ApplicationEntity withoutParsedOtherInfo(String otherInfo) {
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

  public ApplicationEntity withJobId(Integer jobId) {
    this.setJobId(jobId);
    return this;
  }

  public ApplicationEntity withParsedJobId(String jobId) {
    this.parseAndSetJobId(jobId);
    return this;
  }

  public ApplicationEntity withoutJobId( Integer jobId) {
    this.setJobId(null);
    return this;
  }

  public ApplicationEntity withoutParsedJobId(String jobId) {
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

  public ApplicationEntity withApplicantId(Integer applicantId) {
    this.setApplicantId(applicantId);
    return this;
  }

  public ApplicationEntity withParsedApplicantId(String applicantId) {
    this.parseAndSetApplicantId(applicantId);
    return this;
  }

  public ApplicationEntity withoutApplicantId( Integer applicantId) {
    this.setApplicantId(null);
    return this;
  }

  public ApplicationEntity withoutParsedApplicantId(String applicantId) {
    this.setApplicantId(null);
    return this;
  }


    @Override
    public int compareTo(ApplicationEntity otherApplication) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicationEntity)) return false;
        ApplicationEntity otherApplication = (ApplicationEntity) obj;
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
