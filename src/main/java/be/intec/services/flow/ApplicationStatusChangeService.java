package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class ApplicationStatusChangeService {

    private final ApplicationStatusChangeRepository repository;
    
    public ApplicationStatusChangeService() { 
        this.repository = new ApplicationStatusChangeRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( ApplicationStatusChangeEntity record ) throws ApplicationStatusChangeException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public ApplicationStatusChangeEntity findById( Integer id ) throws ApplicationStatusChangeException {

        final var foundApplicationStatusChange = repository.findById( id );

        return foundApplicationStatusChange;
    }

    public List<ApplicationStatusChangeEntity> findAllByExample( ApplicationStatusChangeEntity example ) throws ApplicationStatusChangeException {

        final List<ApplicationStatusChangeEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<ApplicationStatusChangeEntity> findAll() throws ApplicationStatusChangeException {

        final List<ApplicationStatusChangeEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, ApplicationStatusChangeEntity record ) throws ApplicationStatusChangeException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws ApplicationStatusChangeException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateDateChangedById( Integer id, java.sql.Timestamp dateChanged ) throws ApplicationStatusChangeException {

        int rowsEffected = repository.updateDateChangedById( id, dateChanged );

        return rowsEffected;
    }


    public int updateApplicationStatusIdById( Integer id, Integer applicationStatusId ) throws ApplicationStatusChangeException {

        int rowsEffected = repository.updateApplicationStatusIdById( id, applicationStatusId );

        return rowsEffected;
    }


    public int updateApplicationIdById( Integer id, Integer applicationId ) throws ApplicationStatusChangeException {

        int rowsEffected = repository.updateApplicationIdById( id, applicationId );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws ApplicationStatusChangeException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<ApplicationStatusChangeEntity> searchByDateChanged( java.sql.Timestamp dateChanged ) throws ApplicationStatusChangeException {

   final List<ApplicationStatusChangeEntity> itemList =        repository.searchByDateChanged( dateChanged );

        return itemList;
    }


    public boolean existsByDateChanged( java.sql.Timestamp dateChanged ) throws ApplicationStatusChangeException {

        boolean exists = repository.existsByDateChanged( dateChanged );

        return exists;
    }

    public List<ApplicationStatusChangeEntity> searchByApplicationStatusId( Integer applicationStatusId ) throws ApplicationStatusChangeException {

   final List<ApplicationStatusChangeEntity> itemList =        repository.searchByApplicationStatusId( applicationStatusId );

        return itemList;
    }


    public boolean existsByApplicationStatusId( Integer applicationStatusId ) throws ApplicationStatusChangeException {

        boolean exists = repository.existsByApplicationStatusId( applicationStatusId );

        return exists;
    }

    public List<ApplicationStatusChangeEntity> searchByApplicationId( Integer applicationId ) throws ApplicationStatusChangeException {

   final List<ApplicationStatusChangeEntity> itemList =        repository.searchByApplicationId( applicationId );

        return itemList;
    }


    public boolean existsByApplicationId( Integer applicationId ) throws ApplicationStatusChangeException {

        boolean exists = repository.existsByApplicationId( applicationId );

        return exists;
    }


}
