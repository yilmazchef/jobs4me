package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class JobBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty code;
  private SimpleStringProperty name;
  private SimpleStringProperty description;
  private SimpleStringProperty datePublished;
  private SimpleStringProperty jobStartDate;
  private SimpleIntegerProperty noOfVacancies;
  private SimpleIntegerProperty jobCategoryId;
  private SimpleIntegerProperty jobPositionId;
  private SimpleIntegerProperty jobPlatformId;
  private SimpleIntegerProperty organizationId;
  private SimpleIntegerProperty processId;


  public JobBinder ( Integer _id, String _code, String _name, String _description, Timestamp _datePublished, Timestamp _jobStartDate, Integer _noOfVacancies, Integer _jobCategoryId, Integer _jobPositionId, Integer _jobPlatformId, Integer _organizationId, Integer _processId) { 
    this.id = new SimpleIntegerProperty(_id);
    this.code = new SimpleStringProperty(_code);
    this.name = new SimpleStringProperty(_name);
    this.description = new SimpleStringProperty(_description);
    this.datePublished = new SimpleStringProperty(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(_datePublished));
    this.jobStartDate = new SimpleStringProperty(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(_jobStartDate));
    this.noOfVacancies = new SimpleIntegerProperty(_noOfVacancies);
    this.jobCategoryId = new SimpleIntegerProperty(_jobCategoryId);
    this.jobPositionId = new SimpleIntegerProperty(_jobPositionId);
    this.jobPlatformId = new SimpleIntegerProperty(_jobPlatformId);
    this.organizationId = new SimpleIntegerProperty(_organizationId);
    this.processId = new SimpleIntegerProperty(_processId);
  }

  public JobBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public JobBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public JobBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public JobBinder withParsedId(String _id) {
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

  public JobBinder withCode(String _code) {
    this.setCode(_code);
    return this;
  }

  public JobBinder withoutCode(String _code) {
    this.setCode(null);
    return this;
  }

  public JobBinder withParsedCode(String _code) {
    this.parseAndSetCode(_code);
    return this;
  }


  public String getName() {
    return this.name.get();
  }

  public void setName(String _name) {
    this.name.set(_name);
  }

  public void parseAndSetName(String _name) {
    this.name = new SimpleStringProperty(_name);
  }

  public JobBinder withName(String _name) {
    this.setName(_name);
    return this;
  }

  public JobBinder withoutName(String _name) {
    this.setName(null);
    return this;
  }

  public JobBinder withParsedName(String _name) {
    this.parseAndSetName(_name);
    return this;
  }


  public String getDescription() {
    return this.description.get();
  }

  public void setDescription(String _description) {
    this.description.set(_description);
  }

  public void parseAndSetDescription(String _description) {
    this.description = new SimpleStringProperty(_description);
  }

  public JobBinder withDescription(String _description) {
    this.setDescription(_description);
    return this;
  }

  public JobBinder withoutDescription(String _description) {
    this.setDescription(null);
    return this;
  }

  public JobBinder withParsedDescription(String _description) {
    this.parseAndSetDescription(_description);
    return this;
  }


  public Timestamp getDatePublished() {
    return Timestamp.valueOf(this.datePublished.get());
  }

  public void setDatePublished(Timestamp _datePublished) {
    this.datePublished.set(String.valueOf(_datePublished));
  }

  public void parseAndSetDatePublished(String _datePublished) {
    this.setDatePublished(java.sql.Timestamp.valueOf(_datePublished));
  }

  public JobBinder withDatePublished(Timestamp _datePublished) {
    this.setDatePublished(_datePublished);
    return this;
  }

  public JobBinder withoutDatePublished(Timestamp _datePublished) {
    this.setDatePublished(null);
    return this;
  }

  public JobBinder withParsedDatePublished(String _datePublished) {
    this.parseAndSetDatePublished(_datePublished);
    return this;
  }


  public Timestamp getJobStartDate() {
    return Timestamp.valueOf(this.jobStartDate.get());
  }

  public void setJobStartDate(Timestamp _jobStartDate) {
    this.jobStartDate.set(String.valueOf(_jobStartDate));
  }

  public void parseAndSetJobStartDate(String _jobStartDate) {
    this.setJobStartDate(java.sql.Timestamp.valueOf(_jobStartDate));
  }

  public JobBinder withJobStartDate(Timestamp _jobStartDate) {
    this.setJobStartDate(_jobStartDate);
    return this;
  }

  public JobBinder withoutJobStartDate(Timestamp _jobStartDate) {
    this.setJobStartDate(null);
    return this;
  }

  public JobBinder withParsedJobStartDate(String _jobStartDate) {
    this.parseAndSetJobStartDate(_jobStartDate);
    return this;
  }


  public Integer getNoOfVacancies() {
    return this.noOfVacancies.get();
  }

  public void setNoOfVacancies(Integer _noOfVacancies) {
    this.noOfVacancies.set(_noOfVacancies);
  }

  public void parseAndSetNoOfVacancies(String _noOfVacancies) {
    this.setNoOfVacancies(Integer.parseInt(_noOfVacancies));
  }

  public JobBinder withNoOfVacancies(Integer _noOfVacancies) {
    this.setNoOfVacancies(_noOfVacancies);
    return this;
  }

  public JobBinder withoutNoOfVacancies(Integer _noOfVacancies) {
    this.setNoOfVacancies(null);
    return this;
  }

  public JobBinder withParsedNoOfVacancies(String _noOfVacancies) {
    this.parseAndSetNoOfVacancies(_noOfVacancies);
    return this;
  }


  public Integer getJobCategoryId() {
    return this.jobCategoryId.get();
  }

  public void setJobCategoryId(Integer _jobCategoryId) {
    this.jobCategoryId.set(_jobCategoryId);
  }

  public void parseAndSetJobCategoryId(String _jobCategoryId) {
    this.setJobCategoryId(Integer.parseInt(_jobCategoryId));
  }

  public JobBinder withJobCategoryId(Integer _jobCategoryId) {
    this.setJobCategoryId(_jobCategoryId);
    return this;
  }

  public JobBinder withoutJobCategoryId(Integer _jobCategoryId) {
    this.setJobCategoryId(null);
    return this;
  }

  public JobBinder withParsedJobCategoryId(String _jobCategoryId) {
    this.parseAndSetJobCategoryId(_jobCategoryId);
    return this;
  }


  public Integer getJobPositionId() {
    return this.jobPositionId.get();
  }

  public void setJobPositionId(Integer _jobPositionId) {
    this.jobPositionId.set(_jobPositionId);
  }

  public void parseAndSetJobPositionId(String _jobPositionId) {
    this.setJobPositionId(Integer.parseInt(_jobPositionId));
  }

  public JobBinder withJobPositionId(Integer _jobPositionId) {
    this.setJobPositionId(_jobPositionId);
    return this;
  }

  public JobBinder withoutJobPositionId(Integer _jobPositionId) {
    this.setJobPositionId(null);
    return this;
  }

  public JobBinder withParsedJobPositionId(String _jobPositionId) {
    this.parseAndSetJobPositionId(_jobPositionId);
    return this;
  }


  public Integer getJobPlatformId() {
    return this.jobPlatformId.get();
  }

  public void setJobPlatformId(Integer _jobPlatformId) {
    this.jobPlatformId.set(_jobPlatformId);
  }

  public void parseAndSetJobPlatformId(String _jobPlatformId) {
    this.setJobPlatformId(Integer.parseInt(_jobPlatformId));
  }

  public JobBinder withJobPlatformId(Integer _jobPlatformId) {
    this.setJobPlatformId(_jobPlatformId);
    return this;
  }

  public JobBinder withoutJobPlatformId(Integer _jobPlatformId) {
    this.setJobPlatformId(null);
    return this;
  }

  public JobBinder withParsedJobPlatformId(String _jobPlatformId) {
    this.parseAndSetJobPlatformId(_jobPlatformId);
    return this;
  }


  public Integer getOrganizationId() {
    return this.organizationId.get();
  }

  public void setOrganizationId(Integer _organizationId) {
    this.organizationId.set(_organizationId);
  }

  public void parseAndSetOrganizationId(String _organizationId) {
    this.setOrganizationId(Integer.parseInt(_organizationId));
  }

  public JobBinder withOrganizationId(Integer _organizationId) {
    this.setOrganizationId(_organizationId);
    return this;
  }

  public JobBinder withoutOrganizationId(Integer _organizationId) {
    this.setOrganizationId(null);
    return this;
  }

  public JobBinder withParsedOrganizationId(String _organizationId) {
    this.parseAndSetOrganizationId(_organizationId);
    return this;
  }


  public Integer getProcessId() {
    return this.processId.get();
  }

  public void setProcessId(Integer _processId) {
    this.processId.set(_processId);
  }

  public void parseAndSetProcessId(String _processId) {
    this.setProcessId(Integer.parseInt(_processId));
  }

  public JobBinder withProcessId(Integer _processId) {
    this.setProcessId(_processId);
    return this;
  }

  public JobBinder withoutProcessId(Integer _processId) {
    this.setProcessId(null);
    return this;
  }

  public JobBinder withParsedProcessId(String _processId) {
    this.parseAndSetProcessId(_processId);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof JobBinder)) return false;
        JobBinder otherJob = (JobBinder) obj;
        return 
        this.getId().equals(otherJob.getId()) 
 &&         this.getCode().equals(otherJob.getCode()) 
 &&         this.getName().equals(otherJob.getName()) 
 &&         this.getDescription().equals(otherJob.getDescription()) 
 &&         this.getDatePublished().equals(otherJob.getDatePublished()) 
 &&         this.getJobStartDate().equals(otherJob.getJobStartDate()) 
 &&         this.getNoOfVacancies().equals(otherJob.getNoOfVacancies()) 
 &&         this.getJobCategoryId().equals(otherJob.getJobCategoryId()) 
 &&         this.getJobPositionId().equals(otherJob.getJobPositionId()) 
 &&         this.getJobPlatformId().equals(otherJob.getJobPlatformId()) 
 &&         this.getOrganizationId().equals(otherJob.getOrganizationId()) 
 &&         this.getProcessId().equals(otherJob.getProcessId()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getCode()
,         this.getName()
,         this.getDescription()
,         this.getDatePublished()
,         this.getJobStartDate()
,         this.getNoOfVacancies()
,         this.getJobCategoryId()
,         this.getJobPositionId()
,         this.getJobPlatformId()
,         this.getOrganizationId()
,         this.getProcessId()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        this.getId() + ", " + 
        this.getCode() + ", " + 
        this.getName() + ", " + 
        this.getDescription() + ", " + 
        this.getDatePublished() + ", " + 
        this.getJobStartDate() + ", " + 
        this.getNoOfVacancies() + ", " + 
        this.getJobCategoryId() + ", " + 
        this.getJobPositionId() + ", " + 
        this.getJobPlatformId() + ", " + 
        this.getOrganizationId() + ", " + 
        this.getProcessId() + ", " + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getCode() == null && 
this.getName() == null && 
this.getDescription() == null && 
this.getDatePublished() == null && 
this.getJobStartDate() == null && 
this.getNoOfVacancies() == null && 
this.getJobCategoryId() == null && 
this.getJobPositionId() == null && 
this.getJobPlatformId() == null && 
this.getOrganizationId() == null && 
this.getProcessId() == null );    }
}
