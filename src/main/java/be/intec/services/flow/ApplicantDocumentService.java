package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class ApplicantDocumentService {

    private final ApplicantDocumentRepository repository;
    
    public ApplicantDocumentService() { 
        this.repository = new ApplicantDocumentRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( ApplicantDocumentEntity record ) throws ApplicantDocumentException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public ApplicantDocumentEntity findById( Integer id ) throws ApplicantDocumentException {

        final var foundApplicantDocument = repository.findById( id );

        return foundApplicantDocument;
    }

    public List<ApplicantDocumentEntity> findAllByExample( ApplicantDocumentEntity example ) throws ApplicantDocumentException {

        final List<ApplicantDocumentEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<ApplicantDocumentEntity> findAll() throws ApplicantDocumentException {

        final List<ApplicantDocumentEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, ApplicantDocumentEntity record ) throws ApplicantDocumentException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws ApplicantDocumentException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateDocumentIdById( Integer id, Integer documentId ) throws ApplicantDocumentException {

        int rowsEffected = repository.updateDocumentIdById( id, documentId );

        return rowsEffected;
    }


    public int updateApplicantIdById( Integer id, Integer applicantId ) throws ApplicantDocumentException {

        int rowsEffected = repository.updateApplicantIdById( id, applicantId );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws ApplicantDocumentException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<ApplicantDocumentEntity> searchByDocumentId( Integer documentId ) throws ApplicantDocumentException {

   final List<ApplicantDocumentEntity> itemList =        repository.searchByDocumentId( documentId );

        return itemList;
    }


    public boolean existsByDocumentId( Integer documentId ) throws ApplicantDocumentException {

        boolean exists = repository.existsByDocumentId( documentId );

        return exists;
    }

    public List<ApplicantDocumentEntity> searchByApplicantId( Integer applicantId ) throws ApplicantDocumentException {

   final List<ApplicantDocumentEntity> itemList =        repository.searchByApplicantId( applicantId );

        return itemList;
    }


    public boolean existsByApplicantId( Integer applicantId ) throws ApplicantDocumentException {

        boolean exists = repository.existsByApplicantId( applicantId );

        return exists;
    }


}
