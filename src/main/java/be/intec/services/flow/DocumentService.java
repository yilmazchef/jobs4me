package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class DocumentService {

    private final DocumentRepository repository;
    
    public DocumentService() { 
        this.repository = new DocumentRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( DocumentEntity record ) throws DocumentException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public DocumentEntity findById( Integer id ) throws DocumentException {

        final var foundDocument = repository.findById( id );

        return foundDocument;
    }

    public List<DocumentEntity> findAllByExample( DocumentEntity example ) throws DocumentException {

        final List<DocumentEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<DocumentEntity> findAll() throws DocumentException {

        final List<DocumentEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, DocumentEntity record ) throws DocumentException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws DocumentException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateNameById( Integer id, String name ) throws DocumentException {

        int rowsEffected = repository.updateNameById( id, name );

        return rowsEffected;
    }


    public int updateRawDataById( Integer id, Long rawData ) throws DocumentException {

        int rowsEffected = repository.updateRawDataById( id, rawData );

        return rowsEffected;
    }


    public int updateUrlById( Integer id, String url ) throws DocumentException {

        int rowsEffected = repository.updateUrlById( id, url );

        return rowsEffected;
    }


    public int updateLastUpdatedById( Integer id, java.sql.Timestamp lastUpdated ) throws DocumentException {

        int rowsEffected = repository.updateLastUpdatedById( id, lastUpdated );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws DocumentException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<DocumentEntity> searchByName( String name ) throws DocumentException {

   final List<DocumentEntity> itemList =        repository.searchByName( name );

        return itemList;
    }


    public boolean existsByName( String name ) throws DocumentException {

        boolean exists = repository.existsByName( name );

        return exists;
    }

    public List<DocumentEntity> searchByRawData( Long rawData ) throws DocumentException {

   final List<DocumentEntity> itemList =        repository.searchByRawData( rawData );

        return itemList;
    }


    public boolean existsByRawData( Long rawData ) throws DocumentException {

        boolean exists = repository.existsByRawData( rawData );

        return exists;
    }

    public List<DocumentEntity> searchByUrl( String url ) throws DocumentException {

   final List<DocumentEntity> itemList =        repository.searchByUrl( url );

        return itemList;
    }


    public boolean existsByUrl( String url ) throws DocumentException {

        boolean exists = repository.existsByUrl( url );

        return exists;
    }

    public List<DocumentEntity> searchByLastUpdated( java.sql.Timestamp lastUpdated ) throws DocumentException {

   final List<DocumentEntity> itemList =        repository.searchByLastUpdated( lastUpdated );

        return itemList;
    }


    public boolean existsByLastUpdated( java.sql.Timestamp lastUpdated ) throws DocumentException {

        boolean exists = repository.existsByLastUpdated( lastUpdated );

        return exists;
    }


}
