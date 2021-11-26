package be.intec.models.requests;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class RecruiterRequest implements Serializable, Comparable<RecruiterRequest> {

  private Integer id;
  private String firstName;
  private String lastName;
  private String email;

      public RecruiterRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public RecruiterRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public RecruiterRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public RecruiterRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public RecruiterRequest withoutParsedId(String id) {
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

  public RecruiterRequest withFirstName(String firstName) {
    this.setFirstName(firstName);
    return this;
  }

  public RecruiterRequest withParsedFirstName(String firstName) {
    this.parseAndSetFirstName(firstName);
    return this;
  }

  public RecruiterRequest withoutFirstName( String firstName) {
    this.setFirstName(null);
    return this;
  }

  public RecruiterRequest withoutParsedFirstName(String firstName) {
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

  public RecruiterRequest withLastName(String lastName) {
    this.setLastName(lastName);
    return this;
  }

  public RecruiterRequest withParsedLastName(String lastName) {
    this.parseAndSetLastName(lastName);
    return this;
  }

  public RecruiterRequest withoutLastName( String lastName) {
    this.setLastName(null);
    return this;
  }

  public RecruiterRequest withoutParsedLastName(String lastName) {
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

  public RecruiterRequest withEmail(String email) {
    this.setEmail(email);
    return this;
  }

  public RecruiterRequest withParsedEmail(String email) {
    this.parseAndSetEmail(email);
    return this;
  }

  public RecruiterRequest withoutEmail( String email) {
    this.setEmail(null);
    return this;
  }

  public RecruiterRequest withoutParsedEmail(String email) {
    this.setEmail(null);
    return this;
  }


    @Override
    public int compareTo(RecruiterRequest otherRecruiter) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RecruiterRequest)) return false;
        RecruiterRequest otherRecruiter = (RecruiterRequest) obj;
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
        "id:" + this.getId()  + ", " + 
        "firstName:" + this.getFirstName()  + ", " + 
        "lastName:" + this.getLastName()  + ", " + 
        "email:" + this.getEmail()  + 
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
