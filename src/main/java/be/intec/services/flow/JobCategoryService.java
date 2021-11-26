package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class JobCategoryService {

    private final JobCategoryRepository repository;
    
    public JobCategoryService() { 
        this.repository = new JobCategoryRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( JobCategoryEntity record ) throws JobCategoryException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public JobCategoryEntity findById( Integer id ) throws JobCategoryException {

        final var foundJobCategory = repository.findById( id );

        return foundJobCategory;
    }

    public List<JobCategoryEntity> findAllByExample( JobCategoryEntity example ) throws JobCategoryException {

        final List<JobCategoryEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<JobCategoryEntity> findAll() throws JobCategoryException {

        final List<JobCategoryEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, JobCategoryEntity record ) throws JobCategoryException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws JobCategoryException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateCodeById( Integer id, String code ) throws JobCategoryException {

        int rowsEffected = repository.updateCodeById( id, code );

        return rowsEffected;
    }


    public int updateNameById( Integer id, String name ) throws JobCategoryException {

        int rowsEffected = repository.updateNameById( id, name );

        return rowsEffected;
    }


    public int updateDescriptionById( Integer id, String description ) throws JobCategoryException {

        int rowsEffected = repository.updateDescriptionById( id, description );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws JobCategoryException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<JobCategoryEntity> searchByCode( String code ) throws JobCategoryException {

   final List<JobCategoryEntity> itemList =        repository.searchByCode( code );

        return itemList;
    }


    public boolean existsByCode( String code ) throws JobCategoryException {

        boolean exists = repository.existsByCode( code );

        return exists;
    }

    public List<JobCategoryEntity> searchByName( String name ) throws JobCategoryException {

   final List<JobCategoryEntity> itemList =        repository.searchByName( name );

        return itemList;
    }


    public boolean existsByName( String name ) throws JobCategoryException {

        boolean exists = repository.existsByName( name );

        return exists;
    }

    public List<JobCategoryEntity> searchByDescription( String description ) throws JobCategoryException {

   final List<JobCategoryEntity> itemList =        repository.searchByDescription( description );

        return itemList;
    }


    public boolean existsByDescription( String description ) throws JobCategoryException {

        boolean exists = repository.existsByDescription( description );

        return exists;
    }


}
