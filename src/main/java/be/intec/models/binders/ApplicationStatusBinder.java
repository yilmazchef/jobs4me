package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class ApplicationStatusBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty status;


  public ApplicationStatusBinder ( Integer _id, String _status) { 
    this.id = new SimpleIntegerProperty(_id);
    this.status = new SimpleStringProperty(_status);
  }

  public ApplicationStatusBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public ApplicationStatusBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public ApplicationStatusBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public ApplicationStatusBinder withParsedId(String _id) {
    this.parseAndSetId(_id);
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

  public ApplicationStatusBinder withStatus(String _status) {
    this.setStatus(_status);
    return this;
  }

  public ApplicationStatusBinder withoutStatus(String _status) {
    this.setStatus(null);
    return this;
  }

  public ApplicationStatusBinder withParsedStatus(String _status) {
    this.parseAndSetStatus(_status);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicationStatusBinder)) return false;
        ApplicationStatusBinder otherApplicationStatus = (ApplicationStatusBinder) obj;
        return 
        this.getId().equals(otherApplicationStatus.getId()) 
 &&         this.getStatus().equals(otherApplicationStatus.getStatus()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getStatus()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        this.getId() + ", " + 
        this.getStatus() + ", " + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getStatus() == null );    }
}
