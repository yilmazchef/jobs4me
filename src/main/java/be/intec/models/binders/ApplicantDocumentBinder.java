package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class ApplicantDocumentBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleIntegerProperty documentId;
  private SimpleIntegerProperty applicantId;


  public ApplicantDocumentBinder ( Integer _id, Integer _documentId, Integer _applicantId) { 
    this.id = new SimpleIntegerProperty(_id);
    this.documentId = new SimpleIntegerProperty(_documentId);
    this.applicantId = new SimpleIntegerProperty(_applicantId);
  }

  public ApplicantDocumentBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public ApplicantDocumentBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public ApplicantDocumentBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public ApplicantDocumentBinder withParsedId(String _id) {
    this.parseAndSetId(_id);
    return this;
  }


  public Integer getDocumentId() {
    return this.documentId.get();
  }

  public void setDocumentId(Integer _documentId) {
    this.documentId.set(_documentId);
  }

  public void parseAndSetDocumentId(String _documentId) {
    this.setDocumentId(Integer.parseInt(_documentId));
  }

  public ApplicantDocumentBinder withDocumentId(Integer _documentId) {
    this.setDocumentId(_documentId);
    return this;
  }

  public ApplicantDocumentBinder withoutDocumentId(Integer _documentId) {
    this.setDocumentId(null);
    return this;
  }

  public ApplicantDocumentBinder withParsedDocumentId(String _documentId) {
    this.parseAndSetDocumentId(_documentId);
    return this;
  }


  public Integer getApplicantId() {
    return this.applicantId.get();
  }

  public void setApplicantId(Integer _applicantId) {
    this.applicantId.set(_applicantId);
  }

  public void parseAndSetApplicantId(String _applicantId) {
    this.setApplicantId(Integer.parseInt(_applicantId));
  }

  public ApplicantDocumentBinder withApplicantId(Integer _applicantId) {
    this.setApplicantId(_applicantId);
    return this;
  }

  public ApplicantDocumentBinder withoutApplicantId(Integer _applicantId) {
    this.setApplicantId(null);
    return this;
  }

  public ApplicantDocumentBinder withParsedApplicantId(String _applicantId) {
    this.parseAndSetApplicantId(_applicantId);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ApplicantDocumentBinder)) return false;
        ApplicantDocumentBinder otherApplicantDocument = (ApplicantDocumentBinder) obj;
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
        this.getId() + ", " + 
        this.getDocumentId() + ", " + 
        this.getApplicantId() + ", " + 
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
