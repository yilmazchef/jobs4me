package be.intec.models.entities;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ApplicantDocumentEntity implements Serializable, Comparable<ApplicantDocumentEntity> {

  private Integer id;
  private Integer documentId;
  private Integer applicantId;

      public ApplicantDocumentEntity(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public ApplicantDocumentEntity withId(Integer id) {
    this.setId(id);
    return this;
  }

  public ApplicantDocumentEntity withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public ApplicantDocumentEntity withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public ApplicantDocumentEntity withoutParsedId(String id) {
    this.setId(null);
    return this;
  }


  public Integer getDocumentId() {
    return documentId;
  }

  public void setDocumentId(Integer documentId) {
    this.documentId = documentId;
  }

  public void parseAndSetDocumentId(String documentId) {
    this.documentId = Integer.parseInt(documentId);
  }

  public ApplicantDocumentEntity withDocumentId(Integer documentId) {
    this.setDocumentId(documentId);
    return this;
  }

  public ApplicantDocumentEntity withParsedDocumentId(String documentId) {
    this.parseAndSetDocumentId(documentId);
    return this;
  }

  public ApplicantDocumentEntity withoutDocumentId( Integer documentId) {
    this.setDocumentId(null);
    return this;
  }

  public ApplicantDocumentEntity withoutParsedDocumentId(String documentId) {
    this.setDocumentId(null);
    return this;
  }


  public Integer getApplicantId() {
    return applicantId;
  }

  public void setApplicantId(Integer applicantId) {
    this.applicantId = applicantId;
  }

  public void parseAndSetApplicantId(String applicantId) {
    this.applicantId = Integer.parseInt(applicantId);
  }

  public ApplicantDocumentEntity withApplicantId(Integer applicantId) {
    this.setApplicantId(applicantId);
    return this;
  }

  public ApplicantDocumentEntity withParsedApplicantId(String applicantId) {
    this.parseAndSetApplicantId(applicantId);
    return this;
  }

  public ApplicantDocumentEntity withoutApplicantId( Integer applicantId) {
    this.setApplicantId(null);
    return this;
  }

  public ApplicantDocumentEntity withoutParsedApplicantId(String applicantId) {
    this.setApplicantId(null);
    return this;
  }


    @Override
    public int compareTo(ApplicantDocumentEntity otherApplicantDocument) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicantDocumentEntity)) return false;
        ApplicantDocumentEntity otherApplicantDocument = (ApplicantDocumentEntity) obj;
        return 
        this.getId().equals(otherApplicantDocument.getId()) 
 &&         this.getDocumentId().equals(otherApplicantDocument.getDocumentId()) 
 &&         this.getApplicantId().equals(otherApplicantDocument.getApplicantId()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getDocumentId()
,         this.getApplicantId()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "id:" + this.getId()  + ", " + 
        "documentId:" + this.getDocumentId()  + ", " + 
        "applicantId:" + this.getApplicantId()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getDocumentId() == null && 
this.getApplicantId() == null );    }

}
