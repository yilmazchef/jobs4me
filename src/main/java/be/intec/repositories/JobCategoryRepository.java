package be.intec.repositories;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;

public class JobCategoryRepository {

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
        for ( final JobCategoryEntity entity : entities ) {
            rowsDeleted += deleteById( entity.getId() );
        }
        
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        int rowsEffected = 0;
    
        try {
            String query = "ALTER TABLE job_category AUTO_INCREMENT = 0";
            connection = getConnection();
            statement = connection.prepareStatement( query );
            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if ( statement != null ) {
                    statement.close();
                }
                if ( connection != null ) {
                    connection.close();
                }
            } catch ( Exception exception ) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return rowsEffected;
    
    }
    
    
    public int save( JobCategoryEntity record ) throws JobCategoryException {
    
        int rowsEffected = 0;
    
        try {
            String query = "insert into job_category ( code, name, description ) values ( ?, ?, ? )";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getCode());
            statement.setString(2, record.getName());
            statement.setString(3, record.getDescription());

             rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public JobCategoryEntity findById( Integer id ) throws JobCategoryException {


        if( id < 0 ) {
            throw new JobCategoryException( " JobCategory ID is required." ).requiredFields("id");
        }

        JobCategoryEntity item = new JobCategoryEntity();

        try {
            String query = "select id, code, name, description from job_category where id = ?";
            connection = getConnection();

            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            results = statement.executeQuery();
            if(results.next()){
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );
            }
        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return item;
    }

    public List<JobCategoryEntity> findAllByExample( JobCategoryEntity example ) throws JobCategoryException {

        final List<JobCategoryEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from job_category where code = ? OR name = ? OR description = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, example.getCode() );
            statement.setString( 2, example.getName() );
            statement.setString( 3, example.getDescription() );

            results = statement.executeQuery();
            while(results.next()){
            JobCategoryEntity item = new JobCategoryEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return itemList;
    }

    public List<JobCategoryEntity> findAll() throws JobCategoryException {

        final List<JobCategoryEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from job_category ";
            connection = getConnection();
            statement = connection.prepareStatement(query);

            results = statement.executeQuery();
            while(results.next()){
                JobCategoryEntity item = new JobCategoryEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return itemList;
    }

    public int updateById( Integer id, JobCategoryEntity record ) throws JobCategoryException {

        if( id < 0 ) {
            throw new JobCategoryException( " JobCategory ID is required." ).requiredFields("id");
        }

        if ( record == null ) {
            throw new JobCategoryException( " JobCategory is required." ).nullJobCategoryException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job_category set   code  = ?,   name  = ?,   description  = ? where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getCode());
            statement.setString(2, record.getName());
            statement.setString(3, record.getDescription());
            statement.setInt( 4, id );

            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws JobCategoryException {


        if( id < 0 ) {
            throw new JobCategoryException( " JobCategory ID is required." ).requiredFields("id");
        }

        int rowsEffected = 0;

        try {
            String query = "delete from job_category where id = ? ";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            rowsEffected = statement.executeUpdate();
        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int updateCodeById( Integer id, String code ) throws JobCategoryException {

        if( id < 0 ) {
            throw new JobCategoryException( " JobCategory ID is required." ).requiredFields("id");
        }

        if ( code == null ) {
            throw new JobCategoryException( " code is required." ).nullJobCategoryException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job_category set  code  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, code );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateNameById( Integer id, String name ) throws JobCategoryException {

        if( id < 0 ) {
            throw new JobCategoryException( " JobCategory ID is required." ).requiredFields("id");
        }

        if ( name == null ) {
            throw new JobCategoryException( " name is required." ).nullJobCategoryException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job_category set  name  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, name );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateDescriptionById( Integer id, String description ) throws JobCategoryException {

        if( id < 0 ) {
            throw new JobCategoryException( " JobCategory ID is required." ).requiredFields("id");
        }

        if ( description == null ) {
            throw new JobCategoryException( " description is required." ).nullJobCategoryException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job_category set  description  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, description );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws JobCategoryException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description from job_category where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, id );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobCategoryEntity> searchByCode( String code ) throws JobCategoryException {

        final List<JobCategoryEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from job_category where code LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, code );

            results = statement.executeQuery();

            while( results.next() ) {
            JobCategoryEntity item = new JobCategoryEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByCode( String code ) throws JobCategoryException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description from job_category where code LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, code );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobCategoryEntity> searchByName( String name ) throws JobCategoryException {

        final List<JobCategoryEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from job_category where name LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, name );

            results = statement.executeQuery();

            while( results.next() ) {
            JobCategoryEntity item = new JobCategoryEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByName( String name ) throws JobCategoryException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description from job_category where name LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, name );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobCategoryEntity> searchByDescription( String description ) throws JobCategoryException {

        final List<JobCategoryEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from job_category where description LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, description );

            results = statement.executeQuery();

            while( results.next() ) {
            JobCategoryEntity item = new JobCategoryEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByDescription( String description ) throws JobCategoryException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description from job_category where description LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, description );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobCategoryException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobCategoryException(exception.getMessage());
            }
        }

        return exists;
    }


}
