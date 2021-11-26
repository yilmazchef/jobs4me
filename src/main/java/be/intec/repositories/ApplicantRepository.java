package be.intec.repositories;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;

public class ApplicantRepository {

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
        for ( final ApplicantEntity entity : entities ) {
            rowsDeleted += deleteById( entity.getId() );
        }
        
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        int rowsEffected = 0;
    
        try {
            String query = "ALTER TABLE applicant AUTO_INCREMENT = 0";
            connection = getConnection();
            statement = connection.prepareStatement( query );
            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if ( statement != null ) {
                    statement.close();
                }
                if ( connection != null ) {
                    connection.close();
                }
            } catch ( Exception exception ) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return rowsEffected;
    
    }
    
    
    public int save( ApplicantEntity record ) throws ApplicantException {
    
        int rowsEffected = 0;
    
        try {
            String query = "insert into applicant ( first_name, last_name, email, phone, summary ) values ( ?, ?, ?, ?, ? )";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getFirstName());
            statement.setString(2, record.getLastName());
            statement.setString(3, record.getEmail());
            statement.setString(4, record.getPhone());
            statement.setString(5, record.getSummary());

             rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public ApplicantEntity findById( Integer id ) throws ApplicantException {


        if( id < 0 ) {
            throw new ApplicantException( " Applicant ID is required." ).requiredFields("id");
        }

        ApplicantEntity item = new ApplicantEntity();

        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant where id = ?";
            connection = getConnection();

            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            results = statement.executeQuery();
            if(results.next()){
                item.setId( results.getInt("id") );
                item.setFirstName( results.getString("first_name") );
                item.setLastName( results.getString("last_name") );
                item.setEmail( results.getString("email") );
                item.setPhone( results.getString("phone") );
                item.setSummary( results.getString("summary") );
            }
        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return item;
    }

    public List<ApplicantEntity> findAllByExample( ApplicantEntity example ) throws ApplicantException {

        final List<ApplicantEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant where first_name = ? OR last_name = ? OR email = ? OR phone = ? OR summary = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, example.getFirstName() );
            statement.setString( 2, example.getLastName() );
            statement.setString( 3, example.getEmail() );
            statement.setString( 4, example.getPhone() );
            statement.setString( 5, example.getSummary() );

            results = statement.executeQuery();
            while(results.next()){
            ApplicantEntity item = new ApplicantEntity();
                item.setId( results.getInt("id") );
                item.setFirstName( results.getString("first_name") );
                item.setLastName( results.getString("last_name") );
                item.setEmail( results.getString("email") );
                item.setPhone( results.getString("phone") );
                item.setSummary( results.getString("summary") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return itemList;
    }

    public List<ApplicantEntity> findAll() throws ApplicantException {

        final List<ApplicantEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant ";
            connection = getConnection();
            statement = connection.prepareStatement(query);

            results = statement.executeQuery();
            while(results.next()){
                ApplicantEntity item = new ApplicantEntity();
                item.setId( results.getInt("id") );
                item.setFirstName( results.getString("first_name") );
                item.setLastName( results.getString("last_name") );
                item.setEmail( results.getString("email") );
                item.setPhone( results.getString("phone") );
                item.setSummary( results.getString("summary") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return itemList;
    }

    public int updateById( Integer id, ApplicantEntity record ) throws ApplicantException {

        if( id < 0 ) {
            throw new ApplicantException( " Applicant ID is required." ).requiredFields("id");
        }

        if ( record == null ) {
            throw new ApplicantException( " Applicant is required." ).nullApplicantException();
        }

        int rowsEffected = 0;

        try {
            String query = "update applicant set   first_name  = ?,   last_name  = ?,   email  = ?,   phone  = ?,   summary  = ? where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getFirstName());
            statement.setString(2, record.getLastName());
            statement.setString(3, record.getEmail());
            statement.setString(4, record.getPhone());
            statement.setString(5, record.getSummary());
            statement.setInt( 6, id );

            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws ApplicantException {


        if( id < 0 ) {
            throw new ApplicantException( " Applicant ID is required." ).requiredFields("id");
        }

        int rowsEffected = 0;

        try {
            String query = "delete from applicant where id = ? ";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            rowsEffected = statement.executeUpdate();
        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int updateFirstNameById( Integer id, String firstName ) throws ApplicantException {

        if( id < 0 ) {
            throw new ApplicantException( " Applicant ID is required." ).requiredFields("id");
        }

        if ( firstName == null ) {
            throw new ApplicantException( " firstName is required." ).nullApplicantException();
        }

        int rowsEffected = 0;

        try {
            String query = "update applicant set  first_name  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, firstName );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateLastNameById( Integer id, String lastName ) throws ApplicantException {

        if( id < 0 ) {
            throw new ApplicantException( " Applicant ID is required." ).requiredFields("id");
        }

        if ( lastName == null ) {
            throw new ApplicantException( " lastName is required." ).nullApplicantException();
        }

        int rowsEffected = 0;

        try {
            String query = "update applicant set  last_name  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, lastName );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateEmailById( Integer id, String email ) throws ApplicantException {

        if( id < 0 ) {
            throw new ApplicantException( " Applicant ID is required." ).requiredFields("id");
        }

        if ( email == null ) {
            throw new ApplicantException( " email is required." ).nullApplicantException();
        }

        int rowsEffected = 0;

        try {
            String query = "update applicant set  email  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, email );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updatePhoneById( Integer id, String phone ) throws ApplicantException {

        if( id < 0 ) {
            throw new ApplicantException( " Applicant ID is required." ).requiredFields("id");
        }

        if ( phone == null ) {
            throw new ApplicantException( " phone is required." ).nullApplicantException();
        }

        int rowsEffected = 0;

        try {
            String query = "update applicant set  phone  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, phone );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateSummaryById( Integer id, String summary ) throws ApplicantException {

        if( id < 0 ) {
            throw new ApplicantException( " Applicant ID is required." ).requiredFields("id");
        }

        if ( summary == null ) {
            throw new ApplicantException( " summary is required." ).nullApplicantException();
        }

        int rowsEffected = 0;

        try {
            String query = "update applicant set  summary  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, summary );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws ApplicantException {

        boolean exists = false;
        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, id );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<ApplicantEntity> searchByFirstName( String firstName ) throws ApplicantException {

        final List<ApplicantEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant where first_name LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, firstName );

            results = statement.executeQuery();

            while( results.next() ) {
            ApplicantEntity item = new ApplicantEntity();
                item.setId( results.getInt("id") );
                item.setFirstName( results.getString("first_name") );
                item.setLastName( results.getString("last_name") );
                item.setEmail( results.getString("email") );
                item.setPhone( results.getString("phone") );
                item.setSummary( results.getString("summary") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByFirstName( String firstName ) throws ApplicantException {

        boolean exists = false;
        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant where first_name LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, firstName );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<ApplicantEntity> searchByLastName( String lastName ) throws ApplicantException {

        final List<ApplicantEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant where last_name LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, lastName );

            results = statement.executeQuery();

            while( results.next() ) {
            ApplicantEntity item = new ApplicantEntity();
                item.setId( results.getInt("id") );
                item.setFirstName( results.getString("first_name") );
                item.setLastName( results.getString("last_name") );
                item.setEmail( results.getString("email") );
                item.setPhone( results.getString("phone") );
                item.setSummary( results.getString("summary") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByLastName( String lastName ) throws ApplicantException {

        boolean exists = false;
        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant where last_name LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, lastName );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<ApplicantEntity> searchByEmail( String email ) throws ApplicantException {

        final List<ApplicantEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant where email LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, email );

            results = statement.executeQuery();

            while( results.next() ) {
            ApplicantEntity item = new ApplicantEntity();
                item.setId( results.getInt("id") );
                item.setFirstName( results.getString("first_name") );
                item.setLastName( results.getString("last_name") );
                item.setEmail( results.getString("email") );
                item.setPhone( results.getString("phone") );
                item.setSummary( results.getString("summary") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByEmail( String email ) throws ApplicantException {

        boolean exists = false;
        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant where email LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, email );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<ApplicantEntity> searchByPhone( String phone ) throws ApplicantException {

        final List<ApplicantEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant where phone LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, phone );

            results = statement.executeQuery();

            while( results.next() ) {
            ApplicantEntity item = new ApplicantEntity();
                item.setId( results.getInt("id") );
                item.setFirstName( results.getString("first_name") );
                item.setLastName( results.getString("last_name") );
                item.setEmail( results.getString("email") );
                item.setPhone( results.getString("phone") );
                item.setSummary( results.getString("summary") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByPhone( String phone ) throws ApplicantException {

        boolean exists = false;
        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant where phone LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, phone );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<ApplicantEntity> searchBySummary( String summary ) throws ApplicantException {

        final List<ApplicantEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant where summary LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, summary );

            results = statement.executeQuery();

            while( results.next() ) {
            ApplicantEntity item = new ApplicantEntity();
                item.setId( results.getInt("id") );
                item.setFirstName( results.getString("first_name") );
                item.setLastName( results.getString("last_name") );
                item.setEmail( results.getString("email") );
                item.setPhone( results.getString("phone") );
                item.setSummary( results.getString("summary") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsBySummary( String summary ) throws ApplicantException {

        boolean exists = false;
        try {
            String query = "select id, first_name, last_name, email, phone, summary from applicant where summary LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, summary );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ApplicantException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantException(exception.getMessage());
            }
        }

        return exists;
    }


}
