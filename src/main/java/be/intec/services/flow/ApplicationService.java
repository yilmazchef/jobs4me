package be.intec.services.flow;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;
import be.intec.repositories.*;

public class ApplicationService {

    private final ApplicationRepository repository;
    
    public ApplicationService() { 
        this.repository = new ApplicationRepository();
    }
    
    public int clear() {

        final var rowsDeleted = repository.clear();
    
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        final var rowsEffected = repository.resetSequence();

        return rowsEffected;
    
    }
    
    
    public int save( ApplicationEntity record ) throws ApplicationException {
    
        int rowsEffected = repository.save( record ); 

        return rowsEffected;
    }

    public ApplicationEntity findById( Integer id ) throws ApplicationException {

        final var foundApplication = repository.findById( id );

        return foundApplication;
    }

    public List<ApplicationEntity> findAllByExample( ApplicationEntity example ) throws ApplicationException {

        final List<ApplicationEntity> itemList = repository.findAllByExample(example);

        return itemList;
    }

    public List<ApplicationEntity> findAll() throws ApplicationException {

        final List<ApplicationEntity> itemList = repository.findAll();

        return itemList;
    }

    public int updateById( Integer id, ApplicationEntity record ) throws ApplicationException {

        int rowsEffected = repository.updateById(id, record);

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws ApplicationException {

        int rowsDeleted = repository.deleteById( id );

        return rowsDeleted;
    }

    public int updateDateOfApplicationById( Integer id, java.sql.Timestamp dateOfApplication ) throws ApplicationException {

        int rowsEffected = repository.updateDateOfApplicationById( id, dateOfApplication );

        return rowsEffected;
    }


    public int updateEducationById( Integer id, String education ) throws ApplicationException {

        int rowsEffected = repository.updateEducationById( id, education );

        return rowsEffected;
    }


    public int updateExperienceById( Integer id, String experience ) throws ApplicationException {

        int rowsEffected = repository.updateExperienceById( id, experience );

        return rowsEffected;
    }


    public int updateOtherInfoById( Integer id, String otherInfo ) throws ApplicationException {

        int rowsEffected = repository.updateOtherInfoById( id, otherInfo );

        return rowsEffected;
    }


    public int updateJobIdById( Integer id, Integer jobId ) throws ApplicationException {

        int rowsEffected = repository.updateJobIdById( id, jobId );

        return rowsEffected;
    }


    public int updateApplicantIdById( Integer id, Integer applicantId ) throws ApplicationException {

        int rowsEffected = repository.updateApplicantIdById( id, applicantId );

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws ApplicationException {

        boolean exists = repository.existsById( id );

        return exists;
    }

    public List<ApplicationEntity> searchByDateOfApplication( java.sql.Timestamp dateOfApplication ) throws ApplicationException {

   final List<ApplicationEntity> itemList =        repository.searchByDateOfApplication( dateOfApplication );

        return itemList;
    }


    public boolean existsByDateOfApplication( java.sql.Timestamp dateOfApplication ) throws ApplicationException {

        boolean exists = repository.existsByDateOfApplication( dateOfApplication );

        return exists;
    }

    public List<ApplicationEntity> searchByEducation( String education ) throws ApplicationException {

   final List<ApplicationEntity> itemList =        repository.searchByEducation( education );

        return itemList;
    }


    public boolean existsByEducation( String education ) throws ApplicationException {

        boolean exists = repository.existsByEducation( education );

        return exists;
    }

    public List<ApplicationEntity> searchByExperience( String experience ) throws ApplicationException {

   final List<ApplicationEntity> itemList =        repository.searchByExperience( experience );

        return itemList;
    }


    public boolean existsByExperience( String experience ) throws ApplicationException {

        boolean exists = repository.existsByExperience( experience );

        return exists;
    }

    public List<ApplicationEntity> searchByOtherInfo( String otherInfo ) throws ApplicationException {

   final List<ApplicationEntity> itemList =        repository.searchByOtherInfo( otherInfo );

        return itemList;
    }


    public boolean existsByOtherInfo( String otherInfo ) throws ApplicationException {

        boolean exists = repository.existsByOtherInfo( otherInfo );

        return exists;
    }

    public List<ApplicationEntity> searchByJobId( Integer jobId ) throws ApplicationException {

   final List<ApplicationEntity> itemList =        repository.searchByJobId( jobId );

        return itemList;
    }


    public boolean existsByJobId( Integer jobId ) throws ApplicationException {

        boolean exists = repository.existsByJobId( jobId );

        return exists;
    }

    public List<ApplicationEntity> searchByApplicantId( Integer applicantId ) throws ApplicationException {

   final List<ApplicationEntity> itemList =        repository.searchByApplicantId( applicantId );

        return itemList;
    }


    public boolean existsByApplicantId( Integer applicantId ) throws ApplicationException {

        boolean exists = repository.existsByApplicantId( applicantId );

        return exists;
    }


}
