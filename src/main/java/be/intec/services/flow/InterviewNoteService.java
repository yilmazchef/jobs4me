package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class InterviewNoteService {

    private final InterviewNoteRepository repository;
    
    public InterviewNoteService() { 
        this.repository = new InterviewNoteRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( InterviewNoteEntity record ) throws InterviewNoteException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public InterviewNoteEntity findById( Integer id ) throws InterviewNoteException {

        final var foundInterviewNote = repository.findById( id );

        return foundInterviewNote;
    }

    public List<InterviewNoteEntity> findAllByExample( InterviewNoteEntity example ) throws InterviewNoteException {

        final List<InterviewNoteEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<InterviewNoteEntity> findAll() throws InterviewNoteException {

        final List<InterviewNoteEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, InterviewNoteEntity record ) throws InterviewNoteException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws InterviewNoteException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateNotesById( Integer id, String notes ) throws InterviewNoteException {

        int rowsEffected = repository.updateNotesById( id, notes );

        return rowsEffected;
    }


    public int updateInterviewIdById( Integer id, Integer interviewId ) throws InterviewNoteException {

        int rowsEffected = repository.updateInterviewIdById( id, interviewId );

        return rowsEffected;
    }


    public int updateRecruiterIdById( Integer id, Integer recruiterId ) throws InterviewNoteException {

        int rowsEffected = repository.updateRecruiterIdById( id, recruiterId );

        return rowsEffected;
    }


    public int updatePassById( Integer id, String pass ) throws InterviewNoteException {

        int rowsEffected = repository.updatePassById( id, pass );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws InterviewNoteException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<InterviewNoteEntity> searchByNotes( String notes ) throws InterviewNoteException {

   final List<InterviewNoteEntity> itemList =        repository.searchByNotes( notes );

        return itemList;
    }


    public boolean existsByNotes( String notes ) throws InterviewNoteException {

        boolean exists = repository.existsByNotes( notes );

        return exists;
    }

    public List<InterviewNoteEntity> searchByInterviewId( Integer interviewId ) throws InterviewNoteException {

   final List<InterviewNoteEntity> itemList =        repository.searchByInterviewId( interviewId );

        return itemList;
    }


    public boolean existsByInterviewId( Integer interviewId ) throws InterviewNoteException {

        boolean exists = repository.existsByInterviewId( interviewId );

        return exists;
    }

    public List<InterviewNoteEntity> searchByRecruiterId( Integer recruiterId ) throws InterviewNoteException {

   final List<InterviewNoteEntity> itemList =        repository.searchByRecruiterId( recruiterId );

        return itemList;
    }


    public boolean existsByRecruiterId( Integer recruiterId ) throws InterviewNoteException {

        boolean exists = repository.existsByRecruiterId( recruiterId );

        return exists;
    }

    public List<InterviewNoteEntity> searchByPass( String pass ) throws InterviewNoteException {

   final List<InterviewNoteEntity> itemList =        repository.searchByPass( pass );

        return itemList;
    }


    public boolean existsByPass( String pass ) throws InterviewNoteException {

        boolean exists = repository.existsByPass( pass );

        return exists;
    }


}
