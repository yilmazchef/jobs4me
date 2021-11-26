package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class OrganizationService {

    private final OrganizationRepository repository;
    
    public OrganizationService() { 
        this.repository = new OrganizationRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( OrganizationEntity record ) throws OrganizationException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public OrganizationEntity findById( Integer id ) throws OrganizationException {

        final var foundOrganization = repository.findById( id );

        return foundOrganization;
    }

    public List<OrganizationEntity> findAllByExample( OrganizationEntity example ) throws OrganizationException {

        final List<OrganizationEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<OrganizationEntity> findAll() throws OrganizationException {

        final List<OrganizationEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, OrganizationEntity record ) throws OrganizationException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws OrganizationException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateCodeById( Integer id, String code ) throws OrganizationException {

        int rowsEffected = repository.updateCodeById( id, code );

        return rowsEffected;
    }


    public int updateNameById( Integer id, String name ) throws OrganizationException {

        int rowsEffected = repository.updateNameById( id, name );

        return rowsEffected;
    }


    public int updateDescriptionById( Integer id, String description ) throws OrganizationException {

        int rowsEffected = repository.updateDescriptionById( id, description );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws OrganizationException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<OrganizationEntity> searchByCode( String code ) throws OrganizationException {

   final List<OrganizationEntity> itemList =        repository.searchByCode( code );

        return itemList;
    }


    public boolean existsByCode( String code ) throws OrganizationException {

        boolean exists = repository.existsByCode( code );

        return exists;
    }

    public List<OrganizationEntity> searchByName( String name ) throws OrganizationException {

   final List<OrganizationEntity> itemList =        repository.searchByName( name );

        return itemList;
    }


    public boolean existsByName( String name ) throws OrganizationException {

        boolean exists = repository.existsByName( name );

        return exists;
    }

    public List<OrganizationEntity> searchByDescription( String description ) throws OrganizationException {

   final List<OrganizationEntity> itemList =        repository.searchByDescription( description );

        return itemList;
    }


    public boolean existsByDescription( String description ) throws OrganizationException {

        boolean exists = repository.existsByDescription( description );

        return exists;
    }


}
