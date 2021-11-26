package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class RecruiterBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty firstName;
  private SimpleStringProperty lastName;
  private SimpleStringProperty email;


  public RecruiterBinder ( Integer _id, String _firstName, String _lastName, String _email) { 
    this.id = new SimpleIntegerProperty(_id);
    this.firstName = new SimpleStringProperty(_firstName);
    this.lastName = new SimpleStringProperty(_lastName);
    this.email = new SimpleStringProperty(_email);
  }

  public RecruiterBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public RecruiterBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public RecruiterBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public RecruiterBinder withParsedId(String _id) {
    this.parseAndSetId(_id);
    return this;
  }


  public String getFirstName() {
    return this.firstName.get();
  }

  public void setFirstName(String _firstName) {
    this.firstName.set(_firstName);
  }

  public void parseAndSetFirstName(String _firstName) {
    this.firstName = new SimpleStringProperty(_firstName);
  }

  public RecruiterBinder withFirstName(String _firstName) {
    this.setFirstName(_firstName);
    return this;
  }

  public RecruiterBinder withoutFirstName(String _firstName) {
    this.setFirstName(null);
    return this;
  }

  public RecruiterBinder withParsedFirstName(String _firstName) {
    this.parseAndSetFirstName(_firstName);
    return this;
  }


  public String getLastName() {
    return this.lastName.get();
  }

  public void setLastName(String _lastName) {
    this.lastName.set(_lastName);
  }

  public void parseAndSetLastName(String _lastName) {
    this.lastName = new SimpleStringProperty(_lastName);
  }

  public RecruiterBinder withLastName(String _lastName) {
    this.setLastName(_lastName);
    return this;
  }

  public RecruiterBinder withoutLastName(String _lastName) {
    this.setLastName(null);
    return this;
  }

  public RecruiterBinder withParsedLastName(String _lastName) {
    this.parseAndSetLastName(_lastName);
    return this;
  }


  public String getEmail() {
    return this.email.get();
  }

  public void setEmail(String _email) {
    this.email.set(_email);
  }

  public void parseAndSetEmail(String _email) {
    this.email = new SimpleStringProperty(_email);
  }

  public RecruiterBinder withEmail(String _email) {
    this.setEmail(_email);
    return this;
  }

  public RecruiterBinder withoutEmail(String _email) {
    this.setEmail(null);
    return this;
  }

  public RecruiterBinder withParsedEmail(String _email) {
    this.parseAndSetEmail(_email);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RecruiterBinder)) return false;
        RecruiterBinder otherRecruiter = (RecruiterBinder) obj;
        return 
        this.getId().equals(otherRecruiter.getId()) 
 &&         this.getFirstName().equals(otherRecruiter.getFirstName()) 
 &&         this.getLastName().equals(otherRecruiter.getLastName()) 
 &&         this.getEmail().equals(otherRecruiter.getEmail()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getFirstName()
,         this.getLastName()
,         this.getEmail()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        this.getId() + ", " + 
        this.getFirstName() + ", " + 
        this.getLastName() + ", " + 
        this.getEmail() + ", " + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getFirstName() == null && 
this.getLastName() == null && 
this.getEmail() == null );    }
}
