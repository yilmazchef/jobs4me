package be.intec.repositories;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;

public class AnswersRepository {

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
        for ( final AnswersEntity entity : entities ) {
            rowsDeleted += deleteById( entity.getId() );
        }
        
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        int rowsEffected = 0;
    
        try {
            String query = "ALTER TABLE answers AUTO_INCREMENT = 0";
            connection = getConnection();
            statement = connection.prepareStatement( query );
            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if ( statement != null ) {
                    statement.close();
                }
                if ( connection != null ) {
                    connection.close();
                }
            } catch ( Exception exception ) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return rowsEffected;
    
    }
    
    
    public int save( AnswersEntity record ) throws AnswersException {
    
        int rowsEffected = 0;
    
        try {
            String query = "insert into answers ( application_test_id, recruiter_id, total_grades, pass, answer_details ) values ( ?, ?, ?, ?, ? )";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, record.getApplicationTestId());
            statement.setInt(2, record.getRecruiterId());
            statement.setString(3, record.getTotalGrades());
            statement.setString(4, record.getPass());
            statement.setString(5, record.getAnswerDetails());

             rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public AnswersEntity findById( Integer id ) throws AnswersException {


        if( id < 0 ) {
            throw new AnswersException( " Answers ID is required." ).requiredFields("id");
        }

        AnswersEntity item = new AnswersEntity();

        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers where id = ?";
            connection = getConnection();

            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            results = statement.executeQuery();
            if(results.next()){
                item.setId( results.getInt("id") );
                item.setApplicationTestId( results.getInt("application_test_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setTotalGrades( results.getString("total_grades") );
                item.setPass( results.getString("pass") );
                item.setAnswerDetails( results.getString("answer_details") );
            }
        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return item;
    }

    public List<AnswersEntity> findAllByExample( AnswersEntity example ) throws AnswersException {

        final List<AnswersEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers where application_test_id = ? OR recruiter_id = ? OR total_grades = ? OR pass = ? OR answer_details = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, example.getApplicationTestId() );
            statement.setInt( 2, example.getRecruiterId() );
            statement.setString( 3, example.getTotalGrades() );
            statement.setString( 4, example.getPass() );
            statement.setString( 5, example.getAnswerDetails() );

            results = statement.executeQuery();
            while(results.next()){
            AnswersEntity item = new AnswersEntity();
                item.setId( results.getInt("id") );
                item.setApplicationTestId( results.getInt("application_test_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setTotalGrades( results.getString("total_grades") );
                item.setPass( results.getString("pass") );
                item.setAnswerDetails( results.getString("answer_details") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return itemList;
    }

    public List<AnswersEntity> findAll() throws AnswersException {

        final List<AnswersEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers ";
            connection = getConnection();
            statement = connection.prepareStatement(query);

            results = statement.executeQuery();
            while(results.next()){
                AnswersEntity item = new AnswersEntity();
                item.setId( results.getInt("id") );
                item.setApplicationTestId( results.getInt("application_test_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setTotalGrades( results.getString("total_grades") );
                item.setPass( results.getString("pass") );
                item.setAnswerDetails( results.getString("answer_details") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return itemList;
    }

    public int updateById( Integer id, AnswersEntity record ) throws AnswersException {

        if( id < 0 ) {
            throw new AnswersException( " Answers ID is required." ).requiredFields("id");
        }

        if ( record == null ) {
            throw new AnswersException( " Answers is required." ).nullAnswersException();
        }

        int rowsEffected = 0;

        try {
            String query = "update answers set   application_test_id  = ?,   recruiter_id  = ?,   total_grades  = ?,   pass  = ?,   answer_details  = ? where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, record.getApplicationTestId());
            statement.setInt(2, record.getRecruiterId());
            statement.setString(3, record.getTotalGrades());
            statement.setString(4, record.getPass());
            statement.setString(5, record.getAnswerDetails());
            statement.setInt( 6, id );

            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws AnswersException {


        if( id < 0 ) {
            throw new AnswersException( " Answers ID is required." ).requiredFields("id");
        }

        int rowsEffected = 0;

        try {
            String query = "delete from answers where id = ? ";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            rowsEffected = statement.executeUpdate();
        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int updateApplicationTestIdById( Integer id, Integer applicationTestId ) throws AnswersException {

        if( id < 0 ) {
            throw new AnswersException( " Answers ID is required." ).requiredFields("id");
        }

        if ( applicationTestId == null ) {
            throw new AnswersException( " applicationTestId is required." ).nullAnswersException();
        }

        int rowsEffected = 0;

        try {
            String query = "update answers set  application_test_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, applicationTestId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateRecruiterIdById( Integer id, Integer recruiterId ) throws AnswersException {

        if( id < 0 ) {
            throw new AnswersException( " Answers ID is required." ).requiredFields("id");
        }

        if ( recruiterId == null ) {
            throw new AnswersException( " recruiterId is required." ).nullAnswersException();
        }

        int rowsEffected = 0;

        try {
            String query = "update answers set  recruiter_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, recruiterId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateTotalGradesById( Integer id, String totalGrades ) throws AnswersException {

        if( id < 0 ) {
            throw new AnswersException( " Answers ID is required." ).requiredFields("id");
        }

        if ( totalGrades == null ) {
            throw new AnswersException( " totalGrades is required." ).nullAnswersException();
        }

        int rowsEffected = 0;

        try {
            String query = "update answers set  total_grades  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, totalGrades );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updatePassById( Integer id, String pass ) throws AnswersException {

        if( id < 0 ) {
            throw new AnswersException( " Answers ID is required." ).requiredFields("id");
        }

        if ( pass == null ) {
            throw new AnswersException( " pass is required." ).nullAnswersException();
        }

        int rowsEffected = 0;

        try {
            String query = "update answers set  pass  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, pass );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateAnswerDetailsById( Integer id, String answerDetails ) throws AnswersException {

        if( id < 0 ) {
            throw new AnswersException( " Answers ID is required." ).requiredFields("id");
        }

        if ( answerDetails == null ) {
            throw new AnswersException( " answerDetails is required." ).nullAnswersException();
        }

        int rowsEffected = 0;

        try {
            String query = "update answers set  answer_details  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, answerDetails );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws AnswersException {

        boolean exists = false;
        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, id );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<AnswersEntity> searchByApplicationTestId( Integer applicationTestId ) throws AnswersException {

        final List<AnswersEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers where application_test_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, applicationTestId );

            results = statement.executeQuery();

            while( results.next() ) {
            AnswersEntity item = new AnswersEntity();
                item.setId( results.getInt("id") );
                item.setApplicationTestId( results.getInt("application_test_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setTotalGrades( results.getString("total_grades") );
                item.setPass( results.getString("pass") );
                item.setAnswerDetails( results.getString("answer_details") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByApplicationTestId( Integer applicationTestId ) throws AnswersException {

        boolean exists = false;
        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers where application_test_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, applicationTestId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<AnswersEntity> searchByRecruiterId( Integer recruiterId ) throws AnswersException {

        final List<AnswersEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers where recruiter_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, recruiterId );

            results = statement.executeQuery();

            while( results.next() ) {
            AnswersEntity item = new AnswersEntity();
                item.setId( results.getInt("id") );
                item.setApplicationTestId( results.getInt("application_test_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setTotalGrades( results.getString("total_grades") );
                item.setPass( results.getString("pass") );
                item.setAnswerDetails( results.getString("answer_details") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByRecruiterId( Integer recruiterId ) throws AnswersException {

        boolean exists = false;
        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers where recruiter_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, recruiterId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<AnswersEntity> searchByTotalGrades( String totalGrades ) throws AnswersException {

        final List<AnswersEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers where total_grades LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, totalGrades );

            results = statement.executeQuery();

            while( results.next() ) {
            AnswersEntity item = new AnswersEntity();
                item.setId( results.getInt("id") );
                item.setApplicationTestId( results.getInt("application_test_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setTotalGrades( results.getString("total_grades") );
                item.setPass( results.getString("pass") );
                item.setAnswerDetails( results.getString("answer_details") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByTotalGrades( String totalGrades ) throws AnswersException {

        boolean exists = false;
        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers where total_grades LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, totalGrades );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<AnswersEntity> searchByPass( String pass ) throws AnswersException {

        final List<AnswersEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers where pass LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, pass );

            results = statement.executeQuery();

            while( results.next() ) {
            AnswersEntity item = new AnswersEntity();
                item.setId( results.getInt("id") );
                item.setApplicationTestId( results.getInt("application_test_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setTotalGrades( results.getString("total_grades") );
                item.setPass( results.getString("pass") );
                item.setAnswerDetails( results.getString("answer_details") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByPass( String pass ) throws AnswersException {

        boolean exists = false;
        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers where pass LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, pass );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<AnswersEntity> searchByAnswerDetails( String answerDetails ) throws AnswersException {

        final List<AnswersEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers where answer_details LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, answerDetails );

            results = statement.executeQuery();

            while( results.next() ) {
            AnswersEntity item = new AnswersEntity();
                item.setId( results.getInt("id") );
                item.setApplicationTestId( results.getInt("application_test_id") );
                item.setRecruiterId( results.getInt("recruiter_id") );
                item.setTotalGrades( results.getString("total_grades") );
                item.setPass( results.getString("pass") );
                item.setAnswerDetails( results.getString("answer_details") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByAnswerDetails( String answerDetails ) throws AnswersException {

        boolean exists = false;
        try {
            String query = "select id, application_test_id, recruiter_id, total_grades, pass, answer_details from answers where answer_details LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, answerDetails );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new AnswersException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new AnswersException(exception.getMessage());
            }
        }

        return exists;
    }


}
