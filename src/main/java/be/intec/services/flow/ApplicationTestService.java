package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class ApplicationTestService {

    private final ApplicationTestRepository repository;
    
    public ApplicationTestService() { 
        this.repository = new ApplicationTestRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( ApplicationTestEntity record ) throws ApplicationTestException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public ApplicationTestEntity findById( Integer id ) throws ApplicationTestException {

        final var foundApplicationTest = repository.findById( id );

        return foundApplicationTest;
    }

    public List<ApplicationTestEntity> findAllByExample( ApplicationTestEntity example ) throws ApplicationTestException {

        final List<ApplicationTestEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<ApplicationTestEntity> findAll() throws ApplicationTestException {

        final List<ApplicationTestEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, ApplicationTestEntity record ) throws ApplicationTestException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws ApplicationTestException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateTestIdById( Integer id, Integer testId ) throws ApplicationTestException {

        int rowsEffected = repository.updateTestIdById( id, testId );

        return rowsEffected;
    }


    public int updateApplicationIdById( Integer id, Integer applicationId ) throws ApplicationTestException {

        int rowsEffected = repository.updateApplicationIdById( id, applicationId );

        return rowsEffected;
    }


    public int updateStartTimeById( Integer id, java.sql.Timestamp startTime ) throws ApplicationTestException {

        int rowsEffected = repository.updateStartTimeById( id, startTime );

        return rowsEffected;
    }


    public int updateEndTimeById( Integer id, java.sql.Timestamp endTime ) throws ApplicationTestException {

        int rowsEffected = repository.updateEndTimeById( id, endTime );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws ApplicationTestException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<ApplicationTestEntity> searchByTestId( Integer testId ) throws ApplicationTestException {

   final List<ApplicationTestEntity> itemList =        repository.searchByTestId( testId );

        return itemList;
    }


    public boolean existsByTestId( Integer testId ) throws ApplicationTestException {

        boolean exists = repository.existsByTestId( testId );

        return exists;
    }

    public List<ApplicationTestEntity> searchByApplicationId( Integer applicationId ) throws ApplicationTestException {

   final List<ApplicationTestEntity> itemList =        repository.searchByApplicationId( applicationId );

        return itemList;
    }


    public boolean existsByApplicationId( Integer applicationId ) throws ApplicationTestException {

        boolean exists = repository.existsByApplicationId( applicationId );

        return exists;
    }

    public List<ApplicationTestEntity> searchByStartTime( java.sql.Timestamp startTime ) throws ApplicationTestException {

   final List<ApplicationTestEntity> itemList =        repository.searchByStartTime( startTime );

        return itemList;
    }


    public boolean existsByStartTime( java.sql.Timestamp startTime ) throws ApplicationTestException {

        boolean exists = repository.existsByStartTime( startTime );

        return exists;
    }

    public List<ApplicationTestEntity> searchByEndTime( java.sql.Timestamp endTime ) throws ApplicationTestException {

   final List<ApplicationTestEntity> itemList =        repository.searchByEndTime( endTime );

        return itemList;
    }


    public boolean existsByEndTime( java.sql.Timestamp endTime ) throws ApplicationTestException {

        boolean exists = repository.existsByEndTime( endTime );

        return exists;
    }


}
