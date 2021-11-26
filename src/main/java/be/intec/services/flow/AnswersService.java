package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class AnswersService {

    private final AnswersRepository repository;
    
    public AnswersService() { 
        this.repository = new AnswersRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( AnswersEntity record ) throws AnswersException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public AnswersEntity findById( Integer id ) throws AnswersException {

        final var foundAnswers = repository.findById( id );

        return foundAnswers;
    }

    public List<AnswersEntity> findAllByExample( AnswersEntity example ) throws AnswersException {

        final List<AnswersEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<AnswersEntity> findAll() throws AnswersException {

        final List<AnswersEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, AnswersEntity record ) throws AnswersException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws AnswersException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateApplicationTestIdById( Integer id, Integer applicationTestId ) throws AnswersException {

        int rowsEffected = repository.updateApplicationTestIdById( id, applicationTestId );

        return rowsEffected;
    }


    public int updateRecruiterIdById( Integer id, Integer recruiterId ) throws AnswersException {

        int rowsEffected = repository.updateRecruiterIdById( id, recruiterId );

        return rowsEffected;
    }


    public int updateTotalGradesById( Integer id, String totalGrades ) throws AnswersException {

        int rowsEffected = repository.updateTotalGradesById( id, totalGrades );

        return rowsEffected;
    }


    public int updatePassById( Integer id, String pass ) throws AnswersException {

        int rowsEffected = repository.updatePassById( id, pass );

        return rowsEffected;
    }


    public int updateAnswerDetailsById( Integer id, String answerDetails ) throws AnswersException {

        int rowsEffected = repository.updateAnswerDetailsById( id, answerDetails );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws AnswersException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<AnswersEntity> searchByApplicationTestId( Integer applicationTestId ) throws AnswersException {

   final List<AnswersEntity> itemList =        repository.searchByApplicationTestId( applicationTestId );

        return itemList;
    }


    public boolean existsByApplicationTestId( Integer applicationTestId ) throws AnswersException {

        boolean exists = repository.existsByApplicationTestId( applicationTestId );

        return exists;
    }

    public List<AnswersEntity> searchByRecruiterId( Integer recruiterId ) throws AnswersException {

   final List<AnswersEntity> itemList =        repository.searchByRecruiterId( recruiterId );

        return itemList;
    }


    public boolean existsByRecruiterId( Integer recruiterId ) throws AnswersException {

        boolean exists = repository.existsByRecruiterId( recruiterId );

        return exists;
    }

    public List<AnswersEntity> searchByTotalGrades( String totalGrades ) throws AnswersException {

   final List<AnswersEntity> itemList =        repository.searchByTotalGrades( totalGrades );

        return itemList;
    }


    public boolean existsByTotalGrades( String totalGrades ) throws AnswersException {

        boolean exists = repository.existsByTotalGrades( totalGrades );

        return exists;
    }

    public List<AnswersEntity> searchByPass( String pass ) throws AnswersException {

   final List<AnswersEntity> itemList =        repository.searchByPass( pass );

        return itemList;
    }


    public boolean existsByPass( String pass ) throws AnswersException {

        boolean exists = repository.existsByPass( pass );

        return exists;
    }

    public List<AnswersEntity> searchByAnswerDetails( String answerDetails ) throws AnswersException {

   final List<AnswersEntity> itemList =        repository.searchByAnswerDetails( answerDetails );

        return itemList;
    }


    public boolean existsByAnswerDetails( String answerDetails ) throws AnswersException {

        boolean exists = repository.existsByAnswerDetails( answerDetails );

        return exists;
    }


}
