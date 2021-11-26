package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class ProcessService {

    private final ProcessRepository repository;
    
    public ProcessService() { 
        this.repository = new ProcessRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( ProcessEntity record ) throws ProcessException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public ProcessEntity findById( Integer id ) throws ProcessException {

        final var foundProcess = repository.findById( id );

        return foundProcess;
    }

    public List<ProcessEntity> findAllByExample( ProcessEntity example ) throws ProcessException {

        final List<ProcessEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<ProcessEntity> findAll() throws ProcessException {

        final List<ProcessEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, ProcessEntity record ) throws ProcessException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws ProcessException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateCodeById( Integer id, String code ) throws ProcessException {

        int rowsEffected = repository.updateCodeById( id, code );

        return rowsEffected;
    }


    public int updateDescriptionById( Integer id, String description ) throws ProcessException {

        int rowsEffected = repository.updateDescriptionById( id, description );

        return rowsEffected;
    }


    public int updateRecruiterIdById( Integer id, Integer recruiterId ) throws ProcessException {

        int rowsEffected = repository.updateRecruiterIdById( id, recruiterId );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws ProcessException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<ProcessEntity> searchByCode( String code ) throws ProcessException {

   final List<ProcessEntity> itemList =        repository.searchByCode( code );

        return itemList;
    }


    public boolean existsByCode( String code ) throws ProcessException {

        boolean exists = repository.existsByCode( code );

        return exists;
    }

    public List<ProcessEntity> searchByDescription( String description ) throws ProcessException {

   final List<ProcessEntity> itemList =        repository.searchByDescription( description );

        return itemList;
    }


    public boolean existsByDescription( String description ) throws ProcessException {

        boolean exists = repository.existsByDescription( description );

        return exists;
    }

    public List<ProcessEntity> searchByRecruiterId( Integer recruiterId ) throws ProcessException {

   final List<ProcessEntity> itemList =        repository.searchByRecruiterId( recruiterId );

        return itemList;
    }


    public boolean existsByRecruiterId( Integer recruiterId ) throws ProcessException {

        boolean exists = repository.existsByRecruiterId( recruiterId );

        return exists;
    }


}
