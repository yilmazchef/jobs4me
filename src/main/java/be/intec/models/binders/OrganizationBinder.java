package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class OrganizationBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty code;
  private SimpleStringProperty name;
  private SimpleStringProperty description;


  public OrganizationBinder ( Integer _id, String _code, String _name, String _description) { 
    this.id = new SimpleIntegerProperty(_id);
    this.code = new SimpleStringProperty(_code);
    this.name = new SimpleStringProperty(_name);
    this.description = new SimpleStringProperty(_description);
  }

  public OrganizationBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public OrganizationBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public OrganizationBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public OrganizationBinder withParsedId(String _id) {
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

  public OrganizationBinder withCode(String _code) {
    this.setCode(_code);
    return this;
  }

  public OrganizationBinder withoutCode(String _code) {
    this.setCode(null);
    return this;
  }

  public OrganizationBinder withParsedCode(String _code) {
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

  public OrganizationBinder withName(String _name) {
    this.setName(_name);
    return this;
  }

  public OrganizationBinder withoutName(String _name) {
    this.setName(null);
    return this;
  }

  public OrganizationBinder withParsedName(String _name) {
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

  public OrganizationBinder withDescription(String _description) {
    this.setDescription(_description);
    return this;
  }

  public OrganizationBinder withoutDescription(String _description) {
    this.setDescription(null);
    return this;
  }

  public OrganizationBinder withParsedDescription(String _description) {
    this.parseAndSetDescription(_description);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OrganizationBinder)) return false;
        OrganizationBinder otherOrganization = (OrganizationBinder) obj;
        return 
        this.getId().equals(otherOrganization.getId()) 
 &&         this.getCode().equals(otherOrganization.getCode()) 
 &&         this.getName().equals(otherOrganization.getName()) 
 &&         this.getDescription().equals(otherOrganization.getDescription()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getCode()
,         this.getName()
,         this.getDescription()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        this.getId() + ", " + 
        this.getCode() + ", " + 
        this.getName() + ", " + 
        this.getDescription() + ", " + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getCode() == null && 
this.getName() == null && 
this.getDescription() == null );    }
}
