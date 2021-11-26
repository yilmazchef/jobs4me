package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class ApplicationStatusService {

    private final ApplicationStatusRepository repository;
    
    public ApplicationStatusService() { 
        this.repository = new ApplicationStatusRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( ApplicationStatusEntity record ) throws ApplicationStatusException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public ApplicationStatusEntity findById( Integer id ) throws ApplicationStatusException {

        final var foundApplicationStatus = repository.findById( id );

        return foundApplicationStatus;
    }

    public List<ApplicationStatusEntity> findAllByExample( ApplicationStatusEntity example ) throws ApplicationStatusException {

        final List<ApplicationStatusEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<ApplicationStatusEntity> findAll() throws ApplicationStatusException {

        final List<ApplicationStatusEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, ApplicationStatusEntity record ) throws ApplicationStatusException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws ApplicationStatusException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateStatusById( Integer id, String status ) throws ApplicationStatusException {

        int rowsEffected = repository.updateStatusById( id, status );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws ApplicationStatusException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<ApplicationStatusEntity> searchByStatus( String status ) throws ApplicationStatusException {

   final List<ApplicationStatusEntity> itemList =        repository.searchByStatus( status );

        return itemList;
    }


    public boolean existsByStatus( String status ) throws ApplicationStatusException {

        boolean exists = repository.existsByStatus( status );

        return exists;
    }


}
