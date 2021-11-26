package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class JobService {

    private final JobRepository repository;
    
    public JobService() { 
        this.repository = new JobRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( JobEntity record ) throws JobException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public JobEntity findById( Integer id ) throws JobException {

        final var foundJob = repository.findById( id );

        return foundJob;
    }

    public List<JobEntity> findAllByExample( JobEntity example ) throws JobException {

        final List<JobEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<JobEntity> findAll() throws JobException {

        final List<JobEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, JobEntity record ) throws JobException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws JobException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateCodeById( Integer id, String code ) throws JobException {

        int rowsEffected = repository.updateCodeById( id, code );

        return rowsEffected;
    }


    public int updateNameById( Integer id, String name ) throws JobException {

        int rowsEffected = repository.updateNameById( id, name );

        return rowsEffected;
    }


    public int updateDescriptionById( Integer id, String description ) throws JobException {

        int rowsEffected = repository.updateDescriptionById( id, description );

        return rowsEffected;
    }


    public int updateDatePublishedById( Integer id, java.sql.Timestamp datePublished ) throws JobException {

        int rowsEffected = repository.updateDatePublishedById( id, datePublished );

        return rowsEffected;
    }


    public int updateJobStartDateById( Integer id, java.sql.Timestamp jobStartDate ) throws JobException {

        int rowsEffected = repository.updateJobStartDateById( id, jobStartDate );

        return rowsEffected;
    }


    public int updateNoOfVacanciesById( Integer id, Integer noOfVacancies ) throws JobException {

        int rowsEffected = repository.updateNoOfVacanciesById( id, noOfVacancies );

        return rowsEffected;
    }


    public int updateJobCategoryIdById( Integer id, Integer jobCategoryId ) throws JobException {

        int rowsEffected = repository.updateJobCategoryIdById( id, jobCategoryId );

        return rowsEffected;
    }


    public int updateJobPositionIdById( Integer id, Integer jobPositionId ) throws JobException {

        int rowsEffected = repository.updateJobPositionIdById( id, jobPositionId );

        return rowsEffected;
    }


    public int updateJobPlatformIdById( Integer id, Integer jobPlatformId ) throws JobException {

        int rowsEffected = repository.updateJobPlatformIdById( id, jobPlatformId );

        return rowsEffected;
    }


    public int updateOrganizationIdById( Integer id, Integer organizationId ) throws JobException {

        int rowsEffected = repository.updateOrganizationIdById( id, organizationId );

        return rowsEffected;
    }


    public int updateProcessIdById( Integer id, Integer processId ) throws JobException {

        int rowsEffected = repository.updateProcessIdById( id, processId );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws JobException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<JobEntity> searchByCode( String code ) throws JobException {

   final List<JobEntity> itemList =        repository.searchByCode( code );

        return itemList;
    }


    public boolean existsByCode( String code ) throws JobException {

        boolean exists = repository.existsByCode( code );

        return exists;
    }

    public List<JobEntity> searchByName( String name ) throws JobException {

   final List<JobEntity> itemList =        repository.searchByName( name );

        return itemList;
    }


    public boolean existsByName( String name ) throws JobException {

        boolean exists = repository.existsByName( name );

        return exists;
    }

    public List<JobEntity> searchByDescription( String description ) throws JobException {

   final List<JobEntity> itemList =        repository.searchByDescription( description );

        return itemList;
    }


    public boolean existsByDescription( String description ) throws JobException {

        boolean exists = repository.existsByDescription( description );

        return exists;
    }

    public List<JobEntity> searchByDatePublished( java.sql.Timestamp datePublished ) throws JobException {

   final List<JobEntity> itemList =        repository.searchByDatePublished( datePublished );

        return itemList;
    }


    public boolean existsByDatePublished( java.sql.Timestamp datePublished ) throws JobException {

        boolean exists = repository.existsByDatePublished( datePublished );

        return exists;
    }

    public List<JobEntity> searchByJobStartDate( java.sql.Timestamp jobStartDate ) throws JobException {

   final List<JobEntity> itemList =        repository.searchByJobStartDate( jobStartDate );

        return itemList;
    }


    public boolean existsByJobStartDate( java.sql.Timestamp jobStartDate ) throws JobException {

        boolean exists = repository.existsByJobStartDate( jobStartDate );

        return exists;
    }

    public List<JobEntity> searchByNoOfVacancies( Integer noOfVacancies ) throws JobException {

   final List<JobEntity> itemList =        repository.searchByNoOfVacancies( noOfVacancies );

        return itemList;
    }


    public boolean existsByNoOfVacancies( Integer noOfVacancies ) throws JobException {

        boolean exists = repository.existsByNoOfVacancies( noOfVacancies );

        return exists;
    }

    public List<JobEntity> searchByJobCategoryId( Integer jobCategoryId ) throws JobException {

   final List<JobEntity> itemList =        repository.searchByJobCategoryId( jobCategoryId );

        return itemList;
    }


    public boolean existsByJobCategoryId( Integer jobCategoryId ) throws JobException {

        boolean exists = repository.existsByJobCategoryId( jobCategoryId );

        return exists;
    }

    public List<JobEntity> searchByJobPositionId( Integer jobPositionId ) throws JobException {

   final List<JobEntity> itemList =        repository.searchByJobPositionId( jobPositionId );

        return itemList;
    }


    public boolean existsByJobPositionId( Integer jobPositionId ) throws JobException {

        boolean exists = repository.existsByJobPositionId( jobPositionId );

        return exists;
    }

    public List<JobEntity> searchByJobPlatformId( Integer jobPlatformId ) throws JobException {

   final List<JobEntity> itemList =        repository.searchByJobPlatformId( jobPlatformId );

        return itemList;
    }


    public boolean existsByJobPlatformId( Integer jobPlatformId ) throws JobException {

        boolean exists = repository.existsByJobPlatformId( jobPlatformId );

        return exists;
    }

    public List<JobEntity> searchByOrganizationId( Integer organizationId ) throws JobException {

   final List<JobEntity> itemList =        repository.searchByOrganizationId( organizationId );

        return itemList;
    }


    public boolean existsByOrganizationId( Integer organizationId ) throws JobException {

        boolean exists = repository.existsByOrganizationId( organizationId );

        return exists;
    }

    public List<JobEntity> searchByProcessId( Integer processId ) throws JobException {

   final List<JobEntity> itemList =        repository.searchByProcessId( processId );

        return itemList;
    }


    public boolean existsByProcessId( Integer processId ) throws JobException {

        boolean exists = repository.existsByProcessId( processId );

        return exists;
    }


}
