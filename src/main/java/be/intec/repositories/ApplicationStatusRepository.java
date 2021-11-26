package be.intec.repositories;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;

public class ApplicationStatusRepository {

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
        for ( final ApplicationStatusEntity entity : entities ) {
            rowsDeleted += deleteById( entity.getId() );
        }
        
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        int rowsEffected = 0;
    
        try {
            String query = "ALTER TABLE application_status AUTO_INCREMENT = 0";
            connection = getConnection();
            statement = connection.prepareStatement( query );
            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new ApplicationStatusException(sqlException.getMessage());
        } finally {
            try {
                if ( statement != null ) {
                    statement.close();
                }
                if ( connection != null ) {
                    connection.close();
                }
            } catch ( Exception exception ) {
                throw new ApplicationStatusException(exception.getMessage());
            }
        }

        return rowsEffected;
    
    }
    
    
    public int save( ApplicationStatusEntity record ) throws ApplicationStatusException {
    
        int rowsEffected = 0;
    
        try {
            String query = "insert into application_status ( status ) values ( ? )";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getStatus());

             rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ApplicationStatusException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicationStatusException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public ApplicationStatusEntity findById( Integer id ) throws ApplicationStatusException {


        if( id < 0 ) {
            throw new ApplicationStatusException( " ApplicationStatus ID is required." ).requiredFields("id");
        }

        ApplicationStatusEntity item = new ApplicationStatusEntity();

        try {
            String query = "select id, status from application_status where id = ?";
            connection = getConnection();

            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            results = statement.executeQuery();
            if(results.next()){
                item.setId( results.getInt("id") );
                item.setStatus( results.getString("status") );
            }
        } catch (SQLException sqlException) {
                throw new ApplicationStatusException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicationStatusException(exception.getMessage());
            }
        }

        return item;
    }

    public List<ApplicationStatusEntity> findAllByExample( ApplicationStatusEntity example ) throws ApplicationStatusException {

        final List<ApplicationStatusEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, status from application_status where status = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, example.getStatus() );

            results = statement.executeQuery();
            while(results.next()){
            ApplicationStatusEntity item = new ApplicationStatusEntity();
                item.setId( results.getInt("id") );
                item.setStatus( results.getString("status") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicationStatusException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicationStatusException(exception.getMessage());
            }
        }

        return itemList;
    }

    public List<ApplicationStatusEntity> findAll() throws ApplicationStatusException {

        final List<ApplicationStatusEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, status from application_status ";
            connection = getConnection();
            statement = connection.prepareStatement(query);

            results = statement.executeQuery();
            while(results.next()){
                ApplicationStatusEntity item = new ApplicationStatusEntity();
                item.setId( results.getInt("id") );
                item.setStatus( results.getString("status") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicationStatusException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicationStatusException(exception.getMessage());
            }
        }

        return itemList;
    }

    public int updateById( Integer id, ApplicationStatusEntity record ) throws ApplicationStatusException {

        if( id < 0 ) {
            throw new ApplicationStatusException( " ApplicationStatus ID is required." ).requiredFields("id");
        }

        if ( record == null ) {
            throw new ApplicationStatusException( " ApplicationStatus is required." ).nullApplicationStatusException();
        }

        int rowsEffected = 0;

        try {
            String query = "update application_status set   status  = ? where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getStatus());
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new ApplicationStatusException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicationStatusException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws ApplicationStatusException {


        if( id < 0 ) {
            throw new ApplicationStatusException( " ApplicationStatus ID is required." ).requiredFields("id");
        }

        int rowsEffected = 0;

        try {
            String query = "delete from application_status where id = ? ";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            rowsEffected = statement.executeUpdate();
        } catch (SQLException sqlException) {
                throw new ApplicationStatusException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicationStatusException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int updateStatusById( Integer id, String status ) throws ApplicationStatusException {

        if( id < 0 ) {
            throw new ApplicationStatusException( " ApplicationStatus ID is required." ).requiredFields("id");
        }

        if ( status == null ) {
            throw new ApplicationStatusException( " status is required." ).nullApplicationStatusException();
        }

        int rowsEffected = 0;

        try {
            String query = "update application_status set  status  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, status );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ApplicationStatusException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicationStatusException(exception.getMessage());
            }
        }

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws ApplicationStatusException {

        boolean exists = false;
        try {
            String query = "select id, status from application_status where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, id );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ApplicationStatusException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicationStatusException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<ApplicationStatusEntity> searchByStatus( String status ) throws ApplicationStatusException {

        final List<ApplicationStatusEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, status from application_status where status LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, status );

            results = statement.executeQuery();

            while( results.next() ) {
            ApplicationStatusEntity item = new ApplicationStatusEntity();
                item.setId( results.getInt("id") );
                item.setStatus( results.getString("status") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicationStatusException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicationStatusException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByStatus( String status ) throws ApplicationStatusException {

        boolean exists = false;
        try {
            String query = "select id, status from application_status where status LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, status );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ApplicationStatusException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicationStatusException(exception.getMessage());
            }
        }

        return exists;
    }


}
