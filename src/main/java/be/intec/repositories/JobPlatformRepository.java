package be.intec.repositories;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;

public class JobPlatformRepository {

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
        for ( final JobPlatformEntity entity : entities ) {
            rowsDeleted += deleteById( entity.getId() );
        }
        
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        int rowsEffected = 0;
    
        try {
            String query = "ALTER TABLE job_platform AUTO_INCREMENT = 0";
            connection = getConnection();
            statement = connection.prepareStatement( query );
            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if ( statement != null ) {
                    statement.close();
                }
                if ( connection != null ) {
                    connection.close();
                }
            } catch ( Exception exception ) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return rowsEffected;
    
    }
    
    
    public int save( JobPlatformEntity record ) throws JobPlatformException {
    
        int rowsEffected = 0;
    
        try {
            String query = "insert into job_platform ( code, name, description ) values ( ?, ?, ? )";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getCode());
            statement.setString(2, record.getName());
            statement.setString(3, record.getDescription());

             rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public JobPlatformEntity findById( Integer id ) throws JobPlatformException {


        if( id < 0 ) {
            throw new JobPlatformException( " JobPlatform ID is required." ).requiredFields("id");
        }

        JobPlatformEntity item = new JobPlatformEntity();

        try {
            String query = "select id, code, name, description from job_platform where id = ?";
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
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return item;
    }

    public List<JobPlatformEntity> findAllByExample( JobPlatformEntity example ) throws JobPlatformException {

        final List<JobPlatformEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from job_platform where code = ? OR name = ? OR description = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, example.getCode() );
            statement.setString( 2, example.getName() );
            statement.setString( 3, example.getDescription() );

            results = statement.executeQuery();
            while(results.next()){
            JobPlatformEntity item = new JobPlatformEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return itemList;
    }

    public List<JobPlatformEntity> findAll() throws JobPlatformException {

        final List<JobPlatformEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from job_platform ";
            connection = getConnection();
            statement = connection.prepareStatement(query);

            results = statement.executeQuery();
            while(results.next()){
                JobPlatformEntity item = new JobPlatformEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return itemList;
    }

    public int updateById( Integer id, JobPlatformEntity record ) throws JobPlatformException {

        if( id < 0 ) {
            throw new JobPlatformException( " JobPlatform ID is required." ).requiredFields("id");
        }

        if ( record == null ) {
            throw new JobPlatformException( " JobPlatform is required." ).nullJobPlatformException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job_platform set   code  = ?,   name  = ?,   description  = ? where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getCode());
            statement.setString(2, record.getName());
            statement.setString(3, record.getDescription());
            statement.setInt( 4, id );

            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws JobPlatformException {


        if( id < 0 ) {
            throw new JobPlatformException( " JobPlatform ID is required." ).requiredFields("id");
        }

        int rowsEffected = 0;

        try {
            String query = "delete from job_platform where id = ? ";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            rowsEffected = statement.executeUpdate();
        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int updateCodeById( Integer id, String code ) throws JobPlatformException {

        if( id < 0 ) {
            throw new JobPlatformException( " JobPlatform ID is required." ).requiredFields("id");
        }

        if ( code == null ) {
            throw new JobPlatformException( " code is required." ).nullJobPlatformException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job_platform set  code  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, code );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateNameById( Integer id, String name ) throws JobPlatformException {

        if( id < 0 ) {
            throw new JobPlatformException( " JobPlatform ID is required." ).requiredFields("id");
        }

        if ( name == null ) {
            throw new JobPlatformException( " name is required." ).nullJobPlatformException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job_platform set  name  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, name );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateDescriptionById( Integer id, String description ) throws JobPlatformException {

        if( id < 0 ) {
            throw new JobPlatformException( " JobPlatform ID is required." ).requiredFields("id");
        }

        if ( description == null ) {
            throw new JobPlatformException( " description is required." ).nullJobPlatformException();
        }

        int rowsEffected = 0;

        try {
            String query = "update job_platform set  description  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, description );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws JobPlatformException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description from job_platform where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, id );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobPlatformEntity> searchByCode( String code ) throws JobPlatformException {

        final List<JobPlatformEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from job_platform where code LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, code );

            results = statement.executeQuery();

            while( results.next() ) {
            JobPlatformEntity item = new JobPlatformEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByCode( String code ) throws JobPlatformException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description from job_platform where code LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, code );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobPlatformEntity> searchByName( String name ) throws JobPlatformException {

        final List<JobPlatformEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from job_platform where name LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, name );

            results = statement.executeQuery();

            while( results.next() ) {
            JobPlatformEntity item = new JobPlatformEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByName( String name ) throws JobPlatformException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description from job_platform where name LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, name );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<JobPlatformEntity> searchByDescription( String description ) throws JobPlatformException {

        final List<JobPlatformEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from job_platform where description LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, description );

            results = statement.executeQuery();

            while( results.next() ) {
            JobPlatformEntity item = new JobPlatformEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByDescription( String description ) throws JobPlatformException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description from job_platform where description LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, description );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new JobPlatformException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new JobPlatformException(exception.getMessage());
            }
        }

        return exists;
    }


}
