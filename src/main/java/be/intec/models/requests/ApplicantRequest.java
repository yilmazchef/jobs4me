package be.intec.models.requests;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ApplicantRequest implements Serializable, Comparable<ApplicantRequest> {

  private Integer id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String summary;

      public ApplicantRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public ApplicantRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public ApplicantRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public ApplicantRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public ApplicantRequest withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void parseAndSetFirstName(String firstName) {
    this.firstName = firstName;
  }

  public ApplicantRequest withFirstName(String firstName) {
    this.setFirstName(firstName);
    return this;
  }

  public ApplicantRequest withParsedFirstName(String firstName) {
    this.parseAndSetFirstName(firstName);
    return this;
  }

  public ApplicantRequest withoutFirstName( String firstName) {
    this.setFirstName(null);
    return this;
  }

  public ApplicantRequest withoutParsedFirstName(String firstName) {
    this.setFirstName(null);
    return this;
  }


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void parseAndSetLastName(String lastName) {
    this.lastName = lastName;
  }

  public ApplicantRequest withLastName(String lastName) {
    this.setLastName(lastName);
    return this;
  }

  public ApplicantRequest withParsedLastName(String lastName) {
    this.parseAndSetLastName(lastName);
    return this;
  }

  public ApplicantRequest withoutLastName( String lastName) {
    this.setLastName(null);
    return this;
  }

  public ApplicantRequest withoutParsedLastName(String lastName) {
    this.setLastName(null);
    return this;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void parseAndSetEmail(String email) {
    this.email = email;
  }

  public ApplicantRequest withEmail(String email) {
    this.setEmail(email);
    return this;
  }

  public ApplicantRequest withParsedEmail(String email) {
    this.parseAndSetEmail(email);
    return this;
  }

  public ApplicantRequest withoutEmail( String email) {
    this.setEmail(null);
    return this;
  }

  public ApplicantRequest withoutParsedEmail(String email) {
    this.setEmail(null);
    return this;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void parseAndSetPhone(String phone) {
    this.phone = phone;
  }

  public ApplicantRequest withPhone(String phone) {
    this.setPhone(phone);
    return this;
  }

  public ApplicantRequest withParsedPhone(String phone) {
    this.parseAndSetPhone(phone);
    return this;
  }

  public ApplicantRequest withoutPhone( String phone) {
    this.setPhone(null);
    return this;
  }

  public ApplicantRequest withoutParsedPhone(String phone) {
    this.setPhone(null);
    return this;
  }


  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public void parseAndSetSummary(String summary) {
    this.summary = summary;
  }

  public ApplicantRequest withSummary(String summary) {
    this.setSummary(summary);
    return this;
  }

  public ApplicantRequest withParsedSummary(String summary) {
    this.parseAndSetSummary(summary);
    return this;
  }

  public ApplicantRequest withoutSummary( String summary) {
    this.setSummary(null);
    return this;
  }

  public ApplicantRequest withoutParsedSummary(String summary) {
    this.setSummary(null);
    return this;
  }


    @Override
    public int compareTo(ApplicantRequest otherApplicant) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicantRequest)) return false;
        ApplicantRequest otherApplicant = (ApplicantRequest) obj;
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
        "id:" + this.getId()  + ", " + 
        "firstName:" + this.getFirstName()  + ", " + 
        "lastName:" + this.getLastName()  + ", " + 
        "email:" + this.getEmail()  + ", " + 
        "phone:" + this.getPhone()  + ", " + 
        "summary:" + this.getSummary()  + 
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
