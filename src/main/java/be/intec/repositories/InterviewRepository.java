package be.intec.repositories;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;

public class InterviewRepository {

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
        for ( final InterviewEntity entity : entities ) {
            rowsDeleted += deleteById( entity.getId() );
        }
        
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        int rowsEffected = 0;
    
        try {
            String query = "ALTER TABLE interview AUTO_INCREMENT = 0";
            connection = getConnection();
            statement = connection.prepareStatement( query );
            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if ( statement != null ) {
                    statement.close();
                }
                if ( connection != null ) {
                    connection.close();
                }
            } catch ( Exception exception ) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return rowsEffected;
    
    }
    
    
    public int save( InterviewEntity record ) throws InterviewException {
    
        int rowsEffected = 0;
    
        try {
            String query = "insert into interview ( start_time, end_time, application_id ) values ( ?, ?, ? )";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp(1, record.getStartTime());
            statement.setTimestamp(2, record.getEndTime());
            statement.setInt(3, record.getApplicationId());

             rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public InterviewEntity findById( Integer id ) throws InterviewException {


        if( id < 0 ) {
            throw new InterviewException( " Interview ID is required." ).requiredFields("id");
        }

        InterviewEntity item = new InterviewEntity();

        try {
            String query = "select id, start_time, end_time, application_id from interview where id = ?";
            connection = getConnection();

            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            results = statement.executeQuery();
            if(results.next()){
                item.setId( results.getInt("id") );
                item.setStartTime( results.getTimestamp("start_time") );
                item.setEndTime( results.getTimestamp("end_time") );
                item.setApplicationId( results.getInt("application_id") );
            }
        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return item;
    }

    public List<InterviewEntity> findAllByExample( InterviewEntity example ) throws InterviewException {

        final List<InterviewEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, start_time, end_time, application_id from interview where start_time = ? OR end_time = ? OR application_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp( 1, example.getStartTime() );
            statement.setTimestamp( 2, example.getEndTime() );
            statement.setInt( 3, example.getApplicationId() );

            results = statement.executeQuery();
            while(results.next()){
            InterviewEntity item = new InterviewEntity();
                item.setId( results.getInt("id") );
                item.setStartTime( results.getTimestamp("start_time") );
                item.setEndTime( results.getTimestamp("end_time") );
                item.setApplicationId( results.getInt("application_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return itemList;
    }

    public List<InterviewEntity> findAll() throws InterviewException {

        final List<InterviewEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, start_time, end_time, application_id from interview ";
            connection = getConnection();
            statement = connection.prepareStatement(query);

            results = statement.executeQuery();
            while(results.next()){
                InterviewEntity item = new InterviewEntity();
                item.setId( results.getInt("id") );
                item.setStartTime( results.getTimestamp("start_time") );
                item.setEndTime( results.getTimestamp("end_time") );
                item.setApplicationId( results.getInt("application_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return itemList;
    }

    public int updateById( Integer id, InterviewEntity record ) throws InterviewException {

        if( id < 0 ) {
            throw new InterviewException( " Interview ID is required." ).requiredFields("id");
        }

        if ( record == null ) {
            throw new InterviewException( " Interview is required." ).nullInterviewException();
        }

        int rowsEffected = 0;

        try {
            String query = "update interview set   start_time  = ?,   end_time  = ?,   application_id  = ? where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp(1, record.getStartTime());
            statement.setTimestamp(2, record.getEndTime());
            statement.setInt(3, record.getApplicationId());
            statement.setInt( 4, id );

            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws InterviewException {


        if( id < 0 ) {
            throw new InterviewException( " Interview ID is required." ).requiredFields("id");
        }

        int rowsEffected = 0;

        try {
            String query = "delete from interview where id = ? ";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            rowsEffected = statement.executeUpdate();
        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int updateStartTimeById( Integer id, java.sql.Timestamp startTime ) throws InterviewException {

        if( id < 0 ) {
            throw new InterviewException( " Interview ID is required." ).requiredFields("id");
        }

        if ( startTime == null ) {
            throw new InterviewException( " startTime is required." ).nullInterviewException();
        }

        int rowsEffected = 0;

        try {
            String query = "update interview set  start_time  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp( 1, startTime );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateEndTimeById( Integer id, java.sql.Timestamp endTime ) throws InterviewException {

        if( id < 0 ) {
            throw new InterviewException( " Interview ID is required." ).requiredFields("id");
        }

        if ( endTime == null ) {
            throw new InterviewException( " endTime is required." ).nullInterviewException();
        }

        int rowsEffected = 0;

        try {
            String query = "update interview set  end_time  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp( 1, endTime );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateApplicationIdById( Integer id, Integer applicationId ) throws InterviewException {

        if( id < 0 ) {
            throw new InterviewException( " Interview ID is required." ).requiredFields("id");
        }

        if ( applicationId == null ) {
            throw new InterviewException( " applicationId is required." ).nullInterviewException();
        }

        int rowsEffected = 0;

        try {
            String query = "update interview set  application_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, applicationId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws InterviewException {

        boolean exists = false;
        try {
            String query = "select id, start_time, end_time, application_id from interview where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, id );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<InterviewEntity> searchByStartTime( java.sql.Timestamp startTime ) throws InterviewException {

        final List<InterviewEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, start_time, end_time, application_id from interview where start_time = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp( 1, startTime );

            results = statement.executeQuery();

            while( results.next() ) {
            InterviewEntity item = new InterviewEntity();
                item.setId( results.getInt("id") );
                item.setStartTime( results.getTimestamp("start_time") );
                item.setEndTime( results.getTimestamp("end_time") );
                item.setApplicationId( results.getInt("application_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByStartTime( java.sql.Timestamp startTime ) throws InterviewException {

        boolean exists = false;
        try {
            String query = "select id, start_time, end_time, application_id from interview where start_time = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp( 1, startTime );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<InterviewEntity> searchByEndTime( java.sql.Timestamp endTime ) throws InterviewException {

        final List<InterviewEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, start_time, end_time, application_id from interview where end_time = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp( 1, endTime );

            results = statement.executeQuery();

            while( results.next() ) {
            InterviewEntity item = new InterviewEntity();
                item.setId( results.getInt("id") );
                item.setStartTime( results.getTimestamp("start_time") );
                item.setEndTime( results.getTimestamp("end_time") );
                item.setApplicationId( results.getInt("application_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByEndTime( java.sql.Timestamp endTime ) throws InterviewException {

        boolean exists = false;
        try {
            String query = "select id, start_time, end_time, application_id from interview where end_time = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setTimestamp( 1, endTime );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<InterviewEntity> searchByApplicationId( Integer applicationId ) throws InterviewException {

        final List<InterviewEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, start_time, end_time, application_id from interview where application_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, applicationId );

            results = statement.executeQuery();

            while( results.next() ) {
            InterviewEntity item = new InterviewEntity();
                item.setId( results.getInt("id") );
                item.setStartTime( results.getTimestamp("start_time") );
                item.setEndTime( results.getTimestamp("end_time") );
                item.setApplicationId( results.getInt("application_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByApplicationId( Integer applicationId ) throws InterviewException {

        boolean exists = false;
        try {
            String query = "select id, start_time, end_time, application_id from interview where application_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, applicationId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new InterviewException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewException(exception.getMessage());
            }
        }

        return exists;
    }


}
