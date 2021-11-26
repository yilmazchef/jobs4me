package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class RecruiterService {

    private final RecruiterRepository repository;
    
    public RecruiterService() { 
        this.repository = new RecruiterRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( RecruiterEntity record ) throws RecruiterException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public RecruiterEntity findById( Integer id ) throws RecruiterException {

        final var foundRecruiter = repository.findById( id );

        return foundRecruiter;
    }

    public List<RecruiterEntity> findAllByExample( RecruiterEntity example ) throws RecruiterException {

        final List<RecruiterEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<RecruiterEntity> findAll() throws RecruiterException {

        final List<RecruiterEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, RecruiterEntity record ) throws RecruiterException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws RecruiterException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateFirstNameById( Integer id, String firstName ) throws RecruiterException {

        int rowsEffected = repository.updateFirstNameById( id, firstName );

        return rowsEffected;
    }


    public int updateLastNameById( Integer id, String lastName ) throws RecruiterException {

        int rowsEffected = repository.updateLastNameById( id, lastName );

        return rowsEffected;
    }


    public int updateEmailById( Integer id, String email ) throws RecruiterException {

        int rowsEffected = repository.updateEmailById( id, email );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws RecruiterException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<RecruiterEntity> searchByFirstName( String firstName ) throws RecruiterException {

   final List<RecruiterEntity> itemList =        repository.searchByFirstName( firstName );

        return itemList;
    }


    public boolean existsByFirstName( String firstName ) throws RecruiterException {

        boolean exists = repository.existsByFirstName( firstName );

        return exists;
    }

    public List<RecruiterEntity> searchByLastName( String lastName ) throws RecruiterException {

   final List<RecruiterEntity> itemList =        repository.searchByLastName( lastName );

        return itemList;
    }


    public boolean existsByLastName( String lastName ) throws RecruiterException {

        boolean exists = repository.existsByLastName( lastName );

        return exists;
    }

    public List<RecruiterEntity> searchByEmail( String email ) throws RecruiterException {

   final List<RecruiterEntity> itemList =        repository.searchByEmail( email );

        return itemList;
    }


    public boolean existsByEmail( String email ) throws RecruiterException {

        boolean exists = repository.existsByEmail( email );

        return exists;
    }


}
