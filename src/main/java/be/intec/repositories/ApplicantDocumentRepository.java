package be.intec.repositories;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;

public class ApplicantDocumentRepository {

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
        for ( final ApplicantDocumentEntity entity : entities ) {
            rowsDeleted += deleteById( entity.getId() );
        }
        
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        int rowsEffected = 0;
    
        try {
            String query = "ALTER TABLE applicant_document AUTO_INCREMENT = 0";
            connection = getConnection();
            statement = connection.prepareStatement( query );
            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if ( statement != null ) {
                    statement.close();
                }
                if ( connection != null ) {
                    connection.close();
                }
            } catch ( Exception exception ) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return rowsEffected;
    
    }
    
    
    public int save( ApplicantDocumentEntity record ) throws ApplicantDocumentException {
    
        int rowsEffected = 0;
    
        try {
            String query = "insert into applicant_document ( document_id, applicant_id ) values ( ?, ? )";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, record.getDocumentId());
            statement.setInt(2, record.getApplicantId());

             rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public ApplicantDocumentEntity findById( Integer id ) throws ApplicantDocumentException {


        if( id < 0 ) {
            throw new ApplicantDocumentException( " ApplicantDocument ID is required." ).requiredFields("id");
        }

        ApplicantDocumentEntity item = new ApplicantDocumentEntity();

        try {
            String query = "select id, document_id, applicant_id from applicant_document where id = ?";
            connection = getConnection();

            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            results = statement.executeQuery();
            if(results.next()){
                item.setId( results.getInt("id") );
                item.setDocumentId( results.getInt("document_id") );
                item.setApplicantId( results.getInt("applicant_id") );
            }
        } catch (SQLException sqlException) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return item;
    }

    public List<ApplicantDocumentEntity> findAllByExample( ApplicantDocumentEntity example ) throws ApplicantDocumentException {

        final List<ApplicantDocumentEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, document_id, applicant_id from applicant_document where document_id = ? OR applicant_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, example.getDocumentId() );
            statement.setInt( 2, example.getApplicantId() );

            results = statement.executeQuery();
            while(results.next()){
            ApplicantDocumentEntity item = new ApplicantDocumentEntity();
                item.setId( results.getInt("id") );
                item.setDocumentId( results.getInt("document_id") );
                item.setApplicantId( results.getInt("applicant_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return itemList;
    }

    public List<ApplicantDocumentEntity> findAll() throws ApplicantDocumentException {

        final List<ApplicantDocumentEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, document_id, applicant_id from applicant_document ";
            connection = getConnection();
            statement = connection.prepareStatement(query);

            results = statement.executeQuery();
            while(results.next()){
                ApplicantDocumentEntity item = new ApplicantDocumentEntity();
                item.setId( results.getInt("id") );
                item.setDocumentId( results.getInt("document_id") );
                item.setApplicantId( results.getInt("applicant_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return itemList;
    }

    public int updateById( Integer id, ApplicantDocumentEntity record ) throws ApplicantDocumentException {

        if( id < 0 ) {
            throw new ApplicantDocumentException( " ApplicantDocument ID is required." ).requiredFields("id");
        }

        if ( record == null ) {
            throw new ApplicantDocumentException( " ApplicantDocument is required." ).nullApplicantDocumentException();
        }

        int rowsEffected = 0;

        try {
            String query = "update applicant_document set   document_id  = ?,   applicant_id  = ? where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, record.getDocumentId());
            statement.setInt(2, record.getApplicantId());
            statement.setInt( 3, id );

            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws ApplicantDocumentException {


        if( id < 0 ) {
            throw new ApplicantDocumentException( " ApplicantDocument ID is required." ).requiredFields("id");
        }

        int rowsEffected = 0;

        try {
            String query = "delete from applicant_document where id = ? ";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            rowsEffected = statement.executeUpdate();
        } catch (SQLException sqlException) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int updateDocumentIdById( Integer id, Integer documentId ) throws ApplicantDocumentException {

        if( id < 0 ) {
            throw new ApplicantDocumentException( " ApplicantDocument ID is required." ).requiredFields("id");
        }

        if ( documentId == null ) {
            throw new ApplicantDocumentException( " documentId is required." ).nullApplicantDocumentException();
        }

        int rowsEffected = 0;

        try {
            String query = "update applicant_document set  document_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, documentId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateApplicantIdById( Integer id, Integer applicantId ) throws ApplicantDocumentException {

        if( id < 0 ) {
            throw new ApplicantDocumentException( " ApplicantDocument ID is required." ).requiredFields("id");
        }

        if ( applicantId == null ) {
            throw new ApplicantDocumentException( " applicantId is required." ).nullApplicantDocumentException();
        }

        int rowsEffected = 0;

        try {
            String query = "update applicant_document set  applicant_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, applicantId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws ApplicantDocumentException {

        boolean exists = false;
        try {
            String query = "select id, document_id, applicant_id from applicant_document where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, id );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<ApplicantDocumentEntity> searchByDocumentId( Integer documentId ) throws ApplicantDocumentException {

        final List<ApplicantDocumentEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, document_id, applicant_id from applicant_document where document_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, documentId );

            results = statement.executeQuery();

            while( results.next() ) {
            ApplicantDocumentEntity item = new ApplicantDocumentEntity();
                item.setId( results.getInt("id") );
                item.setDocumentId( results.getInt("document_id") );
                item.setApplicantId( results.getInt("applicant_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByDocumentId( Integer documentId ) throws ApplicantDocumentException {

        boolean exists = false;
        try {
            String query = "select id, document_id, applicant_id from applicant_document where document_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, documentId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<ApplicantDocumentEntity> searchByApplicantId( Integer applicantId ) throws ApplicantDocumentException {

        final List<ApplicantDocumentEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, document_id, applicant_id from applicant_document where applicant_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, applicantId );

            results = statement.executeQuery();

            while( results.next() ) {
            ApplicantDocumentEntity item = new ApplicantDocumentEntity();
                item.setId( results.getInt("id") );
                item.setDocumentId( results.getInt("document_id") );
                item.setApplicantId( results.getInt("applicant_id") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByApplicantId( Integer applicantId ) throws ApplicantDocumentException {

        boolean exists = false;
        try {
            String query = "select id, document_id, applicant_id from applicant_document where applicant_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, applicantId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ApplicantDocumentException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ApplicantDocumentException(exception.getMessage());
            }
        }

        return exists;
    }


}
