package be.intec.models.entities;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

public class DocumentEntity implements Serializable, Comparable<DocumentEntity> {

  private Integer id;
  private String name;
  private String rawData;
  private String url;
  private Timestamp lastUpdated;

      public DocumentEntity(){  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void parseAndSetId(String id) {
    this.id = Integer.parseInt(id);
  }

  public DocumentEntity withId(Integer id) {
    this.setId(id);
    return this;
  }

  public DocumentEntity withParsedId(String id) {
    this.parseAndSetId(id);
    return this;
  }

  public DocumentEntity withoutId( Integer id) {
    this.setId(null);
    return this;
  }

  public DocumentEntity withoutParsedId(String id) {
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

  public DocumentEntity withName(String name) {
    this.setName(name);
    return this;
  }

  public DocumentEntity withParsedName(String name) {
    this.parseAndSetName(name);
    return this;
  }

  public DocumentEntity withoutName( String name) {
    this.setName(null);
    return this;
  }

  public DocumentEntity withoutParsedName(String name) {
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

  public DocumentEntity withRawData(String rawData) {
    this.setRawData(rawData);
    return this;
  }

  public DocumentEntity withParsedRawData(String rawData) {
    this.parseAndSetRawData(rawData);
    return this;
  }

  public DocumentEntity withoutRawData( String rawData) {
    this.setRawData(null);
    return this;
  }

  public DocumentEntity withoutParsedRawData(String rawData) {
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

  public DocumentEntity withUrl(String url) {
    this.setUrl(url);
    return this;
  }

  public DocumentEntity withParsedUrl(String url) {
    this.parseAndSetUrl(url);
    return this;
  }

  public DocumentEntity withoutUrl( String url) {
    this.setUrl(null);
    return this;
  }

  public DocumentEntity withoutParsedUrl(String url) {
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

  public DocumentEntity withLastUpdated(Timestamp lastUpdated) {
    this.setLastUpdated(lastUpdated);
    return this;
  }

  public DocumentEntity withParsedLastUpdated(String lastUpdated) {
    this.parseAndSetLastUpdated(lastUpdated);
    return this;
  }

  public DocumentEntity withoutLastUpdated( Timestamp lastUpdated) {
    this.setLastUpdated(null);
    return this;
  }

  public DocumentEntity withoutParsedLastUpdated(String lastUpdated) {
    this.setLastUpdated(null);
    return this;
  }


    @Override
    public int compareTo(DocumentEntity otherDocument) {
        // define here default comparison criteria 
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DocumentEntity)) return false;
        DocumentEntity otherDocument = (DocumentEntity) obj;
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
