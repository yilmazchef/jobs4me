package be.intec.repositories;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;

public class OrganizationRepository {

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
        for ( final OrganizationEntity entity : entities ) {
            rowsDeleted += deleteById( entity.getId() );
        }
        
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        int rowsEffected = 0;
    
        try {
            String query = "ALTER TABLE organization AUTO_INCREMENT = 0";
            connection = getConnection();
            statement = connection.prepareStatement( query );
            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if ( statement != null ) {
                    statement.close();
                }
                if ( connection != null ) {
                    connection.close();
                }
            } catch ( Exception exception ) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return rowsEffected;
    
    }
    
    
    public int save( OrganizationEntity record ) throws OrganizationException {
    
        int rowsEffected = 0;
    
        try {
            String query = "insert into organization ( code, name, description ) values ( ?, ?, ? )";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getCode());
            statement.setString(2, record.getName());
            statement.setString(3, record.getDescription());

             rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public OrganizationEntity findById( Integer id ) throws OrganizationException {


        if( id < 0 ) {
            throw new OrganizationException( " Organization ID is required." ).requiredFields("id");
        }

        OrganizationEntity item = new OrganizationEntity();

        try {
            String query = "select id, code, name, description from organization where id = ?";
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
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return item;
    }

    public List<OrganizationEntity> findAllByExample( OrganizationEntity example ) throws OrganizationException {

        final List<OrganizationEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from organization where code = ? OR name = ? OR description = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, example.getCode() );
            statement.setString( 2, example.getName() );
            statement.setString( 3, example.getDescription() );

            results = statement.executeQuery();
            while(results.next()){
            OrganizationEntity item = new OrganizationEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return itemList;
    }

    public List<OrganizationEntity> findAll() throws OrganizationException {

        final List<OrganizationEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from organization ";
            connection = getConnection();
            statement = connection.prepareStatement(query);

            results = statement.executeQuery();
            while(results.next()){
                OrganizationEntity item = new OrganizationEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return itemList;
    }

    public int updateById( Integer id, OrganizationEntity record ) throws OrganizationException {

        if( id < 0 ) {
            throw new OrganizationException( " Organization ID is required." ).requiredFields("id");
        }

        if ( record == null ) {
            throw new OrganizationException( " Organization is required." ).nullOrganizationException();
        }

        int rowsEffected = 0;

        try {
            String query = "update organization set   code  = ?,   name  = ?,   description  = ? where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, record.getCode());
            statement.setString(2, record.getName());
            statement.setString(3, record.getDescription());
            statement.setInt( 4, id );

            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws OrganizationException {


        if( id < 0 ) {
            throw new OrganizationException( " Organization ID is required." ).requiredFields("id");
        }

        int rowsEffected = 0;

        try {
            String query = "delete from organization where id = ? ";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            rowsEffected = statement.executeUpdate();
        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int updateCodeById( Integer id, String code ) throws OrganizationException {

        if( id < 0 ) {
            throw new OrganizationException( " Organization ID is required." ).requiredFields("id");
        }

        if ( code == null ) {
            throw new OrganizationException( " code is required." ).nullOrganizationException();
        }

        int rowsEffected = 0;

        try {
            String query = "update organization set  code  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, code );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateNameById( Integer id, String name ) throws OrganizationException {

        if( id < 0 ) {
            throw new OrganizationException( " Organization ID is required." ).requiredFields("id");
        }

        if ( name == null ) {
            throw new OrganizationException( " name is required." ).nullOrganizationException();
        }

        int rowsEffected = 0;

        try {
            String query = "update organization set  name  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, name );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateDescriptionById( Integer id, String description ) throws OrganizationException {

        if( id < 0 ) {
            throw new OrganizationException( " Organization ID is required." ).requiredFields("id");
        }

        if ( description == null ) {
            throw new OrganizationException( " description is required." ).nullOrganizationException();
        }

        int rowsEffected = 0;

        try {
            String query = "update organization set  description  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, description );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws OrganizationException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description from organization where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, id );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<OrganizationEntity> searchByCode( String code ) throws OrganizationException {

        final List<OrganizationEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from organization where code LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, code );

            results = statement.executeQuery();

            while( results.next() ) {
            OrganizationEntity item = new OrganizationEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByCode( String code ) throws OrganizationException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description from organization where code LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, code );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<OrganizationEntity> searchByName( String name ) throws OrganizationException {

        final List<OrganizationEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from organization where name LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, name );

            results = statement.executeQuery();

            while( results.next() ) {
            OrganizationEntity item = new OrganizationEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByName( String name ) throws OrganizationException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description from organization where name LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, name );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<OrganizationEntity> searchByDescription( String description ) throws OrganizationException {

        final List<OrganizationEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, code, name, description from organization where description LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, description );

            results = statement.executeQuery();

            while( results.next() ) {
            OrganizationEntity item = new OrganizationEntity();
                item.setId( results.getInt("id") );
                item.setCode( results.getString("code") );
                item.setName( results.getString("name") );
                item.setDescription( results.getString("description") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByDescription( String description ) throws OrganizationException {

        boolean exists = false;
        try {
            String query = "select id, code, name, description from organization where description LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, description );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new OrganizationException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new OrganizationException(exception.getMessage());
            }
        }

        return exists;
    }


}
