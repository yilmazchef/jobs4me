package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class ApplicationStatusChangeBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty dateChanged;
  private SimpleIntegerProperty applicationStatusId;
  private SimpleIntegerProperty applicationId;


  public ApplicationStatusChangeBinder ( Integer _id, Timestamp _dateChanged, Integer _applicationStatusId, Integer _applicationId) { 
    this.id = new SimpleIntegerProperty(_id);
    this.dateChanged = new SimpleStringProperty(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(_dateChanged));
    this.applicationStatusId = new SimpleIntegerProperty(_applicationStatusId);
    this.applicationId = new SimpleIntegerProperty(_applicationId);
  }

  public ApplicationStatusChangeBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public ApplicationStatusChangeBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public ApplicationStatusChangeBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public ApplicationStatusChangeBinder withParsedId(String _id) {
    this.parseAndSetId(_id);
    return this;
  }


  public Timestamp getDateChanged() {
    return Timestamp.valueOf(this.dateChanged.get());
  }

  public void setDateChanged(Timestamp _dateChanged) {
    this.dateChanged.set(String.valueOf(_dateChanged));
  }

  public void parseAndSetDateChanged(String _dateChanged) {
    this.setDateChanged(java.sql.Timestamp.valueOf(_dateChanged));
  }

  public ApplicationStatusChangeBinder withDateChanged(Timestamp _dateChanged) {
    this.setDateChanged(_dateChanged);
    return this;
  }

  public ApplicationStatusChangeBinder withoutDateChanged(Timestamp _dateChanged) {
    this.setDateChanged(null);
    return this;
  }

  public ApplicationStatusChangeBinder withParsedDateChanged(String _dateChanged) {
    this.parseAndSetDateChanged(_dateChanged);
    return this;
  }


  public Integer getApplicationStatusId() {
    return this.applicationStatusId.get();
  }

  public void setApplicationStatusId(Integer _applicationStatusId) {
    this.applicationStatusId.set(_applicationStatusId);
  }

  public void parseAndSetApplicationStatusId(String _applicationStatusId) {
    this.setApplicationStatusId(Integer.parseInt(_applicationStatusId));
  }

  public ApplicationStatusChangeBinder withApplicationStatusId(Integer _applicationStatusId) {
    this.setApplicationStatusId(_applicationStatusId);
    return this;
  }

  public ApplicationStatusChangeBinder withoutApplicationStatusId(Integer _applicationStatusId) {
    this.setApplicationStatusId(null);
    return this;
  }

  public ApplicationStatusChangeBinder withParsedApplicationStatusId(String _applicationStatusId) {
    this.parseAndSetApplicationStatusId(_applicationStatusId);
    return this;
  }


  public Integer getApplicationId() {
    return this.applicationId.get();
  }

  public void setApplicationId(Integer _applicationId) {
    this.applicationId.set(_applicationId);
  }

  public void parseAndSetApplicationId(String _applicationId) {
    this.setApplicationId(Integer.parseInt(_applicationId));
  }

  public ApplicationStatusChangeBinder withApplicationId(Integer _applicationId) {
    this.setApplicationId(_applicationId);
    return this;
  }

  public ApplicationStatusChangeBinder withoutApplicationId(Integer _applicationId) {
    this.setApplicationId(null);
    return this;
  }

  public ApplicationStatusChangeBinder withParsedApplicationId(String _applicationId) {
    this.parseAndSetApplicationId(_applicationId);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicationStatusChangeBinder)) return false;
        ApplicationStatusChangeBinder otherApplicationStatusChange = (ApplicationStatusChangeBinder) obj;
        return 
        this.getId().equals(otherApplicationStatusChange.getId()) 
 &&         this.getDateChanged().equals(otherApplicationStatusChange.getDateChanged()) 
 &&         this.getApplicationStatusId().equals(otherApplicationStatusChange.getApplicationStatusId()) 
 &&         this.getApplicationId().equals(otherApplicationStatusChange.getApplicationId()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getDateChanged()
,         this.getApplicationStatusId()
,         this.getApplicationId()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        this.getId() + ", " + 
        this.getDateChanged() + ", " + 
        this.getApplicationStatusId() + ", " + 
        this.getApplicationId() + ", " + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getDateChanged() == null && 
this.getApplicationStatusId() == null && 
this.getApplicationId() == null );    }
}
