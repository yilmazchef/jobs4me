package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class JobPositionService {

    private final JobPositionRepository repository;
    
    public JobPositionService() { 
        this.repository = new JobPositionRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( JobPositionEntity record ) throws JobPositionException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public JobPositionEntity findById( Integer id ) throws JobPositionException {

        final var foundJobPosition = repository.findById( id );

        return foundJobPosition;
    }

    public List<JobPositionEntity> findAllByExample( JobPositionEntity example ) throws JobPositionException {

        final List<JobPositionEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<JobPositionEntity> findAll() throws JobPositionException {

        final List<JobPositionEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, JobPositionEntity record ) throws JobPositionException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws JobPositionException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateCodeById( Integer id, String code ) throws JobPositionException {

        int rowsEffected = repository.updateCodeById( id, code );

        return rowsEffected;
    }


    public int updateNameById( Integer id, String name ) throws JobPositionException {

        int rowsEffected = repository.updateNameById( id, name );

        return rowsEffected;
    }


    public int updateDescriptionById( Integer id, String description ) throws JobPositionException {

        int rowsEffected = repository.updateDescriptionById( id, description );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws JobPositionException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<JobPositionEntity> searchByCode( String code ) throws JobPositionException {

   final List<JobPositionEntity> itemList =        repository.searchByCode( code );

        return itemList;
    }


    public boolean existsByCode( String code ) throws JobPositionException {

        boolean exists = repository.existsByCode( code );

        return exists;
    }

    public List<JobPositionEntity> searchByName( String name ) throws JobPositionException {

   final List<JobPositionEntity> itemList =        repository.searchByName( name );

        return itemList;
    }


    public boolean existsByName( String name ) throws JobPositionException {

        boolean exists = repository.existsByName( name );

        return exists;
    }

    public List<JobPositionEntity> searchByDescription( String description ) throws JobPositionException {

   final List<JobPositionEntity> itemList =        repository.searchByDescription( description );

        return itemList;
    }


    public boolean existsByDescription( String description ) throws JobPositionException {

        boolean exists = repository.existsByDescription( description );

        return exists;
    }


}
