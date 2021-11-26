package be.intec.models.responses;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class ApplicantDocumentRequest implements Serializable, Comparable<ApplicantDocumentRequest> {

  private Integer id;
  private Integer documentId;
  private Integer applicantId;

      public ApplicantDocumentRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public ApplicantDocumentRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public ApplicantDocumentRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public ApplicantDocumentRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public ApplicantDocumentRequest withoutParsedId(String id) {
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

  public ApplicantDocumentRequest withDocumentId(Integer documentId) {
    this.setDocumentId(documentId);
    return this;
  }

  public ApplicantDocumentRequest withParsedDocumentId(String documentId) {
    this.parseAndSetDocumentId(documentId);
    return this;
  }

  public ApplicantDocumentRequest withoutDocumentId( Integer documentId) {
    this.setDocumentId(null);
    return this;
  }

  public ApplicantDocumentRequest withoutParsedDocumentId(String documentId) {
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

  public ApplicantDocumentRequest withApplicantId(Integer applicantId) {
    this.setApplicantId(applicantId);
    return this;
  }

  public ApplicantDocumentRequest withParsedApplicantId(String applicantId) {
    this.parseAndSetApplicantId(applicantId);
    return this;
  }

  public ApplicantDocumentRequest withoutApplicantId( Integer applicantId) {
    this.setApplicantId(null);
    return this;
  }

  public ApplicantDocumentRequest withoutParsedApplicantId(String applicantId) {
    this.setApplicantId(null);
    return this;
  }


    @Override
    public int compareTo(ApplicantDocumentRequest otherApplicantDocument) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicantDocumentRequest)) return false;
        ApplicantDocumentRequest otherApplicantDocument = (ApplicantDocumentRequest) obj;
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
