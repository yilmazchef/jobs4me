package be.intec.models.entities;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class OrganizationEntity implements Serializable, Comparable<OrganizationEntity> {

  private Integer id;
  private String code;
  private String name;
  private String description;

      public OrganizationEntity(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public OrganizationEntity withId(Integer id) {
    this.setId(id);
    return this;
  }

  public OrganizationEntity withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public OrganizationEntity withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public OrganizationEntity withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void parseAndSetCode(String code) {
    this.code = code;
  }

  public OrganizationEntity withCode(String code) {
    this.setCode(code);
    return this;
  }

  public OrganizationEntity withParsedCode(String code) {
    this.parseAndSetCode(code);
    return this;
  }

  public OrganizationEntity withoutCode( String code) {
    this.setCode(null);
    return this;
  }

  public OrganizationEntity withoutParsedCode(String code) {
    this.setCode(null);
    return this;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void parseAndSetName(String name) {
    this.name = name;
  }

  public OrganizationEntity withName(String name) {
    this.setName(name);
    return this;
  }

  public OrganizationEntity withParsedName(String name) {
    this.parseAndSetName(name);
    return this;
  }

  public OrganizationEntity withoutName( String name) {
    this.setName(null);
    return this;
  }

  public OrganizationEntity withoutParsedName(String name) {
    this.setName(null);
    return this;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void parseAndSetDescription(String description) {
    this.description = description;
  }

  public OrganizationEntity withDescription(String description) {
    this.setDescription(description);
    return this;
  }

  public OrganizationEntity withParsedDescription(String description) {
    this.parseAndSetDescription(description);
    return this;
  }

  public OrganizationEntity withoutDescription( String description) {
    this.setDescription(null);
    return this;
  }

  public OrganizationEntity withoutParsedDescription(String description) {
    this.setDescription(null);
    return this;
  }


    @Override
    public int compareTo(OrganizationEntity otherOrganization) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OrganizationEntity)) return false;
        OrganizationEntity otherOrganization = (OrganizationEntity) obj;
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
        "id:" + this.getId()  + ", " + 
        "code:" + this.getCode()  + ", " + 
        "name:" + this.getName()  + ", " + 
        "description:" + this.getDescription()  + 
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
