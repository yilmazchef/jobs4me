package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class JobPlatformService {

    private final JobPlatformRepository repository;
    
    public JobPlatformService() { 
        this.repository = new JobPlatformRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( JobPlatformEntity record ) throws JobPlatformException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public JobPlatformEntity findById( Integer id ) throws JobPlatformException {

        final var foundJobPlatform = repository.findById( id );

        return foundJobPlatform;
    }

    public List<JobPlatformEntity> findAllByExample( JobPlatformEntity example ) throws JobPlatformException {

        final List<JobPlatformEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<JobPlatformEntity> findAll() throws JobPlatformException {

        final List<JobPlatformEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, JobPlatformEntity record ) throws JobPlatformException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws JobPlatformException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateCodeById( Integer id, String code ) throws JobPlatformException {

        int rowsEffected = repository.updateCodeById( id, code );

        return rowsEffected;
    }


    public int updateNameById( Integer id, String name ) throws JobPlatformException {

        int rowsEffected = repository.updateNameById( id, name );

        return rowsEffected;
    }


    public int updateDescriptionById( Integer id, String description ) throws JobPlatformException {

        int rowsEffected = repository.updateDescriptionById( id, description );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws JobPlatformException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<JobPlatformEntity> searchByCode( String code ) throws JobPlatformException {

   final List<JobPlatformEntity> itemList =        repository.searchByCode( code );

        return itemList;
    }


    public boolean existsByCode( String code ) throws JobPlatformException {

        boolean exists = repository.existsByCode( code );

        return exists;
    }

    public List<JobPlatformEntity> searchByName( String name ) throws JobPlatformException {

   final List<JobPlatformEntity> itemList =        repository.searchByName( name );

        return itemList;
    }


    public boolean existsByName( String name ) throws JobPlatformException {

        boolean exists = repository.existsByName( name );

        return exists;
    }

    public List<JobPlatformEntity> searchByDescription( String description ) throws JobPlatformException {

   final List<JobPlatformEntity> itemList =        repository.searchByDescription( description );

        return itemList;
    }


    public boolean existsByDescription( String description ) throws JobPlatformException {

        boolean exists = repository.existsByDescription( description );

        return exists;
    }


}
