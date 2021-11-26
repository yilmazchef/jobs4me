package be.intec.repositories;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;

public class JobRepository {

    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet results = null;
    
    private Connection getConnection() throws SQLException {
            Connection conn;
            conn = ConnectionFactory.getInstance().getConnection();
            return conn;
    }
    
    public int clear() {

    int rowsDeleted = 0;
    final var entities = findAll();
        for ( final JobEntity entity : entities ) {
            rowsDeleted += deleteById( entity.getId() );
        }
        
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        int rowsEffected = 0;
    
        try {
            String query = "ALTER TABLE job AUTO_INCREMENT = 0";
            connection = getConnection();
            statement = connection.prepareStatement( query );
            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if ( statement != null ) {
                    statement.close();
                }
                if ( connection != null ) {
                    connection.close();
                }
            } catch ( Exception exception ) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    
    }
    
    
    public int save( JobEntity record ) throws JobException {
    
        int rowsEffected = 0;
    
        try {
            String query = "insert into job ( code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getCode());
            statement.setString(2, record.getName());
            statement.setString(3, record.getDescription());
            statement.setTimestamp(4, record.getDatePublished());
            statement.setTimestamp(5, record.getJobStartDate());
            statement.setInt(6, record.getNoOfVacancies());
            statement.setInt(7, record.getJobCategoryId());
            statement.setInt(8, record.getJobPositionId());
            statement.setInt(9, record.getJobPlatformId());
            statement.setInt(10, record.getOrganizationId());
            statement.setInt(11, record.getProcessId());

             rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public JobEntity findById( Integer id ) throws JobException {


        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        JobEntity item = new JobEntity();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where id = ?";
            connection = getConnection();

            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            results = statement.executeQuery();
            if(results.next()){
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );
            }
        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return item;
    }

    public List<JobEntity> findAllByExample( JobEntity example ) throws JobException {

        final List<JobEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where code = ? OR name = ? OR description = ? OR date_published = ? OR job_start_date = ? OR no_of_vacancies = ? OR job_category_id = ? OR job_position_id = ? OR job_platform_id = ? OR organization_id = ? OR process_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, example.getCode() );
            statement.setString( 2, example.getName() );
            statement.setString( 3, example.getDescription() );
            statement.setTimestamp( 4, example.getDatePublished() );
            statement.setTimestamp( 5, example.getJobStartDate() );
            statement.setInt( 6, example.getNoOfVacancies() );
            statement.setInt( 7, example.getJobCategoryId() );
            statement.setInt( 8, example.getJobPositionId() );
            statement.setInt( 9, example.getJobPlatformId() );
            statement.setInt( 10, example.getOrganizationId() );
            statement.setInt( 11, example.getProcessId() );

            results = statement.executeQuery();
            while(results.next()){
            JobEntity item = new JobEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return itemList;
    }

    public List<JobEntity> findAll() throws JobException {

        final List<JobEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job ";
            connection = getConnection();
            statement = connection.prepareStatement(query);

            results = statement.executeQuery();
            while(results.next()){
                JobEntity item = new JobEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return itemList;
    }

    public int updateById( Integer id, JobEntity record ) throws JobException {

        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        if ( record == null ) {
            throw new JobException( " Job is required." ).nullJobException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job set   code  = ?,   name  = ?,   description  = ?,   date_published  = ?,   job_start_date  = ?,   no_of_vacancies  = ?,   job_category_id  = ?,   job_position_id  = ?,   job_platform_id  = ?,   organization_id  = ?,   process_id  = ? where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getCode());
            statement.setString(2, record.getName());
            statement.setString(3, record.getDescription());
            statement.setTimestamp(4, record.getDatePublished());
            statement.setTimestamp(5, record.getJobStartDate());
            statement.setInt(6, record.getNoOfVacancies());
            statement.setInt(7, record.getJobCategoryId());
            statement.setInt(8, record.getJobPositionId());
            statement.setInt(9, record.getJobPlatformId());
            statement.setInt(10, record.getOrganizationId());
            statement.setInt(11, record.getProcessId());
            statement.setInt( 12, id );

            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws JobException {


        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        int rowsEffected = 0;

        try {
            String query = "delete from job where id = ? ";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            rowsEffected = statement.executeUpdate();
        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int updateCodeById( Integer id, String code ) throws JobException {

        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        if ( code == null ) {
            throw new JobException( " code is required." ).nullJobException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job set  code  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, code );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateNameById( Integer id, String name ) throws JobException {

        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        if ( name == null ) {
            throw new JobException( " name is required." ).nullJobException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job set  name  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, name );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateDescriptionById( Integer id, String description ) throws JobException {

        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        if ( description == null ) {
            throw new JobException( " description is required." ).nullJobException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job set  description  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, description );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateDatePublishedById( Integer id, java.sql.Timestamp datePublished ) throws JobException {

        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        if ( datePublished == null ) {
            throw new JobException( " datePublished is required." ).nullJobException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job set  date_published  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp( 1, datePublished );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateJobStartDateById( Integer id, java.sql.Timestamp jobStartDate ) throws JobException {

        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        if ( jobStartDate == null ) {
            throw new JobException( " jobStartDate is required." ).nullJobException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job set  job_start_date  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp( 1, jobStartDate );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateNoOfVacanciesById( Integer id, Integer noOfVacancies ) throws JobException {

        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        if ( noOfVacancies == null ) {
            throw new JobException( " noOfVacancies is required." ).nullJobException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job set  no_of_vacancies  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, noOfVacancies );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateJobCategoryIdById( Integer id, Integer jobCategoryId ) throws JobException {

        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        if ( jobCategoryId == null ) {
            throw new JobException( " jobCategoryId is required." ).nullJobException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job set  job_category_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, jobCategoryId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateJobPositionIdById( Integer id, Integer jobPositionId ) throws JobException {

        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        if ( jobPositionId == null ) {
            throw new JobException( " jobPositionId is required." ).nullJobException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job set  job_position_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, jobPositionId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateJobPlatformIdById( Integer id, Integer jobPlatformId ) throws JobException {

        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        if ( jobPlatformId == null ) {
            throw new JobException( " jobPlatformId is required." ).nullJobException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job set  job_platform_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, jobPlatformId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateOrganizationIdById( Integer id, Integer organizationId ) throws JobException {

        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        if ( organizationId == null ) {
            throw new JobException( " organizationId is required." ).nullJobException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job set  organization_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, organizationId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateProcessIdById( Integer id, Integer processId ) throws JobException {

        if( id < 0 ) {
            throw new JobException( " Job ID is required." ).requiredFields("id");
        }

        if ( processId == null ) {
            throw new JobException( " processId is required." ).nullJobException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job set  process_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, processId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws JobException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, id );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobEntity> searchByCode( String code ) throws JobException {

        final List<JobEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where code LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, code );

            results = statement.executeQuery();

            while( results.next() ) {
            JobEntity item = new JobEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByCode( String code ) throws JobException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where code LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, code );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobEntity> searchByName( String name ) throws JobException {

        final List<JobEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where name LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, name );

            results = statement.executeQuery();

            while( results.next() ) {
            JobEntity item = new JobEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByName( String name ) throws JobException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where name LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, name );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobEntity> searchByDescription( String description ) throws JobException {

        final List<JobEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where description LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, description );

            results = statement.executeQuery();

            while( results.next() ) {
            JobEntity item = new JobEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByDescription( String description ) throws JobException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where description LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, description );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobEntity> searchByDatePublished( java.sql.Timestamp datePublished ) throws JobException {

        final List<JobEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where date_published = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp( 1, datePublished );

            results = statement.executeQuery();

            while( results.next() ) {
            JobEntity item = new JobEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByDatePublished( java.sql.Timestamp datePublished ) throws JobException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where date_published = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp( 1, datePublished );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobEntity> searchByJobStartDate( java.sql.Timestamp jobStartDate ) throws JobException {

        final List<JobEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where job_start_date = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp( 1, jobStartDate );

            results = statement.executeQuery();

            while( results.next() ) {
            JobEntity item = new JobEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByJobStartDate( java.sql.Timestamp jobStartDate ) throws JobException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where job_start_date = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp( 1, jobStartDate );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobEntity> searchByNoOfVacancies( Integer noOfVacancies ) throws JobException {

        final List<JobEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where no_of_vacancies = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, noOfVacancies );

            results = statement.executeQuery();

            while( results.next() ) {
            JobEntity item = new JobEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByNoOfVacancies( Integer noOfVacancies ) throws JobException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where no_of_vacancies = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, noOfVacancies );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobEntity> searchByJobCategoryId( Integer jobCategoryId ) throws JobException {

        final List<JobEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where job_category_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, jobCategoryId );

            results = statement.executeQuery();

            while( results.next() ) {
            JobEntity item = new JobEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByJobCategoryId( Integer jobCategoryId ) throws JobException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where job_category_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, jobCategoryId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobEntity> searchByJobPositionId( Integer jobPositionId ) throws JobException {

        final List<JobEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where job_position_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, jobPositionId );

            results = statement.executeQuery();

            while( results.next() ) {
            JobEntity item = new JobEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByJobPositionId( Integer jobPositionId ) throws JobException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where job_position_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, jobPositionId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobEntity> searchByJobPlatformId( Integer jobPlatformId ) throws JobException {

        final List<JobEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where job_platform_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, jobPlatformId );

            results = statement.executeQuery();

            while( results.next() ) {
            JobEntity item = new JobEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByJobPlatformId( Integer jobPlatformId ) throws JobException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where job_platform_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, jobPlatformId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobEntity> searchByOrganizationId( Integer organizationId ) throws JobException {

        final List<JobEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where organization_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, organizationId );

            results = statement.executeQuery();

            while( results.next() ) {
            JobEntity item = new JobEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByOrganizationId( Integer organizationId ) throws JobException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where organization_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, organizationId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobEntity> searchByProcessId( Integer processId ) throws JobException {

        final List<JobEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where process_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, processId );

            results = statement.executeQuery();

            while( results.next() ) {
            JobEntity item = new JobEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
                item.setDatePublished( results.getTimestamp("date_published") );
                item.setJobStartDate( results.getTimestamp("job_start_date") );
                item.setNoOfVacancies( results.getInt("no_of_vacancies") );
                item.setJobCategoryId( results.getInt("job_category_id") );
                item.setJobPositionId( results.getInt("job_position_id") );
                item.setJobPlatformId( results.getInt("job_platform_id") );
                item.setOrganizationId( results.getInt("organization_id") );
                item.setProcessId( results.getInt("process_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByProcessId( Integer processId ) throws JobException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description, date_published, job_start_date, no_of_vacancies, job_category_id, job_position_id, job_platform_id, organization_id, process_id from job where process_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, processId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobException(exception.getMessage());
            }
        }

        return exists;
    }


}
