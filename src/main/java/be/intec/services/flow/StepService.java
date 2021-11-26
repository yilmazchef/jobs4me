package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class StepService {

    private final StepRepository repository;
    
    public StepService() { 
        this.repository = new StepRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( StepEntity record ) throws StepException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public StepEntity findById( Integer id ) throws StepException {

        final var foundStep = repository.findById( id );

        return foundStep;
    }

    public List<StepEntity> findAllByExample( StepEntity example ) throws StepException {

        final List<StepEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<StepEntity> findAll() throws StepException {

        final List<StepEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, StepEntity record ) throws StepException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws StepException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateCodeById( Integer id, String code ) throws StepException {

        int rowsEffected = repository.updateCodeById( id, code );

        return rowsEffected;
    }


    public int updateNameById( Integer id, String name ) throws StepException {

        int rowsEffected = repository.updateNameById( id, name );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws StepException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<StepEntity> searchByCode( String code ) throws StepException {

   final List<StepEntity> itemList =        repository.searchByCode( code );

        return itemList;
    }


    public boolean existsByCode( String code ) throws StepException {

        boolean exists = repository.existsByCode( code );

        return exists;
    }

    public List<StepEntity> searchByName( String name ) throws StepException {

   final List<StepEntity> itemList =        repository.searchByName( name );

        return itemList;
    }


    public boolean existsByName( String name ) throws StepException {

        boolean exists = repository.existsByName( name );

        return exists;
    }


}
