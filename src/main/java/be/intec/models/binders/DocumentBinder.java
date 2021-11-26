package be.intec.models.binders;

import javafx.beans.property.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.text.*;

public class DocumentBinder implements Serializable {

  private SimpleIntegerProperty id;
  private SimpleStringProperty name;
  private SimpleStringProperty rawData;
  private SimpleStringProperty url;
  private SimpleStringProperty lastUpdated;


  public DocumentBinder ( Integer _id, String _name, String _rawData, String _url, Timestamp _lastUpdated) { 
    this.id = new SimpleIntegerProperty(_id);
    this.name = new SimpleStringProperty(_name);
    this.rawData = new SimpleStringProperty(_rawData);
    this.url = new SimpleStringProperty(_url);
    this.lastUpdated = new SimpleStringProperty(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(_lastUpdated));
  }

  public DocumentBinder(){ }

  public Integer getId() {
    return this.id.get();
  }

  public void setId(Integer _id) {
    this.id.set(_id);
  }

  public void parseAndSetId(String _id) {
    this.setId(Integer.parseInt(_id));
  }

  public DocumentBinder withId(Integer _id) {
    this.setId(_id);
    return this;
  }

  public DocumentBinder withoutId(Integer _id) {
    this.setId(null);
    return this;
  }

  public DocumentBinder withParsedId(String _id) {
    this.parseAndSetId(_id);
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

  public DocumentBinder withName(String _name) {
    this.setName(_name);
    return this;
  }

  public DocumentBinder withoutName(String _name) {
    this.setName(null);
    return this;
  }

  public DocumentBinder withParsedName(String _name) {
    this.parseAndSetName(_name);
    return this;
  }


  public String getRawData() {
    return this.rawData.get();
  }

  public void setRawData(String _rawData) {
    this.rawData.set(_rawData);
  }

  public void parseAndSetRawData(String _rawData) {
    this.rawData = new SimpleStringProperty(_rawData);
  }

  public DocumentBinder withRawData(String _rawData) {
    this.setRawData(_rawData);
    return this;
  }

  public DocumentBinder withoutRawData(String _rawData) {
    this.setRawData(null);
    return this;
  }

  public DocumentBinder withParsedRawData(String _rawData) {
    this.parseAndSetRawData(_rawData);
    return this;
  }


  public String getUrl() {
    return this.url.get();
  }

  public void setUrl(String _url) {
    this.url.set(_url);
  }

  public void parseAndSetUrl(String _url) {
    this.url = new SimpleStringProperty(_url);
  }

  public DocumentBinder withUrl(String _url) {
    this.setUrl(_url);
    return this;
  }

  public DocumentBinder withoutUrl(String _url) {
    this.setUrl(null);
    return this;
  }

  public DocumentBinder withParsedUrl(String _url) {
    this.parseAndSetUrl(_url);
    return this;
  }


  public Timestamp getLastUpdated() {
    return Timestamp.valueOf(this.lastUpdated.get());
  }

  public void setLastUpdated(Timestamp _lastUpdated) {
    this.lastUpdated.set(String.valueOf(_lastUpdated));
  }

  public void parseAndSetLastUpdated(String _lastUpdated) {
    this.setLastUpdated(java.sql.Timestamp.valueOf(_lastUpdated));
  }

  public DocumentBinder withLastUpdated(Timestamp _lastUpdated) {
    this.setLastUpdated(_lastUpdated);
    return this;
  }

  public DocumentBinder withoutLastUpdated(Timestamp _lastUpdated) {
    this.setLastUpdated(null);
    return this;
  }

  public DocumentBinder withParsedLastUpdated(String _lastUpdated) {
    this.parseAndSetLastUpdated(_lastUpdated);
    return this;
  }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DocumentBinder)) return false;
        DocumentBinder otherDocument = (DocumentBinder) obj;
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
        this.getId() + ", " + 
        this.getName() + ", " + 
        this.getRawData() + ", " + 
        this.getUrl() + ", " + 
        this.getLastUpdated() + ", " + 
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
