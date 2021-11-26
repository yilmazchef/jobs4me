package be.intec.models.entities;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ProcessStepEntity implements Serializable, Comparable<ProcessStepEntity> {

  private Integer id;
  private Integer stepId;
  private Integer processId;
  private String status;
  private Integer priority;

      public ProcessStepEntity(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public ProcessStepEntity withId(Integer id) {
    this.setId(id);
    return this;
  }

  public ProcessStepEntity withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public ProcessStepEntity withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public ProcessStepEntity withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public Integer getStepId() {
    return stepId;
  }

  public void setStepId(Integer stepId) {
    this.stepId = stepId;
  }

  public void parseAndSetStepId(String stepId) {
    this.stepId = Integer.parseInt(stepId);
  }

  public ProcessStepEntity withStepId(Integer stepId) {
    this.setStepId(stepId);
    return this;
  }

  public ProcessStepEntity withParsedStepId(String stepId) {
    this.parseAndSetStepId(stepId);
    return this;
  }

  public ProcessStepEntity withoutStepId( Integer stepId) {
    this.setStepId(null);
    return this;
  }

  public ProcessStepEntity withoutParsedStepId(String stepId) {
    this.setStepId(null);
    return this;
  }


  public Integer getProcessId() {
    return processId;
  }

  public void setProcessId(Integer processId) {
    this.processId = processId;
  }

  public void parseAndSetProcessId(String processId) {
    this.processId = Integer.parseInt(processId);
  }

  public ProcessStepEntity withProcessId(Integer processId) {
    this.setProcessId(processId);
    return this;
  }

  public ProcessStepEntity withParsedProcessId(String processId) {
    this.parseAndSetProcessId(processId);
    return this;
  }

  public ProcessStepEntity withoutProcessId( Integer processId) {
    this.setProcessId(null);
    return this;
  }

  public ProcessStepEntity withoutParsedProcessId(String processId) {
    this.setProcessId(null);
    return this;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void parseAndSetStatus(String status) {
    this.status = status;
  }

  public ProcessStepEntity withStatus(String status) {
    this.setStatus(status);
    return this;
  }

  public ProcessStepEntity withParsedStatus(String status) {
    this.parseAndSetStatus(status);
    return this;
  }

  public ProcessStepEntity withoutStatus( String status) {
    this.setStatus(null);
    return this;
  }

  public ProcessStepEntity withoutParsedStatus(String status) {
    this.setStatus(null);
    return this;
  }


  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public void parseAndSetPriority(String priority) {
    this.priority = Integer.parseInt(priority);
  }

  public ProcessStepEntity withPriority(Integer priority) {
    this.setPriority(priority);
    return this;
  }

  public ProcessStepEntity withParsedPriority(String priority) {
    this.parseAndSetPriority(priority);
    return this;
  }

  public ProcessStepEntity withoutPriority( Integer priority) {
    this.setPriority(null);
    return this;
  }

  public ProcessStepEntity withoutParsedPriority(String priority) {
    this.setPriority(null);
    return this;
  }


    @Override
    public int compareTo(ProcessStepEntity otherProcessStep) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ProcessStepEntity)) return false;
        ProcessStepEntity otherProcessStep = (ProcessStepEntity) obj;
        return 
        this.getId().equals(otherProcessStep.getId()) 
 &&         this.getStepId().equals(otherProcessStep.getStepId()) 
 &&         this.getProcessId().equals(otherProcessStep.getProcessId()) 
 &&         this.getStatus().equals(otherProcessStep.getStatus()) 
 &&         this.getPriority().equals(otherProcessStep.getPriority()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getStepId()
,         this.getProcessId()
,         this.getStatus()
,         this.getPriority()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "id:" + this.getId()  + ", " + 
        "stepId:" + this.getStepId()  + ", " + 
        "processId:" + this.getProcessId()  + ", " + 
        "status:" + this.getStatus()  + ", " + 
        "priority:" + this.getPriority()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getStepId() == null && 
this.getProcessId() == null && 
this.getStatus() == null && 
this.getPriority() == null );    }

}
