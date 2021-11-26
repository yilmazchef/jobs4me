package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class ApplicantBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty firstName;
  private SimpleStringProperty lastName;
  private SimpleStringProperty email;
  private SimpleStringProperty phone;
  private SimpleStringProperty summary;


  public ApplicantBinder ( Integer _id, String _firstName, String _lastName, String _email, String _phone, String _summary) { 
    this.id = new SimpleIntegerProperty(_id);
    this.firstName = new SimpleStringProperty(_firstName);
    this.lastName = new SimpleStringProperty(_lastName);
    this.email = new SimpleStringProperty(_email);
    this.phone = new SimpleStringProperty(_phone);
    this.summary = new SimpleStringProperty(_summary);
  }

  public ApplicantBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public ApplicantBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public ApplicantBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public ApplicantBinder withParsedId(String _id) {
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

  public ApplicantBinder withFirstName(String _firstName) {
    this.setFirstName(_firstName);
    return this;
  }

  public ApplicantBinder withoutFirstName(String _firstName) {
    this.setFirstName(null);
    return this;
  }

  public ApplicantBinder withParsedFirstName(String _firstName) {
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

  public ApplicantBinder withLastName(String _lastName) {
    this.setLastName(_lastName);
    return this;
  }

  public ApplicantBinder withoutLastName(String _lastName) {
    this.setLastName(null);
    return this;
  }

  public ApplicantBinder withParsedLastName(String _lastName) {
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

  public ApplicantBinder withEmail(String _email) {
    this.setEmail(_email);
    return this;
  }

  public ApplicantBinder withoutEmail(String _email) {
    this.setEmail(null);
    return this;
  }

  public ApplicantBinder withParsedEmail(String _email) {
    this.parseAndSetEmail(_email);
    return this;
  }


  public String getPhone() {
    return this.phone.get();
  }

  public void setPhone(String _phone) {
    this.phone.set(_phone);
  }

  public void parseAndSetPhone(String _phone) {
    this.phone = new SimpleStringProperty(_phone);
  }

  public ApplicantBinder withPhone(String _phone) {
    this.setPhone(_phone);
    return this;
  }

  public ApplicantBinder withoutPhone(String _phone) {
    this.setPhone(null);
    return this;
  }

  public ApplicantBinder withParsedPhone(String _phone) {
    this.parseAndSetPhone(_phone);
    return this;
  }


  public String getSummary() {
    return this.summary.get();
  }

  public void setSummary(String _summary) {
    this.summary.set(_summary);
  }

  public void parseAndSetSummary(String _summary) {
    this.summary = new SimpleStringProperty(_summary);
  }

  public ApplicantBinder withSummary(String _summary) {
    this.setSummary(_summary);
    return this;
  }

  public ApplicantBinder withoutSummary(String _summary) {
    this.setSummary(null);
    return this;
  }

  public ApplicantBinder withParsedSummary(String _summary) {
    this.parseAndSetSummary(_summary);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicantBinder)) return false;
        ApplicantBinder otherApplicant = (ApplicantBinder) obj;
        return 
        this.getId().equals(otherApplicant.getId()) 
 &&         this.getFirstName().equals(otherApplicant.getFirstName()) 
 &&         this.getLastName().equals(otherApplicant.getLastName()) 
 &&         this.getEmail().equals(otherApplicant.getEmail()) 
 &&         this.getPhone().equals(otherApplicant.getPhone()) 
 &&         this.getSummary().equals(otherApplicant.getSummary()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getFirstName()
,         this.getLastName()
,         this.getEmail()
,         this.getPhone()
,         this.getSummary()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        this.getId() + ", " + 
        this.getFirstName() + ", " + 
        this.getLastName() + ", " + 
        this.getEmail() + ", " + 
        this.getPhone() + ", " + 
        this.getSummary() + ", " + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getFirstName() == null && 
this.getLastName() == null && 
this.getEmail() == null && 
this.getPhone() == null && 
this.getSummary() == null );    }
}
