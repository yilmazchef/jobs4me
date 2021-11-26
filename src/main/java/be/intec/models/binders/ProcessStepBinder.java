package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class ProcessStepBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleIntegerProperty stepId;
  private SimpleIntegerProperty processId;
  private SimpleStringProperty status;
  private SimpleIntegerProperty priority;


  public ProcessStepBinder ( Integer _id, Integer _stepId, Integer _processId, String _status, Integer _priority) { 
    this.id = new SimpleIntegerProperty(_id);
    this.stepId = new SimpleIntegerProperty(_stepId);
    this.processId = new SimpleIntegerProperty(_processId);
    this.status = new SimpleStringProperty(_status);
    this.priority = new SimpleIntegerProperty(_priority);
  }

  public ProcessStepBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public ProcessStepBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public ProcessStepBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public ProcessStepBinder withParsedId(String _id) {
    this.parseAndSetId(_id);
    return this;
  }


  public Integer getStepId() {
    return this.stepId.get();
  }

  public void setStepId(Integer _stepId) {
    this.stepId.set(_stepId);
  }

  public void parseAndSetStepId(String _stepId) {
    this.setStepId(Integer.parseInt(_stepId));
  }

  public ProcessStepBinder withStepId(Integer _stepId) {
    this.setStepId(_stepId);
    return this;
  }

  public ProcessStepBinder withoutStepId(Integer _stepId) {
    this.setStepId(null);
    return this;
  }

  public ProcessStepBinder withParsedStepId(String _stepId) {
    this.parseAndSetStepId(_stepId);
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

  public ProcessStepBinder withProcessId(Integer _processId) {
    this.setProcessId(_processId);
    return this;
  }

  public ProcessStepBinder withoutProcessId(Integer _processId) {
    this.setProcessId(null);
    return this;
  }

  public ProcessStepBinder withParsedProcessId(String _processId) {
    this.parseAndSetProcessId(_processId);
    return this;
  }


  public String getStatus() {
    return this.status.get();
  }

  public void setStatus(String _status) {
    this.status.set(_status);
  }

  public void parseAndSetStatus(String _status) {
    this.status = new SimpleStringProperty(_status);
  }

  public ProcessStepBinder withStatus(String _status) {
    this.setStatus(_status);
    return this;
  }

  public ProcessStepBinder withoutStatus(String _status) {
    this.setStatus(null);
    return this;
  }

  public ProcessStepBinder withParsedStatus(String _status) {
    this.parseAndSetStatus(_status);
    return this;
  }


  public Integer getPriority() {
    return this.priority.get();
  }

  public void setPriority(Integer _priority) {
    this.priority.set(_priority);
  }

  public void parseAndSetPriority(String _priority) {
    this.setPriority(Integer.parseInt(_priority));
  }

  public ProcessStepBinder withPriority(Integer _priority) {
    this.setPriority(_priority);
    return this;
  }

  public ProcessStepBinder withoutPriority(Integer _priority) {
    this.setPriority(null);
    return this;
  }

  public ProcessStepBinder withParsedPriority(String _priority) {
    this.parseAndSetPriority(_priority);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ProcessStepBinder)) return false;
        ProcessStepBinder otherProcessStep = (ProcessStepBinder) obj;
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
        this.getId() + ", " + 
        this.getStepId() + ", " + 
        this.getProcessId() + ", " + 
        this.getStatus() + ", " + 
        this.getPriority() + ", " + 
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
