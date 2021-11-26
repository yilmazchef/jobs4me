package be.intec.repositories;


import be.intec.models.entities.ApplicationTestEntity;
import be.intec.services.exceptions.ApplicationTestException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationTestRepository {

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
		for ( final ApplicationTestEntity entity : entities ) {
			rowsDeleted += deleteById( entity.getId() );
		}

		return rowsDeleted;
	}


	public int resetSequence() {

		int rowsEffected = 0;

		try {
			String query = "ALTER TABLE application_test AUTO_INCREMENT = 0";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return rowsEffected;

	}


	public int save( ApplicationTestEntity record ) throws ApplicationTestException {

		int rowsEffected = 0;

		try {
			String query = "insert into application_test ( test_id, application_id, start_time, end_time ) values ( ?, ?, ?, ? )";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, record.getTestId() );
			statement.setInt( 2, record.getApplicationId() );
			statement.setTimestamp( 3, record.getStartTime() );
			statement.setTimestamp( 4, record.getEndTime() );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public ApplicationTestEntity findById( Integer id ) throws ApplicationTestException {


		if ( id < 0 ) {
			throw new ApplicationTestException( " ApplicationTest ID is required." ).requiredFields( "id" );
		}

		ApplicationTestEntity item = new ApplicationTestEntity();

		try {
			String query = "select id, test_id, application_id, start_time, end_time from application_test where id = ?";
			connection = getConnection();

			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			if ( results.next() ) {
				item.setId( results.getInt( "id" ) );
				item.setTestId( results.getInt( "test_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setStartTime( results.getTimestamp( "start_time" ) );
				item.setEndTime( results.getTimestamp( "end_time" ) );
			}
		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return item;
	}


	public List< ApplicationTestEntity > findAllByExample( ApplicationTestEntity example ) throws ApplicationTestException {

		final List< ApplicationTestEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, test_id, application_id, start_time, end_time from application_test where test_id = ? OR application_id = ? OR start_time = ? OR end_time = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, example.getTestId() );
			statement.setInt( 2, example.getApplicationId() );
			statement.setTimestamp( 3, example.getStartTime() );
			statement.setTimestamp( 4, example.getEndTime() );

			results = statement.executeQuery();
			while ( results.next() ) {
				ApplicationTestEntity item = new ApplicationTestEntity();
				item.setId( results.getInt( "id" ) );
				item.setTestId( results.getInt( "test_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setStartTime( results.getTimestamp( "start_time" ) );
				item.setEndTime( results.getTimestamp( "end_time" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public List< ApplicationTestEntity > findAll() throws ApplicationTestException {

		final List< ApplicationTestEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, test_id, application_id, start_time, end_time from application_test ";
			connection = getConnection();
			statement = connection.prepareStatement( query );

			results = statement.executeQuery();
			while ( results.next() ) {
				ApplicationTestEntity item = new ApplicationTestEntity();
				item.setId( results.getInt( "id" ) );
				item.setTestId( results.getInt( "test_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setStartTime( results.getTimestamp( "start_time" ) );
				item.setEndTime( results.getTimestamp( "end_time" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public int updateById( Integer id, ApplicationTestEntity record ) throws ApplicationTestException {

		if ( id < 0 ) {
			throw new ApplicationTestException( " ApplicationTest ID is required." ).requiredFields( "id" );
		}

		if ( record == null ) {
			throw new ApplicationTestException( " ApplicationTest is required." ).nullApplicationTestException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_test set   test_id  = ?,   application_id  = ?,   start_time  = ?,   end_time  = ? where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, record.getTestId() );
			statement.setInt( 2, record.getApplicationId() );
			statement.setTimestamp( 3, record.getStartTime() );
			statement.setTimestamp( 4, record.getEndTime() );
			statement.setInt( 5, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int deleteById( Integer id ) throws ApplicationTestException {


		if ( id < 0 ) {
			throw new ApplicationTestException( " ApplicationTest ID is required." ).requiredFields( "id" );
		}

		int rowsEffected = 0;

		try {
			String query = "delete from application_test where id = ? ";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			rowsEffected = statement.executeUpdate();
		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateTestIdById( Integer id, Integer testId ) throws ApplicationTestException {

		if ( id < 0 ) {
			throw new ApplicationTestException( " ApplicationTest ID is required." ).requiredFields( "id" );
		}

		if ( testId == null ) {
			throw new ApplicationTestException( " testId is required." ).nullApplicationTestException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_test set  test_id  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, testId );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateApplicationIdById( Integer id, Integer applicationId ) throws ApplicationTestException {

		if ( id < 0 ) {
			throw new ApplicationTestException( " ApplicationTest ID is required." ).requiredFields( "id" );
		}

		if ( applicationId == null ) {
			throw new ApplicationTestException( " applicationId is required." ).nullApplicationTestException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_test set  application_id  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicationId );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateStartTimeById( Integer id, java.sql.Timestamp startTime ) throws ApplicationTestException {

		if ( id < 0 ) {
			throw new ApplicationTestException( " ApplicationTest ID is required." ).requiredFields( "id" );
		}

		if ( startTime == null ) {
			throw new ApplicationTestException( " startTime is required." ).nullApplicationTestException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_test set  start_time  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, startTime );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateEndTimeById( Integer id, java.sql.Timestamp endTime ) throws ApplicationTestException {

		if ( id < 0 ) {
			throw new ApplicationTestException( " ApplicationTest ID is required." ).requiredFields( "id" );
		}

		if ( endTime == null ) {
			throw new ApplicationTestException( " endTime is required." ).nullApplicationTestException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_test set  end_time  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, endTime );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public boolean existsById( Integer id ) throws ApplicationTestException {

		boolean exists = false;
		try {
			String query = "select id, test_id, application_id, start_time, end_time from application_test where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationTestEntity > searchByTestId( Integer testId ) throws ApplicationTestException {

		final List< ApplicationTestEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, test_id, application_id, start_time, end_time from application_test where test_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, testId );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationTestEntity item = new ApplicationTestEntity();
				item.setId( results.getInt( "id" ) );
				item.setTestId( results.getInt( "test_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setStartTime( results.getTimestamp( "start_time" ) );
				item.setEndTime( results.getTimestamp( "end_time" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByTestId( Integer testId ) throws ApplicationTestException {

		boolean exists = false;
		try {
			String query = "select id, test_id, application_id, start_time, end_time from application_test where test_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, testId );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationTestEntity > searchByApplicationId( Integer applicationId ) throws ApplicationTestException {

		final List< ApplicationTestEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, test_id, application_id, start_time, end_time from application_test where application_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicationId );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationTestEntity item = new ApplicationTestEntity();
				item.setId( results.getInt( "id" ) );
				item.setTestId( results.getInt( "test_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setStartTime( results.getTimestamp( "start_time" ) );
				item.setEndTime( results.getTimestamp( "end_time" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByApplicationId( Integer applicationId ) throws ApplicationTestException {

		boolean exists = false;
		try {
			String query = "select id, test_id, application_id, start_time, end_time from application_test where application_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicationId );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationTestEntity > searchByStartTime( java.sql.Timestamp startTime ) throws ApplicationTestException {

		final List< ApplicationTestEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, test_id, application_id, start_time, end_time from application_test where start_time = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, startTime );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationTestEntity item = new ApplicationTestEntity();
				item.setId( results.getInt( "id" ) );
				item.setTestId( results.getInt( "test_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setStartTime( results.getTimestamp( "start_time" ) );
				item.setEndTime( results.getTimestamp( "end_time" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByStartTime( java.sql.Timestamp startTime ) throws ApplicationTestException {

		boolean exists = false;
		try {
			String query = "select id, test_id, application_id, start_time, end_time from application_test where start_time = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, startTime );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationTestEntity > searchByEndTime( java.sql.Timestamp endTime ) throws ApplicationTestException {

		final List< ApplicationTestEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, test_id, application_id, start_time, end_time from application_test where end_time = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, endTime );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationTestEntity item = new ApplicationTestEntity();
				item.setId( results.getInt( "id" ) );
				item.setTestId( results.getInt( "test_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setStartTime( results.getTimestamp( "start_time" ) );
				item.setEndTime( results.getTimestamp( "end_time" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByEndTime( java.sql.Timestamp endTime ) throws ApplicationTestException {

		boolean exists = false;
		try {
			String query = "select id, test_id, application_id, start_time, end_time from application_test where end_time = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, endTime );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationTestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationTestException( exception.getMessage() );
			}
		}

		return exists;
	}


}
