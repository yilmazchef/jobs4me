package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class InterviewService {

    private final InterviewRepository repository;
    
    public InterviewService() { 
        this.repository = new InterviewRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( InterviewEntity record ) throws InterviewException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public InterviewEntity findById( Integer id ) throws InterviewException {

        final var foundInterview = repository.findById( id );

        return foundInterview;
    }

    public List<InterviewEntity> findAllByExample( InterviewEntity example ) throws InterviewException {

        final List<InterviewEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<InterviewEntity> findAll() throws InterviewException {

        final List<InterviewEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, InterviewEntity record ) throws InterviewException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws InterviewException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateStartTimeById( Integer id, java.sql.Timestamp startTime ) throws InterviewException {

        int rowsEffected = repository.updateStartTimeById( id, startTime );

        return rowsEffected;
    }


    public int updateEndTimeById( Integer id, java.sql.Timestamp endTime ) throws InterviewException {

        int rowsEffected = repository.updateEndTimeById( id, endTime );

        return rowsEffected;
    }


    public int updateApplicationIdById( Integer id, Integer applicationId ) throws InterviewException {

        int rowsEffected = repository.updateApplicationIdById( id, applicationId );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws InterviewException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<InterviewEntity> searchByStartTime( java.sql.Timestamp startTime ) throws InterviewException {

   final List<InterviewEntity> itemList =        repository.searchByStartTime( startTime );

        return itemList;
    }


    public boolean existsByStartTime( java.sql.Timestamp startTime ) throws InterviewException {

        boolean exists = repository.existsByStartTime( startTime );

        return exists;
    }

    public List<InterviewEntity> searchByEndTime( java.sql.Timestamp endTime ) throws InterviewException {

   final List<InterviewEntity> itemList =        repository.searchByEndTime( endTime );

        return itemList;
    }


    public boolean existsByEndTime( java.sql.Timestamp endTime ) throws InterviewException {

        boolean exists = repository.existsByEndTime( endTime );

        return exists;
    }

    public List<InterviewEntity> searchByApplicationId( Integer applicationId ) throws InterviewException {

   final List<InterviewEntity> itemList =        repository.searchByApplicationId( applicationId );

        return itemList;
    }


    public boolean existsByApplicationId( Integer applicationId ) throws InterviewException {

        boolean exists = repository.existsByApplicationId( applicationId );

        return exists;
    }


}
