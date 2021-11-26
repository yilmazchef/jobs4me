package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class ApplicantService {

    private final ApplicantRepository repository;
    
    public ApplicantService() { 
        this.repository = new ApplicantRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( ApplicantEntity record ) throws ApplicantException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public ApplicantEntity findById( Integer id ) throws ApplicantException {

        final var foundApplicant = repository.findById( id );

        return foundApplicant;
    }

    public List<ApplicantEntity> findAllByExample( ApplicantEntity example ) throws ApplicantException {

        final List<ApplicantEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<ApplicantEntity> findAll() throws ApplicantException {

        final List<ApplicantEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, ApplicantEntity record ) throws ApplicantException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws ApplicantException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateFirstNameById( Integer id, String firstName ) throws ApplicantException {

        int rowsEffected = repository.updateFirstNameById( id, firstName );

        return rowsEffected;
    }


    public int updateLastNameById( Integer id, String lastName ) throws ApplicantException {

        int rowsEffected = repository.updateLastNameById( id, lastName );

        return rowsEffected;
    }


    public int updateEmailById( Integer id, String email ) throws ApplicantException {

        int rowsEffected = repository.updateEmailById( id, email );

        return rowsEffected;
    }


    public int updatePhoneById( Integer id, String phone ) throws ApplicantException {

        int rowsEffected = repository.updatePhoneById( id, phone );

        return rowsEffected;
    }


    public int updateSummaryById( Integer id, String summary ) throws ApplicantException {

        int rowsEffected = repository.updateSummaryById( id, summary );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws ApplicantException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<ApplicantEntity> searchByFirstName( String firstName ) throws ApplicantException {

   final List<ApplicantEntity> itemList =        repository.searchByFirstName( firstName );

        return itemList;
    }


    public boolean existsByFirstName( String firstName ) throws ApplicantException {

        boolean exists = repository.existsByFirstName( firstName );

        return exists;
    }

    public List<ApplicantEntity> searchByLastName( String lastName ) throws ApplicantException {

   final List<ApplicantEntity> itemList =        repository.searchByLastName( lastName );

        return itemList;
    }


    public boolean existsByLastName( String lastName ) throws ApplicantException {

        boolean exists = repository.existsByLastName( lastName );

        return exists;
    }

    public List<ApplicantEntity> searchByEmail( String email ) throws ApplicantException {

   final List<ApplicantEntity> itemList =        repository.searchByEmail( email );

        return itemList;
    }


    public boolean existsByEmail( String email ) throws ApplicantException {

        boolean exists = repository.existsByEmail( email );

        return exists;
    }

    public List<ApplicantEntity> searchByPhone( String phone ) throws ApplicantException {

   final List<ApplicantEntity> itemList =        repository.searchByPhone( phone );

        return itemList;
    }


    public boolean existsByPhone( String phone ) throws ApplicantException {

        boolean exists = repository.existsByPhone( phone );

        return exists;
    }

    public List<ApplicantEntity> searchBySummary( String summary ) throws ApplicantException {

   final List<ApplicantEntity> itemList =        repository.searchBySummary( summary );

        return itemList;
    }


    public boolean existsBySummary( String summary ) throws ApplicantException {

        boolean exists = repository.existsBySummary( summary );

        return exists;
    }


}
