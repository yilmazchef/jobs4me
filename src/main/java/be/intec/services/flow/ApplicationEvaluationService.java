package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class ApplicationEvaluationService {

    private final ApplicationEvaluationRepository repository;
    
    public ApplicationEvaluationService() { 
        this.repository = new ApplicationEvaluationRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( ApplicationEvaluationEntity record ) throws ApplicationEvaluationException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public ApplicationEvaluationEntity findById( Integer id ) throws ApplicationEvaluationException {

        final var foundApplicationEvaluation = repository.findById( id );

        return foundApplicationEvaluation;
    }

    public List<ApplicationEvaluationEntity> findAllByExample( ApplicationEvaluationEntity example ) throws ApplicationEvaluationException {

        final List<ApplicationEvaluationEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<ApplicationEvaluationEntity> findAll() throws ApplicationEvaluationException {

        final List<ApplicationEvaluationEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, ApplicationEvaluationEntity record ) throws ApplicationEvaluationException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws ApplicationEvaluationException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateNotesById( Integer id, String notes ) throws ApplicationEvaluationException {

        int rowsEffected = repository.updateNotesById( id, notes );

        return rowsEffected;
    }


    public int updateRecruiterIdById( Integer id, Integer recruiterId ) throws ApplicationEvaluationException {

        int rowsEffected = repository.updateRecruiterIdById( id, recruiterId );

        return rowsEffected;
    }


    public int updateApplicationIdById( Integer id, Integer applicationId ) throws ApplicationEvaluationException {

        int rowsEffected = repository.updateApplicationIdById( id, applicationId );

        return rowsEffected;
    }


    public int updateHiredById( Integer id, String hired ) throws ApplicationEvaluationException {

        int rowsEffected = repository.updateHiredById( id, hired );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws ApplicationEvaluationException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<ApplicationEvaluationEntity> searchByNotes( String notes ) throws ApplicationEvaluationException {

   final List<ApplicationEvaluationEntity> itemList =        repository.searchByNotes( notes );

        return itemList;
    }


    public boolean existsByNotes( String notes ) throws ApplicationEvaluationException {

        boolean exists = repository.existsByNotes( notes );

        return exists;
    }

    public List<ApplicationEvaluationEntity> searchByRecruiterId( Integer recruiterId ) throws ApplicationEvaluationException {

   final List<ApplicationEvaluationEntity> itemList =        repository.searchByRecruiterId( recruiterId );

        return itemList;
    }


    public boolean existsByRecruiterId( Integer recruiterId ) throws ApplicationEvaluationException {

        boolean exists = repository.existsByRecruiterId( recruiterId );

        return exists;
    }

    public List<ApplicationEvaluationEntity> searchByApplicationId( Integer applicationId ) throws ApplicationEvaluationException {

   final List<ApplicationEvaluationEntity> itemList =        repository.searchByApplicationId( applicationId );

        return itemList;
    }


    public boolean existsByApplicationId( Integer applicationId ) throws ApplicationEvaluationException {

        boolean exists = repository.existsByApplicationId( applicationId );

        return exists;
    }

    public List<ApplicationEvaluationEntity> searchByHired( String hired ) throws ApplicationEvaluationException {

   final List<ApplicationEvaluationEntity> itemList =        repository.searchByHired( hired );

        return itemList;
    }


    public boolean existsByHired( String hired ) throws ApplicationEvaluationException {

        boolean exists = repository.existsByHired( hired );

        return exists;
    }


}
