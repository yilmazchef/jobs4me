package be.intec.models.requests;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class DocumentRequest implements Serializable, Comparable<DocumentRequest> {

  private Integer id;
  private String name;
  private String rawData;
  private String url;
  private Timestamp lastUpdated;

      public DocumentRequest(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public DocumentRequest withId(Integer id) {
    this.setId(id);
    return this;
  }

  public DocumentRequest withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public DocumentRequest withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public DocumentRequest withoutParsedId(String id) {
    this.setId(null);
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

  public DocumentRequest withName(String name) {
    this.setName(name);
    return this;
  }

  public DocumentRequest withParsedName(String name) {
    this.parseAndSetName(name);
    return this;
  }

  public DocumentRequest withoutName( String name) {
    this.setName(null);
    return this;
  }

  public DocumentRequest withoutParsedName(String name) {
    this.setName(null);
    return this;
  }


  public String getRawData() {
    return rawData;
  }

  public void setRawData(String rawData) {
    this.rawData = rawData;
  }

  public void parseAndSetRawData(String rawData) {
    this.rawData = rawData;
  }

  public DocumentRequest withRawData(String rawData) {
    this.setRawData(rawData);
    return this;
  }

  public DocumentRequest withParsedRawData(String rawData) {
    this.parseAndSetRawData(rawData);
    return this;
  }

  public DocumentRequest withoutRawData( String rawData) {
    this.setRawData(null);
    return this;
  }

  public DocumentRequest withoutParsedRawData(String rawData) {
    this.setRawData(null);
    return this;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void parseAndSetUrl(String url) {
    this.url = url;
  }

  public DocumentRequest withUrl(String url) {
    this.setUrl(url);
    return this;
  }

  public DocumentRequest withParsedUrl(String url) {
    this.parseAndSetUrl(url);
    return this;
  }

  public DocumentRequest withoutUrl( String url) {
    this.setUrl(null);
    return this;
  }

  public DocumentRequest withoutParsedUrl(String url) {
    this.setUrl(null);
    return this;
  }


  public Timestamp getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Timestamp lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public void parseAndSetLastUpdated(String lastUpdated) {
    this.lastUpdated = java.sql.Timestamp.valueOf(lastUpdated);
  }

  public DocumentRequest withLastUpdated(Timestamp lastUpdated) {
    this.setLastUpdated(lastUpdated);
    return this;
  }

  public DocumentRequest withParsedLastUpdated(String lastUpdated) {
    this.parseAndSetLastUpdated(lastUpdated);
    return this;
  }

  public DocumentRequest withoutLastUpdated( Timestamp lastUpdated) {
    this.setLastUpdated(null);
    return this;
  }

  public DocumentRequest withoutParsedLastUpdated(String lastUpdated) {
    this.setLastUpdated(null);
    return this;
  }


    @Override
    public int compareTo(DocumentRequest otherDocument) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DocumentRequest)) return false;
        DocumentRequest otherDocument = (DocumentRequest) obj;
        return 
        this.getId().equals(otherDocument.getId()) 
 &&         this.getName().equals(otherDocument.getName()) 
 &&         this.getRawData().equals(otherDocument.getRawData()) 
 &&         this.getUrl().equals(otherDocument.getUrl()) 
 &&         this.getLastUpdated().equals(otherDocument.getLastUpdated()) 
;    }

    @Override
    public int hashCode() {
        return Objects.hash( 
        this.getId()
,         this.getName()
,         this.getRawData()
,         this.getUrl()
,         this.getLastUpdated()
 );    }

    @Override
    public String toString() {

        return "{ " + 
        "id:" + this.getId()  + ", " + 
        "name:" + this.getName()  + ", " + 
        "rawData:" + this.getRawData()  + ", " + 
        "url:" + this.getUrl()  + ", " + 
        "lastUpdated:" + this.getLastUpdated()  + 
    " } ";
    }

    public boolean isNew(){
        return this.getId() == null;
    }

    public boolean isEmpty(){
        return ( this.getId() == null && 
this.getName() == null && 
this.getRawData() == null && 
this.getUrl() == null && 
this.getLastUpdated() == null );    }

}
