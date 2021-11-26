package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class ProcessStepService {

    private final ProcessStepRepository repository;
    
    public ProcessStepService() { 
        this.repository = new ProcessStepRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( ProcessStepEntity record ) throws ProcessStepException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public ProcessStepEntity findById( Integer id ) throws ProcessStepException {

        final var foundProcessStep = repository.findById( id );

        return foundProcessStep;
    }

    public List<ProcessStepEntity> findAllByExample( ProcessStepEntity example ) throws ProcessStepException {

        final List<ProcessStepEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<ProcessStepEntity> findAll() throws ProcessStepException {

        final List<ProcessStepEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, ProcessStepEntity record ) throws ProcessStepException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws ProcessStepException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateStepIdById( Integer id, Integer stepId ) throws ProcessStepException {

        int rowsEffected = repository.updateStepIdById( id, stepId );

        return rowsEffected;
    }


    public int updateProcessIdById( Integer id, Integer processId ) throws ProcessStepException {

        int rowsEffected = repository.updateProcessIdById( id, processId );

        return rowsEffected;
    }


    public int updateStatusById( Integer id, String status ) throws ProcessStepException {

        int rowsEffected = repository.updateStatusById( id, status );

        return rowsEffected;
    }


    public int updatePriorityById( Integer id, Integer priority ) throws ProcessStepException {

        int rowsEffected = repository.updatePriorityById( id, priority );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws ProcessStepException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<ProcessStepEntity> searchByStepId( Integer stepId ) throws ProcessStepException {

   final List<ProcessStepEntity> itemList =        repository.searchByStepId( stepId );

        return itemList;
    }


    public boolean existsByStepId( Integer stepId ) throws ProcessStepException {

        boolean exists = repository.existsByStepId( stepId );

        return exists;
    }

    public List<ProcessStepEntity> searchByProcessId( Integer processId ) throws ProcessStepException {

   final List<ProcessStepEntity> itemList =        repository.searchByProcessId( processId );

        return itemList;
    }


    public boolean existsByProcessId( Integer processId ) throws ProcessStepException {

        boolean exists = repository.existsByProcessId( processId );

        return exists;
    }

    public List<ProcessStepEntity> searchByStatus( String status ) throws ProcessStepException {

   final List<ProcessStepEntity> itemList =        repository.searchByStatus( status );

        return itemList;
    }


    public boolean existsByStatus( String status ) throws ProcessStepException {

        boolean exists = repository.existsByStatus( status );

        return exists;
    }

    public List<ProcessStepEntity> searchByPriority( Integer priority ) throws ProcessStepException {

   final List<ProcessStepEntity> itemList =        repository.searchByPriority( priority );

        return itemList;
    }


    public boolean existsByPriority( Integer priority ) throws ProcessStepException {

        boolean exists = repository.existsByPriority( priority );

        return exists;
    }


}
