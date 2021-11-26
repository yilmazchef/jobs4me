package be.intec.repositories;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;

public class InterviewNoteRepository {

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
        for ( final InterviewNoteEntity entity : entities ) {
            rowsDeleted += deleteById( entity.getId() );
        }
        
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        int rowsEffected = 0;
    
        try {
            String query = "ALTER TABLE interview_note AUTO_INCREMENT = 0";
            connection = getConnection();
            statement = connection.prepareStatement( query );
            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if ( statement != null ) {
                    statement.close();
                }
                if ( connection != null ) {
                    connection.close();
                }
            } catch ( Exception exception ) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return rowsEffected;
    
    }
    
    
    public int save( InterviewNoteEntity record ) throws InterviewNoteException {
    
        int rowsEffected = 0;
    
        try {
            String query = "insert into interview_note ( notes, interview_id, recruiter_id, pass ) values ( ?, ?, ?, ? )";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getNotes());
            statement.setInt(2, record.getInterviewId());
            statement.setInt(3, record.getRecruiterId());
            statement.setString(4, record.getPass());

             rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public InterviewNoteEntity findById( Integer id ) throws InterviewNoteException {


        if( id < 0 ) {
            throw new InterviewNoteException( " InterviewNote ID is required." ).requiredFields("id");
        }

        InterviewNoteEntity item = new InterviewNoteEntity();

        try {
            String query = "select id, notes, interview_id, recruiter_id, pass from interview_note where id = ?";
            connection = getConnection();

            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            results = statement.executeQuery();
            if(results.next()){
                item.setId( results.getInt("id") );
                item.setNotes( results.getString("notes") );
                item.setInterviewId( results.getInt("interview_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setPass( results.getString("pass") );
            }
        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return item;
    }

    public List<InterviewNoteEntity> findAllByExample( InterviewNoteEntity example ) throws InterviewNoteException {

        final List<InterviewNoteEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, notes, interview_id, recruiter_id, pass from interview_note where notes = ? OR interview_id = ? OR recruiter_id = ? OR pass = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, example.getNotes() );
            statement.setInt( 2, example.getInterviewId() );
            statement.setInt( 3, example.getRecruiterId() );
            statement.setString( 4, example.getPass() );

            results = statement.executeQuery();
            while(results.next()){
            InterviewNoteEntity item = new InterviewNoteEntity();
                item.setId( results.getInt("id") );
                item.setNotes( results.getString("notes") );
                item.setInterviewId( results.getInt("interview_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setPass( results.getString("pass") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return itemList;
    }

    public List<InterviewNoteEntity> findAll() throws InterviewNoteException {

        final List<InterviewNoteEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, notes, interview_id, recruiter_id, pass from interview_note ";
            connection = getConnection();
            statement = connection.prepareStatement(query);

            results = statement.executeQuery();
            while(results.next()){
                InterviewNoteEntity item = new InterviewNoteEntity();
                item.setId( results.getInt("id") );
                item.setNotes( results.getString("notes") );
                item.setInterviewId( results.getInt("interview_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setPass( results.getString("pass") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return itemList;
    }

    public int updateById( Integer id, InterviewNoteEntity record ) throws InterviewNoteException {

        if( id < 0 ) {
            throw new InterviewNoteException( " InterviewNote ID is required." ).requiredFields("id");
        }

        if ( record == null ) {
            throw new InterviewNoteException( " InterviewNote is required." ).nullInterviewNoteException();
        }

        int rowsEffected = 0;

        try {
            String query = "update interview_note set   notes  = ?,   interview_id  = ?,   recruiter_id  = ?,   pass  = ? where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getNotes());
            statement.setInt(2, record.getInterviewId());
            statement.setInt(3, record.getRecruiterId());
            statement.setString(4, record.getPass());
            statement.setInt( 5, id );

            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws InterviewNoteException {


        if( id < 0 ) {
            throw new InterviewNoteException( " InterviewNote ID is required." ).requiredFields("id");
        }

        int rowsEffected = 0;

        try {
            String query = "delete from interview_note where id = ? ";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            rowsEffected = statement.executeUpdate();
        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int updateNotesById( Integer id, String notes ) throws InterviewNoteException {

        if( id < 0 ) {
            throw new InterviewNoteException( " InterviewNote ID is required." ).requiredFields("id");
        }

        if ( notes == null ) {
            throw new InterviewNoteException( " notes is required." ).nullInterviewNoteException();
        }

        int rowsEffected = 0;

        try {
            String query = "update interview_note set  notes  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, notes );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateInterviewIdById( Integer id, Integer interviewId ) throws InterviewNoteException {

        if( id < 0 ) {
            throw new InterviewNoteException( " InterviewNote ID is required." ).requiredFields("id");
        }

        if ( interviewId == null ) {
            throw new InterviewNoteException( " interviewId is required." ).nullInterviewNoteException();
        }

        int rowsEffected = 0;

        try {
            String query = "update interview_note set  interview_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, interviewId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateRecruiterIdById( Integer id, Integer recruiterId ) throws InterviewNoteException {

        if( id < 0 ) {
            throw new InterviewNoteException( " InterviewNote ID is required." ).requiredFields("id");
        }

        if ( recruiterId == null ) {
            throw new InterviewNoteException( " recruiterId is required." ).nullInterviewNoteException();
        }

        int rowsEffected = 0;

        try {
            String query = "update interview_note set  recruiter_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, recruiterId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updatePassById( Integer id, String pass ) throws InterviewNoteException {

        if( id < 0 ) {
            throw new InterviewNoteException( " InterviewNote ID is required." ).requiredFields("id");
        }

        if ( pass == null ) {
            throw new InterviewNoteException( " pass is required." ).nullInterviewNoteException();
        }

        int rowsEffected = 0;

        try {
            String query = "update interview_note set  pass  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, pass );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws InterviewNoteException {

        boolean exists = false;
        try {
            String query = "select id, notes, interview_id, recruiter_id, pass from interview_note where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, id );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<InterviewNoteEntity> searchByNotes( String notes ) throws InterviewNoteException {

        final List<InterviewNoteEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, notes, interview_id, recruiter_id, pass from interview_note where notes LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, notes );

            results = statement.executeQuery();

            while( results.next() ) {
            InterviewNoteEntity item = new InterviewNoteEntity();
                item.setId( results.getInt("id") );
                item.setNotes( results.getString("notes") );
                item.setInterviewId( results.getInt("interview_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setPass( results.getString("pass") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByNotes( String notes ) throws InterviewNoteException {

        boolean exists = false;
        try {
            String query = "select id, notes, interview_id, recruiter_id, pass from interview_note where notes LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, notes );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<InterviewNoteEntity> searchByInterviewId( Integer interviewId ) throws InterviewNoteException {

        final List<InterviewNoteEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, notes, interview_id, recruiter_id, pass from interview_note where interview_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, interviewId );

            results = statement.executeQuery();

            while( results.next() ) {
            InterviewNoteEntity item = new InterviewNoteEntity();
                item.setId( results.getInt("id") );
                item.setNotes( results.getString("notes") );
                item.setInterviewId( results.getInt("interview_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setPass( results.getString("pass") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByInterviewId( Integer interviewId ) throws InterviewNoteException {

        boolean exists = false;
        try {
            String query = "select id, notes, interview_id, recruiter_id, pass from interview_note where interview_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, interviewId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<InterviewNoteEntity> searchByRecruiterId( Integer recruiterId ) throws InterviewNoteException {

        final List<InterviewNoteEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, notes, interview_id, recruiter_id, pass from interview_note where recruiter_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, recruiterId );

            results = statement.executeQuery();

            while( results.next() ) {
            InterviewNoteEntity item = new InterviewNoteEntity();
                item.setId( results.getInt("id") );
                item.setNotes( results.getString("notes") );
                item.setInterviewId( results.getInt("interview_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setPass( results.getString("pass") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByRecruiterId( Integer recruiterId ) throws InterviewNoteException {

        boolean exists = false;
        try {
            String query = "select id, notes, interview_id, recruiter_id, pass from interview_note where recruiter_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, recruiterId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<InterviewNoteEntity> searchByPass( String pass ) throws InterviewNoteException {

        final List<InterviewNoteEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, notes, interview_id, recruiter_id, pass from interview_note where pass LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, pass );

            results = statement.executeQuery();

            while( results.next() ) {
            InterviewNoteEntity item = new InterviewNoteEntity();
                item.setId( results.getInt("id") );
                item.setNotes( results.getString("notes") );
                item.setInterviewId( results.getInt("interview_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setPass( results.getString("pass") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByPass( String pass ) throws InterviewNoteException {

        boolean exists = false;
        try {
            String query = "select id, notes, interview_id, recruiter_id, pass from interview_note where pass LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, pass );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new InterviewNoteException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new InterviewNoteException(exception.getMessage());
            }
        }

        return exists;
    }


}
