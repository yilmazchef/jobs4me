package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class TestService {

    private final TestRepository repository;
    
    public TestService() { 
        this.repository = new TestRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( TestEntity record ) throws TestException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public TestEntity findById( Integer id ) throws TestException {

        final var foundTest = repository.findById( id );

        return foundTest;
    }

    public List<TestEntity> findAllByExample( TestEntity example ) throws TestException {

        final List<TestEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<TestEntity> findAll() throws TestException {

        final List<TestEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, TestEntity record ) throws TestException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws TestException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateCodeById( Integer id, String code ) throws TestException {

        int rowsEffected = repository.updateCodeById( id, code );

        return rowsEffected;
    }


    public int updateDurationById( Integer id, Integer duration ) throws TestException {

        int rowsEffected = repository.updateDurationById( id, duration );

        return rowsEffected;
    }


    public int updateMaxScoreById( Integer id, Integer maxScore ) throws TestException {

        int rowsEffected = repository.updateMaxScoreById( id, maxScore );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws TestException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<TestEntity> searchByCode( String code ) throws TestException {

   final List<TestEntity> itemList =        repository.searchByCode( code );

        return itemList;
    }


    public boolean existsByCode( String code ) throws TestException {

        boolean exists = repository.existsByCode( code );

        return exists;
    }

    public List<TestEntity> searchByDuration( Integer duration ) throws TestException {

   final List<TestEntity> itemList =        repository.searchByDuration( duration );

        return itemList;
    }


    public boolean existsByDuration( Integer duration ) throws TestException {

        boolean exists = repository.existsByDuration( duration );

        return exists;
    }

    public List<TestEntity> searchByMaxScore( Integer maxScore ) throws TestException {

   final List<TestEntity> itemList =        repository.searchByMaxScore( maxScore );

        return itemList;
    }


    public boolean existsByMaxScore( Integer maxScore ) throws TestException {

        boolean exists = repository.existsByMaxScore( maxScore );

        return exists;
    }


}
