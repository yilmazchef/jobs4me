package be.intec.repositories;

import be.intec.models.entities.*;
import java.sql.*;
import java.util.*;
import be.intec.services.exceptions.*;

public class ProcessStepRepository {

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
        for ( final ProcessStepEntity entity : entities ) {
            rowsDeleted += deleteById( entity.getId() );
        }
        
        return rowsDeleted;
    }
    
    
    public int resetSequence() {
    
        int rowsEffected = 0;
    
        try {
            String query = "ALTER TABLE process_step AUTO_INCREMENT = 0";
            connection = getConnection();
            statement = connection.prepareStatement( query );
            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if ( statement != null ) {
                    statement.close();
                }
                if ( connection != null ) {
                    connection.close();
                }
            } catch ( Exception exception ) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return rowsEffected;
    
    }
    
    
    public int save( ProcessStepEntity record ) throws ProcessStepException {
    
        int rowsEffected = 0;
    
        try {
            String query = "insert into process_step ( step_id, process_id, status, priority ) values ( ?, ?, ?, ? )";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, record.getStepId());
            statement.setInt(2, record.getProcessId());
            statement.setString(3, record.getStatus());
            statement.setInt(4, record.getPriority());

             rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public ProcessStepEntity findById( Integer id ) throws ProcessStepException {


        if( id < 0 ) {
            throw new ProcessStepException( " ProcessStep ID is required." ).requiredFields("id");
        }

        ProcessStepEntity item = new ProcessStepEntity();

        try {
            String query = "select id, step_id, process_id, status, priority from process_step where id = ?";
            connection = getConnection();

            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            results = statement.executeQuery();
            if(results.next()){
                item.setId( results.getInt("id") );
                item.setStepId( results.getInt("step_id") );
                item.setProcessId( results.getInt("process_id") );
                item.setStatus( results.getString("status") );
                item.setPriority( results.getInt("priority") );
            }
        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return item;
    }

    public List<ProcessStepEntity> findAllByExample( ProcessStepEntity example ) throws ProcessStepException {

        final List<ProcessStepEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, step_id, process_id, status, priority from process_step where step_id = ? OR process_id = ? OR status = ? OR priority = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, example.getStepId() );
            statement.setInt( 2, example.getProcessId() );
            statement.setString( 3, example.getStatus() );
            statement.setInt( 4, example.getPriority() );

            results = statement.executeQuery();
            while(results.next()){
            ProcessStepEntity item = new ProcessStepEntity();
                item.setId( results.getInt("id") );
                item.setStepId( results.getInt("step_id") );
                item.setProcessId( results.getInt("process_id") );
                item.setStatus( results.getString("status") );
                item.setPriority( results.getInt("priority") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return itemList;
    }

    public List<ProcessStepEntity> findAll() throws ProcessStepException {

        final List<ProcessStepEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, step_id, process_id, status, priority from process_step ";
            connection = getConnection();
            statement = connection.prepareStatement(query);

            results = statement.executeQuery();
            while(results.next()){
                ProcessStepEntity item = new ProcessStepEntity();
                item.setId( results.getInt("id") );
                item.setStepId( results.getInt("step_id") );
                item.setProcessId( results.getInt("process_id") );
                item.setStatus( results.getString("status") );
                item.setPriority( results.getInt("priority") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return itemList;
    }

    public int updateById( Integer id, ProcessStepEntity record ) throws ProcessStepException {

        if( id < 0 ) {
            throw new ProcessStepException( " ProcessStep ID is required." ).requiredFields("id");
        }

        if ( record == null ) {
            throw new ProcessStepException( " ProcessStep is required." ).nullProcessStepException();
        }

        int rowsEffected = 0;

        try {
            String query = "update process_step set   step_id  = ?,   process_id  = ?,   status  = ?,   priority  = ? where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, record.getStepId());
            statement.setInt(2, record.getProcessId());
            statement.setString(3, record.getStatus());
            statement.setInt(4, record.getPriority());
            statement.setInt( 5, id );

            rowsEffected = statement.executeUpdate();

        } catch ( SQLException sqlException ) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int deleteById( Integer id ) throws ProcessStepException {


        if( id < 0 ) {
            throw new ProcessStepException( " ProcessStep ID is required." ).requiredFields("id");
        }

        int rowsEffected = 0;

        try {
            String query = "delete from process_step where id = ? ";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            rowsEffected = statement.executeUpdate();
        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return rowsEffected;
    }

    public int updateStepIdById( Integer id, Integer stepId ) throws ProcessStepException {

        if( id < 0 ) {
            throw new ProcessStepException( " ProcessStep ID is required." ).requiredFields("id");
        }

        if ( stepId == null ) {
            throw new ProcessStepException( " stepId is required." ).nullProcessStepException();
        }

        int rowsEffected = 0;

        try {
            String query = "update process_step set  step_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, stepId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateProcessIdById( Integer id, Integer processId ) throws ProcessStepException {

        if( id < 0 ) {
            throw new ProcessStepException( " ProcessStep ID is required." ).requiredFields("id");
        }

        if ( processId == null ) {
            throw new ProcessStepException( " processId is required." ).nullProcessStepException();
        }

        int rowsEffected = 0;

        try {
            String query = "update process_step set  process_id  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, processId );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updateStatusById( Integer id, String status ) throws ProcessStepException {

        if( id < 0 ) {
            throw new ProcessStepException( " ProcessStep ID is required." ).requiredFields("id");
        }

        if ( status == null ) {
            throw new ProcessStepException( " status is required." ).nullProcessStepException();
        }

        int rowsEffected = 0;

        try {
            String query = "update process_step set  status  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, status );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return rowsEffected;
    }


    public int updatePriorityById( Integer id, Integer priority ) throws ProcessStepException {

        if( id < 0 ) {
            throw new ProcessStepException( " ProcessStep ID is required." ).requiredFields("id");
        }

        if ( priority == null ) {
            throw new ProcessStepException( " priority is required." ).nullProcessStepException();
        }

        int rowsEffected = 0;

        try {
            String query = "update process_step set  priority  = ? where id = ?";

            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, priority );
            statement.setInt( 2, id );

            rowsEffected = statement.executeUpdate();

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return rowsEffected;
    }



    public boolean existsById( Integer id ) throws ProcessStepException {

        boolean exists = false;
        try {
            String query = "select id, step_id, process_id, status, priority from process_step where id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, id );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<ProcessStepEntity> searchByStepId( Integer stepId ) throws ProcessStepException {

        final List<ProcessStepEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, step_id, process_id, status, priority from process_step where step_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, stepId );

            results = statement.executeQuery();

            while( results.next() ) {
            ProcessStepEntity item = new ProcessStepEntity();
                item.setId( results.getInt("id") );
                item.setStepId( results.getInt("step_id") );
                item.setProcessId( results.getInt("process_id") );
                item.setStatus( results.getString("status") );
                item.setPriority( results.getInt("priority") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByStepId( Integer stepId ) throws ProcessStepException {

        boolean exists = false;
        try {
            String query = "select id, step_id, process_id, status, priority from process_step where step_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, stepId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<ProcessStepEntity> searchByProcessId( Integer processId ) throws ProcessStepException {

        final List<ProcessStepEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, step_id, process_id, status, priority from process_step where process_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, processId );

            results = statement.executeQuery();

            while( results.next() ) {
            ProcessStepEntity item = new ProcessStepEntity();
                item.setId( results.getInt("id") );
                item.setStepId( results.getInt("step_id") );
                item.setProcessId( results.getInt("process_id") );
                item.setStatus( results.getString("status") );
                item.setPriority( results.getInt("priority") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByProcessId( Integer processId ) throws ProcessStepException {

        boolean exists = false;
        try {
            String query = "select id, step_id, process_id, status, priority from process_step where process_id = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, processId );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<ProcessStepEntity> searchByStatus( String status ) throws ProcessStepException {

        final List<ProcessStepEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, step_id, process_id, status, priority from process_step where status LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, status );

            results = statement.executeQuery();

            while( results.next() ) {
            ProcessStepEntity item = new ProcessStepEntity();
                item.setId( results.getInt("id") );
                item.setStepId( results.getInt("step_id") );
                item.setProcessId( results.getInt("process_id") );
                item.setStatus( results.getString("status") );
                item.setPriority( results.getInt("priority") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByStatus( String status ) throws ProcessStepException {

        boolean exists = false;
        try {
            String query = "select id, step_id, process_id, status, priority from process_step where status LIKE ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString( 1, status );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return exists;
    }

    public List<ProcessStepEntity> searchByPriority( Integer priority ) throws ProcessStepException {

        final List<ProcessStepEntity> itemList = new ArrayList<>();

        try {
            String query = "select id, step_id, process_id, status, priority from process_step where priority = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, priority );

            results = statement.executeQuery();

            while( results.next() ) {
            ProcessStepEntity item = new ProcessStepEntity();
                item.setId( results.getInt("id") );
                item.setStepId( results.getInt("step_id") );
                item.setProcessId( results.getInt("process_id") );
                item.setStatus( results.getString("status") );
                item.setPriority( results.getInt("priority") );

                itemList.add(item);
            }

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return itemList;
    }


    public boolean existsByPriority( Integer priority ) throws ProcessStepException {

        boolean exists = false;
        try {
            String query = "select id, step_id, process_id, status, priority from process_step where priority = ?";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt( 1, priority );

            results = statement.executeQuery();
            exists = results.next();

        } catch (SQLException sqlException) {
                throw new ProcessStepException(sqlException.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception exception) {
                throw new ProcessStepException(exception.getMessage());
            }
        }

        return exists;
    }


}
